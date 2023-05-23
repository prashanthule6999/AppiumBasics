package eCommerceAppTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import prashanthule.BaseTest;
import prashanthule.Utils;

public class eCommereceTC1 extends BaseTest{

	@Test
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String actualError = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(actualError, "Please enter your name");
		

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prashant Hule");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		Utils.scrollToElementAction("Argentina");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
	}
}
