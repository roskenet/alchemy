package de.felixroske.learnkotlin01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean

fun main() {
//    val logger = LoggerFactory.getLogger("logger")

    val keepRunning = AtomicBoolean(true)
//      var keepRunning = true

    GlobalScope.launch {
        for(i in 1..10) {
            delay(500)
            println("Doing something: ${i}")
        }
//        keepRunning = false
        keepRunning.set(false)
//        logger.info("World!")
    }

    while (keepRunning.get()) {
        Thread.sleep(1000L)
        println("Running")
    }
    println("Ende")
}
