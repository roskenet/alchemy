package de.roskenet.pgjackson;

import static java.time.ZonedDateTime.of;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundJacksonApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testObjectMapping_writeOut() throws JsonProcessingException {
        var artist = new Artist(UUID.fromString("b49fadba-6a8a-4173-b280-60c28b07136c"),
                "Michael Jackson",
                ZonedDateTime.of(1956, 8, 29,
                        17, 20, 23, 1234, ZoneId.of("UTC")),
                Genre.POP, true);

        var s = objectMapper.writeValueAsString(artist);
        System.out.println(s);

        assertThatJson(s).isEqualTo("""
                {"id": "b49fadba-6a8a-4173-b280-60c28b07136c",
                 "birthday": "1956-08-29T17:20:23.000001234Z",
                 "name": "Michael Jackson",
                 "genre": "POP"
                }
                """);
    }

    @Test
    void testObjectMapping_readIn() throws JsonProcessingException {
        // Might or might not work depending on the
        // fail-on-unknown-properties: true setting
        var serializedMichael = """
                {"id": "b49fadba-6a8a-4173-b280-60c28b07136c",
                 "birthday": "1958-08-29T17:15:34.12345Z",
                 "name": "Michael Jackson",
                 "genre": "pop",
                 "some_field": "Some data"
                }
                """;

        var michael = objectMapper.readValue(serializedMichael, Artist.class);

        System.out.println(michael);

    }

}
