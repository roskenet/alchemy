package de.felixroske.charcount;

import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Map<Character, Integer> characters = CharacterCounter.countCharacters("Hallo Welt!");
    }
}
