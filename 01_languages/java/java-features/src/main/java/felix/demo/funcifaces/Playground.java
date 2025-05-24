package felix.demo.funcifaces;

import felix.demo.Artist;
import felix.demo.CommonData;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Playground {

    public static void main(String[] args) {

        var artists = CommonData.getArtists();

        // Cool functional style: parameterize our method call here
        filterSomething(artists,
                a -> a.name().startsWith("M"))
                .forEach(System.out::println);
    }

    private static List<String> filterSomething(List<Artist> theList, Predicate<Artist> predicate) {
        return theList.stream().filter(predicate).map(Artist::toString).collect(Collectors.toList());
    }
}
