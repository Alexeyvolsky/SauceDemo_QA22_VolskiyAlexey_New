package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By checkoutButton = By.cssSelector("#checkout");
    public CartPage(WebDriver driver){super(driver);}

    public void clickCheckoutButton() {driver.findElement(checkoutButton).click();}

}

