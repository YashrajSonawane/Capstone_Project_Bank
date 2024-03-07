package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositsPage;
import com.xyz.qa.pages.TransactionsPage;
import com.xyz.qa.pages.WithdrawalPage;
import com.xyz.qa.util.TestUtil;

public class CustomerHomePageTest extends TestBase{
	
	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	TransactionsPage customerTransaction;
	DepositsPage customerDeposit;
	WithdrawalPage customerWithdrawal;
	TestUtil testutil;
	
	
	public CustomerHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin = new CustomerLoginPage();
		customerHome = customerLogin.Login();
	}
	
	@Test(priority=1)
	
	public void CustomerHomeTitleTest()
	{
		String hometitle = customerHome.verifyHomePageTitle();
		Assert.assertEquals(hometitle,"XYZ Bank","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void CustomerNameTest()
	{
		String customerName = customerHome.customerName();
		Assert.assertEquals(customerName,"Harry Potter","User's name is not matched");
	}
	
	@Test(priority=3)
	public void AccountNumberTest()
	{
		String customeracNumber = customerHome.AccountNo();
		Assert.assertEquals(customeracNumber,"1004","Account number doesn't match");
	}
	@Test(priority=4)
	public void TransactionBtn()
	{
		customerTransaction = customerHome.clickonTransaction();
	}
	
	@Test(priority=5)
	public void DepositBtn()
	{
		customerDeposit = customerHome.clickonDeposit();
	}
	
	@Test(priority=6)
	public void WithdrawalBtn()
	{
		customerWithdrawal = customerHome.clickonWithdrawal();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
