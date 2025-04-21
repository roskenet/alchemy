package de.zalando.demo.aluminium;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    public ProblemDetail handleException(Exception anfe) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        anfe.getLocalizedMessage());

        // Some frequently used fields:
        problemDetail.setType(URI.create("https://mycoolapi.docs.internet.com/errors/not-found"));
        problemDetail.setTitle("Not Found");

        // Expose whatever you want:
        problemDetail.setProperty("timestamp", ZonedDateTime.now());

        return problemDetail;
    }
}
