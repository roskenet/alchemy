package workshop.spring.beans;

import workshop.performer.Performer;

public class Juggler implements Performer {

    @Override
    public void doSomething() {
        System.out.println("I am a Juggler with three chainsaws.");
    }
}
