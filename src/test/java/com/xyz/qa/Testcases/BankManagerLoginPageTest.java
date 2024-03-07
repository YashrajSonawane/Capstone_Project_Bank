package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.util.TestUtil;

public class BankManagerLoginPageTest extends TestBase {
	
	BankManagerLoginPage BML;
	BankManagerHomePage BMH;
	TestUtil testutil;
	
	public BankManagerLoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		BML = new BankManagerLoginPage();
	}
	
	@Test(priority=1)
	
	public void BankManagerLoginTitleTest()
	{
		String title = BML.validateLoginPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void xyzLogoTest()
	{
		boolean logo = BML.validatexyzLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void ManagerLoginTest()
	{
		BMH = BML.Login();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
