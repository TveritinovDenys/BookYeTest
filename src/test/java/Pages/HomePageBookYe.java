package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageBookYe extends BasePage {
    public HomePageBookYe (WebDriver driver)
    {
        super(driver);
    }

    public WebElement logo()
    {
        return driver.findElement(By.xpath("//img[@alt = \"Логотип\"]"));
    }

    public WebElement catalog()
    {
        return driver.findElement(By.xpath("//div[@class=\"header__catalog-wrap\"]"));
    }

    public WebElement searchBar()
    {
        return driver.findElement(By.xpath("//input[@name = 'q']"));
    }

    public WebElement headerSearchBar()
    {
        return  driver.findElement(By.xpath("//input[@id = \"q\"]"));
    }

    public WebElement searchBtn()
    {
        return driver.findElement(By.xpath("//input[@title = \"Шукати\"]"));
    }

    public WebElement basketBtn()
    {
        return driver.findElement(By.xpath("//a[contains(@class , \"header-bottom__basket\")]"));
    }

    public WebElement wishlistBtn()
    {
        return driver.findElement(By.xpath("//a[contains(@class , \"header-bottom__favorites\")]"));
    }

    public WebElement loginBtn()
    {
        return driver.findElement(By.xpath("//span[contains(text(), \"Увійти або Зареєструватися\")]"));
    }

}
