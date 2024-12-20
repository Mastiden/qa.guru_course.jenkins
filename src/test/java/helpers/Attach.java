package helpers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName,String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText(
            "Browser console logs",
            String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    /* @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
            + getVideoUrl()
            + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {
        // Источник получения ссылки на видео (указать свой)
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }**/
}
