package playground

import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun doSomething() {
    log("This is from doSomething")
}

fun main(args: Array<String>) {

    log("Hello, World")

    GlobalScope.launch {
            log("This is the global scope")
            doSomething()
        }

    Thread.sleep(1000)
}

