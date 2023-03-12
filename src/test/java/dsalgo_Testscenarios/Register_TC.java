package dsalgo_Testscenarios;



import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG_Listners.CustomListner;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Register_POM;
@Listeners(CustomListner.class)
public class Register_TC extends BaseClass
{ 
	
	@BeforeClass
	public void setDriver(ITestContext context) 
	{
		context.setAttribute("WebDriver", driver);
	}
	@Test(priority=1)
	public void openregpage()
	{
		Register_POM reg=new Register_POM(driver);
		driver.get(baseURL);
		reg.homepage();
		reg.dropdown();
		reg.array();
		reg.registerpage();
	}

	@Test(priority=2,dataProvider="Registerdata")
	public void register(String user, String psd, String psd2) throws InterruptedException
	{
		Register_POM reg=new Register_POM(driver);
		reg.setusername(user);

		reg.setpaswrd(psd);

		reg.setpaswrd2(psd2);

		reg.submit();

		if(driver.getCurrentUrl().equals(homepageURL))
		{
			logger.info("Register Successful");
			
			Thread.sleep(5000);
			assertTrue(true);
			
		}

		else 
		{
		
			logger.info("Register not  Successful");
			assertTrue(false);
		
	    }

	}
	@Test(priority=3)
	public void backto_home()
	{
		//driver.navigate().to(baseURL);
	}


	@DataProvider(name="Registerdata")
	String [][] getData() throws IOException 
	{
		String userdirectory =  System.getProperty("user.dir");
		String path=userdirectory+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"Register");
		int cocount=XLUtils.getcellcount(path,"Register",1);
		String regdata[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				regdata[i-1][j]=XLUtils.getcellData(path,"Register",i,j);
			}
		}
		return regdata;
	}
}

