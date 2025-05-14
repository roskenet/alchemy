package de.roskenet.createreactappbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController("/hello")
class HelloService {

    @GetMapping("/hello/{name}")
    HelloResponse getHello(@PathVariable("name") String name) {
        return new HelloResponse("Hello, " + name, 42);
    }
}

