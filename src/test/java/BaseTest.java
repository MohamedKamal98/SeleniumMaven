import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.DriverSetup;

public class BaseTest
{
    public WebDriver driver;

    @BeforeClass
    void InvokeBrowser()
    {
        //this.driver = DriverSetup.chromeDriverInitiate();
        this.driver = DriverSetup.DriverInitiate("chrome");
    }
    @AfterClass
    void teardown()
    {
        //driver.quit();
    }
}
