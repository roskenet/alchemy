package springstuff.tradjugglerapp;

import springstuff.jugglers.BallJuggler;
import springstuff.jugglers.Juggler;

/**
 * Juggler App
 * Traditional Style
 */
public class Main {
    public static void main(String[] args) {
        var jugglerApp = new JugglerApp(new BallJuggler());
        jugglerApp.doSomething();
    }
}
