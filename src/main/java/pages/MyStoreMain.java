package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyStoreMain extends BasePage
{
    private By signBtn = By.xpath("//a[@class=\"login\"]");
    public MyStoreMain(WebDriver driver)
    {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signBtn));
    }

    public LoginMyStore  clickSigningBtn()
    {
        driver.findElement(signBtn).click();
        return new LoginMyStore(driver);
    }


}