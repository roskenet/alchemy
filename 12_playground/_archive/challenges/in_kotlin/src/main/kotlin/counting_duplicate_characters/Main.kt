package counting_duplicate_characters

fun isVowel(c: Char): Boolean = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'

fun main() {
    println("Counting duplicate characters:")
    // Write a program that counts duplicate characters from a given string.

    val s = "Mississippi"

    println("`$s` has ${s.length} characters.")
    println("`$s` has ${s.count(::isVowel)} vowels.")
}