package prashanthule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {

	@Test
	public static void longGestureTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		Utils.longPressAction(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")), 2000);

		WebElement webEle2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']"));
		Assert.assertTrue(webEle2.isDisplayed());
		String menuText = webEle2.getText();
		Assert.assertEquals(menuText, "Sample menu");
	}

}
