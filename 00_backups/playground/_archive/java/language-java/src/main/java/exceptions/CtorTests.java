package exceptions;

public class CtorTests {

    public static void main(String[] args) {

        var ctorTests = new CtorTests();

        try {
            ctorTests.doSomething();
        } catch (NullPointerException e) {

            throw new MyException("Test", e);

        }


    }


    public void doSomething() {
        throw new NullPointerException();
    }
}
