package felix.demo.grouping;

import felix.demo.Artist;
import felix.demo.CommonData;

import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {
        System.out.println("Show grouping from a stream");

        var artists = CommonData.getArtists();

        var artistByIsSolo = artists.stream()
                .collect(Collectors.groupingBy(Artist::isSolo));

        artistByIsSolo.forEach((solo, artistList) -> {
            System.out.println("Solo: " + solo);
            artistList.forEach(artist -> System.out.println(artist.name()));
        });
    }
}