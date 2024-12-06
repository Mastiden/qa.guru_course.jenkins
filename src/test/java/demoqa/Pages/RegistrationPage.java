package demoqa.Pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideElement;
import demoqa.Pages.Components.CalendarComponent;
import demoqa.Pages.Components.RegModalPage;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegModalPage regModalPage = new RegModalPage();

    private final String TITLE_TEXT = "Student Registration Form";

    public SelenideElement
        lastNameInput = $("#lastName"),
        firstNameInput = $("#firstName"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        emailInput = $("#userEmail"),
        choosingGender = $("#genterWrapper"),
        phoneInput = $("#userNumber");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove");
        executeJavaScript("$('footer').remove");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        choosingGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendarComponent.setData(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultModalAppears() {
        regModalPage.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        regModalPage.verifyResult(key, value);
        return this;
    }
}
