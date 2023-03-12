package dsalgo_Testscenarios;

import org.testng.annotations.Test;

import allureReports.AllureListeners;
import ds_algo_Utilities.XLUtils;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import dsalgo_objects.Graph_POM;
import dsalgo_objects.Datastructures_POM;
import dsalgo_objects.Login_POM;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.NavigateResponse;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
@Test@Listeners({AllureListeners.class})
public class Graph_TC extends BaseClass


{
	public WebDriver tdriver;
	@Test(priority=1)
	@Description("User is in Graph page and Trying to open Texteditor ")
	@Severity(SeverityLevel.NORMAL)
	public void graphpage() throws InterruptedException
	{Graph_POM gp=new Graph_POM(driver);
	Thread.sleep(2000);	
	driver.navigate().to(homepageURL);
	gp.dropdown();
	logger.info("User clicks on Dropdown");
	gp.graphlink();
	logger.info("User clicks on graph");
	if (driver.getTitle().equals("Graph"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	gp.graphclick();
	logger.info("User clicks on graph in graph page");
	if (driver.getTitle().equals("Graph"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	gp.graphrepresents();
	logger.info("User clicks on Graph Representations link");
	if (driver.getTitle().equals("Graph Representations"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	gp.Tryhere();
	logger.info("User clicks on Tryhere button");
	if (driver.getTitle().equals("Assessment"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}

	}

	@Test (priority=2,dataProvider="Python")
	@Description("User is in TextEditor and entering python code and expecting Output")
	@Severity(SeverityLevel.NORMAL)
	public void graphText_Editor(String code) throws InterruptedException
	{
		Graph_POM gp=new Graph_POM(driver);
		gp.pythoncode(code);
		logger.info("user is entering code");
		
		gp.Run();
		Thread.sleep(2000);
		logger.info("user clicks Run ");
		logger.info("Output is -"+gp.output());
		
		if(gp.output()==null)
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


	@Test(priority=3)
	@Description("User is clicking Run and expecting Output")
	@Severity(SeverityLevel.NORMAL)
	public void back_to_home() throws InterruptedException 
	{
		Graph_POM gp=new Graph_POM(driver);
		driver.navigate().to(homepageURL);
		Assert.assertTrue(false);
	    gp.logout();

	}


	//dataprovider is used here to fetch python code from excel sheet

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
