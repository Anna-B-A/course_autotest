//package prepare;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.Duration;
//import java.util.List;
//
//public class SeleniumTest {
//    WebDriver wd;
//
//    @BeforeEach
//    void driverInit() {
//        wd = new ChromeDriver();
//    }
//
//    @Test
//    void testDriver(){
//        wd.get("ya.ru");
//        WebElement element = wd.findElement(By.xpath("//*"));
//        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//        wd.navigate().refresh();
//
//        element.sendKeys("dcvdvdv");
//        element.sendKeys(Keys.ARROW_DOWN);
//        element.clear();
//
//        element.sendKeys(Keys.BACK_SPACE);
//        element.getText();
//
////        element.getAttribute("");
//
//        List<WebElement> elemevtsList = wd.findElements(By.xpath("//*")); //неизменяемый
////        List<WebElement> elemevtsList =new ArrayList<>(wd.findElements(By.xpath("//*"))); //изменяемый
//
//
//
//    }
//
//    @AfterEach
//    void tearDown() {
//        wd.quit();
//    }
//}
