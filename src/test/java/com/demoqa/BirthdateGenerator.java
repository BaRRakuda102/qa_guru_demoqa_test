package com.demoqa;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class BirthdateGenerator {

    public static String birthdate() {
        return randomValue(10, 25) + " " +
                monthName(LocalDate.now()) + " " +
                randomValue(2000, 2015);
    }

    private static int randomValue(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    private static String monthName(LocalDate date) {
        return date.getMonth()
                .getDisplayName(
                        TextStyle.SHORT,
                        new Locale("en_US")
                );
    }
}