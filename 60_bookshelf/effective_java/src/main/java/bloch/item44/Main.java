package bloch.item44;
//Favor the use of standard functional interfaces

import java.util.function.IntPredicate;

public class Main {
    // And use the functional interfaces for primitives:
    // eg. IntPredicate

    static void main() {
        IntPredicate myPredicate = ( n ) -> (n/2 == 0);
    }
}
