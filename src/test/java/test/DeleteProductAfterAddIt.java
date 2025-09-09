package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Home;
import utils.ExtentReportManger;
@Listeners(utils.TestListener.class)
public class DeleteProductAfterAddIt extends BaseTest {
    @Test(priority = 1)
    public void deleteProductAfterAdd() {
        test = ExtentReportManger.createTest("delete Product After Add it");


        Home homePage = new Home(driver);
        test.info("Opened home page");

        test.info("Selecting a product");
        homePage.clickProduct();


        test.info("Clicking 'Add to Cart' button");
        homePage.clickAddToCartButton();


        test.info("Verifying alert text after adding product");
        Assert.assertEquals(homePage.getAlertText(), "Product added");


        String expectedName = homePage.getNameText();
        String expectedPrice = homePage.getPriceText().replace("$", "").trim();

        test.info("Captured product name: " + expectedName);
        test.info("Captured product price: " + expectedPrice);


        Cart cartPage = new Cart(driver);
        test.info("Navigating to Cart page");
        cartPage.clickcartNavigationLink();
        cartPage.clickDeleteButton();

    }
}
