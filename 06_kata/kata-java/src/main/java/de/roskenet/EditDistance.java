package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EditDistance {

    public int editDistance(String source, String destination) {

        if (source.toLowerCase().equals(destination.toLowerCase())) {
            return 0;
        } else { }

        return 0;
    }

    @Test
    void testEditDistance_tables() {
       assertThat(editDistance("rapple", "tables")).isEqualTo(4);
    }

    @Test
    void testEditDistance_michael() {
        assertThat(editDistance("Micha", "Michael")).isEqualTo(2);
    }
}
