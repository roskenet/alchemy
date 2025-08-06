package constructors

import java.time.LocalDate

data class Singer(val name: String, val birthday: LocalDate)

fun Singer.printDetails() {
    println("$name was born on $birthday.")
}

fun main() {
    val singer = Singer("Elvis A. Presley", LocalDate.of(1935, 1, 8))
    singer.printDetails()
}
