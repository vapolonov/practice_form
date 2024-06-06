package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    public static SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWrapper = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            chooseFileButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-content"),
            modalTitle = $("#example-modal-sizes-title-lg");


    CalendarComponent calendarComponent = new CalendarComponent();


    public void openPage() {
        open("/automation-practice-form");
        $("h1").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        emailInput.setValue(value);
    }

    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void setGender(String value) {
        genderWrapper.$(byText(value)).click();
    }

    public void setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
    }

    public PracticeFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
//        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }

    public void setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
    }

    public void uploadPicture(String value) {
        chooseFileButton.uploadFromClasspath(value);
    }

    public void setAddress(String value) {
        addressInput.setValue(value);
    }

    public void selectState(String value) {
        stateDropdown.click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void selectCity(String value) {
        cityDropdown.click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void sendForm() {
        submitButton.click();
    }

    public void checkModalIsAppear(String value) {
        modalWindow.should(appear);
        modalTitle.shouldHave(text(value));
    }
}
