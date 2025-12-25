package workshop.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class SummerParty implements Party {

    private Performer performer;

    public SummerParty(Performer performer) {
        this.performer = performer;
    }

    @Override
    public void start() {
        performer.doSomething();
    }
}
