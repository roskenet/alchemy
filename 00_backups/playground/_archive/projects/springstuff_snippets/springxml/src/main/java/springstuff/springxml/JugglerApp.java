package springstuff.springxml;


import springstuff.jugglers.Juggler;

public class JugglerApp implements TheApp {

    private final Juggler juggler;

    public JugglerApp(Juggler juggler) {
        this.juggler = juggler;
    }

    @Override
    public void doSomething() {
        System.out.println(juggler.perform());
    }

}
