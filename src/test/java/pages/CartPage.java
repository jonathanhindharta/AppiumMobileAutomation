package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import utils.BasicUtils;

public class CartPage {
	BasicUtils basicUtils = new BasicUtils();
	public void checkCartDetailAndCheckOut(AppiumDriver driver, String productNameAdded, String priceAdded) {
		basicUtils.sleepCertainTime(5000);
		WebElement yourCartTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"YOUR CART\"]"));
		WebElement qtyTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"QTY\"]"));
		WebElement descTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"DESCRIPTION\"]"));
		WebElement productAmountTextView= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Amount\"]/android.widget.TextView"));
		WebElement productNameTextView= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView"));
		WebElement priceTextView= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView"));
		WebElement removeButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]"));
		WebElement continueShoppingButton= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"CONTINUE SHOPPING\"]"));
		WebElement checkOutButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]"));
		
		
		assertEquals(true, yourCartTextView.isDisplayed());
		assertEquals(true, qtyTextView.isDisplayed());
		assertEquals(true, descTextView.isDisplayed());
		assertEquals(true, productAmountTextView.isDisplayed());
		assertEquals(true, productNameTextView.isDisplayed());
		assertEquals(true, priceTextView.isDisplayed());
		assertEquals(true, removeButton.isDisplayed());
		assertEquals(true, continueShoppingButton.isDisplayed());
		assertEquals(true, checkOutButton.isDisplayed());
		
		assertEquals(productAmountTextView.getText(),"1");
		assertEquals(productNameTextView.getText(),productNameAdded);
		assertEquals(priceTextView.getText(),priceAdded);
		
		checkOutButton.click();
	}
	
}
