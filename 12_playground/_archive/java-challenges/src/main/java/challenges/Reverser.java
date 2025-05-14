package challenges;

public class Reverser {

    public static String reverseLetters(String inputString) {
        var tokens = inputString.split("\\s+");

        StringBuilder stringBuilder = new StringBuilder();

        for (String token : tokens) {
            var reverseToken = reverse(token);
            stringBuilder.append(reverseToken).append(' ');
        }

        return stringBuilder.toString().trim();
    }

    private static String reverse(String input) {
        if(input.length() == 1) {
            return input;
        }

        return  reverse(input.substring(1, input.length())) + input.substring(0,1);
    }

    public static String reverseWordsAndLetters(String inputString) {
        return reverse(inputString);
    }
}
