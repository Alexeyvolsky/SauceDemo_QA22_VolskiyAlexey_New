package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends Basetest {
    @Test(description = "pozitiveLoginTest", groups = "smoke", retryAnalyzer = Retry.class)
    @Description(value = "Тест проверяет вход при вводе допустимых значений")
    public void pozitiveLoginTest() {
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }

    @Test(dataProvider = "negativeLoginTestData", description = "negativeLoginTestPassword", groups = "regression")
    @Description(value = "Тест проверяет не возможность входа при вводе недопустимых значений")
    public void negativeLoginTest(String username, String password) {
        loginPage.setUsername(username).
                setPassword(password).
                clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageContainerPresent());
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"standard_user", "12345678"},
                {"locked_out_user", "ABCDEFGH"},
                {"Alexey", "secret_sauce"},

        };
    }

    @Test(description = "logout test", groups = "smoke")
    @Description(value = "Тест проверяет роботоспособность выхода из аккаунта")
    public void logoutTest() {
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        isPageOpened = productsPage.clickMenuButton().clickLogout().isPageOpened();
        Assert.assertTrue(isPageOpened,"Login page is not opened");
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
}
