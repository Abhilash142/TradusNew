package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsTradusPROPPage {
	
	RemoteWebDriver driver = null;
	
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']")
	 public WebElement EmailsAndPhoneLeadsInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']/parent::div/parent::div/parent::div//p")
	 public WebElement EmailsAnsPhoneLeadsInfo;
	 
	 @FindBy(xpath ="//div[@id='apexcharts9nftozfs']")
	 public WebElement EmailsAnsPhoneLeadsChart;
	 
	 @FindBy(xpath ="//h4[text()=' Visits ']")
	 public WebElement VisitsInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Visits ']/parent::div/parent::div/parent::div//p")
	 public WebElement VisitsInfo;
	 
	 @FindBy(xpath ="//div[@id='apexchartsaxzo3bpb']")
	 public WebElement VisitsGraph;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per month ']")
	 public WebElement LeadsPerMonthInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per month ']/parent::div/parent::div/parent::div//p")
	 public WebElement LeadsPerMonthInfo;
	 
	 @FindBy(xpath ="//div[@id='apexchartsgwoz4anig']")
	 public WebElement LeadsPerMonthGraph;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per country ']")
	 public WebElement LeadsPerCountryInfoHeading;
	 
	 @FindBy(xpath ="//h4[text()=' Leads per country ']/parent::div/parent::div/parent::div//span[text()='No Data Available']")
	 public WebElement LeadsPerCountryInfo;
	 
	 @FindBy(xpath ="//span[.='Email']/following-sibling::span")
	 public WebElement numberOfEmailsLeads;
	 
	 @FindBy(xpath ="//span[contains(.,'callbacks')]/following-sibling::span")
	 public WebElement numberOfPhoneCallbacksinLeads;
	 
	 @FindBy(xpath ="//span[contains(.,'calls')]/following-sibling::span")
	 public WebElement numberOfPhoneCalLeads;
	 
	 @FindBy(xpath ="//span[contains(.,'WhatsApp')]/following-sibling::span")
	 public WebElement numberOfWhatsAppLeads;
	 
	 @FindBy(xpath ="//h4[text()=' Email and phone leads ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')]")
	 public WebElement emailandPhoneLeadsGraph;
	 
	 @FindBy(xpath ="(//h4[text()=' Visits ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')])[1]")
	 public WebElement visitsGraph;
	 
	 @FindBy(xpath ="(//h4[text()=' Leads per month ']/ancestor::div[@class='vx-card']/descendant::div[contains(@class,'apexcharts-theme-light')])[1]")
	 public WebElement leadsPerMonth;
	 
	 @FindBy(xpath = "//a[@href='/lms/leads']")
	 public WebElement leadsLink;
	 
	 @FindBy(xpath = "//input[@id='username_login']")
	 public WebElement tradusUidInLoginPage;
	 
	 @FindBy(xpath = "//input[@id='password_login']")
	 public WebElement tradusPWDInLoginPage;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login')])[1]")
	 public WebElement tradusLoginButton;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login as Buyer')])[1]")
	 public WebElement tradusLoginAsaBuyer;
	 
	 @FindBy(xpath = "(//span[contains(.,'Harish')])[1]/parent::a")
	 public WebElement tradusHomePageVerification;
	 
	 @FindBy(xpath = "//h1[contains(.,'Dionex 32')]")
	 public WebElement dionexAdinTradus;
	 
	 @FindBy(xpath = "//a[contains(.,'Request a Price')]")
	 public WebElement requestAPriceinTradus;
	 
	 @FindBy(xpath = "//button[contains(.,'Send')]")
	 public WebElement submitLeadForminTradus;
	 
	 @FindBy(xpath = "//strong[contains(.,'Your message has been sent')]")
	 public WebElement leadFormSubmitSuccessinTradus;
	 
	 @FindBy(xpath = "//button[contains(.,'Close window')]")
	 public WebElement closeWindowButtoninTradus;
	 
	@FindBy(xpath = "//a[contains(.,'Callback')]")
	public WebElement callBackButtoninTradus;

	@FindBy(xpath = "(//a[contains(.,'Sign out')])[1]")
	public WebElement signOutLinkinTradus;

	@FindBy(xpath = "(//button[contains(@class,'modal__close')])[3]")
	public WebElement closeIconiInSuccessModel;
	
	@FindBy(xpath ="//h4[text()=' Email and phone leads ']/parent::div/parent::div/parent::div//p")
	 public WebElement EmailsAndPhoneLeadsInfo;

	public LeadsTradusPROPPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver,"https://pro.tradus.com/lms/leads");
		waitTill(1000);
	}
	
	public void leadsGenerationinTPRO() throws Exception
	{
		LeadsTradusPROPPage leadsObj = new LeadsTradusPROPPage(driver);
		waitTill(2000);
		loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
		explicitWaitFortheElementTobeVisible(driver, leadsObj.tradusUidInLoginPage);
		waitTill(2000);
		sendKeys(leadsObj.tradusUidInLoginPage,testUser);
		sendKeys(leadsObj.tradusPWDInLoginPage,pwd);
		jsClick(driver,leadsObj.tradusLoginButton);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.tradusLoginAsaBuyer);
		jsClick(driver, leadsObj.tradusLoginAsaBuyer);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.tradusHomePageVerification);
		loadUrl(driver,"https://www.tradus.com/en/spare-parts/other-spare-parts-and-tools/tools/dionex/dionex-32-5837514");
		explicitWaitFortheElementTobeVisible(driver, leadsObj.dionexAdinTradus);
		waitTill(2000);
		jsClick(driver,leadsObj.requestAPriceinTradus);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.submitLeadForminTradus);
		jsClick(driver,leadsObj.submitLeadForminTradus);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.leadFormSubmitSuccessinTradus);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.closeWindowButtoninTradus);
		jsClick(driver,leadsObj.closeWindowButtoninTradus);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.callBackButtoninTradus);
		jsClick(driver,leadsObj.callBackButtoninTradus);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.submitLeadForminTradus);
		jsClick(driver,leadsObj.submitLeadForminTradus);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.leadFormSubmitSuccessinTradus);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.closeWindowButtoninTradus);
		waitTill(2000);
		actionClick(driver,leadsObj.closeIconiInSuccessModel);
		waitTill(3000);
		jsClick(driver,leadsObj.tradusHomePageVerification);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.signOutLinkinTradus);
		click(leadsObj.signOutLinkinTradus);
	}
	public void doLogIn(String UserName, String Password) throws Exception {
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
		 }
		 cmdObj.login(UserName,Password);
		 explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		 loadUrl(driver,"https://pro.tradus.com/lms/leads");
	}
}
