package workshop.spring.beans;

public class Juggler implements Performer {
    @Override
    public String doSomething() {
        return "I am juggling with three swords!";
    }
}
