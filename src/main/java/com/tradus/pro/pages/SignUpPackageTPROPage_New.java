package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.actionClick1;
import static com.tradus.core.ActionElementClass.waitTill;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPackageTPROPage_New {
	
	RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//*[@alt='Tradus']")
	public WebElement TRProLogo;
	
	@FindBy(xpath = "//h2[contains(.,'The benefits of selling on Tradus PRO')]/parent::div")
	public WebElement benifitsSection;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']")
	public WebElement languageText;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']/parent::span")
	public WebElement languageDropdown;
	
	@FindBy(xpath = "//div[@class='bg-white py-6']//button[contains(.,'Get support')]")
	public WebElement getSupportButton;
	
	@FindBy(xpath = "//div[@class='bg-white py-6']//a[contains(.,'Log in')]")
	public WebElement loginLink;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]")
	public WebElement supportSectionVerificationElement;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//div[@class='flex mb-8']")
	public WebElement contactSectioninSupportSlider;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/following-sibling::button")
	public WebElement supportSectionCloseButton;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//div[@class='flex']")
	public WebElement emailSectioninSupportSlider;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']")
	public WebElement tabInfo;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']/parent::div/following-sibling::span")
	public WebElement tabName;
	
	@FindBy(xpath = "//h4[contains(.,'1. Please select your plan')]")
	public WebElement packagePageVerificationElement;
	
	@FindBy(xpath = "//button[contains(.,'For businesses')]")
	public WebElement forBusinessButton;
	
	@FindBy(xpath = "//button[contains(.,'For individuals')]")
	public WebElement forIndivisualsButton;
	
	/*@FindBy(xpath = "//p[contains(.,'per month')]/ancestor::div[contains(@class,'vx-col w-full')]")
	public List<WebElement> packageTiles;*/
	
	@FindBy(xpath = "//p[contains(.,'per month')]/ancestor::div[contains(@class,'w-full flex items-stretch')]")
	public List<WebElement> packageTiles;
	
	@FindBy(xpath = "//p[contains(.,'per month')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[text()=' * Prices excluding VAT ']")
	public List<WebElement> exculdingVatText;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	public WebElement nextButton;
	
	@FindBy(xpath = "//p[contains(.,'per month')]/ancestor::div[contains(@class,'vx-col w-full')]//a[contains(.,'CONTACT SALES')]")
	public WebElement contactSales;
	
	@FindBy(xpath = "//p[contains(.,'per month')]/ancestor::div[contains(@class,'vx-col w-full')]")
	public WebElement contactSalesTile;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='name']")
	public WebElement FullNameInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='email']")
	public WebElement EmailInputFieldInSupportForm;
	
	@FindBy(xpath= "(//div[@class='p-8']//input[@name='companyName'])[1]")
	public WebElement companyNameInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='phone']")
	public WebElement PhoneInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//span[contains(.,'Send request')]")
	public WebElement SubmitButtonInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//p[contains(text(), 'message has been successfully sent.')]")
	public WebElement SuccessmessageofSupportForm;
	
	@FindBy(xpath= "//h2[contains(.,'The smart way to')]")
	public WebElement landingPageVerificationElement;
	
	@FindBy(xpath ="//div[contains(@class,'vs-dropdown--custom')]//li")
	public List<WebElement> languageDropdownOptionsList;
	
	@FindBy(xpath ="//span[contains(.,'1 listing')]")
	public WebElement indivisualPackageVerificationElement;                          
	
	@FindBy(xpath ="//div[.='How many ads will you post per month?']/../parent::div/following::div//span[.='Tradus Basic']")
	public WebElement businessPackageVerificationElement;                            
	
	@FindBy(xpath ="//span[contains(.,'Tradus Basic')]/ancestor::div[contains(@class,'w-full flex items-stretch')]/div[1]")
	public WebElement tradusBasicPackage;
	
	@FindBy(xpath ="//span[contains(.,'Tradus Premium')]/ancestor::div[contains(@class,'w-full flex items-stretch')]")
	public WebElement  tradusPremiumPackage;
	
	/*@FindBy(xpath ="//span[contains(.,'70 listings')]/ancestor::div[contains(@class,'vx-col w-full')]")
	public WebElement seventyAdsPackage;*/
	
	@FindBy(xpath ="//h4[.='Log in']")
	public WebElement loginPageVerificationElement;
	
	@FindBy(xpath = "//h4[contains(.,'2. Create an account')]")
	public WebElement accountsPageVerificationElement;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Basic')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//li")
	public List<WebElement> basicPackageHighlights;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Premium')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//li")
	public List<WebElement> premiumPackageHighlights;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Basic')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//select")
	public WebElement ListingDropdowninBasicPackage;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Premium')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//select")
	public WebElement ListingDropdowninPremiumPackage;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Basic')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//p[contains(@class,'text-5xl')]")
	public WebElement basicPackagePriceText;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Basic')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//p[@class='mt-4']")
	public WebElement basicPackagePriceperMonth;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Premium')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//p[contains(@class,'text-5xl')]")
	public WebElement premiumPackagePriceText;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Premium')]/ancestor::div[contains(@class,'w-full flex items-stretch')]//div[@class='w-full']//p[@class='mt-4']")
	public WebElement premiumPackagePriceperMonth;
	
	@FindBy(xpath = "//div[.='How many ads will you post per month?']/../parent::div//div[@class='grid mt-1']//div")
	public List<WebElement> numberOfListingInListingBar;

	@FindBy(xpath = "//div[.='How many ads will you post per month?']/../parent::div")
	public WebElement listingBarinPackagePage;
	
	@FindBy(xpath = "//div[.='How many ads will you post per month?']/following-sibling::input")
	public WebElement packageSlider;

	@FindBy(xpath = "//span[contains(.,'Tradus Basic')]/following-sibling::span")
	public WebElement numberOfListinginBasicPackage;
	
	@FindBy(xpath = "//span[contains(.,'Tradus Premium')]/following-sibling::span")
	public WebElement numberOfListinginPremiumPackage;
	
	public SignUpPackageTPROPage_New(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver,"https://pro.tradus.com/signup");
		explicitWaitFortheElementTobeVisible(driver,packagePageVerificationElement);
		
	}
}
