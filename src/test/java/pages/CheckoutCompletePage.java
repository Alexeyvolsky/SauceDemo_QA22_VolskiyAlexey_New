package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutCompletePage extends BasePage {
    private By checkoutComplete = By.className("pony_express");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking presence on the finish page")
    public boolean isCheckoutCompletePresent() {
        try {
            driver.findElement(checkoutComplete);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

}
