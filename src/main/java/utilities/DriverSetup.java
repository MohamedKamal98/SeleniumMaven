package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup
{
    private static String url;
    public static WebDriver chromeDriverInitiate()
    {
        System.setProperty("webdriver.chrome.driver",
                "resources/chromedriver.exe");
        /*
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "resources/chromedriver.exe");

         */
        WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    public static WebDriver DriverInitiate(String browser)
    {
        url = PropertyFileSetup.properties.getProperty("url");
        WebDriver driver = null;
        if (browser == "chrome")
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser == "firefox")
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser == "edge")
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("Browser is not Supported");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
