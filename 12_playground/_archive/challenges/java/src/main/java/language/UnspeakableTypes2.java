package language;

public class UnspeakableTypes2 {

    public static void main(String[] args) {

        Object theObject = new Object() {
            public String toString() {
                System.out.println("Hello World!");
                return "Hallo";
            }
        };

        System.out.println(theObject);
    }
}
