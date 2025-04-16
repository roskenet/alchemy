package demo.uranium;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('Apps/ZMON/Users') or hasAnyAuthority(@authScope.helloRead)")
    public HelloWorldResponse helloWorld() {
        return new HelloWorldResponse("Elvis A. Presley", LocalDate.of(1935, 1,8));
    }
}
