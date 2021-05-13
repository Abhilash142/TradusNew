package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTradusPROPage {
	public RemoteWebDriver driver = null;

	@FindBy(xpath = "//h4[text()='Log in']")
	public WebElement LoginText;

	@FindBy(xpath = "//p[text()='Welcome back! Please log in to your account.']")
	public WebElement LoginToYourAccount;

	//@FindBy(xpath = "//span[@class='input-span-placeholder vs-input--placeholder large'][contains(text(),'Email')]")
	//public WebElement emailNameElement;

	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']/following-sibling::span")
	public WebElement emailNameElement;
	
	@FindBy(xpath = "//span[contains(@class,'input-span-placeholder vs-input--placeholder large')][contains(text(),'Password')]")
	public WebElement passwordNameElement;

	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']")
	public WebElement emailTextField;
	
	/*@FindBy(xpath = "(//input[@name='email'])[2]")
	public WebElement emailTextField;*/

	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='password']")
	public WebElement passwordTextField;

	@FindBy(xpath = "//div[contains(@class,'text-danger')][contains(text(),'email')]")
	public WebElement emailErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'text-danger')][contains(text(),'password')]")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//a[text()=' Forgot password? ']")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//span[contains(text(),'Register')]/parent::button")
	public WebElement RegisterButton;

	@FindBy(xpath = "//span[contains(text(),'Log in ')]/parent::button")
	public WebElement LoginButton;
	
	//@FindBy(xpath = "//h2[contains(text(),' password has been successfully reset. ')]")
	//public WebElement PasswordResetSuccessMessage;
	
	@FindBy(xpath = "//h2[contains(text(),' Your password has been successfully reset. ')]")
	public WebElement PasswordResetSuccessMessage;

	@FindBy(xpath = "//h2[contains(@class,'text-danger')][contains(text(),'Please')]")
	public WebElement unConfirmedEmailDangerText;
	
	@FindBy(xpath = "//span[contains(.,'Overview')]/parent::a")
	public WebElement overviewPageVerificationElement;
	
	@FindBy(xpath = "//span[contains(.,'Overview')]/parent::a")
	public WebElement overviewOptioninSiderBar;
	
	@FindBy(xpath = "//img[@alt='user-img']")
	public WebElement overviewUserDropdown;
	
	@FindBy(xpath = "//span[text()='Log out']//parent::li")
	public WebElement overviewLogoutLink;
	
	
	public LoginTradusPROPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver,"https://pro.tradus.com/login");
		waitTill(2000);
	}

	public void setAccountEmailAndPassword(String email,String password) {
		try {
			sendKeys(emailTextField, email);
			waitTill(1000);
			sendKeys(passwordTextField, password);
			waitTill(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
