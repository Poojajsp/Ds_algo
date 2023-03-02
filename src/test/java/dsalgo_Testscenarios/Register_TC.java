package dsalgo_Testscenarios;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Register;

public class Register_TC extends BaseClass
{ // This is for Register

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

		reg.setpaswrd(psd);

		reg.setpaswrd2(psd2);

		reg.submit();

		if(driver.getTitle()=="NumpyNinja")
		{
			logger.info("Register is successful");
			Assert.assertTrue(true);

		}
		else 
		{
			logger.info("Register is not successful");
			Assert.assertTrue(false);
		}

	}


	@DataProvider(name="Registerdata")
	String [][] getData() throws IOException 
	{


		String userdirectory =  System.getProperty("user.dir");
		System.out.print("success");
		String path=userdirectory+"\\src\\test\\resources\\TestData\\registerinputs.xlsx";
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

