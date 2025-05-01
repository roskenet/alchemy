package de.roskenet

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    var myNumber = 42

    myNumber.flxFormatString()

}

fun Number.flxFormatString(): String = "%.2f".format(this)


