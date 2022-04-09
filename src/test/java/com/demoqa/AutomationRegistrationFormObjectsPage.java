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
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
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

        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setlastName(lastName)
                            .setEmail(email)
                            .setClick()
                            .setNumber(phoneNumber)
                            .dobleClick()
                            .dateControl()
                            .dateSpace()
                            .setBirthday(birthday)
                            .setHobbies(hobbies)
                            .setHobbiesClick()
                            .uploadImg()
                            .setCurrentAdress(currentAdress)
                            .stateClick()
                            .setValueState()
                            .setCity()
                            .submitClick()

                            .setShouldHaveText()
                .setResults(firstName,lastName,email,phoneNumber,currentAdress,birthday,hobbies);
    }
}