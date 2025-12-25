package kata;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class NumberPlayground {

    public static boolean isBinaryNumber(String num) {

        CharacterIterator iterator = new StringCharacterIterator(num);
        while (iterator.current() != CharacterIterator.DONE) {
            if (!(iterator.current() == '0' ||
                  iterator.current() == '1')) {
                return false;
            }
            iterator.next();
        }

        return true;
    }


    public static int binaryToDecimal(String num) {
        int result = 0;

        for (int x=0; x < num.length(); x++) {
            result += Character.getNumericValue(num.charAt(x)) * Math.pow(2, num.length()-x-1);
        }

        return result;
    }

    public static int hexToDecimal(String hexValue) {
        int result = 0;

        for (int x = 0; x < hexValue.length(); x++) {
//            result += Character.getNumericValue(num.charAt(x)) * Math.pow(2, num.length()-x-1);
            result += (Character.valueOf(hexValue.charAt(x)) - 55) * Math.pow(16, hexValue.length() - x - 1);
        }

        return result;
    }
}
