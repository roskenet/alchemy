package springstuff.tradjugglerapp;

import springstuff.jugglers.Juggler;

public class JugglerApp {
    private final Juggler juggler;

    public JugglerApp(Juggler juggler) {
        this.juggler = juggler;
    }

    public void doSomething() {
        System.out.println(juggler.perform());
    }
}
