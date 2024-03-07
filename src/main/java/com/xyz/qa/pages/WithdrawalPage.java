package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class WithdrawalPage extends TestBase{

	@FindBy(xpath="//button[@class='btn btn-lg tab'][3]")
	WebElement DepositopBtn;
	
	@FindBy(xpath="//input[@placeholder='amount']")
	WebElement EnterAmt;
	
	@FindBy(xpath="//button[text()='Withdraw']")
	WebElement WithdrawAmtbtn;
	
	@FindBy(xpath="//strong[@class='ng-binding'][2]")
	WebElement balenceUpdate;
	
	public WithdrawalPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateWithdrawalPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isadded()
	{
		return EnterAmt.isDisplayed();
	}
	
	public void Withdraw(String w)
	{
		EnterAmt.sendKeys(w);
		WithdrawAmtbtn.click();
	}
	
	public void checkbalence()
	{
		balenceUpdate.getText();
	}
}
