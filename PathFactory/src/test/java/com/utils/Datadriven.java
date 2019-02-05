package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datadriven {
	
public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		
		String path="./Excel/TestData.xlsx";
		
		XLUtils.setExcelFile(path,"Sheet1");
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rownum;i++) {
			
			String email = XLUtils.getCellData(path, "Sheet1",i,0);
			String pwd = XLUtils.getCellData(path, "Sheet1",i,1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("passwd")).clear();
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("passwd")).sendKeys(pwd);
			driver.findElement(By.id("SubmitLogin")).click();
			
			Thread.sleep(2000);
			
			String act=driver.getCurrentUrl();
			String exp="http://automationpractice.com/index.php?controller=my-account";

			if(act.equals(exp)){
				System.out.println("Test passed");
				XLUtils.setCellData(path, "Sheet1", i, 2,"passed");
			}
			else {
				System.out.println("Test failed");
				XLUtils.setCellData(path, "Sheet1", i, 2,"failed");
			}
			
			driver.navigate().back();
			Thread.sleep(2000);
		}
		driver.close();
	}

	

}
