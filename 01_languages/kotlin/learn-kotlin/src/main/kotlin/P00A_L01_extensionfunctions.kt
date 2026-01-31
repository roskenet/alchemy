package de.roskenet

import java.util.UUID

@JvmInline
value class ArtistId(val id: String)

fun ArtistId.genId(): UUID {
    return UUID.randomUUID()
}
//j
//package de.roskenet
//
////fun Boolean:not(): String = when {
////    this -> println("not false")
////    else -> println("not true")
////}
//
//fun Boolean.tellMe(): String = when {
//    this -> ""
//    else -> "not"
//}
//
//fun main() {
//    val x = 42
//    println("$x is ${isNonsense(x).tellMe()} nonsense")
//}
//
//fun isNonsense(zahl: Int): Boolean =
//    when (zahl) {
//        42 -> true
//        else -> false
//    }
