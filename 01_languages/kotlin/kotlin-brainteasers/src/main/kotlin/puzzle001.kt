package de.zalando.demo

fun main() {
	  val result = null + null

	  if (result == null) {
	    println("It's null")
	  } else {
	    println("It's a ${result::class.simpleName} with the value: $result")
	  }
}