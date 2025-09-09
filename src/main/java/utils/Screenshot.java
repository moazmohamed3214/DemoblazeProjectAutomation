package utils;


import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot extends BaseTest {

    public static String takeScreenshot(String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String folder = "/Reports/Screenshots/";
        String fileName = screenshotName + "_" + dateName + ".png";
        String fullPath = System.getProperty("user.dir") + folder + fileName;

        try {
            FileUtils.copyFile(source, new File(fullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "screenshots/" + fileName;
    }


}
