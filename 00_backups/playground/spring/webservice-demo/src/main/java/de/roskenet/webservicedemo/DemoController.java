package de.roskenet.webservicedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public static enum Status {
        ACTIVE,
        INACTIVE
    }

    @GetMapping("/demo")
    public String demo(
            DemoParameters parameters
    ) {
       return "Hello " + parameters.getSure_name() + " " +
               parameters.getFirst_name() + " " +
               parameters.getStatus();
    }
}
