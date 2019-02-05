package com.automationpractice.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utils.ReadConfig;

public class BaseClass {

    ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String email =readconfig.getEmail();
	public String email1 =readconfig.getEmail1();
	public String email2 =readconfig.getEmail2();
	public String pwd =readconfig.getPassword();
	public String pwd1 =readconfig.getPassword1();
	public static WebDriver driver;	
	public static Logger logs;

	//@Parameters("Browser")
	@BeforeClass
	public void setup()
	//public void setup(String br)
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		
		/*
		 if(br.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		
		else 
			if(br.equals("Firefox"))
		  {
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver = new FirefoxDriver();
		  }
		
			else
				if(br.equals("Edge"))
				{
					System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
					driver=new EdgeDriver();
					
				}
				*/
		
		driver.get(baseURL);
		driver.manage().deleteAllCookies();
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.manage().window().maximize();	
		logs=Logger.getLogger("ECommerce Test"); // Adding logger
		PropertyConfigurator.configure("log4j.properties"); // Adding logger
	} 
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
