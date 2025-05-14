package de.felixroske.mostfrequentlyusedwords

fun top3(s: String): List<String> {
    val splitlist = s.split(' ', ';', '/', ':', '!', '?', ',', '.', '\n', '\t')

    val tempMap = mutableMapOf<String, Int>()

    splitlist.forEach {
        val times: Int? = tempMap[it.toLowerCase()]
        if(times == null) {
            tempMap.put(it.toLowerCase(), 1)
        } else {
            tempMap.put(it.toLowerCase(), times+1)
        }
    }

    print(tempMap)

    val endList = mutableListOf<Pair<String, Int>>()

    tempMap.forEach outer@{(s, i) ->
        if(s.equals("") or s.equals("'") or s.equals("'''")) {
            return@outer
        }
        if(endList.size == 0) {
            endList.add(Pair(s, i))
            return@outer
        }

        for (inneri in endList.indices) {
            val (s1, i1) = endList[inneri]
            if (i >= i1) {
                endList.add(inneri, Pair(s, i))
                return@outer
            } else {
                endList.add(Pair(s, i))
            }
        }
    }

    if(endList.size == 0) {
        return emptyList()
    }
    if(endList.size == 1) {
        return listOf(endList[0].first)
    }
    if(endList.size == 2) {
        return listOf(endList[0].first, endList[1].first)
    }
    if(endList.size >= 3) {
        return listOf(endList[0].first, endList[1].first, endList[2].first)
    }
    // We can never get here:
    return emptyList()
}

/*
fun top3(text: String): List<String> {
    val words = Regex("[A-Za-z][A-Za-z']*").findAll(text).map { it.groupValues[0].toLowerCase() }
    val occurrences = mutableMapOf<String, Int>()
    words.forEach { occurrences.merge(it, 1, Integer::sum) }
    return occurrences.toList().sortedByDescending { it.second }.map { it.first }.take(3)
}*/
