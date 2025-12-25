package de.felixroske.ctxdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CtxDemoApplication: CommandLineRunner {

    @Autowired
    lateinit var myService: MyService

    override fun run(vararg args: String?) {
        myService.doSomething()
    }
}

fun main(args: Array<String>) {
    runApplication<CtxDemoApplication>(*args)
}
