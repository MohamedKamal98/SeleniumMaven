package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileSetup
{
    public static Properties properties;
    public static void propertiesInitiate()
    {
        properties = System.getProperties();
        try {
            properties.load(new FileInputStream(new File("resources/data.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}