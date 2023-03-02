package dsalgo_Testscenarios;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
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
	{
		Sign_in lpd=new Sign_in(driver);
		lpd.homebutton();
		logger.info("User is in the page-"+driver.getTitle());
		logger.info("User clicks on GetStarted button");}

	@Test(priority=2)
	public void sign_inpage()
	{Sign_in lpd=new Sign_in(driver);
	lpd.SIGN();
	logger.info("User is in the page-"+driver.getTitle());
	logger.info("user clicks on Signin button");}


	@Test(priority=3,dataProvider="Valid_Logindata")
	public void aa_loginDDT(String user, String psd) throws InterruptedException
	{Sign_in lpd=new Sign_in(driver);
	lpd.setusername(user);
	logger.info("Enters Username");
	lpd.setpassword(psd);
	logger.info("Enters Password");
	lpd.Loginbutton();
	logger.info("clicks on Login Button");
	
	logger.info("User is logged in ");
	logger.info("User is in the page-"+driver.getTitle());
	Thread.sleep(1000);
	driver.getTitle();
	if(driver.getTitle().equals("NumpyNinja"))
	{assertEquals(true, true);
	logger.info("Login Success");}
	else
	{assertEquals(true, false);
	logger.info("Login notSuccess");}
	}

	@DataProvider(name="Valid_Logindata")
	String [][] getData() throws IOException 
	{	   //String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		String dir = System.getProperty("user.dir");
		String path=dir+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
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
