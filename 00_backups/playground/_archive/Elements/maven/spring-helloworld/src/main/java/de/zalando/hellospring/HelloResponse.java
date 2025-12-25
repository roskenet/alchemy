package de.zalando.hellospring;

import java.time.ZonedDateTime;

public class HelloResponse {

    private String name;
    private ZonedDateTime now;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getNow() {
        return now;
    }

}
