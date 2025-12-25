package workshop.spring.party;

import org.springframework.stereotype.Component;

@Component
public class Magician implements Performer {
    @Override
    public void doSomething() {
        System.out.println("I do some MaGiC!");
    }
}
