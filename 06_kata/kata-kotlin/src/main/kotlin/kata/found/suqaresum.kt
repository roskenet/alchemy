package kata.found

fun squareSum(n: Array<Int>): Int {
//    return n.stream.map( (z) -> {z*z}).sum()
    return n.sumOf { it * it }
}