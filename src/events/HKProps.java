package events;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by hkon on 1/13/18.
 */
public class HKProps {
    public static Properties getProperties(int recursiondepth) {


        if (recursiondepth > 20) {
            System.out.println("recurse too deep");
            System.exit(1);

        }

        // first see if there is a prop file already

        try {
            File file = new File("confighk.properties");

            if (file.exists()) {
                FileInputStream fileInput = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInput);
                fileInput.close();

                Enumeration enuKeys = properties.keys();
                while (enuKeys.hasMoreElements()) {
                    String key = (String) enuKeys.nextElement();
                    String value = properties.getProperty(key);
                    System.out.println(key + ": " + value);
                }
                return properties;
            }
            else // create file
            {
                 writeProperties();
                 return getProperties(recursiondepth+1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // create a first prop file and return associated prop
    private static void writeProperties() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("confighk.properties");




            // set the properties value
            prop.setProperty("fontsize", "100");


            // save properties to project root folder
            prop.store(output, null);


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}



