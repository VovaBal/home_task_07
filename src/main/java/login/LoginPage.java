package login;

import com.saucedemo.uitests.pages.BasePage;
import homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(name = "user-name")
    WebElement inputUserName;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[text()='Epic sadface: ']")
    WebElement unsuccessfulLoginText;

    public void setUserName(String userName) {
        inputUserName.sendKeys(userName);
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getUnsuccessfulLoginText() {
        return unsuccessfulLoginText.getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLogin();
        return new HomePage(driver);
    }

    public LoginPage loginUnsuccessful(String wrongUserName, String password) {
        this.setUserName(wrongUserName);
        this.setPassword(password);
        this.clickLogin();
        return this;
    }
}
