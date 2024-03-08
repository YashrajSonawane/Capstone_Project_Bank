package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class ManagerLogout extends TestBase {
	
	@FindBy(xpath="//button[@class='btn home' and contains(@ng-click, 'home()')]")
	WebElement Logout;
	
	public ManagerLogout()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatemanagerpageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean islogout()
	{
		return Logout.isDisplayed();
	}
	
	public BankManagerLoginPage Logout()
	{
		 Logout.click();
		 
		 return new BankManagerLoginPage();
	}
	
	

}
