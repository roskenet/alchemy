package language;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class DateAndTime {

    public static void main(String[] args) {

//        printAllZones();
//        playWithTheWorld();

        playWithInstant();
    }

    private static void playWithInstant() {
        var now = Instant.now();
        var duration = Duration.ofSeconds(5);

        var inFiveSeconds = now.plus(duration);
    }

    private static void playWithTheWorld() {
        var parsedDateTime = ZonedDateTime.parse("2023-04-01T19:46:04.123456+02:00");

        System.out.println(String.format("UTC: %s", getLocalTimeIn(parsedDateTime, ZoneId.of("UTC"))));
        System.out.println(String.format("In Berlin ist es dann: %s.", getLocalTimeIn(parsedDateTime, ZoneId.of("Europe/Berlin"))));
        System.out.println(String.format("In London ist es dann: %s.", getLocalTimeIn(parsedDateTime, ZoneId.of("Europe/London"))));
        System.out.println(String.format("In New York ist es dann: %s.", getLocalTimeIn(parsedDateTime, ZoneId.of("America/New_York"))));
        System.out.println(String.format("In San Francisco ist es dann: %s.", getLocalTimeIn(parsedDateTime, ZoneId.of("America/Los_Angeles"))));
    }

    private static void printAllZones() {
        Set<String> zoneIds= ZoneId.getAvailableZoneIds();

        for (String zone : zoneIds) {
            System.out.println(zone);
        }
    }

    private static String getLocalTimeIn(ZonedDateTime zdt, ZoneId id) {
        return zdt.withZoneSameInstant(id).toString();
    }

    private static void playWithDuration() {
        Duration duration = Duration.ofSeconds(5);
    }
}
