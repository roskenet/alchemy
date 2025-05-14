package de.felixroske

fun main() {
    println("Hello World!")

    val elvis = Singer("Love me tender!")
    val monty = Juggler("two chain saws")

    bookThisOne(monty)

    doSomething(elvis)
    doSomething(monty)
}

fun doSomething(performer: Performer) {
    performer.perform()
}

fun bookThisOne(theBookableObject: Bookable) {
    theBookableObject.book()
}