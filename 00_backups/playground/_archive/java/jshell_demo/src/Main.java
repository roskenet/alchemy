import killerclasses.MyKillerClass;

public class Main {
    public static void main(String[] args) {
        MyKillerClass.doSomething();

        var newString = "New String";
        var myLong = 5L;
        System.out.println(newString);
        System.out.println(myLong);
    }

    public void aMethod() {
        MyKillerClass myKillerClass = new MyKillerClass();
    }
}