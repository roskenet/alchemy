package hello.kotlin

import java.util.UUID

var pi = 3.14

open class UsefulClass(var name: String, value_param: Int) {
    
   var foo = value_param
    set(value) {
       field = value 
    } 
    
}

class VeryUsefulClass(name: String, value_param: Int) : UsefulClass(name, value_param) {
    
}

fun main(args: Array<String>) {
    
    val theClass = UsefulClass("EineKlasse", 42)
    
    theClass.foo = 142
    
    println("${theClass.foo}")
    
//    println("Hello World!")
//    
//    var x = 3
//    var name = "Franz Beckenbauer"
//    
//    println(if (pi < 3) "$name hat mehr als $x Tore geschossen" else "Irgendwas anderes")
//    
//    name = "Rudi Völler"
//    
//    println ("Und nun bin ich ein $name")
//    
//     val theName = doSomething("Blah")
//    println("$theName")
}

fun doSomething(arg: String): String {
    
    val myAsset = Asset(UUID.randomUUID(), arg)
    
    return "${myAsset.name.toUpperCase()}"
}