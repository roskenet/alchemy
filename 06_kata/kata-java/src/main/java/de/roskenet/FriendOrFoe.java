package de.roskenet;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendOrFoe {

    public static List<String> friend(List<String> x) {

        return x.stream().filter(v -> v.length() == 4).collect(Collectors.toList());
    }

    @Test
    void testFriend() {
        assertEquals(List.of("Ryan", "Yous"), FriendOrFoe.friend(List.of("Ryan", "Kieran", "Jason", "Yous")), "Input: [\"Ryan\", \"Kieran\", \"Jason\", \"Yous\"]");
        assertEquals(List.of(), FriendOrFoe.friend(List.of("Peter", "Stephen", "Joe")), "Input: [\"Peter\", \"Stephen\", \"Joe\"]");
    }

}
