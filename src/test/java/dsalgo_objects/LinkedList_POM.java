package dsalgo_objects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LinkedList_POM {



	public  WebDriver  ldriver;

	//Constructor for page object class

	public LinkedList_POM(WebDriver rdriver)
	{

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}



	


	@FindBy (xpath = "//a[@href ='linked-list']")WebElement getStarted_linkedlist;

	//links in array page  Creating Linked LIst

	@FindBy(xpath="//a[@href='introduction']") WebElement introduction_linkedlist; 

	 
	@FindBy(xpath="//a[contains(text(),'Creating Linked LIst')]") WebElement creating_linkedlist; 

	@FindBy(xpath="//a[contains(text(),'Types of Linked List')]") WebElement  types_of_linkedlist; 

	@FindBy(xpath="//a[contains(text(),'Implement Linked List in Python')]") WebElement implement_linkedlist; 
	
	@FindBy(xpath="//a[contains(text(),'Traversal')]") WebElement traversal_linkedlist;
	
	@FindBy(xpath="//a[contains(text(),'Insertion')]") WebElement  insertion_linkedlist;
	
	@FindBy(xpath="//a[contains(text(),'Deletion')]") WebElement deletion_linkedlist;

	@FindBy(xpath="//a[@href='/tryEditor']") WebElement tryeditor;

	@FindBy(xpath="//button[@onclick='runit()']") WebElement runbutton;

	//@FindBy(xpath="//div[@class='input']/textarea[@id='editor']") WebElement textarea;

	@FindBy (xpath="//textarea[@tabindex='0']")WebElement textarea;

	@FindBy(xpath="//pre[@id='output']") WebElement output;

	@FindBy(xpath="//a[contains(text(),'Practice Questions')]") WebElement Practice_Question; 

	//@FindBy(xpath="//a[contains(text(),'Search the array')]") WebElement  search_array;




	//links in application arraypage

	public void getlinkedliststarted()
	{
		getStarted_linkedlist.click();

	}
	
	public void introduction()
	{
		
		introduction_linkedlist.click();
	}
	
	
	public void creating()
	{
		
		creating_linkedlist.click();
	}
	
	public void types()
	{
		
		types_of_linkedlist.click();
	}
	
	
	public void implement()
	{
		
		implement_linkedlist.click();
	}
	
	public void traversal()
	{
		
		traversal_linkedlist.click();
	}
	
	public void insertion()
	{
		
		insertion_linkedlist.click();
	}
	
	public void deletion()
	{
		
		deletion_linkedlist.click();
	}
	
	public void particequestions()
	{
		
		Practice_Question.click();
	}
	
	public void tryEditor()
	{
		tryeditor.click();
	}
	
	public void Textarea(String code)
	{   
			textarea.sendKeys(code);
	}
	
	
	public void run()
	{   
		runbutton.click();
	}
	
	public boolean output()
	{   
		if(output.getText().isEmpty())
		return false;
		else
			return true;
					
	}
		
}






