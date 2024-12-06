package demoqa;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends TestBase {

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Tag("simple")
    @Test
    void successfulRegistrationTest() {
        String username = "Alex";
        String lastname = "Egorov";
        String phoneNumber = "1234454582";

        step("Open reg form", () -> {
            registrationPage.openPage();
        });

        step("Filling out the form", () -> {
            registrationPage.setFirstName(username)
                .setLastName(lastname)
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setPhone(phoneNumber)
                .setDate("30", "July", "2008");

            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#currentAddress").setValue("Some_address 13");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
        });

        step("Click submit", () -> {
            $("#submit").click();
        });

        step("Verify result modal", () -> {
            registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", username + " Egorov")
                .verifyResult("Student Email", "alex@egorov.com")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports");
        });
    }

}
