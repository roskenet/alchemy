# Katas

## Find The Parity Outlier

You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples:
```
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)
```

## Complementary DNA

Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

More similar exercise are found here http://rosalind.info/problems/list-view/ (source)

```
DnaStrand.makeComplement("ATTGC") // return "TAACG"

DnaStrand.makeComplement("GTAT") // return "CATA"
```

## Find the first non-consecutive number

Your task is to find the first element of an array that is not consecutive.

By not consecutive we mean not exactly 1 larger than the previous element of the array.

E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all consecutive but 6 is not, so that's the first non-consecutive number.

If the whole array is consecutive then return null2.

The array will always have at least 2 elements1 and all elements will be numbers. The numbers will also all be unique and in ascending order. The numbers could be positive or negative and the first non-consecutive could be either too!

If you like this Kata, maybe try this one next: https://www.codewars.com/kata/represent-array-of-numbers-as-ranges

1 Can you write a solution that will return null2 for both [] and [ x ] though? ( This is not tested, but you can write your own example test. )

2
Swift, Ruby and Crystal: nil
Haskell: Nothing
Python: None
Julia: nothing

# Who likes it?

You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement a function likes :: [String] -> String, which must take in input array, containing the names of people who like an item. It must return the display text as shown in the examples:

```
likes [] // must be "no one likes this"
likes ["Peter"] // must be "Peter likes this"
likes ["Jacob", "Alex"] // must be "Jacob and Alex like this"
likes ["Max", "John", "Mark"] // must be "Max, John and Mark like this"
likes ["Alex", "Jacob", "Mark", "Max"] // must be "Alex, Jacob and 2 others like this"
```

# Sum of odd numbers

Given the triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...

Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:

rowSumOddNumbers(1); // 1
rowSumOddNumbers(2); // 3 + 5 = 8

    /* sum of consequent M numbers is (M+1)M/2, so 
     * we may know how many numbers were below
     * our ROW : numbersBelow = ((n-1)*(n))/2.
     * Now we may calculate first number in row:
     * firstNumberInRow = 2*numbersBelow+1.
     * So, firstNumberInRow = n*n-n+1 and
     * last number in ROW is n*n-n+1 + 2(n-1).
     * Let assume that last number before row is
     * x1 and last number in row is x2. It's known
     * that 1+3+5+...+(2k-1) = k*k.
     * Sum in row must be x2*x2 - x1*x1. 
     // OUR x1 = (n*n-n)/2 and x2 = (n*n+n)/2.
     * After some simplification: SUM = n*n*n. */

# The Office VI - Sabbatical

Learning to code around you full time job is taking over your life. You realise that in order to make significant steps quickly, it would help to go to a coding bootcamp in London.

Problem is, many of them cost a fortune, and those that don't still involve a significant amount of time off work - who will pay your mortgage?!

To offset this risk, you decide that rather than leaving work totally, you will request a sabbatical so that you can go back to work post bootcamp and be paid while you look for your next role.

You need to approach your boss. Her decision will be based on three parameters:

val=your value to the organisation
happ=her happiness level at the time of asking and finally
The numbers of letters from 'sabbatical' that are present in string 'x'.

Note that if x contains three instances of the letter 'l', that still scores three points, even though there is only one in the word sabbatical.

If the sum of the three parameters (as described above) is > 22, return 'Sabbatical! Boom!', else return 'Back to your desk, boy.'.

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

                                                                                         In the kata, we will use tuples of type (int, int) to represent rationals, where (a, b) represents a / b

                                                                                         Use this method to create an infinite list of tuples:

                                                                                         def all_rationals() -> Generator[(int, int)]:

                                                                                         matching the list described above:

                                                                                         all_rationals => [(1, 1), (1, 2), (2, 1), (1, 3), (3, 2), ...]
