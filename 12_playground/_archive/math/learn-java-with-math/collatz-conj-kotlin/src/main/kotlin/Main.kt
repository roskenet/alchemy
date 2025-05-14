// Collatz Conjecture
//
// Will return 1 eventually.
// Still not solved yet.

fun main(args: Array<String>) {
    val start = 1540

    println("Checking Collatz Conjecture for $start")
    println("It took ${collatzConjecture(start)} steps.");
}

fun collatzConjecture(num: Int, calls: Int=0): Int {
    if (num == 1)
        return calls

    if (num % 2 == 0)
        return collatzConjecture(doWhenEven(num), calls+1)
    else
        return collatzConjecture(doWhenOdd(num), calls+1)
}

fun doWhenOdd(num: Int) = num*3+1

fun doWhenEven(num: Int) = num/2
