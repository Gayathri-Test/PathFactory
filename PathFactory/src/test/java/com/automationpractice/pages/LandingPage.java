package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage{
	
    public WebDriver ldriver;
	
	public LandingPage(WebDriver rdriver)
	 {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	 }
	
	//Sign-in Link in the Landing Page
	@FindBy(xpath="//a[@class = 'login']")
	@CacheLookup
	WebElement Lnk_Signin;
	
	public void validate_Signinlink() {
		
		Assert.assertTrue(Lnk_Signin.isDisplayed());
		
	}
	
	public void Click_SignIn() {
		Lnk_Signin.click();
	}
}
