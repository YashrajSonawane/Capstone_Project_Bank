package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class DepositsPage extends TestBase{
	
	//Page Factory- Object Repository:
	@FindBy(xpath="//button[@class='btn btn-lg tab'][2]")
	WebElement DepositopBtn;
	
	@FindBy(xpath="//input[@placeholder='amount']")
	WebElement EnterAmt;
	
	@FindBy(xpath="//button[text()='Deposit']")
	WebElement DepositAmt;
	
	@FindBy(xpath="//strong[@class='ng-binding'][2]")
	WebElement balenceUpdate;
	
	
	public DepositsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateDepositsPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isadded()
	{
		return EnterAmt.isDisplayed();
	}
	
	public void Deposit(String n)
	{
		EnterAmt.sendKeys(n);
		DepositAmt.click();
	}
	
	public void checkbalence()
	{
		balenceUpdate.getText();
	}

}
