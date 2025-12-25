import org.springframework.context.support.ClassPathXmlApplicationContext
import workshop.beans.Party

fun main(args: Array<String>) {
    println("Let's have a party!")

    val ctx = ClassPathXmlApplicationContext("classpath:application-context.xml")
    val party = ctx.getBean(Party::class.java)

    party.start()
}