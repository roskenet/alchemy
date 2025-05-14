package de.roskenet.demo_client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.web.SecurityFilterChain
import java.net.http.HttpClient

@Configuration
class SecurityConfig {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { webSecurity ->
            webSecurity.ignoring().requestMatchers("/**")
        }
    }

//    @Autowired
//    @RegisteredOAuth2AuthorizedClient
//    lateinit var client: OAuth2AuthorizedClient

//    @Bean
//    fun hydrogenClient(): OAuth2AuthorizedClient? {
//
//        return OAuth2AuthorizedClientResolver.withDefaults()
//            .authenticateClient(client, null)kk
//
//
//        return clientProvider.
//        return null
//    }
//
    @Bean
    fun authorizedClientManager(
    clientRegistrationRepository: ClientRegistrationRepository,
    authorizedClientService: OAuth2AuthorizedClientService): OAuth2AuthorizedClientManager {
    val authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
            .clientCredentials()
            .build()
    val authorizedClientManager = AuthorizedClientServiceOAuth2AuthorizedClientManager(
            clientRegistrationRepository, authorizedClientService)
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)
    return authorizedClientManager
}
}