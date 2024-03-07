package com.xyz.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.CustomersPage;
import com.xyz.qa.util.TestUtil;

public class CustomerPageTest extends TestBase {
	
	BankManagerLoginPage managerLogin;
	BankManagerHomePage managerHome;
	CustomersPage managerCustomerList;
	TestUtil testutil;
	
	public CustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerLogin= new BankManagerLoginPage();
		managerHome = managerLogin.Login();
		managerHome.clickonCustomers();
		managerCustomerList = new CustomersPage();
	}
	
	@Test(priority=1)
	public void OpenAccountTitleTest()
	{
		String title = managerCustomerList.validatecustomerpageTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	
	public void searchCustomerusingfirstName()
	{
		managerCustomerList.searchCustomer(prop.getProperty("scustomerFirst"));
		
		Assert.assertTrue(managerCustomerList.isCustomerFound(prop.getProperty("scustomerFirst")), "Customer not found after search");
	}
	
	@Test(priority=3)
	
	public void searchCustomerusingLastName()
	{
		managerCustomerList.searchCustomer(prop.getProperty("scustomerLast"));
		
		Assert.assertTrue(managerCustomerList.isCustomerFound(prop.getProperty("scustomerLast")), "Customer not found after search");
	}
	
	@Test(priority=4)
	
	public void searchCustomerusingPostCode()
	{
		managerCustomerList.searchCustomer(prop.getProperty("scustomerpost"));
		
		Assert.assertTrue(managerCustomerList.isCustomerFound(prop.getProperty("scustomerpost")), "Customer not found after search");
	}
	
	@Test(priority=5)
	
	public void searchCustomerusingAccNumber()
	{
		managerCustomerList.searchCustomer(prop.getProperty("scustomeracc"));
		
		Assert.assertTrue(managerCustomerList.isCustomerFound(prop.getProperty("scustomeracc")), "Customer not found after search");
	}
	
	@Test(priority=6)
	public void DeleteSearchedCustomer()
	{
		managerCustomerList.searchCustomer(prop.getProperty("scustomeracc"));
		
		Assert.assertTrue(managerCustomerList.isCustomerFound(prop.getProperty("scustomeracc")), "Customer not found after search");
		
		managerCustomerList.deleteCust();
		
		System.out.println("CustomerDeleted");
	}
	
	@Test(priority=7)
	public void SortingUsingFirstName()
	{
		managerCustomerList.sortusingFirst();
	}
	
	@Test(priority=8)
	public void SortingUsingLastName()
	{
		managerCustomerList.sortusingLast();
	}
	
	@Test(priority=9)
	public void SortingUsingpost()
	{
		managerCustomerList.sortusingpost();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
