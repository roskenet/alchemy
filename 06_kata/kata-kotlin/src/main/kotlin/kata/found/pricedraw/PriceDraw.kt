package kata.found.pricedraw

import kotlin.test.Test
import kotlin.test.assertEquals

fun nameValue(name: String): Int {
    return name.fold(name.length) { acc, ch -> acc + ch.lowercaseChar().code - 'a'.code + 1 }
}

fun nthRank(st: String, we: IntArray, n: Int): String {
    if (st.isEmpty()) return "No participants"
    val names = st.split(',')
    if (n > names.size) return "Not enough participants"

    val participants = names.mapIndexed { index, name ->
        val som = nameValue(name) * we[index]
        name to som
    }

    val sortedParticipants = participants.sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })

    return sortedParticipants[n - 1].first
}

class RankTest {

    private fun dotest( expect: String, st: String, we: IntArray, n: Int) {
        val actual = nthRank(st, we, n)
        assertEquals(expect, actual)
    }

    @Test
    fun `Fixed tests`() {
        // no participant
//        var st = ""
//        var we = intArrayOf(4, 2, 1, 4, 3, 1, 2)
//        dotest("No participants", st, we, 4)
        // n = 8 is greater than the number of participants
//        var st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin"
//        var we = intArrayOf(4, 2, 1, 4, 3, 1, 2)
//        dotest("Not enough participants", st, we, 8)
        //
//        var st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin"
//        var we = intArrayOf(4, 2, 1, 4, 3, 1, 2)
//        dotest("Benjamin", st, we, 4)

        var st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden"
        var we = intArrayOf(1, 3, 5, 5, 3, 6, 1)
        dotest("Matthew", st, we, 2)

    }
}