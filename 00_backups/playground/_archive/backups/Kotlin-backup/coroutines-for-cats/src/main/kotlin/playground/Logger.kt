package playground

val startTime = System.currentTimeMillis()

fun log(msg: String) = println("[${Thread.currentThread().name}] [${System.currentTimeMillis() - startTime}] $msg")