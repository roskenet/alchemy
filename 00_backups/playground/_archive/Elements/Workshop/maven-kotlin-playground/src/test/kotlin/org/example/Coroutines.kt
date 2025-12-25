package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch(block = {
        delay(500)
//        log.debug("World!")
        println("World!")
    })
//    log.debug("Hello,")
    println("Hello, ")
    Thread.sleep(1000L)
}