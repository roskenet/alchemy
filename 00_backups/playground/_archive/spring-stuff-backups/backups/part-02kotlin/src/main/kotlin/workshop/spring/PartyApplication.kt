package workshop.spring

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(PartyConfig::class.java)
    val performer = applicationContext.getBean(Performer::class.java)

    println(performer.doSomething())
}
