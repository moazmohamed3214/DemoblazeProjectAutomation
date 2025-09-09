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

    /// ///////////////Test cases with Soft data///////////////////////
    @DataProvider(name="signup data")
    public Object[][] SignUpData()
    {
        String path="./src/test/java/resources/SignUpData.xlsx";
        ExcelUtils.readExelFile(path,"sheet1");
        int row=ExcelUtils.getNumOfRow();
        int col=ExcelUtils.getNumOfColumn();
        Object[][] data=new Object[row-1][col];
        for (int  i=1;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                data[i-1][j]=ExcelUtils.getCellData(i,j);
            }
        }
        return data;

    }
    @Test(priority = 1 ,dataProvider = "signup data")
    public void SinupRest(String testname,String name,String password,String expectedMessege,String type) {
        test= ExtentReportManger.createTest(testname);
        test.info("Start test: "+testname);

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username : "+name);
        signupPage.enterUserName(name);

        test.info("Enter password : "+password);
        signupPage.enterPassword(password);

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        if(type.equals("valid")) {
            Assert.assertEquals(signupPage.geAlertText(), expectedMessege);
        }
        else {
            Assert.assertEquals(signupPage.geAlertText(), expectedMessege);

        }

    }
    /// ///////////////Test cases with Hard data///////////////////////
    @Test(priority = 1)
    public void validSinup() {
        test= ExtentReportManger.createTest("validSinup");
        test.info("Start test: validSinup");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username");
        signupPage.enterUserName("ahmed12349654");

        test.info("Enter password");
        signupPage.enterPassword("ahmed12349654");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), "Sign up successful.");

    }

    @Test(priority = 2)
    public void invalidSignupwhereUsenameIsEmpty() {
        test= ExtentReportManger.createTest("invalid Signup where Usename Is Empty");
        test.info("Start test: invalid Signup where Usename Is Empty");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter password only");
        signupPage.enterPassword("ahmed1234565");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), "Please fill out Username and Password.");
    }

    @Test(priority = 3)
    public void invalidSignupWherePasswordIsEmpty() {
        test= ExtentReportManger.createTest("invalidSignup where password Is Empty");

        test.info("Start test: invalidSignupWherePasswordIsEmpty");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username only");
        signupPage.enterUserName("ahmed1234565");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), "Please fill out Username and Password.");
    }

    @Test(priority = 4)
    public void invalidSinup() {
        test= ExtentReportManger.createTest("invalidSinup");

        test.info("Start test: invalidSinup");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter existing username");
        signupPage.enterUserName("moaz123");

        test.info("Enter password");
        signupPage.enterPassword("moaz123");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), "This user already exist.");
    }

    @Test(priority = 5)
    public void invalidSinupWhereEnterWeakPassword() {
        test= ExtentReportManger.createTest("invalidSinup Where Enter Weak Password");
        test.info("Start test: invalidSinupWhereEnterWeakPassword");

        SignUp signupPage = new SignUp(driver);

        test.info("Click on signup button");
        signupPage.clickSignUp();

        test.info("Enter username");
        signupPage.enterUserName("moaz12391011");

        test.info("Enter weak password");
        signupPage.enterPassword("mo");

        test.info("Click Sign Up button");
        signupPage.clickSignUpButton();

        test.info("Verify alert text");
        Assert.assertEquals(signupPage.geAlertText(), "this password is weak");

    }
}
