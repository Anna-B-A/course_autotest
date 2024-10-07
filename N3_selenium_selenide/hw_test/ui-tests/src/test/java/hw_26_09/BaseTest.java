package hw_26_09;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        open("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    void tearDown() {
        getWebDriver().quit();
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        File screenshot = Screenshots.takeScreenShotAsFile();
        try {
            return Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
