package org.example;


public class App
{
    public static void main( String[] args ) {
        var app = new App();

        try {
            app.doSomething();
        }
//        catch (MySubException mse) {
//            System.out.println("CATCH in MSE");
//            mse.echo();
//        }
        catch (MyException me) {
            System.out.println("CATCH in ME");
            me.echo();
        }

    }

    public void doSomething() {
        // Here we do some things
        throw new MySubException("Fehler");
    }
}
