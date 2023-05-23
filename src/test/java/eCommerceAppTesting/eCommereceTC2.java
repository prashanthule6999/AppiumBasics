package eCommerceAppTesting;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import prashanthule.BaseTest;
import prashanthule.Utils;

public class eCommereceTC2 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prashant Hule");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		Utils.scrollToElementAndClickAction("Argentina");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// Product Page Verification
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")), "text", "Products"));
		String productPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).getText();
		Assert.assertEquals(productPageTitle, "Products");

		// Product Selection
		Utils.scrollToElementAction("Jordan 6 Rings");
		List<WebElement> productsItems = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

		int productCount = productsItems.size();
		System.out.println("Product : Total Product  :- " + productCount);

		for (int i = 0; i < productCount; i++) {
			String productName = productsItems.get(i).getText();
			if (productName.equals("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// Cart Page Verification
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Cart']")), "text", "Cart"));
		String cartPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Cart']")).getText();
		Assert.assertEquals(cartPageTitle, "Cart");

		List<WebElement> cartsItemsName = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

		int cartsCount = cartsItemsName.size();
		System.out.println("Cart : Total Product  :- " + cartsCount);

		Assert.assertEquals(cartsItemsName.get(0).getText(), "Air Jordan 9 Retro");
		Assert.assertEquals(cartsItemsName.get(1).getText(), "Jordan 6 Rings");

		double sum = 0;
		List<WebElement> cartsItemsPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		for (int i = 0; i < cartsCount; i++) {
			String price = cartsItemsPrice.get(i).getText();
			double f = Utils.stringToDouble(price);
			sum = sum + f;
		}
		System.out.println("Total Price of Items Added to Cart : " + sum);

		String actualTotalCartPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
				.getText().trim();
		Assert.assertEquals(Utils.stringToDouble(actualTotalCartPrice), sum);

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		Utils.longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")), 2000);

		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText(),
				"Terms Of Conditions");
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(20000);
		Set<String> contextNames = driver.getContextHandles();
		for (String context : contextNames) {
			System.out.println(context);
			if (context.contains("WEBVIEW")) {
				driver.context(context);
			}
		}
		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(20000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
	}
}
