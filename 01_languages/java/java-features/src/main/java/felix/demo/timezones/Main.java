package felix.demo.timezones;

import com.ibm.icu.util.TimeZone;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String countryCode = "PL";

        final String[] icuTimezones = TimeZone.getAvailableIDs(countryCode);
        Set<String> javaTimezones = ZoneId.getAvailableZoneIds();

        var timezones = Arrays.stream(icuTimezones)
                .filter(javaTimezones::contains)
                .collect(Collectors.toList());

        if (timezones.isEmpty()) {
            System.err.println("No compatible timezones found for " + countryCode);
            return;
        }

        var localDate = OffsetDateTime.now()
                .atZoneSameInstant(ZoneId.of(timezones.get(0))).toLocalDate();

        System.out.println("The date in " + countryCode + " is: " + localDate);


    }
}
