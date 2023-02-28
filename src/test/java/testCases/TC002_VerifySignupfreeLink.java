package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import testBase.BaseClass;

public class TC002_VerifySignupfreeLink extends BaseClass{
		
	@Test
	public void verifySignupfreeLinkTest() {
		LandingPage lp = new LandingPage(driver);
		String val = lp.getSignupfreeLinkeText();
		Assert.assertEquals(val, "Sign up free","Sign up free link is missing");
		//System.out.println("Sign up free link is existing");
		logger.info("Sign up free link is existing");
	}
	
	
}
