package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	//1
	public WebDriver driver;
	
	//2. Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver; //Assigning the driver passed from Test Case to local WebDriver.
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(linkText="Log in")
	WebElement  lnkLogin;
	
	@FindBy(linkText = "Sign up free")
	WebElement lnkSignupfree;
	
	public String getLoginLinkText() {
		String val = lnkLogin.getText();
		return val;
	}
	
	public String getSignupfreeLinkeText() {
		return lnkSignupfree.getText();
	}
	

}
