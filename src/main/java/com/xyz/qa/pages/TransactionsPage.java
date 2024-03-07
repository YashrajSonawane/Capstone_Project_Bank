package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class TransactionsPage extends TestBase{

	//Page Factory- Object Repository:
	
	@FindBy(xpath="//button[@class='btn btn-lg tab'][1]")
	WebElement TransactionBtn;
	
	@FindBy(xpath="//button[@class='btn' and @ng-click='back()']")
	WebElement Backbtn;
	
	@FindBy(xpath="//button[contains(@class, 'btn') and contains(@ng-click, 'reset')]")
	WebElement ResetBtn;
	
	@FindBy(xpath="//a[@ng-click=\"sortType = 'date'; sortReverse = !sortReverse\"]")
	WebElement sortUsingDateTime;
	
	@FindBy(xpath="//input[@id='start' and @name='start' and @type='datetime-local']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@id='end' and @name='end' and @type='datetime-local']")
	WebElement endDate;
	
	public TransactionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTransactionsPageTitle()
	{
		return driver.getTitle();
	}
	
	public void sortusingdatetime()
	{
		sortUsingDateTime.click();
	}
	
	public void clickReset()
	{
		ResetBtn.click();
	}
	
	public CustomerHomePage clickBack()
	{
		Backbtn.click();
		
		return new CustomerHomePage();
	}

	
	
	
	
	
	
	
}
