package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    @FindBy(css = ".shopping_cart_link")
    private WebElement SHOPPING_CART_BUTTON;
    @FindBy(xpath = ".//*[@class='btn btn_secondary back btn_large inventory_details_back_button']")
    private WebElement BACK_TO_PRODUCTS;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement menu;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logout;
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//*[@class='inventory_item_price']");
    private final static By ITEM_DESCRIPTION = By.xpath(".//*[@class='inventory_item_desc']");
    private final static By ITEM_NAME = By.xpath(".//*[@class='inventory_item_name']");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";


    @Override
    public boolean isPageOpened() {
        return menu.isDisplayed();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
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
        return SHOPPING_CART_BUTTON.isDisplayed();
    }

    @Step("Checking presence on the product details page")
    public boolean backToProductsPresent() {
        return BACK_TO_PRODUCTS.isDisplayed();
    }

    @Step("Go to shopping cart")
    public ProductsPage clickShoppingCartButton() {
        logger.info("Clicking shoppingCart button");
        SHOPPING_CART_BUTTON.click();
        return this;
    }

    @Step("Add item to cart")
    public ProductsPage clickAddToCartButton(String itemName) {
        logger.info("Clicking addToCart button");
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    @Step("Get item name")
    public String getItemName(String itemName) {
        logger.info("Getting itemName");
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).getText();
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        logger.info("Getting itemPrice");
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName) {
        logger.info("Getting itemDescription");
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step("Open item")
    public ProductDetailsPage openItem(String itemName) {
        logger.info("Clicking product button");
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).click();
        return new ProductDetailsPage(driver);
    }

    @Step("Open menu")
    public ProductsPage clickMenuButton() {
        logger.info("Clicking menu button");
        menu.click();
        return this;
    }

    @Step("Logout")
    public LoginPage clickLogout() {
        logger.info("Clicking logout button");
        logout.click();
        return new LoginPage(driver);
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

}
