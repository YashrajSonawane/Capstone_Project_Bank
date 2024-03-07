package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class CustomerLogout extends TestBase {
	
	@FindBy(xpath="//button[@ng-show='logout' and contains(@class, 'logout') and @ng-click='byebye()']")
	WebElement Logout;
	
	public CustomerLogout()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateCustomerpageTitle()
	{
		return driver.getTitle();
	}
	
	public CustomerLoginPage Logout()
	{
		 Logout.click();
		 
		 return new CustomerLoginPage();
	}

}
