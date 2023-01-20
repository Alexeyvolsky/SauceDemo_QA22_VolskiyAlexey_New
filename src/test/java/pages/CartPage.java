package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(css = "#checkout")
    private WebElement checkoutButton;
    @FindBy(xpath = ".//div[@class ='inventory_item_desc']")
    private WebElement ITEM_DESCRIPTION_LOCATOR;
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static String ITEM_REMOVE_LOCATOR = "//button[@id='remove-%s']";

    private By getRemoveButtonByItemName(String itemName) {
        return By.xpath(String.format(ITEM_REMOVE_LOCATOR, itemName));
    }

    @Override
    public boolean isPageOpened() {
        return checkoutButton.isDisplayed();
    }

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Go to cart")
    public CheckoutPage clickCheckoutButton() {
        logger.info("Clicking checkout button");
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    @Step("Removing item from the cart")
    public void removeButtonClick(String itemName) {
        logger.info("Clicking remove button");
        driver.findElement(getRemoveButtonByItemName(itemName)).click();
    }

    @Step("Checking if an element exists on a page")
    public boolean isItemDescriptionDisplayed(String itemName) {
        try {
            return driver.findElement(getItemContainerByName(itemName)).findElement((By) ITEM_DESCRIPTION_LOCATOR).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }
}

