package com.xyz.qa.Testcases;


import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositsPage;
import com.xyz.qa.util.TestUtil;

public class DepositsPageTest extends TestBase{
	
	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	DepositsPage customerDeposit;
	TestUtil testutil;
	
	public DepositsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin= new CustomerLoginPage();
		customerHome = customerLogin.Login();
		customerHome.clickonDeposit();
		customerDeposit = new DepositsPage();
	}
	
	@Test(priority=1)
	public void BankManagerHomeTitleTest()
	{
		String title = customerDeposit.validateDepositsPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void DepositValidAmt()
	{
		customerDeposit.Deposit(prop.getProperty("nValid"));
		
		Assert.assertTrue(customerDeposit.isadded(),"Amount not added");
	}
	@Test(priority=3)
	public void DepositNegativeAmt()
	{
		customerDeposit.Deposit(prop.getProperty("nNegative"));
		
		Assert.assertFalse(customerDeposit.isadded(),"Amount not added");
	}
	@Test(priority=4)
	public void DepositZeroAmt()
	{
		customerDeposit.Deposit(prop.getProperty("nZero"));
		
		Assert.assertFalse(customerDeposit.isadded(),"Amount not added");
	}
	@Test(priority=5)
	public void DepositBlankAmt()
	{
		customerDeposit.Deposit(prop.getProperty("nBlank"));
		
		Assert.assertTrue(customerDeposit.isadded(),"Amount not added");
	}
	@Test(priority=6)
	public void DeposittenraisetopowAmt()
	{
		customerDeposit.Deposit(prop.getProperty("ntenraisetopow"));
		
		Assert.assertTrue(customerDeposit.isadded(),"Amount not added");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
