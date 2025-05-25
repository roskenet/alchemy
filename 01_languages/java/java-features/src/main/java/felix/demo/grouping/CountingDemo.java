package felix.demo.grouping;

import felix.demo.Artist;
import felix.demo.CommonData;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDemo {

    public static void main(String[] args) {
        var artists = CommonData.getArtists();

        var artistCollection = artists.stream().collect(groupingBy(Artist::isSolo, counting()));

        System.out.println(artistCollection);
    }
}
