package de.felixroske.firstnonconsecutive;

class FirstNonConsecutive {
    static Integer find(final int[] array) {

        int firstElement = array[0];

        for (int x = 1; x < array.length; ++x) {
            if (array[x] != firstElement + x) {
                return array[x];
            }
        }
        return null;
    }
}
