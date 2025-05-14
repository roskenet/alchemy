package de.zalando.sb3nakadidemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.zalando.nakadiproducer.eventlog.EventLogWriter
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@SpringBootApplication
class Sb3NakadiDemoApplication : CommandLineRunner {

    @Autowired
    lateinit var eventLogWriter: EventLogWriter

    override fun run(vararg args: String?) {
        println("Hello World!")

        var theEvent = HashMap<String, Any>()
        theEvent.put("someText", "Hallo Welt!")
        theEvent.put("someInteger", 42)

        eventLogWriter.fireBusinessEvent("order.ORDER_RECEIVED", theEvent);
    }
}

fun main(args: Array<String>) {
    runApplication<Sb3NakadiDemoApplication>(*args)
}
