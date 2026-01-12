package petunia

class Stack<T> {
    val stack: MutableList<T> = ArrayList()

    fun push(t: T) {
        stack.add(t)
    }

    fun pop(): T? {
        return stack.removeAt(stack.lastIndex)
    }

    fun peek(): T? {
        return stack.lastOrNull()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    fun size(): Int {
        return stack.size
    }
}

fun main() {
    val intStack = Stack<Int>()
    intStack.push(1)
    intStack.push(2)
    intStack.push(3)

    val stringStack = Stack<String>()
    stringStack.push("A")
    stringStack.push("B")
    stringStack.push("C")

    println(intStack.peek()) // 3
    while (!intStack.isEmpty()) { // 3, 2, 1
        println(intStack.pop())
    }
    println(intStack.peek()) // null
    println(intStack.isEmpty()) // true

    println(stringStack.size()) // 3
    while (!stringStack.isEmpty()) { // C, B, A
        println(stringStack.pop())
    }
}