package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends Basetest{
    @Test(description = "pozitiveLoginTest",groups = "smoke",retryAnalyzer = Retry.class)
    public void pozitiveLoginTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }
    @Test(dataProvider = "negativeLoginTestData", description = "negativeLoginTestPassword",groups = "regression")
    public void negativeLoginTest(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageContainerPresent());
    }
    @DataProvider
    public Object[][]negativeLoginTestData(){
        return new Object[][]{
                {"standard_user", "12345678"},
                {"locked_out_user","ABCDEFGH"},
                {"Alexey","secret_sauce"},

        };
    }
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
