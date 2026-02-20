package coroutines;

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("This is easy!")
    }

//    CoroutineScope.launch {
//        delay(1000L)
//        println("This is easy!")
//    }

    Thread.sleep(2000L) // We will see: World!
    println("Hello, World!")
}