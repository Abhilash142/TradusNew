package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethod {
	public RemoteWebDriver driver = null;

	@FindBy(xpath = "//p[text()='Welcome back! Please log in to your account.']")
	public WebElement LoginPageVerify;
	
	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']")
	public WebElement emailTextField;

	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='password']")
	public WebElement passwordTextField;
	
	@FindBy(xpath = "//span[contains(text(),'Log in ')]/parent::button")
	public WebElement LoginButton;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//button[contains(@class, 'parent-dropdown cursor-pointer')]")
	public WebElement profileIconOnHeader;
	
	@FindBy(xpath = "//div[contains(@class, 'vs-dropdown--menu')]//li[2]")
	public WebElement logoutOptionInProfileIconDropdown;
	
	@FindBy(xpath = "//h4[contains(text(),'Popular ads')]")
	public WebElement overviewPageVerificationElement;
	
	public CommonMethod(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UserId, String Password) throws Exception {
		explicitWaitFortheElementTobeVisible(driver,emailTextField);
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
		explicitWaitFortheElementTobeVisible(driver,profileIconOnHeader);
		try {
			click(profileIconOnHeader);
		} catch (Exception e) {
			jsClick(driver, profileIconOnHeader);
		}
		waitTill(1000);
		try {
			click(logoutOptionInProfileIconDropdown);
		} catch (Exception e) {
			jsClick(driver, logoutOptionInProfileIconDropdown);
		}
	}
}
