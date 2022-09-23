package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReadDataFromFile
{
    private static Map<String, String> dataMap = new HashMap<String, String>();
    private static void fileReader()
    {
        File file= new File("resources/Customer1ValidData.txt");
        try {
            BufferedReader reader =  new BufferedReader(new FileReader(file));
            String line;
            int i =0;
            while ((line = reader.readLine())!= null)
            {
                if(i==0)
                    dataMap.put("email",line);
                else if(i==1)
                    dataMap.put("firstName",line);
                else if(i==2)
                    dataMap.put("lastName",line);
                else if(i==3)
                    dataMap.put("password",line);
                else if(i==4)
                    dataMap.put("yearValue",line);
                else if (i==5)
                    dataMap.put("monthValue",line);
                else if (i==6)
                    dataMap.put("dayValue",line);
                else if (i==7)
                    dataMap.put("company",line);
                else if (i==8)
                    dataMap.put("address1",line);
                else if (i==9)
                    dataMap.put("address2",line);
                else if (i==10)
                    dataMap.put("city",line);
                else if (i==11)
                    dataMap.put("stateValue",line);
                else if(i==12)
                    dataMap.put("postcode",line);
                else if (i==13)
                    dataMap.put("countryValue",line);
                else if (i==14)
                    dataMap.put("additionalInfo",line);
                else if (i==15)
                    dataMap.put("homePhone",line);
                else if (i==16)
                    dataMap.put("mobilePhone",line);
                else if (i==17)
                    dataMap.put("aliasAddress",line);
                i++;
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, String> getData()
    {
        fileReader();
        return dataMap;
    }
}
