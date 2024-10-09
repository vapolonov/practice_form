package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static tests.TestData.*;

public class PracticeFormPageObjectTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillPracticeFormTest() {
        practiceFormPage.openPage();

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(userEmail);

        practiceFormPage.setGender("Male");

        practiceFormPage.setUserNumber("1234567890");

        practiceFormPage.setDateOfBirth("09", "September", "1974");

        practiceFormPage.setSubject("Math");

        practiceFormPage.setHobbies("Sports");

        practiceFormPage.uploadPicture("img/pic.jpg");

        practiceFormPage.setAddress("Some address 1");

        practiceFormPage.selectState("Haryana");
        practiceFormPage.selectCity("Panipat");

        practiceFormPage.sendForm();

        practiceFormPage.checkModalIsAppear("Thanks for submitting the form");

        practiceFormPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", userEmail)
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
