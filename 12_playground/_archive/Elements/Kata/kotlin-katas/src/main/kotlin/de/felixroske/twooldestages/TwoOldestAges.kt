package de.felixroske.twooldestages

fun twoOldestAges(ages: List<Int>): List<Int> {
    val sortedDescending = ages.sortedDescending()
    return listOf(sortedDescending[1], sortedDescending[0])
}

//fun twoOldestAges(ages: List<Int>) = ages.sorted().takeLast(2)