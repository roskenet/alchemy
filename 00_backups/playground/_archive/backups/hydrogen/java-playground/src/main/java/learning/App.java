package learning;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        App theApp = new App();
        Class<? extends App> theAppClass = theApp.getClass();

        System.out.println(theAppClass.getSimpleName());
    }
}
