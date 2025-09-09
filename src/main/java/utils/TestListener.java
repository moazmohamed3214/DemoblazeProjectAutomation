package utils;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        BaseTest base = (BaseTest) currentClass;

        if (base.test != null) {
            String screenshot = Screenshot.takeScreenshot(result.getName());
            base.test.fail(result.getThrowable());
            try {
                base.test.addScreenCaptureFromPath(screenshot);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object currentClass = result.getInstance();
        BaseTest base = (BaseTest) currentClass;
        if (base.test != null) {
            base.test.pass("Test Passed");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }



}
