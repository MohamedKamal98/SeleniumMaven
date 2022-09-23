import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.DriverSetup;

public class BaseTest
{
    public WebDriver driver;
    public SoftAssert softAssert;
    @BeforeClass
    void InvokeBrowser()
    {
        softAssert = new SoftAssert();
        //this.driver = DriverSetup.chromeDriverInitiate();
        this.driver = DriverSetup.DriverInitiate("chrome");
    }
    @AfterClass
    void teardown()
    {
        //driver.quit();
    }
}
