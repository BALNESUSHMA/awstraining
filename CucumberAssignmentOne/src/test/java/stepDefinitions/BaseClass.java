package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.logging.Logger;
import pageObjects.LoginPage;
import pageObjects.Registration;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public Registration reg;
	public static Logger logger;
	public Properties configprop;
	
	public static String randomeString() {
		String generateString1=RandomStringUtils.randomAlphanumeric(5);
		return generateString1;
	}
}
