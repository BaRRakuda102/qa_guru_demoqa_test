package com.demoqa;

import com.github.javafaker.Faker;

import java.util.Locale;




public class TestDataGenerator {

    public static String birthday(Locale locale) {
        return faker(locale).date().birthday().toString();
    }

    public static String email(Locale locale) {
        return faker(locale).internet().emailAddress();
    }

    public static String phoneNumber(Locale locale) {
        return faker(locale).phoneNumber().phoneNumber();
    }


    private static Faker faker(Locale locale) {
        return new Faker(locale);
    }
}