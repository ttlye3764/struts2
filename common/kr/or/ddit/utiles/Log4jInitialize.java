package kr.or.ddit.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInitialize {
	public static void init(){
		
		
		URL log4jURL = Log4jInitialize.class.getResource("/kr/or/ddit/log4j/config/log4j.properties");
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(new File(log4jURL.toURI())));
			PropertyConfigurator.configure(properties);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
