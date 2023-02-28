package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import testBase.BaseClass;

public class TC001_VerifyLoginLink extends BaseClass{

	@Test
	public void verifyLoginLinkTest() {
		LandingPage lp = new LandingPage(driver);
		String val = lp.getLoginLinkText();
		Assert.assertEquals(val, "Log in","Log in link is missing");
		//System.out.println("Log in link is existing");
		logger.info("Log in link is existing");
	}
	
	

}
