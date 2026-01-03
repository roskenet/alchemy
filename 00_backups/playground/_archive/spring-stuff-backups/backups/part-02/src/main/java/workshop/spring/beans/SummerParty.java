package workshop.spring.beans;

import java.util.Locale;

public class SummerParty implements Party {

    private Performer performer;

    public SummerParty(Performer performer) {
        this.performer = performer;
    }

    @Override
    public String start() {
        return performer.doSomething().toUpperCase(Locale.US);
    }
}
