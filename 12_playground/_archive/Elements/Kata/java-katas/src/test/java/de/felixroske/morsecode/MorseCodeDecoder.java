package de.felixroske.morsecode;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        var builder = new StringBuilder();
        var words = morseCode.trim().split("   ");// We split for words

        for (String word : words) {
            var letters = word.split(" ");
            for (String letter: letters) {
// Commented out, to make it compile here.
//            builder.append(MorseCode.get(letter.trim()));
            }
            builder.append(' ');
        }

        return builder.toString().trim();
    }
}
