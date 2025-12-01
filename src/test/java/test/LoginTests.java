package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login;
import utils.ExcelUtils;
import utils.ExtentReportManger;

@Listeners(utils.TestListener.class)
public class LoginTests extends BaseTest {

    //------------------- DataProvider -------------------//
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        String path = "./src/test/java/resources/loginData.xlsx";
        ExcelUtils.readExelFile(path, "sheet1");
        int row = ExcelUtils.getNumOfRow();
        int col = ExcelUtils.getNumOfColumn();
        Object[][] data = new Object[row - 1][col];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ExcelUtils.getCellData(i, j);
            }
        }
        return data;
    }

    //------------------- Tests with DataProvider -------------------//
    @Test(priority = 1, dataProvider = "loginData")
    public void loginWithDataProvider(String testname, String name, String password, String expectedMessage, String type) {
        test = ExtentReportManger.createTest("Login Test - " + testname);
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username: " + name);
        login.enterUserName(name);
        test.info("Enter password: " + password);
        login.enterPassword(password);
        test.info("Click login button");
        login.clickLoginButton();

        if (type.equals("success")) {
            Assert.assertEquals(login.getLoginWelocmeMessege(), expectedMessage);
        } else {
            Assert.assertEquals(login.getAlertText(), expectedMessage);
        }
    }

    //------------------- Tests with Hard Data -------------------//
    @Test(priority = 2)
    public void loginWithValidCredentials_shouldSucceed() {
        test = ExtentReportManger.createTest("Login With Valid Credentials - Success");
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();

        Assert.assertEquals(login.getLoginWelocmeMessege(), "Welcome moaz123");
    }

    @Test(priority = 3)
    public void loginWithInvalidUsername_shouldFail() {
        test = ExtentReportManger.createTest("Login With Invalid Username - Fail");
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter invalid username");
        login.enterUserName("moazzzzz123");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();

        Assert.assertEquals(login.getAlertText(), "User does not exist.");
    }

    @Test(priority = 4)
    public void loginWithInvalidPassword_shouldFail() {
        test = ExtentReportManger.createTest("Login With Invalid Password - Fail");
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter invalid password");
        login.enterPassword("moaz12");
        test.info("Click login button");
        login.clickLoginButton();

        Assert.assertEquals(login.getAlertText(), "Wrong password.");
    }

    @Test(priority = 5)
    public void loginWithEmptyUsername_shouldFail() {
        test = ExtentReportManger.createTest("Login With Empty Username - Fail");
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter empty username");
        login.enterUserName("");
        test.info("Enter password");
        login.enterPassword("moaz123");
        test.info("Click login button");
        login.clickLoginButton();

        Assert.assertEquals(login.getAlertText(), "Please fill out Username and Password.");
    }

    @Test(priority = 6)
    public void loginWithEmptyPassword_shouldFail() {
        test = ExtentReportManger.createTest("Login With Empty Password - Fail");
        test.info("Open home page");
        Login login = new Login(driver);
        test.info("Click login button");
        login.clickLogin();
        test.info("Enter username");
        login.enterUserName("moaz123");
        test.info("Enter empty password");
        login.enterPassword("");
        test.info("Click login button");
        login.clickLoginButton();
        Assert.assertEquals(login.getAlertText(), "Please fill out Username and Password.");
    }
}
