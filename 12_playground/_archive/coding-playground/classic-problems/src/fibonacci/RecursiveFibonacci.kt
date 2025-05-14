package fibonacci

fun main() {
    val theFun = ::fibonacciImperative

    for (n in 0L..10L) {
        println("fibonacci(${n}) is ${fibCalc(n, theFun)}")
    }

//    val fibWithNoOp = fibCalc(2L) {
//        it
//    }

}

fun fibonacciRecursive(n: Long) : Long {
    when(n) {
        0L -> return 0L
        in 1L..2L -> return 1L
        else -> return fibonacciRecursive(n-1)+fibonacciRecursive(n-2)
    }
}

fun fibonacciImperative(n: Long) : Long {

    when(n) {
        0L -> return 0
        1L -> return 1
    }

    var x = 2L
    var nm2 = 0L
    var nm1 = 1L
    var nx = 0L;

    while(x <= n) {
        nx = nm2 + nm1
        nm2 = nm1
        nm1 = nx
        x++
    }
    return nx
}

fun fibCalc(n: Long, fc: (Long) -> Long): Long {
    return fc.invoke(n)
}