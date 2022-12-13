package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class ProductsPage extends BasePage{
    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath("//*[@class='inventory_item_price']");
    private final static By ITEM_DESCRIPTION = By.xpath("//*[@class='inventory_item_desc']");
    private final static By ITEM_NAME = By.xpath("//*[@class='inventory_item_name']");
    private final static By BACK_TO_PRODUCTS = By.xpath("//*[@class='btn btn_secondary back btn_large inventory_details_back_button']");
    public ProductsPage(WebDriver driver){
        super(driver);
    }
    public boolean isShoppingCartButtonPresent(){
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        }catch (NoSuchElementException ex){
            return false;
        }
        return true;
    }
    public boolean backToProductsPresent(){
        try {
            driver.findElement(BACK_TO_PRODUCTS);
        }catch (NoSuchElementException ex){
            return false;
        }
        return true;
    }
    public void clickShoppingCartButton(){

        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
    public void clickAddToCartButton (String itemName){
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }
    public String getItemName(String itemName){
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).getText();
    }
    public String getItemPrice(String itemName){
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }
    public String getItemDescription(String itemName){
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }
    public void openItem (String itemName){
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME).click();
    }
    private By getItemContainerByName(String itemName){
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR,itemName));
    }

}
