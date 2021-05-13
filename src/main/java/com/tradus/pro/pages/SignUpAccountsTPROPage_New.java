package com.tradus.pro.pages;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.username;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpAccountsTPROPage_New {
	
	RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']")
	public WebElement tabInfo;
	
	@FindBy(xpath = "//h4[contains(.,'2. Create an account')]")
	public WebElement accountsPageVerificationElement;
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='email']")
	public WebElement emailField;
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='password']")
	public WebElement passWordField;
	
	@FindBy(xpath = "//input[@name='agreed']/ancestor::div[@class='mt-4']")
	public WebElement acceptacneCheckBoxSection;
	
	@FindBy(xpath = "//input[@name='agreed']")
	public WebElement agreeCheckBox;
	
	@FindBy(xpath = "//div[@class='wizard-card-footer clearfix']//div[contains(@class,'left')]")
	public WebElement backButton;
	
	@FindBy(xpath = "(//div[@class='wizard-card-footer clearfix']//div[contains(@class,'right')])[1]")
	public WebElement nextButton;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div")
	public WebElement monthlyCostSection;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Package']/parent::div//p")
	public WebElement numberOfAdsperPackageUnderMonthlyCost;
	
	/*@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Billing frequency']/parent::div//p")
	public WebElement billingFrequencyUnderMonthlyCost;*/
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()=' Billing frequency ']/parent::div//p")
	public WebElement billingFrequencyUnderMonthlyCost;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Price']/parent::div//p")
	public WebElement priceUnderMonthlyCost;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Package']/parent::div//a")
	public WebElement changePackageUnderMonthlyCost;
		
	@FindBy(xpath = "//input[@name='email']/../../..//div[contains(@class,'text-danger')]")
	public WebElement emailFieldDangerText;

	@FindBy(xpath = "//input[@name='password']/../../..//div[contains(@class,'text-danger')]")
	public WebElement passWordFieldDangerText;
	
	@FindBy(xpath = "//input[@name='agreed']/../../..//div[contains(@class,'text-danger')]")
	public WebElement agreeCheckBoxError;
	
	@FindBy(xpath = "//h1[contains(.,'New Terms of Use')]")
	public WebElement termsPageVerify;
	
	@FindBy(xpath = "//p[contains(.,'About Tradus')]")
	public WebElement privacyPageVerify;
	
	@FindBy(xpath = "//p[contains(.,'About Tradus')]")
	public WebElement cookiesPageVerify;
	
	@FindBy(xpath = "//input[@name='agreed']/../..//a")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[1]")
	public WebElement privacyLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[2]")
	public WebElement coockiesLink;
	
	@FindBy(xpath = "//h4[contains(.,'3. Account details')]")
	public WebElement detailsPageVerificationElement;
	
	@FindBy(xpath = "//input[@name='email']/../../..//div[contains(@class,'text-danger')]/a")
	public WebElement goToSignInPageErrorLinkOnEnteringRegisteredEmail;
	
	@FindBy(xpath = "//h4[text()='Log in']/..")
	public WebElement loginPageVerificationElement;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']")
	public WebElement languageText;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']/parent::span")
	public WebElement languageDropdown;
	
	@FindBy(xpath ="//div[contains(@class,'vs-dropdown--custom')]//li")
	public List<WebElement> languageDropdownOptionsList;
	
	@FindBy(xpath = "//div[@class='bg-white py-6']//button[contains(.,'Get support')]")
	public WebElement getSupportButton;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]")
	public WebElement supportSectionVerificationElement;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//div[@class='flex mb-8']")
	public WebElement contactSectioninSupportSlider;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/following-sibling::button")
	public WebElement supportSectionCloseButton;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//p[contains(.,'You can email us at')]/ancestor::div[contains(@class,'flex mb-8')]")
	public WebElement emailSectioninSupportSlider;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//p[contains(.,'chat with us')]/ancestor::div[contains(@class,'flex')]")
	public WebElement chatSectioninSupportSlider;
	
	@FindBy(xpath = "//h2[contains(.,'Need help?')]/ancestor::div[contains(@class,'text-white')]//p[contains(.,'chat with us')]/ancestor::div[contains(@class,'flex')]//a[.='here']")
	public WebElement chatLinkinSupportSlider;
	
	@FindBy(xpath = "//h1[text()='How can we help you?']")
	public WebElement chatPageVerificationElement;
	
	@FindBy(xpath = "//h2[contains(.,'The benefits of selling on Tradus PRO')]/parent::div")
	public WebElement benifitsSection;
	
	@FindBy(xpath = "//*[@alt='Tradus']")
	public WebElement TRProLogo;
	
	@FindBy(xpath= "//h2[contains(.,'The smart way to')]")
	public WebElement landingPageVerificationElement;
	
	@FindBy(xpath = "//div[@class='bg-white py-6']//a[contains(.,'Log in')]")
	public WebElement loginLink;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']/parent::div/following-sibling::span")
	public WebElement tabName;
	
	@FindBy(xpath = "//h4[contains(.,'1. Please select your plan')]")
	public WebElement packagePageVerificationElement;
	
    public SignUpAccountsTPROPage_New(RemoteWebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void gotoAccountsPage(RemoteWebDriver driver,String user) throws Exception {
        	SignUpPackageTPROPage_New obj=new SignUpPackageTPROPage_New(driver);
    		explicitWaitFortheElementTobeVisible(driver,obj.packagePageVerificationElement);
    		explicitWaitFortheElementTobeVisible(driver,obj.businessPackageVerificationElement);
    		
    		waitTill(1000);
    		if(user.equalsIgnoreCase("business")) {
    			try {
    				click(obj.tradusPremiumPackage);
    			}catch(Exception E) {
    				jsClick(driver,obj.tradusPremiumPackage);
    			}
    			waitTill(1000);
    			explicitWaitFortheElementTobeVisible(driver,obj.nextButton);
    			try{
    				click(obj.nextButton);
    			}catch(Exception E) {
    				jsClick(driver,obj.nextButton);
    			}
    		}
    		else {
    			explicitWaitFortheElementTobeVisible(driver,obj.forIndivisualsButton);
    			jsClick(driver,obj.forIndivisualsButton);
    			waitTill(1000);
    			explicitWaitFortheElementTobeVisible(driver,obj.tradusPremiumPackage);
    			explicitWaitFortheElementTobeVisible(driver,obj.nextButton);
    			try{
    				click(obj.nextButton);
    			}catch(Exception E) {
    				jsClick(driver,obj.nextButton);
    				//actionClick1(driver,obj.nextButton);
    			}
    		}	
    	}	
    }
