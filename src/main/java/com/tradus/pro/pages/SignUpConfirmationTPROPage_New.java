package com.tradus.pro.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpConfirmationTPROPage_New {
	
	public RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//h4[contains(.,'4.')]")
	public WebElement orderSummeryHeadingInPaymentPage;
	
	@FindBy(xpath = "//h4[contains(.,'Your order')]")
	public WebElement yourOrderHeadingInPaymentPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]")
	public WebElement customerSummarySection;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]")
	public WebElement billingSummarySection;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Company name ']/following-sibling::div")
	public WebElement companyNameinBllingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' VAT number ']/following-sibling::div")
	public WebElement vatNumberinBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Contact person ']/following-sibling::div")
	public WebElement contactPersonNameinBliingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Address ']/following-sibling::div")
	public WebElement addressInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' ZIP code ']/following-sibling::div")
	public WebElement zipCodeInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' City ']/following-sibling::div")
	public WebElement cityInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Country ']/following-sibling::div")
	public WebElement countryInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Phone ']/following-sibling::div")
	public WebElement phoneNumberBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Contact person ']/following-sibling::div")
	public WebElement BillingContactPersonInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Email ']/following-sibling::div")
	public WebElement billingEmailaddressInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' ZIP code ']/following-sibling::div")
	public WebElement billingZIPCodeInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' City ']/following-sibling::div")
	public WebElement billingCityInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Country ']/following-sibling::div")
	public WebElement billingCountryInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Phone ']/following-sibling::div")
	public WebElement billingPhoneInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Billing summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Address ']/following-sibling::div")
	public WebElement billingAddressInBillingPage;
	
	@FindBy(xpath = "//h4[contains(.,'Customer summary')]/ancestor::div[contains(@class,'summary')]//div[text()=' Full name ']/following-sibling::div")
	public WebElement fullNameInBillingPage;
	
	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//div[@class='vs-collapse-item py-3']")
	public List<WebElement> FAQsInBillingPage;	
	
	@FindBy(xpath = "((//h4[text()='FAQ']/..)[2]//div[contains(@class,'vs-collapse')])[1]")
	public WebElement FAQSectionInBillingPage;
	
	@FindBy(xpath = "//h4[text()='Your order']/following-sibling::div[1]")
	public WebElement yourOrderSectionBillingPage;	
	
	@FindBy(xpath = "//h4[text()='Your order']/..//h4[text()='Select a payment method']/following-sibling::div[1]")
	public WebElement PaymentMethodSectioninBillingPage;	
	
	@FindBy(xpath = "//h4[text()='Your order']/following-sibling::div[3]")
	public WebElement makePaymentButtonSectionBillingPage;
	
	@FindBy(xpath = "//span[text()='Paypal']/parent::div")
	public WebElement paypalButton;	
	
	@FindBy(xpath = "//span[text()='Credit card']/parent::div")
	public WebElement creditCardButton;	
	
	@FindBy(xpath = "//span[text()='Stripe direct debit']/ancestor::div[contains(@class,'hover:border')]")
	public WebElement stripeButton;	
	
	@FindBy(xpath = "//button[contains(.,'Make payment')]")
	public WebElement makePaymentButtonPaymentpage;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']")
	public WebElement tabInfo;
	
	@FindBy(xpath = "//h2[text()='Thank you']/ancestor::header")
	public WebElement ThankYouPageVerificationElement;
	
	@FindBy(xpath = "//a[text()='Enter payment information later']")
	public WebElement enterPaymentInfoLaterinPaymentPage;
	
	@FindBy(xpath = "//button[contains(.,'Confirm mandate and initiate debit')]")
	public WebElement stripePaymentVerificationElement;
	
	@FindBy(xpath = "//button[contains(@class,'text-gray-500')]")
	public WebElement stripePaymentPopUpCancleButton;
	
	@FindBy(xpath = "//label[contains(.,'Card')]")
	public WebElement creditCardPopUpVerificationElement;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div")
	public WebElement monthlyCostSection;
	
	/*@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Total per month']/parent::div//p")
	public WebElement totalPriceinMonthlyCostSection;*/
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()=' Total per month ']/parent::div//p")
	public WebElement totalPriceinMonthlyCostSection;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='VAT']/parent::div//p")
	public WebElement VATAmountinMonthlyCostSection;
	
	@FindBy(xpath = "//button[contains(.,'Log in')]")
	public WebElement loginButtoninThankYouPage;
	
	@FindBy(xpath = "//h4[contains(.,'Log in')]")
	public WebElement loginPageVerificationElement;
	
	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//div[@class='vs-collapse-item--content']")
	public List<WebElement> FAQinternalText;

	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//h4[contains(.,'When will I be billed?')]")
	public WebElement FAQno1;
	
	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//h4[contains(.,'cancel my account?')]")
	public WebElement FAQno2;
	
	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//h4[contains(.,'change my plan later?')]")
	public WebElement FAQno3;
	
	@FindBy(xpath = "(//h4[text()='FAQ']/..)[2]//h4[contains(.,'my account be activated?')]")
	public WebElement FAQno4;
	
	public SignUpConfirmationTPROPage_New(RemoteWebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
