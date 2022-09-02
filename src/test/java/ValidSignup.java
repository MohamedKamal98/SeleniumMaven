import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginMyStore;
import pages.MyAccountMyStore;
import pages.MyStoreMain;
import pages.SignupMyStore;

public class ValidSignup extends BaseTest
{
    private MyStoreMain MyStore;
    private SignupMyStore signupMyStore;
    private LoginMyStore loginMyStore;
    private MyAccountMyStore myAccountMyStore;
    @BeforeClass
    private void intializeObjects()
    {
        MyStore = new MyStoreMain(driver);
        signupMyStore = new SignupMyStore(this.driver);
        loginMyStore = new LoginMyStore(this.driver);
        myAccountMyStore = new MyAccountMyStore(this.driver);
    }

    @Test (priority = -1)
    public void verifyPageTitle()
    {
        Assert.assertEquals(driver.getTitle(),"My Store");
    }
    @Test
    public void verifyCreatingAccount()
    {
        MyStore.clickSigningBtn();
        loginMyStore.writeCreateAccountEmail();
        loginMyStore.clickCreateAccountEmailBtn();
        signupMyStore.fillCustomerData();
        verifyEmail();
        signupMyStore.clickRegisterBtn();
        verifyCstName();
    }
    private void verifyEmail()
    {
        Assert.assertEquals(signupMyStore.checkEmail(),signupMyStore.getEmail());
    }
    private void  verifyCstName()
    {
        Assert.assertTrue(myAccountMyStore.checkCstName());
    }
}
