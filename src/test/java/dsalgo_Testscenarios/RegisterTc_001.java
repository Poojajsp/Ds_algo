package dsalgo_Testscenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Register;

public class RegisterTc_001 extends BaseClass
{
	
 @Test
  public void openregpage()
	{
		Register reg=new Register(driver);
		reg.homepage();
		reg.dropdown();
		reg.array();
		reg.registerpage();
	}
   
 @Test(dataProvider="Registerdata")
 public void register(String user, String psd, String psd2) throws InterruptedException
	{
		Register reg=new Register(driver);
		reg.setusername(user);
		Thread.sleep(1000);
		reg.setpaswrd(psd);
		Thread.sleep(1000);
		reg.setpaswrd2(psd2);
		Thread.sleep(1000);
		reg.submit();
		Thread.sleep(1000);
		/*if(is_register_success()==true)
		{Assert.assertTrue(true);
		reg.logout();}
		else
		{Assert.assertTrue(false);
		  reg.Print_Alert();*/
		 // SS(driver, "RegisterTc_01");}
	}
 public boolean is_register_success()
 {
	 Register reg=new Register(driver);
	 reg.Success();
	 reg.Print_Success();
	return true;
	
 }
 
    @DataProvider(name="Registerdata")
    String [][] getData() throws IOException 
     {
     String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\registerinputs.xlsx";
     int rownum=XLUtils.getRowCount(path,"Sheet1");
     int cocount=XLUtils.getcellcount(path,"Sheet1",1);
    String regdata[][]=new String[rownum][cocount];
  for(int i=1; i<=rownum;i++)
  {
  	for(int j=0;j<cocount;j++)
  {
  		regdata[i-1][j]=XLUtils.getcellData(path,"Sheet1",i,j);
  		}
     }
  return regdata;
  }
  }

