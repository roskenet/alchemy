package language;

public class UnspeakableTypes {

    public static void main(String[] args) {

        var theObject = new Object() {
            void bar() {
                System.out.println("Hello World");
            }
        };

        theObject.bar();

    }
}
