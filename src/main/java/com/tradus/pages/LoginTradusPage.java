package com.tradus.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.TCOM_User_1;
import static com.tradus.core.GlobalConstants.TCOM_pwd;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;

import static com.tradus.core.ActionElementClass.verifyElementPresent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTradusPage {
	
	public RemoteWebDriver driver = null;
	
	@FindBy(xpath = "(//header[@class='app-header']//a[contains(.,'Login / Register')])[1]")
    public  WebElement link_loginTradus_xpath;
	
	@FindBy(xpath = "//a[@id='login_tab']")
	public static WebElement LoginTab;
	
	@FindBy(xpath = "//a[@id='register_tab']")
	public WebElement SignUpTab;
	
	@FindBy(xpath = "//div[@id='login']//input[@type='email']")
	public WebElement userName;
	
	@FindBy(xpath = "//div[@id='login']//input[@type='password']")
	public WebElement passWord;
	
	@FindBy(xpath = "//div[@class='login-form']//input[@id='username']")
	public WebElement userNameInSignUp;
	
	@FindBy(xpath = "//div[@class='login-form']//input[@id='password']")
	public WebElement PasswordInSignUp;
	
	@FindBy(xpath = "//button[contains(text(),'Create an account')]")
	public WebElement CreateAnAccountButton;
	
	@FindBy(xpath = "//label[.='keep me logged in']/preceding-sibling::input")
	public WebElement input_keepMeLoginCheckBox_xpth;
	
	@FindBy(xpath = "(//button[contains(.,'Login')])[1]")
	public WebElement tradusLoginButton;
	
	@FindBy(xpath = "//div[@id='login']//a[.='Forgot password']")
	public WebElement link_forgotPwd_xpath;
	
	@FindBy(xpath = "//div[@id='login']//a[.='Terms of use']")
	public WebElement link_Terms_xpath;
	
	@FindBy(xpath = "//div[@id='login']//a[.='Privacy Statement']")
	public WebElement link_Privacy_xpath;
	
	@FindBy(xpath = "//div[@id='login']//span[contains(.,'login as a seller')]//a[.='Click here']")
	public WebElement link_SellerLogin_xpath;
	
	@FindBy(xpath = "//div[@id='login']//a[@id='google-login']")
	public WebElement link_googleLogin_xpath;
	
	@FindBy(xpath = "//div[@id='login']//a[@id='fb-login']")
	public WebElement link_FBLogin_xpath;
	
	@FindBy(xpath = "//div[@id='register']//h2[contains(.,'Create a free account')]")
	public WebElement SignUpPageVerify_xpath;
	
	@FindBy(xpath = "//div[@id='register']//a[@id='fb-register']")
	public WebElement link_SignUpwithFb_xpath;
	
	@FindBy(xpath = "//div[@id='register']//a[@id='google-register']")
	public WebElement link_SignUpwithGoogle_xpath;
	
	@FindBy(xpath = "//div[@id='register']//label[contains(.,'Receive e-mails')]/preceding-sibling::input")
	public WebElement checkBox_receiveEmail_xpath;
	
	@FindBy(xpath = "//div[@id='register']//a[.='Terms and Conditions']")
	public WebElement link_termsInRegistrationTab_xpath;
	
	@FindBy(xpath = "//div[@id='register']//a[.='Privacy Statement']")
	public WebElement link_PrivacyInRegistrationTab_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'success-message')]")
	public WebElement div_SignUpSuccess_xpath;
	
	@FindBy(xpath = "//ul[contains(@class,'user-account')]//a[@id='myaccount']")
	public WebElement div_MyAccountTab_xpath;
	
	@FindBy(xpath = "//div[@class='error-message']")
	public WebElement div_ErrorMessage_xpath;
	
	@FindBy(xpath = "(//div[@class='login-buyer-or-seller-modal__content'])[1]")
	public WebElement div_BuyerSellerModel_xpath;
	
	 @FindBy(xpath = "(//button[contains(.,'Login as Buyer')])[1]")
	 public WebElement tradusLoginAsaBuyer;
	 
	 @FindBy(xpath = "(//a[contains(.,'Login as Seller')])[1]")
	 public WebElement tradusLoginAsaSeller;
	 
	 @FindBy(xpath = "//p[text()='Welcome back! Please log in to your account.']")
	 public WebElement para_ProTradusLoginPageVerify_xpath;
	 
	 @FindBy(xpath = "//h2[.='Password assistance']")
	 public WebElement h2_ForgotPasswordPageVerify_xpath;
	
	 @FindBy(xpath = "//div[contains(@class,'glide--benefits')]")
	 public WebElement div_glideSectionInSignUpForm_xpath;
	
	 @FindBy(xpath = "//div[contains(@class,'glide--benefits')]//span[contains(@class,'glide__bullet')]")
	 public WebElement span_glideiconInSignUpForm_xpath;
	
	 @FindBy(xpath = "//span[.='Tradus']/parent::div[contains(.,'Log in to use your Facebook')]")
	 public WebElement div_FaceBookPageVerify_xpath;
	
	 @FindBy(xpath = "(//div[.='Sign in with Google'])[2]")
	 public WebElement div_GooglePageVerify_xpath;
	 
	 @FindBy(xpath = "//input[@name='identifier']")
	 public WebElement input_emailFieldinGooglePage_xpath;
	
	 //@FindBy(xpath = "//label[.='Email address or phone number:']/following-sibling::input")
	 //public WebElement input_emailFieldinFBPage_xpath;
	 
	 @FindBy(xpath = "//input[@id='email']")
	 public WebElement input_emailFieldinFBPage_xpath;
	
	 @FindBy(xpath = "//input[@id='pass']")
	 public WebElement input_passwordFieldinFBPage_xpath;
	 
	 //@FindBy(xpath = "//label[.='Password:']/following-sibling::input")
	// public WebElement input_passwordFieldinFBPage_xpath;
	 
	 @FindBy(xpath = "//label[@id='loginbutton']")
	 public WebElement  btn_loginButtoninFBPage_xpath;
	 
	 @FindBy(xpath = "//input[@name='password']")
	 public WebElement div_passwordFieldInGooglePage_xpath;
	
	 @FindBy(xpath = "//span[.='Next']")
	 public WebElement btn_nextButtonInGooglePage_xpath;
	 
	 @FindBy(xpath = "//span[.='Verify that it's you']")
	 public WebElement span_googleVerify_xpath;
	
	 //@FindBy(xpath = "//div[@class='user-menu-container']//li//a[.='Sign out']")
	// public WebElement link_SignOut_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[@href='/account/logout']")
	 public WebElement link_SignOut_xpath;
	
	 @FindBy(xpath = "//a[@id='user-menu-label']")
	 public WebElement lable_UserMenu_xpath;
	
	public LoginTradusPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
		//waitTill(2000);
	}
	
	public void doLogOut() throws Exception {
		explicitWaitFortheElementTobeVisible(driver,lable_UserMenu_xpath);
		try {
			click(lable_UserMenu_xpath);
		}catch(Exception E){
			jsClick(driver,lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,link_SignOut_xpath);
		waitTill(1500);
		try {
			click(link_SignOut_xpath);
		}catch(Exception E){
			jsClick(driver,link_SignOut_xpath);
		}
		waitTill(1500);
		explicitWaitFortheElementTobeVisible(driver,link_loginTradus_xpath);
	}
	
	public void doLogin(String userId, String password) throws Exception {
		waitTill(1500);
		if(!verifyElementPresent(link_loginTradus_xpath)) {
			doLogOut();
			waitTill(1500);
		}
		explicitWaitFortheElementTobeVisible(driver,link_loginTradus_xpath);
		try {
			click(link_loginTradus_xpath);
		}catch(Exception E){
			jsClick(driver,link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,LoginTab);
		waitTill(1000);
		try {
			click(LoginTab);
		}catch(Exception E){
			jsClick(driver,LoginTab);
		}
		explicitWaitFortheElementTobeVisible(driver,tradusLoginButton);
		waitTill(1000);
		sendKeys(userName,userId);
		sendKeys(passWord,password);
		waitTill(1500);
		try {
			click(tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver,tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,lable_UserMenu_xpath);
	}
}
