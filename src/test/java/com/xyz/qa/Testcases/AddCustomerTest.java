package com.xyz.qa.Testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.AddCustomerPage;
import com.xyz.qa.pages.BankManagerHomePage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.util.TestUtil;


public class AddCustomerTest extends TestBase{
	
	BankManagerLoginPage managerLogin;
	BankManagerHomePage managerHome;
	AddCustomerPage managerAdd;
	TestUtil testutil;
	
	public AddCustomerTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		managerLogin= new BankManagerLoginPage();
		managerHome = managerLogin.Login();
		managerHome.clickonAddCustomer();
		managerAdd = new AddCustomerPage();
	}
	
	@Test(priority=1)
	public void AddCustomerTitleTest()
	{
		String title = managerAdd.validateAddcustomerTitle();
		Assert.assertEquals(title,"XYZ Bank");
	}
	
	@Test(priority=2)
	public void addcustomerwithvalidData()
	{
		managerAdd.add(prop.getProperty("Firstnamevalid"),prop.getProperty("Lastnamevalid"), 
				prop.getProperty("Postcodevalid"));
		
		Assert.assertTrue(managerAdd.isFirstNameAdded(), "First name is not displayed");
		Assert.assertTrue(managerAdd.isLastNameAdded(), "Last name is not displayed");
        Assert.assertTrue(managerAdd.isPostCodeAdded(), "Postcode is not displayed");
	}
	
	@Test(priority=2)
	public void addcustomerwithInvalidData()
	{
		managerAdd.add(prop.getProperty("FirstnameInvalid"),prop.getProperty("LastnameInvalid"), 
				prop.getProperty("PostcodeInvalid"));
		
		Assert.assertTrue(managerAdd.isFirstNameAdded(), "First name is not displayed");
		Assert.assertTrue(managerAdd.isLastNameAdded(), "Last name is not displayed");
        Assert.assertTrue(managerAdd.isPostCodeAdded(), "Postcode is not displayed");
        System.out.println("*******Invalid Data added*******");
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String screenshotLocation = "C:\\Users\\Lenovo\\eclipse-workspace\\Captone_xyzbank\\Screenshots";
		
	}
	
	@Test(priority=3)
	public void addcustomerwithblankData()
	{
		managerAdd.add(prop.getProperty("FirstnameBlank"),prop.getProperty("LastnameBlank"), 
				prop.getProperty("Postcode"));
		
		Assert.assertTrue(managerAdd.isFirstNameAdded(), "First name is not displayed");
		Assert.assertTrue(managerAdd.isLastNameAdded(), "Last name is not displayed");
        Assert.assertTrue(managerAdd.isPostCodeAdded(), "Postcode is not displayed");
        System.out.println("*******Blank Data added*******");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
