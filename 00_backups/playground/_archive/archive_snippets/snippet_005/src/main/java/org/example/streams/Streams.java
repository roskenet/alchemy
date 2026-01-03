package org.example.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.util.Pair;

public class Streams {

    public static void main(String[] args) {
        streamExampl2();
    }

    private static void streamExampl2() {
        List<Integer> dividers = Arrays.asList(2, 3, 5);
        List<Integer> integerList = Arrays.asList(4, 10, 20, 15);

        Double collect = integerList.stream().collect(Collectors.averagingInt(value -> value));

        System.out.println("AveragingInt: " + collect);
    }

    public static void streamExampl1(String[] args) {
        var pair1 = new Pair<>(MealType.OBST, "Ananas");
        var pair2 = new Pair<>(MealType.OBST, "Kiwi");
        var pair3 = new Pair<>(MealType.PILZE, "Champignongs");
        var pair4 = new Pair<>(MealType.GEMUESE, "Avocado");
        var pair5 = new Pair<>(MealType.GEMUESE, "Tomate");

        List<Pair<MealType, String>> theList = Arrays.asList(pair1, pair2, pair3, pair4, pair5);

        Map<MealType, List<Pair<MealType, String>>> collect = theList.stream().collect(Collectors.groupingBy(Pair::getKey, Collectors.toList()));

        List<Pair<MealType, String>> theResult= collect.getOrDefault(MealType.GEMUESE, Collections.EMPTY_LIST);

        theResult.stream().map(Pair::getValue).forEach(System.out::println);

    }

}
