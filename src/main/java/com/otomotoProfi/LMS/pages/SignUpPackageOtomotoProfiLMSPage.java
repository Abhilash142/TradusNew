package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPackageOtomotoProfiLMSPage {
	
	RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//*[@alt='Otomotoprofi']")
	public WebElement TRProLogo;
	
	@FindBy(xpath = "//h2[contains(.,'Benefits of selling on OTOMOTO Profi')]/parent::div")
	public WebElement benifitsSection;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']")
	public WebElement languageText;
	
	@FindBy(xpath = "//span[@class='hidden sm:block ml-2']/parent::span")
	public WebElement languageDropdown;
	
	@FindBy(xpath = "//div[@class='bg-white py-6']//a[contains(.,'Log in')]")
	public WebElement loginLink;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']")
	public WebElement tabInfo;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']/parent::div/following-sibling::span")
	public WebElement tabName;
	
	@FindBy(xpath = "//h4[contains(.,'1. Please choose the package')]")
	public WebElement packagePageVerificationElement;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]")
	public WebElement starterPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]")
	public WebElement smartPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]")
	public WebElement plusPackage;
	
	@FindBy(xpath = "//div[contains(@class,'flex w-full flex-wrap')]//h5[contains(.,'Prices exclude VAT')]")
	public WebElement priceExcludingVATtext;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//select")
	public WebElement ListingDropdowninStarterPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//select")
	public WebElement ListingDropdowninSmartPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//select")
	public WebElement ListingDropdowninPlusPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[contains(@class,'tooltip')]")
	public List<WebElement> toolTipsinSmartPackage;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[contains(@class,'tooltip')]")
	public List<WebElement> toolTipsinStarterPackage;
	
	@FindBy(xpath = "//div[@class='vs-tooltip vs-tooltip-right vs-tooltip-null' and  contains(@style,'transition-delay: 0.3s')]")
	public WebElement toolTipsContent;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'text-3xl')]")
	public WebElement smartPackagePriceText;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'text-3xl')]")
	public WebElement starterPackagePriceText;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'text-3xl')]")
	public WebElement plusPackagePriceText;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'-mt-1')]")
	public WebElement starterPackagePriceperListing;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'-mt-1')]")
	public WebElement smartPackagePriceperListing;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//div[contains(@class,'-mt-1')]")
	public WebElement PlusPackagePriceperListing;
	
	@FindBy(xpath = "(//div[@class='wizard-card-footer clearfix']//div[contains(@class,'right')])[1]//button")
	public WebElement nextButton;
	
	@FindBy(xpath = "//li[contains(.,'English')]")
	public WebElement englishOptioninLangDropdown;
	
	@FindBy(xpath = "//span[contains(.,'E-mail')]")
	public WebElement loginPageVerifcationElement;
		
	@FindBy(xpath = "//h4[contains(.,'1. Please choose the package')]//following-sibling::div//child::div[contains(@class,'vx-col w-full flex items')]")
	public List<WebElement> numberOfPackages;
	
	@FindBy(xpath = "//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//li")
	public List<WebElement> starterPackageHighlights;
	
	@FindBy(xpath = "//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//li")
	public List<WebElement> smartPackageHighlights;
	
	@FindBy(xpath = "//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//div[@class='mt-4 flex flex-col']//li")
	public List<WebElement> plusPackageHighlights;
	
	@FindBy(xpath = "//h4[contains(.,'2. Create an account')]")
	public WebElement accountsPageVerificationElement;
	
	@FindBy(xpath = "(//span[contains(.,'Profi Starter')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//child::div)[1]")
	public WebElement starterPackageBackground;
	
	@FindBy(xpath = "(//span[contains(.,'Profi Smart')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//child::div)[1]")
	public WebElement smartPackageBackground;
	
	@FindBy(xpath = "(//span[contains(.,'Profi Plus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]//child::div)[1]")
	public WebElement plusPackageBackground;
	
	public SignUpPackageOtomotoProfiLMSPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/signup");
		explicitWaitFortheElementTobeVisible(driver,languageDropdown);
		actionClick(driver,languageDropdown);
		waitTill(1000);
		actionClick(driver,englishOptioninLangDropdown);
		
	}
	public void gotoAccountsPage(RemoteWebDriver driver, String packageType) throws Exception {
		SignUpPackageOtomotoProfiLMSPage obj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,obj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,obj.smartPackage);
		//waitTill(2000);
		if(packageType.equalsIgnoreCase("Smart")) {
			explicitWaitFortheElementTobeVisible(driver,obj.smartPackage);
		  try {  click(obj.smartPackage);
		  }catch(Exception E) {
			  jsClick(driver,obj.smartPackage);
		  }
		    explicitWaitFortheElementTobeVisible(driver,obj.nextButton);
		    try {  click(obj.nextButton);
			  }catch(Exception E) {
				  jsClick(driver,obj.nextButton);
			  }
		}	
		
		else if(packageType.equalsIgnoreCase("Plus")) {
			explicitWaitFortheElementTobeVisible(driver,obj.plusPackage);
		    
		    try {
		    	click(obj.smartPackage);
		    }catch(Exception E) {
		    	jsClick(driver,obj.smartPackage);
		    }
		    explicitWaitFortheElementTobeVisible(driver,obj.nextButton);
		    try {  click(obj.nextButton);
			  }catch(Exception E) {
				  jsClick(driver,obj.nextButton);
			  }
		}
		else {
			explicitWaitFortheElementTobeVisible(driver,obj.starterPackage);
		    try {
		    	click(obj.starterPackage);
		    }catch(Exception E) {
		    	jsClick(driver,obj.starterPackage);
		    }
		    explicitWaitFortheElementTobeVisible(driver,obj.nextButton);
		    try {  click(obj.nextButton);
			  }catch(Exception E) {
				  jsClick(driver,obj.nextButton);
			  }
		}
	}
}
