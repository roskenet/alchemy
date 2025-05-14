package de.roskenet.christmastree.nurserycli;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

import de.roskenet.christmastree.ChristmasTreeNursery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = TreeCommand.class)
public class TreeNurseryCliMockExampleTest {

    @MockBean
    private ChristmasTreeNursery nurseryMock;

    @Autowired
    private TreeCommand treeCommand;

    @Test
    void testChristmasTreeNurseryMock() {
        given(nurseryMock.tree(3)).willReturn("MockedReturn");

        assertThat(treeCommand.tree(3), is("MockedReturn"));
    }
}
