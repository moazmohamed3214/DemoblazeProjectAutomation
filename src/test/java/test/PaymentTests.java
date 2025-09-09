package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Payment;
import utils.ExcelUtils;
import utils.ExtentReportManger;
@Listeners(utils.TestListener.class)
public class PaymentTests extends BaseTest {

    /// //////////////////////TestCases with Soft Data////////////////////////
    @DataProvider(name = "PaymentData")
    public Object[][] getData()
    {
        String path="./src/test/java/resources/PaymentData.xlsx";
        ExcelUtils.readExelFile(path,"sheet1");
        int row=ExcelUtils.getNumOfRow();
        int col=ExcelUtils.getNumOfColumn();
        Object[][] data=new Object[row-1][col];
        for (int i=1;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                data[i-1][j]=ExcelUtils.getCellData(i,j);
            }
        }
        return data;

    }

    @Test(priority = 1,dataProvider = "PaymentData")
    public void paymentTest(String name,String country ,String city,String card,String month,String year,String expectedMessege,String type) {
        test = ExtentReportManger.createTest("Valid Payment");
        test.info("open Website");

        Cart cart = new Cart(driver);
        test.info("Click cart navigation link");
        cart.clickcartNavigationLink();

        Payment payment = new Payment(driver);
        test.info("Click place order button");
        payment.clickPlaceOrderButton();

        test.info("Enter name");
        payment.enterName(name);

        test.info("Enter country");
        payment.enterCountry(country);

        test.info("Enter city");
        payment.enterCity(city);

        test.info("Enter credit card");
        payment.enterCreditCard(card);

        test.info("Enter month");
        payment.enterMonth(month);

        test.info("Enter year");
        payment.enterYear(year);

        test.info("Click purchase button");
        payment.clickPurchaseButton();

        test.info("Verify success message");
        if(type.equals("valid"))
        {
            Assert.assertEquals(payment.getDoneMessege(), expectedMessege);
        }
        else
        {
            Assert.assertEquals(payment.geAlertText(), expectedMessege);
        }

    }
    /// //////////////////////TestCases with Hrad Data////////////////////////
    @Test(priority = 1)
    public void validpayment() {
        test = ExtentReportManger.createTest("Valid Payment");
        test.info("open Website");

        Cart cart = new Cart(driver);
        test.info("Click cart navigation link");
        cart.clickcartNavigationLink();

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

    @Test(priority = 2)
    public void invalidpaymentWhenFieldIsEmpty() {
        test = ExtentReportManger.createTest("Invalid Payment - Empty Name");
        test.info("open Website");

        Cart cart = new Cart(driver);
        test.info("Click cart navigation link");
        cart.clickcartNavigationLink();

        Payment payment = new Payment(driver);
        test.info("Click place order button");
        payment.clickPlaceOrderButton();

        test.info("Enter empty name");
        payment.enterName("");

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

        test.info("Verify alert message");
        Assert.assertEquals(payment.geAlertText(), "Please fill out Name and Creditcard.");
    }

    @Test(priority = 3)
    public void invalidpaymentWhenEnterNameAndCardOnly() {
        test = ExtentReportManger.createTest("Invalid Payment - Only Name and Card");
        test.info("open Website");

        Cart cart = new Cart(driver);
        test.info("Click cart navigation link");
        cart.clickcartNavigationLink();

        Payment payment = new Payment(driver);
        test.info("Click place order button");
        payment.clickPlaceOrderButton();

        test.info("Enter name");
        payment.enterName("moaz");

        test.info("Enter credit card");
        payment.enterCreditCard("242534");

        test.info("Click purchase button");
        payment.clickPurchaseButton();

        test.info("Verify success message");
        Assert.assertEquals(payment.getDoneMessege(), "Thank you for your purchase!");
    }
}
