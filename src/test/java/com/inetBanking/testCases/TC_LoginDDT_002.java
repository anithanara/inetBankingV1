package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException, IOException {
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			
			logger.warning("login failed");
			captureScreenshot(driver,"loginDDT");
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login success");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/logindata.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		
		String loginData[][] = new String[rowcount][colcount];
		
		for (int i=1; i<=rowcount; i++) {
			for (int j=0; j<colcount; j++) {
				loginData[i-1][j] =XLUtils.getCellData(path, "Sheet1", i, j); //i=1, j=0, but array starts from 0,0
			}
		}
		return loginData;
		
		
	}

}
