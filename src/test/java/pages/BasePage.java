package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    protected WebDriver driver;
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
