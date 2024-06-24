package pages;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasicUtils;

import io.appium.java_client.AppiumDriver;
public class HomePage {
	BasicUtils basicUtils = new BasicUtils();
	
	List<Double> priceListData = new ArrayList<>();
	List<Double> priceListDataSorted = new ArrayList<>();
	public String productNameAdded, priceAdded;
	
	public void checkFilterLowHighAndHighLow(AppiumDriver driver) {
		basicUtils.sleepCertainTime(5000);
		
		WebElement stripMenuImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
		WebElement swagLabsLogo= 
				driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]"));
		WebElement testToggleImage= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
		WebElement cartButtonImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
		WebElement filterButtonImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"));
		
	    assertEquals(true, stripMenuImage.isDisplayed());
		assertEquals(true, swagLabsLogo.isDisplayed());
		assertEquals(true, testToggleImage.isDisplayed());
		assertEquals(true, cartButtonImage.isDisplayed());
		assertEquals(true, filterButtonImage.isDisplayed());
		
		filterButtonImage.click();
		basicUtils.sleepCertainTime(2000);
		//after pop up filter appeared
		WebElement sortItemsByTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sort items by...\"]"));
		WebElement cancelFilterButton= 
				driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"));
		WebElement nameAZTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Name (A to Z)\"]"));
		WebElement nameZATextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Name (Z to A)\"]"));
		WebElement priceLowHigh= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Price (low to high)\"]"));
		WebElement priceHighLow= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Price (high to low)\"]"));
		
		assertEquals(true, sortItemsByTextView.isDisplayed());
		assertEquals(true, cancelFilterButton.isDisplayed());
		assertEquals(true, nameAZTextView.isDisplayed());
		assertEquals(true, nameZATextView.isDisplayed());
		assertEquals(true, priceLowHigh.isDisplayed());
		assertEquals(true, priceHighLow.isDisplayed());

		priceLowHigh.click();
		
		basicUtils.sleepCertainTime(3000);
		
		basicUtils.scrollDownInPage(driver);
		
		basicUtils.sleepCertainTime(3000);
		
		List<WebElement> priceTextElementList= 
				driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));
		WebElement priceTextElement;
		for(int i=0;i<priceTextElementList.size();i++) {
			priceTextElement=priceTextElementList.get(i);
			priceListData.add(Double.parseDouble(priceTextElement.getText().replace("$","")));
		}
		//sorted data Ascending and assert if equals to web data (assert if data list is sorted from low to high)
		List<Double> priceListDataAscSorted = priceListData.stream().sorted().collect(Collectors.toList());
		assertEquals(priceListDataAscSorted, priceListData);
		
		filterButtonImage.click();
		basicUtils.sleepCertainTime(3000);
		
		sortItemsByTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sort items by...\"]"));
		cancelFilterButton= 
				driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"));
		nameAZTextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Name (A to Z)\"]"));
		nameZATextView= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Name (Z to A)\"]"));
		priceLowHigh= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Price (low to high)\"]"));
		priceHighLow= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"Price (high to low)\"]"));
		
		assertEquals(true, sortItemsByTextView.isDisplayed());
		assertEquals(true, cancelFilterButton.isDisplayed());
		assertEquals(true, nameAZTextView.isDisplayed());
		assertEquals(true, nameZATextView.isDisplayed());
		assertEquals(true, priceLowHigh.isDisplayed());
		assertEquals(true, priceHighLow.isDisplayed());

		priceHighLow.click();
		
		basicUtils.sleepCertainTime(3000);
		
		priceTextElementList= 
				driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));
		priceTextElement=null;
		priceListData = new ArrayList<>();
		for(int i=0;i<priceTextElementList.size();i++) {
			priceTextElement=priceTextElementList.get(i);
			priceListData.add(Double.parseDouble(priceTextElement.getText().replace("$","")));
		}
		priceListDataSorted = priceListData;
		
		//sorted data Descending and assert if equals to web data (assert if data list is sorted from high to low)
		Collections.sort(priceListDataSorted, Collections.reverseOrder()); 
		assertEquals(priceListDataSorted, priceListData);
	}
	
	public void checkOutFirstProduct(AppiumDriver driver) {
		basicUtils.sleepCertainTime(5000);
		
		WebElement stripMenuImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
		WebElement swagLabsLogo= 
				driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]"));
		WebElement testToggleImage= 
				driver.findElement(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
		WebElement cartButtonImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
		WebElement filterButtonImage= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"));
		
	    assertEquals(true, stripMenuImage.isDisplayed());
		assertEquals(true, swagLabsLogo.isDisplayed());
		assertEquals(true, testToggleImage.isDisplayed());
		assertEquals(true, cartButtonImage.isDisplayed());
		assertEquals(true, filterButtonImage.isDisplayed());
		
		WebElement firstProductAddToCartButton= 
				driver.findElement(By.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]"));
		
		assertEquals(true, firstProductAddToCartButton.isDisplayed());
		
		List<WebElement> productNameTextElementList= 
				driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]"));
		assertEquals(true, productNameTextElementList.get(0).isDisplayed());
		productNameAdded=productNameTextElementList.get(0).getText();
		
		List<WebElement> priceTextElementList= 
				driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));
		assertEquals(true, priceTextElementList.get(0).isDisplayed());
		priceAdded=priceTextElementList.get(0).getText();
		
		firstProductAddToCartButton.click();
		basicUtils.sleepCertainTime(3000);
		
		WebElement removeButton= 
				driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]"));
		//after product added to cart, Add button become remove button
		assertEquals(true, removeButton.isDisplayed());
		
		/*WebElement numberCartTextView= 
				driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView"));
		//after product added to cart, number 1 will be appear in cart
		assertEquals(true, numberCartTextView.isDisplayed());
		assertEquals(numberCartTextView.getText(),"1");*/
		
		cartButtonImage.click();
	}
}
