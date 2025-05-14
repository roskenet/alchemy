package de.felixroske.convertstringtocamelcase

fun toCamelCase(str: String): String {
    val regex = """[-_]\w""".toRegex()

    val s = regex.replace(str) {
        it.value[1].toString().toUpperCase()
    }
    return s
}
