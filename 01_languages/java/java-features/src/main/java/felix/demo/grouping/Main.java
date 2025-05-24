package felix.demo.grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Show grouping from a stream");

        Artist michaelJackson= new Artist("Michael Jackson", true);
        Artist theBeatles = new Artist("The Beatles", false);
        Artist fleetwoodMac= new Artist("Fleetwood Mac", false);

        ArrayList<Artist> artists = new ArrayList<>(Arrays.asList(michaelJackson, theBeatles, fleetwoodMac));

        Map<Boolean, List<Artist>> artistByIsSolo = artists.stream().collect(Collectors.groupingBy(Artist::isSolo));

        artistByIsSolo.forEach((solo, artistList) -> {
            System.out.println("Solo: " + solo);
            artistList.forEach(artist -> System.out.println(artist.name()));
        });
    }
}