package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By checkoutButton = By.cssSelector("#checkout");
    private final static By ITEM_DESCRIPTION_LOCATOR = By.xpath(".//div[@class ='inventory_item_desc']");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static String ITEM_REMOVE_LOCATOR = "//button[@id='remove-%s']";

    private By getRemoveButtonByItemName(String itemName) {
        return By.xpath(String.format(ITEM_REMOVE_LOCATOR, itemName));
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to cart")
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    @Step("Removing item from the cart")
    public void removeButtonClick(String itemName) {
        driver.findElement(getRemoveButtonByItemName(itemName)).click();
    }

    @Step("Checking if an element exists on a page")
    public boolean isItemDescriptionDisplayed(String itemName) {
        try {
            return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION_LOCATOR).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }
}

