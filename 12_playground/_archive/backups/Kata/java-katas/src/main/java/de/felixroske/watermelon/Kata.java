package de.felixroske.watermelon;

public class Kata {
    public static boolean divide(int weight) {

        if(weight <= 2) {
            return false;
        }

        return weight %2 == 0;
    }
}
