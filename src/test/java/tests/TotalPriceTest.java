package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends Basetest {
    @Test(groups = "smoke", description = "totalPriceTest")
    @Description(value = "Тест проверяет правильность подсчета итоговой стоимости")
    public void totalPriceTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("Alexey");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        double expectedItemTotal = checkoutOverwiewPage.itemSubtotal() + checkoutOverwiewPage.itemTax();
        Assert.assertEquals(checkoutOverwiewPage.actualItemTotal(), expectedItemTotal);
    }
}
