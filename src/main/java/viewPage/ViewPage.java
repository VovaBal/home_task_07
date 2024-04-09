package viewPage;

import com.saucedemo.uitests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPage extends BasePage {

    @FindBy(xpath = "//button[@class='inventory_details_back_button']")
    WebElement buttonBack;

    @FindBy(xpath = "//div[@class='inventory_details_name']")
    WebElement nameActualProduct;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement priceActualProduct;

    public ViewPage(WebDriver driver) {
        super(driver);
    }

    public void buttonBackClick() {
        buttonBack.click();
    }
    public String getNameFromActualProduct(){
        return nameActualProduct.getText();
    }
    public String getPriceFromActualProduct(){
        return priceActualProduct.getText().replace("$","");
    }
}
