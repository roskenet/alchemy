package de.roskenet.hellospringnative;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloMessage getMessage() {
        var helloMessage = new HelloMessage();
        helloMessage.setMessage("HalloWelt!");
        return helloMessage;
    }
}
