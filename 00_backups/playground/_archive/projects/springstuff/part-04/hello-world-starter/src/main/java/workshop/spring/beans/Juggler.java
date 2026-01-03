package workshop.spring.beans;

public class Juggler implements Performer {

    @Override
    public void doSomething() {
        System.out.println("I am juggling with a chainsaw!");
    }
}
