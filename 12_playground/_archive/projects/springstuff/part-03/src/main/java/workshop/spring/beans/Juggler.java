package workshop.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer {
    @Override
    public void doSomething() {
        System.out.println("I am juggling with three swords!");
    }
}
