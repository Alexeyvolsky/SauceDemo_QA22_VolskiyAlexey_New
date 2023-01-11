package tests;

import io.qameta.allure.Description;
import org.apache.hc.core5.annotation.Contract;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveButtonTest extends Basetest {
    String itemName = "Sauce Labs Backpack";

    @Test(description = "removeButtonTest", groups = "regression")
    @Description(value = "Тест проверяет работоспособность кнопки удаления товара из корзины")
    public void removeButtonTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(itemName);
        productsPage.clickShoppingCartButton();
        cartPage.removeButtonClick(itemName.replaceAll(" ", "-").toLowerCase());
        Assert.assertFalse(cartPage.isItemDescriptionDisplayed(itemName));
    }
}
