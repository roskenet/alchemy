package de.roskenet.christmastree;

public class StringChristmasTreeNursery implements ChristmasTreeNursery {

    @Override
    public String tree(int height) {
        if (height < 4) {
            throw new IllegalArgumentException(String.format("Height %d is too small."));
        }

        StringBuilder tree = new StringBuilder();

        for (int x = 1; x <= height - 1; x++) {
            tree.append(drawTreeLine(height - 1, x)).append("\n");
        }

        // Add the trunk:
        tree.append(drawTreeLine(height - 1, 2));
        return tree.toString();
    }

    private static String drawTreeLine(int height, int lineNumber) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < height - lineNumber; x++) {
            stringBuilder.append(" ");
        }

        for (int x = 1; x < lineNumber * 2; x++) {
            stringBuilder.append("*");
        }

        return stringBuilder.toString();
    }
}
