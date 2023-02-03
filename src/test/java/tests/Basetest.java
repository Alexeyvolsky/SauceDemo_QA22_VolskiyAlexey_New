package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class Basetest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;
    protected CheckoutOverwiewPage checkoutOverwiewPage;
    protected ProductDetailsPage productDetailsPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "Chrome");
        String headless = System.getProperty("headless", "false");
        if (browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(headless.equals("true")){
                options.addArguments("--headless");
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverwiewPage = new CheckoutOverwiewPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
