package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignInPage {
	
public WebDriver ldriver;
	
	public SignInPage(WebDriver rdriver)
	 {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	 }
	
	//ALREADY REGISTERED? Section
	//Email field
	@FindBy(xpath="//input[@id='email']")
	WebElement Txt_email;
	
	//Password field
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Txt_pwd;
	
	//Signin button
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement Btn_Signin;
	
	//Sign out link
	@FindBy(xpath="//a[@class='logout']")
	WebElement Lnk_Signout;
	
	
	//CREATE AN ACCOUNT Section
	//Email field
	@FindBy(xpath="//input[@id='email_create']")
	//@CacheLookup
	WebElement Txt_Email1;
	
	//Create an account button
	@FindBy(xpath="//button[@id='SubmitCreate']")
	//@CacheLookup
	WebElement Btn_Createanaccount;
	
	//Mr radio button
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement Btn_Mr;
	
	//Mrs radio button
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement Btn_Mrs;
	
	//First name
	@FindBy(id="customer_firstname")
	WebElement Txt_Fname;
	
	//Last name
	@FindBy(id="customer_lastname")
	WebElement Txt_Lname;
	
	//Password
	@FindBy(id="passwd")
	WebElement Txt_pass;
	
	//Address
	@FindBy(id="address1")
	WebElement Txt_address;
	
	//City
	@FindBy(id="city")
	WebElement Txt_city;
	
	//State dropdown
	@FindBy(id="id_state")
	WebElement StateDropdown;
	
	//Postal code
	@FindBy(id="postcode")
	WebElement postalcode;
	
	//phone_mobile
	@FindBy(id="phone_mobile")
	WebElement phoneno;
	
	//Register button
	@FindBy(id="submitAccount")
	WebElement Btn_Register;
		
	//Back to login button
	@FindBy(xpath="//span[contains(text(),'Back to Login')]")
	WebElement Btn_backtologin;
	
	//Alert message for duplicate email address
	@FindBy(xpath="//div[@id='create_account_error']//ol//li[contains(text(),'An account using this email address has already been registered. Please enter a valid password or request a new one. ')]")
	WebElement Alert_duplicateemail;
	
	//Alert message for invalid email address
	@FindBy(xpath="//div[@id='center_column']//div[@class='alert alert-danger']//ol//li[contains(text(),'Invalid email address.')]")
	WebElement Alert_invalidemail;
	
	//Alert message for wrong password
	@FindBy(xpath="//div[@id='center_column']//div[@class='alert alert-danger']//ol//li[contains(text(),'Authentication failed.')]")
	WebElement Alert_wrongpwd;
	
	//Alert message for blank email field
	@FindBy(xpath="//div[@id='center_column']//div[@class='alert alert-danger']//ol//li[contains(text(),'An email address required.')]")
	WebElement Alert_blankemail;
	
	//Alert message for blank password field
	@FindBy(xpath="//div[@id='center_column']//div[@class='alert alert-danger']//ol//li[contains(text(),'Password is required.')]")
	WebElement Alert_blankpwd;
	
	//Forgot password link
	@FindBy(xpath="//a[@title='Recover your forgotten password']")
    WebElement Lnk_forgotpwd;
	
	//Forgot password - email field
	@FindBy(xpath="//input[@class='form-control' and @id='email']")
	WebElement emailtoretrievepwd;
	
	//Retrieve password button
	@FindBy(xpath="//span[contains(text(), 'Retrieve Password')]")
	WebElement Btn_retrievepwd;
	
	//Alert message for email sent to retrieve password
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement Alert_emailsent;
	
	//Contact us link - Header
	@FindBy(xpath="//div[@id='contact-link']//a[contains(text(),'Contact us')]")
	WebElement Lnk_Contactus;
	
	//Shop phone no
	@FindBy(xpath="//span[@class='shop-phone']")
	WebElement Lbl_Phno;
	
	//Logo
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement Img_Logo;
	
	//Cart
	@FindBy(xpath="//span[@class='ajax_cart_no_product']")
	WebElement Lnk_Cart;
	
	//Search box
	@FindBy(id="search_query_top")
	WebElement Txt_Search;
	
	//Facebook link
	@FindBy(xpath="//li[@class='facebook']")
	WebElement Btn_Facebook;
	
	//Twitter link
	@FindBy(xpath="//li[@class='twitter']")
	WebElement Btn_Twitter ;
	
	//YouTube link
	@FindBy(xpath="//li[@class='youtube']")
	WebElement Btn_Youtube;
	
	//Google+ link
	@FindBy(xpath="//li[@class='google-plus']")
	WebElement Btn_Googleplus;
	
	//About us - Footer
	@FindBy(xpath="//a[@title='About us']")
	WebElement Lnk_Aboutus;
	
	//Store info - Footer
	@FindBy(xpath="//section[@id='block_contact_infos']")
	WebElement Lbl_storeinfo;
	
	//newsletter
	@FindBy(id="newsletter-input")
	WebElement Txt_newsletter;
	
	//Women tab
	@FindBy(xpath="//a[@title='Women' and contains(text(),'Women')]")
	WebElement Tab_Women;
	
	//Dresses tab
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[2]/a[contains(text(),'Dresses')]")
	WebElement Tab_Dresses;
	
	//T-Shirts tab
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[3]/a[contains(text(),'T-shirts')]")
	WebElement Tab_Tshirts;
	
	//Already registered Sign in (valid inputs)
	public void signin(String email,String pwd) {
		Txt_email.sendKeys(email);
		Txt_pwd.sendKeys(pwd);
		Btn_Signin.click();
	}
	
	public void signout() {
		Lnk_Signout.click();
	}
	
	//Validating email and password fields - availability
	public void val_mail_pwd() {	
		Assert.assertTrue(Txt_email.isDisplayed());
		Assert.assertTrue(Txt_pwd.isDisplayed());	
	}
	
	//Create an account Signup
	public void createacc(String email) {
		Txt_Email1.clear();
		Txt_Email1.sendKeys(email);
		Btn_Createanaccount.click();
		Btn_Mrs.click();
		Txt_Fname.sendKeys("Gayathri");
		Txt_Lname.sendKeys("G");
		Txt_pass.sendKeys("Hardwork");
		Txt_address.sendKeys("123,Deer valley st");
		Txt_city.sendKeys("Phoenix");
		StateDropdown.sendKeys("Arizona");
		postalcode.sendKeys("12345");
		phoneno.sendKeys("16029009015");
		Btn_Register.click();
	}
	
	//State dropdown
	public void select_list(){
	     Select stat=new Select(ldriver.findElement(By.id("id_state")));
	     stat.selectByVisibleText("Arizona");
	}
	
	
	//Validating email address field - valid or invalid format
	 public void  isValidEmailAddress(String email1) {
		 Txt_email.sendKeys(email1);
		 Btn_Signin.click();
  	     Assert.assertEquals(Alert_invalidemail.getText(), "Invalid email address.");
  	}
	 
	 //Validating password field by giving wrong password
	 public void isValidPassword(String email,String pwd1) {
		 Txt_email.clear();
		 Txt_pwd.clear();
		 Txt_email.sendKeys(email);
		 Txt_pwd.sendKeys(pwd1);
		 Btn_Signin.click();
		 Assert.assertEquals(Alert_wrongpwd.getText(), "Authentication failed.");
		 
	 }
	 
	 //Validating email field by leaving it blank
	 public void blankemail(String pwd1) {
		 Txt_email.clear();
		 Txt_pwd.clear();
		 Txt_pwd.sendKeys(pwd1);
		 Btn_Signin.click();
		 Assert.assertEquals(Alert_blankemail.getText(), "An email address required.");
	 }
	 
	 //Validating password field by leaving it blank
	 public void blankpwd(String email) {
		 Txt_email.clear();
		 Txt_pwd.clear();
		 Txt_email.sendKeys(email);
		 Btn_Signin.click();
		 Assert.assertEquals(Alert_blankpwd.getText(), "Password is required.");	 
	 }
	
	 //click forgot password link and validate the function
	 public void click_forgotpwd(String email) {
		 Txt_email.clear();
		 Txt_pwd.clear();
		 Txt_email.sendKeys(email);
		 Lnk_forgotpwd.click();
		 emailtoretrievepwd.sendKeys(email);
		 Btn_retrievepwd.click();
		 Assert.assertTrue(Alert_emailsent.getText().contains("A confirmation email has been sent to your address:"));
		 Btn_backtologin.click();	 
	 }
	 
	 //Validate the email address field in 'Create an account' section by giving duplicate email address
	 public void duplicate_email(String email){
		 Txt_Email1.sendKeys(email);
		 Btn_Createanaccount.click();
		 Assert.assertTrue(Alert_duplicateemail.getText().contains("An account using this email address has already been registered."));
	 }
	 
	 //Validate Contact us
	 public void val_Contactus_Header() {
		 
		 Assert.assertTrue(Lnk_Contactus.isDisplayed());
		 Lnk_Contactus.click();
		 Assert.assertTrue((ldriver.getPageSource().contains("Customer service")));
	 }
	 
	 //Validate Ph no
	 public void val_Phno_Header() { 
		 Assert.assertTrue(Lbl_Phno.isDisplayed());
	 }
	 
	 //Validate Logo 
	 public void val_logo_Header() { 
		 Assert.assertTrue(Img_Logo.isDisplayed());
	 }
	 
	 //Validate Cart-empty
	 public void val_Cart_Header() {
		 Assert.assertTrue(Lnk_Cart.isDisplayed());
		 Assert.assertTrue(Lnk_Cart.getText().contains("(empty)"));
		 
		 
	 }
	 
	//Validate Search option
	 public void val_Search() {	 
		 Assert.assertTrue(Txt_Search.isDisplayed());
		 Assert.assertTrue(Txt_Search.isEnabled());
	 }
	 
	 //Validating social media icons 
	 public void click_Facebook() throws InterruptedException{   
		    Assert.assertTrue(Btn_Facebook.isDisplayed());
			String ParentWindow=ldriver.getWindowHandle();
			Btn_Facebook.click();
			Thread.sleep(5000);
			//Using windowHandle to access the new window
			for(String currWindow :ldriver.getWindowHandles()) {	
				ldriver.switchTo().window(currWindow);	
				}
			Thread.sleep(5000);	
			Assert.assertTrue((ldriver.getPageSource().contains("Selenium Framework Public Group")));
			ldriver.switchTo().window(ParentWindow);
		}
	 
	 public void click_Twitter() throws InterruptedException{   
		    Assert.assertTrue(Btn_Twitter.isDisplayed());
			String ParentWindow=ldriver.getWindowHandle();
			Btn_Twitter.click();
			Thread.sleep(5000);
			//Using windowHandle to access the new window
			for(String currWindow :ldriver.getWindowHandles()) {	
				ldriver.switchTo().window(currWindow);	
				}
			Thread.sleep(5000);	
			Assert.assertEquals(ldriver.getCurrentUrl(),"https://twitter.com/seleniumfrmwrk");
			ldriver.switchTo().window(ParentWindow);
		}
	 
	 public void click_Youtube() throws InterruptedException{   
		    Assert.assertTrue(Btn_Youtube.isDisplayed());
			String ParentWindow=ldriver.getWindowHandle();
			Btn_Youtube.click();
			Thread.sleep(5000);
			//Using windowHandle to access the new window
			for(String currWindow :ldriver.getWindowHandles()) {	
				ldriver.switchTo().window(currWindow);	
				}
			Thread.sleep(5000);	
			Assert.assertTrue((ldriver.getPageSource().contains("Selenium Framework")));
			ldriver.switchTo().window(ParentWindow);
		}
	 
	 public void click_Googleplus() throws InterruptedException{   
		    Assert.assertTrue(Btn_Googleplus.isDisplayed());
			String ParentWindow=ldriver.getWindowHandle();
			Btn_Googleplus.click();
			Thread.sleep(5000);
			//Using windowHandle to access the new window
			for(String currWindow :ldriver.getWindowHandles()) {	
				ldriver.switchTo().window(currWindow);	
				}
			Thread.sleep(5000);	
			Assert.assertTrue((ldriver.getPageSource().contains("Selenium Framework - Google+")));
			ldriver.switchTo().window(ParentWindow);
		}
	 
	 //Validating Footeroptions
	 public void val_Footeroptions() {	 
		Assert.assertTrue(Lnk_Aboutus.isDisplayed());
		Assert.assertTrue(Lbl_storeinfo.isDisplayed());	
		Assert.assertTrue(Txt_newsletter.isDisplayed());
	 }
	 
	 //Validating Category tabs
	 public void val_tabs() {		 
		 Assert.assertTrue(Tab_Women.isDisplayed());
		 Assert.assertTrue(Tab_Dresses.isDisplayed());
	     Assert.assertTrue(Tab_Tshirts.isDisplayed());
	     Tab_Women.click();
	     Assert.assertEquals(ldriver.getCurrentUrl(),"http://automationpractice.com/index.php?id_category=3&controller=category");
	     Tab_Dresses.click();
	     Assert.assertEquals(ldriver.getCurrentUrl(),"http://automationpractice.com/index.php?id_category=8&controller=category");
	     Tab_Tshirts.click();
	     Assert.assertEquals(ldriver.getCurrentUrl(),"http://automationpractice.com/index.php?id_category=5&controller=category");
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
