package com.demoqa.pages;

import com.demoqa.BirthdayConverter;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {


    public void openPage() {
        open("/automation-practice-form");
    }


    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setlastName (String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail (String email) {
        $("#userEmail").setValue(email);
    }

    public void setClick () {
        $(byText("Male")).click();
    }
    public void setNumber (String phoneNumber) {
        $("#userNumber").sendKeys(Keys.chord(phoneNumber));
    }
    public void dobleClick() {
        $("#dateOfBirthInput").click();
    }
    public void dateControl () {
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
    }
    public void dateSpace() {
        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
    }
    public void setBirthday(String birthday) {
        $("#dateOfBirthInput").setValue(birthday).pressEnter();
    }
    public void setHobbies(String hobbies) {
        $("#subjectsInput").setValue(hobbies).pressEnter();
    }
    public void setHobbiesClick() {
        $(byText("Music")).click();
    }
    public void uploadImg() {
        $("#uploadPicture").uploadFromClasspath("img/1.png");
    }
    public void setCurrentAdress(String currentAdress) {
        $("#currentAddress").setValue(currentAdress);
    }
    public void stateClick() {
        $("#state").click();
    }
    public void setValueState() {
        $("#stateCity-wrapper").$(byText("NCR"));
    }
    public void setCity() {
        $("#city").$(byText("Delhi"));
    }
    public void submitClick() {
        $("#submit").click();
    }
    public void setShouldHaveText() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void setResults(String firstName, String lastName, String email, String phoneNumber, String currentAdress,
                           String birthday, String hobbies) {
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text(phoneNumber),
                text(currentAdress), text(BirthdayConverter.convertToFullMonthName(birthday)), text(hobbies));
    }

}

