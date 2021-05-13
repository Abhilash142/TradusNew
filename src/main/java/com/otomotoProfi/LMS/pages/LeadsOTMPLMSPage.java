package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tradus.pro.pages.LeadsTradusPROPPage;

public class LeadsOTMPLMSPage  {
	
	RemoteWebDriver driver = null;
	
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']")
	 public WebElement EmailsAndPhoneLeadsInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']/parent::div/parent::div/parent::div//p")
	 public WebElement EmailsAnsPhoneLeadsInfo;
	 
	 @FindBy(xpath ="//h4[text()=' Visits ']")
	 public WebElement VisitsInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Visits ']/parent::div/parent::div/parent::div//p")
	 public WebElement VisitsInfo;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per month ']")
	 public WebElement LeadsPerMonthInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per month ']/parent::div/parent::div/parent::div//p")
	 public WebElement LeadsPerMonthInfo;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per country ']")
	 public WebElement LeadsPerCountryInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per country ']/parent::div/parent::div/parent::div//span[text()='No Data Available']")
	 public WebElement LeadsPerCountryInfo;
	 
	 @FindBy(xpath ="//span[.='Email']/following-sibling::span")
	 public WebElement numberOfEmailsLeads;
	 
	 @FindBy(xpath ="//span[contains(.,'callbacks')]/following-sibling::span")
	 public WebElement numberOfPhoneCallbacksinLeads;
	 
	 @FindBy(xpath ="(//span[contains(.,'calls')]/following-sibling::span)[1]")
	 public WebElement numberOfPhoneCalLeads;
	 
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')]")
	 public WebElement emailandPhoneLeadsGraph;
	 
	 @FindBy(xpath ="(//h4[text()=' Visits ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')])[1]")
	 public WebElement visitsGraph;
	 
	 @FindBy(xpath ="(//h4[text()=' Leads per month ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')])[1]")
	 public WebElement leadsPerMonth;
	 
	 @FindBy(xpath = "//a[@href='/lms/leads']")
	 public WebElement leadsLink;
	 
	 @FindBy(xpath = "//input[@id='username_login']")
	 public WebElement otmpUidInLoginPage;
	 
	 @FindBy(xpath = "//input[@id='password_login']")
	 public WebElement otmpPWDInLoginPage;
	 
	 @FindBy(xpath = "//button[.='Login']")
	 public WebElement otmpLoginButton;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login as Buyer')])[1]")
	 public WebElement otmpLoginAsaBuyer;
	 
	 @FindBy(xpath = "(//button[contains(.,'Zaloguj się jako kupujący')])[1]")
	 public WebElement otmpLoginAsaBuyerinPL;
	 
	 @FindBy(xpath = "(//span[contains(.,'ABHILASH')])[1]/parent::a")
	 public WebElement otmpHomePageVerification;
	 
	 @FindBy(xpath = "//h1[contains(.,'Scania G-series')]")
	 public WebElement ScaniaAdinOTMP;
	 
	 @FindBy(xpath = "//a[contains(.,'Request a Price')]")
	 public WebElement requestAPriceinOTMP;
	 
	 @FindBy(xpath = "//button[contains(.,'Send')]")
	 public WebElement submitLeadForminOTMP;
	 
	 @FindBy(xpath = "//strong[contains(.,'Your message has been sent')]")
	 public WebElement leadFormSubmitSuccessinOTMP;
	 
	 @FindBy(xpath = "//button[contains(.,'Close window')]")
	 public WebElement closeWindowButtoninOTMP;
	 
	 @FindBy(xpath = "//a[contains(.,'Callback')]")
	 public WebElement callBackButtoninOTMP;
	 
	 @FindBy(xpath = "//input[@name='full_name']")
	 public WebElement nameFieldinPhnLeadForm;
	 
	 @FindBy(xpath = "(//input[@name='phone'])[1]")
	 public WebElement phoneFieldinPhnLeadForm;
	
	 @FindBy(xpath = "(//a[contains(.,'Sign out')])[1]")
	 public WebElement signOutLinkinTradus;
 
	 @FindBy(xpath = "(//button[contains(@class,'modal__close')])[3]")
	 public WebElement closeIconiInSuccessModel;
	
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']/parent::div/parent::div/parent::div//p")
	 public WebElement EmailsAndPhoneLeadsInfo;
	 
	 @FindBy(xpath ="(//select[@name='language_select'])[1]")
	 public WebElement languageDropdowninOTMP;
	 
	 @FindBy(xpath ="//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']")
	 public WebElement popularAdssectioninLeads;
			 
	@FindBy(xpath ="//div[@class='layer__modal login-buyer-or-seller-modal' and @data-is-open='true']")
	public WebElement loginAsBuyerorSellerPopUp;
	
	@FindBy(xpath ="//a[@id='login_tab']")
	public WebElement logInTabInLoginPage;
	
	@FindBy(xpath ="//span[.='Email']/parent::a[contains(@class,'offer-contact__button')]")
	public WebElement contactEmail;
	
	
	@FindBy(xpath ="//a[@id='user-menu-label']")
	public WebElement userMenuInOTMP;
	
	
	@FindBy(xpath ="//a[@id='login_tab']")
	public WebElement loginTab;
	 
	public LeadsOTMPLMSPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/leads");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leadsGenerationinOTMP() throws Exception
	{
		//LeadsOTMPLMSPage leadsObj = new LeadsOTMPLMSPage(driver);
		waitTill(2000);
		loadUrl(driver,"https://www.otomotoprofi.pl/account/login#tab-login");
		explicitWaitFortheElementTobeVisible(driver, loginTab);
		try {
			click(loginTab);
		}catch(Exception E) {
			jsClick(driver,loginTab);
		}
		explicitWaitFortheElementTobeVisible(driver, otmpUidInLoginPage);
		explicitWaitFortheElementTobeVisible(driver, languageDropdowninOTMP);
		Select s =new Select(languageDropdowninOTMP);
		s.selectByValue("en");
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,logInTabInLoginPage);
		try{
			click(logInTabInLoginPage);
		}catch(Exception E) {
			jsClick(driver,logInTabInLoginPage);
		}
		explicitWaitFortheElementTobeVisible(driver, otmpLoginButton);
		waitTill(1000);
		sendKeys(otmpUidInLoginPage,testUserPL);
		sendKeys(otmpPWDInLoginPage,pwd);
		jsClick(driver,otmpLoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginAsBuyerorSellerPopUp);
		if(verifyElementPresent(otmpLoginAsaBuyer)) {
			jsClick(driver, otmpLoginAsaBuyer);
		}
		else {
			jsClick(driver, otmpLoginAsaBuyerinPL);
		}
		explicitWaitFortheElementTobeVisible(driver, otmpHomePageVerification);
		loadUrl(driver,"https://www.otomotoprofi.pl/en/spare-parts/engines/scania/scania-g-series-7128618#");
		explicitWaitFortheElementTobeVisible(driver, ScaniaAdinOTMP);
		waitTill(2000);
		jsClick(driver,contactEmail);
		explicitWaitFortheElementTobeVisible(driver, submitLeadForminOTMP);
		jsClick(driver,submitLeadForminOTMP);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, leadFormSubmitSuccessinOTMP);
		explicitWaitFortheElementTobeVisible(driver, closeWindowButtoninOTMP);
		jsClick(driver,closeWindowButtoninOTMP);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,callBackButtoninOTMP);
		jsClick(driver,callBackButtoninOTMP);
		explicitWaitFortheElementTobeVisible(driver,submitLeadForminOTMP);
		//sendKeys(leadsObj.nameFieldinPhnLeadForm,"Test User");
		waitTill(1000);
		sendKeys(phoneFieldinPhnLeadForm,"8792630104");
		jsClick(driver,submitLeadForminOTMP);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,leadFormSubmitSuccessinOTMP);
		explicitWaitFortheElementTobeVisible(driver, closeWindowButtoninOTMP);
		waitTill(1000);
		actionClick(driver,closeIconiInSuccessModel);
		waitTill(2000);
		try {
		   click(userMenuInOTMP);
		}catch(Exception E) {
			jsClick(driver,userMenuInOTMP);
		}
		explicitWaitFortheElementTobeVisible(driver,signOutLinkinTradus);
		try {
			click(signOutLinkinTradus);
			}catch(Exception E) {
				jsClick(driver,signOutLinkinTradus);
			}
		
		waitTill(2000);
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
