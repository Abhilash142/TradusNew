package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.loadUrl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicesOtomotoProfiLMSPage {
	
	public RemoteWebDriver driver= null;
	
	@FindBy(xpath = "//table[contains(@class,'table-documents')]//th")
	public List<WebElement> billingPageHeaders;
	
	@FindBy(xpath = "//table[contains(@class,'table-documents')]//tbody")
	public WebElement invoicePageBody;
	
	@FindBy(xpath = "//table[contains(@class,'table-invoices')]//th[text()='Invoice Number']")
	public WebElement invoiceNumberlabel;
	
	@FindBy(xpath = "//th[contains(.,'Due Date')]")
	public WebElement billingPageverificationElement;
	
	public  InvoicesOtomotoProfiLMSPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/billing");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doLogIn(String UserName, String Password) throws Exception {
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.emailNameElement)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.emailNameElement);
		 }
		 cmdObj.login(UserName,Password);
		 explicitWaitFortheElementTobeVisible(driver,cmdObj.overviewUserDropdown);
	}
}
