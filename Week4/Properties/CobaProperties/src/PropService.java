import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropService {
	public static void print() throws IOException {
		File f = new File("coba.properties");
		FileReader reader;
		try {
			reader = new FileReader(f);
	        BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        
	}
	public static void updateValue(String key, String value) {
		Properties props = new Properties();
	    String propsFileName = "coba.properties";
	    File f = new File(propsFileName); 
	    if(!f.exists()) {
	    	setProp(key, value);
	    } else {
	    	try {
	  	      //first load old one:
	  	      FileInputStream configStream = new FileInputStream(propsFileName);
	  	      props.load(configStream);
	  	      configStream.close();
	  	      //modifies existing or adds new property
	  	      props.setProperty(key, value);
	  	      //save modified property file
	  	      FileOutputStream output = new FileOutputStream(propsFileName);
	  	      props.store(output,null);
	  	      output.close();
	  	      System.out.println(props);
	  	    } catch (IOException ex) {
	  	      ex.printStackTrace();
	  	    }
	    }
	}
		
	public static void setProp(String key, String value) {
		try (OutputStream output = new FileOutputStream("coba.properties")) {
            Properties prop = new Properties();
            // set the properties value
            prop.setProperty(key, value);
            // save properties to project root folder
            prop.store(output, null);
            output.close();
            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
	}


}
