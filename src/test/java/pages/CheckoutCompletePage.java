package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutCompletePage extends BasePage{
    private By checkoutComplete = By.className("pony_express");
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public boolean isCheckoutCompletePresent(){
        try {
            driver.findElement(checkoutComplete);
        }catch (NoSuchElementException ex){
            return false;
        }
        return true;
    }

}
