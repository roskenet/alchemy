package de.zalando.webdemo

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.zalando.riptide.Http

@SpringBootApplication
class ClientDemoAppConfig {
    @Bean
    fun webClient(@Qualifier("example") example: Http): CatFactClient {
        return CatFactClient(example)
    }

    @Bean
    fun webDemoApp(client: CatFactClient): ClientDemoApp {
        return ClientDemoApp(client)
    }
}