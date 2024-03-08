package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.OpenAccountPage;
import com.xyz.qa.util.TestUtil;

public class OpenAccountTest extends TestBase{
	
	BankManagerLoginPage managerLogin;
	BankManagerHomePage managerHome;
	OpenAccountPage managerOpenAccount;
	TestUtil testutil;
	
	public OpenAccountTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerLogin= new BankManagerLoginPage();
		managerHome = managerLogin.Login();
		managerHome.clickonOpenAccount();
		managerOpenAccount = new OpenAccountPage();
	}
	
	@Test(priority=1)
	public void OpenAccountTitleTest()
	{
		String title = managerOpenAccount.validateopenAccountPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void ValidopenAccount()
	{ 
		managerOpenAccount.selectCustomer();
		Assert.assertTrue(managerOpenAccount.isCustomerSelected(), "Customer selection failed");
		managerOpenAccount.selectCurrency();
		Assert.assertTrue(managerOpenAccount.isCurrencySelected(), "Currency selection failed");
		managerOpenAccount.process();
	}
	
	@Test(priority=3)
	public void InvalidopenAccountwithselectcustomer()
	{
		managerOpenAccount.selectCustomer();
		Assert.assertTrue(managerOpenAccount.isCustomerSelected(), "Customer selection failed");
		managerOpenAccount.process();
	}
	
	@Test(priority=4)
	public void InvalidopenAccountwithcurrency()
	{
		managerOpenAccount.selectCurrency();
		Assert.assertTrue(managerOpenAccount.isCurrencySelected(), "Currency selection failed");
		managerOpenAccount.process();
	}
	
	@Test(priority=5)
	public void InvalidopenAccountwithblank()
	{
		managerOpenAccount.process();
		Assert.assertTrue(managerOpenAccount.isCurrencySelected(), "No field is there");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
