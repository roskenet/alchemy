package de.roskenet.aluminium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class MvnSpringKotlinApplication : CommandLineRunner {
   override fun run(vararg args: String): Unit {
       println("This is from \"run\"")
} 
}

fun main(args: Array<String>) {
	runApplication<MvnSpringKotlinApplication>(*args)
//    println("This is the end")
//    println("Hold your breath and count to ten")
//    println("Feel the earth move and then")
}
