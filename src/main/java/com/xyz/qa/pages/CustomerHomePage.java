package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class CustomerHomePage extends TestBase {
	
	@FindBy(xpath="//span[@class='fontBig ng-binding']")
	WebElement welcomeTxt; 
	
	@FindBy(xpath="//select[@id='accountSelect']")
	WebElement AcNoDropDown;
	
	@FindBy(xpath="//strong[@class='ng-binding'][1]")
	WebElement AcNoNum;
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][1]")
	WebElement TransactionsBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][2]")
	WebElement DepositBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][3]")
	WebElement WithdrawlBtn;
	
	//Initializing page Objects:
	public CustomerHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String customerName()
	{
		return welcomeTxt.getText();
	}
	
	public void AccountNODropDown()
	{
		Select CustomerAcNumber = new Select(AcNoDropDown);
		CustomerAcNumber.selectByVisibleText(prop.getProperty("AcNumber"));
	}
	
	public String AccountNo()
	{
		return AcNoNum.getText();
	}
	
	public TransactionsPage clickonTransaction()
	{
		TransactionsBtn.click();
		return new TransactionsPage();
	}
	
	public DepositsPage clickonDeposit()
	{
		DepositBtn.click();
		return new DepositsPage();
	}
	
	public WithdrawalPage clickonWithdrawal()
	{
		WithdrawlBtn.click();
		return new WithdrawalPage();
	}
	

}
