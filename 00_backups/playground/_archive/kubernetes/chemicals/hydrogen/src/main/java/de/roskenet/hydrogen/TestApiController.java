package de.roskenet.hydrogen;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestApiController {

    @PostMapping("/api/something")
    public void postSomething(@RequestBody Something something) {
        System.out.println(something);
    }
}
