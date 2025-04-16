package de.zalando.demo.aluminium;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ArtistController {

    @GetMapping("/artists/{artistId}")
    public Artist getArtist(@PathVariable String artistId) {

        switch (artistId) {
            case "elvis":
                return new Artist("elvis",
                        "Elvis A. Presley",
                        LocalDate.of(1935, 1, 8)
                );
        }

        throw new ArtistNotFoundException("Artist [" + artistId + "]");
    }

}
