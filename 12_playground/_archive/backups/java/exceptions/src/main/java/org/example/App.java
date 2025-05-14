package org.example;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        final MyClass myClass = new MyClass();

        try {
            myClass.doSomething(true);
        } catch (Exception e) {
            Throwable cause = e.getCause();

            if(cause instanceof RuntimeException) {
                System.out.println("RuntimeException");
            }
            else {
                System.out.println("EXCEPTION!");
            }
        } finally {
            System.out.println("Here I am!");
        }
    }
}
