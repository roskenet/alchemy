package de.roskenet.playground.springbootkotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

/*
Bean definitionen funktionieren genauso with mit Java:
*/
interface Usable {
    fun doSomething(arg: String)
}

//@Component
class MyWorkerClass(val param: String = "default"): Usable {
    override fun doSomething(arg: String) {
        println("This was parameterized with $param")
    }
}

@Configuration
class MyUseableConfig() {
    @Bean
    fun usableFactory(): Usable {
        return MyWorkerClass("Another thing")
    }
}