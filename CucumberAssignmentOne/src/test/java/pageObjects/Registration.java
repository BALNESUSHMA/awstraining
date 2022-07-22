package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Registration {
public WebDriver driver;
	
	public Registration(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);

}
	By registernow=By.linkText("Register Now!");
	By userid=By.name("username");
	By pwd=By.xpath("//input[@name='password']");
	By repeatpwd=By.xpath("//input[@name='repeatedPassword']");
	By fname=By.name("account.firstName");
	By lname=By.name("account.lastName");
	By email=By.xpath("//input[@name='account.email'][@size='40']");
	By phone=By.name("account.phone");
	By address1=By.name("account.address1");
	By city=By.name("account.city");
	By state=By.name("account.state");
	By zip=By.name("account.zip");
	By country=By.name("account.country");
	By save=By.name("newAccount");
	By loginhomepage=By.xpath("//form/p");
	
	
	public void clickRegister()
	{
		driver.findElement(registernow).click();
	}
	public void setUserId(String uid) {
		driver.findElement(userid).sendKeys(uid);
	}
	public void setPassword(String pd) {
		driver.findElement(pwd).sendKeys(pd);
	}
	public void setRepeatPassword(String rpd) {
		driver.findElement(repeatpwd).sendKeys(rpd);
	}
	public void setfirstName(String name1) {
		driver.findElement(fname).sendKeys(name1);
	}
	public void setLastName(String name2) {
		driver.findElement(lname).sendKeys(name2);
	}
	public void setEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	public void setPhone(String num) {
		driver.findElement(phone).sendKeys(num);
	}
	public void setAddress(String adrs) {
		driver.findElement(address1).sendKeys(adrs);
	}
	public void setCity(String c) {
		driver.findElement(city).sendKeys(c);
	}
	public void setState(String st) {
		driver.findElement(state).sendKeys(st);
	}
	public void setZip(String z) {
		driver.findElement(zip).sendKeys(z);
	}
	public void setCountry(String c) {
		driver.findElement(country).sendKeys(c);
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickOnSave() {
		driver.findElement(save).click();
		
	}
	public String verifyLoginHomePage() {
		String msg=driver.findElement(loginhomepage).getText();
		return msg;
	}
}
