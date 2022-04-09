package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.PhoneNumberHelper.extractPhoneWithoutCountryCode;
import static java.lang.String.format;


public class AutomationRegistrationFormObjectsPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            currentAdress = faker.address().streetAddress();
    String phone = TestDataGenerator.phoneNumber(new Locale("ru"));
    String email = TestDataGenerator.email(Locale.ENGLISH);
    String phoneNumber = extractPhoneWithoutCountryCode(phone);
    String birthday = BirthdayConverter.convertToShortMonthName();
    String hobbies = ("History");

    String expectedFullName = format("%s %s" , firstName, lastName);

    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void succesfullTest () {
        new RegistrationFormPage().openPage();
        new RegistrationFormPage().setFirstName(firstName);
        new RegistrationFormPage().setlastName(lastName);
        new RegistrationFormPage().setEmail(email);
        new RegistrationFormPage().setClick();
        new RegistrationFormPage().setNumber(phoneNumber);
        new RegistrationFormPage().dobleClick();
        new RegistrationFormPage().dateControl();
        new RegistrationFormPage().dateSpace();
        new RegistrationFormPage().setBirthday(birthday);
        new RegistrationFormPage().setHobbies(hobbies);
        new RegistrationFormPage().setHobbiesClick();
        new RegistrationFormPage().uploadImg();
        new RegistrationFormPage().setCurrentAdress(currentAdress);
        new RegistrationFormPage().stateClick();
        new RegistrationFormPage().setValueState();
        new RegistrationFormPage().setCity();
        new RegistrationFormPage().submitClick();

        new RegistrationFormPage().setShouldHaveText();
        new RegistrationFormPage().setResults(firstName,lastName,email,phoneNumber,currentAdress,birthday,hobbies);
    }
}