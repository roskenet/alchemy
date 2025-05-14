package workshop.spring;

public class Party {

    private Performer performer;

    Party(Performer performer) {
        this.performer = performer;
    }

    public String start() {
       return performer.doSomething();
    }

}
