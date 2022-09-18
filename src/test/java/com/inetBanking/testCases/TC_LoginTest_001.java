package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;


import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.get(URL);
		logger.info("URL is opened");
				
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		Thread.sleep(1000);
		
		lp.setPassword(password);
		logger.info("Entered password");
		Thread.sleep(1000);
		
		lp.clickSubmit();
		Thread.sleep(1000);
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
	}

}
