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
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened, "Products page is not opened");
        isPageOpened = productsPage.clickAddToCartButton(itemName).clickShoppingCartButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Cart page is not opened");
        cartPage.removeButtonClick(itemName.replaceAll(" ", "-").toLowerCase());
        Assert.assertFalse(cartPage.isItemDescriptionDisplayed(itemName));
    }
}
