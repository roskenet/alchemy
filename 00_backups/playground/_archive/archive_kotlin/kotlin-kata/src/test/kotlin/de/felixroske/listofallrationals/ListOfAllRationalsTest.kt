package de.felixroske.listofallrationals

import kotlin.test.assertEquals
import org.junit.Test

/*
# List of all Rationals

Here's a way to construct a list containing every positive rational number:

Build a binary tree where each node is a rational and the root is 1/1, with the following rules for creating the nodes below:

    The value of the left-hand node below a/b is a/a+b
    The value of the right-hand node below a/b is a+b/b

So the tree will look like this:

                       1/1
                  /           \
            1/2                  2/1
           /    \              /     \
       1/3        3/2        2/3       3/1
      /   \      /   \      /   \     /   \
   1/4    4/3  3/5   5/2  2/5   5/3  3/4   4/1

 ...

Now traverse the tree, breadth first, to get a list of rationals.

[ 1/1, 1/2, 2/1, 1/3, 3/2, 2/3, 3/1, 1/4, 4/3, 3/5, 5/2, .. ]

Every positive rational will occur, in its reduced form, exactly once in the list, at a finite index.

In the kata, we will use Pairs of type Pair<Int, Int> to represent rationals, where Pair(a, b) represents a / b

Use this method to create an infinite list of tuples:

fun allRationals(): Iterator<Pair<Int, Int>>

matching the list described above:

allRationals().asSequence().take(..).toList() => listOf(Pair(1, 1), Pair(1, 2), Pair(2, 1), Pair(1, 3), Pair(3, 2), ...)

'
*/

class TestKata {
    private val a = allRationals().asSequence().take(100001).toList()

    @Test
    fun simpleTests() {
        assertEquals(Pair(1, 1), a[0])
        assertEquals(Pair(1, 3), a[3])
        assertEquals(Pair(3, 2), a[4])
        assertEquals(Pair(5, 2), a[10])
    }

    @Test
    fun largerIndices() {
        assertEquals(Pair(19, 12), a[100])
        assertEquals(Pair(39, 28), a[1000])
        assertEquals(Pair(205, 162), a[10000])
        assertEquals(Pair(713, 586), a[100000])
    }
}