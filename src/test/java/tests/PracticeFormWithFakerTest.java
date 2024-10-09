package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.util.Locale;


public class PracticeFormWithFakerTest extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillPracticeFormWithFakerTest() {

        Faker faker = new Faker(new Locale("en"));

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String userNumber = faker.phoneNumber().subscriberNumber(10); // Barton
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        practiceFormPage.openPage();

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(userEmail);

        practiceFormPage.setGender("Male");

        practiceFormPage.setUserNumber(userNumber);

        practiceFormPage.setDateOfBirth("09", "September", "1974");

        practiceFormPage.setSubject("Math");

        practiceFormPage.setHobbies("Sports");

        practiceFormPage.uploadPicture("img\\pic.jpg");

        practiceFormPage.setAddress(streetAddress);

        practiceFormPage.selectState("Haryana");
        practiceFormPage.selectCity("Panipat");

        practiceFormPage.sendForm();

        practiceFormPage.checkModalIsAppear("Thanks for submitting the form");

        practiceFormPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "09 September,1974")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "pic.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "Haryana Panipat");
    }
}

