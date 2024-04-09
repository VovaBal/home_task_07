package homePage;

import com.saucedemo.uitests.pages.BasePage;
import com.saucedemo.uitests.pages.products.Product;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

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

    @FindBy(css = "div[class='inventory_list'] div[class='inventory_item']")
    private List<WebElement> productItems;

    @FindBy(xpath = "//a/div")
    private List<WebElement> nameProducts;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priceProducts;

//      public String getRandomProductText() {
//        return nameRandomProduct.getText();
//    }

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

//    public WebElement getRandomElement() {
//        Random rand = new Random();
//        int index = rand.nextInt(productItems.size());
//        return productItems.get(index);
//    }

    public Product getRandomProduct() {
        Product product = new Product();
        Random rand = new Random();
        int index = rand.nextInt(productItems.size());
        WebElement nameProduct = nameProducts.get(index);
        product.setProductName(nameProduct.getText());
        String priceProduct = priceProducts.get(index).getText().replace("$","");
        product.setProductPrice(priceProduct);
        nameProduct.click();
        return product;
    }
}


