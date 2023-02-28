package dsalgo_Testscenarios;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Sign_in;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Common_Login_Tc_001 extends BaseClass
{
	 @Test(priority=1)
	 @Description("User is clicking Signin and expecting loginpage")
		@Severity(SeverityLevel.NORMAL)
		public void a_opensign_inpage()
	{Sign_in lpd=new Sign_in(driver);
	driver.get(homepageURL);
	  lpd.SIGN();
	logger.info("user clicks on Signin button");
	}
	@Test(priority=2,dataProvider="Valid_Logindata")
	public void aa_loginDDT(String user, String psd) throws InterruptedException
	{Sign_in lpd=new Sign_in(driver);
		lpd.setusername(user);
		logger.info("Enters Username");
		lpd.setpassword(psd);
		logger.info("Enters Password");
		lpd.Loginbutton();
		logger.info("clicks on Login Button");
		Thread.sleep(1000);
		logger.info("User is logged in ");
	}
	@DataProvider(name="Valid_Logindata")
	  String [][] getData() throws IOException 
	   {
	   String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
	   int rownum=XLUtils.getRowCount(path,"valid_login");
	   int cocount=XLUtils.getcellcount(path,"valid_login",1);
	  String logindata[][]=new String[rownum][cocount];
	for(int i=1; i<=rownum;i++)
	{
		for(int j=0;j<cocount;j++)
	{
			logindata[i-1][j]=XLUtils.getcellData(path,"valid_login",i,j);
			}
	   }
	return logindata;
	}
	 
}
