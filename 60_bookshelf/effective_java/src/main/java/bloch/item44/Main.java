package bloch.item44;
//Favor the use of standard functional interfaces

import java.util.function.IntPredicate;
import java.util.function.Supplier;

class Artist {
    private String name;
    private String genre;

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}

public class Main {
    // And use the functional interfaces for primitives:
    // eg. IntPredicate

//    static void main() {
//        IntPredicate myPredicate = ( n ) -> (n/2 == 0);
//    }

    static void main() {

//        Functional style:
        Artist elvis = new Artist("Elvis", "Rock'n'Roll");

        String result = doSomething(elvis::getName);
        System.out.println(result);

    }

    public static String doSomething(Supplier<String> supplier) {
       return supplier.get().toUpperCase();
    }
}


