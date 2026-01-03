import org.springframework.context.annotation.AnnotationConfigApplicationContext
import workshop.beans.Party

fun main(args: Array<String>) {
    println("Let's have an AnnotationConfigured Party!")

    val ctx = AnnotationConfigApplicationContext(ApplicationConfig::class.java)
    val party = ctx.getBean(Party::class.java)

    println(party.start())
}