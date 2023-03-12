package dsalgo_objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_POM {

	WebDriver ldriver;

	public Register_POM(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy (xpath="//div/a[@class='nav-link dropdown-toggle']")WebElement dropdown;
	@FindBy (xpath="//div/a[text()='Arrays']")WebElement array;
	@FindBy (xpath="//div/a")WebElement hombutton;
	@FindBy (xpath="//div/div[2]/ul/a[2]")WebElement regstr;
	@FindBy (id="id_username")WebElement usrnam;
	@FindBy (id="id_password1")WebElement pswd;
	@FindBy (id="id_password2")WebElement conpswd;
	@FindBy (xpath="//div[2]//form/input[5]")WebElement submit;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement alertmsg;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement Successmsg;
	@FindBy (xpath="//ul/a[text()='Sign out']") WebElement Logout;



	//to launch Url

	public void homepage() 
	{
		hombutton.click();
	}
	public void registerpage() 
	{ 
		regstr.click();
	}
	public void dropdown() 
	{
		dropdown.click();
	}
	public void array() 
	{
		array.click();
	}
	public void logout()
	{
		Logout.click();
	}

	public void setusername(String uname)
	{
		usrnam.sendKeys(uname);
	}
	public void setpaswrd(String psd)
	{
		pswd.sendKeys(psd);
	}
	public void setpaswrd2(String psd2)
	{
		conpswd.sendKeys(psd2);
	}
	public void submit()
	{
		submit.click();
	}
	
}
