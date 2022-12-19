package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutOverwiewPage extends BasePage {
    private By finishButton = By.cssSelector("#finish");

    private final static By DETAILS_NAME = By.xpath("//*[@class='inventory_item_name']");
    private final static By DETAILS_PRICE = By.xpath("//*[@class='inventory_item_price']");
    private final static By DETAILS_DESCRIPTION = By.xpath("//*[@class='inventory_item_desc']");

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
    public void clickFinishButton (){driver.findElement(finishButton).click();}
    public String getDetailsName(){
        return driver.findElement(DETAILS_NAME).getText();
    }
    public String getDetailsPrice(){
        return driver.findElement(DETAILS_PRICE).getText();
    }
    public String getDetailsDescription(){
        return driver.findElement(DETAILS_DESCRIPTION).getText();
    }
}
