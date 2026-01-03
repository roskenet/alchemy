import java.util.*

class AnagramTester {

    val theCharArray: CharArray

    constructor(initialString: String) {
        theCharArray = initialString.trim().toLowerCase().toCharArray()
        theCharArray.sort()
    }

    fun isAnagramTo(param: String): Boolean {
        val chars = param.trim().toLowerCase().toCharArray()
        chars.sort()

        return Arrays.equals(theCharArray, chars)
    }

}