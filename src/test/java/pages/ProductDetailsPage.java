package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//*[@class='inventory_details_name large_size']")
    private WebElement DETAILS_NAME;
    @FindBy(xpath = "//*[@class='inventory_details_price']")
    private WebElement DETAILS_PRICE;
    @FindBy(xpath = "//*[@class='inventory_details_desc large_size']")
    private WebElement DETAILS_DESCRIPTION;
    @FindBy(css = "#back-to-products")
    private WebElement backToProductsButton;

    @Override
    public boolean isPageOpened() {
        return backToProductsButton.isDisplayed();
    }

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @Step("Get details name")
    public String getDetailsName() {
        return DETAILS_NAME.getText();
    }

    @Step("Get details price")
    public String getDetailsPrice() {
        return DETAILS_PRICE.getText();
    }

    @Step("Get details description")
    public String getDetailsDescription() {
        return DETAILS_DESCRIPTION.getText();
    }

}
