package de.zalando.demo.openapi;

import java.time.LocalDate;

public record Artist(String name, String genre, LocalDate birthDate) {
}
