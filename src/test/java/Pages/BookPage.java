package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage extends BasePage {
    public BookPage(WebDriver driver){
        super(driver);
    }

    public WebElement buyBtn()
    {
       return driver.findElement(By.xpath("//div/a[text() = \"Купити\"]"));
    }

    public WebElement addToWishLsBtn()
    {
        return driver.findElement(By.xpath("//*[text() = \"Додати до списку побажань\"]"));
    }

    public WebElement deliveryMethods()
    {
        return driver.findElement(By.xpath("//*[text() = \"Доставка\"]"));
    }

    public WebElement paymentsMethods()
    {
        return driver.findElement(By.xpath("//*[text() = \"Оплата\"]"));
    }
}
