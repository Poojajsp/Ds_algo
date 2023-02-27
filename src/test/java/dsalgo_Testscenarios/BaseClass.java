package dsalgo_Testscenarios;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

import ds_algo_Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 ReadConfig readconfig=new ReadConfig();
	 
public String baseURL=readconfig.getapplicationURL();
public String username=readconfig.getusername();
public String password=readconfig.getpassword();
public String homepageURL=readconfig.gethomepageURL();
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
		//System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
            driver=new ChromeDriver();

  
  }
	else if(br.equals("firefox"))
			{WebDriverManager.firefoxdriver().setup();	
			PropertyConfigurator.configure("Log4j.properties");
			logger =Logger.getLogger("DS-ALGO Project");
		//System.setProperty("webdriver.gecko.driver",readconfig.getfirefox());
    driver=new FirefoxDriver();}
	
	else if(br.equals("msedge"))
			{WebDriverManager.edgedriver().setup();	
			PropertyConfigurator.configure("Log4j.properties");
			logger =Logger.getLogger("DS-ALGO Project");
		//System.setProperty("webdriver.edge.driver",readconfig.getmsedge());
   driver=new EdgeDriver();    }
  }
	else
	{return driver;}
driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
driver.manage().window().maximize();
	driver.get(baseURL);
	tdriver.set(driver);
	return getDriver();
}

//Screenshot
public void SS(WebDriver driver, String tname) 
{
	// take screen shot and store it in a file
	File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Timestamp timestamp= new Timestamp(System.currentTimeMillis());
	
		try {
			FileUtils.copyFile(scrfile,new File("C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\Screeshots\\test_"+tname+"_"+timestamp()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtils.copyFile(scrfile,new File("filename+.jpeg"));
	}

public static String timestamp() {
	//Comment
	
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}




@AfterClass
public void tearDown()
{
	//driver.quit();
}


public static synchronized WebDriver getDriver() {
	// TODO Auto-generated method stub
	return tdriver.get();
}
}



