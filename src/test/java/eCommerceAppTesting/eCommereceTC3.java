package eCommerceAppTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import prashanthule.BrowserBaseTest;

public class eCommereceTC3 extends BrowserBaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(20000);		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("//*[text()='Products ']")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@href,'products/3')]")));
		String thirdProduct=driver.findElement(By.xpath("//*[contains(@href,'products/3')]")).getText();
		System.out.println(thirdProduct);
		Assert.assertEquals(thirdProduct, "Devops");
		
	}
}
