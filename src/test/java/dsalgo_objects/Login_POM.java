package dsalgo_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo_Testscenarios.BaseClass;

public class Login_POM    
{
	WebDriver ldriver;

	public Login_POM(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//div/a/button")WebElement open;
	@FindBy(xpath="//div/div[2]/ul/a[3]") WebElement sign;
	@FindBy(id="id_username")WebElement usernm;
	@FindBy(id="id_password")WebElement pasword ;
	@FindBy(xpath="//div[2]//input[4]")WebElement login;
	@FindBy(xpath="//a[text()='Sign out']")WebElement logout;


	public void homebutton() 
	{
		open.click();
	}
	public void SIGN() 
	{
		sign.click();
	}
	public void setusername(String uname) 
	{
		usernm.sendKeys(uname);
	}
	public void setpassword(String psd) 
	{
		pasword.sendKeys(psd);
	}
	public void Loginbutton() 
	{
		login.click();
	}
	public void Logout()
	{
		logout.click();
	}
}







