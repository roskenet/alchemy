package de.roskenet.sudoku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuTest {

    @Test
    void testSomething() {
        Sudoku theSudoku = Sudoku.of(unfinishedSudoku);
        System.out.println(theSudoku);

        assertThat(true).isTrue();
    }

    @Test
    void testIsSolved() {
       Sudoku theSudoku = Sudoku.of(solvedSudoku);
       boolean result = theSudoku.isSolved();
       assertThat(result).isTrue();
    }

    @Test
    void testIsUnsolved() {
        Sudoku theSudoku = Sudoku.of(unsolvedSudoku);
        boolean result = theSudoku.isSolved();
        assertThat(result).isFalse();
    }
    @Test
    void testIsUnfinished() {
        Sudoku theSudoku = Sudoku.of(unfinishedSudoku);
        boolean result = theSudoku.isSolved();
        assertThat(result).isFalse();
    }

    int [][] solvedSudoku = new int[][] {
            {4,9,3,6,1,2,8,5,7},
            {1,8,6,7,5,3,4,9,2},
            {2,5,7,8,9,4,6,3,1},
            {3,7,4,2,6,8,9,1,5},
            {6,2,9,1,4,5,7,8,3},
            {8,1,5,3,7,9,2,6,4},
            {9,3,2,4,8,1,5,7,6},
            {7,4,8,5,3,6,1,2,9},
            {5,6,1,9,2,7,3,4,8}
    };

    int [][] unsolvedSudoku = new int[][] {
            {4,9,3,6,1,2,8,5,7},
            {4,8,6,7,5,3,1,9,2},
            {2,5,7,8,9,4,6,3,1},
            {3,7,4,2,6,8,9,1,5},
            {6,2,9,1,4,5,7,8,3},
            {8,1,5,3,7,9,2,6,4},
            {9,3,2,4,8,1,5,7,6},
            {7,4,8,5,3,6,1,2,9},
            {5,6,1,9,2,7,3,4,8}
    };

    int [][] unfinishedSudoku = new int[][] {
            {4,0,3,6,1,2,8,5,7},
            {1,8,6,7,5,3,4,9,2},
            {2,5,7,8,9,4,6,3,1},
            {3,7,4,2,6,8,9,1,5},
            {6,0,9,1,4,5,7,0,3},
            {8,1,5,3,7,9,2,6,4},
            {9,3,2,4,8,1,5,7,6},
            {7,4,8,5,3,6,1,0,9},
            {5,6,1,9,2,0,3,4,8}
    };
}
