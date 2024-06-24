package pages;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.BasicUtils;

import io.appium.java_client.AppiumDriver;
public class LoginPage {
	BasicUtils basicUtils = new BasicUtils();
	
	public void loginUsingStandardUser(AppiumDriver driver) {
		basicUtils.sleepCertainTime(5000);
		
		
		WebElement swagLabsImageLogo= 
				driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]"));
		WebElement swagLabsImage= 
				driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[2]"));
		WebElement userNameEditText= 
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
		WebElement passwordEditText= 
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
		WebElement loginButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
		assertEquals(true, swagLabsImageLogo.isDisplayed());
		assertEquals(true, swagLabsImage.isDisplayed());
		assertEquals(true, userNameEditText.isDisplayed());
		assertEquals(true, passwordEditText.isDisplayed());
		assertEquals(true, loginButton.isDisplayed());
		
		basicUtils.scrollDownInPage(driver);
		basicUtils.sleepCertainTime(3000);
		WebElement standardUserTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"standard_user\"]"));
		assertEquals(true, standardUserTextView.isDisplayed());
		
		standardUserTextView.click();
		basicUtils.sleepCertainTime(3000);
		basicUtils.scrollUpInPage(driver);
		
		assertEquals(userNameEditText.getText(), "standard_user");
		assertNotEquals(passwordEditText.getText(), "");
		
		basicUtils.sleepCertainTime(2000);
		
		loginButton.click();
		
	}
}
