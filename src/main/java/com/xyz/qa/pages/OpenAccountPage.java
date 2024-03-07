package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class OpenAccountPage extends TestBase{

	//Page Factory- Object Repository:
	
		@FindBy(xpath="//select[@name='userSelect']")
		WebElement CustomerName;
		
		@FindBy(xpath="//select[@id='currency']")
		WebElement Currency;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement Process;
		
		public OpenAccountPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		
		public String validateopenAccountPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean isCustomerSelected() {
		    return CustomerName.isDisplayed(); 
		}
		
		public boolean isCurrencySelected()
		{
			return Currency.isDisplayed();
		}
		
		
		public void selectCustomer()
		{
			Select cust = new Select(CustomerName);
			cust.selectByVisibleText(prop.getProperty("name"));
		}
		
		public void selectCurrency()
		{
			Select currency = new Select(Currency);
			currency.selectByVisibleText(prop.getProperty("currency"));
		}
		
		public void process()
		{
			Process.click();
			try {
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert text: " + alert.getText());
	            alert.accept();
	        } catch (Exception e) {
	            // No alert present
	            System.out.println("No alert present.");
	        }
		}
}

