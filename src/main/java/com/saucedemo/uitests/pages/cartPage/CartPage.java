package com.saucedemo.uitests.pages.cartPage;

import com.saucedemo.uitests.pages.BasePage;
import com.saucedemo.uitests.pages.products.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    WebElement productNameInCart;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement productPriceInCart;

    @FindBy(css = "div[class='cart_list'] div[class='cart_item']")
    public List<WebElement> productsInCartWithRandomChosenQuantity;

    public String getProductNameFromCart() {
        return productNameInCart.getText();
    }

    public String getProductPriceFromCart() {
        return productPriceInCart.getText();
    }

    public List<Product> getChosenProductListFromCart() {
        List<Product> chosenProductListFromCart = new ArrayList<>();

        for (WebElement products : productsInCartWithRandomChosenQuantity) {
            Product simpleProduct = new Product();
            simpleProduct.setProductName(products.findElement(By.cssSelector(".inventory_item_name")).getText());
           // simpleProduct.setProductName(products.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
            simpleProduct.setProductPrice(products.findElement(By.cssSelector(".inventory_item_price")).getText());
            simpleProduct.setPrice(Double.parseDouble(products.findElement(By.cssSelector(".inventory_item_price")).getText()));
            chosenProductListFromCart.add(simpleProduct);
        }
        return chosenProductListFromCart;
    }
}
