package de.zalando.sb3nakadidemo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.nakadiproducer.AccessTokenProvider
import org.zalando.spring.oauth2.client.core.AccessToken
import org.zalando.spring.oauth2.client.core.KubernetesTokenValueReader

@Configuration
class DemoConfig {

    @Value("\${CREDENTIALS_DIR}")
    lateinit var credentialsDir: String

    @Bean(name=["nakadiToken"])
    fun nakadiToken(): AccessToken {
        return AccessToken("nakadi", KubernetesTokenValueReader(credentialsDir))
    }

    @Bean
    fun accessTokenProvider(accessToken: AccessToken): AccessTokenProvider {
        return AccessTokenProvider { accessToken.accessToken }
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JavaTimeModule())
        return objectMapper
    }

}