package com.demoqa;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DateRandomizer {
    public static LocalDate randomDate() {
        int day = randomValue(1, 25);
        int month = randomValue(1, 12);
        int year = randomValue(2000, 2020);
        return LocalDate.of(year, month, day);
    }

    private static int randomValue(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }
}
