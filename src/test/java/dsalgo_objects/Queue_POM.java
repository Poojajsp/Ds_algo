package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Queue_POM {

	WebDriver ldriver;

	public Queue_POM(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(xpath = "//div/a[@class='nav-link dropdown-toggle']")
	WebElement dropdown;
	@FindBy(xpath = "//div/a[text()='Queue']")
	WebElement queue;

	// queue in phython implementation
	@FindBy(xpath = "//*[contains(text(),'Queue in Python')]")
	WebElement implPython;
    //collections in queue //	//@FindBy(xpath="//*[@id=\"content\"]/li[2]/a]")
	@FindBy(xpath="//*[contains(text(),'collections.deque')]")
	WebElement collection;
	//using array
    @FindBy(xpath="//*[contains(text(),'using array')]")
	WebElement usingarray;
    //QueueOperations
    @FindBy(xpath="//*[contains(text(),'Queue Operations')]")
    WebElement queueOperations;
    //Practicequestions
  // @FindBy(Xpath="//*[@id="content,"]/a")"
   @FindBy(xpath="//*[contains(text(),'Practice Questions')]")
    WebElement practicequestions;
    
    
	//common
	@FindBy(xpath = "//*[contains(text(),'Try here')]")
	WebElement tryHere;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
	WebElement textEditor;
	@FindBy(xpath = "//*[@id='answer_form']/button")
	WebElement runButton;
	
	private System pro;
	
	
	public void dropdown() {
		dropdown.click();
	}

	public void queueClink() {
		queue.click();

	}

	public void implPython() {
		implPython.click();
	}

	public void tryHere() {
		tryHere.click();
	}

	public void textEditor(String text) {
		textEditor.sendKeys(text);
	}
	
	public void textEditor() {
		
		textEditor.sendKeys("print(\"Success\")");
	}

	public void runButton() {
		runButton.click();
	}

	

public void collection( ) {
	collection.click();
	}

	public void usingarray( ) {
		usingarray.click();}
	
	
	public void queueOperations() {
		
		queueOperations.click();
	}
	
 public void commonInvocation(String text) {
	    tryHere();
		textEditor(text);
		runButton();
 }
 
 public void commonInvocation() {
	    tryHere();
		textEditor();
		runButton();
}

	
	public void practiceQuestions() {
		
		practicequestions.click();
	}
	
	public String gethomepageURL()
	{
		return pro.getProperty("homepageURL");
		
	}
}

