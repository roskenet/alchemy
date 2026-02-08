package felix.demo.datetime;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        Clock clock = Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneId.of("Europe/Berlin"));

        LocalDate now = LocalDate.now(clock);
        now.isLeapYear();

        System.out.println(now);

        Year year1974 = Year.of(1974);
        year1974.isLeap();
    }
}
