package odd

fun isOdd(num: Int) = num%2==1

fun main() {
    var arg: Int = 1
    println("Is ${arg} odd? ${isOdd(arg)}")

    arg = -1
    println("Is ${arg} odd? ${isOdd(arg)}")
}