package de.zalando.showtell;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VarTest
{
    @Test
    @DisplayName("Type inference with var")
    void typeInference() {
        var param = "Hello World!";

        var result = param.toUpperCase(Locale.GERMAN);

        assertThat(result).isEqualTo("HELLO WORLD!");
    }

}
