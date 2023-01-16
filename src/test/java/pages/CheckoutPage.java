package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CheckoutPage extends BasePage {

    @FindBy(css = "#first-name")
    private WebElement FIRST_NAME_INPUT;
    @FindBy(css = "#last-name")
    private WebElement LAST_NAME_INPUT;
    @FindBy(css = "#postal-code")
    private WebElement POSTAL_CODE_INPUT;
    @FindBy(css = "#continue")
    private WebElement continueButton;
    @FindBy (xpath = "//*[@class='error-button']")
    private WebElement errorMessage;

    @Override
    public boolean isPageOpened() {
        return continueButton.isDisplayed();
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Entering a First Name")
    public CheckoutPage setFirstNameInput(String Firstname) {
        FIRST_NAME_INPUT.sendKeys(Firstname);
        return this;
    }

    @Step("Entering a Last Name")
    public CheckoutPage setLastNameInput(String Lastname) {
        LAST_NAME_INPUT.sendKeys(Lastname);
        return this;
    }

    @Step("Entering a code")
    public CheckoutPage setPostalCodeInput(String Postalcode) {
        POSTAL_CODE_INPUT.sendKeys(Postalcode);
        return this;
    }

    @Step("Go to overview page")
    public CheckoutOverwiewPage clickContinueButton() {
        continueButton.click();
        return new CheckoutOverwiewPage(driver);
    }

    @Step("Checking presence on the overview page")
    public boolean isErrorMessagePresent() {
        return errorMessage.isDisplayed();
    }
}
