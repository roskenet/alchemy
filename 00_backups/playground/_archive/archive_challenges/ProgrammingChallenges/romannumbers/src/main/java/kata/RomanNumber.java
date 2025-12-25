package kata;

public class RomanNumber {

    private RomanNumber() {
    }

    public static String toRomanNumber(int value) {
        if (value == 0)
            return "";
        if (value - 1000 >= 0)
            return "M" + toRomanNumber(value - 1000);
        if (value - 900 >= 0)
            return "CM" + toRomanNumber(value - 900);
        if (value - 500 >= 0)
            return "D" + toRomanNumber(value - 500);
        if (value - 400 >= 0)
            return "CD" + toRomanNumber(value - 400);
        if (value - 100 >= 0)
            return "C" + toRomanNumber(value - 100);
        if (value - 90 >= 0)
            return "XC" + toRomanNumber(value - 90);
        if (value - 50 >= 0)
            return "L" + toRomanNumber(value - 50);
        if (value - 40 >= 0)
            return "XL" + toRomanNumber(value - 40);
        if (value - 10 >= 0)
            return "X" + toRomanNumber(value - 10);
        if (value - 9 >= 0)
            return "IX" + toRomanNumber(value - 9);
        if (value - 5 >= 0)
            return "V" + toRomanNumber(value - 5);
        if (value - 4 >= 0)
            return "IV" + toRomanNumber(value - 4);
        if (value - 1 >= 0)
            return "I" + toRomanNumber(value - 1);
        return "";
    }

    public static int fromRomanNumber(String number) {
        if (number.length() == 0)
                return 0;
        if (number.startsWith("CM"))
            return 900 + fromRomanNumber(number.substring(2));
        if (number.startsWith("M"))
           return 1000 + fromRomanNumber(number.substring(1));
        if (number.startsWith("CD"))
            return 400 + fromRomanNumber(number.substring(2));
        if (number.startsWith("D"))
            return 500 + fromRomanNumber(number.substring(1));
        if (number.startsWith("XC"))
            return 90 + fromRomanNumber(number.substring(2));
        if (number.startsWith("C"))
            return 100 + fromRomanNumber(number.substring(1));
        if (number.startsWith("XL"))
            return 40 + fromRomanNumber(number.substring(2));
        if (number.startsWith("L"))
            return 50 + fromRomanNumber(number.substring(1));
        if (number.startsWith("IX"))
            return 9 + fromRomanNumber(number.substring(2));
        if (number.startsWith("X"))
            return 10 + fromRomanNumber(number.substring(1));
        if (number.startsWith("IV"))
            return 4 + fromRomanNumber(number.substring(2));
        if (number.startsWith("V"))
            return 5 + fromRomanNumber(number.substring(1));
        if (number.startsWith("I"))
            return 1 + fromRomanNumber(number.substring(1));
        throw new IllegalArgumentException("Illegal input: " + number);
    }
}
