package com.tradus.pro.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllStockTradusPROPage {
	RemoteWebDriver driver = null;
	 
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/parent::div")
	public WebElement myStockOptioninSiderBar;
	 
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/ancestor::div[8]//span[text()='All']")
	public WebElement allMyStockOptioninSiderBar;
	 
	@FindBy(xpath= "//h2[text()='My stock']")
	public WebElement MyStockText;
	
	@FindBy(xpath= "//h2[text()='My stock']/following-sibling::h3")
	public WebElement CountOfAllCategoryAds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//div[@class='p-4 sm:p-6']")
	public List<WebElement> PostedAds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//img[contains(@class, 'h-64 lg:h-48 w-full object-cover')]")
	public List<WebElement> PostedAdsImages;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//h3[contains(@class, 'text-2xl leading-6 font-medium')]")
	public List<WebElement> PostedAdsTitles;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//p[@class='text-md text-gray-600 mb-6']")
	public List<WebElement> PostedAdsCategoryTypeAndSubType;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//p[@class='text-lg text-gray-800 font-medium']")
	public List<WebElement> PostedAdsCurrencyAndPrices;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//span[@class='rounded-full bg-gray-200 py-1 px-3 mb-2']")
	public List<WebElement> PostedAdsAdIds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//span[@class='flex items-center mt-1']")
	public List<WebElement> PostedAdsTMV;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//span[text()='Visits:']/following-sibling::span")
	public List<WebElement> PostedAdsVisits;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//span[text()='Emails:']/following-sibling::span")
	public List<WebElement> PostedAdsEmails;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//span[text()='Active on:']/following-sibling::a")
	public List<WebElement> PostedAdsStatus;
	
	@FindBy(xpath= "//a[text()='Tradus']")
	public List<WebElement> TradusLinkOnPostedAds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//a[text()=' Edit ']")
	public List<WebElement> EditOptionOnPostedAds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//a[text()=' Delete ']")
	public List<WebElement> DeleteOptionOnPostedAds;
	
	@FindBy(xpath= "//h2[text()='My stock']/ancestor::div//button[text()=' Promote ']")
	public List<WebElement> PromoteOptionOnPostedAds;
	
	@FindBy(xpath= "//button[contains(.,'Filter')] ")
	public WebElement filterButtoninAllStocksPage;
	
	@FindBy(xpath= "//span[contains(.,'2987306')]")
	public WebElement firstStockVerificationElement;
	
	@FindBy(xpath= "//span[contains(.,'2986865')]")
	public WebElement secondStockVerificationElement;
	
	@FindBy(xpath= "//span[contains(.,'save')]/parent::button")
	public WebElement saveButtoninPostingForm;	
	
	@FindBy(xpath= "//h1[contains(@class,'header__title text')]")
	public WebElement makeandModelonTradusADP;	
	
	@FindBy(xpath= "//dt[.='Year']/parent::dl//span")
	public WebElement makeYearonTradusADP;
	
	@FindBy(xpath= "(//dt[.='Sellers Reference']/following-sibling::dd)[1]")
	public WebElement sellerRefNoonTradusADP;
	
	@FindBy(xpath= "//dt[contains(.,'VIN')]/following-sibling::dd")
	public WebElement vinNumberonTradusADP;

	/*@FindBy(xpath = "//h2[text()='My stock']")
	public WebElement MyStockText;*/

	@FindBy(xpath = "//h3[text()=' Volvo 8700 ']/parent::div/parent::div/following-sibling::div//a[text()=' Delete ']")
	public WebElement DeleteOptionOnSparePartsAd;

	@FindBy(xpath = "//h3[text()=' Volvo 8700 ']/parent::div//a[text()='Tradus']")
	public WebElement TradusLinkOnSparePartsAd;

	@FindBy(xpath = "//div[@class='vs-dialog']//span[text()='Yes']")
	public WebElement YesButtonOnAdDeletePopup;

	/*@FindBy(xpath = "//h2[text()='My stock']/ancestor::div//button[text()=' Promote ']")
	public List<WebElement> PromoteOptionOnPostedAds;*/

	@FindBy(xpath = "//h3[contains(text(), 'Volvo 8700')]")
	public WebElement SparePartsTestAd;

	@FindBy(xpath = "//h1[contains(text(), 'Volvo 8700')]")
	public WebElement SparePartsTestAdTitle;

	@FindBy(xpath = "//div[contains(@class,'vs-noti-success activeNoti')]")
	public WebElement successToastInAllStockPage;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/ancestor::div[contains(@class,'sidebar-group-open')]//span[text()='Create']")
	public WebElement createMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//span[contains(.,'2987306')]/ancestor::div[contains(@class,'overflow-hidden')]//a[contains(.,'Edit')]")
	public WebElement editButtonforMANtires;
	
	@FindBy(xpath = "//span[contains(.,'2987306')]/ancestor::div[contains(@class,'overflow-hidden')]//a[contains(.,'Tradus')]")
	public WebElement tradusLinkforMANtires;
	
	public AllStockTradusPROPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
