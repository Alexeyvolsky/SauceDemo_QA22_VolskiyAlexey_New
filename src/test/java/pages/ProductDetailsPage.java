package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver){super(driver);}
    private final static By DETAILS_NAME = By.xpath("//*[@class='inventory_details_name large_size']");
    private final static By DETAILS_PRICE = By.xpath("//*[@class='inventory_details_price']");
    private final static By DETAILS_DESCRIPTION = By.xpath("//*[@class='inventory_details_desc large_size']");
    private final static By DETAILS_ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    public void clickDetailsAddToCartButton(){
        driver.findElement(DETAILS_ADD_TO_CART_BUTTON).click();
    }
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
