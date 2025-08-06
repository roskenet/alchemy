import org.springframework.ai.chat.client.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController() {

    @Autowired
    lateinit var chatClient: ChatClient

    @PostMapping("/ask")
    fun ask(@RequestBody question: Question): Answer {
        return chatClient.prompt()
            .user(question.question())
            .call()
            .entity(Answer.class)
    }
}