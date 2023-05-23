package prashanthule;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollGesture extends BaseTest {

	@Test
	public static void scrollGestureTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Utils.scrollToElementAction("ImageView");
		Utils.scrollToEndAction();
		Thread.sleep(3000);
	}
}
