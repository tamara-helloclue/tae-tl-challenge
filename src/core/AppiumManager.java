package core;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumManager {
	
	public static AppiumDriver<MobileElement> driver;
	private InputStream inputStream;
	
	@BeforeTest
	public void DesiredCapabilities() throws MalformedURLException {
			
	    	Properties desiredcapabilitiesFile = loadPropertiesFile("android.properties");
	    	DesiredCapabilities mDsrdCpblties = new DesiredCapabilities();
			mDsrdCpblties.setCapability("deviceName",desiredcapabilitiesFile.getProperty("deviceName"));
			mDsrdCpblties.setCapability("app",desiredcapabilitiesFile.getProperty("appName"));
			mDsrdCpblties.setCapability("locationServicesEnabled",desiredcapabilitiesFile.getProperty("locationServicesEnabled"));
			mDsrdCpblties.setCapability("gpsEnabled",desiredcapabilitiesFile.getProperty("gpsEnabled"));
			mDsrdCpblties.setCapability("autoGrantPermissions",desiredcapabilitiesFile.getProperty("autoGrantPermissions"));
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://" + desiredcapabilitiesFile.getProperty("hub_URL")+ ":" + desiredcapabilitiesFile.getProperty("port") + "/wd/hub"), mDsrdCpblties);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {

				e.printStackTrace();

			}
	}
		
		public Properties loadPropertiesFile(String fileName) {
			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			try {
				prop.load(inputStream);
			} catch (IOException e) {

				e.printStackTrace();
			}
			return prop;
		}
		@AfterTest
		public void tearDownDriver() {
			try {
				driver.close();
			} catch (Exception e) {
			}
			

		}
}
