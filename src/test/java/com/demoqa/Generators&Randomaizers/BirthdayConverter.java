package com.demoqa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BirthdayConverter {
    private static final String SHORT_NAME_PATTERN = "dd MMM yyyy";
    private static final String FULL_NAME_PATTERN = "dd MMMM,yyyy";
    private static final Locale LOCALE_ENG = Locale.ENGLISH;

    public static String convertToFullMonthName(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(SHORT_NAME_PATTERN,
                LOCALE_ENG));
        return format(localDate, FULL_NAME_PATTERN);
    }

    public static String convertToShortMonthName() {
        return format(DateRandomizer.randomDate(),
                SHORT_NAME_PATTERN);
    }

    private static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern,
                LOCALE_ENG));
    }
}