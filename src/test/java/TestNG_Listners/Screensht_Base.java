package TestNG_Listners;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screensht_Base {
	WebDriver driver;

	public WebDriver windows_setup() 

	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		return driver;

	}

	public void SS(WebDriver driver, String tname) 
	{
		// take screen shot and store it in a file
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());

		try {
			FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screeshots\\test"+tname+timestamp()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String timestamp() {

		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
