package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class BankManagerHomePage extends TestBase {

	//Page Factory- Object Repository:
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][1]")
	WebElement AddCustBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][2]")
	WebElement OpenAccountBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][3]")
	WebElement CustBtn;
	
	@FindBy(xpath="//strong[@class='mainHeading']")
	WebElement HomexyzLogo;
	
	@FindBy(xpath="//button[@class='btn home' and contains(@ng-click, 'home()')]")
	WebElement Logout;
	
	//Initializing page Objects:
	public BankManagerHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHomexyzLogo()
	{
		return HomexyzLogo.isDisplayed();
	}
	
	public AddCustomerPage clickonAddCustomer()
	{
		AddCustBtn.click();
		return new AddCustomerPage();
	}
	
	public OpenAccountPage clickonOpenAccount()
	{
		OpenAccountBtn.click();
		return new OpenAccountPage();
	}
	
	public CustomersPage clickonCustomers()
	{
		CustBtn.click();
		return new CustomersPage();
	}
	
	public ManagerLogout clickonLogout()
	{
		Logout.click();;
		return new ManagerLogout();
	}
	
}
