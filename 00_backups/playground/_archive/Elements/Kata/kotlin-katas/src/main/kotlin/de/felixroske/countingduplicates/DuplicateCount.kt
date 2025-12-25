package de.felixroske.countingduplicates

fun duplicateCount(text: String): Int {

    val charMap = mutableMapOf<Char, Int>()

    text.toLowerCase().toCharArray().forEach {
        val value = charMap.get(it)

        if(value == null) {
            charMap.put(it, 1);
        }
        else {
            charMap.put(it, value+1)
        }
    }

    return charMap.count {
        it.value > 1
    }
}
/*
fun duplicateCount(text: String): Int {
    return text.groupingBy { it.toLowerCase() }.eachCount().values.count { it > 1 }
}

fun duplicateCount(text: String) = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }
 */