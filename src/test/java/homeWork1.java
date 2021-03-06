import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class homeWork1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        driver = new ChromeDriver(opts);
        driver.get("http://158.101.173.161/admin/");

        wait = new WebDriverWait(driver,10);

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("testadmin");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("R8MRDAYT_test");

        WebElement login_btn = driver.findElement(By.cssSelector("button.btn.btn-default"));
        login_btn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("box-apps-menu")));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void clickMenuTest(){
        if (isElementPresent(driver, By.cssSelector("div.panel-heading")))
        {
            System.out.println("Element is present");
        }
        else
        {
            System.out.println("Element is absent");
        }

        List<WebElement> el = driver.findElements(By.className("app"));
        List<WebElement> subel = driver.findElements(By.className("doc"));

        for (int i = 1; i <= el.size(); i++) {
            WebElement clikMain = driver.findElement(By.xpath("//li[contains(@class,'app')][" + i + "]"));
            wait.until(ExpectedConditions.elementToBeClickable(clikMain));
            clikMain.click();

            for (int j = 1; j <= subel.size(); j++) {
                WebElement clickSub = driver.findElement(By.xpath("//li[contains(@class,'doc')][" + j + "]"));
                wait.until(ExpectedConditions.elementToBeClickable(clickSub));
                clickSub.click();

             }
        }
    }

    public boolean isElementPresent(WebDriver drv, By locator)
    {
        return  drv.findElements(locator).size()>0;
    }

}