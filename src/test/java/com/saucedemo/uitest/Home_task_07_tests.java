package com.saucedemo.uitest;

import com.saucedemo.uitests.pages.cartPage.CartPage;
import homePage.HomePage;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import viewPage.ViewPage;

import java.time.Duration;

public class Home_task_07_tests {

    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @BeforeClass
    public void Login() {
       // setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void getPriceAndNameFromProduct() {
        HomePage homePage = new HomePage(driver);
        String nameProductOnHomePage = homePage.getFirstProductName();
        String priceProductOnHomePage = homePage.getFirstProductPrice();
        //homePage.firstProductChoose();
        homePage.addToCardButtonClick();
        homePage.cartButtonClick();
        CartPage cartPage = new CartPage(driver);
        String nameProductInCart = cartPage.getProductNameFromCart();
        String priceProductInCart = cartPage.getProductPriceFromCart();
        Assert.assertEquals(nameProductOnHomePage, nameProductInCart);
        // Assert.assertEquals(priceProductOnHomePage, priceProductInCart);
    }

    @Test
    public void testCase_3() throws InterruptedException {
       // driver.get("https://www.saucedemo.com/v1/index.html");
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        homePage.firstProductChoose();
        ViewPage viewPage = new ViewPage(driver);
        viewPage.buttonBackClick();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.getHomePageHeaderText().contains("Products"));
    }

    @Test
    public void testRandomProducts(){
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage =new HomePage(driver);
        homePage.getRandomElement();
    }

//    @AfterClass
//    public void Logout() {
//        HomePage homePage = new HomePage(driver);
//        homePage.Logout();
//    }


}
