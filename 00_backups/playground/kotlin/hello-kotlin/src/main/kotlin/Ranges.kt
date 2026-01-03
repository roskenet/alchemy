package de.felixroske

fun main() {
    executeSomething(::rangePlayground)
}

fun rangePlayground() {
    for(i in 100 downTo 1 step 2) {
        println(i)
    }
}

typealias MyFunc = () -> Unit

fun executeSomething(myFunc: MyFunc) {
    myFunc()
}
