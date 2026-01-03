package challenges;

public class DigitTester {

    public static boolean test(String input) {

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
