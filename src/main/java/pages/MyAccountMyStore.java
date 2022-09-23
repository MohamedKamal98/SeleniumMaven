package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountMyStore extends BasePage
{
    private By cstAccountBtn = By.xpath("//div[@class=\"header_user_info\"]//a[@class=\"account\"]");

    private By womenMenuBtn = By.xpath("//div[@id=\"block_top_menu\"]//a[@class=\"sf-with-ul\"and @title=\"Women\"]");
    private By womenT_shirtsbtn = By.xpath("//ul[@class=\"submenu-container clearfix first-in-line-xs\"]//a[@title=\"T-shirts\"]");

    public MyAccountMyStore(WebDriver driver)
    {
        super(driver);
    }
    public Boolean checkCstName(String firstName, String lastName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cstAccountBtn));
         return driver.findElement(cstAccountBtn).getText().equals((firstName + " " + lastName));
    }
    public void chooseWomenT_shirt()
    {
        // mouse hover
        actions.moveToElement(driver.findElement(womenMenuBtn));
        //sub menu
        actions.moveToElement(driver.findElement(womenT_shirtsbtn));
        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }
}
