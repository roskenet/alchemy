package org.example;

public class Puzzle {

    /**
     * Returns whether the puzzle is solved.
     *
     * @param configuration
     * @return true if the integer matrix is ascending from
     *         top left to bottom right with the 0 as the last field.
     *         else false
     * @throws IllegalArgumentException if the configuration is {@code null} or not valid at all.
     */
    public static boolean isSolved(int[][] configuration) {
        if(configuration == null) {
            throw new IllegalArgumentException("Configuration must not be null.");
        }

        for (int y=0; y < configuration.length; y++) {
           for (int x=0; x < configuration[y].length; x++) {
               // We are still here and the bottom right field is 0:
               if(y == configuration.length-1 && x == configuration[y].length-1) {
                   if (configuration[y][x] == 0) return true;
               }
               if(!(configuration[y][x] == y * configuration.length + x+1)) {
                  return false;
               }
           }
        }
        throw new IllegalArgumentException("Configuration without 0");
    }
}
