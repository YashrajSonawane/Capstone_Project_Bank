package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class BankManagerLoginPage extends TestBase {
	
	//Page Factory- Object Repository:
	
	@FindBy(xpath="//button[text()='Bank Manager Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[text()='Home']")
	WebElement HomeBtn;
	
	@FindBy(xpath="//strong[@class='mainHeading']")
	WebElement xyzLogo;
	
	//Initializing page Objects:
	public BankManagerLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatexyzLogo()
	{
		return xyzLogo.isDisplayed();
	}
	
	
	public BankManagerHomePage Login()
	{
		LoginBtn.click();
		
		return new BankManagerHomePage();
	}

}
