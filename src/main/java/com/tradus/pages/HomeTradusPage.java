package com.tradus.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;

public class HomeTradusPage {
	
	public RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//p[contains(.,'using cookies and similar technologies')]")
	public WebElement cookiesInfo_tradus_xpath;
	
	@FindBy(xpath = "//p[contains(.,'using cookies and similar technologies')]//a[contains(.,'Learn more')]")
	public WebElement link_learnMoreinCookiesInfo_xpath;
	
	@FindBy(xpath = "//span[contains(.,'Transport')]//parent::div")
	public WebElement element_homePageVerify_xpath;
	
	@FindBy(xpath = "//a[@class='app-header-bar__logo']")
	public WebElement logo_tradus_xpath;
	
	@FindBy(xpath = "//header[@class='app-header']//input[@id='search-form-query']")
	public  WebElement input_searchField_xpath;
			
    @FindBy(xpath = "(//header[@class='app-header']//select[@name='language_select'])[1]")
	public WebElement dropdown_languageOptions_xpath;
    
    @FindBy(xpath = "(//header[@class='app-header']//select[@name='currency_select'])[1]")
    public  WebElement dropdown_currency_xpath;
    
    @FindBy(xpath = "//header[@class='app-header']//a[contains(.,'Login / Register')]")
    public  WebElement link_loginTradus_xpath;
    
    @FindBy(xpath = "(//header[@class='app-header']//a[contains(.,'Sell on Tradus')])[1]")
    public  WebElement link_sellOnTradus_xpath;
  
    @FindBy(xpath = "//header[@class='app-header']//button[@id='search-button']")
    public WebElement button_searchIcon_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']")
    public WebElement section_OfferOfTheDay_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'quick-search__nav-item')]")
    public  List<WebElement> icon_L1Categories_xpath;
    
    @FindBy(xpath = "//span[.='Category']/ancestor::div[@class='quick-search__field']//select")
    public  List<WebElement> dropDown_L2Categories_xpath;
    
    @FindBy(xpath = "//span[.='Make']/ancestor::div[@class='quick-search__field']//select")
    public  List<WebElement> dropDown_Make_xpath;
    
    @FindBy(xpath = "//span[.='Model']/ancestor::div[@class='quick-search__field']//select")
    public List<WebElement> dropDown_Model_xpath;
    
    @FindBy(xpath = "//span[.='Year from']/ancestor::div[@class='quick-search__field']//select")
    public List<WebElement> dropDown_YearFrom_xpath;
    
    @FindBy(xpath = "//span[contains(.,'Price up to')]/ancestor::div[@class='quick-search__field']//select")
    public List<WebElement> dropDown_Price_xpath;
    
    @FindBy(xpath = "//span[contains(.,'Mileage')]/ancestor::div[@class='quick-search__field']//select")
    public  WebElement dropDown_Mileage_xpath;
    
    @FindBy(xpath = "//span[contains(.,'Weight')]/ancestor::div[@class='quick-search__field']//select")
    public List<WebElement> dropDown_Weight_xpath;
    
    @FindBy(xpath = "//label[contains(.,'Country')]/ancestor::div[@class='quick-search__field']")
    public List<WebElement> dropDown_Country_xpath;
    
    @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]")
    public List<WebElement> field_Country_xpath;
    
    @FindBy(xpath = "//a[contains(.,'Detailed search')]")
    public List<WebElement> link_detailedSearch_xpath;
    
    @FindBy(xpath = "//a[contains(@class,'quick-search__cta--button')]")
    public List<WebElement> button_searchResult_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//a[contains(.,'View offer')]")
    public List<WebElement> link_viewOfferinOfferoftheDay_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers')]/following-sibling::a//span[contains(.,'See all')]")
    public List<WebElement> link_SeeAllLinkwithFeatureOffer_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Check our sellers')]/following-sibling::span[contains(.,'See all')]//parent::a")
    public List<WebElement> link_checkOutourSeller_xpath;
  
    @FindBy(xpath = "//div[contains(@class,'category-list--footer')]//a[contains(@class,'category-list__title')]")
    public List<WebElement> link_categoryLinksinBottom_xpath;
    
    @FindBy(xpath = "//a[.='Transport:']/parent::div//li//a")
    public List<WebElement> link_L2CategoriesUnderTransport_xpath;
    
    @FindBy(xpath = "//a[.='Transport:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForTransport_xpath;
    
    @FindBy(xpath = "//a[.='Farm:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForFarm_xpath;
    
    @FindBy(xpath = "//a[.='Construction:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForConstruction_xpath;
    
    @FindBy(xpath = "//a[.='Material handling:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForMH_xpath;
  
    @FindBy(xpath = "//a[.='Top Manufacturers:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForTopManufacture_xpath;
    
    @FindBy(xpath = "//a[.='Countries:']/parent::div//span[contains(@class,'category-list__show-more')]")
    public WebElement link_showMoreLinkForCountries_xpath;
  
    
    @FindBy(xpath = "//a[.='Farm:']/parent::div//li//a")
    public List<WebElement> link_L2CategoriesUnderFarm_xpath;
    
    @FindBy(xpath = "//a[.='Construction:']/parent::div//li//a")
    public List<WebElement> link_L2CategoriesUnderConstruction_xpath;
    
    @FindBy(xpath = "//a[.='Material handling:']/parent::div//li//a")
    public List<WebElement> link_L2CategoriesUnderMaterialHandling_xpath;
    
    @FindBy(xpath = "//a[.='Top Manufacturers:']/parent::div//li//a")
    public List<WebElement> link_topManufacturersList_xpath;
    
    @FindBy(xpath = "//a[.='Countries:']/parent::div//li//a")
    public List<WebElement> link_countriesList_xpath;
    
    @FindBy(xpath = "//a[contains(.,'Back to top')]")
    public List<WebElement> link_backToTop_xpath;
    
    @FindBy(xpath = "//ul[contains(@class,'app-footer__list')]/parent::nav//li//a")
    public List<WebElement> link_bottomLinks_xpath;
  
    @FindBy(xpath = "//h3[.='Download the Tradus app']/following-sibling::a//span[contains(@class,'footer__store-icon')]")
    public List<WebElement> link_storeLinks_xpath;
    
    @FindBy(xpath = "//div[@class='app-footer__social']//a")
    public List<WebElement> link_socialSites_xpath;
    
    @FindBy(xpath = "//h1[contains(.,'New Policy on Cookies and Similar Technologies')]")
    public WebElement header_CookiesPage_xpath;
  
    @FindBy(xpath = "//button[contains(@class,'autocomplete__clear-button')]")
    public WebElement button_searchBoxClear_xpath;
    
    @FindBy(xpath = "//ul[@class='autocomplete__options ']//li")
    public List<WebElement> list_autoCompleteSuggestion_xpath;
    
    @FindBy(xpath = "//div[@class='offer-result__name']")
    public List<WebElement> div_AdTitlesinResults_xpath;
    
    @FindBy(xpath = "//div[@class='offer-result__name']//h3//a")
    public List<WebElement> div_AdHeadinginResults_xpath;
    
    @FindBy(xpath = "//span[text()='Sort by']/parent::span")
    public WebElement span_listingPageVerify_xpath;
  
    @FindBy(xpath = "//h1[text()='About us']")
    public WebElement header_aboutUsPageVerify_xpath;
    
    @FindBy(xpath = "//p[.='Tradus - Terms of Use']")
    public WebElement header_TermsPageVerify_xpath;
  
    @FindBy(xpath = "//h2[.='The Tradus Blog']")
    public WebElement header_blogPageVerify_xpath;
  
    @FindBy(xpath = "//p[.='Tradus-Privacy Statement']")
    public WebElement header_PrivacyPageVerify_xpath;
    
    @FindBy(xpath = "//h1[.='How can we help you?']")
    public WebElement header_HelpPageVerify_xpath;
    
    @FindBy(xpath = "//h2[.='The benefits of selling on Tradus PRO']")
    public WebElement header_SellingOnTradusPageVerify_xpath;
    
    @FindBy(xpath = "//p[.='Policy on Cookies and Similar Technologies ']")
    public WebElement header_CookiesPolicyPageVerify_xpath;
    
    @FindBy(xpath = "//div[@class='sIskre']//span[text()='Tradus - Heavy Machinery Marketplace']")
    public WebElement header_PlayStoreVerify_xpath;
                     
    @FindBy(xpath = "//header[contains(@class,'product-header app-header')]//h1[contains(.,'Tradus - Heavy Machinery')]")
    public WebElement header_AppStoreVerify_xpath;
    
    @FindBy(xpath = "//p[@class='app-header-bar__title']//img[@alt='Otomoto Profi']")
    public WebElement logo_OtomotoProfi_xpath;
    
    @FindBy(xpath = "//a[contains(.,'Switch to English')]")
    public WebElement link_switchToEnglish_xpath;
    
    @FindBy(xpath = "(//select[@name='quick-search-make'])[1]")
    public WebElement make;
    
    @FindBy(xpath = "//nav[@class='login-form__tabs']//a[contains(text(),'Login')]")
    public WebElement tab_LoginPageVerify_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'detailed-search__group')]//h2[text()='General']")
    public WebElement div_DetailsSearchPageVerify_xpath;
    
    @FindBy(xpath = "//ul[contains(@class,'detailed-search__breadcrumbs')]")
    public WebElement ul_CategoryNameinDetailedSearch_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//div[text()='Offer of the day']")
    public List<WebElement> div_offerOfTheDayinTag_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//a//h3[@class='offer-of-the-day__title']")
    public List<WebElement> title_offerOfTheDay_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//h4[contains(@class,'offer-of-the-day__category')]")
    public List<WebElement> h4_CategoryinOfferOfTheDay_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//div[contains(@class,'offer-of-the-day__company')]//a")
    public List<WebElement> h4_DealerNameinOfferOfTheDay_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//div[contains(@class,'offer-of-the-day__company')]//div[@class='offer-of-the-day__location']")
    public List<WebElement> h4_DealerLocationinOfferOfTheDay_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//span[@class='offer-of-the-day__price']")
    public List<WebElement> h4_AdPriceinOfferOfTheDay_xpath;
    
    @FindBy(xpath = "//div[@class='quick-search__offer column column-md-2']//img")
    public List<WebElement> img_AdImageOfferinOfferOfTheDay_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Transport')]/parent::div//article")
    public List<WebElement> article_FeaturedOfferForTransport_xpath;
  
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Farm')]/parent::div//article")
    public List<WebElement> article_FeaturedOfferForFarm_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Construction')]/parent::div//article")
    public List<WebElement> article_FeaturedOfferForConstruction_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Material handling')]/parent::div//article")
    public List<WebElement> article_FeaturedOfferForMT_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Transport')]/parent::div//article//h3[@class='offer-card__title link']")
    public List<WebElement> title_FeaturedOffersForTransport_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Farm')]/parent::div//article//h3[@class='offer-card__title link']")
    public List<WebElement> title_FeaturedOffersForFarm_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Construction')]/parent::div//article//h3[@class='offer-card__title link']")
    public List<WebElement> title_FeaturedOffersForConstruction_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Material handling')]/parent::div//article//h3[@class='offer-card__title link']")
    public List<WebElement> title_FeaturedOffersForMT_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Farm')]/parent::div//article//span[@class='offer-card__price']")
    public List<WebElement> price_FeaturedOffersForFarm_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Transport')]/parent::div//article//span[@class='offer-card__price']")
    public List<WebElement> price_FeaturedOffersForTransport_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Construction')]/parent::div//article//span[@class='offer-card__price']")
    public List<WebElement> price_FeaturedOffersForConstruction_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Featured offers in Material handling')]/parent::div//article//span[@class='offer-card__price']")
    public List<WebElement> price_FeaturedOffersForMT_xpath;
    
    @FindBy(xpath = "//nav[@class='breadcrumb']//li[2]")
    public WebElement li_categoryInSellerPage_xpath;
    
    @FindBy(xpath = "(//h2[contains(.,'Check our sellers')]//ancestor::div[@class='home__popular-seller-container']//ul)[1]//li//img")
    public List<WebElement> li_proSellerListforTransport_xpath;
    
    @FindBy(xpath = "(//h2[contains(.,'Check our sellers')]//ancestor::div[@class='home__popular-seller-container']//ul)[2]//li//img")
    public List<WebElement> li_proSellerListforFarm_xpath;
    
    @FindBy(xpath = "(//h2[contains(.,'Check our sellers')]//ancestor::div[@class='home__popular-seller-container']//ul)[3]//li//img")
    public List<WebElement> li_proSellerListforConstruction_xpath;
    
    @FindBy(xpath = "(//h2[contains(.,'Check our sellers')]//ancestor::div[@class='home__popular-seller-container']//ul)[4]//li//img")
    public List<WebElement> li_proSellerListforMaterialhandling_xpath;
    
    @FindBy(xpath ="//h1[@class='h4 search-seller__company-title']")
    public WebElement header_sellerTitle_xpath;
    
    @FindBy(xpath ="//nav[@class='breadcrumb']//a[contains(.,'Sellers Catalog')]")
    public WebElement link_sellerPageVerify_xpath;
   
    @FindBy(xpath ="//div[@class='grid__content']//h2[contains(.,'Choose a category')]")
    public WebElement header_chooseCategoryHeaderinSellerCatlog_xpath;
    
    @FindBy(xpath ="//div[contains(@class,'panel__content seller-filters')]//h3[.='Category']//parent::section//a")
    public WebElement text_selectedCategoryInSellerList_xpath;
    
    @FindBy(xpath ="//article[@class='seller-result']//div[@class='seller-result__details']")
    public List<WebElement> sellerTilesInSellerListing_xpath;
    
    @FindBy(xpath ="//div[@class='grid__content']//h2[contains(@class,'category-picker__title')]")
    public WebElement title_categoryInSellerCatelog_xpath;
    
    @FindBy(xpath ="//article[@class='seller-result']//div[@class='seller-result__details']//div[contains(@class,'seller-result__title')]//a")
    public List<WebElement> title_sellerNameinSellerListing_xpath;
    
    @FindBy(xpath = "//a[@class='back-to-top__link']")
    public WebElement link_BackToTop_xpath;
    
    @FindBy(xpath = "//div[@class='app-footer__columns']//img[@alt='Tradus']")
    public WebElement logo_BottomHomePage_xpath;
    
    @FindBy(xpath = "//div[@class='app-footer__columns']//img[@alt='Tradus']/following-sibling::p")
    public WebElement tagLine_Tradus_xpath;
    
    @FindBy(xpath = "//div[@class='app-footer__bottom']//p")
    public WebElement para_TradusCopyRight_xpath;
    
    @FindBy(xpath = "//*[contains(.,'TRADUS Epic Challenges:')]/parent::h1[contains(@class,'title style-scope ytd-video-primary')]")
    public WebElement title_YouTubePageVerify_xpath;
    
    @FindBy(xpath = "//h2[.='traduscom']/parent::div")
    public WebElement title_InstagramPageVerify_xpath;
    
    @FindBy(xpath = "(//div[@class='fb_content clearfix ']//span[.='Tradus']/parent::a)[1]")
    public WebElement title_FBPageVerify_xpath;
    
    @FindBy(xpath = "//h1[contains(.,'Tradus')]/parent::div[@class='top-card-layout__entity-info']")
    public WebElement title_LinkedInPageVerify_xpath;
  
    @FindBy(xpath = "//h2[.='Recently viewed ads']/parent::div")
    public WebElement div_recentlyViewedAds_xpath;
    
    @FindBy(xpath = "//h2[.='Recently viewed ads']/parent::div//article")
    public List<WebElement> adTiles_recentlyViewed_xpath;
    
    @FindBy(xpath = "//input[@id='username_login']")
	 public WebElement tradusUidInLoginPage;
	 
	 @FindBy(xpath = "//input[@id='password_login']")
	 public WebElement tradusPWDInLoginPage;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login')])[1]")
	 public WebElement tradusLoginButton;
	 
	 @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]/following-sibling::div//input")
	 public List<WebElement> input_SearchBoxUnderCountryDropdown_xpath;
	 
	 //after country got selected, corresponding value class name changes 
	 @FindBy(xpath = "//div[@class='ss-content ss-open']//div[contains(@class,'ss-option')]")
	 public List<WebElement> div_listOfCountries_xpath;
	 
	 @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]//span[contains(@class,'ss-plus')]")
	 public List<WebElement> icon_addIconInCountryDropdown_xpath;
	 
	 @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]//span[contains(@class,'ss-value-delete')]")
	 public List<WebElement> icon_deleteIconNearSelectedCountry_xpath;
	 
	 @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]//span[contains(@class,'ss-value-text')]")
	 public List<WebElement> span_SelectedCountry_xpath;
	 
	 @FindBy(xpath = "//span[contains(@class,'ss-plus')]/ancestor::div[contains(@class,'ss-multi-selected')]//span[contains(@class,'ss-disabled')]")
	 public List<WebElement> span_emptyCountryDropdown_xpath;
	 
	 @FindBy(xpath = "//h2[.='Recently viewed ads']/parent::div//article//span[@class='offer-card__price']")
	 public List<WebElement> span_priceInRecentlyViewedAds_xpath;
	 
	 @FindBy(xpath = "//span[contains(.,'Price up to')]//span")
	 public List<WebElement> span_unitNearPriceFilter_xpath;
	 
	 @FindBy(xpath = "//a[@id='user-menu-label']")
	 public WebElement lable_UserMenu_xpath;
	
	 @FindBy(xpath = "//a[@id='user-menu-label']/../following-sibling::ul//li//a[@class='favorites-count']//span[contains(@class,'counter')]")
	 public WebElement span_CountOfFavoriteAdsunderUserMenu_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[@href='/account/#tab-favorites']")
	 public WebElement link_FavoriteAdsPage_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[.='Sign out']")
	 public WebElement link_SignOut_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[contains(.,'My saved searches')]")
	 public WebElement link_FavoriteSearchFromUserMenu_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[contains(.,'My Account')]")
	 public WebElement link_MyAccountFromUserMenu_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//li//a[@href='/account/#tab-savedalerts']")
	 public WebElement link_myAlertPage_xpath;
	 
	 @FindBy(xpath = "//a[@id='user-menu-label']/../following-sibling::ul//li//a[@class='alerts-count']//span[contains(@class,'counter')]")
	 public WebElement span_CountOfAlertsunderUserMenu_xpath;
	
    public HomeTradusPage(RemoteWebDriver driver) throws Exception {
    	this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://www.tradus.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void doLogOut() throws Exception {
    	explicitWaitFortheElementTobeVisible(driver, lable_UserMenu_xpath);
    	try{
    		click(lable_UserMenu_xpath);
    	}catch(Exception E) {
    		jsClick(driver,lable_UserMenu_xpath);
    	}
    	explicitWaitFortheElementTobeVisible(driver, link_SignOut_xpath);
    	try{
    		click(link_SignOut_xpath);
    	}catch(Exception E) {
    		jsClick(driver,link_SignOut_xpath);
    	}
    	waitTill(1000);
    }
}
