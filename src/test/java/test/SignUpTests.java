package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SignUp;
import utils.ExcelUtils;
import utils.ExtentReportManger;

@Listeners(utils.TestListener.class)
public class SignUpTests extends BaseTest {

    //------------------- DataProvider -------------------//
    @DataProvider(name = "signupData")
    public Object[][] signUpData() {
        String path = "./src/test/java/resources/SignUpData.xlsx";
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
    @Test(priority = 1, dataProvider = "signupData")
    public void signupWithDataProvider(String testname, String name, String password,
                                       String expectedMessage, String type) {
        test = ExtentReportManger.createTest("SignUp Test - " + testname);
        test.info("Start test: " + testname);

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username: " + name);
        signupPage.enterUserName(name);

        test.info("Enter password: " + password);
        signupPage.enterPassword(password);

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), expectedMessage);
    }

    //------------------- Tests with Hard Data -------------------//
    @Test(priority = 2)
    public void signupWithValidCredentials_shouldSucceed() {
        test = ExtentReportManger.createTest("SignUp With Valid Credentials - Success");
        test.info("Start test: signupWithValidCredentials_shouldSucceed");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username");
        signupPage.enterUserName("ahmed12349654");

        test.info("Enter password");
        signupPage.enterPassword("ahmed12349654");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        Assert.assertEquals(signupPage.geAlertText(), "Sign up successful.");
    }

    @Test(priority = 3)
    public void signupWithEmptyUsername_shouldFail() {
        test = ExtentReportManger.createTest("SignUp With Empty Username - Fail");
        test.info("Start test: signupWithEmptyUsername_shouldFail");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter password only");
        signupPage.enterPassword("ahmed1234565");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        Assert.assertEquals(signupPage.geAlertText(), "Please fill out Username and Password.");
    }

    @Test(priority = 4)
    public void signupWithEmptyPassword_shouldFail() {
        test = ExtentReportManger.createTest("SignUp With Empty Password - Fail");
        test.info("Start test: signupWithEmptyPassword_shouldFail");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username only");
        signupPage.enterUserName("ahmed1234565");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        Assert.assertEquals(signupPage.geAlertText(), "Please fill out Username and Password.");
    }

    @Test(priority = 5)
    public void signupWithExistingUser_shouldFail() {
        test = ExtentReportManger.createTest("SignUp With Existing User - Fail");
        test.info("Start test: signupWithExistingUser_shouldFail");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter existing username");
        signupPage.enterUserName("moaz123");

        test.info("Enter password");
        signupPage.enterPassword("moaz123");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        Assert.assertEquals(signupPage.geAlertText(), "This user already exist.");
    }

    @Test(priority = 6)
    public void signupWithWeakPassword_shouldFail() {
        test = ExtentReportManger.createTest("SignUp With Weak Password - Fail");
        test.info("Start test: signupWithWeakPassword_shouldFail");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username");
        signupPage.enterUserName("moaz12391011");

        test.info("Enter weak password");
        signupPage.enterPassword("mo");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        Assert.assertEquals(signupPage.geAlertText(), "this password is weak");
    }
}
