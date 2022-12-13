package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends Basetest{
    @Test
    public void pozitiveLoginTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }
    @Test
    public void negativeLoginTestUser(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("12345678");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageContainerPresent());
    }
    @Test
    public void negativeLoginTestPassword(){
        loginPage.setUsername("Alexey");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageContainerPresent());
    }
}
