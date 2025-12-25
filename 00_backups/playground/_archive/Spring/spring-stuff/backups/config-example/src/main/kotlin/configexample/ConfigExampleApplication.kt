package configexample

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConfigExampleApplication : CommandLineRunner {

    @Value("\${greeting:Guten Tag!}")
    lateinit var greeting: String

    override fun run(vararg args: String?) {
       println("${greeting}")
    }

}

fun main(args: Array<String>) {
    runApplication<ConfigExampleApplication>(*args)
}
