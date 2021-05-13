package com.tradus.pro.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

public class MonthlyPackageTradusPROPage {
public RemoteWebDriver driver = null;
	
	/*@FindBy(xpath = "//h5[contains(text(), 'You are subscribed')]/parent::div/following-sibling::div//div//div//div//div//span")
	public WebElement selectedPackageTitle;*/
	
	@FindBy(xpath = "//div[text()='Pending payment']/ancestor::div[@class='w-full']")
	public WebElement subscribedPackageTile;
	
	@FindBy(xpath = "//div[text()='Active']/ancestor::div[@class='w-full']")
	public WebElement PaidPackageTile;
	
	@FindBy(xpath = "(//div[text()='Active']/ancestor::div[@class='w-full']//div[contains(@class,'px-6 py-4')]//div)[1]")
	public WebElement PaidPackageTitle;
	
	@FindBy(xpath = "(//div[text()='Pending payment']/ancestor::div[@class='w-full']//div[contains(@class,'px-6 py-4')]//div)[1]")
	public WebElement subscribedPackageTitle;

	@FindBy(xpath = "//span[text()=' Pay now ']/parent::button")
	public WebElement PayNowButtonForSelectedPackage;
	
	@FindBy(xpath = "(//div[@class='vs-tooltip vs-tooltip-right vs-tooltip-null'])[1]")
	public WebElement PackageStatusTooltip;
	
	@FindBy(xpath = "((//h2[contains(text(), 'Subscription details')]/../following-sibling::div//div[@class='w-full'])[1]//div[contains(@class,'tooltip flex items-center')])[1]")
	public WebElement packageStatusText;
	
	@FindBy(xpath = "//div[.='How many ads will you post per month?']/../parent::div/following-sibling::div/div")
	public List<WebElement> packagesUnderListingSlider;
	
	@FindBy(xpath = "//h5[contains(text(), 'Interested in other packages?')]/parent::div/parent::div//span[text()=' Buy package ']")
	public List<WebElement> buyPackageButtonForSelectedPackage;
	
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
	
	@FindBy(xpath = "//h4[contains(.,'Select a payment method')]/parent::div//span")
	public List<WebElement> paymentOptionsinMonthlyPackage;
	
	@FindBy(xpath = "//h2[contains(.,'total payment')]")
	public WebElement paymentTextWithPrice;
	
	@FindBy(xpath = "//div[contains(@class,'absolute top-0 right-0')]//button")
	public WebElement cancleButtoninPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'Card holder')]/following-sibling::div//input")
	public WebElement cardHoldersName;
	
	@FindBy(xpath = "//button[contains(.,'Pay package')]")
	public WebElement payPackageButtoninPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'IBAN')]/parent::div//div[@id='iban-element']")
	public WebElement ibanFieldinPaymentScreen;
	
	@FindBy(xpath = "//button[contains(.,'Confirm mandate and initiate debit')]")
	public WebElement initiateDebitinPaymentScreen;
	
	@FindBy(xpath = "(//h2[contains(text(), 'Subscription details')]/../following-sibling::div//div[@class='w-full'])[1]/following-sibling::div")
	public WebElement subscriptionPeriodText;
	
	@FindBy(xpath = "//h2[contains(text(), 'Subscription details')]/../following-sibling::div//a[contains(.,'Cancel package')]")
	public WebElement canclePackageLink;
	
	@FindBy(xpath = "//div[.='How many ads will you post per month?']/../parent::div//div[@class='grid mt-1']//div")
	public List<WebElement> numberOfListingInListingBar;

	@FindBy(xpath = "//div[.='How many ads will you post per month?']/../parent::div")
	public WebElement listingBarinPackagePage;
	
	@FindBy(xpath = "//div[.='How many ads will you post per month?']/following-sibling::input")
	public WebElement packageSlider;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	public WebElement nextButtonInMonthlyPackagePage;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header/following-sibling::div")
	public WebElement changePackagePopup;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header/following-sibling::footer//span[.='Agree & Pay']/parent::button")
	public WebElement agreeButtonInChangePackagePopUp;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header/following-sibling::footer//span[.='Go back']/parent::button")
	public WebElement goBackButtonInChangePackagePopUp;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header/following-sibling::div//a[.='Terms of Use']")
	public WebElement termsLinkInChangePackagePopUp;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header/following-sibling::div//a[contains(.,'CONTACT SALES')]")
	public WebElement contactSalesLinkInChangePackagePopUp;
	
	@FindBy(xpath = "//h3[contains(.,'change your Tradus PRO package?')]/ancestor::header//i[.='close']")
	public WebElement closeIconInChangePackagePopUp;
	
	@FindBy(xpath = "//h3[contains(.,'We are sorry to see you go!')]/ancestor::header//i[.='close']")
	public WebElement cancelIconInPackageCancelPopUp;
	
	@FindBy(xpath = "//h3[contains(.,'We are sorry to see you go!')]/ancestor::header/following-sibling::div//a[.='Terms of Use']")
	public WebElement termsLinkInPackageCancelPopUp;
	
	@FindBy(xpath = "//h3[contains(.,'We are sorry to see you go!')]/ancestor::header/following-sibling::footer//span[.='Go back']/parent::button")
	public WebElement goBackButtonInPackageCancelPopUp;
	
	@FindBy(xpath = "//h3[contains(.,'We are sorry to see you go!')]/ancestor::header/following-sibling::footer//span[.='Confirm']/parent::button")
	public WebElement confirmButtonInPackageCancelPopUp;
	
	@FindBy(xpath = "//div[text()='Active']/ancestor::div[contains(@class,'mb-8 px-4')]//following::div[contains(@class,'mb-8 px-4')]//div[@class='w-full']")
	public WebElement upcomingPackage;
	
	@FindBy(xpath = "//div[text()='Active']/ancestor::div[contains(@class,'mb-8 px-4')]//following::div[contains(@class,'mb-8 px-4')]//span[contains(.,'Pay now')]/parent::button")
	public WebElement payNowButtonUnderThisIsYourUpcomingPackage;
	
	@FindBy(xpath = "//div[@id='card-element']/parent::div//h2")
	public WebElement packageInfoInCreditCardPaymentScreen;
	
	@FindBy(xpath = "//div[@id='card-element']//div[@class='__PrivateStripeElement']")
	public WebElement cardNumberFieldInCreditCardPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'Email')]/following-sibling::div//input")
	public WebElement emailFieldInCreditCardPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'IBAN')]/ancestor::div[@class='px-4 pt-4 pb-8']//h2")
	public WebElement packageInfoInSEPAPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'IBAN')]/parent::div/preceding-sibling::div//input[@name='name']")
	public WebElement nameFieldInSEPAPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'IBAN')]/parent::div/preceding-sibling::div//input[@name='email']")
	public WebElement emailFieldInSEPAPaymentScreen;
	
	@FindBy(xpath = "//label[contains(.,'IBAN')]/ancestor::div[@class='px-4 pt-4 pb-8']//div[@class='mt-8']")
	public WebElement paymentInfoInSEPAPaymentScreen;
	
	@FindBy(xpath = "//h3[contains(.,'We are sorry to see you go!')]/ancestor::header/following-sibling::div[@class='vs-dialog-text']")
	public WebElement inSideContentOfPackageCancelPopUp;
	
	@FindBy(xpath = "//div[@class='flex -mx-4 justify-center']//span")
	public List<WebElement> paymentOptionsinForPrePaidUser;
	
	public MonthlyPackageTradusPROPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver, "https://pro.tradus.com/lms/subscription-details");
		waitTill(2000);
	}
	public void doLogIn(String UserName, String Password) throws Exception {
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
		 }
		 cmdObj.login(UserName,Password);
		 explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		 loadUrl(driver, "https://pro.tradus.com/lms/subscription-details");
	}
}
