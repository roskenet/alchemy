package de.roskenet.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IoController {

    @Autowired
    private GanymedeService ganymedeService;

    @GetMapping("/hello")
    public Artist hello() {
        return ganymedeService.makeApiCall();
    }
}
