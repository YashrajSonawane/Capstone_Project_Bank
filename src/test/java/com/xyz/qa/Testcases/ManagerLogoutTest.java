package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.ManagerLogout;
import com.xyz.qa.util.TestUtil;

public class ManagerLogoutTest extends TestBase {
	
	BankManagerLoginPage managerLogin;
	BankManagerHomePage managerHome;
	ManagerLogout managerlogout;
	TestUtil testutil;
	
	public ManagerLogoutTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerLogin = new BankManagerLoginPage();
		managerHome = managerLogin.Login();
		managerlogout = new ManagerLogout();
		
	}
	
	@Test(priority=1)
	public void BankManagerHomeTitleTest()
	{
		String title = managerLogin.validateLoginPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void LogoutTest()
	{
		managerLogin= managerlogout.Logout();
	}


}
