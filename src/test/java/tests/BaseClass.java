package tests;

import java.net.URI;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class BaseClass {
	
	public static AppiumDriver driver;
	@BeforeSuite
	public void setup() {
		UiAutomator2Options options = new UiAutomator2Options()
			       .setPlatformName("Android")
			       .setPlatformVersion("11")
			       .setUdid("29e46e30")
			       //.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\apps\\Android.SauceLabs.Mobile.app.2.7.1.apk")
			       //.setAppWaitActivity("com.swaglabsmobileapp.SplashActivity");
			       .setAppPackage("com.swaglabsmobileapp")
			       .setAppActivity("com.swaglabsmobileapp.SplashActivity");
		
		try {
			URI uri =  new URI("http://127.0.0.1:4723");
			driver = new AppiumDriver(uri.toURL(), options);
			

		} catch (Exception exp) {
			System.out.println("Exception Cause is: "+exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	
	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
