package dsalgo_Testscenarios;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.PropertyConfigurator;
import java.time.Duration;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(baseURL);
		tdriver.set(driver);
		return getDriver();
	}

	/*//Screenshot
public void SS(WebDriver driver, String tname) 
{
	// take screen shot and store it in a file
	File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Timestamp timestamp= new Timestamp(System.currentTimeMillis());

		try {
			String Path = System.getProperty("user.dir");

			FileUtils.copyFile(scrfile,new File(Path+"src\\test\\resources\\Screeshots\\test_"+tname+"_"+timestamp()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public static String timestamp() {

	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}

	 */


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



