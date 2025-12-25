public class AlgUndData {

    public static int numDivisions(int value) {
       int counter = 0;
       while (value % 5 == 0) {
           value /= 5;
           counter++;
       }
       return counter;
    }

    public static void main(String[] args) {
        int value = 23;
        System.out.println("Fuer " + value + " ist das Ergebnis: " + AlgUndData.numDivisions(value));
    }

}
