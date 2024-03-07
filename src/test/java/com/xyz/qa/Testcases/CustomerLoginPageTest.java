package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerHomePage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.util.TestUtil;



public class CustomerLoginPageTest extends TestBase {
	
	CustomerLoginPage customerLogin;
	CustomerHomePage customerHome;
	TestUtil testutil;
	
	public CustomerLoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		customerLogin = new CustomerLoginPage();
	}
	
	@Test(priority=1)
	
	public void CustomerLoginTitleTest()
	{
		String title = customerLogin.validateLoginPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void xyzLogoTest()
	{
		boolean logo = customerLogin.validatexyzLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void CustomerLoginTest()
	{
		customerHome = customerLogin.Login();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
