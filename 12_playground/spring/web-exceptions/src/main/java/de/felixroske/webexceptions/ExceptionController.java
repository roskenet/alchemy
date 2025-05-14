package de.felixroske.webexceptions;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    public static class Person {
        public String name;
        public LocalDate birthday;
    }

    @GetMapping("/exception")
    public Person throwException() {

        throw new TestException("No such Person");

    }

    @GetMapping("/person")
    public Person getPerson() {

       var elvis = new Person();
       elvis.name = "Elvis A. Presley";
       elvis.birthday = LocalDate.of(1953, 1, 8);
       return elvis;
    }

}
