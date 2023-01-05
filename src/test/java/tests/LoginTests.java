package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends Basetest{
    @Test(description = "pozitiveLoginTest",groups = "smoke",retryAnalyzer = Retry.class)
    @Description(value = "Тест проверяет вход при вводе допустимых значений")
    public void pozitiveLoginTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }
    @Test(dataProvider = "negativeLoginTestData", description = "negativeLoginTestPassword",groups = "regression")
    @Description(value = "Тест проверяет не возможность входа при вводе недопустимых значений")
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
    @Description(value = "Тест проверяет роботоспособность выхода из аккаунта")
    public void logoutTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickMenuButton();
        productsPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
}
