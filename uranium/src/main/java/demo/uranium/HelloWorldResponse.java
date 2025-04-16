package demo.uranium;

import java.time.LocalDate;

public record HelloWorldResponse (
        String name,
        LocalDate birthday
) {}


