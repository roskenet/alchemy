package felix.demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Athens", "Berlin", "Chicago", "Dublin", "Windhoek");

        var min = list.stream().map(String::length).max(Comparator.naturalOrder());

        System.out.println(min.get());
    }

}
