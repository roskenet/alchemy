package de.roskenet.pgjackson;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class Artist {

    private final UUID id;
    private final String name;
    private final ZonedDateTime birthday;
    private final Genre genre;
    private final boolean skipRetouchQA;

    public Artist(UUID id, String name, ZonedDateTime birthday, Genre genre, boolean skipRetouchQA) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.genre = genre;
        this.skipRetouchQA = skipRetouchQA;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) && Objects.equals(name, artist.name)
                && Objects.equals(birthday, artist.birthday) && genre == artist.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday, genre);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", genre=" + genre +
                '}';
    }

    public boolean isSkipRetouchQA() {
        return skipRetouchQA;
    }
}
