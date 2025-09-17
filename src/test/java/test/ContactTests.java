package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Contact;
import utils.ExcelUtils;
import utils.ExtentReportManger;

@Listeners(utils.TestListener.class)
public class ContactTests extends BaseTest {

    ////////////////////// Data-Driven Tests ////////////////////////
    @DataProvider(name = "contact data")
    public Object[][] getContactData() {
        String path = "./src/test/java/resources/contactData.xlsx";
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

    @Test(priority = 1, dataProvider = "contact data")
    public void contactTest(String testName, String email, String name, String message, String expectedMessage, String type) {
        test = ExtentReportManger.createTest(testName);
        test.info("Start test: " + testName);

        Contact contactPage = new Contact(driver);

        test.info("Click on contact button");
        contactPage.clickContact();

        test.info("Enter contact email: " + email);
        contactPage.enterContactEmail(email);

        test.info("Enter contact name: " + name);
        contactPage.enterName(name);

        test.info("Enter message: " + message);
        contactPage.enterMessage(message);

        test.info("Click Send Message button");
        contactPage.clickSendMessage();

        test.info("Verify alert text");
        Assert.assertEquals(contactPage.getAlertText(), expectedMessage);
    }


    ////////////////////// Hardcoded Tests ////////////////////////
    @Test(priority = 2)
    public void validContact() {
        test = ExtentReportManger.createTest("validContact");
        test.info("Start test: validContact");

        Contact contactPage = new Contact(driver);

        test.info("Click on contact button");
        contactPage.clickContact();

        test.info("Enter valid contact email");
        contactPage.enterContactEmail("moazm7176@gmail.com");

        test.info("Enter valid contact name");
        contactPage.enterName("Moaz");

        test.info("Enter valid message");
        contactPage.enterMessage("Hello, this is a valid test message.");

        test.info("Click Send Message button");
        contactPage.clickSendMessage();

        test.info("Verify alert text");
        Assert.assertEquals(contactPage.getAlertText(), "Thanks for the message!!");
    }

    @Test(priority = 3)
    public void invalidContactWhenAllFieldsEmpty() {
        test = ExtentReportManger.createTest("invalidContactWhenAllFieldsEmpty");
        test.info("Start test: invalidContactWhenAllFieldsEmpty");

        Contact contactPage = new Contact(driver);

        test.info("Click on contact button");
        contactPage.clickContact();

        test.info("Enter empty email");
        contactPage.enterContactEmail("");

        test.info("Enter empty name");
        contactPage.enterName("");

        test.info("Enter empty message");
        contactPage.enterMessage("");

        test.info("Click Send Message button");
        contactPage.clickSendMessage();

        test.info("Verify alert text");
        Assert.assertNotEquals(contactPage.getAlertText(), "Thanks for the message!!");
    }

    @Test(priority = 4)
    public void invalidContactWhenInvalidEmail() {
        test = ExtentReportManger.createTest("invalidContactWhenInvalidEmail");
        test.info("Start test: invalidContactWhenInvalidEmail");

        Contact contactPage = new Contact(driver);

        test.info("Click on contact button");
        contactPage.clickContact();

        test.info("Enter invalid email");
        contactPage.enterContactEmail("moazm7176.cm");

        test.info("Enter valid name");
        contactPage.enterName("Moaz");

        test.info("Enter valid message");
        contactPage.enterMessage("Invalid email format test.");

        test.info("Click Send Message button");
        contactPage.clickSendMessage();

        test.info("Verify alert text");
        Assert.assertNotEquals(contactPage.getAlertText(), "Thanks for the message!!");
    }
}
