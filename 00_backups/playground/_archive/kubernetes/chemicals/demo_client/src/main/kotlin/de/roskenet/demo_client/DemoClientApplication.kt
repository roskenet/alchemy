package de.roskenet.demo_client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoClientApplication

fun main(args: Array<String>) {
    runApplication<DemoClientApplication>(*args)
}

@RestController
//@EnableMethodSecurity(prePostEnabled = true)
class DemoClientController {

    @Autowired
    lateinit var clientService: OAuth2AuthorizedClientService
//    lateinit var clientRepo: ClientRegistrationRepository
//    lateinit var applicationContext: ApplicationContext
//    lateinit var oAuth2AuthorizationContext: OAuth2AuthorizationContext

    @GetMapping("/show")
    fun showFortyTwo(): Map<String, String> {

        val client: OAuth2AuthorizedClient =
            clientService.loadAuthorizedClient("hydrogen", "hydrogen")
//        val client = clientRepo.findByRegistrationId("hydrogen")

//        val client: OAuth2AuthorizedClient = authorizedClientService
//            .loadAuthorizedClient("hydrogen", "hydrogen")

//        val restTemplate = hydrogen.build()
//        var restTemplate = RestTemplateBuilder().build()
//
//        val forObject = client.getForEntity<String>("http://localhost:9191/myresource", String.javaClass)
//            client.

        return mapOf(Pair("item", "test"))
    }
}