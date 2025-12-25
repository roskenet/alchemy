package de.roskenet.sporx.dateservice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @GetMapping("/now")
    public CurrentDateTime getCurrentDate() {
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication();

        return new CurrentDateTime();
    }

    @GetMapping("/openforall")
    public String openForAll() {
        return "{\"content\": \"open_for_all\"}";
    }

    @GetMapping("/authenticated")
    public String getTest() {
        var context = SecurityContextHolder.getContext();
        return "{\"content\": \"test\"}";
    }

    @GetMapping("/getforscope")
    @PreAuthorize("hasAuthority('SCOPE_nothere')")
    public String getForScope() {
        var context = SecurityContextHolder.getContext();
        return "{\"result\": \"successful\"}";
    }
}
