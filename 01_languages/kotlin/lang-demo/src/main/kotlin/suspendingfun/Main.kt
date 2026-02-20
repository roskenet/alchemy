package suspendingfun

import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

suspend fun a() {
    val abc = "ABC"
    suspendCancellableCoroutine<Unit> { cont ->
        cont.resume(Unit)
    }
    println("A")
}

fun doSomething(cont: Continuation<Unit>) {
    val abc = "ABC"
    val x = 42
    println("in doSomething with $abc and $x")
    cont.resume(Unit)
}

suspend fun main() {
    val someText = "World"
    val otherText = "Kotlin"

    println("Hello, $someText!")
    delay(5000)
    a()

    println(otherText)
}