package Tests;

import Pages.BookPage;
import Pages.HomePageBookYe;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class BookYeTest extends TestInit {
    @Test
    public void startSiteTest() {
        runBookYe();
    }

    @Test
    public void displayTestHomePage()
    {
        WebDriver driver = getDriver();
        HomePageBookYe homePageBookYe = new HomePageBookYe(driver);

        runBookYe();
        Assert.assertTrue(homePageBookYe.logo().isDisplayed());
        Assert.assertTrue(homePageBookYe.catalog().isDisplayed());
        Assert.assertTrue(homePageBookYe.basketBtn().isDisplayed());
        Assert.assertTrue(homePageBookYe.wishlistBtn().isDisplayed());
        Assert.assertTrue(homePageBookYe.loginBtn().isDisplayed());
        Assert.assertTrue(homePageBookYe.searchBar().isDisplayed());
        Assert.assertTrue(homePageBookYe.searchBtn().isDisplayed());
    }

    @Test
    public void searchTest()
    {
        WebDriver driver = getDriver();
        HomePageBookYe homePageBookYe = new HomePageBookYe(driver);

        runBookYe();
        homePageBookYe.searchBar().click();
        homePageBookYe.searchBar().sendKeys("1984\n");
        driver.findElement(By.xpath("//a/img[@alt = \"1984\"]")).click();
    }

    @Test
    public void titleTest()
    {
        WebDriver driver = getDriver();

        runBookYe();
        Assert.assertEquals("Інтернет-магазин книг - Книгарня \"Є\" ➤ Завжди дешевше, ніж будь-де | Купити книги в інтернет-магазині дешево" , driver.getTitle());

    }

    @Test
    public void basketListTest() throws InterruptedException {

        WebDriver driver = getDriver();
        HomePageBookYe homePageBookYe = new HomePageBookYe(driver);
        BookPage bookPage = new BookPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        runBookYe();
        homePageBookYe.searchBar().click();
        homePageBookYe.searchBar().sendKeys("1984\n");
        driver.findElement(By.xpath("//a/img[@alt = \"1984\"]")).click();

        js.executeScript("window.scrollBy(0, 300)");
        bookPage.buyBtn().click();

        Thread.sleep(1500);

        Assert.assertTrue(driver.findElement(By.xpath("//div//td/a[text()= \"1984\"]")).isDisplayed());

    }

    @Test
    public void displayTestBookPage()
    {
        WebDriver driver = getDriver();
        HomePageBookYe homePageBookYe = new HomePageBookYe(driver);
        BookPage bookPage = new BookPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        runBookYe();
        homePageBookYe.searchBar().click();
        homePageBookYe.searchBar().sendKeys("1984\n");
        driver.findElement(By.xpath("//a/img[@alt = \"1984\"]")).click();
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0, 100)");

        Assert.assertTrue(bookPage.paymentsMethods().isDisplayed());
        Assert.assertTrue(bookPage.deliveryMethods().isDisplayed());
        Assert.assertTrue(bookPage.buyBtn().isDisplayed());
        Assert.assertTrue(bookPage.addToWishLsBtn().isDisplayed());
    }

    @Test
    public void homeBtnTest()
    {
        WebDriver driver = getDriver();
        HomePageBookYe homePageBookYe = new HomePageBookYe(driver);

        runBookYe();
        homePageBookYe.wishlistBtn().click();
        homePageBookYe.logo().click();

        Assert.assertEquals("https://book-ye.com.ua/", driver.getCurrentUrl());


    }


}
