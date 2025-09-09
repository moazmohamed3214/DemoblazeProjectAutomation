package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentReportManger;


public class BaseTest {
    protected static WebDriver driver;
    protected static ExtentTest test;
    protected ExtentReports extent;
    @BeforeSuite
    public void setUpReport()
    {
        extent = ExtentReportManger.getReportInstance();
    }
    @AfterSuite
    public void tearDown()
    {

        extent.flush();
    }

    @BeforeMethod
    public void setUp()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html#");


    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }

}
