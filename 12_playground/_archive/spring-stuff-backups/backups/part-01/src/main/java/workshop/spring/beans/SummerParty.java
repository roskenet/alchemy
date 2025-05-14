package workshop.spring.beans;

public class SummerParty implements Party {

    private Performer performer;

    public SummerParty(Performer performer) {
        this.performer = performer;
    }

    @Override
    public String start() {
        return performer.doSomething();
    }
}
