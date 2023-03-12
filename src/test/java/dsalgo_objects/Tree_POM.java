package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tree_POM {
	WebDriver ldriver;

	public Tree_POM(WebDriver rdriver)
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
	@FindBy (xpath="//a[text()='Implementation in Python']")WebElement Implementation_in_Python;
	@FindBy (xpath="//a[text()='Applications of Binary trees']")WebElement Applications_of_Binary_trees ;
	@FindBy (xpath="//a[text()='Binary Search Trees']")WebElement Binary_Search_Trees ;
	@FindBy (xpath="//a[text()='Implementation Of BST']")WebElement Implementation_Of_BST ;
	@FindBy (xpath ="//a[text()='Binary Tree Traversals']")WebElement Binary_Tree_Traversals;

	@FindBy (xpath="//a[text()='Sign out']")WebElement signout;
	@FindBy (xpath="//a[text()='Sign in']")WebElement signin;
	@FindBy (xpath="//div[@class='col-sm']/a")WebElement Tryhere;
	@FindBy (xpath="//button")WebElement Run;
	@FindBy (xpath="//form/div/div/div/textarea")WebElement enter;
	@FindBy (id="output")WebElement output;


	public void Get_started()
	{
	 Get_Started_Tree.click();
	 }
	public void overview_of_Trees()
	{overview_of_Trees.click();}
	public void terminologies()
	{terminologies.click();}
	public void Types_of_Trees()
	{Types_of_Trees.click();}
	public void Tree_Traversals()
	{Tree_Traversals.click();}
	public void Traversals_Illustration()
	{Traversals_Illustration.click();}
	public void Binary_Trees()
	{Binary_Trees.click();}
	public void Types_of_Binary_Trees()
	{Types_of_Binary_Trees.click();}
	public void Implementation_of_Binary_Trees()
	{Implementation_of_Binary_Trees.click();}
	public void Implementation_in_Python()
	{
		Implementation_in_Python.click();
	}
	public void Binary_Tree_Traversals()
	{
		Binary_Tree_Traversals.click();
	}
	public void Applications_of_Binary_trees()
	{Applications_of_Binary_trees.click();}
	public void Binary_Search_Trees()
	{Binary_Search_Trees.click();}
	public void Implementation_Of_BST()
	{Implementation_Of_BST.click();}
	public void Tryhere()
	{Tryhere.click();}

	public void pythoncode(String code)
	{ 	 enter.sendKeys(code);}

	public void Run()
	{Run.click();}
	 public String output()
     {return output.getText();}


}


