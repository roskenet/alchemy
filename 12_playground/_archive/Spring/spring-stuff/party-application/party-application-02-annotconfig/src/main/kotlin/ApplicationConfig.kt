import de.felixroske.performer.Performer
import de.felixroske.performer.Singer
import org.springframework.context.annotation.Bean
import workshop.beans.Party
import workshop.beans.SummerParty

class ApplicationConfig {
    @Bean
    fun performer(): Performer = Singer()

    @Bean
    fun party(performer: Performer): Party = SummerParty(performer)
}