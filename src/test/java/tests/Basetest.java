package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
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
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverwiewPage = new CheckoutOverwiewPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }
    @BeforeMethod
    public void navigate(){
        driver.get("https://www.saucedemo.com/");
    }
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        driver.quit();
//    }

}
