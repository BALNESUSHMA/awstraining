package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;
import pageObjects.LoginPage;
import pageObjects.Registration;

public class PetStoreStep extends BaseClass{
	
	@Before
	public void setUp() throws IOException, InterruptedException {
//		configprop=new Properties();
//		FileInputStream configpropfile=new FileInputStream("config.properties");
//		configprop.load(configpropfile);
//		
//		String br=configprop.getProperty("browser");
//		System.out.println("browser "+br);
//		if(br.equals("chrome")) {
//		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
//		driver=new ChromeDriver();}
//		else if(br.equals("firefox")) {
//			System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
//			driver=new FirefoxDriver();
//		}
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SU20365236\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver=new ChromeDriver();
		
		DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("firefox");
       //Set Browser name (case sensitive)
        dc.setPlatform(Platform.LINUX);
        
        
  
       driver = new RemoteWebDriver(new URL("http://35.163.1.191:4444/wd/hub"), dc);
        
		System.out.println("befor open url");
		driver.get("https://petstore.octoperf.com/");
		
		
	}

	@Given("User Launch chrome browser and open url")
	public void user_launch_chrome_browser_and_open_url() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		//logger=Logger.getLogger("Assignment one");
		//PropertyConfigurator.configure("Log4j.properties");
		
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Then("Close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}
@When("User on homepage and follows sign In")
public void user_on_homepage_and_follows_sign_in() {
    // Write code here that turns the phrase above into concrete actions
    reg=new Registration(driver);
    String actual=reg.getPageTitle();
  //  Assert.assertEquals("JPetStore Demo",actual );
    driver.findElement(By.linkText("Enter the Store")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Sign In")).click();
}

@When("User click on RegisterNow")
public void user_click_on_register_now() {
    // Write code here that turns the phrase above into concrete actions
	reg.clickRegister();
	
}

@When("Fill user details in registration form")
public void fill_user_details_in_registration_form(DataTable dataTable) {
	List<List<String>> data=dataTable.cells();
	//String email=randomeString()+"@gmail.com";
	reg.setEmail(data.get(4).get(1));
    reg.setAddress(data.get(6).get(1));
    reg.setCity(data.get(7).get(1));
    reg.setCountry(data.get(10).get(1));
    reg.setfirstName(data.get(2).get(1));
    reg.setLastName(data.get(3).get(1));
    reg.setPassword(data.get(1).get(1));
    reg.setRepeatPassword(data.get(1).get(1));
    reg.setPhone(data.get(5).get(1));;
    reg.setState(data.get(8).get(1));
    reg.setZip(data.get(9).get(1));
    reg.setUserId(data.get(0).get(1));
   
}

@When("User click on Save Account Information")
public void user_click_on_save_account_information() {
    // Write code here that turns the phrase above into concrete actions
    reg.clickOnSave();
}

@Then("Reloaded to login url")
public void reloaded_to_login_url() {
    // Write code here that turns the phrase above into concrete actions
	String actaulamsg=reg.verifyLoginHomePage();
	System.out.println("actaulamsg"+actaulamsg);
	if(actaulamsg.contains("Please enter your username and password.")) {
		Assert.assertEquals(true, true);
	}
	else {
		Assert.assertEquals(false, true);
	}
    
}

@And("Login with valid username and password")
public void login_with_valid_username_and_password(DataTable dataTable) {
	lp=new LoginPage(driver);
	List<List<String>> data=dataTable.cells();
	lp.setUserId(data.get(0).get(1));
	lp.setPassword(data.get(1).get(1));
}

@When("User click on login button")
public void user_click_on_login_button() throws InterruptedException {
	Thread.sleep(1000);
   lp.clickLogin();
}

@Then("Check for welcome message to user")
public void check_for_welcome_message_to_user() {
    String actualwelcomeCont=lp.checkWelcomeContent();
    System.out.println("actualwelcomeCont"+actualwelcomeCont);
    if(actualwelcomeCont.contains("Welcome")) {
    	Assert.assertEquals(true, true);
    	System.out.println("true true+++++++++++++++++");
    	}
    	else {
    		Assert.assertEquals(false, true);
    	}
    
}

@After
public void end()
{
	
	driver.close();
}
}
