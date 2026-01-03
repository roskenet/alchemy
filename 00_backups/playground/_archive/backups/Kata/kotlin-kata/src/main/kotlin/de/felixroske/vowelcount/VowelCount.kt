package de.felixroske.vowelcount

fun getCount(str : String) : Int {
  val vowels = listOf('a', 'e', 'i', 'o', 'u')
  var count = 0

  for (letter: Char in str.toCharArray()) {
    if (vowels.contains(letter)) {
      count+=1
    }
  }

  return count
}

//fun getCount(str : String) = str.count { it in "aeiou" }
