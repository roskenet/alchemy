package exceptions;

import java.io.IOException;

public class Basics {

    public static void main(String[] args) {
       try {
           doSomething();
       } catch (IllegalArgumentException ioe) {
           System.out.println("Caught the NPE");
           throw new IllegalArgumentException();
       } catch (Exception e) {
           System.out.println("Caught the Exception");
           throw e;
       } finally {
           System.out.println("Doing it");
       }
    }

    private static void doSomething() {
//        throw new ("Hello");
//        throw new NullPointerException();
    }

}
