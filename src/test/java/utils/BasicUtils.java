package utils;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class BasicUtils {
	public void sleepCertainTime(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollDownInPage(AppiumDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(523, 1931);
		Point end = new Point (572, 1100);
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
		    PointerInput.Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
		    PointerInput.Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public void scrollUpInPage(AppiumDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(493, 466);
		Point end = new Point (493, 1333);
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
			    PointerInput.Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
		    PointerInput.Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public void longScrollDownInPage(AppiumDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(493, 2151);
		Point end = new Point (457, 664);
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
		    PointerInput.Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
		    PointerInput.Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}

}
