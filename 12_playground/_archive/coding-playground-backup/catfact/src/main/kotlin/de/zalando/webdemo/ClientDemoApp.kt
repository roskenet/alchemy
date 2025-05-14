package de.zalando.webdemo

import org.springframework.boot.CommandLineRunner
import kotlin.system.exitProcess

class ClientDemoApp(val client: CatFactClient): CommandLineRunner {
    override fun run(vararg args: String?) {
        println(client.getAFact())
        exitProcess(0)
    }
}