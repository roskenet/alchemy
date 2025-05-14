package centuryfromyear

import org.junit.Test
import kotlin.test.assertEquals

fun century(number: Int): Int = ((number - 1) / 100 ) + 1
// or (number + 99 / 100)

class CenturyFromYearTest {

    @Test fun testFixed() {
        assertEquals(18, century(1705));
        assertEquals(19, century(1900));
        assertEquals(17, century(1601));
        assertEquals(20, century(2000));
        assertEquals(1,  century(89));
    }
}