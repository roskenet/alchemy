package kata

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/515bb423de843ea99400000a/train/kotlin

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.count()
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            if (collection.count() % itemsPerPage == 0)
                return collection.count() / itemsPerPage
            else
                return (collection.count() / itemsPerPage) + 1
        }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int =
        when {
            pageIndex < pageCount - 1 -> itemsPerPage
            pageIndex == pageCount - 1 -> pageCount % itemsPerPage
            else -> -1
        }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int =
        when {
            itemIndex < 0 -> -1
            itemIndex >= itemCount -> -1
            else -> itemIndex / itemsPerPage
        }
}


class PaginationHelperTest {
    @Test
    fun testItemCount() {
        val helper = PaginationHelper<Int>(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3)
        assertEquals(11, helper.itemCount, "itemCount is returning incorrect value")
    }

    @Test
    fun testPageCount() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(2, helper.pageCount, "pageCount is returning incorrect value")
    }

    @Test
    fun testPageItemCount() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(2, helper.pageItemCount(1), "pageItemCount is returning incorrect value")
    }

    @Test
    fun testPageIndex() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(0, helper.pageIndex(3), "pageIndex is returning incorrect value")

    }
}