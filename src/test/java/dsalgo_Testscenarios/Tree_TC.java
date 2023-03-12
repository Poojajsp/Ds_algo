package dsalgo_Testscenarios;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Tree_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Tree_TC  extends BaseClass

{

	@Test(priority=1)
	@Description("User is in Tree page and Clicks  on each sub links and TextEditor ")
	@Severity(SeverityLevel.NORMAL)
	public void Tree() throws InterruptedException
	{Tree_POM tr=new Tree_POM(driver);
	Thread.sleep(2000);	
	driver.navigate().to(homepageURL);
	tr.Get_started();
	logger.info("User clicks on GetStarted");
	tr.overview_of_Trees();
	logger.info("User clicks on overview of Tree");
	if (driver.getTitle().equals("Overview of Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.terminologies();
	logger.info("User clicks on graph in terminologies link");
	if (driver.getTitle().equals("Terminologies"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Types_of_Trees();
	logger.info("User clicks on Types_of_Trees link");
	if (driver.getTitle().equals("Types of Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Tree_Traversals();
	logger.info("User clicks on Tree_Traversals link");
	if (driver.getTitle().equals("Tree Traversals"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Traversals_Illustration();
	logger.info("User clicks on Traversals_Illustration link");
	if (driver.getTitle().equals("Traversals-Illustration"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Binary_Trees();
	logger.info("User clicks on Binary_Trees link");
	if (driver.getTitle().equals("Binary Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Types_of_Binary_Trees();
	logger.info("User clicks on Types of Binary Trees link");
	if (driver.getTitle().equals("Types of Binary Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Implementation_in_Python();
	logger.info("User clicks on Implementation in Python link");
	if (driver.getTitle().equals("Implementation in Python"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Binary_Tree_Traversals();
	logger.info("User clicks on Binary Tree Traversals link");
	if (driver.getTitle().equals("Binary Tree Traversals"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Implementation_of_Binary_Trees();
	logger.info("User clicks on Implementation_of_Binary_Trees link");
	if (driver.getTitle().equals("Implementation of Binary Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Applications_of_Binary_trees();
	logger.info("User clicks on Applications of Binary trees link");
	if (driver.getTitle().equals("Applications of Binary trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Binary_Search_Trees();
	logger.info("User clicks on Binary Search Trees link");
	if (driver.getTitle().equals("Binary Search Trees"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}
	tr.Implementation_Of_BST();
	logger.info("User clicks on Implementation Of BST link");
	if (driver.getTitle().equals("Implementation Of BST"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}

	tr.Tryhere();
	logger.info("User clicks on Tryhere button");
	if (driver.getTitle().equals("Assessment"))
	{
		logger.info("User is in the "+driver.getTitle()+" page");
	}
	else
	{
		Assert.assertEquals(true, false);
	}

	}

	@Test(priority=2,dataProvider="Python")
	@Description("User is in Assessment page and entering valid and invalid data and expecting respective output")
	@Severity(SeverityLevel.NORMAL)
	public void Tree_TextEditor(String code) throws InterruptedException
	{
		Tree_POM tr=new Tree_POM(driver);
		tr.pythoncode(code);
		logger.info("user is entering code");
		Thread.sleep(2000);
		tr.Run();
		logger.info("user clicks Run ");
		logger.info("Output is -"+tr.output());

		if(tr.output()==null)
		{
			Assert.assertEquals(false, true);
			
		        Alert alert=driver.switchTo().alert();
		        Thread.sleep(3000);
		        alert.dismiss();		     
		}
		else
		{
			Assert.assertEquals(true, true);
	     }
		driver.navigate().refresh();
	}



	@Test(priority=3)
	@Description("User is clicking Run and expecting Output")
	@Severity(SeverityLevel.NORMAL)
	public void back_to_Home() throws InterruptedException {


		Thread.sleep(2000);
		driver.navigate().to(homepageURL);

	}

	@DataProvider(name="Python")
	String [][] getdata() throws IOException 
	{
		//String path="C:\\Users\\pooja\\eclipse-workspace\\Ds_algo\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		String dir = System.getProperty("user.dir");
		String path=dir+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"python_code");
		int cocount=XLUtils.getcellcount(path,"python_code",1);
		String pycode[][]=new String[rownum][cocount];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				pycode[i-1][j]=XLUtils.getcellData(path,"python_code",i,j);
			}
		}
		return pycode;}
}
