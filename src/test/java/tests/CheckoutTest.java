package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends Basetest{
    @Test
    public void pozitiveCheckoutTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("Alexey");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverwiewPage.isFinishButtonPresent());

    }
    @Test
    public void negativeCheckoutTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMessagePresent());


    }
}
