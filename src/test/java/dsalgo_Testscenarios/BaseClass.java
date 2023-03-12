package dsalgo_Testscenarios;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Date;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import ds_algo_Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getapplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public String homepageURL=readconfig.gethomepageURL();
	public String ArrayURL=readconfig.getArrayURL();


	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver =new ThreadLocal<WebDriver>();

	public static Logger logger;



	@Parameters("browser")
	@BeforeClass
	public WebDriver setup(String br)
	{
		if(driver==null) 
		{
			if(br.equals("chrome"))
			{	WebDriverManager.chromedriver().setup();
			PropertyConfigurator.configure("Log4j.properties");
			logger =Logger.getLogger("DS-ALGO Project");

			driver=new ChromeDriver();


			}
			else if(br.equals("firefox"))
			{WebDriverManager.firefoxdriver().setup();	
			PropertyConfigurator.configure("Log4j.properties");
			logger =Logger.getLogger("DS-ALGO Project");


			driver=new FirefoxDriver();}

			else if(br.equals("msedge"))
			{WebDriverManager.edgedriver().setup();	
			PropertyConfigurator.configure("Log4j.properties");
			logger =Logger.getLogger("DS-ALGO Project");

			driver=new EdgeDriver();    }
		}
		else
		{return driver;}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		tdriver.set(driver);
		return getDriver();
	
}

@AfterSuite
public void quit()
{logger.info("Logout Succesful....Quitting Browser.");
	driver.quit();
}


public static synchronized WebDriver getDriver() {
	// TODO Auto-generated method stub
	return tdriver.get();
}
}



