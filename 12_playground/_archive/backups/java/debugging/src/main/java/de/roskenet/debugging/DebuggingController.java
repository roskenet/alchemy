package de.roskenet.debugging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebuggingController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("something", 1234);
    }

}
