package kata.armstrongzahlen;

public class Main {

    public static void main(String[] args) {
        System.out.println("Aufgabe 9: Armstrong-Zahlen");

        for(int i1 = 1; i1 < 10; i1++) {
            for(int i2 = 1; i2 < 10; i2++) {
                for(int i3 = 1; i3 < 10; i3++) {

                    int multipl = i1 * 100 + i2 * 10 + i3;
                    int cubics = i1*i1*i1 + i2*i2*i2 + i3*i3*i3;

                    if(multipl == cubics) {
                        System.out.println(String.format("%d%d%d = %d^3 + %d^3 + %d^3", i1, i2, i3, i1, i2, i3));
                    }

                }
            }
        }

    }
}
