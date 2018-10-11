package com.symc.qa.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.symc.qa.utility.TestUtil;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public testbase() throws IOException
	{
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\TestAutomation\\pageobject\\src\\main\\java\\com\\symc\\qa\\configuration\\config.properties");
		prop.load(ip);
		
	}
	
	public static void init()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Automation_jar\\driver_browser");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equals("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}
	


}
