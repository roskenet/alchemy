package de.felixroske.listofallrationals

fun allRationals(): Iterator<Pair<Int, Int>> = iterator {
    var nom = 1
    var denom = 1

    while (true) {
        yield(Pair(nom++, denom++))
    }
}