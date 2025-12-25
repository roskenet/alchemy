package org.example

// kata_001: 100001st prime number:
fun main() {
    println("Calculating the 10001 Prime Number")
    var numsFound: UInt = 6u;

    var counter: ULong = 13UL;

    while(numsFound < 10001u) {
        if (isPrime(++counter)) {
            ++numsFound
        }
    }

    println("The 10001st Prime Number is: ${counter}")
}
// A very naive and easy implementation that runs fast enough on my machine!
fun isPrime(number: ULong): Boolean {
    for (x: ULong in 2UL..number/2UL ) {
        if(number % x == 0UL)
            return false;
    }
    return true;
}