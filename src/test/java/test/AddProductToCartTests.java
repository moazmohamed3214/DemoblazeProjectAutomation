package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Home;
import utils.ExtentReportManger;
@Listeners(utils.TestListener.class)
public class AddProductToCartTests extends BaseTest {
    @Test(priority = 1)
    public void validAddProductToCart()
    {
        test= ExtentReportManger.createTest("AddProductToCart");
        test.info("Open home page");
        Home page=new Home(driver);
        test.info("Select Product");
        page.clickProduct();
        test.info("Enter Add to cart Button");
        page.clickAddToCartButton();
        Assert.assertEquals(page.getAlertText(),"Product added");

    }
}
