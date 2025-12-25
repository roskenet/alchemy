package de.roskenet.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/{param}")
    public HelloResponse getApi(@PathVariable("param") String param) {
        HelloResponse response = new HelloResponse();
        
        String upperCase = param.toUpperCase();
        response.setValue(upperCase);

        return response;
    }
}
