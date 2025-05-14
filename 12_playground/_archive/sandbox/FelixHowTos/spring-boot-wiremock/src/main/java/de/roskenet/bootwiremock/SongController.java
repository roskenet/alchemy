package de.roskenet.bootwiremock;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @GetMapping("/songs")
    public List<Song> getSongs() {
        var song1 = new Song();
        song1.setArtist("Oasis");
        song1.setTitle("Don't look back in anger");

        var songList = Arrays.asList(song1);

        return songList;
    }
}
