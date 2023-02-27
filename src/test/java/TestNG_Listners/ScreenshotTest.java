package TestNG_Listners;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListner.class)

public class ScreenshotTest extends Screensht_Base {
	WebDriver driver;
	
@BeforeClass
public void setDriver(ITestContext context) {
	driver=windows_setup();
	context.setAttribute("WebDriver", driver);
}
	
	@BeforeMethod
	public void setup()
	{
		
	}
	
	@Test
	
	public void TakesScreenshot()
	{
		assertEquals(false, true);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
