package de.roskenet.sudoku;

public class Sudoku {

    private int[][] field;

    public Sudoku() {
        field = new int[9][9];
    }
    public Sudoku(int[][] sudoku) {
       field = sudoku;
    }
}
