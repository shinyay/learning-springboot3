package io.spring.shinyay.learningspringboot3.ch4.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository


@Configuration
class SecurityConfig {
    @Bean
    fun clientManager(
        clientRegRepo: ClientRegistrationRepository?,
        authClientRepo: OAuth2AuthorizedClientRepository?
    ): OAuth2AuthorizedClientManager {
        val clientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
            .authorizationCode()
            .refreshToken()
            .clientCredentials()
            .password()
            .build()
        val clientManager = DefaultOAuth2AuthorizedClientManager(
            clientRegRepo, authClientRepo
        )
        clientManager
            .setAuthorizedClientProvider(clientProvider)
        return clientManager
    }
}
