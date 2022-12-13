package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutPage extends BasePage{

    private final static By FIRST_NAME_INPUT = By.cssSelector("#first-name");
    private final static By LAST_NAME_INPUT = By.cssSelector("#last-name");
    private final static By POSTAL_CODE_INPUT = By.cssSelector("#postal-code");
    private By continueButton = By.cssSelector("#continue");
    private By errorMessage = By.xpath("//*[@class='error-button']");
    public CheckoutPage(WebDriver driver){super(driver);}
    public void setFirstNameInput(String Firstname){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(Firstname);
    }
    public void setLastNameInput(String Lastname){
        driver.findElement(LAST_NAME_INPUT).sendKeys(Lastname);
    }
    public void setPostalCodeInput(String Postalcode){
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(Postalcode);
    }
    public void clickContinueButton(){driver.findElement(continueButton).click();}
    public boolean isErrorMessagePresent() {
        try {
            driver.findElement(errorMessage);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}
