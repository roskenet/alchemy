package de.roskenet.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }

    class MyResponse {
        private String theString;
        private Integer theInteger;

        public MyResponse(String theString, Integer theInteger) {
            this.theString = theString;
            this.theInteger = theInteger;
        }

        public String getTheString() {
            return theString;
        }

        public Integer getTheInteger() {
            return theInteger;
        }
    }

    @GetMapping("/hello")
    public MyResponse getResponse() {
        return new MyResponse("test", 1234);
    }
}
