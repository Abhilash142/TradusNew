package com.otomotoProfi.LMS.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

public class MonthlyPackageOTMPLMSPage {
	public RemoteWebDriver driver=null;
	
	/*@FindBy(xpath = "//h5[contains(text(), 'You are subscribed')]/parent::div/following-sibling::div//div//div//div//div//span")
	public WebElement selectedPackageTitle;*/
	
	@FindBy(xpath = "//h5[contains(text(), 'your active package')]/parent::div/following-sibling::div//span[contains(@class,'text-2xl')]")
	public WebElement selectedPackageTitle;
	
	
	
	@FindBy(xpath = "//h5[text()='This is your active package']/parent::div/following-sibling::div//div//div//div//div//span")
	public WebElement PaidPackageTitle;
	
	/*@FindBy(xpath = "//h5[contains(text(), 'Interested in other packages?')]/parent::div/following-sibling::div")
	public List<WebElement> packagesUnderInterestedInOtherPackagesSection;*/
	
	@FindBy(xpath = "//h5[contains(text(),'Interested in other packages?')]/parent::div//div[contains(@class,'block package rounded')]")
	public List<WebElement> packagesUnderInterestedInOtherPackagesSection;
	
	@FindBy(xpath = "//h5[contains(text(), 'Interested in other packages?')]/parent::div/parent::div//span[text()=' Upgrade package ']")
	public List<WebElement> upgradePackageButtonForSelectedPackage;
	
	@FindBy(xpath = "//h2[text()='Buy package']/parent::header")
	public WebElement buyPackagePageTitle;
	
	@FindBy(xpath= "//img[@class='w-48 block mx-auto my-6 pb-4']")
	public WebElement SEPALabel;
	
	@FindBy(xpath= "//th[text()=' Bank details ']")
	public WebElement bankDetailsHeading;
	
	@FindBy(xpath= "//th[text()=' Company details ']")
	public WebElement companyDetailsHeading;
	
	@FindBy(xpath= "//th[text()=' Bank details ']/ancestor::table//th[text()= ' IBAN ']")
	public WebElement IBANLableField;
	
	@FindBy(xpath= "//th[text()= ' IBAN ']/following-sibling::td")
	public WebElement IBANValueField;
	
	@FindBy(xpath= "//th[text()=' Bank details ']/ancestor::table//th[text()= ' Bank name ']")
	public WebElement BankNameLableField;
	
	@FindBy(xpath= "//th[text()= ' Bank name ']/following-sibling::td")
	public WebElement BankNameValueField;
	
	@FindBy(xpath= "//th[text()=' Bank details ']/ancestor::table//th[text()= ' BIC ']")
	public WebElement BICLableField;
	
	@FindBy(xpath= "//th[text()= ' BIC ']/following-sibling::td")
	public WebElement BICValueField;
	
	@FindBy(xpath= "//th[text()=' Company details ']/ancestor::table//th[text()= ' Legal entity ']")
	public WebElement LegalEntityLableField;
	
	@FindBy(xpath= "//th[text()= ' Legal entity ']/following-sibling::td")
	public WebElement LegalEntityValueField;
	
	@FindBy(xpath= "//th[text()=' Company details ']/ancestor::table//th[text()= ' KVK ']")
	public WebElement KVKLableField;
	
	@FindBy(xpath= "//th[text()= ' KVK ']/following-sibling::td")
	public WebElement KVKValueField;
	
	@FindBy(xpath= "//th[text()=' Company details ']/ancestor::table//th[text()= ' VAT number ']")
	public WebElement VATLableField;
	
	@FindBy(xpath= "//th[text()= ' VAT number ']/following-sibling::td")
	public WebElement VATValueField;
	
	@FindBy(xpath= "//section[@data-title='Log in to your PayPal account']//a[@id='createAccount']")
	public WebElement CreateAnAccountButtonInPayPalLoginPage;
	
	@FindBy(xpath= "//span[@id='transactionCart']")
	public WebElement TransactionCartLinkInSubscriptionPage;
	
	@FindBy(xpath= "//div[@class='subscriptionDetails']")
	public WebElement SubscriptionDetailsPage;
	
	@FindBy(xpath = "//h2[contains(text(),'Subscription details')]")
	public WebElement monthlyPackagePageVerificationElement;
	
	@FindBy(xpath = "//h5[contains(text(), 'your active package')]/parent::div/following-sibling::div//div[@class='w-full']")
	public WebElement selectedPackageInsights;

	@FindBy(xpath = "//h2[contains(.,'Activate Package')]")
	public WebElement activatePackagepageHeading;
	
	@FindBy(xpath = "//h3[contains(.,'total amount')]")
	public WebElement packageAmountTextinActivatePackagePage;
	
	@FindBy(xpath = "//span[contains(.,'Send request')]/parent::button")
	public WebElement sendRequestBtninActivatePackagePage;
	
	@FindBy(xpath = "//h5[contains(text(),'Interested in other packages?')]/parent::div//div[contains(@class,'block package rounded')]//span[@class='text-lg font-regular text-black']")
	public List<WebElement> availablePackageHeaders;
	
	@FindBy(xpath = "//a[contains(.,'Cancel subscription')]")
	public WebElement cancelSubscripion;
	
	@FindBy(xpath = "//div[@class='vs-row']//div[1]")
	public WebElement changePackageText;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'h-full flex flex-col space-between')]//select")
	public WebElement ListingDropdowninSmartPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'h-full flex flex-col space-between')]//select")
	public WebElement ListingDropdowninStarterPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'h-full flex flex-col space-between')]//select")
	public WebElement ListingDropdowninPlusPackage;
	
	@FindBy(xpath = "//div[@class='content-noti']")
	public WebElement sucessNotification;
	
	@FindBy(xpath = "//h1[contains(.,'Wyślij zlecenie')]")
	public WebElement sendOrderPageHeader;
	
	@FindBy(xpath = "//label[contains(.,'Czego dotyczy Twoje zgłoszenie')]/parent::div")
	public WebElement aboutApplicationsectioninSendRqstPage;
	
	public MonthlyPackageOTMPLMSPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
			
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
