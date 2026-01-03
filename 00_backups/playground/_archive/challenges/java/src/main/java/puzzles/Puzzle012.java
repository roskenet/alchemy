package puzzles;

import com.sun.jdi.Value;
import java.util.Vector;

public class Puzzle012 {

    public static class Value {
        public String someField = "Blubber";
    }

    public static void main(String[] args) {
       char[] myCArray = { 'A', 'B', 'C'};
       int[] myIArray = {1, 2, 3};
       Value[] myVArray = { new Value(), new Value(), new Value()};

       // see toString:
        System.out.println("Look at CArray: " + myCArray);
        System.out.println("Look at IArray: " + myIArray);
        System.out.println("Look at VArray: " + myVArray);

    }

}
