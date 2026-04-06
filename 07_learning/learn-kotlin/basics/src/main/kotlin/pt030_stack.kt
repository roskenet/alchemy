import java.util.Stack

fun main() {
    var theStack = Stack<String>()
    theStack.push("Hello")

    if (theStack.isNotEmpty()) {
        println(theStack.pop())
    }
}