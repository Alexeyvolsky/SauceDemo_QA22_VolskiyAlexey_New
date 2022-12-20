package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends Basetest{

    @Test(description = "test details",groups = "smoke")
    public void detailsTest(){
        String expectedDetailsName = "Sauce Labs Backpack";
        String expectedDetailsPrice = "$29.99";
        String expectedDetailsDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(expectedDetailsName);
        Assert.assertEquals(productDetailsPage.getDetailsDescription(),expectedDetailsDescription);
        Assert.assertEquals(productDetailsPage.getDetailsName(),expectedDetailsName);
        Assert.assertEquals(productDetailsPage.getDetailsPrice(),expectedDetailsPrice);
    }
}
