package com.tradus.pro.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.password;
import static com.tradus.core.GlobalConstants.vatNumber;
import static com.tradus.core.GlobalConstants.companyName;
import static com.tradus.core.GlobalConstants.contactPerson;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.GlobalConstants.webSIteLink;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.mobileNumber;
import static com.tradus.core.GlobalConstants.whatsAppAvailable;

public class SignupTPROPage {

	RemoteWebDriver driver = null;

	@FindBy(xpath = "//*[@alt='Tradus']")
	public WebElement TRProLogo;

	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	public WebElement SignIn;

	@FindBy(xpath = "//h4[text()='Log in']")
	public WebElement LoginPage;
	
	@FindBy(xpath = "//div[@class='px-12 text-center']")
	public WebElement proCaption;

	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']")
	public WebElement languageText;

	@FindBy(xpath = "//span[contains(text(), 'Reach out to our sales team!')]/..")
	public WebElement ReachOutToOurSalesTeam;

	@FindBy(xpath = "(//span[@class='vs-radio']/span[@class='vs-radio--circle'])[1]")
	public WebElement companyRadioButton;
	
	@FindBy(xpath = "//span[text()='Company ']/parent::label//input[@name='user_type']")
	public WebElement companyRadioBtn;
	
	@FindBy(xpath = "(//span[@class='vs-radio']/span[@class='vs-radio--circle'])[2]")
	public WebElement privateRadioButton;

	/*@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='email']")
	public WebElement emailField;*/
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='email']")
	public WebElement emailField;

	/*@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='password']")
	public WebElement passWordField;*/
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='password']")
	public WebElement passWordField;

	@FindBy(xpath = "//div[@class='wizard-card-footer clearfix']//button")
	public WebElement nextButton;

	@FindBy(xpath = "//input[@name='agreed']")
	public WebElement agreeCheckBox;

	@FindBy(xpath = "//input[@name='agreed']/../../..//div[contains(@class,'text-danger')]")
	public WebElement agreeCheckBoxError;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Country']")
	public WebElement detailsCountryText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='VAT number']")
	public WebElement detailsVATNumberText;

	@FindBy(xpath = "//li//div[@class='wizard-icon-container']")
	public WebElement detailsPageDetailElement;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Company name']")
	public WebElement detailsCompanyText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='City']")
	public WebElement detailsCityText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Address']")
	public WebElement detailsAddressText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='ZIP code']")
	public WebElement detailsZIPCodeText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Contact person']")
	public WebElement detailsContactPersonText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Website']")
	public WebElement detailsWebsiteText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Phone']")
	public WebElement detailsPhoneText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Mobile phone']")
	public WebElement detailsMobilephoneText;

	@FindBy(xpath = "//div[@class='zdksearch']")
	public WebElement termsPageCheck;

	@FindBy(xpath = "//input[@name='agreed']/../..//a")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[1]")
	public WebElement privacyLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[2]")
	public WebElement coockiesLink;

	@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='email']/../../..//div[contains(@class,'text-danger')]")
	public WebElement emailFieldDangerText;

	@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='password']/../../..//div[contains(@class,'text-danger')]")
	public WebElement passWordFieldDangerText;

	@FindBy(xpath = "//a[text()=' 0049 30 2555 5338']")
	public WebElement phoneNumberAtBottomDE;

	@FindBy(xpath = "//a[text()=' 0031 23 799 6576']")
	public WebElement phoneNumberAtBottomNL;

	@FindBy(xpath = "//a[text()=' 0040 31 630 2046']")
	public WebElement phoneNumberAtBottomRO;

	@FindBy(xpath = "//div[@class='multiselect__tags']//span")
	public WebElement detailsCountryDropdown;

	@FindBy(xpath = "//label[text()='VAT number']/..//input[contains(@name,'vat')]")
	public WebElement detailsVATNoTextField;

	@FindBy(xpath = "//label[text()='Company name']/..//input[contains(@name,'company-name')]")
	public WebElement detailsCompanyNameTextField;

	@FindBy(xpath = "//label[text()='Full name']/..//input[contains(@name,'name')]")
	public WebElement detailsPrivateFullNameTextField;

	@FindBy(xpath = "//label[text()='City']/..//input[contains(@name,'city')]")
	public WebElement detailsCityTextField;

	@FindBy(xpath = "//label[text()='Address']/..//input[contains(@name,'address')]")
	public WebElement detailsCompanyAddressTextField;

	@FindBy(xpath = "//label[text()='ZIP code']/..//input[contains(@autocomplete,'postal-code')]")
	public WebElement detailsCompanyZIPTextField;

	@FindBy(xpath = "//label[text()='Contact person']/..//input[contains(@name,'rep-name')]")
	public WebElement detailsContactPersonTextField;

	@FindBy(xpath = "//label[text()='Website']/..//input[@data-vv-as='website']")
	public WebElement detailsCompanyWebsiteTextField;

	@FindBy(xpath = "//label[text()='Phone']/..//input[@data-vv-as='phone']")
	public WebElement detailsPhoneTextField;

	@FindBy(xpath = "//label[text()='Mobile phone']/..//input[@data-vv-as='mobile phone']")
	public WebElement detailsMobilePhoneTextField;

	@FindBy(xpath = "//span[contains(text(),'on WhatsApp?')]/..")
	public WebElement detailsAvailableOnWhatsAppCheckbox;

	@FindBy(xpath = "//h4[text()=' Billing information ']/..//button//input")
	public WebElement detailsBillingInformationTooglebutton;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	public WebElement detailsNextbutton;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	public WebElement detailsBackbutton;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	public WebElement packageBackbutton;

	@FindBy(xpath = "//div[@id='Package2']")
	public WebElement packageDisplaying;

	@FindBy(xpath = "//label[text()='VAT number']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsVATfieldDangerText;

	@FindBy(xpath = "//label[text()='Company name']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCompanyNamefieldDangerText;

	@FindBy(xpath = "//label[text()='Full name']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsPrivateNamefieldDangerText;

	@FindBy(xpath = "//label[text()='City']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCityDangerText;

	@FindBy(xpath = "//label[text()='Address']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsAddressDangerText;

	@FindBy(xpath = "//label[text()='ZIP code']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsZIPCodeDangerText;

	@FindBy(xpath = "//label[text()='Website']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsWebsiteDangerText;

	@FindBy(xpath = "//label[text()='Phone']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsPhoneDangerText;

	@FindBy(xpath = "//label[text()='Mobile phone']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsMobilePhoneDangerText;

	@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='email']/../../..//div[contains(@class,'text-danger')]/a")
	public WebElement goToSignInPageErrorLinkOnEnteringRegisteredEmail;

	@FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='password']/../../..//div[contains(@class,'text-danger')]")
	public WebElement passWordErrorMessgaeElement;

	@FindBy(xpath = "//div[contains(@class,'vx-card__title')]//h4[@class='mb-4']")
	public WebElement loginPageVerificationElement;

	@FindBy(xpath = "//input[@name='billing-rep-name']")
	public WebElement detailsBillingInfoContactPersonTextbox;

	@FindBy(xpath = "//input[@name='billing-email']")
	public WebElement detailsBillingInfoEmailTextbox;

	@FindBy(xpath = "//input[@name='billing-company-name']")
	public WebElement detailsBillingInfoCompanyTextbox;

	@FindBy(xpath = "(//div[@class='multiselect__tags']//span)[2]")
	public WebElement detailsBillingInfoCountryTextbox;

	@FindBy(xpath = "//input[@name='billing-city']")
	public WebElement detailsBillingInfoCityTextbox;

	@FindBy(xpath = "//input[@name='billing-address']")
	public WebElement detailsBillingInfoAddressTextbox;

	@FindBy(xpath = "//input[@name='billing-zip']")
	public WebElement detailsBillingInfoZIPTextbox;

	@FindBy(xpath = "//input[@name='billing-phone']")
	public WebElement detailsBillingInfoPhoneTextbox;

	@FindBy(xpath = "(//label[text()='Contact person']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoCompanyContactPersonDangerText;

	@FindBy(xpath = "//label[text()='Contact person']/../..//div[@class='text-danger mt-2']")
	public WebElement detailsBillingInfoPrivateContactPersonDangerText;

	@FindBy(xpath = "(//label[text()='Email']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoEmailDangerText;

	@FindBy(xpath = "(//label[text()='City']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoCityDangerText;

	@FindBy(xpath = "(//label[text()='Address']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoAddressDangerText;

	@FindBy(xpath = "(//label[text()='ZIP code']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoZIPCodeDangerText;

	@FindBy(xpath = "(//label[text()='Phone']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoPhoneDangerText;

	@FindBy(xpath = "(//label[text()='Company name']/../..//div[@class='text-danger mt-2'])[2]")
	public WebElement detailsBillingInfoCompanyNameDangerText;

	@FindBy(xpath = "//input[@name='company-country']")
	public WebElement detailsCompanyCountry;

	@FindBy(xpath = "//input[@name='company-country']/../following-sibling::div//span[text()='India']")
	public WebElement detailsCompanyCountrySelectText;

	@FindBy(xpath = "//input[@name='billing-country']")
	public WebElement detailsBillingCompanyCountry;

	@FindBy(xpath = "//input[@name='billing-country']/../following-sibling::div//span[text()='India']")
	public WebElement detailsBillingCompanyCountrySelectText;

	@FindBy(xpath = "//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> countryDropdownvalues;

	@FindBy(xpath = "//label[text()='Contact person']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsContactPersonDangerText;

	@FindBy(xpath = "//div[@class='vx-row']//label[text()='Full name']")
	public WebElement detailsFullameText;

	@FindBy(xpath = "//*[text()='Edit this information']/..")
	public WebElement editThisInformation;

	@FindBy(xpath = "//button[contains(.,'Create an account')]")
	public WebElement createAnAccount;

	@FindBy(xpath = "//div[text()=' Price per month ']/following-sibling::div")
	public WebElement pricePerMonth;

	@FindBy(xpath = "//div[text()=' VAT ']/following-sibling::div")
	public WebElement VAT;

	@FindBy(xpath = "//div[text()=' Total per month ']/following-sibling::div")
	public WebElement totalPerMonth;

	@FindBy(xpath = "//li[@class='active'][contains(.,'Confirmation')]/a/div")
	public WebElement confirmation;

	@FindBy(xpath = "//button[contains(@class,'vs-component vs-switch mr-2 vs-switch-primary')]")
	public WebElement detailsBillingInformationToggle;
	
	@FindBy(xpath = "//div[text()=' Company name ']/following-sibling::div")
	public WebElement AccountSummaryGivenCompanyName;

	@FindBy(xpath = "//div[text()=' Contact person ']/following-sibling::div")
	public WebElement AccountSummaryGivenContactPerson;

	@FindBy(xpath = "//div[text()=' Address ']/following-sibling::div")
	public WebElement AccountSummaryGivenAddress;

	@FindBy(xpath = "//div[text()=' ZIP code ']/following-sibling::div")
	public WebElement AccountSummaryGivenZipCode;

	@FindBy(xpath = "//div[text()=' City ']/following-sibling::div")
	public WebElement AccountSummaryGivenCity;

	@FindBy(xpath = "//div[text()=' Country ']/following-sibling::div")
	public WebElement AccountSummaryGivenCountry;

	@FindBy(xpath = "//div[text()=' Phone ']/following-sibling::div")
	public WebElement AccountSummaryGivenPhone;

	@FindBy(xpath = "//div[text()=' VAT number ']/following-sibling::div")
	public WebElement AccountSummaryGivenVAT;

	@FindBy(xpath = "//div[text()=' Full name ']/following-sibling::div")
	public WebElement AccountSummaryGivenFullName;

	@FindBy(xpath = "//div[text()=' Website ']/following-sibling::div")
	public WebElement AccountSummaryGivenWebsite;

	@FindBy(xpath = "//div[text()=' Mobile phone ']/following-sibling::div")
	public WebElement AccountSummaryGivenMobilePhone;

	@FindBy(xpath = "(//div[text()=' Contact person ']/following-sibling::div)[2]")
	public WebElement BillingSummaryGivenContactPerson;

	@FindBy(xpath = "//div[text()=' Email ']/following-sibling::div")
	public WebElement BillingSummaryGivenEmail;

	@FindBy(xpath = "//div[text()=' Company name ']/following-sibling::div")
	public WebElement BillingSummaryGivenCompanyName;

	@FindBy(xpath = "(//div[text()=' Address ']/following-sibling::div)[2]")
	public WebElement BillingSummaryGivenAddress;

	@FindBy(xpath = "(//div[text()=' ZIP code ']/following-sibling::div)[2]")
	public WebElement BillingSummaryGivenZipCode;

	@FindBy(xpath = "(//div[text()=' City ']/following-sibling::div)[2]")
	public WebElement BillingSummaryGivenCity;

	@FindBy(xpath = "(//div[text()=' Country ']/following-sibling::div)")
	public WebElement BillingSummaryGivenCountry;

	@FindBy(xpath = "(//div[text()=' Phone ']/following-sibling::div)[2]")
	public WebElement BillingSummaryGivenPhone;

	@FindBy(xpath = "//div[text()=' VAT ']/following-sibling::div")
	public WebElement PackageSummaryGivenVAT;

	@FindBy(xpath = "//div[@id='step-Account0']")
	public WebElement accountIcon;

	@FindBy(xpath = "//div[@id='step-Details1']")
	public WebElement detailsIcon;

	@FindBy(xpath = "//div[@id='step-Package2']")
	public WebElement packageIcon;

	@FindBy(xpath = "//div[@id='step-Confirmation3']")
	public WebElement confirmationIcon;

	@FindBy(xpath = "//li//div[@class='wizard-icon-container']")
	public WebElement confirmationPageConfirmationElement;

	@FindBy(xpath = "//li//div[@class='wizard-icon-container']/../..")
	public WebElement commonElementToCheckTabByText;

	@FindBy(xpath = "//div[@class='text-danger mt-2']")
	public List<WebElement> errorMessagesInDetailsPage;

	@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/div[1]//input[@name='selected-package'][1]")
	public WebElement packageSelectedDefaultElement;

	@FindBy(xpath = "//ul[@class='multiselect__content']//li[@class='multiselect__element']/span/span")
	public List<WebElement> countryDropdownvaluesInnerHtml;

	@FindBy(xpath = "//p[text()='Welcome back! Please log in to your account.']")
	public WebElement welcomeBackTextInLogInPage;

	@FindBy(xpath = "//div[@class='vx-card']//input[@name='email']")
	public WebElement loginPageEmailTextField;

	@FindBy(xpath = "//div[@class='vx-card']//input[@name='password']")
	public WebElement loginPagePasswordTextField;

	@FindBy(xpath = "//a[text()=' Forgot password? ']")
	public WebElement loginPageForgotPassword;

	@FindBy(xpath = "//span[text()=' Register ']")
	public WebElement loginPageRegister;

	@FindBy(xpath = "//h4[text()='Recover your password']")
	public WebElement recoverPasswordPage;

	@FindBy(xpath = "//span[contains(text(),'Back to login')]")
	public WebElement recoverPasswordPageBackButton;
	
	@FindBy(xpath = "//div[@class='wizard-footer-right']")
	public WebElement PackagepageNextButton;

	@FindBy(xpath = "//p[contains(.,'Please go to your email to confirm your registration so that you can access your Tradus PRO account.')]")
	public WebElement checkoutPage;
	
	@FindBy(xpath= "(//div[@class='p-8']//input[@name='name'])[2]")
	public WebElement FullNameInputFieldInSupportForm;
	
	@FindBy(xpath= "(//div[@class='p-8']//input[@name='email'])[2]")
	public WebElement EmailInputFieldInSupportForm;
	
	@FindBy(xpath= "(//div[@class='p-8']//input[@name='phone'])[2]")
	public WebElement PhoneInputFieldInSupportForm;
	
	@FindBy(xpath= "(//div[@class='p-8']//span[text()=' Send message '])[2]/parent::button")
	public WebElement SubmitButtonInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//p[contains(text(), 'message has been successfully sent.')]")
	public WebElement SuccessmessageofSupportForm;	
	
	@FindBy(xpath= "//div[@class='wizard-header']")
	public WebElement signUpPageHeader;	
	
	@FindBy(xpath= "//div[@class='wizard-navigation']/ul/li/a")
	public List<WebElement> signUpStages;
	
	@FindBy(xpath= "//ul[@role='tablist']/following-sibling::div//span[text()='Company ']/parent::label")
	public WebElement companyRadioBtnbelowStages;
	
	@FindBy(xpath= "//ul[@role='tablist']/following-sibling::div//span[text()='Private ']/parent::label")
	public WebElement privateRadioBtnBelowStages;

	public SignupTPROPage(RemoteWebDriver driver) throws Exception {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			loadUrl(driver, "https://pro.tradus.com/signup");
			explicitWaitFortheElementTobeVisible(driver,emailField);
		}

	public void setAccountUsernameAndPassword() {
		sendKeys(emailField, username);
		sendKeys(passWordField, password);
		try {
			click(agreeCheckBox);
			waitTill(2000);
			jsClick(driver,nextButton);
			waitTill(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commonFunctionForCheckingPackageWithValidDetails(SignupTPROPage signUpObj, String user)
			throws Exception {
		sendKeys(signUpObj.emailField, username);
		sendKeys(signUpObj.passWordField, password);
		if (user.equals("private")) {
			jsClick(driver,signUpObj.privateRadioButton);
		}
		jsClick(driver,signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver,signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("India");
		click(signUpObj.detailsCountryDropdown);
		waitTill(2000);
		click(listOfCountries.get(randomInt));
		waitTill(2000);
		if (!user.equals("private")) {
			sendKeys(signUpObj.detailsVATNoTextField, vatNumber);
			waitTill(4000);
			sendKeys(signUpObj.detailsCompanyNameTextField, companyName);
			waitTill(2000);
			sendKeys(signUpObj.detailsContactPersonTextField, contactPerson);
			waitTill(1000);
		} else {
			//sendKeys(signUpObj.detailsPrivateNamefieldDangerText, contactPerson);
			sendKeys(signUpObj.detailsPrivateFullNameTextField, contactPerson);
			waitTill(1000);
			waitTill(1000);
		}
		sendKeys(signUpObj.detailsCityTextField, cityName);
		waitTill(2000);
		sendKeys(signUpObj.detailsCompanyAddressTextField, companyAddress);
		waitTill(1000);
		sendKeys(signUpObj.detailsCompanyZIPTextField, zipCode);
		waitTill(1000);
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, webSIteLink);
		waitTill(1000);
		sendKeys(signUpObj.detailsPhoneTextField, phoneNumber);
		waitTill(1000);
		sendKeys(signUpObj.detailsMobilePhoneTextField, mobileNumber);
		waitTill(1000);
		if (whatsAppAvailable) {
			jsClick(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
			waitTill(1000);
		}
		boolean flag = true;
		List<WebElement> errorList = signUpObj.errorMessagesInDetailsPage;
		for (WebElement ele : errorList) {
			if (!getText(ele).trim().isEmpty()) {
				flag = false;
				break;
			}
		}
		Assert.assertTrue(flag == true, "Provided details are not valid");
		scrollDown(driver);
		waitForElement(signUpObj.detailsNextbutton);
		waitTill(1000);
		new Actions(driver).moveToElement(signUpObj.detailsNextbutton).click().build().perform();
		//jsClick(driver,signUpObj.detailsNextbutton);
		waitForElement(signUpObj.PackagepageNextButton);
		waitTill(4000);
		String tabName = getText(signUpObj.commonElementToCheckTabByText).trim();
		Assert.assertTrue(tabName.equals("Package"),
				"Package page is not displayed after filling valid details in details page");
	}

	public void selectDropdownByText(WebElement ele, WebElement select, String text) throws Exception {
		Actions act = new Actions(driver);
		act.click(ele).build().perform();
		sendKeys(ele, text);
		waitTill(1000);
		act.moveToElement(select);
		waitForElement(select);
		act.click(select).build().perform();
	}
	
}
