package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Logouttest extends Basetest {
    @Test(description = "logout test",groups = "smoke")
    public void logoutTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickMenuButton();
        productsPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }

}
