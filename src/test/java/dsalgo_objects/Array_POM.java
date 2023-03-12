package dsalgo_objects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Array_POM {
	
	
	
	public  WebDriver  ldriver;
		
		//Constructor for page object class
		
		public Array_POM(WebDriver rdriver)
		{
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
			
		}
		
		
		
		//arraypage link
		
		// @FindBy (xpath="//div/a[@class='nav-link dropdown-toggle']")WebElement dropdown;
		
				
		   @FindBy (xpath = "//a[@href ='array']")WebElement getStartedarray;
			
			//links in array page
			
			@FindBy(xpath="//a[@href='applications-of-array']") WebElement Application_array; 
			
			@FindBy(xpath="//a[@href='basic-operations-in-lists']") WebElement Basic_o_list; 
			
			@FindBy(xpath="//a[@href='arrays-using-list']") WebElement Arrays_using_list;
			
			//@FindBy(xpath="//*[@id=\"content\"]/li[1]/a]") WebElement Arrays_in_python;
			
			@FindBy(xpath="//a[contains(text(),'Arrays in Python')]") WebElement Arrays_in_python;
			
			@FindBy(xpath="//a[@href='/tryEditor']") WebElement tryeditor;
			
			@FindBy(xpath="//button[@onclick='runit()']") WebElement runbutton;
			
			//@FindBy(xpath="//div[@class='input']/textarea[@id='editor']") WebElement textarea;
			
			@FindBy (xpath="//textarea[@tabindex='0']")WebElement textarea;
			
		    @FindBy(xpath="//pre[@id='output']") WebElement output;
			
		    @FindBy(xpath="//a[contains(text(),'Practice Questions')]") WebElement Practice_Question; 
			
		    @FindBy(xpath="//a[contains(text(),'Search the array')]") WebElement  search_array;
		    
		    @FindBy(xpath="//a[contains(text(),'Max Consecutive Ones')]") WebElement  Max_Consecutive;
		    
		    @FindBy(xpath="//a[contains(text(),'Find Numbers with Even Number of Digits')]") WebElement  Find_Numbers_Even;
		    
		    @FindBy(xpath="//a[contains(text(),'Squares of  a Sorted Array')]") WebElement  Squares_Sorted_Array;
		    
		    @FindBy(xpath="//span[@role='presentation']") WebElement  textareaclear;
		  
		   
			
			//links in application arraypage
			
			public void getarraystarted()
			{
				getStartedarray.click();
				
			}
			
			public void Applicationarray()
			{
				Application_array.click();
				
			}
			
			public void basicoperation()
			{
				Basic_o_list.click();
				
			}
			
			
			public void arraylist()
			{
				Arrays_using_list.click();
				
			}
			
			
			public void arrayinpython()
			{
				Arrays_in_python.click();
				
			}
			
			
			public void tryEditor()
			{
				tryeditor.click();
				
			}
			
			
			public void Textarea(String code)
			{   String text= textarea.getText();
				
				if(text==null)
				{
					textarea.sendKeys(code);
				}
				else
				{
					PythonCode_Practice(ldriver);
					textarea.sendKeys(code);
				}
				
				
				
			}
			
			
			public void run()
			{
				
				runbutton.click();
			}
			
			
			public void practicequestions()
			{
				Practice_Question.click();
			}
			
			public void searcharray()
			{
				
				search_array.click();
			}
			
			public void maxconsecutive()
			{
				Max_Consecutive.click();
			}
			
			
			public void findnumbers()
			{
				
				Find_Numbers_Even.click();
			}
			
			
			public void squaressortedarray()
			{
				
				Squares_Sorted_Array.click();
			}
			
			public void textareaclear()
			{
				textareaclear.clear();
			}
			
			
			public void PythonCode_Practice(WebDriver ldriver)
			{
			       	

                   Actions act = new Actions(ldriver);

             //Keyboard events operations

                  act.keyDown(Keys.CONTROL)
                 .sendKeys("a")
                 .sendKeys(Keys.DELETE)
                 .keyUp(Keys.CONTROL)
                 .build().perform();
				
			}	
			
			
			

			
		public boolean IsDisplayed_output()
			{
				if(output.isDisplayed())
				  return true;
				  else
					  return false;
			}
	}




