package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpDetailsTPROPage_New {
	
	public RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//div[@class='multiselect__tags']//span")
	public WebElement detailsCountryDropdown;

	@FindBy(xpath = "//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> countryDropdownvalues;
	
	@FindBy(xpath = "//ul[@class='multiselect__content']//li[@class='multiselect__element']/span/span")
	public List<WebElement> countryDropdownvaluesInnerHtml;
	
	@FindBy(xpath = "//label[text()='Tax number (Optional)']/parent::div//input[contains(@name,'vat')]")
	public WebElement detailsTaxNoTextField;
	
	@FindBy(xpath = "//label[text()='VAT number (Optional)']/parent::div//input[contains(@name,'vat')]")
	public WebElement detailsVATNoOptionalTextField;
	
	/*@FindBy(xpath = "//label[text()='VAT number']/parent::div//input[contains(@name,'vat')]")
	public WebElement detailsVATNoTextField;*/
	
	@FindBy(xpath = "//label[text()='VAT number  *']/parent::div//input[contains(@name,'vat')]")
	public WebElement detailsVATNoTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Company name']/..//input[contains(@name,'company-name')]")
	public WebElement detailsCompanyNameTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='Company name *']/..//input[contains(@name,'company-name')]")
	public WebElement detailsCompanyNameTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Address']/..//input[contains(@name,'address')]")
	public WebElement detailsCompanyAddressTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='Address *']/..//input[contains(@name,'address')]")
	public WebElement detailsCompanyAddressTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='ZIP code']/..//input[contains(@autocomplete,'postal-code')]")
	public WebElement detailsCompanyZIPTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='ZIP code *']/..//input[contains(@autocomplete,'postal-code')]")
	public WebElement detailsCompanyZIPTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='City']/..//input[contains(@name,'city')]")
	public WebElement detailsCityTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='City *']/..//input[contains(@name,'city')]")
	public WebElement detailsCityTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Website']/..//input[@data-vv-as='website']")
	public WebElement detailsCompanyWebsiteTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='Website']/..//input[@data-vv-as='website']")
	public WebElement detailsCompanyWebsiteTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Phone']/..//input[@data-vv-as='phone']")
	public WebElement detailsPhoneTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/parent::div//label[text()='Phone *']/..//input[@data-vv-as='phone']")
	public WebElement detailsPhoneTextField;
	
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[contains(text(),'Payment reference')]/..//input[@name='po']")
	public WebElement detailsPaymentReference;*/
	
	@FindBy(xpath = "//input[@name='po']")
	public WebElement detailsPaymentReference;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Contact person']/..//input[contains(@name,'rep-name')]")
	public WebElement detailsContactPersonTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Contact person *']/..//input[contains(@name,'rep-name')]")
	public WebElement detailsContactPersonTextField;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//label[text()='Mobile phone']/..//input[@data-vv-as='mobile phone']")
	public WebElement detailsMobilePhoneTextField;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Mobile phone']/..//input[@data-vv-as='mobile phone']")
	public WebElement detailsMobilePhoneTextField;
	
	/*@FindBy(xpath = "//label[text()='Country']/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement countryfieldDangerText;*/
	
	@FindBy(xpath = "//label[text()='Country *']/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement countryfieldDangerText;
	
	/*@FindBy(xpath = "//label[text()='Tax number (Optional)']/parent::div/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement taxfieldDangerText;*/
	
	@FindBy(xpath = "//label[text()='Tax number (Optional)']/parent::div/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement taxfieldDangerText;
	
	/*@FindBy(xpath = "//label[text()='VAT number']/parent::div/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement VATfieldDangerText;*/
	
	@FindBy(xpath = "//label[text()='VAT number  *']/parent::div/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement VATfieldDangerText;
	
	/*@FindBy(xpath = "//label[text()='Company name']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCompanyNamefieldDangerText;*/
	
	@FindBy(xpath = "//label[text()='Company name *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCompanyNamefieldDangerText;
	
	/*@FindBy(xpath = "//label[text()='Phone']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsPhoneDangerText;*/
	
	@FindBy(xpath = "//label[text()='Phone *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsPhoneDangerText;
	
	/*@FindBy(xpath = "//label[text()='Address']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsAddressDangerText;*/
	
	@FindBy(xpath = "//label[text()='Address *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsAddressDangerText;
	
	/*@FindBy(xpath = "//label[text()='ZIP code']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsZIPCodeDangerText;*/
	
	@FindBy(xpath = "//label[text()='ZIP code *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsZIPCodeDangerText;
	
	/*@FindBy(xpath = "//label[text()='City']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCityDangerText;*/
	
	@FindBy(xpath = "//label[text()='City *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsCityDangerText;
	
	@FindBy(xpath = "//label[text()='Website']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsWebsiteDangerText;
	
	@FindBy(xpath = "//label[text()='Mobile phone']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsMobilePhoneDangerText;
	
	/*@FindBy(xpath = "//label[text()='Contact person']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsContactPersonDangerText;*/
	
	@FindBy(xpath = "//label[text()='Contact person *']/../..//div[contains(@class,'text-danger')]")
	public WebElement detailsContactPersonDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]//span[contains(text(),'on WhatsApp?')]/..")
	public WebElement detailsAvailableOnWhatsAppCheckbox;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//span[contains(text(),'on WhatsApp?')]/..")
	public WebElement detailsAvailableOnWhatsAppCheckbox;
	
	@FindBy(xpath = "//h4[text()=' Billing information ']/..//button//input")
	public WebElement detailsBillingInformationTooglebutton;
	
	@FindBy(xpath = "//input[@name='billing-rep-name']")
	public WebElement detailsBillingInfoContactPersonTextbox;
	
	@FindBy(xpath = "//input[@name='billing-email']")
	public WebElement detailsBillingInfoEmailTextbox;
	
	@FindBy(xpath = "//input[@name='billing-name']")
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
	
	@FindBy(xpath = "//input[@name='billing-rep-name']/parent::div/parent::div/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement companyContactPersonDangerTextinBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-company-name']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement companyNameDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-email']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement billingEmailDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "(//div[@class='multiselect__tags']//span)[2]/ancestor::div[contains(@class,'multiselect')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement countryFieldDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-city']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement cityDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-address']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement addressFieldDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-zip']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement zipFieldDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//input[@name='billing-phone']/ancestor::div[contains(@class,'vs-input-primary')]/following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement phoneFieldDangerTextindetailsBillingInfo;
	
	@FindBy(xpath = "//div[@class='wizard-card-footer clearfix']//div[contains(@class,'left')]")
	public WebElement backButtoninDetailsPage;
	
	@FindBy(xpath = "//div[@class='wizard-card-footer clearfix']//button[contains(.,'Create an account')]")
	public WebElement createAnAccountButtoninDetailsPage;
	
	@FindBy(xpath = "(//h2[text()='Monthly cost']/parent::div)[2]")
	public WebElement monthlyCostSectioninDetailsPage;
	
	@FindBy(xpath = "//h4[text()='FAQ']/parent::div")
	public WebElement FAQSectioninDetailsPage;
	
	@FindBy(xpath = "//h4[text()='FAQ']/parent::div//div[@class='vs-collapse px-0 no-padding']//div[contains(@class,'vs-collapse-item py-3')]")
	public List<WebElement> FAQsinDetailsPage;
	
	/*@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]")
	public WebElement companyDetailsSection;*/
	
	@FindBy(xpath = "//h4[contains(.,'Company details')]/ancestor::div[contains(@class,'py-6')]")
	public WebElement companyDetailsSection;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse-item py-6')]")
	public WebElement contactDetailsSection;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]")
	public WebElement contactDetailsSection;
	
	@FindBy(xpath = "//h4[contains(.,'4. Order summary')]")
	public WebElement paymentPageVerificationElement;
	
	@FindBy(xpath = "//button[contains(.,'Make payment')]")
	public WebElement makePaymentButtonPaymentpage;
	
	@FindBy(xpath = "(//h2[text()='Monthly cost']/parent::div//div[text()='VAT']/parent::div[@class='px-4 py-3 flex'])[2]")
	public WebElement vatSectionInMonthlyCost;
	
	@FindBy(xpath = "(//h2[text()='Monthly cost']/parent::div//div[text()='VAT']/following-sibling::p)[2]")
	public WebElement vatPriceInMonthlyCost;
	
	@FindBy(xpath = "(//h2[text()='Monthly cost']/parent::div)[2]//div[text()=' Total per month ']/following-sibling::p")
	public WebElement totalPriceInMonthlyCost;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]")
	public WebElement contactDetailsSectionforIndivisual;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]")
	public WebElement contactDetailsSectionforIndivisual;
	
	@FindBy(xpath = "//h4[contains(.,'Billing information')]/ancestor::div[contains(@class,'py-6 border-t')]")
	public WebElement billingInfoSectionforIndivisual;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Full name']/..//input[contains(@name,'name')]")
	public WebElement fullNameFieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='Full name *']/..//input[contains(@name,'name')]")
	public WebElement fullNameFieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Phone']/..//input[contains(@name,'phone')]")
	public WebElement phoneNumberFieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='Phone *']/..//input[contains(@name,'phone')]")
	public WebElement phoneNumberFieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Mobile phone']/..//input[contains(@name,'mobile-phone')]")
	public WebElement mobilePhoneNumberFieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='Mobile phone']/..//input[contains(@name,'mobile-phone')]")
	public WebElement mobilePhoneNumberFieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Address']/..//input[contains(@name,'address')]")
	public WebElement addressFieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='Address *']/..//input[contains(@name,'address')]")
	public WebElement addressFieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='City']/..//input[contains(@name,'individual-city')]")
	public WebElement cityFieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='City *']/..//input[contains(@name,'individual-city')]")
	public WebElement cityFieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='ZIP code']/..//input[contains(@name,'company-zip')]")
	public WebElement ZIPfieldforIndivisualUser;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/parent::div[contains(@class,'py-6')]//label[text()='ZIP code *']/..//input[contains(@name,'company-zip')]")
	public WebElement ZIPfieldforIndivisualUser;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Full name']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement fullNamefieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Full name *']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement fullNamefieldDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Phone']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement phoneNumberFieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Phone *']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement phoneNumberFieldDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Address']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement addressFieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Address *']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement addressFieldDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='City']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement cityFieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='City *']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement cityFieldDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='ZIP code']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement ZIPfieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='ZIP code *']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement ZIPfieldDangerText;
	
	/*@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'vs-collapse')]//label[text()='Mobile phone']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement mobilePhonefieldDangerText;*/
	
	@FindBy(xpath = "//h4[contains(.,'Contact details')]/ancestor::div[contains(@class,'py-6')]//label[text()='Mobile phone']/../following-sibling::div[@class='text-danger mt-2 mb-4']")
	public WebElement mobilePhonefieldDangerText;
	
	@FindBy(xpath = "//h4[contains(.,'Billing information')]/ancestor::div[contains(@class,'py-6')]")
	public WebElement billingInfoSection;
	
	@FindBy(xpath = "//h4[contains(.,'3. Account details')]")
	public WebElement detailsPageVerificationElement;
	
	public SignUpDetailsTPROPage_New(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	 public void gotoDetailsPage(RemoteWebDriver driver, String user, String userid) throws Exception {
	    	SignUpAccountsTPROPage_New obj2=new SignUpAccountsTPROPage_New(driver);
	    	obj2.gotoAccountsPage(driver, user);
	    	explicitWaitFortheElementTobeVisible(driver,obj2.emailField);
	    	sendKeys(obj2.emailField,userid);
	        sendKeys(obj2.passWordField,pwd);
	        try{
	        	click(obj2.agreeCheckBox);
	        }catch (Exception E) {
	        	jsClick(driver,obj2.agreeCheckBox);
	        }
	        waitTill(1000);
	        try {
			click(obj2.nextButton);
	        }catch(Exception E) {
	        	jsClick(driver,obj2.nextButton);
	        }
			
			//explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
	    }
	
	public void selectCountryFromDropdown(String country) throws Exception {
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf(country);
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		
	}
}
