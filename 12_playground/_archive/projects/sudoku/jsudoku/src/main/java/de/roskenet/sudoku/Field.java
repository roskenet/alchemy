package de.roskenet.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Field {
    private final int row;
    private final int column;

    private int value = 0;

    private Set<Integer> pencilmarks = new HashSet<>(9);

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
        for (int x=1; x < 10; x++) {
            pencilmarks.add(x);
        }
    }

    public Field(int row, int column, int value) {
        this(row, column);
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value != 0) {
            this.value = value;
            pencilmarks.removeAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
    }
    
    public int strikeMark(int mark) {
       pencilmarks.remove(Integer.valueOf(mark));

       if(pencilmarks.size() == 1) {
           int value = pencilmarks.stream().findFirst().get();
           setValue(value);
       }

       return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
