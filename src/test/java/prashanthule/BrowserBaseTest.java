package prashanthule;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserBaseTest {
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configAppium() throws MalformedURLException {

		/*
		 * service = new AppiumServiceBuilder().withAppiumJS(new File(
		 * "C://Users//Prashant Raju Hule//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"
		 * )) .withIPAddress("127.0.0.1").usingPort(4723).build();
		 * 
		 * service.start();
		 */

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Prashantemulator");
		options.setChromedriverExecutable("F:\\eclipse-workspace-2022-2023\\MobileTesting\\src\\test\\java\\resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(320));
	}

	@AfterClass
	public void tearDown() {
		/*
		 * driver.quit(); service.stop();
		 */
	}
}
