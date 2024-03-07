package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class CustomerLoginPage extends TestBase{
	
	//Page Factory- Object Repository:
	
		@FindBy(xpath="//button[text()='Customer Login']")
		WebElement CustBtn;
		
		@FindBy(xpath="//select[@id='userSelect']")
		WebElement SelectUser;
		
		@FindBy(xpath="//button[@class='btn btn-default']")
		WebElement LoginBtn;
		
		@FindBy(xpath="//button[text()='Home']")
		WebElement HomeBtn;
		
		@FindBy(xpath="//strong[@class='mainHeading']")
		WebElement xyzLogo;
		
		//Initializing page Objects:
		public CustomerLoginPage()
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
		
		public CustomerHomePage Login()
		{
			CustBtn.click();
			Select CustomerName = new Select(SelectUser);
			CustomerName.selectByVisibleText(prop.getProperty("name"));
			
			LoginBtn.click();
			
			
			return new CustomerHomePage();
		}


}
