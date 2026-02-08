package felix.demo.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        // Array sizes are fixed

        String[] cities = new String[]{"Athens", "London", "Paris", "Tokyo"};
        cities[0] = "Berlin";

        List<String> list = Arrays.asList(cities);

        // Copy arrays:
        String[] newCityArray = Arrays.copyOf(cities, 422);
        newCityArray[112] = "Madrid";

        System.out.println(newCityArray);

        Function<String, String> upperCase = String::toUpperCase;
        doSomething(cities, upperCase);
    }

    public static String[] doSomething(String[] array, Function<String, String> function) {
        return Arrays.stream(array).map(function).toArray(String[]::new);
    }
}
