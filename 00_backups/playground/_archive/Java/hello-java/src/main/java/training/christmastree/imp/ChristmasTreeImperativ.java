package training.christmastree.imp;

public class ChristmasTreeImperativ {

    public static void main(String[] args) {
        int height = 5;

        for (int x = 1; x <= height; x++) {
            System.out.println(drawLine(height, x));
        }
    }

    private static String drawLine(int height, int lineNumber) {

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

//   *          h 4: l 1:     3 _ 1
//  ***         h 4: l 2:     2 _ 3
// *****        h 4: l 3:     1 _ 5
//*******       h 4: l 4:     0 _ 7