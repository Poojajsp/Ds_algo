package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stack_POM {
	WebDriver ldriver;

	public Stack_POM(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);}
		
		@FindBy(xpath="//div/a[@class='nav-link dropdown-toggle']")WebElement dropdown;
		@FindBy(xpath="//div/a[text()='Stack']")WebElement stack;
		//oprationsinstack
@FindBy(xpath = "//a[@href='operations-in-stack']")WebElement OperationsInStackLink;
		
@FindBy(xpath = "//a[@href='implementation']")WebElement Implementation;		
@FindBy(xpath = "//a[@href='stack-applications']")WebElement Applications;	
//@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")WebElement PracticeQuestions;	
@FindBy(xpath="//*[contains(text(),'Practice Questions')]")
WebElement PracticeQuestions;
@FindBy(xpath = "//*[contains(text(),'Try here')]")

WebElement tryHere;
@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
WebElement textEditor;
@FindBy(xpath = "//*[@id='answer_form']/button")
WebElement runButton;	
		
		
		
public void dropdown() {
	dropdown.click();
}

public void Stacklink() {
	stack.click();

}

public void textEditor() {
	
	textEditor.sendKeys("print(\"Success\")");
}

public void OperationsInStackLink() {
	System.out.println("i am printing");
	OperationsInStackLink.click();
	}
public void tryHere() {
	tryHere.click();
}
public void runButton() {
	runButton.click();
}
public void textEditor(String text) {
	System.out.println("i am here texteditor***************");
	textEditor.sendKeys(text);
}

public void Implementation() {
	System.out.println("i am here texteditor***************");
	Implementation.click();
	
}
public void Applications() {
	System.out.println("i am here texteditor***************");
	Applications.click();
}
public void practiceQuestions() {
	
	PracticeQuestions.click();
}

}










