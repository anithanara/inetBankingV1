package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String URL = readconfig.getURL();
	public String username = readconfig.getUsername();
	public String password =readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	

	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger = Logger.getLogger("Banking project");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		

		if(br.equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}

		if(br.equals("ie"))
		{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString() {
		String randomemail = RandomStringUtils.randomAlphabetic(6);
		return randomemail;
	}
	
	public static String randomNumber() {
		String randomNum = RandomStringUtils.randomNumeric(5);
		return randomNum;
	}
}
