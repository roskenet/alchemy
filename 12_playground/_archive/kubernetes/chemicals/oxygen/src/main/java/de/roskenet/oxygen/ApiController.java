package de.roskenet.oxygen;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ApiController {

    @GetMapping("/api/name/{param}")
    public HelloResponse getApi(@PathVariable("param") String param) {
        var response = new HelloResponse(param.toUpperCase());

        return response;
    }
}
