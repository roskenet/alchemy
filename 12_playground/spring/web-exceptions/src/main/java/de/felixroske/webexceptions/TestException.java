package de.felixroske.webexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Thing")
public class TestException extends RuntimeException {

    public TestException(String message) {
        super(message);
    }

}
