package de.roskenet.kata;

import java.time.LocalDate;

public class MonthDetails {

    // Show number of days for this month (1-based) in the current year.
    public static void main(String[] args) {
        int input = 5;

        var lengthOfMonth = LocalDate.of(2023, input, 1).lengthOfMonth();

        System.out.println(String.format("Month #%d has %d days.", input, lengthOfMonth));
    }
}
