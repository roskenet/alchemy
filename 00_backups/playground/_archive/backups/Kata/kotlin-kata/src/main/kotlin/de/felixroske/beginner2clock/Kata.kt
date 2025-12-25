package de.felixroske.beginner2clock

fun past(h: Int, m: Int, s: Int): Int =
    (h * 60 * 60 + m * 60 + s) * 1000
