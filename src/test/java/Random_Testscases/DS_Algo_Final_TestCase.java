package Random_Testscases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_Testscenarios.BaseClass;
import dsalgo_objects.Datastructures;
import dsalgo_objects.Graph;
import dsalgo_objects.Sign_in;
@Listeners
public class DS_Algo_Final_TestCase extends BaseClass
{@Test
	public void a_opensign_inpage()
	{
		Sign_in lpd=new Sign_in(driver);
		lpd.homebutton();
		lpd.SIGN();
	}

	 @Test(dataProvider="Logindata")
	public void b_loginDDT(String user, String psd) throws InterruptedException
 {
	Sign_in lpd=new Sign_in(driver);
	lpd.setusername(user);
	lpd.setpassword(psd);
	lpd.Loginbutton();
	//Thread.sleep(1000);
	//lpd.Logout();
	//lpd.logoutalert();	

}
	 @Test
		public void c_graphpage()
		{
			Graph gp=new Graph(driver);
			gp.dropdown();
			gp.graphlink();
			gp.graphclick();
			gp.Tryhere();
		}
		
	 
		@Test (dataProvider="Python")
		public void d_graphlink(String code) throws InterruptedException
		{
			Graph gp=new Graph(driver);
			Thread.sleep(4000);
			gp.pythoncode(code);
			}
		
		@Test
		public void e_runn()
		{Graph gp=new Graph(driver);
			gp.Run();
			driver.navigate().back();
			}
		@Test
		public void f_graphreprsntspage()
		{
			Graph gp=new Graph(driver);
			gp.graphrepresents();
			gp.Tryhere();
		}
		
		@Test (dataProvider="Python")
		public void g_graphrprnts(String code)
		{
			Graph gp=new Graph(driver);
			gp.pythoncode(code);}
		@Test
		public void h_run()
		{Graph gp=new Graph(driver);
			gp.Run();	
		driver.navigate().to(homepageURL);
		}
		@Test
		public void i_Timecomplex()
		{
			Datastructures DS=new Datastructures(driver);
			DS.Get_started();
			DS.Time_Complexity();
			DS.Tryhere();
		}
		
		@Test (dataProvider="Python")
		public void j_Time_Complex_Editor(String pycode) throws InterruptedException
		{
			Datastructures DS=new Datastructures(driver);
			DS.pythoncode(pycode);
			Thread.sleep(1000);}
		@Test
		public void k_rn() {
			Datastructures DS=new Datastructures(driver);
			DS.Run();
			driver.navigate().to(homepageURL);
			//driver.quit();
			}
	 

@DataProvider(name="Logindata")
  String [][] getData() throws IOException 
   {
   String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\login_invalid_valid.xlsx";
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



