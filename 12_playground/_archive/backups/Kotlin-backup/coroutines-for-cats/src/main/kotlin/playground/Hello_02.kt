package playground

import kotlinx.coroutines.*

fun doSomethingMore() {
    println("This is doSoethingMore")
}

fun workload(n: Int): Int {
//    delay(500)
    doSomethingMore()
    return n
}

fun main(args: Array<String>) {

    println("Start")

// Start a coroutine
    GlobalScope.launch {

        var myInt = async {
            workload(1234)
            println("Finished Workload")
        }

        delay(1000)
        println("Hello")
    }

    Thread.sleep(2000) // wait for 2 seconds
    println("Stop")
}