package de.zalando.workshop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextAnagramTest {
    @Test
    void testIsAnagram_true() {
        Text text = new Text("Suppenwürfel");

        boolean result = text.isAnagramTo("Würfelsuppen");

        assertThat(result).isEqualTo(true);
    }

    @Test
    void testIsAnagram_false() {
        Text text = new Text("Bilderrahmen");

        boolean result = text.isAnagramTo("Fototapete");

        assertThat(result).isEqualTo(false);
    }
}
