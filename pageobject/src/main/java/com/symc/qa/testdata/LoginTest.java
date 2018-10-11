package com.symc.qa.testdata;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.symc.qa.base.testbase;
import com.symc.qa.pages.Loginpage;
import com.symc.qa.pages.SMOPage;

public class LoginTest extends testbase {
	
	Loginpage login_page;
	
	SMOPage smpage;

	public LoginTest() throws IOException {
		super();
		
	}
	
	@BeforeTest
	public void setup() throws IOException
	{
		init();
	 login_page = new Loginpage();
		
	}
	@Test(priority=1)
	public void loginpage_titletest()
	{
		String title=login_page.validatelogintitle();
		Assert.assertEquals(title, "Log In with Western Union in the United States");
	}
	
	@Test(priority=2)
	public void wulogoimagetest()
	{
		boolean wuimage =login_page.validateimage();
		Assert.assertTrue(wuimage);
	}
	
	@Test(priority=3)
	public void logintest()
	{
		smpage= login_page.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
