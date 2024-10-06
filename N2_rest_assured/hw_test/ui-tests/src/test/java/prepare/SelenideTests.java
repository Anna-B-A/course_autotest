package prepare;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTests {

    SelenideElement infiniteScrollButton = $x("//a[@href='/infinite_scroll']");
    SelenideElement pageTitle = $x("//h3");

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        open("https://the-internet.herokuapp.com/");
    }

    @Test
    void test(){
//        $("div");
//        $x("//div");
//        ElementsCollection linksList = $$x("//a");

        infiniteScrollButton.click();

        assert pageTitle.text().equals("Infinite Scroll");
    }

    @AfterEach
    void tearDown() {
        getWebDriver().quit();
    }
}
