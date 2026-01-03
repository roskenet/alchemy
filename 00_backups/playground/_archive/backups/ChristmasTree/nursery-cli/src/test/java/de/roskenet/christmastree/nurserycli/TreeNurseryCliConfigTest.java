package de.roskenet.christmastree.nurserycli;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import de.roskenet.christmastree.ChristmasTreeNursery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TreeNurseryCliConfig.class)
@ActiveProfiles("test")
public class TreeNurseryCliConfigTest {

    @Autowired
    private ChristmasTreeNursery nursery;

    @Test
    void testMockTreeNursery() {

        assertThat(nursery.tree(4), is(""));
    }
}
