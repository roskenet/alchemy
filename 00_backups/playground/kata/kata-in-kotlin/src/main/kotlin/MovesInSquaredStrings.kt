package squaredstrings

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/56dbe0e313c2f63be4000b25/train/kotlin

object Opstrings {

    fun splitMe(strng: String): List<String> {
        return strng.split('\n')
    }

    fun vertMirror(strng: String): String {
        var accu = ""
        for (s in splitMe(strng)) {
           accu += s.reversed() + "\n"
        }
        return accu.substring(0, accu.length - 1)
    }
    fun horMirror(strng: String): String {
        var accu = ""
        for (s in splitMe(strng)) {
            accu = s + "\n" + accu
        }
        return accu.substring(0, accu.length - 1)
    }
    fun oper(func: (String) -> String, s: String): String {
        return func(s)
    }
}

//object Opstrings {
//    fun vertMirror(s: String) = s.split("\n").joinToString("\n") { it.reversed() }
//    fun horMirror(s: String) = s.split("\n").reversed().joinToString("\n")
//    fun oper(f: (String) -> String, s: String) = f(s)
//}

class OpstringsTest {
    private fun testing(actual: String, expected: String) {
        assertEquals(expected, actual)
    }
    @Test
    fun test() {
        println("Fixed Tests vertMirror")
        var s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
        var r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw"
        testing(Opstrings.oper(Opstrings::vertMirror, s), r)
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx"
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP"
        testing(Opstrings.oper(Opstrings::vertMirror, s), r)

        println("Fixed Tests horMirror")
        s = "lVHt\nJVhv\nCSbg\nyeCt"
        r = "yeCt\nCSbg\nJVhv\nlVHt"
        testing(Opstrings.oper(Opstrings::horMirror, s), r)
        s = "njMK\ndbrZ\nLPKo\ncEYz"
        r = "cEYz\nLPKo\ndbrZ\nnjMK"
        testing(Opstrings.oper(Opstrings::horMirror, s), r)

    }
}