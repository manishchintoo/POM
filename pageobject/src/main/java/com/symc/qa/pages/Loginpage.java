package com.symc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.symc.qa.base.testbase;

public class Loginpage extends testbase {
	
	
	//pagefacotry or or //
	
	@FindBy(xpath="//input[@id='txtEmailAddr']")
	WebElement username;
	
	@FindBy (xpath="//input[@id='txtKey']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='button-continue']")
	WebElement continuebutton;
	
	@FindBy(xpath="//a[@id='menu-wu-logo']//div[1]//img")
	
	WebElement wu_image;

	public Loginpage() throws IOException  {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//Action class
	
	public String validatelogintitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateimage()
	{
		return wu_image.isDisplayed();
	}
	
	public   SMOPage login(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		continuebutton.click();
		
		return  new SMOPage();
	}
	

	
}
