package de.roskenet.kata;

public class FunWithUnicode {

    public static void main(String[] args) {
        String hearts = "\uD83D\uDC95";

//        for (char ch : hearts.toCharArray()) {
//            System.out.println(ch);
//        }

//        System.out.println(hearts);

        var i1 = hearts.codePointAt(0);
        var i2 = hearts.codePointAt(1);

        var chars = Character.toChars(i1);

        System.out.println(chars);
    }
}
