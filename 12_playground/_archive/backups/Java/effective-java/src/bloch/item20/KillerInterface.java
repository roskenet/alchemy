package bloch.item20;

public interface KillerInterface {

    void doSomething();

    default void doSomethingElse() {
        System.out.println("This is the default.");
    }
}
