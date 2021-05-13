package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FogrotPasswordOTMPLMSPage {
public RemoteWebDriver driver= null;
	
	@FindBy(xpath = "//h4[text()='Recover your password']")
	public WebElement forgotPasswordPageHeading;
	
	@FindBy(xpath = "//a[text()='Log in ']")
	public WebElement forgotPasswordSignInLink;
	
	@FindBy(xpath = "//p[contains(text(),'enter your email')]")
	public WebElement forgotPasswordInfoText;
	
	@FindBy(xpath = "//label[text()='Email']")
	public WebElement forgotPasswordEmaillabel;
	
	@FindBy(xpath = "//div[@class='text-danger mt-2']")
	public WebElement forgotPasswordBlankEmailDangerText;
	
	@FindBy(xpath = "//h2[contains(text(),'email address does not exist')]")
	public WebElement forgotPasswordUnregisteredEmailDangerText;
	
	@FindBy(xpath = "//label[text()='Email']/../div//input")
	public WebElement forgotPasswordEmailInputField;
	
	@FindBy(xpath = "//span[text()='Back to login ']//parent::button")
	public WebElement forgotPasswordLoginPageLink;
	
	@FindBy(xpath = "//span[text()=' Recover password ']//parent::button")
	public WebElement forgotPasswordRecoveryButton;
	
	@FindBy(xpath = "//h2[contains(text(), 'sent you an email with a link to reset')]")
	public WebElement forgotPasswordSuccessMessage;
	
	@FindBy(xpath = "//span[text()='Sign in']")
	public WebElement gmailFillEmailPageElement;
	
	@FindBy(xpath = "//input[@name='identifier']")
	public WebElement gmailSignInPageUseridField;
	
	@FindBy(xpath = "//div[@id='identifierNext']")
	public WebElement gmailSignInPageUidNextbtn;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement gmailSignInPagePasswordField;
	
	@FindBy(xpath = "//div[@id='passwordNext']")
	public WebElement gmailSignInPagePasswdNextbtn;
	
	@FindBy(xpath = "//h1[@id='headingText']//span[text()='Harish boyapati']")
	public WebElement gmailFillPasswordPageElement;
	
	@FindBy(xpath = "//a[@aria-label='Google apps']")
	public WebElement gmailGoogleAppsLink;
	
	@FindBy(xpath = "//span[text()='Gmail']/parent::a")
	public WebElement gmailLinkinGoogleApps;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome, Harish')]")
	public WebElement googleAccountVerificationElement;
	
	@FindBy(xpath = "//span[text()='Recover Password Instructions']/ancestor::tr")
	public WebElement RecoveryPasswordEmailThread;
	
	@FindBy(xpath = "//a[text()='Change my password']/parent::td")
	public WebElement ResetPasswordbtninEmail;
	
	@FindBy(xpath = "//h4[text()='Set a new password']")
	public WebElement ResetPasswordPageElement;
	
	//@FindBy(xpath = "//span[text()= 'Cancel ']")
	//public WebElement setNewPasswordCancelButton;
	
	 @FindBy(xpath = "//button[contains(@class, 'vs-component vs-button mb-4 mr-4 ')]")
	 public WebElement setNewPasswordCancelButton;
	
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement setNewPasswordTextBox;
	
	@FindBy(xpath = "//input[@name='confirmed-password']")
	public WebElement ConifrmPasswordTextBox;
	
	@FindBy(xpath = "//span[text()= ' Recover password ']")
	public WebElement setNewPasswordPageRecoverPasswordButton;
	
	@FindBy(xpath = "//label[text()='Password']")
	public WebElement resetPasswordPwdElement;
	
	@FindBy(xpath = "//label[text()='Confirm password']")
	public WebElement resetPasswordPwdCnfElement;
	
	@FindBy(xpath = "//div[text()='Primary']/ancestor::td")
	public WebElement GmailInboxPageVerificationElement;
	
	@FindBy(xpath = "(//div[@class='mb-4']//div[contains(@class,'text-danger')])[1]")
	public WebElement resetPasswordDangerText;
	
	@FindBy(xpath = "(//div[@class='mb-4']//div[contains(@class,'text-danger')])[2]")
	public WebElement resetCnfPasswordDangerText;
	
	@FindBy(xpath = "//label[text()='Password']/parent::div//input")
	public WebElement resetPasswordPwdTextfield;
	
	@FindBy(xpath = "//label[text()='Confirm password']/parent::div//input")
	public WebElement resetPasswordCnfPwdTextfield;
	
	@FindBy(xpath = "//span[text()=' Recover password ']/parent::button")
	public WebElement recoverPasswordbtn;
	
	@FindBy(xpath = "//div[@class='vx-card__title mb-4']")
	public WebElement ResetPasswordPageTitle;
	
	@FindBy(xpath = "//a[contains(@aria-label,'Google Account')]")
	public WebElement emailUserDropdown;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	public WebElement emailSignoutButton;
	
	public FogrotPasswordOTMPLMSPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


}
