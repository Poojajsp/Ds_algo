package dsalgo_Testscenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Datastructures;
import dsalgo_objects.Graph;
import dsalgo_objects.Sign_in;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_StructuresTc_001 extends BaseClass {
	

	@Test
	public void a_Timecomplex()
	{
		Datastructures DS=new Datastructures(driver);
		DS.Get_started();
		logger.info("User is clicking on Get-Started button");
		DS.Time_Complexity();
		
		DS.Tryhere();
	}
	
	@Test (dataProvider="Python")
	public void b_Timecomplex_editor(String code) throws InterruptedException
	{
		Datastructures DS=new Datastructures(driver);
		Thread.sleep(2000);
		DS.pythoncode(code);
		DS.Run();
		driver.navigate().to("https://dsportalapp.herokuapp.com/home");
		
	}
	@DataProvider(name="Python")
	String [][] getdata() throws IOException 
	 {
	 String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\pythoncode.xlsx";
	 int rownum=XLUtils.getRowCount(path,"Sheet1");
	 int cocount=XLUtils.getcellcount(path,"Sheet1",1);
	String pycode[][]=new String[rownum][cocount];
	for(int i=1; i<=rownum;i++)
	{
		for(int j=0;j<cocount;j++)
	{
			pycode[i-1][j]=XLUtils.getcellData(path,"Sheet1",i,j);
			}
	 }
	return pycode;}
}
