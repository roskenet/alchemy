package playground.querydsl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    private ArtistService artistService;

    @Test
    void searchForPrince() {
        var searchParams = new ArtistService.SearchParams("Prince");

        var filteredArtists = artistService
                .getFiltered(searchParams).stream()
                .map(Artist::getName)
                .collect(Collectors.toUnmodifiableList());

        assertThat(filteredArtists.contains("Prince")).isTrue();
    }
}
