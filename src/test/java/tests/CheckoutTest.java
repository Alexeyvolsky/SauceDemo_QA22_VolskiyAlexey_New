package tests;

import io.qameta.allure.Description;
import org.apache.hc.core5.annotation.Contract;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

import java.util.NoSuchElementException;

public class CheckoutTest extends Basetest {
    @Test(description = "pozitive Checkout Test", groups = "smoke")
    @Description(value = "Тест проверяет покупку при вводе допустимых значений")
    public void pozitiveCheckoutTest() {
        String expectedName = "Sauce Labs Bike Light";
        String expectedPrice = "$9.99";
        String expectedDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickShoppingCartButton();
        Assert.assertEquals(checkoutOverwiewPage.getDetailsName(), expectedName);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsPrice(), expectedPrice);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsDescription(), expectedDescription);
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("Alexey");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        checkoutOverwiewPage.clickFinishButton();
        checkoutCompletePage.isCheckoutCompletePresent();
    }

    @Test(description = "negativeCheckoutTest", groups = "regression")
    @Description(value = "Тест проверяет не возможность покупки при вводе недопустимых значений")
    public void negativeCheckoutTest() {
        String expectedName = "Sauce Labs Bike Light";
        String expectedPrice = "$9.99";
        String expectedDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickShoppingCartButton();
        Assert.assertEquals(checkoutOverwiewPage.getDetailsName(), expectedName);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsPrice(), expectedPrice);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsDescription(), expectedDescription);
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMessagePresent());
    }
}
