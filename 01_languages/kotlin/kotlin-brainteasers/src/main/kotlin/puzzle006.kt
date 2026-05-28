package de.zalando.demo

 	object Chicken {
 	  val comesAfter: String = Egg.comesAfter
 	}

 	object Egg {
 	  val comesAfter: String = Chicken.comesAfter
 	}

 	fun main() {
 	  println("The chicken comes after: " + Chicken.comesAfter)
 	  println("The egg comes after: " + Egg.comesAfter)
 	}