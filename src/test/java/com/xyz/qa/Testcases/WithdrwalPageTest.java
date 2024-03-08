package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.WithdrawalPage;
import com.xyz.qa.util.TestUtil;

public class WithdrwalPageTest extends TestBase {
	
	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	WithdrawalPage customerWithdraw;
	TestUtil testutil;
	
	public WithdrwalPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin= new CustomerLoginPage();
		customerHome = customerLogin.Login();
		customerHome.clickonWithdrawal();
		customerWithdraw = new WithdrawalPage();
	}
	
	@Test(priority=1)
	public void BankManagerHomeTitleTest()
	{
		String title = customerWithdraw.validateWithdrawalPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	@Test(priority=2)
	public void WithdrawValidAmt()
	{
		customerWithdraw.Withdraw(prop.getProperty("wValid"));
		
		Assert.assertTrue(customerWithdraw.isadded(),"Amount not added");
	}
	@Test(priority=3)
	public void DepositNegativeAmt()
	{
		customerWithdraw.Withdraw(prop.getProperty("wNegative"));
		
		Assert.assertFalse(customerWithdraw.isadded(),"Amount not added");
	}
	@Test(priority=4)
	public void DepositZeroAmt()
	{
		customerWithdraw.Withdraw(prop.getProperty("wZero"));
		
		Assert.assertFalse(customerWithdraw.isadded(),"Amount not added");
	}
	@Test(priority=5)
	public void DepositBlankAmt()
	{
		customerWithdraw.Withdraw(prop.getProperty("wBlank"));
		
		Assert.assertTrue(customerWithdraw.isadded(),"Amount not added");
	}
	@Test(priority=7)
	public void DeposittenraisetopowAmt()
	{
		customerWithdraw.Withdraw(prop.getProperty("wtenraisetopow"));
		
		Assert.assertTrue(customerWithdraw.isadded(),"Amount not added");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
