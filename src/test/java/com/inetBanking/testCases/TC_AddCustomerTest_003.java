package com.inetBanking.testCases;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		driver.get(URL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clkAddNewCustomer();
		
		logger.info("Providing customer details..........");
		addCust.setCustomerName("Ravi");
		addCust.setGender("male");
		addCust.setDob("10", "24", "1985");
		Thread.sleep(3000);
		addCust.setAddress("India");
		addCust.setCity("Bangalore");
		addCust.setState("KA");
		addCust.setPinno("234567");
		addCust.setPhoneno("3214765890");
		
		String random_email = randomString()+"@gmail.com";
		addCust.setMailid(random_email);
		addCust.setPassword("asdert");
		addCust.clkSubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true) {
			logger.info("Test case is passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Test case is failed");
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
