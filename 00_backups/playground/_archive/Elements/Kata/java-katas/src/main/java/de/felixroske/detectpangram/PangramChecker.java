package de.felixroske.detectpangram;

/*
# DetectPangram

A pangram is a sentence that contains every single letter of the alphabet at
least once. For example, the sentence "The quick brown fox jumps over the lazy dog"
is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not.
Ignore numbers and punctuation.
 */

import java.util.HashSet;

public class PangramChecker {
    public boolean check(String sentence){
        var characters = new HashSet<Character>();

        for (Character letter : sentence.toLowerCase().toCharArray()) {
            if(Character.isAlphabetic(letter)) {
                characters.add(letter);
            }
        }

        return characters.size() == 26;
    }
}

/*
public class PangramChecker {
  public boolean check(String sentence){
    return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
  }
}
 */