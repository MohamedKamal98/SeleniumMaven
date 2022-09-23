package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import utilities.ReadDataFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SignupMyStore extends BasePage
{
    private By mrRadioBtn = By.xpath("(//div[@class=\"radio\"])[1]//span");
    private By mrsRadioBtn = By.xpath("(//div[@class=\"radio\"])[2]//span");

    //First Name
    private By firstNameTxt = By.xpath("//div[@class=\"required form-group\"]//input[@id=\"customer_firstname\"]");
    //Last Name
    private By lastNameTxt = By.xpath("//div[@class=\"required form-group\"]//input[@id=\"customer_lastname\"]");
    //Email
    private By emailTxt = By.xpath("//div[@class=\"required form-group\"]//input[@id=\"email\"]");
    //Password
    private By passwordTxt = By.xpath("//div[@class=\"required password form-group\"]//input[@id=\"passwd\"]");
    //Date of birth
        //days
    private Select drpDays;
    private By dobDays = By.xpath("//div[@class=\"selector\"]//select[@id=\"days\"]");
        //month
    private Select drpMonths;
    private By dobMonths = By.xpath("//div[@class=\"selector\"]//select[@id=\"months\"]");
        //year
    private Select drpYears;
    private By dobYears = By.xpath("//div[@class=\"selector\"]//select[@id=\"years\"]");
    //Receive special offers from our partners
    private By checkBoxReceiveOffers = By.xpath("(//div[@class=\"checkbox\"])[1]//span");
    //Company
    private By companyTxt = By.xpath("//p[@class=\"form-group\"]//input[@id=\"company\"]");
    // Address 1
    private By address1Txt = By.xpath("//p[@class=\"required form-group\"]//input[@id=\"address1\"]");
    // Address 2
    private By address2Txt = By.xpath("//p[@class=\"form-group is_customer_param\"]//input[@id=\"address2\"]");
    //City
    private By cityTxt = By.xpath("//p[@class=\"required form-group\"]//input[@id=\"city\"]");
    // State
    private Select drpState;
    //private By state = By.xpath("//div[@class=\"selector\"]//select[@id=\"id_state\"]");
    private By state = By.xpath("//select[@name=\"id_state\"]");
    //Zip/Postal Code
    private By postcodeTxt = By.xpath("//p[@class=\"required postcode form-group\"]//input[@id=\"postcode\"]");
    // Country
    private Select drpCountry;
    private By country = By.xpath("//div[@class=\"selector\"]//select[@id=\"id_country\"]");
    // Additional information
    private By additionalInfoTxt = By.xpath("//p[@class=\"textarea form-group\"]//textarea[@id=\"other\"]");
    // Home Phone
    private By homePhoneTxt = By.xpath("//p[@class=\"form-group\"]//input[@id=\"phone\"]");
    // Mobile Phone
    private By mobilePhoneTxt = By.xpath("//p[@class=\"required form-group\"]//input[@id=\"phone_mobile\"]");
    // Assign an address alias for future reference. *
    private By aliasAddressTxt = By.xpath("//p[@class=\"required form-group\"]//input[@id=\"alias\"]");
    // Sign up Button
    private By registerBtn =By.xpath("//div[@class=\"submit clearfix\"]//button[@id=\"submitAccount\"]");

    public SignupMyStore(WebDriver driver)
    {
        super(driver);
    }

    public void fillCustomerData()
    {
        clickMaleRadioBtn();
        writeFirstName(ReadDataFromFile.getData().get("firstName"));
        writeLastName(ReadDataFromFile.getData().get("lastName"));
        writePassword(ReadDataFromFile.getData().get("password"));
        selectDateOfBirth(
                ReadDataFromFile.getData().get("dayValue"),
                ReadDataFromFile.getData().get("monthValue"),
                ReadDataFromFile.getData().get("yearValue")
        );
        clickCheckBoxReceiveOffers();
        writeCompany(ReadDataFromFile.getData().get("company"));
        writeAddress1(ReadDataFromFile.getData().get("address1"));
        writeAddress2(ReadDataFromFile.getData().get("address2"));
        writeCity(ReadDataFromFile.getData().get("city"));
        selectState(ReadDataFromFile.getData().get("stateValue"));
        writePostcode(ReadDataFromFile.getData().get("postcode"));
        selectCountry(ReadDataFromFile.getData().get("countryValue"));
        writeAdditionalInfo(ReadDataFromFile.getData().get("additionalInfo"));
        writeHomePhone(ReadDataFromFile.getData().get("homePhone"));
        writeMobilePhone(ReadDataFromFile.getData().get("mobilePhone"));
        writeAliasAddress(ReadDataFromFile.getData().get("aliasAddress"));

    }
    public void  clickRegisterBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn));
        driver.findElement(registerBtn).click();
    }
    private void clickMaleRadioBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mrRadioBtn));
        driver.findElement(mrRadioBtn).click();
    }
    private void selectDateOfBirth(String dayValue, String monthValue, String yearValue)
    {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dobDays));
        drpDays = new Select(driver.findElement(dobDays));
        drpDays.selectByValue(dayValue);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dobMonths));
        drpMonths = new Select(driver.findElement(dobMonths));
        drpMonths.selectByValue(monthValue);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dobYears));
        drpYears = new Select(driver.findElement(dobYears));
        drpYears.selectByValue(yearValue);
    }
    private void writeFirstName(String firstName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTxt));
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }
    private void writeLastName(String lastName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTxt));
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }
    public String checkEmail()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxt));
        //return driver.findElement(emailTxt).getText();
        return driver.findElement(emailTxt).getAttribute("value");
    }
    private void writePassword(String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxt));
        driver.findElement(passwordTxt).sendKeys(password);
    }
    private void clickCheckBoxReceiveOffers()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxReceiveOffers));
        driver.findElement(checkBoxReceiveOffers).click();
    }
    private void writeCompany(String company)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyTxt));
        driver.findElement(companyTxt).sendKeys(company);
    }
    private void writeAddress1(String address1)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(address1Txt));
        driver.findElement(address1Txt).sendKeys(address1);
    }
    private void writeAddress2(String address2)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(address2Txt));
        driver.findElement(address2Txt).sendKeys(address2);
    }
    private void writeCity(String city)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityTxt));
        driver.findElement(cityTxt).sendKeys(city);
    }
    private void selectState(String stateValue)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_state")));
        drpState = new Select(driver.findElement(state));
        drpState.selectByValue(stateValue);
    }
    private void  writePostcode(String postcode)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postcodeTxt));
        driver.findElement(postcodeTxt).sendKeys(postcode);
    }
    private void selectCountry(String countryValue)
    {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        drpCountry = new Select(driver.findElement(country));
        drpCountry.selectByValue(countryValue);
    }
    private void writeAdditionalInfo(String additionalInfo)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(additionalInfoTxt));
        driver.findElement(additionalInfoTxt).sendKeys(additionalInfo);
    }
    private void writeHomePhone(String homePhone)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePhoneTxt));
        driver.findElement(homePhoneTxt).sendKeys(homePhone);
    }
    private void writeMobilePhone(String mobilePhone)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhoneTxt));
        driver.findElement(mobilePhoneTxt).sendKeys(mobilePhone);
    }
    private void writeAliasAddress(String aliasAddress)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aliasAddressTxt));
        driver.findElement(aliasAddressTxt).clear();
        driver.findElement(aliasAddressTxt).sendKeys(aliasAddress);
    }
}
