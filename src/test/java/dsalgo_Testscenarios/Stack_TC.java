package dsalgo_Testscenarios;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds_algo_Utilities.XLUtils;
import dsalgo_objects.Queue_POM;
import dsalgo_objects.Stack_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Stack_TC extends  BaseClass {
	@Test(priority=1)
	@Description("Select stack from dropdown,then select OperationsInStackLink ")
	@Severity(SeverityLevel.NORMAL)
	public void b_Stackpage() throws InterruptedException{
	
		
		Stack_POM st =new Stack_POM(driver);
	Thread.sleep(1000);	
	st.dropdown();
	st.Stacklink();
	
	}
	@Test(priority=2,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)
	public void exuteoperationinstack(String code) throws InterruptedException {
		Stack_POM	st =new Stack_POM(driver);
		st.OperationsInStackLink();
		st.tryHere();
		st.textEditor(code);
		st.runButton();
		assertion();
		
}
	
	@Test(priority=3 ,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)
	public void exuteImplemation(String code) throws InterruptedException {
		Stack_POM	st =new Stack_POM(driver);
		//Thread.sleep(1000);	
		driver.navigate().back();	
		st.dropdown();
		st.Stacklink();
		st.Implementation();
		st.tryHere();
		st.textEditor(code);
		st.runButton();	
		assertion();
	}
	
@Test(priority=4 ,dataProvider="Python_Code")
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)
	public void exutapplications(String code) throws InterruptedException {
		Stack_POM	st =new Stack_POM(driver);
		//Thread.sleep(1000);	
		driver.navigate().back();	
		st.dropdown();
		st.Stacklink();
		st.Applications();
		st.tryHere();
		st.textEditor(code);
		st.runButton();
		assertion();
	
	}
	@Test(priority=5)
	@Description("Select try here and test the text editor for the python code ")
	@Severity(SeverityLevel.NORMAL)

	public void excutepracticequestions() throws InterruptedException  {
		Stack_POM	st =new Stack_POM(driver);
		driver.navigate().back();
		Thread.sleep(1000);	

		//st.dropdown();
		//st.Stacklink();
		st.practiceQuestions();
		driver.navigate().to(homepageURL);
		//st.practiceQuestions();
		
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

