package felix.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonData {

    public static List<Artist> getArtists() {

        Artist michaelJackson= new Artist("Michael Jackson", true);
        Artist theBeatles = new Artist("The Beatles", false);
        Artist fleetwoodMac= new Artist("Fleetwood Mac", false);

        return new ArrayList<>(Arrays.asList(michaelJackson, theBeatles, fleetwoodMac));
    }
}
