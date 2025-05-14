package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public final class Field implements Updateable {
    private final Set<Integer> marks;

    private int value;
    private final int row;
    private final int column;

    private final Sudoku puzzle;

    public Field(int row, int column, Sudoku puzzle) {
        value = 0;
        marks = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.row = row;
        this.column = column;
        this.puzzle = puzzle;
    }

    public Set<Integer> getMarks() {
        return marks;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value != 0) {
            this.value = value;
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(marks::remove);
            updateFriends(value);
        }
    }

    public void checkForOnlyOnePossibleValueInBox(Field[] box) {
        if (marks.size() > 1) {

            Optional<Integer> onlyInThisMarksList = Optional.empty();

            for (Integer mark : marks) {
                boolean foundIt = false;

                for (Field boxField : box) {
                    if (boxField != this) {
                        if (boxField.marks.contains(mark) || boxField.getValue() == mark) {
                            foundIt = true;
                            break;
                        }
                    }
                }
                if (!foundIt) {
                  onlyInThisMarksList = Optional.of(mark);
                  break;
            }
        }

            onlyInThisMarksList.ifPresent(this::setValue);
    }

}

    @Override
    public void removeMark(int mark) {
        marks.remove(mark);
        if (marks.size() == 1) {
            setValue(marks.stream().findFirst().get());
        }
        var boxFields = puzzle.getBox(row, column);
        checkForOnlyOnePossibleValueInBox(boxFields);

        var rowFields = puzzle.getRow(row);
        checkForOnlyOnePossibleValueInBox(rowFields);

        var columnFields = puzzle.getColumn(column);
        checkForOnlyOnePossibleValueInBox(columnFields);

    }

    private void updateFriends(int mark) {
        for (Field friend : puzzle.getFriendsFor(row, column)) {
            if (friend != this)
                friend.removeMark(mark);
        }
    }
}
