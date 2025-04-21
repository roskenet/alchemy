package de.roskenet.copper;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ManagedResource(objectName = "de.roskenet.copper:type=CopperController")
public class CopperController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        String firstName = name.split(" ")[0];
        return "Hello, " + firstName + "!";
    }
}
