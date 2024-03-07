package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class CustomersPage extends TestBase {
	
	//Page Factory- Object Repository:
		
	@FindBy(xpath="//button[@class='btn btn-lg tab btn-primary']")
	WebElement Custbtn;
	
	@FindBy(xpath="//input[@placeholder='Search Customer']")
	WebElement Searchcust;
	
	@FindBy(xpath="//a[normalize-space(text()) = 'First Name']")
	WebElement sortusingFirstName;
	
	@FindBy(xpath="//a[normalize-space(text()) = 'Last Name']")
	WebElement sortusingLastName;
	
	@FindBy(xpath="//a[normalize-space(text()) = 'Post Code']")
	WebElement sortusingPostcode;
	
	@FindBy(xpath="//button[contains(@ng-click, 'deleteCust(cust)')]")
	WebElement Delete;

	public CustomersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatecustomerpageTitle()
	{
		return driver.getTitle();
	}
	
	public void searchCustomer(String SC)
	{
		Searchcust.sendKeys(SC);
	}
	
	public boolean isCustomerFound(String SC)
	{
		return Searchcust.isDisplayed();
	}
	
	public void sortusingFirst()
	{
		sortusingFirstName.click();
	}
	
	public void sortusingLast()
	{
		sortusingLastName.click();
	}
	
	public void sortusingpost()
	{
		sortusingPostcode.click();
	}
	
	public void deleteCust()
	{
		Delete.click();
	}
	
	
	
}
