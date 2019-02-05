package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SignInPage;

//TC2 : Validating the sign in page
public class TC2_SigninPage extends BaseClass{
	
	LandingPage obj_LandingPage;
	SignInPage obj_SignInPage;
	
	@Test
	public void sign() throws InterruptedException {
		
	  obj_LandingPage = new LandingPage(driver);
	  logs.info("Application opened");
	  obj_LandingPage.Click_SignIn();
	  logs.info("Clicked SignIn link");
	  obj_SignInPage = new SignInPage(driver);
	
	 /*  TC2_1 : Validate the Sign in functionality for the registered user 
      *TC2_1_1 : Once the user landed in the Authentication page, make sure the availability of Email Address and Password fields for the registered users.
      *TC2_1_2 : By clicking sign in, it should direct to the appropriate page.
	  */
	
	  obj_SignInPage.val_mail_pwd();
	  logs.info("Username and password fields are available");
	
	// TC2_2 : Field Validation for Username & Password fields by giving valid inputs.
	      
	//TC2_2_1 : Validate the username/email address field by providing valid inputs.
	       obj_SignInPage.signin(email, pwd);
	       logs.info("Registered email and password entered");	
	       logs.info("Clicked Sign in button");
	       Thread.sleep(2000);
	       Assert.assertTrue((driver.getPageSource().contains("Welcome to your account.")));
	       logs.info("Sign in function validated");
	       obj_SignInPage.signout();
	       driver.navigate().refresh();
	       
     //TC2_2_2 : Validate for invalid email format with "Invalid email address" message.     
	       obj_SignInPage.isValidEmailAddress(email1);
	       logs.info("Email field validated by giving invalid address");
	       
     //TC2_2_3 : Validate Password field with wrong input.
	       obj_SignInPage.isValidPassword(email, pwd1);
	       logs.info("Password field validated by giving wrong password");
	       
	 //TC2_2_4 : Validate by leaving email or/and password fields blank.
	       obj_SignInPage.blankemail(pwd1);
	       logs.info("Email field validated by leaving it blank");
	       obj_SignInPage.blankpwd(email);
	       logs.info("Password field validated by leaving it blank");
	       
	  //TC2_4 : Forgot Password Validation
	       
	       /*TC2_4_1 : Click forgot password link
	         TC2_4_2 : Make sure the user is taken to the Retrieval page .
	        TC_2_4_3 : Enter the Email address and validate for the Password Retrieval 
	        TC_2_4_4 : Once the Email is entered , make sure the user is provided with the below message "A confirmation email has been sent to your address: userxxx@email.com"
	       */
	       obj_SignInPage.click_forgotpwd(email);
	       logs.info("Clicked forgot password link");
	       logs.info("Forgot password link validated");
	       
      //TC2_5 : Validate for duplicate email address in the account creation section.     
	       obj_SignInPage.duplicate_email(email);
	       logs.info("Entered already registered email");
	       logs.info("Error message displayed appropriately");
	       
	  //TC2_6 : Account creation Validation
    
	       /*TC_2_6_1 : Enter Email address to start the account creation	
	        *TC_2_6_2 : Validate the user is taken to the Account creation page 
	        *TC_2_6_3 : Validate the fields in Personal information tab 
	        *TC_2_6_4 : Validate the fields in Address Tab
	        *TC_2_6_5 : Validate the mandatory Required fields  
	        */
	       
	       obj_SignInPage.createacc("cust123@gmail.com");
	       Assert.assertTrue((driver.getPageSource().contains("Welcome to your account.")));
	       logs.info("Account creation fields validated");
	       obj_SignInPage.signout();
	       
	  //TC2_7 : Signin Page Header Validation
	       
	       //TC_2_7_1 : Validate Contact us link is available in the header part and when clicked directs to the appropriate page. 
	       obj_SignInPage.val_Contactus_Header();
	       logs.info("Contact us link in the header validated");
	       driver.navigate().back();
	       
	       //TC_2_7_2 : Validate the shop phone no in the header.
	       obj_SignInPage.val_Phno_Header();
	       logs.info("Store phone no validated");
	    
	       //TC_2_7_3 : Validate the Store Logo.
	       obj_SignInPage.val_logo_Header();
	       logs.info("Store logo validated");
	       
	       //TC_2_7_4 : Validate the Cart link and make sure it is empty.
	       obj_SignInPage.val_Cart_Header();
	       logs.info("Cart link validated");
	       
	       //TC_2_7_5 : Validate the search box.
	       obj_SignInPage.val_Search();
	       logs.info("Search option validated");
	       
	  //TC2_8 : Signin Page Footer validation
	       
	       //TC_2_8_1 : Validate the Social media block in the Sign in page footer.
	        obj_SignInPage.click_Facebook();
	        logs.info("Facebook icon validated");
			obj_SignInPage.click_Twitter();
			logs.info("Twitter icon validated");
			obj_SignInPage.click_Youtube();
			logs.info("Youtube icon validated");
			obj_SignInPage.click_Googleplus();
			logs.info("Googleplus icon validated");
	       
	       //TC_2_8_2 : Validate the Newsletter Module
		   //TC_2_8_3 : Validate About us in the footer.
		   //TC_2_8_4 : Validate Store info in the footer.	
			obj_SignInPage.val_Footeroptions();
			logs.info("Footer options validated");
	       
	       //TC_2_9 : Validate Category title tabs.
		  //TC_2_9_1: Validate Women,Dresses and T-Shirts tabs.
			obj_SignInPage.val_tabs();
			logs.info("Category tabs are validated");
			
	}
}
