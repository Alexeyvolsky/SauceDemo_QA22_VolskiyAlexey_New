package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
