package dsalgo_Testscenarios;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Array_POM;




public class Arraypage_TC extends BaseClass {


	public String ArrayURL=readconfig.getArrayURL();
	//Array array=new Array(driver);

	@Test(priority=1)
	public void Arraypage()
	{
		Array_POM array=new Array_POM(driver);
		array.getarraystarted();
		logger.info("user is in Array page");

	}


	@Test(dataProvider="phytoncode",priority =2)
	public void arraysinpython(String code)
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		array.arrayinpython();
		logger.info("user clicked the array in python link[1st link]");
		array.tryEditor();
		logger.info("user clicked on try here button in arrayinpython page");
		array.Textarea(code);
		logger.info("user entered code in  on try here button in arrayinpython page");
		array.run();
		logger.info("user clicked on  run  in arrayinpython page");
		isalertpresent();

		if(array.IsDisplayed_output()==true)
		{

			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}


		driver.navigate().back();

	}

	@Test(dataProvider="phytoncode",priority =3)
	public void arraysusinglist(String code )
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayURL);
		array.arraylist();
		logger.info("user clicked the array in arraylist[2nd link]");
		array.tryEditor();
		logger.info("user clicked on try here button in arraylist page");
		array.Textarea(code);
		logger.info("user entered code in  on try here button in arraylist page");
		array.run();
		logger.info("user clicked on  run  in arraylist page");
		isalertpresent();
		if(array.IsDisplayed_output()==true)
		{

			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
		driver.navigate().back();

	}

	@Test(dataProvider="phytoncode",priority =4)
	public void Basic_Oprtations_list(String code )
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayURL);
		array.basicoperation();
		logger.info("user clicked the  Basic operation in list[3rd link]");
		array.tryEditor();
		logger.info("user clicked on try here button in Basic operation in list page");
		array.Textarea(code);
		logger.info("user entered code in  on try here button in Basic operation in list page");
		array.run();
		logger.info("user clicked on  run  in Basic operation in list page");
		isalertpresent();
		if(array.IsDisplayed_output()==true)
		{

			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
		driver.navigate().back();

	}

	@Test(dataProvider="phytoncode",priority =5)
	public void Applications_of_Array(String code )
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayURL);
		array.Applicationarray();
		logger.info("user clicked the  Application of array[4th link]");
		array.tryEditor();
		logger.info("user clicked on try here button in Application of array page");
		array.Textarea(code);
		logger.info("user entered code in  on try here button in Application of array page");
		array.run();
		logger.info("user clicked on  run  in Application of array page");
		isalertpresent();
		if(array.IsDisplayed_output()==true)
		{

			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
		driver.navigate().back();

	}

	@Test(priority =6)
	public void Practice_Questions()
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayURL);
		array.arrayinpython();
		logger.info("user clicked the array in python link[1st link]");
		array.practicequestions();
		logger.info("user clicked on practice questions link");
		assertverify_practiceq();

		driver.navigate().back();

	}
	
	/*

	@Test(dataProvider="phytoncode1",priority =7)
	//@Test(priority=7)
	public void searcharraylink(String code )
	//public void searcharraylink( )
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayparcticeUrl);
		array.searcharray();
		logger.info("user clicked the  search arraylink");
		array.Textarea(code);
		logger.info("user entered code in  text editor in search arraylink");
		array.run();
		logger.info("user clicked on  run  in  search array page");
		isalertpresent();
		assertveriy_assesment();
		driver.navigate().back();
	}


	//@Test(dataProvider="phytoncode",priority =8)
	@Test(priority =8)
	//public void MaxConsiqutiveone(String code )
	public void MaxConsiqutiveone( )
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayparcticeUrl);
		array.maxconsecutive();
		logger.info("user clicked the  max consequtive link");
		//array.Textarea(code);
		//logger.info("user entered code in  text editor in  max consequtive page");
		array.run();
		logger.info("user clicked on  run  in   max consequtive page");
		isalertpresent();
		assertveriy_assesment();
		driver.navigate().back();
	}


	//@Test(dataProvider="phytoncode",priority =9)
	@Test(priority =9)
	//public void Findnumberswitheven(String code)
	public void Findnumberswitheven()
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayparcticeUrl);
		array.findnumbers();
		logger.info("user clicked findnumbers with even number link");
		//array.Textarea(code);
		//logger.info("user entered code in  text editor in  findnumbers with even numbee page");
		array.run();
		logger.info("user clicked on  run  in  findnumbers with even numbe page");
		isalertpresent();
		assertveriy_assesment();
		driver.navigate().back();

	}

	//@Test(dataProvider="phytoncode",priority =10)
	@Test(priority =10)
	//public void squaresorted(String code )
	public void squaresorted()
	{
		Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(ArrayparcticeUrl);
		array.squaressortedarray();
		logger.info("user clicked findnumbers with sqaure sorted link");
		//array.tryEditor();
		//logger.info("user clicked on try here button in Application of array page");
		//array.textareaclear();
		//logger.info("user cleard code in text area");
		//array.Textarea(code);
		//logger.info("user entered code in  text editor in  square sorted  page");
		array.run();
		logger.info("user clicked on  run in  square sortede page");
		isalertpresent();
		assertveriy_assesment();
		driver.navigate().back();

	} */

	@Test(priority=11)
	public void Final()
	{
		//Array_POM array=new Array_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(homepageURL);
		
	}



	public boolean isalertpresent()
	{
		try
		{

			Alert alert= driver.switchTo().alert();
			alert.getText();
			logger.info("Alert present :{}"+alert.getText());
			logger.info("user entered invalid code ");
			alert.dismiss();
			//assertTrue(false);
			return true;

		}
		catch(Exception e)
		{
			//assertTrue(true);
			logger.info("user entered valid code");
			return false;
		}
	}

	public  void   assertverify_practiceq()

	{
		String Pagetitle=driver.getTitle();
		if(Pagetitle==" Practice Questions ")
		{
			assertTrue(true);
		}
		else
			assertTrue(false);

	}

	public  void   assertveriy_assesment()

	{
		String Pagetitle=driver.getTitle();
		if(Pagetitle=="Assessment")
		{
			assertTrue(true);
		}
		else
			assertTrue(false);

	}



	@DataProvider(name="phytoncode")
	String [][] getData() throws IOException 
	{

		String userdirectory =  System.getProperty("user.dir");
		String path=userdirectory+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";

		int rownum=XLUtils.getRowCount(path,"Arraypage_Phytoncode");
		int cocount=XLUtils.getcellcount(path,"Arraypage_Phytoncode",1);
		String phytoncode[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				phytoncode[i-1][j]=XLUtils.getcellData(path,"Arraypage_Phytoncode",i,j);
			}
		}
		return phytoncode;
	}

	

}
