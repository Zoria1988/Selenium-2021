import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class homeWork3 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
     static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        driver = new ChromeDriver(opts);
    }

    //@AfterAll
    //static void tearDown() {
    //    driver.quit();
    //}


    @Test
    void logInTest () {
        driver.get("http://158.101.173.161/admin/?app=countries&doc=countries");
        wait = new WebDriverWait(driver,10);

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("testadmin");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("R8MRDAYT_test");

        WebElement login_btn = driver.findElement(By.cssSelector("button.btn.btn-default"));
        login_btn.click();
    }


}