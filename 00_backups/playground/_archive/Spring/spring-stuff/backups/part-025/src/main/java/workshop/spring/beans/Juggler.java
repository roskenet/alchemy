package workshop.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer {
    @Override
    public String doSomething() {
        return "I am juggling with three swords!";
    }
}
