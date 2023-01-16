package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CheckoutCompletePage extends BasePage {
    @FindBy(className = "pony_express")
    private WebElement checkoutComplete;

    @Override
    public boolean isPageOpened() {
        return checkoutComplete.isDisplayed();
    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Checking presence on the finish page")
    public boolean isCheckoutCompletePresent() {
        return checkoutComplete.isDisplayed();
    }

}
