package de.felixroske.sumofoddnumbers

fun rowSumOddNumbers(n: Int): Int {
    val startBy = (n - 1) * n + 1
    var sum = 0

    for (x in 0..n - 1) sum += (startBy + x * 2)

    return sum
}
