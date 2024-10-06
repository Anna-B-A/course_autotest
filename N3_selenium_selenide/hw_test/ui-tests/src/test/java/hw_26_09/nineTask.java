package hw_26_09;

import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class nineTask {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        open("https://the-internet.herokuapp.com/");
    }

    @Test
    void checkboxes(){
        SelenideElement hrefCheckboxes = $x("//a[@href='/checkboxes']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        SelenideElement firstCheckbox = $x("//form[@id='checkboxes']/input[1]");
        SelenideElement secondCheckbox = $x("//form[@id='checkboxes']/input[2]");

        sleep(2000);
        hrefCheckboxes.click();

        sleep(1500);
        firstCheckbox.click();
        sleep(1500);
        secondCheckbox.click();
        sleep(1500);

        System.out.println("Value for first checkbox: " + firstCheckbox.getAttribute("checked"));
        System.out.println("Value for second checkbox: " + secondCheckbox.getAttribute("checked"));
    }

    @Test
    void dropdown(){
        SelenideElement hrefDropdown = $x("//a[@href='/dropdown']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        SelenideElement selectListDropdown = $x("//select[@id='dropdown']");

        sleep(2000);
        hrefDropdown.click();

        sleep(1500);
        selectListDropdown.selectOption(1);
        System.out.println("Value for first option: " + selectListDropdown.$("option", 1).getText());
        sleep(1500);
        selectListDropdown.selectOption(2);
        System.out.println("Value for second option: " + selectListDropdown.$("option", 2).getText());
        sleep(1500);
    }

    @Test
    void disappearingElements(){
        SelenideElement hrefdisappearingElements = $x("//a[@href='/disappearing_elements']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        ElementsCollection listElementsDisappearing = $$x("//ul//li");

        sleep(2000);
        hrefdisappearingElements.click();
        Selenide.refresh();
        sleep(1500);
        int listElementsCount = 0;
        for (int i = 0; i < 10; i++){
            listElementsCount = listElementsDisappearing.size();
            if (listElementsCount == 5){
                break;
            }
            else {
                Selenide.refresh();
                sleep(1500);
            }
        }
        assertEquals(listElementsCount, 5, "5 items were not found in 10 attempts, found: : " + listElementsCount);
    }

    @Test
    void inputs(){
        SelenideElement hrefInputs = $x("//a[@href='/inputs']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        SelenideElement input = $x("//input");

        sleep(2000);
        hrefInputs.click();

        sleep(1500);
        input.setValue(Integer.toString((int)(Math.random() * 10000) + 1));
        sleep(1500);
        System.out.println("Contents of input: " + input.getValue());
    }

    @Test
    void hovers(){
        SelenideElement hrefHovers = $x("//a[@href='/hovers']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        ElementsCollection listElementsHovers = $$x("//div[@class='figure']");

        sleep(2000);
        hrefHovers.click();

        for (int i = 0; i < listElementsHovers.size(); i++){
            SelenideElement figure = listElementsHovers.get(i);
            sleep(1500);
            figure.hover();
            System.out.println("Under figure: " + (i+1) + "\n text: " + figure.$x(".//h5").getText() + "\n");
        }
    }

    @Test
    void notificationMessage(){
        SelenideElement hrefNotifivcationMessage = $x("//a[@href='/notification_message']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        SelenideElement alert = $x("//div[@data-alert='' and @id='flash']");

        sleep(2000);
        hrefNotifivcationMessage.click();

        do {
            hrefNotifivcationMessage.click();
            sleep(1500);
            if (alert.getText().contains("Action successful")){
                break;
            }
            else {
                alert.$x(".//a[@class='close']").click();
                sleep(1500);
            }
        } while (true);
    }

    @Test
    void addRemoveElements(){
        SelenideElement hrefAddRemoveElements = $x("//a[@href='/add_remove_elements/']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
        SelenideElement addElement = $x("//button[@onclick='addElement()']");
        ElementsCollection listElementsAdd = $$x("//button[@class='added-manually']");

        sleep(2000);
        hrefAddRemoveElements.click();
        sleep(1500);

        for (int i = 0; i < 5; i++){
            addElement.click();
            sleep(1500);
            System.out.println("Text " + (listElementsAdd.size() - 1) + " button: "
                    + listElementsAdd.get(listElementsAdd.size() - 1).getText()
                    + "\n size: " + listElementsAdd.size());
        }

        for (int i = 0; i < 3; i++){
            if (i % 2 == 0){
                listElementsAdd.get(0).click();
            }
            else{
                listElementsAdd.get(listElementsAdd.size() - 1).click();
            }
            sleep(1500);
            System.out.println("Buttons left: " + listElementsAdd.size());
            for (int j = 0; j < listElementsAdd.size(); j++){
                System.out.println("Text " + j + " button: "
                        + listElementsAdd.get(j).getText());
            }
        }
    }


    @Test
    void testStatusCode200() {
        testStatusCode(200);
    }

    @Test
    void testStatusCode301() {
        testStatusCode(301);
    }

    @Test
    void testStatusCode404() {
        testStatusCode(404);
    }

    @Test
    void testStatusCode500() {
        testStatusCode(500);
    }

    private void testStatusCode(int statusCode){
        SelenideElement hrefStatusCodes = $x("//a[@href='/status_codes']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        sleep(2000);
        hrefStatusCodes.click();

        SelenideElement elementCodeOnPage = $x("//a[text()='" + statusCode + "']");
        sleep(1500);
        elementCodeOnPage.click();
        String fullText = $x("//p").getText();
        String textForCode = fullText.split("\n")[0];
        System.out.println(textForCode);
        sleep(1500);
        back();
        sleep(1500);
        attachScreenshot("Страница статус-кода " + statusCode);
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
