package de.roskenet.httpmock;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {

    @GetMapping("/492")
    public ResponseEntity<String> tooManyRequests() {
        var body = "Too many requests";

        var httpHeaders = new HttpHeaders();
        httpHeaders.add("Retry-After", "42");

        return new ResponseEntity<>(body, httpHeaders, HttpStatus.TOO_MANY_REQUESTS);
    }
}
