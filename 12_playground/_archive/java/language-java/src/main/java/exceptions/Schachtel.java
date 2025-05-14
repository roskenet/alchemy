package exceptions;

public class Schachtel {

    public static void main(String[] args) {
       try {
           System.out.println("Hello World");
           throw new IllegalArgumentException("Test");
       } catch (Exception e) {
           System.out.println("Ich bin im catch-block!");
       }
    }

}
