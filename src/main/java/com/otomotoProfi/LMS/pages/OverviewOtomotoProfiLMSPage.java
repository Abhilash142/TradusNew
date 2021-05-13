package com.otomotoProfi.LMS.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.otomotoProfi.LMS.pages.CommonMethod;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;


public class OverviewOtomotoProfiLMSPage {
	public RemoteWebDriver driver= null;
	
	@FindBy(xpath = "//div[@slot='header'] //img[@alt='Otomotoprofi'] ")
	public WebElement OTMPLMSLogo;
	
	@FindBy(xpath = "//div[@slot='header']//span[@id='btnSidebarToggler'][1]")
	public WebElement togglerUnderLogo;
	
	@FindBy(xpath = "//div[@class='vs-sidebar--item']//a[@class='router-link-exact-active router-link-active']")
	public WebElement highlightedTab;
	
	@FindBy(xpath = "//header[contains(@class,'vs-navbar')]//li[@class='starred-page']")
	public List<WebElement> headerIcons;
	
	@FindBy(css = "svg.feather.feather-bar-chart.h-6.w-6")
	public WebElement overviewIconOnHeaderSection;
	
	@FindBy(xpath = "svg.feather.feather-smile.h-6.w-6")
	public WebElement leadsIconOnHeaderSection;
	
	@FindBy(xpath = "svg.feather.feather-truck.h-6.w-6")
	public WebElement mystockIconOnHeaderSection;
	
	@FindBy(xpath = "svg.feather.feather-plus-square.h-6.w-6")
	public WebElement addstockIconOnHeaderSection;
	
	@FindBy(xpath = "svg.feather.feather-user.h-6.w-6")
	public WebElement profileIconOnHeaderSection;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='overview']")
	public WebElement overviewInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//ul//li")
	public List<WebElement> startIconSuggestionLists;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//ul//li//span[.='Leads']")
	public WebElement startIconSuggestionListVerify;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[@class='feather-icon select-none relative']")
	public List<WebElement> starIconsOnSuggestions;
	
	@FindBy(xpath = "(//span[@class='input-span-placeholder vs-input--placeholder normal'])[1]")
	public WebElement HeaderSearchField;
	
	//@FindBy(xpath = "//span[contains(text(),'active')]/parent::div/preceding-sibling::span[contains(@class,'text-primary')]")
	//public WebElement iconInActiveAdsCountSection;
	
	@FindBy(xpath = "//span[contains(text(),'available for publishing')]/parent::div/preceding-sibling::span[contains(@class,'text-primary')]")
	public WebElement iconInActiveAdsCountSection;
	
	/*@FindBy(xpath = "//span[contains(text(),'active')]/parent::div/h2")
	public WebElement totalActiveAdsCount;*/
	
	@FindBy(xpath = "//span[contains(text(),'available for publishing')]/parent::div/h2")
	public WebElement totalActiveAdsCount;
	
	@FindBy(xpath = "//span[contains(text(),'visits')]/parent::div/preceding-sibling::span[contains(@class,'text-success')]")
	public WebElement iconInVisitesCountSection;
	
	@FindBy(xpath = "//span[contains(text(),'visits')]/parent::div/h2")
	public WebElement totalVisitsCount;
	
	@FindBy(xpath = "//span[contains(text(),'leads')]/parent::div/preceding-sibling::span[contains(@class,'text-warning')]")
	public WebElement iconInTotalLeadsCountSection;
	
	@FindBy(xpath = "//span[contains(text(),'leads')]/parent::div/h2")
	public WebElement totalLeadsCount;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='Leads']")
	public WebElement leadsInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='My stock']")
	public WebElement myStockInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='Add stock']")
	public WebElement addStockInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='Profile']")
	public WebElement profileInStartIconSuggestionList;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms']")
	public WebElement overviewOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/leads']")
	public WebElement leadsOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/parent::div")
	public WebElement myStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/ancestor::div[contains(@class,'sidebar-group-open')]//span[contains(.,'Create')]")
	public WebElement createMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/ancestor::div[8]//span[contains(.,'All')]")
	public WebElement allMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Market Insights')]/parent::a")
	public WebElement marketInsightOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Profile')]/parent::a")
	public WebElement profileOptioninSiderBar;
	
	/*@FindBy(xpath ="//section[contains(@class,'main-sidebar')]//span[text()='Monthly package']/parent::div") 
	 public WebElement monthlyPackageOptioninSiderBar;*/
	 
	 @FindBy(xpath ="//section[contains(@class,'main-sidebar')]//span[contains(.,'Subscription details')]/parent::div")
	 public WebElement monthlyPackageOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/subscription-details']")
	public WebElement packageButtonunderMonthlyPackage;
	
	@FindBy(xpath = "//th[contains(.,'Due Date')]")
	public WebElement billingPageverificationElement;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/billing']")
	public WebElement billingButtonunderMonthlyPackage;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Contact')]/parent::div")
	public WebElement contactOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Contact')]/ancestor::div[8]//span[contains(.,'Terms of Use')]")
	public WebElement termsOptionunderContactlinkSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Contact')]/ancestor::div[8]//span[contains(.,'Privacy Policy')]")
	public WebElement privacyOptionunderContactlinkSiderBar;
	
	@FindBy(xpath = "(//section[contains(@class,'main-sidebar')]//span[text()='Contact']/ancestor::div[8]//span[text()='Contact'])[3]")
	public WebElement contactOptionunderContactlinkSiderBar;
	
	@FindBy(xpath = "//h4[contains(text(),'Leads per country')]")
	public WebElement leadsPageVerificationElement;
	
	@FindBy(xpath = "(//span[text()='Post your ad ']/parent::button)[1]")
	public WebElement createStockPageVerificationElement;
	
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	public WebElement allStockPageVerificationElement;
	
	@FindBy(xpath = "//h2[contains(text(),'Most Popular Vehicles')]")
	public WebElement marketInsightpageVerificationElement;

	@FindBy(xpath = "//h2[contains(text(),'Profile')]")
	public WebElement profilePageVerificationElement;

	@FindBy(xpath = "//h2[contains(text(),'Subscription details')]")
	public WebElement monthlyPackagePageVerificationElement;
	
	@FindBy(xpath = "//h1[contains(.,' Aktualny Regulamin')]")
	public WebElement termsPageVerificationElement;

	@FindBy(xpath = "//h1[contains(.,'Polityka prywatności')]")
	public WebElement privacyPolicayPageVerificationElement;
	
	@FindBy(xpath = "//h1[contains(.,'Wyślij zlecenie')]")
	public WebElement conatctPageVerificationElement;

	@FindBy(xpath = "//header[contains(@class,'vs-navbar')]//li[@class='starred-page']")
	public List<WebElement> pageheaderIcons;
	
	@FindBy(xpath = "//header[contains(@class,'vs-navbar')]//div[@class='bookmark-container']")
	public WebElement startIconOnPageHeader;
	
	@FindBy(xpath ="//div[@class='bookmark-container']//input")
	public WebElement startIconSearchField;
	
	@FindBy(xpath ="//header[contains(@class,'vs-navbar')]//button[contains(@class,'locale-dropdown')]")
	public WebElement languageAtHeader;
	
	@FindBy(xpath ="//div[contains(@class,'vs-dropdown--custom')]//li")
	public List<WebElement> languageDropdownOptionsList;
	
	@FindBy(xpath ="//div[@class='vx-row']//span[contains(text(),'active')]")
	public WebElement totalActiveAdsText;
	
	@FindBy(xpath ="//div[@class='vx-row']//span[contains(text(),'available for publishing')]")
	public WebElement adsAvailabeforPublishingText;
	
	@FindBy(xpath ="//div[@class='vx-row']//span[contains(text(),'visit')]")
	public WebElement totalVisitsText;
	
	@FindBy(xpath ="//div[@class='vx-row']//span[contains(text(),'leads')]")
	public WebElement totalLeadsText;
	
	@FindBy(xpath ="(//div[@class='vx-row'])[2]//h4[contains(text(),'Popular ads')]")
	public WebElement popularAdsText;
	
    @FindBy(xpath="//h4[contains(text(),'Popular ads')]/ancestor::div[@class='vx-card']//tr//th")
    public List<WebElement> popularAdHeaders;
    
    @FindBy(xpath ="(//div[@class='vx-row'])[3]//h4[contains(text(),'Visits per country')]")
	public WebElement visitsPerCountryText;
    
    @FindBy(xpath ="//h4[contains(text(),'Visits per country')]/ancestor::div[@class='vx-card']//div[contains(@class,'loading__container')]")
	public WebElement visitsPerPageContent;
  
    @FindBy(xpath ="//h4[contains(text(),'Popular ads')]/ancestor::div[@class='vx-card']//div[contains(@class,'loading__container')]//div[contains(@class,'not-data')]")
	public WebElement noDataUnderpopularAds;
    
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//span[contains(@class, 'navbar-fuzzy-search')]")
	public WebElement SearchIconOnHeader;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//div[contains(@class, 'left-0 bottom-0 rounded-lg flex')]")
	public WebElement SearchFieldOnHeader;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//span[contains(@class, 'close-search-icon')]")
	public WebElement crossIconOnSearchField;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//div[contains(@class,'text-right leading-tight')]")
	public WebElement sellerNameonHeader;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//img[@alt='user-img']")
	public WebElement sellerLogoonHeader;
	
	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//button[contains(@class, 'parent-dropdown cursor-pointer')]")
	public WebElement profileIconOnHeader;
	
	@FindBy(xpath = "//div[contains(@class, 'vs-dropdown--menu')]//li[1]")
	public WebElement profileOptionInProfileIconDropdown;
	
	@FindBy(xpath = "//div[contains(@class, 'vs-dropdown--menu')]//li[2]")
	public WebElement logoutOptionInProfileIconDropdown;
	
	@FindBy(xpath = "//h4[contains(text(),'Popular ads')]")
	public WebElement overviewPageVerificationElement;
	
	@FindBy(xpath = "//h4[text()='Log in']")
	public WebElement LoginText;
	
	@FindBy(xpath = "//button[contains(@class,'parent-dropdown locale-dropdown')]")
	public WebElement languageDropdowninHeader ;
	
	@FindBy(xpath = "//a[contains(text(),'English')]")
	public WebElement EnglishOptionFromHeader ;
	
	
	@FindBy(xpath = "//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']//td[contains(.,'SCANIA G-SERIES')]")
	public WebElement activeAdsunderPopularAds;
	
	@FindBy(xpath = "(//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']//td)[6]")
	public WebElement visitsCountunderPopularAds;
	
	@FindBy(xpath = "(//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']//td)[7]")
	public WebElement leadsCountunderPopularAds;
	
	@FindBy(xpath = "//div[@class='tradus welcome-box']")
	public WebElement TradusWelcomeBox;
	
	@FindBy(xpath = "//span[text()='Post your first Ad ']")
	public WebElement PostYourAdButtonOnWelcomePopup;
	
	@FindBy(xpath = "//a[contains(@class, 'wn-close absolute right-0 top-0')]")
	public WebElement CloseIconOnWelcomePopup;
	
	@FindBy(xpath ="//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']")
	 public WebElement popularAdssection;
	
	@FindBy(xpath = "//div[@class='pt-12 p-8']//input[@name='email']/following-sibling::span")
	public WebElement loginPageVerify;
	
	public  OverviewOtomotoProfiLMSPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
        loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms");
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
