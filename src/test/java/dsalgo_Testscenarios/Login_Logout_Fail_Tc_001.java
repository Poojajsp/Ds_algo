package dsalgo_Testscenarios;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;



import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import allureReports.AllureListeners;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Sign_in;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Test@Listeners({AllureListeners.class})
public class Login_Logout_Fail_Tc_001 extends BaseClass

 {
	public WebDriver tdriver;
 
	@Test(priority=1)
	@Description("User is clicking homebutton and expecting loginpage")
	@Severity(SeverityLevel.NORMAL)
	public void opensign_inpage()
	{Sign_in lpd=new Sign_in(driver);
	
	 lpd.homebutton(); 
	logger.info("User clicks on Homebutton");
		lpd.SIGN();
	logger.info("user clicks on Signin button");
	}
	
	 @Test (priority=2,dataProvider="Logindata")
	 @Description("User is entering Username password and expecting login succesful")
	@Severity(SeverityLevel.BLOCKER)
	 public void loginDDT(String user, String psd) throws InterruptedException
 {Sign_in lpd=new Sign_in(driver);
 logger.info("User is in Login Page ");
	lpd.setusername(user);
	logger.info("Enters Username");
	lpd.setpassword(psd);
	logger.info("Enters Password");
	lpd.Loginbutton();
	logger.info("Press Login button");
	Thread.sleep(1000);
	logger.info("User is logged in ");
	
}
	 @Test(priority=3)
	 @Description("User is loggingout and  expecting logout succesful message")
		@Severity(SeverityLevel.NORMAL)
	 public void logout() throws InterruptedException
	 {
		 Sign_in lpd=new Sign_in(driver);
	 lpd.Logout();
	 logger.info("User clicks on logout");
	 Thread.sleep(2000);
	 logger.info("User is logged out ");
	 logger.info("Creating Failure Testcase");
	 if(isalertsuccess()==false)
	 {assertEquals(false, true); }
	 }
	 
	 public boolean isalertsuccess() {
		 Sign_in lpd=new Sign_in(driver);
         lpd.logoutalert();
         logger.info("User is expecting Logout alert");
         return false;
         
}
	
	 @Test
	 public void Skip_test()
	 {
		 throw new SkipException("Skipping this Test");
	 }
	 

@DataProvider(name="Logindata")
  String [][] getData() throws IOException 

   {
	String userdirectory =  System.getProperty("user.dir");
		String path=userdirectory+"src\\test\\resources\\TestData\\login_invalid_valid.xlsx";
   int rownum=XLUtils.getRowCount(path,"Sheet1");
   int cocount=XLUtils.getcellcount(path,"Sheet1",1);

  String logindata[][]=new String[rownum][cocount];
for(int i=1; i<=rownum;i++)
{
	for(int j=0;j<cocount;j++)
{
		logindata[i-1][j]=XLUtils.getcellData(path,"invalid_valid",i,j);
		}
   }
return logindata;
}
}