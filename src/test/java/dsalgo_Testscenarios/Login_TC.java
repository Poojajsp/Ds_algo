package dsalgo_Testscenarios;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import allureReports.AllureListeners;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Login_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Test@Listeners({AllureListeners.class})
public class Login_TC extends BaseClass

{
	public WebDriver tdriver;

	@Test(priority=1)
	@Description("User is clicking Signin and expecting loginpage")
	@Severity(SeverityLevel.NORMAL)
	public void a_opensign_inpage() throws InterruptedException
	{
		Login_POM lpd=new Login_POM(driver);
		driver.get(baseURL);
		Thread.sleep(1000);
		lpd.homebutton();
		logger.info("User is in the page-"+driver.getTitle());
		logger.info("User clicks on GetStarted button");
		}

	@Test(priority=2)
	public void sign_inpage()
	{
		Login_POM lpd=new Login_POM(driver);
		lpd.SIGN();
		logger.info("user clicks on Signin button");
		logger.info("User is in the "+driver.getTitle()+"page");

	}

	@Test(priority=3,dataProvider="Valid_Logindata")
	public void aa_loginDDT(String user, String psd) throws InterruptedException
	{
		Login_POM lpd=new Login_POM(driver);
		lpd.setusername(user);
		logger.info("Enters Username");
		lpd.setpassword(psd);
		logger.info("Enters Password");
		lpd.Loginbutton();
		logger.info("clicks on Login Button");
		Thread.sleep(1000);
		logger.info("User is in the "+driver.getTitle()+"page");

		if(driver.getCurrentUrl().equals(homepageURL))
		{
			logger.info("Login Successful");
			assertTrue(true);
			
		}

		else 
		{
		
			logger.info("Login not  Successful");
			assertTrue(false);
		
	    }
	}


	@DataProvider(name="Valid_Logindata")
	String [][] getData() throws IOException 
	{	  
		String dir = System.getProperty("user.dir");
		String path=dir+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"Login");
		int cocount=XLUtils.getcellcount(path,"Login",1);
		String logindata[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getcellData(path,"Login",i,j);
			}
		}
		return logindata;
	}

}



