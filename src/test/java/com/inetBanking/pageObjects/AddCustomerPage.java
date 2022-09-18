package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how= How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how= How.NAME, using="name")
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME, using="rad1")
	WebElement rdGender;
	
	@FindBy(how= How.ID_OR_NAME, using="dob")
	WebElement txtdob;
	
	@FindBy(how= How.NAME, using="addr")
	WebElement txtAddress;
	
	@FindBy(how= How.NAME, using="city")
	WebElement txtcity;
	
	@FindBy(how= How.NAME, using="state")
	WebElement txtstate;
	
	@FindBy(how= How.NAME, using="pinno")
	WebElement txtpinno;
	
	@FindBy(how= How.NAME, using="telephoneno")
	WebElement txtmobile;
	
	@FindBy(how= How.NAME, using="emailid")
	WebElement txtemailid;
	
	@FindBy(how= How.NAME, using="password")
	WebElement txtpassword;
	
	@FindBy(how= How.NAME, using="sub")
	WebElement btnSubmit;
	
	public void clkAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void setGender(String rgender) {
		rdGender.click();
	}
	
	public void setDob(String mm, String dd, String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}
	
	public void setAddress(String addr) {
		txtAddress.sendKeys(addr);
	}
	
	public void setCity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void setState(String state) {
		txtstate.sendKeys(state);
	}
	
	public void setPinno(String pin) {
		txtpinno.sendKeys(String.valueOf(pin));
	}
	
	public void setPhoneno(String mobile) {
		txtmobile.sendKeys(mobile);
	}
	
	public void setMailid(String mailid) {
		txtemailid.sendKeys(mailid);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clkSubmit() {
		btnSubmit.click();
	}
	
}
