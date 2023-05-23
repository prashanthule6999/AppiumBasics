package prashanthule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDropGesture extends BaseTest {

	@Test
	public static void dragDropGestureTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement webEle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));		
		Utils.dragDropActions(webEle, 620, 556);
		
		Thread.sleep(5000);
	}
}
