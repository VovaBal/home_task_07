package viewPage;

import com.saucedemo.uitests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPage extends BasePage {

    @FindBy(xpath = "//button[@class='inventory_details_back_button']")
    WebElement buttonBack;

    public ViewPage(WebDriver driver) {
        super(driver);
    }

    public void buttonBackClick() {
        buttonBack.click();
    }
}
