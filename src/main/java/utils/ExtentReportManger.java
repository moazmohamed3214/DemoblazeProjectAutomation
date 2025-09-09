package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManger {
    private static ExtentReports extent;
    private static ExtentTest test;
    public static ExtentReports getReportInstance()
    {
        if (extent==null)
        {
            String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String path="Reports/ExtentReport_"+date+".html";
            ExtentSparkReporter reporter=new ExtentSparkReporter(path);
            reporter.config().setReportName("test name");
            reporter.config().setDocumentTitle("report name");
            extent=new ExtentReports();
            extent.attachReporter(reporter);


        }
        return extent;

    }
    public static ExtentTest createTest(String testName)
    {
        test= getReportInstance().createTest(testName);
        return test;
    }
}
