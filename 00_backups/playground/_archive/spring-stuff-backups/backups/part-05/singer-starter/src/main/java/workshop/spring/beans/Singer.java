package workshop.spring.beans;

import workshop.performer.Performer;

public class Singer implements Performer {

    @Override
    public void doSomething() {
        System.out.println("I am a Celine Dion on steroids.");
    }
}
