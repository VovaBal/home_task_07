package com.saucedemo.uitests.pages.cartPage;

import com.saucedemo.uitests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='item_4_title_link']/div")
    WebElement productNameInCart;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement productPriceInCart;

    public String getProductNameFromCart(){
        return productNameInCart.getText();
    }

    public String getProductPriceFromCart(){
        return productPriceInCart.getText();
    }
}
