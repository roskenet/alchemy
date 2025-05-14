package de.zalando.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HelloController {

    @GetMapping("/{name}")
    public HelloResponse greeting(@PathVariable("name") String name) {
        final HelloResponse response = new HelloResponse();
        response.setName(name);

        return response;
    }

}
