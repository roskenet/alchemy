package felix.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReducerDemo {
    static void main(String[] args) {
        List<String> majorMarathons = Arrays.asList("Berlin", "Tokyo", "New York", "Boston", "Chicao", "Sydney", "Cape Town");

        String collect = majorMarathons.stream().collect(Collectors.joining(", "));
    }
}
