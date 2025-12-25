package org.example

fun main() {
    println("Q to R")
    print("Bitte gib den Zähler an: ")
    val nomin = readln()
    print("Bitte gib den Nenner an: ")
    val denomin = readln()

    println("Q ist: ${convQtoR(nomin, denomin)}")

}

fun convQtoR(nomin: String, denomin: String): String {
    val nominator = nomin.toLong()
    val denominator = denomin.toLong()

    var n = nominator / denominator
    var mod = nominator % denominator
    var lastMod = mod
    val qStr = StringBuilder()
    qStr.append(n.toString()).append(',')

    while (mod != 0L) {
        n = denominator / mod
        mod = denominator % mod
        qStr.append(n.toString()).append(',')
        if (mod == lastMod) {
            break
        }
        lastMod = mod
    }


    return qStr.toString()
}