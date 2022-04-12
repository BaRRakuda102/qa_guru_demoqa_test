package com.demoqa.pages;

import com.demoqa.BirthdayConverter;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }


    public RegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setlastName (String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail (String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage choosingGender () {
        $(byText("Male")).click();
        return this;
    }
    public RegistrationFormPage setNumber (String phoneNumber) {
        $("#userNumber").sendKeys(Keys.chord(phoneNumber));
        return this;
    }
    public RegistrationFormPage fieldSelection() {
        $("#dateOfBirthInput").click();
        return this;
    }
    public RegistrationFormPage dateControl () {
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        return this;
    }
    public RegistrationFormPage dateSpace() {
        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
        return this;
    }
    public RegistrationFormPage setBirthday(String birthday) {
        $("#dateOfBirthInput").setValue(birthday).pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbies(String hobbies) {
        $(byText("Music")).click();
        $("#subjectsInput").setValue(hobbies).pressEnter();
        return this;
    }

    public RegistrationFormPage uploadImg() {
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }
    public RegistrationFormPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }
    public RegistrationFormPage stateClick() {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        return this;
    }

    public RegistrationFormPage submitClick() {
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage chekingHaveText() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegistrationFormPage checkingTheResult(String firstName, String lastName, String email, String phoneNumber, String currentAdress,
                           String birthday, String hobbies) {
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text(phoneNumber),
                text(currentAdress), text(BirthdayConverter.convertToFullMonthName(birthday)), text(hobbies));
        return this;
    }

}

