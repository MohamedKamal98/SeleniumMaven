package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BasePage
{
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    String email = "MohamedKamal@gmail.com";
    String firstName = "Mohamed";
    String lastName = "Kamal";
    String password = "mkamal9";
    String yearValue = "1998";
    String monthValue = "7";
    String dayValue = "17";
    String company = "Vodafone";
    String address1 = "52 othman ibn affan";
    String address2 = "Safeer Square";
    String city = "Cairo";
    String stateValue = "36";
    String postcode = "12345";
    String countryValue =  "21";
    String additionalInfo = "Thank  you :)";
    String homePhone = "0222410610";
    String mobilePhone = "01064468332";
    String aliasAddress = "Alias Address";

    BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 20);
        actions = new Actions(this.driver);
        this.filereader();

    }
    public void filereader()
    {
        File file= new File("resources/Customer1ValidData.txt");
        try {
            BufferedReader reader =  new BufferedReader(new FileReader(file));
            String line;
            int i =0;
            while ((line = reader.readLine())!= null)
            {
                if(i==0)
                    email =line;
                else if(i==1)
                    firstName = line;
                else if(i==2)
                    lastName = line;
                else if(i==3)
                    password = line;
                else if(i==4)
                    yearValue =  line;
                else if (i==5)
                    monthValue = line;
                else if (i==6)
                    dayValue = line;
                else if (i==7)
                    company = line;
                else if (i==8)
                    address1 = line;
                else if (i==9)
                    address2 = line;
                else if (i==10)
                    city = line;
                else if (i==11)
                    stateValue =line;
                else if(i==12)
                    postcode = line;
                else if (i==13)
                    countryValue = line;
                else if (i==14)
                    additionalInfo = line;
                else if (i==15)
                    homePhone = line;
                else if (i==16)
                    mobilePhone = line;
                else if (i==17)
                    aliasAddress = line;
                i++;
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
