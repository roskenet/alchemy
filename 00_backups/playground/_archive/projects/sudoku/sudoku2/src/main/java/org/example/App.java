package org.example;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello Sudoku Lover!" );

        Sudoku thePuzzle = new Sudoku(puzzle);

        System.out.println(thePuzzle);
    }

    private static int [][] puzzle = new int[][] {
            {0,0,0,5,0,0,0,0,6},
            {0,7,6,4,0,0,1,0,0},
            {0,8,1,0,0,6,0,3,0},
            {0,0,0,0,5,0,0,9,0},
            {0,0,5,8,0,1,4,0,0},
            {0,9,0,0,3,0,0,0,0},
            {0,2,0,3,0,0,8,6,0},
            {0,0,3,0,0,2,9,4,0},
            {7,0,0,0,0,8,0,0,0}
    };

}
