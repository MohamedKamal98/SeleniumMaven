package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReport
{
    static ExtentTest test;
    static ExtentReports report;

    public static void  reportInitiate()
    {
        report = new ExtentReports("resources/"+"ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }
    public static void logStep()
    {
        test.log(LogStatus.PASS,"Test Passed");
        //test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
    }
    public static void reportFinalize()
    {
        report.endTest(test);
        report.flush();
    }
    public static String capture(WebDriver driver) throws IOException
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
}
