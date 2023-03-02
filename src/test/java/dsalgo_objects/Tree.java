package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tree {
WebDriver ldriver;
	
	public Tree(WebDriver rdriver)
	{    ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	 @FindBy (xpath="//h5[text()='Tree']/../a[text()='Get Started']")WebElement Get_Started_Tree;
	 @FindBy (xpath="//a[text()='Overview of Trees']")WebElement overview_of_Trees;
	 @FindBy (xpath="//a[text()='Terminologies']")WebElement terminologies ;
	 @FindBy (xpath="//a[text()='Types of Trees']")WebElement Types_of_Trees;
	 @FindBy (xpath="//a[text()='Tree Traversals']")WebElement Tree_Traversals;
	 @FindBy (xpath="//a[text()='Traversals-Illustration']")WebElement Traversals_Illustration;
	 @FindBy (xpath="//a[text()='Binary Trees']")WebElement Binary_Trees;
	 @FindBy (xpath="//a[text()='Types of Binary Trees']")WebElement Types_of_Binary_Trees;
	 @FindBy (xpath="//a[text()='Implementation of Binary Trees']")WebElement Implementation_of_Binary_Trees;
	 @FindBy (xpath="//a[text()='Applications of Binary trees']")WebElement Applications_of_Binary_trees ;
	 @FindBy (xpath="//a[text()='Binary Search Trees']")WebElement Binary_Search_Trees ;
	 @FindBy (xpath="//a[text()='Implementation Of BST']")WebElement Implementation_Of_BST ;
	
	 @FindBy (xpath="//a[text()='Sign out']")WebElement signout;
	 @FindBy (xpath="//a[text()='Sign in']")WebElement signin;
	 @FindBy (xpath="//div[@class='col-sm']/a")WebElement Tryhere;
   @FindBy (xpath="//*[@id=\"answer_form\"]/div/div/div[6]")WebElement enter;
   	 @FindBy (xpath="//button")WebElement Run;
	// @FindBy (id="answer_form")WebElement enter;
	//@FindBy (xpath="//pre[@class=' CodeMirror-line ']/span")WebElement enter;


	public void Get_started()
	{Get_Started_Tree.click();}
	public void overview_of_Trees()
	{overview_of_Trees.click();}
	
	 public void Tryhere()
		{Tryhere.click();}
	
	 public void pythoncode(String code)
     { 
		 //enter.click();
		 //enter.clear();
		 enter.sendKeys(code);}
	
     public void Run()
     {Run.click();}

	
}


