package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadDataFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginMyStore extends BasePage
{
    //private By createAccountEmailTxt = By.xpath("//input[@id=\"email_create\"]");
    private By createAccountEmailTxt =  By.xpath("//input[@name=\"email_create\"]");

    //private By createAccountEmailBtn = By.xpath("//button[@class=\"btn btn-default button button-medium exclusive\"]");
    //private By createAccountEmailBtn = By.xpath("//button[@id=\"SubmitCreate\"]");
    private By createAccountEmailBtn = By.xpath("//button[@name=\"SubmitCreate\"]");

    private By signInEmailTxt = By.xpath("//input[@id=\"email\"]");

    //private By signInPasswordTxt = By.xpath("//input[@id=\"passwd\"]");
    private By signInPasswordTxt = By.xpath("//input[@name=\"passwd\"]");

    //private By signInBtn = By.xpath("//button[@id=\"SubmitLogin\"]");
    //private By signInBtn = By.xpath("//button[@name=\"SubmitLogin\"]");
    private By signInBtn = By.xpath("//button[@class=\"button btn btn-default button-medium\"]");

    public LoginMyStore(WebDriver driver)
    {
        super(driver);
    }

    public void writeCreateAccountEmail(String email)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountEmailTxt));
        driver.findElement(createAccountEmailTxt).sendKeys(email);
    }
    public void clickCreateAccountEmailBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountEmailBtn));
        driver.findElement(createAccountEmailBtn).click();
    }
    public void writeSignInEmailTxt(String email)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInEmailTxt));
        driver.findElement(signInEmailTxt).sendKeys(email);
    }
    public void writeSignInPasswordTxt(String password)
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
