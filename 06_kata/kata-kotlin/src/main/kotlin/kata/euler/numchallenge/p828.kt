package kata.euler.numchallenge

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

data class Challenge(val target: UInt, val numbers: List<UInt>)

fun main() {
    val fileName = "./resources/0828_number_challenges.txt"
    val inputStream = File(fileName).inputStream()
    val reader = BufferedReader(InputStreamReader(inputStream))

    reader.forEachLine { println(challengeFactory(it)) }
}

fun challengeFactory(line: String): Challenge {
    val colonSplit = line.split(':')
    val target = colonSplit[0].toUInt()
    val numbers = colonSplit[1].split(',').map(String::toUInt)
    return Challenge(target, numbers)
}

// I'll try it using brute force:
// Kombinatorik:
// 6 Zahlen und 4 Operationen:
//