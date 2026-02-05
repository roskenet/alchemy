package bloch.item26;
// Item 26: Don't use raw types

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Main {

    static void main() {

    }

    // The difference between raw type and <?>:
    static int numElementsInCommon(Set<?> s1, Set s2) {
        // This doesn't work with <?> :
//        s1.add(new Object());
        s2.add(new Object());

        int numElementsInCommon = 0;

        for (Object e : s1) {
            if(s2.contains(e)) {
                numElementsInCommon++;
            }
        }
        return numElementsInCommon;
    }

    // Exceptions from this rule: 1. class literals Set<String>.class doesn't exist.
    // 2. instanceof:
    static boolean isInstanceOf(Object o) {
        if (o instanceof Set) {
            return true;
        } else {
            return false;
        }
    }
}
