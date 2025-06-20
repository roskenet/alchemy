package de.zalando.demo.openapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/artists")
    public List<Artist> getArtists() {

        var michael =
                new Artist("Michael Jackson",
                        "Pop",
                        LocalDate.of(1958, 8, 29)
                );
        var john =
                new Artist("John Lennon",
                        "Rock",
                        LocalDate.of(1940, 10, 9)
                );

        return List.of(michael, john);
    }

    @PostMapping("/artists")
    public Artist postArtist(Artist artist) {
        return artist;
    }
}
