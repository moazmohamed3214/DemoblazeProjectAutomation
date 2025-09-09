package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Contact;
import pages.Login;
import utils.ExcelUtils;
import utils.ExtentReportManger;
@Listeners(utils.TestListener.class)
public class ContactTests extends BaseTest {
    @DataProvider(name = "Contact data")
    public Object[][] getData()
    {
        String path="./src/test/java/resources/contactData.xlsx";
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
    @Test(priority = 1 ,dataProvider = "Contact data")
    public void contactTest(String testName,String email,String name,String messege,String expectedMessege,String type)
    {
        test= ExtentReportManger.createTest(testName);
        test.info("Open home page");
        Contact contactPage=new Contact(driver);
        test.info("Click contact button");
        contactPage.clickContact();
        test.info("Enter contact email : "+email);
        contactPage.entercontactEmail(email);
        test.info("Enter contact name : "+name);
        contactPage.entereName(name);
        test.info("enter messege: "+messege);
        contactPage.enterMessege(messege);
        test.info("Click send messege ");
        contactPage.clickSendMessege();
            Assert.assertEquals(contactPage.getAlertText(), expectedMessege);


    }
    @Test(priority = 1)
    public void validcontact()
    {
        test= ExtentReportManger.createTest("valid contact");
        test.info("Open home page");
        Contact contactPage=new Contact(driver);
        test.info("Click contact button");
        contactPage.clickContact();
        test.info("Enter contact email");
        contactPage.entercontactEmail("moazm7176@gmail.com");
        test.info("Enter contact name");
        contactPage.entereName("moaz");
        test.info("enter messege");
        contactPage.enterMessege("ipum ipum");
        test.info("Click send messege ");
        contactPage.clickSendMessege();
        Assert.assertEquals(contactPage.getAlertText(),"Thanks for the message!!");

    }
    @Test(priority = 2)
    public void invalidcontactWhenAllFieldsIsEmpty()
    {
        test= ExtentReportManger.createTest("invalid contact");
        test.info("Open home page");
        Contact contactPage=new Contact(driver);
        test.info("Click contact button");
        contactPage.clickContact();
        test.info("Enter empty email");
        contactPage.entercontactEmail("");
        test.info("Enter empty name");
        contactPage.entereName("");
        test.info("enter empty messege");
        contactPage.enterMessege("");
        test.info("Click send messege ");
        contactPage.clickSendMessege();
        Assert.assertNotEquals(contactPage.getAlertText(),"Thanks for the message!!");

    }
    @Test(priority = 3)
    public void invalidcontactWhenenterInValidEmail()
    {
        test= ExtentReportManger.createTest("valid contact");
        test.info("Open home page");
        Contact contactPage=new Contact(driver);
        test.info("Click contact button");
        contactPage.clickContact();
        test.info("Enter contact email");
        contactPage.entercontactEmail("moazm7176.cm");
        test.info("Enter contact name");
        contactPage.entereName("moaz");
        test.info("enter messege");
        contactPage.enterMessege("ipum ipum");
        test.info("Click send messege ");
        contactPage.clickSendMessege();
        Assert.assertNotEquals(contactPage.getAlertText(),"Thanks for the message!!");

    }

}
