package de.roskenet.hellospring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloSpringApplication: CommandLineRunner {
    override fun run(vararg args: String) {
        println("Hello World!")

        println("Fun with bits")

        val num1 = 0b0011
        val num2 = 0b1010

        println("${num1.toBinaryString(4)}\tand\t${num2.toBinaryString(4)}\t=\t${(num1 and num2).toBinaryString(4)}")
        println("${num1.toBinaryString(4)}\tor\t${num2.toBinaryString(4)}\t=\t${(num1 or num2).toBinaryString(4)}")
        println("${num1.toBinaryString(4)} xor ${num2.toBinaryString(4)} = ${(num1 xor num2).toBinaryString(4)}")
    }
}

fun Int.toBinaryString(length: Int): String = "0b" + toString(2).padStart(length, '0')

fun main(args: Array<String>) {
    runApplication<HelloSpringApplication>(*args)
}
