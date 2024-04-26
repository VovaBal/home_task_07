package com.saucedemo.uitest;

import com.saucedemo.uitests.pages.cartPage.CartPage;
import com.saucedemo.uitests.pages.products.Product;
import com.saucedemo.uitests.pages.products.ProductComparator;

import homePage.HomePage;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import viewPage.ViewPage;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Home_task_07_tests {

    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }
//    @AfterTest
//    public void close(){
//        driver.quit();
//    }

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
    public void testCase_3_withRandomChoseProduct() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        homePage.getRandomProduct();
        ViewPage viewPage = new ViewPage(driver);
        viewPage.buttonBackClick();
        Assert.assertTrue(homePage.getHomePageHeaderText().contains("Products"));

    }

    @Test
    public void testCase_4_withRandomChoseProductAndEnterInCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        Product product = homePage.getRandomProduct();
        ViewPage viewPage = new ViewPage(driver);
        viewPage.addToCartButtonOnViewPageClick();
        viewPage.cartIconClick();
        CartPage cartPage = new CartPage(driver);

        String productNameInCart = cartPage.getProductNameFromCart();
        System.out.println("productNameInCart  = " + productNameInCart);

        String productPriceInCart = cartPage.getProductPriceFromCart();
        System.out.println("productPriceInCart = " + productPriceInCart);

        String productName = product.getProductName();
        System.out.println("productName = " + productName);

        String productPrice = product.getProductPrice();
        System.out.println("productPrice = " + productPrice);

        Assert.assertEquals(productName, productNameInCart);
        Assert.assertEquals(productPrice, productPriceInCart);
    }

    @Test
    public void testRandomProducts() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        Product productExpected = new Product();
        productExpected = homePage.getRandomProduct();
        ViewPage viewPage = new ViewPage(driver);
        Product productActual = new Product();
        productActual.setProductName(viewPage.getNameFromActualProduct());
        productActual.setProductPrice(viewPage.getPriceFromActualProduct());
        Assert.assertEquals(productActual.getProductName(), productExpected.getProductName());
        Assert.assertEquals(productActual.getProductPrice(), productExpected.getProductPrice());
    }

    //    @AfterClass
//    public void Logout() {
//        HomePage homePage = new HomePage(driver);
//        homePage.Logout();
//    }
    @Test
    public void checkSortingByPrice() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        List<Product> productList = homePage.getProducts();

        Select select = new Select(homePage.sortByElement);
        select.selectByValue("lohi");
        List<Product> productListSortedByPrice = homePage.getProducts();
        List<Product> sortedProductList = homePage.getProducts();

        Assert.assertNotEquals(productList, productListSortedByPrice);

    }

    @Test
    public void testCase_5() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        List<Product> expectedResult = homePage.getProducts();

        Select select = new Select(homePage.sortByElement);
        select.selectByValue("lohi");
        List<Product> actualResult = homePage.getProducts();

        for (Product product : actualResult) {
            System.out.println("actualResult = " + product.getProductName() + " = " + product.getProductPrice());
        }
        System.out.println();

        Collections.sort(expectedResult, new ProductComparator());


        for (Product product : expectedResult) {
            System.out.println("expectedResult  " + product.getProductName() + " = " + product.getProductPrice());
        }
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase_6() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        ViewPage viewPage = new ViewPage(driver);
        for (int i = 0; i < 3; i++) {
            homePage.getRandomProduct();
            Thread.sleep(400);
            viewPage.addToCartButtonOnViewPageClick();
            viewPage.buttonBackClick();
        }
    }

    @Test
    public void testCase_7()  {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        HomePage homePage = new HomePage(driver);
        ViewPage viewPage = new ViewPage(driver);
        CartPage cartPage = new CartPage(driver);
        List<Product> productsAddedToCart = homePage.addToCartRandomProducts(3);
        viewPage.cartIconClick();
        List<Product> productsListInCart = cartPage.getChosenProductListFromCart();
        Assert.assertEquals(productsAddedToCart, productsListInCart);


    }

}
