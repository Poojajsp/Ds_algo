package dsalgo_Testscenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG_Listners.CustomListner;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Datastructures;
import io.qameta.allure.Description;
@Listeners(CustomListner.class)
public class Data_StructuresTc_001 extends BaseClass

{
	public void  setDriver(ITestContext context) 

	{
		context.setAttribute("WebDriver", driver);
	}

	@Test(priority=1)
	@Description("User is navigating to Assessment page From Data Structures-Introduction and enters python code")
	public void Timecomplex()
	{
		Datastructures DS=new Datastructures(driver);
		driver.get(homepageURL);
		logger.info("User is in the homepage");
		DS.Get_started();
		logger.info("User is clicking on Get-Started button");
		if(driver.getTitle().equals("Data Structures-Introduction"))
		{
			logger.info("User is in the "+driver.getTitle());
		}
		else
		{
			Assert.assertEquals(true, false);
		}

		DS.Time_Complexity();
		logger.info("User is clicking on Time_Complexity");
		if(driver.getTitle().equals("Time Complexity"))
		{
			logger.info("User is in the "+driver.getTitle());
		}
		else
		{
			Assert.assertEquals(true, false);
		}

		DS.Tryhere();
		if(driver.getTitle().equals("Assessment"))
		{
			logger.info("User is in the "+driver.getTitle());
		}
		else
		{
			Assert.assertEquals(true, false);
		}

	}

	@Test (priority=2,dataProvider="Python")
	public void Timecomplex_editor(String code) throws InterruptedException
	{
		Datastructures DS=new Datastructures(driver);
	/* WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.wait();*/
		DS.pythoncode(code);
		logger.info("user is entering code");
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void Run()
	{
		Datastructures DS=new Datastructures(driver);
	DS.Run();
	logger.info("user clicks Run ");
	driver.navigate().to(homepageURL);
	}
	@DataProvider(name="Python")
	String [][] getdata() throws IOException 
	{
		//String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		String dir = System.getProperty("user.dir");
		String path=dir+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"python_code");
		int cocount=XLUtils.getcellcount(path,"python_code",1);
		String pycode[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				pycode[i-1][j]=XLUtils.getcellData(path,"python_code",i,j);
			}
		}
		return pycode;}
}
