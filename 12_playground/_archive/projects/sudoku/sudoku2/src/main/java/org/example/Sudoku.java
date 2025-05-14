package org.example;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    private Field[][] puzzle = new Field[9][9];

    public Sudoku() {
        for(int row=0; row < 9; row++) {
            for(int column=0; column < 9; column++) {
               puzzle[row][column] = new Field(row, column, this);
            }
        }
    }

    public Sudoku(int[][] initial) {
       this();

        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                setField(y, x, initial[y][x]);
            }
        }
    }

    public boolean setField(int row, int column, int value) {
       puzzle[row][column].setValue(value);
       if (isSolved())
           return true;

       for(int r=0;  r < 9; r++) {
           for(int c=0; c < 9; c++) {
               if(puzzle[r][c].getValue() == 0) {
                  puzzle[r][c].checkForOnlyOnePossibleValueInBox(getBox(r, c));
                  puzzle[r][c].checkForOnlyOnePossibleValueInBox(getRow(r));
                  puzzle[r][c].checkForOnlyOnePossibleValueInBox(getColumn(c));
               }
           }
       }


       return false;
    }

    public Field[] getFriendsFor(int row, int column) {
        Field[] updateables = new Field[27];
        for(int idx=0; idx < 9; idx++) {
            updateables[idx] = getRow(row)[idx];
        }
        for(int idx=0; idx < 9; idx++) {
            updateables[idx+9] = getColumn(column)[idx];
        }
        for(int idx=0; idx < 9; idx++) {
            updateables[idx+18] = getBox(row, column)[idx];
        }
        return updateables;
    }

    public Field[] getRow(int idx) {
        return puzzle[idx];
    }

    public Field[] getColumn(int idx) {
        var updateables = new Field[9];
        for(int row=0; row < 9 ; row++) {
            updateables[row] = puzzle[row][idx];
        }
        return updateables;
    }

    public Field[] getBox(int row, int column) {
       int centerColumn;
       int centerRow;

       centerColumn = findMiddleField(column);
       centerRow = findMiddleField(row);

        var updateables = new Field[9];
        updateables[0] = puzzle[centerRow-1][centerColumn-1];
        updateables[1] = puzzle[centerRow-1][centerColumn];
        updateables[2] = puzzle[centerRow-1][centerColumn+1];

        updateables[3] = puzzle[centerRow][centerColumn-1];
        updateables[4] = puzzle[centerRow][centerColumn];
        updateables[5] = puzzle[centerRow][centerColumn+1];

        updateables[6] = puzzle[centerRow+1][centerColumn-1];
        updateables[7] = puzzle[centerRow+1][centerColumn];
        updateables[8] = puzzle[centerRow+1][centerColumn+1];

        return updateables;
    }

    private static int findMiddleField(int idx) {
        int center;
        if(idx == 0 || idx == 1 || idx == 2)
            return 1;
        if(idx == 3 || idx == 4 || idx == 5)
            return 4;
        if(idx == 6 || idx == 7 || idx == 8)
            return 7;
        throw new IllegalStateException("No center for idx [" + idx + "]");
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
                vertRow[y] = puzzle[y][x];
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
                strBuilder.append(puzzle[y][x].getValue());
            }
            strBuilder.append('\n');
        }
        return strBuilder.toString();
    }
}
