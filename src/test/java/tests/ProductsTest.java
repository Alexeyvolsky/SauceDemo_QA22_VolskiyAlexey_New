package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends Basetest{

    @Test
    public void productsTest(){
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(productsPage.getItemPrice(testItemName),expectedItemPrice);
        Assert.assertEquals(productsPage.getItemDescription(testItemName),expectedItemDescription);
        Assert.assertEquals(productsPage.getItemName(testItemName),testItemName);
        productsPage.openItem(testItemName);
        Assert.assertTrue(productsPage.backToProductsPresent());
    }
}
