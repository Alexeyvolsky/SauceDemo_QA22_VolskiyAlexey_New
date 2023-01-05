package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class LoginPage extends BasePage {
    private final static By USERNAME_INPUT_LOCATOR = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessageContainer = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Login")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Entering a username")
    public void setUsername(String Username) {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(Username);
    }

    @Step("Entering a password")
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Data Validation")
    public boolean isErrorMessageContainerPresent() {
        try {
            driver.findElement(errorMessageContainer);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Checking presence on the login page")
    public boolean isLoginButtonPresent() {
        try {
            driver.findElement(loginButton);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}
