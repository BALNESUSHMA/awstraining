package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement userid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="signon")
	@CacheLookup
	WebElement login;
	
	@FindBy(linkText="Sign Out")
	@CacheLookup
	WebElement SignOut;
	
	@FindBy(id="WelcomeContent")
	@CacheLookup
	WebElement welcomeContent;
	
	public void setUserId(String uid)
	{
		userid.clear();
		userid.sendKeys(uid);
	}
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		login.click();
		
	}
	public void clickLogout()
	{
		SignOut.click();
		
	}
	public String checkWelcomeContent() {
		return welcomeContent.getText();
	}
	
}
