package Random_Testscases;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG_Listners.CustomListner;
import TestNG_Listners.Screensht_Base;
import dsalgo_Testscenarios.BaseClass;
//import dsalgo_objects.Base_Class;
import dsalgo_objects.Sign_in;
@Listeners(CustomListner.class)
public class LoginTc_001 extends BaseClass
{	
	//WebDriver driver;	
	//commenting

	public void  setDriver(ITestContext context) 
	
	    {
	//	WebDriverManager.chromedriver().setup();
		//driver= new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		
		}
	@Test
	public void login() throws InterruptedException 
	{
		//driver.get(baseURL);
		Sign_in lp=new Sign_in(driver);
		lp.homebutton();
		lp.SIGN();
		lp.setusername(username);
		lp.setpassword(password);
		lp.Loginbutton();
		if(driver.getTitle().equals("k"))
		{ Assert.assertTrue(true);}
		else
		{SS(driver, "LoginTc_001");
			Assert.assertTrue(false);}
		
	}
	
	
	}



