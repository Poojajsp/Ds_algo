package dsalgo_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo_Testscenarios.BaseClass;

public class Datastructures {

WebDriver ldriver;
	
	public Datastructures(WebDriver rdriver)
	{    ldriver=rdriver;
	
		PageFactory.initElements(rdriver, this);
	}
	
	 @FindBy (xpath="//h5[text()='Data Structures-Introduction']/../a[text()='Get Started']")WebElement Get_Started;
	 @FindBy (xpath="//a[text()='Time Complexity']")WebElement timecomplexity;
	 @FindBy (xpath="//a[text()='Sign out']")WebElement signout;
	 @FindBy (xpath="//a[text()='Sign in']")WebElement signin;
	 @FindBy (xpath="//div[@class='col-sm']/a")WebElement Tryhere;
   @FindBy (xpath="//*[@id=\"answer_form\"]/div/div/div[6]")WebElement enter;
   	 @FindBy (xpath="//button")WebElement Run;
	// @FindBy (id="answer_form")WebElement enter;
	//@FindBy (xpath="//pre[@class=' CodeMirror-line ']/span")WebElement enter;


	public void Get_started()
	{Get_Started.click();}
	public void Time_Complexity()
	{timecomplexity.click();}
	 public void Tryhere()
		{Tryhere.click();}
	
	 public void pythoncode(String code)
     { 
		 //enter.click();
		 enter.clear();
		 enter.sendKeys(code);}
	
     public void Run()
     {Run.click();}

	
}
