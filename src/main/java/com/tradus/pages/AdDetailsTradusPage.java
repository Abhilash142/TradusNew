package com.tradus.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdDetailsTradusPage {

	public RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//a[@class='app-header-bar__logo']")
	public WebElement logo_tradus_xpath;
	
	@FindBy(xpath = "//header[@class='app-header']//input[@id='search-form-query']")
	public  WebElement input_searchField_xpath;
			
    @FindBy(xpath = "(//header[@class='app-header']//select[@name='language_select'])[1]")
	public WebElement dropdown_languageOptions_xpath;
    
    @FindBy(xpath = "(//header[@class='app-header']//select[@name='currency_select'])[1]")
    public  WebElement dropdown_currency_xpath;
    
    @FindBy(xpath = "(//header[@class='app-header']//a[contains(.,'Login / Register')])[1]")
    public  WebElement link_loginTradus_xpath;
    
    @FindBy(xpath = "(//header[@class='app-header']//a[contains(.,'Sell on Tradus')])[1]")
    public  WebElement link_sellOnTradus_xpath;
  
    @FindBy(xpath = "//header[@class='app-header']//button[@id='search-button']")
    public WebElement button_searchIcon_xpath;
    
    @FindBy(xpath = "//h1[@class='offer-header__title text-600']")
    public WebElement title_AdDetails_xpath;
    
    @FindBy(xpath = "//section[contains(@class,'gallery')]//li//a")
	public List<WebElement> img_AdCoverPhoto_xpath;
    
    @FindBy(xpath = "//section[@class='gallery gallery--single-image']")
    public WebElement img_DefaultImage_xpath;
    
    @FindBy(xpath = "//span[@class='gallery__overlay-content']")
    public WebElement count_onLastImg_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//button[@title='Zoom in/out']")
    public WebElement btn_ZoomInandOutForImgViewPage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//button[@class='pswp__button pswp__button--arrow--left']")
    public WebElement btn_LeftArrowForImgViewPage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//button[@class='pswp__button pswp__button--arrow--right']")
    public WebElement btn_RightArrowForImgViewPage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//div[@class='pswp__counter']")
    public WebElement div_ImageCountforImgViewPage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//button[@class='pswp__button pswp__button--close']")
    public WebElement btn_CloseButtononImgViewPage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'pswp--open')]//button[@class='pswp__button pswp__button--fs']")
    public WebElement btn_fullScreenInImgViewPage_xpath;
    
    @FindBy(xpath = "(//nav[@class='breadcrumb']//li/a)[2]/span[@itemprop='name']")
    public WebElement link_MainCategoryinBreadcrumb_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[contains(.,'Make')]/following-sibling::dd[1]")
    public WebElement div_makeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Model']/following-sibling::dd[1]")
    public WebElement div_modelInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Condition']/following-sibling::dd[1]")
    public WebElement div_conditionInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Sellers Reference']/following-sibling::dd[1]")
    public WebElement div_sellerRefInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='First Registration Year']/following-sibling::dd[1]")
    public WebElement div_firstRegistartionYearInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='First Registration Month']/following-sibling::dd[1]")
    public WebElement div_firstRegistartionMonthInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Brakes Type']/following-sibling::dd[1]")
    public WebElement div_breakTypesInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Front Axle Brakes Type']/following-sibling::dd[1]")
    public WebElement div_frontAxleBreakTypesInAdDetails_xpath;
    
   /* @FindBy(xpath = "//div[@class='offer__details']//dt[.='Year']/following-sibling::dd[1]")
    public WebElement div_YearInAdDetails_xpath;*/
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Construction Year']/following-sibling::dd[1]")
    public WebElement div_YearInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Mileage']/following-sibling::dd[1]")
    public WebElement div_MileageInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Steering Wheel Side']/following-sibling::dd[1]")
    public WebElement div_SteeringSideInAdDetails_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Tradus ID']/following-sibling::dd[1]")
    public WebElement div_TradusIDInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Fuel Consumption Overall')]/following-sibling::dd[1]")
    public WebElement div_fuelConsumptionInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Body Type')]/following-sibling::dd[1]")
    public WebElement div_bodyTypeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Price Options')]/following-sibling::dd[1]")
    public WebElement div_priceOptionsInAdDetails_xpath;
    
  
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Second Axle Tire Size')]/following-sibling::dd[1]")
    public WebElement div_secondAxleTireSizeInAdDetails_xpath;
  
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Chassis Options')]/following-sibling::dd[1]")
    public WebElement div_chassisOptionsInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Tire Size')]/following-sibling::dd[1]")
    public WebElement div_tireSizeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Gross Weight')]/following-sibling::dd[1]")
    public WebElement div_grossWeightInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Technical specs')]//parent::section//dt[contains(.,'Net Weight')]/following-sibling::dd[1]")
    public WebElement div_netWeightInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Number Of Gears')]/following-sibling::dd[1]")
    public WebElement div_numberOfGearsInAdDetails_xpath;
  
    @FindBy(xpath = " //h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Transmission Make')]/following-sibling::dd[1]")
    public WebElement div_transmissionMakeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Engine Make')]/following-sibling::dd[1]")
    public WebElement div_engineMakeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Engine Type')]/following-sibling::dd[1]")
    public WebElement div_engineTypeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Number Of Fuel Tanks')]/following-sibling::dd[1]")
    public WebElement div_numberOfFuelTanksInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Fuel Tank Capacity')]/following-sibling::dd[1]")
    public WebElement div_FuelTankCapacityInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Transmission Model')]/following-sibling::dd[1]")
    public WebElement div_transmissionModelInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Engine Model')]/following-sibling::dd[1]")
    public WebElement div_engineModelInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[contains(.,'Emission Level')]/following-sibling::dd[1]")
    public WebElement div_emissionLevelInAdDetails_xpath;
    
    
    
  //need to work on remove contains() from xpath
    
  
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[(.='Engine Capacity Or Displacement')]/following-sibling::dd[1]")
    public WebElement div_EngineCapacityInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[(.='Engine')]/following-sibling::dd[1]")
    public WebElement div_EngineInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[(.='Transmission')]/following-sibling::dd[1]")
    public WebElement div_TransmissionInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[(.='Engine Power')]/following-sibling::dd[1]")
    public WebElement div_powerInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]//parent::section//dt[(.='Cylinders')]/following-sibling::dd[1]")
    public WebElement div_cylindersInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Interior')]/following-sibling::dd[1]")
    public WebElement div_interiorInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Exterior')]/following-sibling::dd[1]")
    public WebElement div_exteriorInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Tank Trailer Number Of Sections')]/following-sibling::dd[1]")
    public WebElement div_tankTrailerSectionsInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Number Of Valves')]/following-sibling::dd[1]")
    public WebElement div_NoOfValvesInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Adblue Tank Capacity')]/following-sibling::dd[1]")
    public WebElement div_adblueTankCapacityInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Cooling Unit')]/following-sibling::dd[1]")
    public WebElement div_coolingUnitInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Number Of Seats')]/following-sibling::dd[1]")
    public WebElement div_numberOfSeatsInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Options')]//parent::section//dt[(.='Options And Attachments')]/following-sibling::dd[1]")
    public WebElement div_optionsAndAttachmentsInAdDetails_xpath;
    
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Cabin Type')]/following-sibling::dd[1]")
    public WebElement div_cabinTypeInAdDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Tire Size')]/following-sibling::dd[1]")
    public WebElement div_tireSizeUnderDimention_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Body Model')]/following-sibling::dd[1]")
    public WebElement div_bodyModelInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Cargo Space Length')]/following-sibling::dd[1]")
    public WebElement div_cargoLengthInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Cargo Space Width')]/following-sibling::dd[1]")
    public WebElement div_cargoWidthInDetails_xpath;
   
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Cargo Space Height')]/following-sibling::dd[1]")
    public WebElement div_cargoHeightInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Wheelbase')]/following-sibling::dd[1]")
    public WebElement div_wheelBaseInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Front Tire Size')]/following-sibling::dd[1]")
    public WebElement div_frontTyreSizeInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Rear Tire Size')]/following-sibling::dd[1]")
    public WebElement div_rearTyreSizeInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Axle Configuration')]/following-sibling::dd[1]")
    public WebElement div_axleConfigSizeInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Suspension Type')]/following-sibling::dd[1]")
    public WebElement div_suspensionTypeInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Max. Payload')]/following-sibling::dd[1]")
    public WebElement div_maxPayloadInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Height')]/following-sibling::dd[1]")
    public WebElement div_heightInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Width')]/following-sibling::dd[1]")
    public WebElement div_widthInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Length')]/following-sibling::dd[1]")
    public WebElement div_lengthInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Technical Inspection Valid Till')]/following-sibling::dd[1]")
    public WebElement div_technicalInspecsValidTillInDetails_xpath;
  
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Technical Inspection Date')]/following-sibling::dd[1]")
    public WebElement div_technicalInspectionDateInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Registration Number')]/following-sibling::dd[1]")
    public WebElement div_registrationNumberInDetails_xpath;
  
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Serial Number / VIN')]/following-sibling::dd[1]")
    public WebElement div_VINNumberInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Unloading Way')]/following-sibling::dd[1]")
    public WebElement div_unloadingWayInDetails_xpath;
    
    @FindBy(xpath = "//h3[contains(.,'Additional Details')]//parent::section//dt[(.='Number Of Axles')]/following-sibling::dd[1]")
    public WebElement div_numberOfAxelsInDetails_xpath;
    
    @FindBy(xpath = "//h1[contains(.,'MAN TGL 15.250')]")
    public WebElement title_MANAdDetails_xpath;
    
    @FindBy(xpath = "//*[@class='breadcrumb']//li/a")
    public List<WebElement> link_Breadcrumb_xpath;
    
    @FindBy(xpath = "//h2[text()='Contact the seller']")
    public WebElement title_AdDetailsVerify_xpath;
    
    @FindBy(xpath = "(//span[text()='Previous']/ancestor::div[contains(@class,'next_offer_button')])[2]")
    public WebElement nav_previousButton_xpath;
    
    @FindBy(xpath = "(//span[text()='Next']/ancestor::div[contains(@class,'next_offer_button')])[2]")
    public WebElement nav_nextButton_xpath;
    
    @FindBy(xpath = "//*[@class='breadcrumb']//span[text()='Home']")
    public WebElement link_HomeinBreadcrumb_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer__gallery')]//div[1]//iframe")
    public WebElement videoInCoverImg_xpath;
    
    @FindBy(xpath = "//div[@class='fixed-ratio__content']/img[@class='gallery__item--web-thumbnail']")
    public WebElement smallImagebelowtheCoverImage;
    
    @FindBy(xpath = "//span[@class='offer-header__category']//a")
    public WebElement link_headerCategory_xpath;
  
    @FindBy(xpath = "//span[@class='offer-header__category']/following-sibling::time")
    public WebElement time_AdPostingTime_xpath;
    
   /* @FindBy(xpath = "//dl[@class='offer-header__meta-list']//dt[contains(text(),'Net Price')]/following-sibling::dd[1]")
    public WebElement netPriceInOfferHeader_xpath;*/
    
    @FindBy(xpath = "(//dl[@class='offer-header__meta-list']//dt[contains(text(),'Net Price')]/following-sibling::dd[1]//span)[1]")
    public WebElement netPriceInOfferHeader_xpath;
    
    @FindBy(xpath = "//dl[@class='offer-header__meta-list']//span[contains(text(),'Price rating')]/parent::dt/following-sibling::dd")
    public WebElement priceRatngInOfferHeader_xpath;
    
    @FindBy(xpath = "//div[@class='offer__sidebar']//div[contains(@class,'offer-header__steering-wheel')]")
    public WebElement div_steerSideInOfferHeader_xpath;
    
    @FindBy(xpath = "//div[@class='offer__sidebar']//dt[contains(.,'Year')]/parent::dl//dd[1]")
    public WebElement div_yearOfManufacturingInOfferHeader_xpath;
    
    @FindBy(xpath = "//div[@class='offer__sidebar']//dt[contains(.,'Hours Run')]/parent::dl//dd[2]")
    public WebElement div_hoursRunInOfferHeader_xpath;
    
    @FindBy(xpath = "//div[@class='offer__sidebar']//dt[contains(.,'Mileage')]/parent::dl/dd[2]")
    public WebElement div_mileageInOfferHeader_xpath;
    
    @FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//span[text()='Email']/parent::a")
    public WebElement link_emailUnderContactSeller_xpath;
  
    @FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//span[text()='Callback']/parent::a")
    public WebElement link_callBackUnderContactSeller_xpath;
  
    @FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//a[contains(@id,'phone-offer-contact')]")
    public WebElement link_callButtonUnderContactSeller_xpath;
    
    @FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//a[contains(@id,'offer-similar-alert')]")
    public WebElement link_emailforSimilarAlert_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer-seller container')]//div[contains(@class,'offer-seller__description')]")
    public WebElement div_dealerInfo_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer-seller container')]//div[@id='offer__map']")
    public WebElement div_dealerMapLocation_xpath;
    
    //@FindBy(xpath = "//h2[text()='Tradus valuation for MAN TGL ']/parent::section")
    //public WebElement div_TMVsection_xpath;
    
    @FindBy(xpath = "//h2[text()='Tradus valuation for Mercedes-Benz Actros ']/parent::section")
    public WebElement div_TMVsection_xpath;
    
    @FindBy(xpath = "//h2[text()='Tradus valuation for MAN TGL ']/parent::section//dt[contains(.,'Net Price')]/..//dd")
    public WebElement span_netPriceinTMVForMAN_xpath;
    
    @FindBy(xpath = "//h2[text()='Tradus valuation for MAN TGL ']/parent::section//dt[contains(.,'Tradus Market Value')]/..//dd")
    public WebElement span_TMVpriceForMAN_xpath;
    
    @FindBy(xpath = "//a[@id='about-tmv']/parent::Section")
    public WebElement link_aboutTMV_xpath;
    
    @FindBy(xpath = "//a[contains(@class,'offer__favorite-button')]//span")
    public WebElement link_FavoriteIcon_xpath;
    
    @FindBy(xpath = "//a[contains(@class,'offer__favorite-button')]")
    public WebElement link_FavoriteLink_xpath;
    
    @FindBy(xpath = "//nav[@class='login-form__tabs']//a[contains(text(),'Login')]")
    public WebElement tab_LoginPageVerify_xpath;
  
    //@FindBy(xpath = "//h2[text()='Tradus valuation for MAN TGL ']")
    //public WebElement header_TMVvaluationHeader_xpath;
    
    
  
    @FindBy(xpath = "//h2[text()='Tradus valuation for Mercedes-Benz Actros ']")
    public WebElement header_TMVvaluationHeader_xpath;
    
    @FindBy(xpath = "//h2[text()='Description']")
    public WebElement header_DescritpionvHeader_xpath;
    
    @FindBy(xpath = "//dl[@class='offer-header__meta-list']//td[text()='Tradus Market Value']")
    public WebElement link_TMVlinkInHeader_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer-seller container')]//a[@class='offer-seller__logo']//img")
    public WebElement img_DealerLogo_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer-seller container')]//h2[@class='h3 offer-seller__title']")
    public WebElement img_DealerName_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer-seller container')]//div[contains(@class,'offer-seller__description')]//a[contains(.,'View all ads')]")
    public WebElement link_ViewAllAds_xpath;
    
    @FindBy(xpath = "//h1[contains(@class,'seller__company-title')]//span[text()='TRADUS B.V.']")
    public WebElement span_DealerNameinAllAdspage_xpath;
  
    @FindBy(xpath = "//h2[contains(.,'results for TRADUS B.V.')]")
    public WebElement AdCountinDealerAllAds_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Frequently viewed')]/parent::section")
    public WebElement section_frequentlyViewedAds_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Frequently viewed')]/parent::section//article[contains(@class,'offer-card')]")
    public List<WebElement> adTilesUnderFrequentlyViewedAds_xpath;
  
    @FindBy(xpath = "//h2[contains(.,'Frequently viewed')]/parent::section//div[@class='glide__arrows']//a[contains(@class,'arrow--left')]")
    public WebElement link_leftGlideArrowinFrequentlyViewedAds_xpath;
    
    @FindBy(xpath = "//h2[contains(.,'Frequently viewed')]/parent::section//div[@class='glide__arrows']//a[contains(@class,'arrow--right')]")
    public WebElement link_rightGlideArrowinFrequentlyViewedAds_xpath;
    
    @FindBy(xpath = "//a[@class='back-to-top__link']")
    public WebElement link_BackToTop_xpath;
    
    @FindBy(xpath = "//div[@class='category-nav__content']//div[@id='transport']//li")
    public List<WebElement> div_transportCategoryInBottom_xpath;
    
    @FindBy(xpath = "//div[@class='category-nav__content']//div[@id='farm']//li")
    public List<WebElement> div_farmCategoryInBottom_xpath;
    
    @FindBy(xpath = "//div[@class='category-nav__content']//div[@id='construction']//li")
    public List<WebElement> div_constructionCategoryInBottom_xpath;
    
    @FindBy(xpath = "//div[@class='category-nav__content']//div[@id='material handling']//li")
    public List<WebElement> div_materialHandlingCategoryInBottom_xpath;
    
    @FindBy(xpath = "//div[@class='category-nav__content']/following-sibling::a[text()='See all categories']")
    public WebElement div_seeAllCategoriesInBottom_xpath;
    
    @FindBy(xpath = "//div[@class='category-list category-list--overview']//h3[text()='Spare parts']")
    public WebElement div_categoryPageVerify_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer__description ')]//div[.='Other languages   ']")
    public WebElement div_otherLanguageOptioninDescription_xpath;
    
    @FindBy(xpath = "(//div[contains(@class,'offer__description ')]//div[contains(.,'Original language')])[2]")
    public WebElement div_descriptionInOriginalLanguage_xpath;
    
    @FindBy(xpath = "(//div[contains(@class,'offer__description ')]//div[contains(.,'English')])[2]")
    public WebElement div_descriptionInEnglishLanguage_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer__description ')]//span[.='Show more']")
    public WebElement link_showMoreInDescription_xpath;
    
    @FindBy(xpath = "//div[contains(@class,'offer__description ')]//span[.='Show less']")
    public WebElement link_showLessInDescription_xpath;
  
    @FindBy(xpath = "//h2[text()='Description']/parent::div[contains(@class,'offer__description ')]")
    public WebElement div_DescriptionSection_xpath;
    
    @FindBy(xpath = "//h3[.='Overview']/parent::section")
    public WebElement div_OverviewSection_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Loader Crane Make']/following-sibling::dd[1]")
    public WebElement div_loaderCraneMakeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Axles Make']/following-sibling::dd[1]")
    public WebElement div_axlesMakeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Cab Heater Make']/following-sibling::dd[1]")
    public WebElement div_cabHeaterMakeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Tyre Condition']/following-sibling::dd[1]")
    public WebElement div_tyreConditionInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Rear Axle Brakes Type']/following-sibling::dd[1]")
    public WebElement div_RearAxleBreaksTypeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Body Make']/following-sibling::dd[1]")
    public WebElement div_BodyMakeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Second Axle Brakes Type']/following-sibling::dd[1]")
    public WebElement div_secondAxleBrakesTypeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Rear Axle Tyre Condition']/following-sibling::dd[1]")
    public WebElement div_rearAxleTyreConditionInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Body Volume']/following-sibling::dd[1]")
    public WebElement div_bodyVolumeInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Color']/following-sibling::dd[1]")
    public WebElement div_colorInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@class='offer__details']//dt[.='Cabin']/following-sibling::dd[1]")
    public WebElement div_cabinInAdDetailsPage_xpath;
    
    @FindBy(xpath = "//div[@id='offer-overview']//span[.='Show more']")
    public WebElement span_showMoreinOverview_xpath;
    
  
    @FindBy(xpath = "//h3[contains(.,'Dimensions')]//parent::section//dt[(.='Tire Size')]/following-sibling::dd[1]")
    public WebElement div_tireSizeInDimention_xpath;
    
    @FindBy(xpath = "//input[@id='username_login']")
	 public WebElement tradusUidInLoginPage;
	 
	 @FindBy(xpath = "//input[@id='password_login']")
	 public WebElement tradusPWDInLoginPage;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login')])[1]")
	 public WebElement tradusLoginButton;
	 
	 @FindBy(xpath = "(//button[contains(.,'Login as Buyer')])[1]")
	 public WebElement tradusLoginAsaBuyer;
    
	 @FindBy(xpath = "//div[@class='user-menu-container']")
	 public WebElement div_userMenu_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-menu-container']//ul//li[contains(.,'My favorites')]")
	 public WebElement div_favAdsLinkunderUserMenu_xpath;
	 
	 @FindBy(xpath = "//div[@class='favorites-list']//article//h3[contains(.,'Caterpillar 725C From first owner - nice machi...')]")
	 public WebElement div_AdVerifyinFavListing_xpath;
	
	 @FindBy(xpath = "//h3[contains(.,'Caterpillar 725C From first owner - nice machi...')]/ancestor::article//a[contains(@class,'favorite-link')]//span")
	 public WebElement div_favIconinFavAdListing_xpath;
	
	/* @FindBy(xpath = "//div[@class='offer__gallery mb-md-1']//a[@href='https://images.tradus.com/v1/37df45d6-f724-46e4-a828-6a1f1d6e5944.jpg']")
	 public WebElement img_CoverImgOfMANTGL_xpath;*/
	 
	 @FindBy(xpath = "//div[@class='offer__gallery mb-md-1']//img[@loading='eager']/parent::div")
	 public WebElement img_CoverImgOfMANTGL_xpath;
	
	 
	 @FindBy(xpath = "//div[@class='offer__gallery mb-md-1']//a[@href='https://images.tradus.com/v1/49ec966c-6afe-4b06-b120-0a863e1200ce.jpg']")
	 public WebElement img_CoverImgOfCaterpillarM322_xpath;
	 
	@FindBy(xpath = "(//div[contains(@class,'pswp--open')]//span[.='Report poor quality image'])[2]")
	public WebElement btn_ReportBtnImgViewPage_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'pswp--open')]//h3[.='Interested in this machine?']/following-sibling::a[contains(.,'Contact the seller now')]")
	public WebElement btn_ContactSellerinImgViewPage_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'pswp--open')]//h3[.='Interested in this machine?']/following-sibling::a[contains(@id,'phone-offer-contact')]")
	public WebElement btn_CallOptioninImgViewPage_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'pswp--open')]//h3[.='Interested in this machine?']/following-sibling::a[contains(.,'Call')]")
	public WebElement btn_CallBtninImgViewPage_xpath;
	
	@FindBy(xpath = "//div[@class='layer__modal contact-seller-modal']//label[contains(.,'message to the seller')]")
	public WebElement div_sellerContactFormVerify_xpath;
	
	@FindBy(xpath = "//div[@class='layer__modal contact-seller-modal']//button[contains(.,'Send')]")
	public WebElement div_sendButtonInContactForm_xpath;
	
	@FindBy(xpath = "//h2[.='Images']/..//ul[contains(@class,'gallery__items')]//li[@class='gallery__item gallery__item--no-video'or@class='gallery__item']")
	public List<WebElement> img_AdImageinDetaislPage_xpath;
	
	@FindBy(xpath = "//h2[.='Images']/..//ul[contains(@class,'gallery__items')]//li[@class='gallery__item gallery__item--no-video'or@class='gallery__item']//img")
	public WebElement img_defaultImageinDetaislPage_xpath;
	
	@FindBy(xpath = "//div[@class='offer__description offer-description offer__content row-11 mb-1']/following-sibling::div[1]")
	public WebElement div_CoverImgSectioninDetaislPage_xpath;
	
	@FindBy(xpath = "//strong[contains(.,'Your message has been sent')]")
	public WebElement text_leadFormSubmitSuccessinTradus_xpath;
	
	@FindBy(xpath = "(//button[contains(@class,'modal__close')])[2]")
	public WebElement btn_closeIconInContactSuccessModel_xpath;
	
	@FindBy(xpath = "(//button[contains(@class,'modal__close')])[3]")
	public WebElement btn_closeIconInCallBackSuccessModel_xpath;

	@FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//a[contains(@id,'phone-offer-contact')]")
	public WebElement link_callOptionInContactSection_xpath;
	
	@FindBy(xpath = "//div[@class='contact-callback-modal__content']//button[contains(.,'Send')]")
	public WebElement link_sendButtonInCallBackForm_xpath;
	
	@FindBy(xpath = "(//div[@class='layer__modal contact-callback-modal']//div[contains(.,'Ask the seller to call you back')])[2]")
	public WebElement link_callBackFormVerify_xpath;
	
	@FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//a[contains(@id,'phone-offer-contact')]//div[.='Please, mention Tradus when you contact the seller']")
	public WebElement div_ContactSellerforCallText_xpath;

	@FindBy(xpath = "//div[contains(@class,'pswp--open')]//h3[.='Interested in this machine?']/parent::div//div[.='Please, mention Tradus when you contact the seller']")
	public WebElement div_ContactSellerforCallTextInExtendedView_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'pswp--open')]//h3[.='Interested in this machine?']/parent::div//div[contains(@class,'phonenumber__target')]")
	public WebElement div_UnhidePhoneNumberInExtednedImgPage_xpath;
	
	@FindBy(xpath = "//h2[text()='Contact the seller']/parent::section//a[contains(@id,'phone-offer-contact')]//div[contains(@class,'phonenumber__target')]")
	public WebElement div_UnhidePhoneNumber_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//div[contains(@class,'graph-bar-item--great-price')]")
	public WebElement div_VeryLowPriceSectionInTMV_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//div[contains(@class,'graph-bar-item--good-price')]")
	public WebElement div_LowPriceSectionInTMV_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//div[contains(@class,'graph-bar-item--fair-price')]")
	public WebElement div_AveragePriceSectionInTMV_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//div[contains(@class,'graph-bar-item--high-price')]")
	public WebElement div_HighPriceSectionInTMV_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//div[contains(@class,'graph-bar-item--overprice')]")
	public WebElement div_VeryHighPriceSectionInTMV_xpath;
	
	@FindBy(xpath = "//div[.='This listing']/parent::div/following-sibling::div//div[contains(@class,'graph-price-pointer')]")
	public WebElement div_TMVPricePointer_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//dt[contains(text(),'Net Price')]/following-sibling::dd[1]")
	public WebElement div_TMVNetPrice_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//dt[contains(text(),'Tradus Market Value')]/following-sibling::dd[1]")
	public WebElement div_TMVPrice_xpath;
	
	@FindBy(xpath = "//span[@id='offer-export-link']//span[.='Print']")
	public WebElement span_PrintBtn_xpath;
	
	@FindBy(xpath = "//span[.='Print Page']")
	public WebElement span_PrintPageVerify_xpath;
	
	@FindBy(xpath = "//body[@id='print']//div[.='MAN TGL 15.250 - 2005']")
	public WebElement div_AdHeaderInPrintPage_xpath;
	
	@FindBy(xpath = "//a[@class='report-abuse__button']")
	public WebElement link_reportAbuse_xpath;
	
	@FindBy(xpath = "//div[@class='report-abuse__form-wrapper']//h2[contains(.,'Report abuse')]")
	public WebElement header_reportAbuseWrapper_xpath;
	
	@FindBy(xpath = "//div[@class='report-abuse__form-wrapper']//button[contains(.,'Send')]")
	public WebElement btn_reportAbuseSubmit_xpath;
	
	@FindBy(xpath = "//div[@class='offer__sidebar']//a[@id='offer-similar-alert']")
	public WebElement link_SendAlertForSimilarOffer_xpath;
	
	@FindBy(xpath = "//div[@class='user-menu-container']//ul//li[contains(.,'My alerts')]")
	public WebElement div_myAlertsLinkunderUserMenu_xpath;

	//@FindBy(xpath = "//div[@class='grid__content favorites__content']//a[.='Man | Army / Military Trucks']")
	//public WebElement div_AdVerifyinAlertListing_xpath;
	
	@FindBy(xpath = "//div[@class='grid__content favorites__content']//a[contains(.,'Army / Military Trucks')]")
	public WebElement div_AdVerifyinAlertListing_xpath;
	
	@FindBy(xpath = "//div[@class='grid__content favorites__content']//a[contains(.,'Army / Military Trucks')]/parent::div/following-sibling::div//a[.='Delete']")
	public WebElement link_deleteForMANinAlertList_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//p//span[1]")
	public WebElement span_AdPriceInTMVDescription_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//p//span[.='Tradus Market Value']/following-sibling::span[1]")
	public WebElement span_TMVPriceInTMVDescription_xpath;
	
	@FindBy(xpath = "//div[@class='price-rating-valuation__details']//p//span[.='Tradus Market Value']/following-sibling::span[3]")
	public WebElement span_TMVEsitamtedPriceDifference_xpath;
	
	@FindBy(xpath = "//div[@class='user-menu-container']//li//a[.='Sign out']")
	public WebElement link_SignOut_xpath;
	
	@FindBy(xpath = "//div[@class='report-abuse__close']")
	public WebElement div_CloseIconInReportAbuseScreen_xpath;
	
	@FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='mysavedalerts']")
	public WebElement div_MyAlertsTab_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'alert_results_list')]//a[.='Delete']")
	public List<WebElement> link_DeleteAlerts_xpath;

    public AdDetailsTradusPage(RemoteWebDriver driver) throws Exception {
    	this.driver = driver;
		PageFactory.initElements(driver, this);
    }
}
