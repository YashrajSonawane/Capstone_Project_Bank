package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class AddCustomerPage extends TestBase {

	//Page Factory- Object Repository:
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][1]")
	WebElement AddCustBtn;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='Post Code']")
	WebElement PostCode;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Addcustomer;
	
	WebElement errormessage;
	
	public AddCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateAddcustomerTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isFirstNameAdded()
	{
		return FirstName.isDisplayed();
	}
	
	public boolean isLastNameAdded()
	{
		return LastName.isDisplayed();
	}
	
	public boolean isPostCodeAdded()
	{
		return PostCode.isDisplayed();
	}
	
	public void add(String FN, String LN, String PC)
	{
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		PostCode.sendKeys(PC);
		Addcustomer.click();
		
		try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            // No alert present
            System.out.println("No alert present.Error Occured");
        }
	}

	public boolean isErrorMessageDisplayed() {
		
		return errormessage.isDisplayed();
	}
	
	
	
	
	
}