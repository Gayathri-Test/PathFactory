package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.pages.LandingPage;

//TC1 : Validating the Landing page.

public class TC1_LandingPage extends BaseClass {
	LandingPage obj_LandingPage;	
	@Test
	public void home(){
		
		obj_LandingPage = new LandingPage(driver);
		logs.info("Application opened");
		
		/* TC1_1 : Validate the landing page URL.
		 *     A : Go to the webpage http://automationpractice.com/index.php
		 *     B : Validate if the landing page loads properly 
		 */
		 
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
		logs.info("Application URL validated");
		
		/* TC1_2 : Validate the availability of Sign in option.
		 *     A : Validate the availability of Sign in option and verify if its Clickable 
		 */
		
		obj_LandingPage.validate_Signinlink();
		obj_LandingPage.Click_SignIn();
		logs.info("Clicked Sign in link");
		Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account");
		logs.info("Sign in link directed to the appropriate page");
		logs.info("Sign in link validated");		
		
	}	
}


