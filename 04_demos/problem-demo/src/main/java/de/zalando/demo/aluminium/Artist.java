package de.zalando.demo.aluminium;

import java.time.LocalDate;

public record Artist(String id,
                     String name,
                     LocalDate born) { }
