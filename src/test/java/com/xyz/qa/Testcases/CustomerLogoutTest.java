package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.CustomerLogout;
import com.xyz.qa.util.TestUtil;


public class CustomerLogoutTest extends TestBase{

	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	CustomerLogout customerlogout;
	TestUtil testutil;
	
	public CustomerLogoutTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin = new CustomerLoginPage();
		customerHome = customerLogin.Login();
		customerlogout = new CustomerLogout();
	}
	
	@Test(priority=1)
	public void BankManagerHomeTitleTest()
	{
		String title = customerLogin.validateLoginPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void LogoutTest()
	{
		customerLogin= customerlogout.Logout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
