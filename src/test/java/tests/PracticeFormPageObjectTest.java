package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillPracticeFormTest() {
        practiceFormPage.openPage();

        practiceFormPage.setFirstName("Vasily");
        practiceFormPage.setLastName("Apolonov");
        practiceFormPage.setEmail("vasvap@gmail.com");

        practiceFormPage.setGender("Male");

        practiceFormPage.setUserNumber("1234567890");

        practiceFormPage.setDateOfBirth("09", "September", "1974");


        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\img\\pic.jpg"));
        $("#uploadPicture").uploadFromClasspath("img\\pic.jpg");

        $("#currentAddress").setValue("Some address 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        practiceFormPage.checkResult("Student Name", "Vasily Apolonov")
                .checkResult("Student Name", "Vasily Apolonov")
                .checkResult("Student Email", "vasvap@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "09 September,1974")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "pic.jpg")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "Haryana Panipat");
    }
}
