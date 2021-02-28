import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SimpleTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void firstSeleniumTest() {

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.cssSelector("h3")).getText().toLowerCase().contains("senium"), "Selenium not found");
    }
}
