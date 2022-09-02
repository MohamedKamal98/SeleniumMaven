package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginMyStore extends BasePage
{
    private By createAccountEmailTxt = By.xpath("//div[@class=\"form-group\"]//input[@id=\"email_create\"]");
    private By createAccountEmailBtn = By.xpath("//div[@class=\"submit\"]//button[@class=\"btn btn-default button button-medium exclusive\"]");

    private By signInEmailTxt = By.xpath("//div[@class=\"form-group\"]//input[@id=\"email\"]");
    private By signInPasswordTxt = By.xpath("//div[@class=\"form-group\"]//input[@id=\"passwd\"]") ;
    private By signInBtn = By.xpath("//p[@class=\"submit\"]//button[@id=\"SubmitLogin\"]");

    public LoginMyStore(WebDriver driver)
    {
        super(driver);
    }

    public void writeCreateAccountEmail()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountEmailTxt));
        driver.findElement(createAccountEmailTxt).sendKeys(email);
    }
    public void clickCreateAccountEmailBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountEmailBtn));
        driver.findElement(createAccountEmailBtn).click();
    }
    public void writeSignInEmailTxt()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInEmailTxt));
        driver.findElement(signInEmailTxt).sendKeys(email);
    }
    public void writeSignInPasswordTxt()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInPasswordTxt));
        driver.findElement(signInPasswordTxt).sendKeys(password);
    }
    public void clickSignInBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
        driver.findElement(signInBtn).click();
    }
}
