package solution

import kotlin.test.Test
import kotlin.test.assertEquals

//A bookseller has lots of books classified in 26 categories labeled A, B, C, ..., Z.
// Each book has a code of at least 3 characters.
// The 1st character of a code is a capital letter which defines the book category.
//
//In the bookseller's stocklist each code is followed by a space and by a positive integer,
// which indicates the quantity of books of this code in stock.
//Task
//
//You will receive the bookseller's stocklist and a list of categories.
// Your task is to find the total number of books in the bookseller's stocklist,
// with the category codes in the list of categories.
// Note: the codes are in the same order in both lists.
//
//Return the result as a string described in the example below,
// or as a list of pairs (Haskell/Clojure/Racket/Prolog).
//
//If any of the input lists is empty, return an empty string, or an empty array/list (Clojure/Racket/Prolog).
//Example
//
//# the bookseller's stocklist:
//"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"
//
//# list of categories:
//"A", "B", "C", "W"
//
//# result:
//"(A : 20) - (B : 114) - (C : 50) - (W : 0)"
//
//Explanation:
//
//category A: 20 books (ABART)
//category B: 114 books = 25 (BKWRK) + 89 (BTSQZ)
//category C: 50 books (CDXEF)
//category W: 0 books

object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        if (lstOfArt.isEmpty() || lstOfCat.isEmpty()) {
            return ""
        }

        var result = listOf<String>()
        for (cat in lstOfCat) {
            val sum = lstOfArt.filter { it[0] == cat[0] }
                .map { it.split(" ")[1].toInt() }
                .sumOf { it -> it }
            result += "(${cat[0]} : $sum)"
        }
        return result.joinToString(" - ")
    }
}

//fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
//    if (lstOfArt.isEmpty()) return ""
//    val counts = lstOfArt.groupingBy { it.take(1) }.fold(0) { acc, s -> acc + s.split(" ")[1].toInt() }
//    return lstOfCat.joinToString(" - ") { "($it : ${counts.getOrDefault(it, 0)})" }
//}

class StockListTest {

    private fun testing(lstOfArt: Array<String>, lstOfCat: Array<String>, expect: String) {
        val actual: String = StockList.stockSummary(lstOfArt, lstOfCat)
        assertEquals(expect, actual)
    }

    @Test
    fun basicTests() {
        var b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
        var c = arrayOf("A", "B", "C", "D")
        var res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"
        testing(b, c, res)

        b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
        c = arrayOf("A", "B")
        res = "(A : 200) - (B : 1140)"
        testing(b, c, res)

    }
}