package functionalkotlin

interface VeryBasic

class FlxBasic: VeryBasic

fun main(args: Array<String>) {
    val x = 5;

    val flxBasic = FlxBasic()

    doSomething(flxBasic)

    println("Only for reference: $x")
    println(flxBasic)
}

fun doSomething(param: VeryBasic) {
    println("Hello World!")
}

