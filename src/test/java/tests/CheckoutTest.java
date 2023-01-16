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
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened, "Products page is not opened");
        isPageOpened = productsPage.clickAddToCartButton("Sauce Labs Bike Light").clickShoppingCartButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Cart page is not opened");
        Assert.assertEquals(checkoutOverwiewPage.getDetailsName(), expectedName);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsPrice(), expectedPrice);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsDescription(), expectedDescription);
        isPageOpened = cartPage.clickCheckoutButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Checkout page is not opened");
        isPageOpened = checkoutPage.setFirstNameInput("Alexey").
                setLastNameInput("Volskiy").
                setPostalCodeInput("77887").
                clickContinueButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Checkout overview page is not opened");
        checkoutOverwiewPage.clickFinishButton();
        checkoutCompletePage.isCheckoutCompletePresent();
    }

    @Test(description = "negativeCheckoutTest", groups = "regression")
    @Description(value = "Тест проверяет не возможность покупки при вводе недопустимых значений")
    public void negativeCheckoutTest() {
        String expectedName = "Sauce Labs Bike Light";
        String expectedPrice = "$9.99";
        String expectedDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened, "Products page is not opened");
        isPageOpened = productsPage.clickAddToCartButton("Sauce Labs Bike Light").
                clickShoppingCartButton().
                isPageOpened();
        Assert.assertTrue(isPageOpened,"Cart page is not opened");
        Assert.assertEquals(checkoutOverwiewPage.getDetailsName(), expectedName);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsPrice(), expectedPrice);
        Assert.assertEquals(checkoutOverwiewPage.getDetailsDescription(), expectedDescription);
        isPageOpened = cartPage.clickCheckoutButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Checkout page is not opened");
        checkoutPage.setFirstNameInput("");
        checkoutPage.setLastNameInput("Volskiy");
        checkoutPage.setPostalCodeInput("77887");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMessagePresent());
    }
}
