package dsalgo_Testscenarios;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG_Listners.CustomListner;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Datastructures_POM;
import io.qameta.allure.Description;

public class Data_Structures_TC extends BaseClass
{

@Test(priority=1)
@Description("User is navigating to Assessment page From Data Structures-Introduction and enters python code")
public void Timecomplex()
{
	Datastructures_POM DS=new Datastructures_POM(driver);
	//driver.get(homepageURL);
	logger.info("User is in the "+driver.getTitle()+" page");
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

@Test(priority=2,dataProvider="Python")
public void DSText_editor(String code) throws InterruptedException
{
	Datastructures_POM DS=new Datastructures_POM(driver);
	DS.pythoncode(code);
	logger.info("user is entering code");
	Thread.sleep(2000);
	DS.Run();
	logger.info("user clicks Run ");
	logger.info("Output is -"+DS.output());
	if(DS.output()==null)
	{
	        Assert.assertEquals(false, true);
		
	        Alert alert=driver.switchTo().alert(); 
	        Thread.sleep(3000);
	        alert.dismiss();
	   }
	else 
	{
		Assert.assertEquals(true, true);
	}
	driver.navigate().refresh();
}


@AfterClass
public void n()
{
	driver.navigate().to(homepageURL);}

@DataProvider(name="Python")
String [][] getdata() throws IOException 

{		String userdirectory =  System.getProperty("user.dir");
String path=userdirectory+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
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
