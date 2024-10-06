//package prepare;
//
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.Duration;
//
//import static java.lang.Thread.sleep;
//
//public class SeleniumTests {
//    WebDriver wd;
//
//    @BeforeEach
//    void setup() {
//        wd = new ChromeDriver();
//        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wd.get("https://the-internet.herokuapp.com/");
//    }
//
//    @Test
//    void test() throws InterruptedException {
//        Thread.sleep(1000);
//        WebElement infiniteScrollButton = wd.findElement(By.xpath("//a[@href='/infinite_scroll']"));
//        infiniteScrollButton.click();
//        Thread.sleep(1000);
//
//        WebElement pageTitle = wd.findElement(By.xpath("//h3"));
//        assert pageTitle.getText().equals("Infinite Scroll");
//        Thread.sleep(1000);
//    }
//
//    @AfterEach
//    void tearDown() {
//        wd.quit();
//    }
//}
