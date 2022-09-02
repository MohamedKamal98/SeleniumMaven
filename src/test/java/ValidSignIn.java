import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginMyStore;
import pages.MyAccountMyStore;
import pages.MyStoreMain;

public class ValidSignIn extends BaseTest
{
    MyStoreMain myStoreMain;
    LoginMyStore loginMyStore;
    MyAccountMyStore  myAccountMyStore;
    @BeforeClass
    private void initializeObject()
    {
        myStoreMain = new MyStoreMain(this.driver);
        loginMyStore = new LoginMyStore(this.driver);
        myAccountMyStore = new MyAccountMyStore(this.driver);
    }
    @Test
    public void verifyLoginIn()
    {
        myStoreMain.clickSigningBtn();
        loginMyStore.writeSignInEmailTxt();
        loginMyStore.writeSignInPasswordTxt();
        loginMyStore.clickSignInBtn();
        verifyCstName();
        myAccountMyStore.chooseWomenT_shirt();
    }
    private void  verifyCstName()
    {
        Assert.assertTrue(myAccountMyStore.checkCstName());
    }

}
