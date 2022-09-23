package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyStoreMain extends BasePage
{
    private By signBtn = By.xpath("//a[@class=\"login\"]");
    public MyStoreMain(WebDriver driver)
    {
        super(driver);
    }

    public void  clickSigningBtn()
    {
        driver.findElement(signBtn).click();
    }


}