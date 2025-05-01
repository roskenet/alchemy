package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// Greatest Common Divisor
public class GgtRekursiv {

    public static int ggT(int a, int b) {
        if (b == 0)
            return a;
        else return ggT(b, a % b);
    }

    @Test
    public void ggT() {
        assertThat(ggT(42, 7)).isEqualTo(7);
        assertThat(ggT(7, 14)).isEqualTo(14);
    }

}
