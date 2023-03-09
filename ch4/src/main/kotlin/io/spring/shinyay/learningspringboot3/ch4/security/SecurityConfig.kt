package io.spring.shinyay.learningspringboot3.ch4.security

import io.spring.shinyay.learningspringboot3.ch4.security.entity.UserAccount
import io.spring.shinyay.learningspringboot3.ch4.security.repository.UserManagementRepository
import io.spring.shinyay.learningspringboot3.ch4.security.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
            repository.save(UserAccount("user", "password", "ROLE_USER"))
            repository.save(UserAccount("admin", "password", "ROLE_ADMIN"))
        }
    }

    @Bean
    fun userDetailsService(repository: UserRepository): UserDetailsService {
        return UserDetailsService {
            repository.findByUsername(it).asUser()
        }
    }

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val userDetailsManager: UserDetailsManager = InMemoryUserDetailsManager()
//        userDetailsManager.createUser(
//            User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build()
//        )
//        userDetailsManager.createUser(
//            User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN")
//                .build()
//        )
//        return userDetailsManager
//    }

    @Bean
    fun configureSecurity(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("/login").permitAll()
            .requestMatchers("/", "/search").authenticated()
            
            .and()
            .httpBasic()
        return http.build()
    }

}
