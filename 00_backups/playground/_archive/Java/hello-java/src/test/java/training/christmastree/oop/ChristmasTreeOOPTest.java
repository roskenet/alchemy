package training.christmastree.oop;

import org.junit.jupiter.api.Test;

public class ChristmasTreeOOPTest {

    @Test
    void testPrintTree() {
        ChristmasTreeOOP tree = new ChristmasTreeOOP(5);

        String theTree = tree.getTree();

        System.out.println(theTree);
    }
}
