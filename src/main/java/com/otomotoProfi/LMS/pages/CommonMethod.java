package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.getText;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethod {
	public RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']/following-sibling::span")
	public WebElement emailNameElement;
	
	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']")
	public WebElement emailTextField;

	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='password']")
	public WebElement passwordTextField;
	
	@FindBy(xpath = "//span[contains(text(),'Log in ')]/parent::button")
	public WebElement LoginButton;
	
	@FindBy(xpath = "//img[@alt='user-img']")
	public WebElement overviewUserDropdown;
	
	@FindBy(xpath = "//span[text()='Log out']//parent::li")
	public WebElement overviewLogoutLink;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']/parent::span")
	public WebElement languageDropdown;
	
	@FindBy(xpath = "//li[contains(.,'English')]")
	public WebElement englishOptioninLangDropdown;
	
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']")
	public WebElement languageText;
	
	public CommonMethod(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String UserId, String Password) throws Exception {
		explicitWaitFortheElementTobeVisible(driver,emailTextField);
		explicitWaitFortheElementTobeVisible(driver,languageDropdown);
		actionClick(driver,languageDropdown);
		waitTill(1000);
		actionClick(driver,englishOptioninLangDropdown);
		sendKeys(emailTextField, UserId);
		sendKeys(passwordTextField, Password);
		waitTill(1000);
		try {
			click(LoginButton);
		}catch(Exception E) {
			jsClick(driver,LoginButton);
		}
		
	}
	
	public void logOut() throws Exception {
		explicitWaitFortheElementTobeVisible(driver,overviewUserDropdown);	
		explicitWaitFortheElementTobeVisible(driver,languageDropdown);
		if(!getText(languageText).trim().equals("English")) {
			actionClick(driver,languageDropdown);
			waitTill(1000);
			actionClick(driver,englishOptioninLangDropdown);
		}
		try {
			click(overviewUserDropdown);
		} catch (Exception e) {
			jsClick(driver, overviewUserDropdown);
		}
		waitTill(1000);
		try {
			click(overviewLogoutLink);
		} catch (Exception e) {
			jsClick(driver, overviewLogoutLink);
		}
	}

}
