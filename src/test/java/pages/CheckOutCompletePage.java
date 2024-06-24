package pages;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import utils.BasicUtils;
public class CheckOutCompletePage {
	BasicUtils basicUtils = new BasicUtils();
	public void checkCheckOutCompletePage(AppiumDriver driver) {
		basicUtils.sleepCertainTime(7000);
		WebElement checkOutCompleteTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]"));
		WebElement thankYouTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]"));
		WebElement backHomeButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]"));
		
		assertEquals(true, checkOutCompleteTextView.isDisplayed());
		assertEquals(true, thankYouTextView.isDisplayed());
		assertEquals(true, backHomeButton.isDisplayed());
		
		backHomeButton.click();
		basicUtils.sleepCertainTime(3000);
	}
}
