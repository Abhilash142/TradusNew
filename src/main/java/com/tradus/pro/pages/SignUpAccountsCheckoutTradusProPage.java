package com.tradus.pro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpAccountsCheckoutTradusProPage {

    RemoteWebDriver driver = null;
	
	@FindBy(xpath ="//*[@alt='Tradus']")
	public WebElement TRProLogo;
	
	@FindBy(xpath ="//h2")
	public WebElement CheckoutPageElement;
	
	@FindBy(xpath ="//div[@class='text-center']//p")
	public WebElement CheckoutPageInfoText;
	
	@FindBy(xpath ="//div[@class='vx-row text-center']//p[contains(text(),'PayPal')]")
	public WebElement CheckoutPagePayPalText;
	
	@FindBy(xpath ="//img[contains(@src,'https://www.paypalobjects.com')]/parent::a")
	public WebElement CheckoutPagePayPalLink;
	
	@FindBy(xpath ="//button[contains(text(),'credit card')]//div")
	public WebElement CheckoutCreditCardLink;
	
	@FindBy(xpath ="//h2[contains(text(),'Tradus')]")
	public WebElement CheckoutPackageInfoinPaymentPopup;
	
	@FindBy(xpath ="//input[@placeholder='Card number']/../../..")
	public WebElement CheckoutPackageCreditCardNumberField;
	
	@FindBy(xpath ="//input[@placeholder='MM / YY']")
	public WebElement CheckoutPackageCreditCardExpDateField;
	
	@FindBy(xpath ="//input[@placeholder='CVC']")
	public WebElement CheckoutPackageCreditCardCVCField;
	
	@FindBy(xpath ="//label[contains(text(),'Card holder')]/..//div//input")
	public WebElement CheckoutPackageCreditCardHolderTextField;
	
	@FindBy(xpath ="//label[contains(text(),'Email')]/..//div//input")
	public WebElement CheckoutPackageCreditCardHolderEmailField;
	
	@FindBy(xpath ="//button[contains(text(),'Pay')]")
	public WebElement CheckoutPackageCreditCardPaymentButton;
	
	@FindBy(xpath ="//p[contains(text(),'Missing or incorrect credit')]")
	public WebElement CheckoutPackageCreditCardSumbitDangerText;
	
	@FindBy(xpath ="//iframe[@name='__privateStripeFrame77']")
	public WebElement CheckoutPackageCardDetailsInputFrame;
	
	@FindBy(xpath ="//input[@class='__PrivateStripeElement-input']")
	public WebElement CheckoutPackageCardDetailsInputField;

	@FindBy(xpath ="//h1[text()='Pay with PayPal']")
	public WebElement paypalPaymentPageText;
	
	@FindBy(xpath ="//input[@class='__PrivateStripeElement-input']")
	public WebElement creditCardNumberFieldAlongWithCVV;
	
	@FindBy(xpath="//label[contains(text(),'Card holder')]")
	public WebElement cardHolderNameField;
	
	@FindBy(xpath="//section[@id='login']//a[@id='cancelLink']")
	public WebElement paypalPaymentCancel;
	
	@FindBy(xpath="//div[@class='vx-col w-full']")
	public WebElement errorMessageOncancelPaypalPayment;
	
	@FindBy(xpath="//h2[contains(.,'unsuccessful')]")
	public WebElement paymentUnsuccessfulToast;
	
	public SignUpAccountsCheckoutTradusProPage (RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
