package de.zalando.webdemo

//import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
//import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource

@SpringBootTest
class WebDemoApplicationConfigTests {
//    companion object {
//        @JvmStatic
//        @RegisterExtension
//        val wiremockServer: WireMockExtension =
//            WireMockExtension.newInstance().build()
//
//        @JvmStatic
//        @DynamicPropertySource
//        fun configureProperties(registry: DynamicPropertyRegistry) {
//            registry.add("riptide_clients_example_base-url") {
//                wiremockServer.baseUrl()
//            }
//        }
//    }

    @Test
    fun contextLoads() {
    }
}
