package TestNG_Listners;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class CustomListner extends Screensht_Base implements ITestListener {
	
	WebDriver driver =null;
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	
	}
	
	@Override
	public void onTestFailure(ITestResult result)  {
		System.out.println("Failed Test");
		ITestContext context=result.getTestContext();
		driver= (WebDriver) context.getAttribute("WebDriver");
		SS(driver, "test");
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	
	
	
	

}
