import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemo {
    WebDriver driver;
    @Test
    public void sauceDemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton =driver.findElement(By.cssSelector(".submit-button"));
        loginButton.click();
        String itemName1 = driver.findElement(By.id("item_0_title_link")).getText();
        String price1 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div")).getText();
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCart.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
        String itemName2 = driver.findElement(By.id("item_0_title_link")).getText();
        Assert.assertEquals(itemName1,itemName2);
        String price2 =driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(price1,price2);


    }
}
