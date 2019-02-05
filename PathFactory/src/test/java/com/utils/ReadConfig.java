package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmail()
	{
	String email=pro.getProperty("Email");
	return email;
	}
	
	public String getEmail1()
	{
	String email1=pro.getProperty("Email1");
	return email1;
	}
	
	public String getEmail2()
	{
	String email2=pro.getProperty("Email2");
	return email2;
	}
	
	public String getPassword()
	{
	String pwd=pro.getProperty("Password");
	return pwd;
	}
	
	public String getPassword1()
	{
	String pwd1=pro.getProperty("Password1");
	return pwd1;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getFirefoxPath()
	{
	String Firefoxpath=pro.getProperty("firefoxpath");
	return Firefoxpath;
	}
	
	public String getEdgePath()
	{
	String edge=pro.getProperty("edgepath");
	return edge;
	}
	
	
	public String getPageTitle()
	{
		String pageTitle=pro.getProperty("pageTitle");
		return pageTitle;
	}


}
