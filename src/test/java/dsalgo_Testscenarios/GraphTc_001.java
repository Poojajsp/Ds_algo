package dsalgo_Testscenarios;

import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import dsalgo_objects.Graph;
import dsalgo_objects.Datastructures;
import dsalgo_objects.Sign_in;
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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.NavigateResponse;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
  
public class GraphTc_001 extends BaseClass


{
	@Test(priority=1)
	@Description("User is in Graph page and Trying to open Texteditor ")
	@Severity(SeverityLevel.NORMAL)
	public void b_graphpage() throws InterruptedException
	{Graph gp=new Graph(driver);
	Thread.sleep(2000);	
	gp.dropdown();
	gp.graphlink();
	gp.graphclick();
	gp.Tryhere();
}
	
	@Test (priority=2,dataProvider="Python")
	@Description("User is in TextEditor and entering python code")
	@Severity(SeverityLevel.NORMAL)
	public void c_graphlink(String code) throws InterruptedException
	{
		Graph gp=new Graph(driver);
		Thread.sleep(2000);
		gp.pythoncode(code);}
	
	@Test(priority=3)
	@Description("User is clicking Run and expecting Output")
	@Severity(SeverityLevel.NORMAL)
	public void d_run() {
		Graph gp=new Graph(driver);
		gp.Run();
		driver.navigate().back();
		
		}
	@Test(priority=4)
	public void e_graphreprsntspage()
	{
		Graph gp=new Graph(driver);
		gp.graphrepresents();
		gp.Tryhere();
	}
	
	@Test (priority=5,dataProvider="Python")
	public void f_graphrprnts(String code)
	{
	Graph gp=new Graph(driver);
		gp.pythoncode(code);}
	@Test(priority=6)
	public void g_run() {
		Graph gp=new Graph(driver);
		gp.Run();	
	driver.navigate().to("https://dsportalapp.herokuapp.com/home");
	}


//dataprovider is used here to fetch logindata from excel sheet

@DataProvider(name="Logindata")
String [][] getData() throws IOException 
 {
 String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\validlogininputs.xlsx";
 int rownum=XLUtils.getRowCount(path,"Sheet1");
 int cocount=XLUtils.getcellcount(path,"Sheet1",1);
String logindata[][]=new String[rownum][cocount];
for(int i=1; i<=rownum;i++)
{
	for(int j=0;j<cocount;j++)
{
		logindata[i-1][j]=XLUtils.getcellData(path,"Sheet1",i,j);
		}
 }
return logindata;
}

//dataprovider is used here to fetch python code from excel sheet

@DataProvider(name="Python")
String [][] getdata() throws IOException 
 {
 String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\Python.xlsx";
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
