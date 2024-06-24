package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import utils.BasicUtils;

public class CheckOutOverViewPage {
	BasicUtils basicUtils = new BasicUtils();
	public void checkCheckOutOverviewAndFinish(AppiumDriver driver, String productNameAdded, String priceAdded) {
		basicUtils.sleepCertainTime(7000);
		WebElement checkOutOverviewTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]"));
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
		WebElement paymentInformationTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Payment Information:\"]"));
		WebElement shippingInformationTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Shipping Information:\"]"));
		
		assertEquals(true, checkOutOverviewTextView.isDisplayed());
		assertEquals(true, qtyTextView.isDisplayed());
		assertEquals(true, descTextView.isDisplayed());
		assertEquals(true, productAmountTextView.isDisplayed());
		assertEquals(true, productNameTextView.isDisplayed());
		assertEquals(true, priceTextView.isDisplayed());
		assertEquals(true, paymentInformationTextView.isDisplayed());
		assertEquals(true, shippingInformationTextView.isDisplayed());
		
		assertEquals(productAmountTextView.getText(),"1");
		assertEquals(productNameTextView.getText(),productNameAdded);
		assertEquals(priceTextView.getText(),priceAdded);
		
		basicUtils.longScrollDownInPage(driver);
		basicUtils.sleepCertainTime(3000);
		/*WebElement itemTotalTextView= 
				driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[contains(text(),\"Item total: \")]"));
		WebElement taxTextView= 
				driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[contains(text(),\"Tax: \")]"));
		WebElement totalTextView= 
				driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[contains(text(),\"Total: \")]"));
		*/
		WebElement cancelButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]"));
		WebElement finishButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]"));
		
		
		//assertEquals(true, itemTotalTextView.isDisplayed());
		//assertEquals(true, taxTextView.isDisplayed());
		//assertEquals(true, totalTextView.isDisplayed());
		assertEquals(true, cancelButton.isDisplayed());
		assertEquals(true, finishButton.isDisplayed());
		
		finishButton.click();
	}
}
