package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutOverwiewPage extends BasePage {
    private By finishButton = By.cssSelector("#finish");

    public CheckoutOverwiewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFinishButtonPresent() {
        try {
            driver.findElement(finishButton);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}
