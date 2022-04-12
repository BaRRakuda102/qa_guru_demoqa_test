package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static com.demoqa.PhoneNumberHelper.extractPhoneWithoutCountryCode;



public class AutomationRegistrationFormObjectsPage {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            currentAddress = faker.address().streetAddress();
    String phone = com.demoqa.TestDataGenerator.phoneNumber(new Locale("ru"));
    String email = com.demoqa.TestDataGenerator.email(Locale.ENGLISH);
    String phoneNumber = extractPhoneWithoutCountryCode(phone);
    String birthday = com.demoqa.BirthdayConverter.convertToShortMonthName();
    String hobbies = ("History");



    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFullTest () {

        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setlastName(lastName)
                            .setEmail(email)
                            .choosingGender()
                            .setNumber(phoneNumber)
                            .fieldSelection()
                            .dateControl()
                            .dateSpace()
                            .setBirthday(birthday)
                            .setHobbies(hobbies)
                            .uploadImg()
                            .setCurrentAddress(currentAddress)
                            .stateClick()
                            .submitClick()

                            .chekingHaveText()
                .checkingTheResult(firstName,lastName,email,phoneNumber,currentAddress,birthday,hobbies);
    }
}