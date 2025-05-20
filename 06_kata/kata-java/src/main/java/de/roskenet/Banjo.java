package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a function which answers the question "Are you playing banjo?".
//If your name starts with the letter "R" or lower case "r", you are playing banjo!
//
//The function takes a name as its only argument, and returns one of the following strings:
//
//name + " plays banjo"
//name + " does not play banjo"
//
//Names given are always valid strings.

public class Banjo {

  private static String areYouPlayingBanjo(String name) {
    if (name.toLowerCase().startsWith("r")) {
      return name + " plays banjo";
    }
    else {
      return name + " does not play banjo";
    }
  }

  @Test
  public void PeopleThatPlayBanjo() {
    assertEquals( "Martin does not play banjo", Banjo.areYouPlayingBanjo("Martin"));
    assertEquals( "Rikke plays banjo", Banjo.areYouPlayingBanjo("Rikke"));
    assertEquals( "rolf plays banjo", Banjo.areYouPlayingBanjo("rolf"));
    assertEquals( "bravo does not play banjo", Banjo.areYouPlayingBanjo("bravo"));
  }

}
