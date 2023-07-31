package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    @AfterMethod
    public void quit(){
        driver.get().quit();
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void runBookYe(){

        try {
            getDriver().get("https://www.book-ye.com.ua");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
