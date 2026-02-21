package felix.demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Athens", "Berlin", "Bern", "Chicago", "Dublin", "Windhoek");

        Map<Character, List<String>> cities = list.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.groupingBy(x -> x.toUpperCase().charAt(0)));

//        var min = list.stream().map(String::length).max(Comparator.naturalOrder());

        System.out.println(cities.get('B').stream().collect(Collectors.joining(", ")));
    }

}
