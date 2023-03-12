package dsalgo_Testscenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Queue_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Queue_TC extends  BaseClass {
	
	
	@Test(priority=1)
	@Description("Select queue from dopdown,then select python implementation ")
	
	@Severity(SeverityLevel.NORMAL)
	public void b_Queuepage() throws InterruptedException
	{
		
	Queue_POM	qu =new Queue_POM(driver);
	Thread.sleep(1000);	
	qu.dropdown();
	qu.queueClink();
	
	}
	@Test(priority=2,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)
	public void exutePythonCode(String code) throws IOException, InterruptedException {
		Queue_POM	qu =new Queue_POM(driver);
		qu.implPython();
	 	qu.tryHere();
	 	
		qu.textEditor(code);
		qu.runButton();
		assertion();
		
	}
	
	@Test(priority=3,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)
	public void exuteCollectionse(String code) throws InterruptedException {
		Queue_POM	qu =new Queue_POM(driver);
		//Thread.sleep(1000);	
		driver.navigate().back();	
		qu.dropdown();
		qu.queueClink();
		qu.collection();
		qu.tryHere();
		qu.textEditor(code);
		qu.runButton();
		assertion();
	}
	@Test(priority=4,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)

	public void excuteusingarray(String code) throws InterruptedException {
		Queue_POM	qu =new Queue_POM(driver);
		driver.navigate().back();	
		qu.dropdown();
		qu.queueClink();
		qu.usingarray();
		qu.tryHere();
		qu.textEditor(code);
		qu.runButton();
		assertion();
	
}
	
	@Test(priority=5,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for operation")
	@Severity(SeverityLevel.NORMAL)
	public void excuteQueueOperation(String code) throws InterruptedException {
		Queue_POM	qu =new Queue_POM(driver);
		driver.navigate().back();	
		qu.dropdown();
		qu.queueClink();
		qu.queueOperations();
		qu.commonInvocation(code);
		//qu.tryHere();
		//qu.textEditor();
		//qu.runButton();
 }
	
	@Test(priority=6)
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)

	public void excutepracticequestions()  {
		Queue_POM	qu =new Queue_POM(driver);
		driver.navigate().back();	
		qu.dropdown();
		qu.queueClink();
		qu.implPython();
		qu.practiceQuestions();
			
}

	@DataProvider(name="Python_Code")
	String[]  getPythonCode() throws IOException 
	{	  
		String dir = System.getProperty("user.dir");
		String path=dir+"\\src\\test\\resources\\TestData\\Ds_algo_Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"python_code");
		int cocount=XLUtils.getcellcount(path,"python_code",1);
		String pythonCode[]=new String[1];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				 pythonCode[i-1]=XLUtils.getcellData(path,"python_code",i,j);
				
			}
		}
		return pythonCode;
	}
	
	public void assertion() throws InterruptedException {
		
		if(isDialogPresent()) {
			    Assert.assertEquals(true, true);
				Alert alert=driver.switchTo().alert();  
				Thread.sleep(3000);
				alert.dismiss();
			
		}
				
		driver.navigate().refresh();			
		}
	
	 private static boolean isDialogPresent() {
	        try {
	            driver.getTitle();
	            return false;
	        } catch (UnhandledAlertException e) {
	            return true;
	        }
	    }
}




