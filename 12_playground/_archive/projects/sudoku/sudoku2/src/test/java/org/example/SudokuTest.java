package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuTest {


    @Test
    void testIsSolved() {
        Sudoku theSudoku = new Sudoku(solvedSudoku);
        boolean result = theSudoku.isSolved();
        assertThat(result).isTrue();
    }

    @Test
    void testIsUnsolved() {
        Sudoku theSudoku = new Sudoku(unsolvedSudoku);
        boolean result = theSudoku.isSolved();
        assertThat(result).isFalse();
    }
    @Test
    void testIsUnfinished() {
        // Can be finished!
        Sudoku theSudoku = new Sudoku(unfinishedSudoku);
//        theSudoku.setField(0,7,1);

        boolean result = theSudoku.isSolved();

        System.out.println(theSudoku);
        assertThat(result).isTrue();
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
            {4,0,0,6,0,0,0,0,3},
            {0,0,3,1,0,0,0,0,0},
            {1,5,0,0,9,3,0,0,0},
            {6,0,4,7,0,0,5,0,2},
            {0,0,2,5,0,4,1,0,0},
            {7,0,5,0,0,6,3,0,9},
            {0,0,0,9,5,0,0,2,8},
            {0,0,0,0,0,2,6,0,0},
            {2,0,0,0,0,1,0,0,5}
    };
}
