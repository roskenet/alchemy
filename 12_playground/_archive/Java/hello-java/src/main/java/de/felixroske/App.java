package de.felixroske;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        MyGreatWorker theWorker = new MyGreatSubWorkerClass();
        App theApp = new App();
        theApp.doSomethingWith(theWorker);
    }

    public void doSomethingWith(MyGreatWorker theWorkerClss) {
        var something = theWorkerClss.returnSomething();
        System.out.println("Something is: " + something);
    }
}
