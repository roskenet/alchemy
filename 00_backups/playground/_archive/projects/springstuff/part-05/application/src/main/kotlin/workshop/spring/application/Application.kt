package workshop.spring.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import workshop.performer.Performer

@SpringBootApplication
class Application : CommandLineRunner {

    @Autowired
    lateinit var performer: Performer

    override fun run(vararg args: String?) {
        performer.doSomething();
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
