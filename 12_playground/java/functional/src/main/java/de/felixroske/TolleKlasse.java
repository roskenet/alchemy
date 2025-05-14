package de.felixroske;

public class TolleKlasse {

    public StringProvider provideSomething(String anotherString) {
        return (y) -> String.valueOf(anotherString);
    }

}
