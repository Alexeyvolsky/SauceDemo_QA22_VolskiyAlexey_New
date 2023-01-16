package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LoginPage extends BasePage {
    @FindBy(css = "#user-name")
    private WebElement usernameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;

    @Override
    public boolean isPageOpened() {
        return loginButton.isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Login")
    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    @Step("Entering a username")
    public LoginPage setUsername(String Username) {
        usernameInput.sendKeys(Username);
        return this;
    }

    @Step("Entering a password")
    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Data Validation")
    public boolean isErrorMessageContainerPresent() {
        return errorMessageContainer.isDisplayed();
    }

    @Step("Checking presence on the login page")
    public boolean isLoginButtonPresent() {
        return loginButton.isDisplayed();
    }
}
