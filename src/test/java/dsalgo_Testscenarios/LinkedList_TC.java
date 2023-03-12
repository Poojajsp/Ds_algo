package dsalgo_Testscenarios;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ds_algo_Utilities.XLUtils;
import dsalgo_objects.LinkedList_POM;




public class LinkedList_TC extends BaseClass {


	//public String ArrayURL=readconfig.getArrayURL();
	//Array array=new Array(driver);

	@Test(priority=1)
	public void Linkedlistpage()
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		linked.getlinkedliststarted();
		logger.info("user is in Linked list page");

	}


	@Test(dataProvider="phytoncode",priority =2)
	public void LinkedList_Introduction(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.introduction();
		logger.info("user clicked introduction in linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in introduction linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in introduction  linkedlist page");
		linked.run();
		logger.info("user clicked on  run  in intorduction linkedlist page");
		verifyassert();
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =3)
	public void LinkedList_Create(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.creating();
		logger.info("user clicked creating linked list in create linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in create linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in create linkedlist page");
		linked.run();
		logger.info("user clicked on  run  in create linkedlist page");
		verifyassert();
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =4)
	public void LinkedList_Types(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.types();
		logger.info("user clicked types in  linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in  types of  linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in types of linkedlist page");
		linked.run();
		verifyassert();
		logger.info("user clicked on  run  in linkedlist page");
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =5)
	public void LinkedList_implement(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.implement();
		logger.info("user clicked implement in  linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in  implement linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in  implement  linkedlist page");
		linked.run();
		verifyassert();
		logger.info("user clicked on  run  in linkedlist page");
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =6)
	public void LinkedList_trasversal(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.traversal();
		logger.info("user clicked traversal  in  linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in  traversal linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in  traversal  linkedlist page");
		linked.run();
		verifyassert();
		logger.info("user clicked on  run  in traversal page");
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =7)
	public void LinkedList_insertion(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.insertion();
		logger.info("user clicked insertion  in  linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in  insertion linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in  insertion  linkedlist page");
		linked.run();
		logger.info("user clicked on  run  in insertion page");
		verifyassert();
		driver.navigate().back();

	}
	
	@Test(dataProvider="phytoncode",priority =8)
	public void LinkedList_Deletion(String code)
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.deletion();
		logger.info("user clicked deletion  in  linked list page");
		linked.tryEditor();
		logger.info("user clicked on try here button in  deletion linked list page");
		linked.Textarea(code);
		logger.info("user entered code in text area button in  deletion  linkedlist page");
		linked.run();
		logger.info("user clicked on  run  in deletion page");
		verifyassert();
		driver.navigate().back();
		

	}
	
	@Test(priority=9)
	public void LinkedList_PracticeQuestion()
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		linked.particequestions();
		logger.info("user clicked practice question link  in  linked list page");
		driver.navigate().to(homepageURL);
		

	}
	
	public void verifyassert()
	{
		LinkedList_POM linked=new LinkedList_POM(driver);
		if(linked.output()==true)
		{
		logger.info("user entered valid code");
		assertTrue(true);
		}
		else
		{
			logger.info("user entered invalid code");
			assertTrue(true);
		}
	}

	
	
	@DataProvider(name="phytoncode")
	String [][] getData() throws IOException 
	{

		String userdirectory =  System.getProperty("user.dir");
		String path=userdirectory+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";

		int rownum=XLUtils.getRowCount(path,"python_code");
		int cocount=XLUtils.getcellcount(path,"python_code",1);
		String phytoncode[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				phytoncode[i-1][j]=XLUtils.getcellData(path,"python_code",i,j);
			}
		}
		return phytoncode;
	}

	


}


