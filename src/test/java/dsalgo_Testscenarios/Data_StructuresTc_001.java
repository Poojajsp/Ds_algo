package dsalgo_Testscenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Datastructures;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_StructuresTc_001 extends BaseClass

{
	
	@Test
	public void a_Timecomplex()
	{
		Datastructures DS=new Datastructures(driver);
		driver.get(homepageURL);
		logger.info("User is in the homepage");
		DS.Get_started();
		logger.info("User is clicking on Get-Started button");
		DS.Time_Complexity();
		logger.info("User is clicking on Time_Complexity");
		DS.Tryhere();
	}
	
	@Test (dataProvider="Python")
	public void b_Timecomplex_editor(String code) throws InterruptedException
	{
		Datastructures DS=new Datastructures(driver);
	Thread.sleep(5000);
		DS.pythoncode(code);
		   logger.info("user is entering code");}
	@Test
	public void c_Run()
	{Datastructures DS=new Datastructures(driver);
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
