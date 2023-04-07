package io.spring.shinyay.learningspringboot3.ch5.security

import io.spring.shinyay.learningspringboot3.ch5.security.entity.UserAccount
import io.spring.shinyay.learningspringboot3.ch5.security.repository.UserManagementRepository
import io.spring.shinyay.learningspringboot3.ch5.security.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig {

    @Bean
    fun initUsers(repository: UserManagementRepository): CommandLineRunner? {
        return CommandLineRunner {
            repository.save(UserAccount("alice", "password", "ROLE_USER"))
            repository.save(UserAccount("bob", "password", "ROLE_USER"))
            repository.save(UserAccount("admin", "password", "ROLE_ADMIN"))
        }
    }

    @Bean
    fun userDetailsService(repository: UserRepository): UserDetailsService {
        return UserDetailsService {
            repository.findByUsername(it).asUser()
        }
    }

    @Bean
    fun configureSecurity(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("/login").permitAll()
            .requestMatchers("/", "/search").authenticated()
            .requestMatchers(HttpMethod.GET, "/api/**").authenticated()
            .requestMatchers(HttpMethod.POST, "/new-video", "/delete/**").authenticated()
            .anyRequest().denyAll()
            .and()
            .formLogin()
            .and()
            .httpBasic()
        return http.build()
    }

}
