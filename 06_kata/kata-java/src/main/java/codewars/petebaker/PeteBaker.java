package codewars.petebaker;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {

        // I love this:
// return recipe.entrySet().
// stream()
// .mapToInt(
//    e -> available.getOrDefault(e.getKey(), 0) / e.getValue()
//    ).min()
//    .orElse(0);

        // Classic imperative version:
        var cakes = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            if (available.containsKey(entry.getKey())) {
                int tempValue = available.get(entry.getKey()).intValue() / entry.getValue().intValue();
                if (tempValue < cakes) {
                    cakes = tempValue;
                }
            } else {
               return 0;
            }
        }

        return cakes;
    }

    @Test
    void basicTest() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(2, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

    @Test
    void missingIngredient() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1,
                "cinnamon", 300);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(0, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }
}
