package felix.demo.datatypes;

public class Primitives {
    public static void main(String[] args) {
       var myChar = '\u0041';

       // char is unsigned, short is signed
//       short myShort = myChar;

       System.out.println(myChar);
    }
}
