package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CheckoutOverwiewPage extends BasePage {
    private By finishButton = By.cssSelector("#finish");

    private final static By DETAILS_NAME = By.xpath("//*[@class='inventory_item_name']");
    private final static By DETAILS_PRICE = By.xpath("//*[@class='inventory_item_price']");
    private final static By DETAILS_DESCRIPTION = By.xpath("//*[@class='inventory_item_desc']");
    private final static By SUMMARY_SUBTOTAL_LABEL = By.xpath("//*[@class ='summary_subtotal_label']");
    private final static By SUMMARY_TAX_LABEL = By.xpath("//*[@class ='summary_tax_label']");
    private final static By SUMMARY_TOTAL_LABEL = By.xpath("//*[@class ='summary_total_label']");

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
    @Step("Go to finish page")
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
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
    @Step("Cost value")
    public double itemSubtotal() {
        String subtotalFull = driver.findElement(SUMMARY_SUBTOTAL_LABEL).getText();
        String subtotalString = subtotalFull.substring(13);
        double subtotal = Double.parseDouble(subtotalString);
        return subtotal;
    }
    @Step("Discount value")
    public double itemTax() {
        String taxFull = driver.findElement(SUMMARY_TAX_LABEL).getText();
        String taxString = taxFull.substring(6);
        double tax = Double.parseDouble(taxString);
        return tax;
    }
    @Step("actual value")
    public double actualItemTotal() {
        String itemTotalFull = driver.findElement(SUMMARY_TOTAL_LABEL).getText();
        String itemTotalString = itemTotalFull.substring(8);
        double actualTotal = Double.parseDouble(itemTotalString);
        return actualTotal;
    }
    @Step("expected value")
    public double expectedItemTotal() {
        double expectedTotal = itemSubtotal() + itemTax();
        return expectedTotal;
    }
}
