package com.tradus.pro.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userName;

public class OverviewTradusPROPage {
	public RemoteWebDriver driver= null;
	
	@FindBy(xpath = "//div[@slot='header'] //img[@alt='Tradus']")
	public WebElement tradusProLogo;
	
	@FindBy(xpath = "//div[@slot='header']//span[@id='btnSidebarToggler'][1]")
	public WebElement togglerUnderLogo;
	
	@FindBy(xpath = "//div[@class='vs-sidebar--item']//span[text()='Overview']")
	public WebElement overviewLinkOnSideBar;
	
	@FindBy(xpath = "//div[@class='vs-sidebar--item']//a[@class='router-link-exact-active router-link-active']")
	public WebElement highlightedTab;
	
	@FindBy(xpath = "//a[@href='/lms/leads']")
	public WebElement leadsLink;
	
	@FindBy(xpath = "(//span[@class='flex items-center w-full'])[1]")
	public WebElement myStockLink;
	
	@FindBy(xpath = "//div[@class='vs-sidebar--item']//a[@href='/lms/profile']")
	public WebElement profileLinkOnSideBar;
	
	@FindBy(xpath = "//a[@href='/lms/monthly-package']")
	public WebElement monthlyPackageLink;
	
	@FindBy(xpath = "(//span[@class='flex items-center w-full'])[2]")
	public WebElement contactLink;
	
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
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='leads']")
	public WebElement leadsInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='myStock']")
	public WebElement myStockInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='addStock']")
	public WebElement addStockInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[text()='profile']")
	public WebElement profileInStartIconSuggestionList;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//ul//li")
	public List<WebElement> startIconSuggestionLists;
	
	@FindBy(xpath = "//div[@class='bookmark-container']//span[@class='feather-icon select-none relative']")
	public WebElement starIconsOnSuggestions;
	
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
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms']")
	public WebElement overviewOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/leads']")
	public WebElement leadsOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/parent::div")
	public WebElement myStockOptioninSiderBar;
	
	//To ask about this approach
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/ancestor::div[contains(@class,'sidebar-group-open')]//span[contains(.,'Create')]")
	public WebElement createMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'My stock')]/ancestor::div[8]//span[contains(.,'All')]")
	public WebElement allMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Market Insights')]/parent::a")
	public WebElement marketInsightOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Profile')]/parent::a")
	public WebElement profileOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[contains(.,'Subscription details')]/parent::div")
	public WebElement subscriptionDetailsinSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/subscription-details']")
	public WebElement monthlyPackageOptioninSiderBar;
	
	/*@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='Monthly package']/parent::div")
	public WebElement monthlyPackageOptioninSiderBar;*/
	
	/*
	 * @FindBy(xpath =
	 * "//section[contains(@class,'main-sidebar')]//a[@href='/lms/monthly-package']")
	 * public WebElement packageButtonunderMonthlyPackage;
	 */
	
	@FindBy(xpath = "//th[contains(.,'Due Date')]")
	public WebElement billingPageverificationElement;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/billing']")
	public WebElement billingButtonunderMonthlyPackage;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//a[@href='/lms/contracts']")
	public WebElement contactsLinkUnderSubscriptionDetails;
	
	@FindBy(xpath = "//th[contains(.,'Acceptance Date')]")
	public WebElement contactsLinkVerificationElement;
	
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
	
	@FindBy(xpath = "//h1[text()=' New Terms of Use']")
	public WebElement termsPageVerificationElement;

	@FindBy(xpath = "//h1[text()='How can we help you?']")
	public WebElement privacyPolicayPageVerificationElement;
	
	@FindBy(xpath = "//h1[text()='Help us help you faster!']")
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
	
	@FindBy(xpath = "//h3[contains(.,'Dionex 32')]/ancestor::div[@class='p-4 sm:p-6']")
	public WebElement activeAdinStockListing;
	
	@FindBy(xpath = "//h4[contains(.,'Popular ads')]/ancestor::div[@class='vx-card']//td[contains(.,'DIONEX 32')]")
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
	
	public OverviewTradusPROPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loadUrl(driver,"https://pro.tradus.com/lms");
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
	}


}
