package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Datastructures_POM {

WebDriver ldriver;
	
	public Datastructures_POM(WebDriver rdriver)
	{    ldriver=rdriver;
	   PageFactory.initElements(rdriver, this);
	}
	
	 @FindBy (xpath="//h5[text()='Data Structures-Introduction']/../a[text()='Get Started']")WebElement Get_Started;
	 @FindBy (xpath="//a[text()='Time Complexity']")WebElement timecomplexity;
	 @FindBy (xpath="//a[text()='Sign out']")WebElement signout;
	 @FindBy (xpath="//a[text()='Sign in']")WebElement signin;
	 @FindBy (xpath="//div[@class='col-sm']/a")WebElement Tryhere;
   	 @FindBy (xpath="//button")WebElement Run;
	@FindBy (xpath="//form/div/div/div/textarea")WebElement enter;
	@FindBy (id="output")WebElement output;


	public void Get_started()
	{Get_Started.click();}
	public void Time_Complexity()
	{timecomplexity.click();}
	 public void Tryhere()
		{Tryhere.click();}
	
	 public void pythoncode(String code)
     { 
		 enter.sendKeys(code);
	 }
	 public void clear()
	 {
		 enter.clear();
	 }
	
     public void Run()
     {
    	 Run.click();
     }
     public String output()
     {
    	 return output.getText();
     }

     public void click()
     {
    	 enter.click();
     }
	
}
