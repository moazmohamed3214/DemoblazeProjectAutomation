package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentReportManger;
@Listeners(utils.TestListener.class)
public class EndToEndSenarioTest extends BaseTest {
    String userName="moaz196522134312";
    String password="moaz196522134312";

    @Test(priority = 1)
    public void EndToEndSenarioTest() {

        test = ExtentReportManger.createTest(" EndToEnd Senario Test");
        SignUp signUp = new SignUp(driver);
        test.info("click on siginup button");
        signUp.clickSignUp();
        test.info("enter user name");
        signUp.enterUserName(userName);
        test.info("enter password");
        signUp.enterPassword(password);
        test.info("click sign up button");
        signUp.clickSignUpButton();
        test.pass("sign up sucessfully");
        Assert.assertEquals(signUp.geAlertText(), "Sign up successful.");
        test.pass(" Sign up successful.");

        Login login = new Login(driver);

        test.info("Click on login button");
        login.clickLogin();

        test.info("Enter username");
        login.enterUserName(userName);

        test.info("Enter password");
        login.enterPassword(password);

        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getLoginWelocmeMessege(), "Welcome " + userName);


        Home homePage = new Home(driver);
        test.info("Opened home page");

        test.info("Selecting a product");
        homePage.clickProduct();


        test.info("Clicking 'Add to Cart' button");
        homePage.clickAddToCartButton();


        test.info("Verifying alert text after adding product");
        Assert.assertEquals(homePage.getAlertText(), "Product added.");


        String expectedName = homePage.getNameText();
        String expectedPrice = homePage.getPriceText().substring(1,4);

        test.info("Captured product name: " + expectedName);
        test.info("Captured product price: " + expectedPrice);


        Cart cartPage = new Cart(driver);
        test.info("Navigating to Cart page");
        cartPage.clickcartNavigationLink();


        test.info("Verifying product details inside Cart");
        Assert.assertEquals(cartPage.getProductNameText(), expectedName, "Product name mismatch in cart!");
        Assert.assertEquals(cartPage.getProductPriceText(), expectedPrice, "Product price mismatch in cart!");
        Payment payment = new Payment(driver);
        test.info("Click place order button");
        payment.clickPlaceOrderButton();

        test.info("Enter name");
        payment.enterName("name");

        test.info("Enter country");
        payment.enterCountry("egypt");

        test.info("Enter city");
        payment.enterCity("sohag");

        test.info("Enter credit card");
        payment.enterCreditCard("242534");

        test.info("Enter month");
        payment.enterMonth("233");

        test.info("Enter year");
        payment.enterYear("2025");

        test.info("Click purchase button");
        payment.clickPurchaseButton();

        test.info("Verify success message");
        Assert.assertEquals(payment.getDoneMessege(), "Thank you for your purchase!");

    }


}
