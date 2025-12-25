package workshop.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PartyConfig {

    @Bean
    fun performer() : Performer {
        return Magician()
    }
}