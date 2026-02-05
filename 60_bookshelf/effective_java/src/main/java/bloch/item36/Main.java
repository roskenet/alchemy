package bloch.item36;
//Use EnumSet instead of bit fields

import java.util.EnumSet;

enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    static void main() {
        EnumSet<Weekday> weekend = EnumSet.of(Weekday.SATURDAY, Weekday.SUNDAY);

        var someday = Weekday.FRIDAY;

        if(weekend.contains(someday)) {
            System.out.println("Hooray! Weekend!");
        } else {
            System.out.println("Oh, no. Workday!");
        }

    }
}
