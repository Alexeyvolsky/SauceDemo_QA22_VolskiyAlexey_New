package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CheckoutOverwiewPage extends BasePage {
    @FindBy(css = "#finish")
    private WebElement finishButton;
    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private WebElement DETAILS_NAME;
    @FindBy(xpath = "//*[@class='inventory_item_price']")
    private WebElement DETAILS_PRICE;
    @FindBy(xpath = "//*[@class='inventory_item_desc']")
    private WebElement DETAILS_DESCRIPTION;
    @FindBy(xpath = "//*[@class ='summary_total_label']")
    private WebElement SUMMARY_TOTAL_LABEL;

    @Override
    public boolean isPageOpened() {
        return finishButton.isDisplayed();
    }

    public CheckoutOverwiewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Go to finish page")
    public CheckoutCompletePage clickFinishButton() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
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

    @Step("Actual value")
    public double getActualItemTotal() {
        String itemTotalFull = SUMMARY_TOTAL_LABEL.getText();
        String itemTotalString = itemTotalFull.substring(8);
        double actualTotal = Double.parseDouble(itemTotalString);
        return actualTotal;
    }
}
