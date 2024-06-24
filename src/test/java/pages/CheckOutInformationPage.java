package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import utils.BasicUtils;

public class CheckOutInformationPage {
	BasicUtils basicUtils = new BasicUtils();
	public void checkCheckOutInformationPageAndContinue(AppiumDriver driver) {
		basicUtils.sleepCertainTime(7000);
		WebElement checkOutInfotextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: INFORMATION\"]"));
		WebElement firstnameEditText= 
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]"));
		WebElement lastNameEditText= 
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]"));
		WebElement zipPostalCodeEditText= 
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]"));
		WebElement cancelButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]"));
		WebElement continueButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]"));
		
		assertEquals(true, checkOutInfotextView.isDisplayed());
		assertEquals(true, firstnameEditText.isDisplayed());
		assertEquals(true, lastNameEditText.isDisplayed());
		assertEquals(true, zipPostalCodeEditText.isDisplayed());
		assertEquals(true, cancelButton.isDisplayed());
		assertEquals(true, continueButton.isDisplayed());
		
		//fill data
		firstnameEditText.sendKeys("Jonathan");
		lastNameEditText.sendKeys("Hindharta");
		zipPostalCodeEditText.sendKeys("111111");
		
		basicUtils.sleepCertainTime(2000);
		//click continue to next page
		continueButton.click();
	}
}
