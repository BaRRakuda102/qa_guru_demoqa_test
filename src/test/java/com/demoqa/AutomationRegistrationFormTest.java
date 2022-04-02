package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class AutomationRegistrationFormTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    String email = "domesh.s@yandex.ru";
    @Test
    void succesfullTest () {
        Selenide.open("/automation-practice-form");
        $("#firstName").setValue("Vladislav");
        $("#lastName").setValue("Krasavchik");
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue("89174358231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label$='November 30th, 1994']").click();
        $("#subjectsInput").setValue("Informatic").pressEnter();


    }
}
