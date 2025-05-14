fun main(args: Array<String>) {
    println("Hello World!")

    val l1 = 100_000L
    val l2 = 100_000L

    println("${l1 == l2}")
    println("${l1.equals(l2)}")
    println("${l1 === l2}")
}