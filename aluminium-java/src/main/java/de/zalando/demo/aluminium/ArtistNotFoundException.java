package de.zalando.demo.aluminium;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(String s) {
        super(s);
    }
}
