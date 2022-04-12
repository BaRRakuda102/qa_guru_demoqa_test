package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.PhoneNumberHelper.extractPhoneWithoutCountryCode;
import static java.lang.String.format;


public class AutomationRegistrationFormFakerTest {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            currentAdress = faker.address().streetAddress();
    String phone = TestDataGenerator.phoneNumber(new Locale("ru"));
    String email = TestDataGenerator.email(Locale.ENGLISH);
    String phoneNumber = extractPhoneWithoutCountryCode(phone);
    String birthday = BirthdayConverter.convertToShortMonthName();
    String hobbies = ("History");





    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void succesfullTest () {
        Selenide.open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").sendKeys(Keys.chord(phoneNumber));
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
        $("#dateOfBirthInput").setValue(birthday).pressEnter();
        $("#subjectsInput").setValue(hobbies).pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(currentAdress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR"));
        $("#city").$(byText("Delhi"));
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text(phoneNumber),
                text(currentAdress), text(BirthdayConverter.convertToFullMonthName(birthday)), text(hobbies));





    }
}