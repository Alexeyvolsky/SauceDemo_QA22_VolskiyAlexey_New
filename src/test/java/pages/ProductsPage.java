package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//*[@class='inventory_item_price']");
    private final static By ITEM_DESCRIPTION = By.xpath(".//*[@class='inventory_item_desc']");
    private final static By ITEM_NAME = By.xpath(".//*[@class='inventory_item_name']");
    private final static By BACK_TO_PRODUCTS = By.xpath(".//*[@class='btn btn_secondary back btn_large inventory_details_back_button']");
    private By menu = By.cssSelector("#react-burger-menu-btn");
    private By logout = By.cssSelector("#logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getActualNamesElements() {
        return driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
    }

    @Step("Get actual collection names on page")
    public List<String> getProductNames() {
        List<String> actualItemNames = new ArrayList<>();
        for (WebElement x : getActualNamesElements()) {
            actualItemNames.add(x.getText());
        }
        return actualItemNames;
    }

    @Step("Sorting")
    public void selectSortingOption(String sortByValue) {
        Select select = new Select(driver.findElement(By.tagName("select")));
        select.selectByValue(sortByValue);
    }

    @Step("Checking presence on the product page")
    public boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Checking presence on the product details page")
    public boolean backToProductsPresent() {
        try {
            driver.findElement(BACK_TO_PRODUCTS);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Go to shopping cart")
    public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    @Step("Add item to cart")
    public void clickAddToCartButton(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step("Get item name")
    public String getItemName(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).getText();
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step("Open item")
    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).click();
    }

    @Step("Open menu")
    public void clickMenuButton() {
        driver.findElement(menu).click();
    }

    @Step("Logout")
    public void clickLogout() {
        driver.findElement(logout).click();
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

}
