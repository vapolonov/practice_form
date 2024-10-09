package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("h1").shouldHave(text("Practice Form"));

        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Vasily");
        $("#lastName").setValue("Apolonov");
        $("#userEmail").setValue("vasvap@gmail.com");
//        $("[for=gender-radio-1]").click();  // $("label[for=gender-radio-1]").click();
//        $("#gender-radio-3").parent().click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
//        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOption("1974");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
//        $x("//*/[@class='react-datepicker__day--009'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\img\\pic.jpg"));
        $("#uploadPicture").uploadFromClasspath("img/pic.jpg");

        $("#currentAddress").scrollIntoView(true).setValue("Some address 100500");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text("Vasily Apolonov"),
                text("vasvap@gmail.com"),
                text("Male"),
                text("1234567890"),
                text("09 September,1974"),
                text("Math"),
                text("Sports"),
                text("pic.jpg"),
                text("Some address 1"),
                text("Haryana Panipat")
        );
    }
}
