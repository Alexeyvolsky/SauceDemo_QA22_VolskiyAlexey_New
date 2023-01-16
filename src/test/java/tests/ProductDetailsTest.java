package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends Basetest {

    @Test(description = "test details", groups = "smoke")
    @Description(value = "Тест проверяет соответствие всех параметров выбранного товара с параметрами на странице")
    public void detailsTest() {
        String expectedDetailsName = "Sauce Labs Backpack";
        String expectedDetailsPrice = "$29.99";
        String expectedDetailsDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        isPageOpened = productsPage.openItem(expectedDetailsName).isPageOpened();
        Assert.assertTrue(isPageOpened,"Product details page is not opened");
        Assert.assertEquals(productDetailsPage.getDetailsDescription(), expectedDetailsDescription);
        Assert.assertEquals(productDetailsPage.getDetailsName(), expectedDetailsName);
        Assert.assertEquals(productDetailsPage.getDetailsPrice(), expectedDetailsPrice);
    }
}
