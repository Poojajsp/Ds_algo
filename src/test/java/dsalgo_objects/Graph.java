package dsalgo_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dsalgo_Testscenarios.BaseClass;

public class Graph {
	//public static WebDriver driver=BaseClass.getDriver();
	
WebDriver ldriver;
	
	public Graph(WebDriver rdriver)
	{
	ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	 @FindBy (xpath="//div/a[@class='nav-link dropdown-toggle']")WebElement dropdown;
	 @FindBy (xpath="//div/a[text()='Graph']")WebElement graph;
	 @FindBy (xpath="//div/ul[2]/a")WebElement graphclk;
	 @FindBy (xpath="//div//a[text()='Graph Representations']")WebElement graphreprsnts;
	 @FindBy (xpath="//div[@class='col-sm']/a")WebElement Tryhere;
	 @FindBy (xpath="//button")WebElement Run;
	@FindBy (xpath="//*[@id=\"answer_form\"]/div/div/div[6]")WebElement enter;
	//@FindBy (xpath="//div[@class='input']/textarea[@id='editor']") WebElement enter;
	//@FindBy (id="answer_form")WebElement enter;

//to select graph link
      public void dropdown()
      {	dropdown.click();}
      public void graphlink()
      {graph.click();}
      public void graphclick()
      {graphclk.click();}
      public void Tryhere()
		{Tryhere.click();}
      public void graphrepresents()
      {graphreprsnts.click();}
    
      public void pythoncode(String code)
      {      enter.sendKeys(code); 
      System.out.println("Print Success");}
      
      public void Run()
      { Run.click();}

}