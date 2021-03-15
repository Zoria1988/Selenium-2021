import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class homeWork2 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        wait = new WebDriverWait(driver,10);
        driver = new ChromeDriver(opts);
    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
    @Test
    void addToCart() {
        driver.get("...");
        for (int i = 1; i <= 3; i++) {
            driver.findElements(By.cssSelector("#box-popular-products .product-column")).get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='add_cart_product']"))).click();
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div.badge.quantity"), String.valueOf(i)));
            driver.get("http://158.101.173.161/");
        }
        driver.findElement(By.cssSelector("div.badge.quantity")).click();
    }
    @Test
    void checkCart() {
        driver.get("http://158.101.173.161/checkout");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.items")));
    }
    @Test
    void removeFromCart(){
        while (driver.findElements(By.cssSelector("a.btn-default")).size() == 0)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='remove_cart_item']"))).click();
            pause(1);
        }

        driver.findElement(By.cssSelector("a.btn-default")).click();
        driver.get("http://158.101.173.161/");
        }
    void pause(int sec)
    {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
