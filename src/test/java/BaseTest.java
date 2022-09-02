import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.DriverSetup;

public class BaseTest
{
    public WebDriver driver;
    @BeforeClass
    void InvokeBrowser()
    {
        //this.driver = DriverSetup.chromeDriverInitiate();
        this.driver = DriverSetup.DriverInitiate("edge");
    }
    @AfterClass
    void teardown()
    {
        //driver.quit();
    }
}
