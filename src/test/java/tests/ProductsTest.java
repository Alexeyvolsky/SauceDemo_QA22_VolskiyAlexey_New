package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsTest extends Basetest {

    @Test(dataProvider = "productTestData", description = "products test", groups = "regression")
    @Description(value = "Тест проверяет работоспособность перехода на страницу каждого из товаров")
    public void productsTest(String testItemName, String expectedItemPrice, String expectedItemDescription) {
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        Assert.assertEquals(productsPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(productsPage.getItemDescription(testItemName), expectedItemDescription);
        Assert.assertEquals(productsPage.getItemName(testItemName), testItemName);
        isPageOpened = productsPage.openItem(testItemName).isPageOpened();
        Assert.assertTrue(isPageOpened,"Product details page is not opened");
        Assert.assertTrue(productsPage.backToProductsPresent());
    }

    @DataProvider
    public Object[][] productTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds" +
                        " uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when" +
                        " riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt." +
                        " From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece" +
                        " jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development." +
                        " Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying" +
                        " up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."},
        };
    }

    @Test(dataProvider = "sorting", retryAnalyzer = Retry.class, description = "sorting test", groups = {"regression"})
    @Description(value = "Тест проверяет правильность сортировки товаров")
    public void sortingTest(String sortByValue, List<String> itemNames) {
        boolean isPageOpened = loginPage.setUsername("standard_user").
                setPassword("secret_sauce").
                clickLoginButton().isPageOpened();
        Assert.assertTrue(isPageOpened,"Products page is not opened");
        productsPage.selectSortingOption(sortByValue);
        Assert.assertEquals(productsPage.getProductNames(), itemNames);

    }

    @DataProvider()
    public Object[][] sorting() {
        return new Object[][]{
                {"za", Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                        "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack")},
                {"lohi", Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket")},
                {"hilo", Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light", "Sauce Labs Onesie")},
                {"az", Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")},
        };
    }
}
