package de.roskenet.sudoku;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Naive Sudoku playground
 */
public class Sudoku {

    private Field[][] puzzle = new Field[9][9];
    private Sudoku() {}

    public static Sudoku of(int[][] input) {
        var sudoku = Sudoku.empty();

        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                sudoku = sudoku.setFieldValue(y, x, input[y][x]);
            }
        }
        return sudoku;
    }

    public static Sudoku empty() {
        var sudoku = new Sudoku();
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                sudoku.puzzle[y][x] = new Field(y, x, 0);
            }
        }
        return sudoku;
    }

    private Sudoku setFieldValue(int row, int column, int value) {
        assertArguments(row, column, value);

        setValue(row, column, value);

        return this;
    }

    private void setValue(int row, int column, int value) {
        puzzle[row][column].setValue(value);
        removeAllMarksFromRow(row, value);
        removeAllMarksFromColumn(column, value);
    }

    private void removeAllMarksFromRow(int row, int value) {
       for (Field field : puzzle[row]) {
           var result = field.strikeMark(value);
           if(result != 0) {
              setValue(field.getRow(), field.getColumn(), field.getValue());
           }
       }
    }

   private void removeAllMarksFromColumn(int column, int value) {
       for(int row=0; row < 9 ; row++) {
           var result = puzzle[row][column].strikeMark(value);
           if (result != 0) {
               setValue(row, column, value);
           }
       }
   }

    public int solve() {
        var start = Instant.now();

        var end = Instant.now();
        return end.getNano()-start.getNano();
    }

    private void assertArguments(int x, int y, int value) {
        if(x < 0 || x > 9) {
            throw new IllegalArgumentException(String.format("x is [%d]", x));
        }
        if(y < 0 || y > 9) {
            throw new IllegalArgumentException(String.format("y is [%d]", y));
        }
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException(String.format("value is [%d]", value));
        }
    }

    public boolean isSolved() {
        for (Field[] horizRow: puzzle) {
            if(!isRowComplete(horizRow)) {
                return false;
            }
        }

        for(int x = 0; x < 9; x++) {
            Field[] vertRow = new Field[9];
            for (int y = 0; y < 9; y++) {
                vertRow[y] = new Field(y, x, puzzle[y][x].getValue());
            }
            if(!isRowComplete(vertRow)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isRowComplete(Field[] row) {
        Set<Integer> set = new HashSet<>();
        for (Field f : row) {
            if(f.getValue() == 0) {
                return false;
            }
            if(f.getValue() < 0 || f.getValue() > 9) {
                throw new IllegalStateException("The puzzle is in a incorrect state.");
            }
            set.add(f.getValue());
        }

        if (set.stream().count() != 9) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder();
        for (int y=0; y < 9; y++) {
            for (int x=0; x < 9; x++) {
                strBuilder.append(puzzle[y][x]);
            }
            strBuilder.append('\n');
        }
        return strBuilder.toString();
    }
}
