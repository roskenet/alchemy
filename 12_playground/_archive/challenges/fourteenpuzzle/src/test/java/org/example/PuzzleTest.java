package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PuzzleTest {

    @Test
    void testIsSolved() {
       int[][] configuration = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

       boolean result = Puzzle.isSolved(configuration);

       assertThat(result).isTrue();
    }

    @Test
    void testIsNotSolved() {
        int[][] configuration = { {4, 2, 3, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 1}};

        boolean result = Puzzle.isSolved(configuration);

        assertThat(result).isFalse();

    }

    @Test
    void testIsSolved_null() {
       assertThatThrownBy(() ->
               Puzzle.isSolved(null)
       ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testIsSolved_without0() {
        int[][] configuration = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        assertThatThrownBy(() ->
                Puzzle.isSolved(configuration)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
