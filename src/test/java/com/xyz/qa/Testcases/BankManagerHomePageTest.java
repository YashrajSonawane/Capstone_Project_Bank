package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.AddCustomerPage;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.CustomersPage;
import com.xyz.qa.pages.ManagerLogout;
import com.xyz.qa.pages.OpenAccountPage;
import com.xyz.qa.util.TestUtil;

public class BankManagerHomePageTest extends TestBase{
	
	BankManagerLoginPage managerLogin;
	BankManagerHomePage managerHome;
	AddCustomerPage managerAdd;
	OpenAccountPage managerOpenAccount;
	CustomersPage managerCustomerList;
	ManagerLogout managerlogout;
	TestUtil testutil;
	
	public BankManagerHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerLogin = new BankManagerLoginPage();
		managerHome = managerLogin.Login();
	}
	
	@Test(priority=1)
	
	public void BankManagerHomeTitleTest()
	{
		String title = managerLogin.validateLoginPageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}

	@Test(priority=2)
	public void AddCustbtn()
	{
		managerAdd = managerHome.clickonAddCustomer();
	}
	
	@Test(priority=3)
	public void openAccountbtn()
	{
		managerOpenAccount = managerHome.clickonOpenAccount();
	}
	@Test(priority=4)
	public void customerListbtn()
	{
		managerCustomerList = managerHome.clickonCustomers();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
