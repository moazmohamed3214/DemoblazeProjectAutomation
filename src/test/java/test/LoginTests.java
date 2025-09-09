package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login;
import utils.ExcelUtils;
import utils.ExtentReportManger;

import javax.naming.Name;
@Listeners(utils.TestListener.class)
public class LoginTests extends BaseTest {
    /// ///////////////Test cases with Soft data///////////////////////
    @DataProvider(name = "loginData")
    public Object[][] getData()
    {
        String path="./src/test/java/resources/loginData.xlsx";
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

    @Test(priority = 1 ,dataProvider = "loginData")
    public void loginTest(String testname,String name,String password,String expectedMessege,String type) {
        test = ExtentReportManger.createTest(testname);
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username :"+name);
        login.enterUserName(name);
        test.info("Enter password :"+password);
        login.enterPassword(password);
        test.info("Click login button");
        login.clickLoginButton();
        if (type.equals("success") ) {
            Assert.assertEquals(login.getLoginWelocmeMessege(), expectedMessege);
        } else {
            Assert.assertEquals(login.getAlertText(), expectedMessege);

        }
    }

    //---------------------------TestCases with Hard Data--------------------------------------//


    @Test(priority = 2)
    public void validLoginTest()
    {
        test= ExtentReportManger.createTest("valid Login");
        test.info("Open home page");
        Login login=new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();

        Assert.assertEquals(login.getLoginWelocmeMessege(),"Welcome moaz123");

    }
    @Test(priority = 3)
    public void invalidLoginWhereEnterInvaliduserName()
    {
        test= ExtentReportManger.createTest("valid Login when enter invalid userName");
        test.info("Open home page");
        Login login=new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter invalid username");
        login.enterUserName("moazzzzz123");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getAlertText(),"User does not exist.");


    }
    @Test(priority = 4)
    public void invalidLoginWhereEnterInvalidpassword()
    {
        test= ExtentReportManger.createTest("valid Login when enter invalid password ");
        test.info("Open home page");
        Login login=new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter invalid password");
        login.enterPassword("moaz12");
        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getAlertText(),"Wrong password.");


    }
    @Test(priority = 5)
    public void invalidLoginWhereEnterEmptyEmail()
    {
        test= ExtentReportManger.createTest("invalid Login when enter empty Email ");
        test.info("Open home page");
        Login login=new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter empty username");
        login.enterUserName("");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getAlertText(),"Please fill out Username and Password.");


    }
    @Test(priority = 6)
    public void invalidLoginWhereEnterEmptyPassword()
    {
        test= ExtentReportManger.createTest("valid Login when enter empty password ");
        test.info("Open home page");
        Login login=new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter empty password");
        login.enterPassword("");
        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getAlertText(),"Please fill out Username and Password.");

    }



}
