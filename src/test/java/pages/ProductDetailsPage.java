package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final static By DETAILS_NAME = By.xpath("//*[@class='inventory_details_name large_size']");
    private final static By DETAILS_PRICE = By.xpath("//*[@class='inventory_details_price']");
    private final static By DETAILS_DESCRIPTION = By.xpath("//*[@class='inventory_details_desc large_size']");

    @Step("Get details name")
    public String getDetailsName() {
        return driver.findElement(DETAILS_NAME).getText();
    }
    @Step("Get details price")
    public String getDetailsPrice() {
        return driver.findElement(DETAILS_PRICE).getText();
    }
    @Step("Get details description")
    public String getDetailsDescription() {
        return driver.findElement(DETAILS_DESCRIPTION).getText();
    }

}
