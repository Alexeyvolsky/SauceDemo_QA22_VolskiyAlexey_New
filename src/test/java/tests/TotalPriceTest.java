package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends Basetest {
    @Test(groups = "smoke", description = "totalPriceTest")
    @Description(value = "Тест проверяет правильность подсчета итоговой стоимости")
    public void totalPriceTest() {
        double expectedItemTotal = 43.18;
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        isPageOpened = productsPage.clickAddToCartButton("Sauce Labs Backpack").
                clickAddToCartButton("Sauce Labs Bike Light").
                clickShoppingCartButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Cart page is not opened");
        isPageOpened = cartPage.clickCheckoutButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Checkout page is not opened");
        isPageOpened = checkoutPage.setFirstNameInput("Alexey").
                setLastNameInput("Volskiy").
                setPostalCodeInput("77887").
                clickContinueButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Checkout overview page is not opened");
        Assert.assertEquals(checkoutOverwiewPage.getActualItemTotal(), expectedItemTotal);
    }
}
