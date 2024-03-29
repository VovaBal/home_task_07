package homePage;

import com.saucedemo.uitests.pages.BasePage;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    WebElement productName;

    @FindBy(xpath = "//div[@class='inventory_item_price' and  text()='29.99']")
    WebElement productPrice;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    WebElement firstProductChoose;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[1]")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='shopping_cart_container']")
    WebElement cartButton;

    @FindBy(xpath = "//div[@class='product_label']")
    WebElement homePageHeaderText;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    WebElement menuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutButton;

    public String getFirstProductName() {
        return productName.getText();
    }

    public String getFirstProductPrice() {
        return productPrice.getText();
    }

    public void firstProductChoose() {
        firstProductChoose.click();
    }

    public void addToCardButtonClick() {
        addToCartButton.click();
    }

    public void cartButtonClick() {
        cartButton.click();
    }

    public String getHomePageHeaderText() {
        return homePageHeaderText.getText();
    }

    public void menuButtonClick() {
        menuButton.click();
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }

    public LoginPage Logout() {
        menuButtonClick();
        logoutButtonClick();
        return new LoginPage(driver);
    }
}

