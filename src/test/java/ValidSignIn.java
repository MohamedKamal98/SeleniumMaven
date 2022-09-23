import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginMyStore;
import pages.MyAccountMyStore;
import pages.MyStoreMain;
import utilities.ReadDataFromExcel;
import utilities.ReadDataFromFile;

import java.io.IOException;

public class ValidSignIn extends BaseTest
{
    MyStoreMain myStoreMain;
    LoginMyStore loginMyStore;
    MyAccountMyStore  myAccountMyStore;

    @DataProvider(name = "ValidUserLoginData")
    private Object[][] userLoginData() throws IOException
    {
        return ReadDataFromExcel.getExcelData("Login.xlsx","validLogin",2);
    }

    @BeforeClass
    private void initializeObject()
    {
        myStoreMain = new MyStoreMain(this.driver);
        loginMyStore = new LoginMyStore(this.driver);
        myAccountMyStore = new MyAccountMyStore(this.driver);
    }
    @Test(dataProvider = "ValidUserLoginData")
    public void verifyLoginIn(String email,String password)
    {
        myStoreMain.clickSigningBtn();
        //loginMyStore.writeSignInEmailTxt(ReadDataFromFile.getData().get("email"));
        //loginMyStore.writeSignInPasswordTxt(ReadDataFromFile.getData().get("password"));
        loginMyStore.writeSignInEmailTxt(email);
        loginMyStore.writeSignInPasswordTxt(password);
        loginMyStore.clickSignInBtn();
        softAssert.assertEquals(myAccountMyStore.getCstName(),
                ReadDataFromFile.getData().get("firstName") +
                        " " +ReadDataFromFile.getData().get("lastName")
        );
        //verifyCstName();
        //myAccountMyStore.chooseWomenT_shirt();
        softAssert.assertAll();
    }
    private void  verifyCstName()
    {
        Assert.assertEquals(myAccountMyStore.getCstName(),
                ReadDataFromFile.getData().get("firstName") +
                        " " +ReadDataFromFile.getData().get("lastName")
        );
    }

}
