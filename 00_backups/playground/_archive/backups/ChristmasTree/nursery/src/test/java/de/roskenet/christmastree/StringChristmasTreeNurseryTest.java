package de.roskenet.christmastree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringChristmasTreeNurseryTest {

    @Test
    void testTreeWithHeight4() {
        ChristmasTreeNursery treeNursery = new StringChristmasTreeNursery();

        var result = treeNursery.tree(4);

        assertThat(result, is("  *\n ***\n*****\n ***"));

    }

    @Test
    void testTreeIsTooSmallError() {
        ChristmasTreeNursery treeNursery = new StringChristmasTreeNursery();

        assertThrows(IllegalArgumentException.class, () ->
                treeNursery.tree(3));
    }
}
