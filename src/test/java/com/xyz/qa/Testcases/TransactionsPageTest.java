package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.TransactionsPage;
import com.xyz.qa.util.TestUtil;


public class TransactionsPageTest extends TestBase{
	
	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	TransactionsPage customerTransactions;
	TestUtil testutil;
	
	public TransactionsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin= new CustomerLoginPage();
		customerHome = customerLogin.Login();
		customerHome.clickonTransaction();
		customerTransactions = new TransactionsPage();
	}
	
	@Test(priority=1)
	public void BankManagerHomeTitleTest()
	{
		String title = customerTransactions.validateTransactionsPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	@Test(priority=2)
	public void sortTransaction()
	{
		customerTransactions.sortusingdatetime();
	}
	
	@Test(priority=3)
	public void ResetTransaction()
	{
		customerTransactions.clickReset();
	}
	@Test(priority=4)
	public void BackTransaction()
	{
		customerHome=customerTransactions.clickBack();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
