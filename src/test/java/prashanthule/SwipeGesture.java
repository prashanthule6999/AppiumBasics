package prashanthule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public static void scrollGestureTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(
				ExpectedConditions.attributeContains(By.xpath("(//android.widget.ImageView)[1]"), "focusable", "true"));
		
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),
				"true");

		WebElement webEle = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Utils.swipeAction(webEle, "left");

		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),
				"false");

	}
}
