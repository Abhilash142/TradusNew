package com.tradus.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdListingTradusPage {

	public RemoteWebDriver driver;
	
	  @FindBy(xpath = "//span[text()='Sort by']/parent::span//span[@class='search-sort__select select']")
	  public WebElement span_SelectedSortingType_xpath;
	  
	  @FindBy(xpath = "//nav[@class='breadcrumb']")
	  public WebElement nav_breadCrumb_xpath;
	  
	  @FindBy(xpath = "//nav[@class='breadcrumb']//li[2]//span")
	  public WebElement span_L1CategoryTypeinBreadCrumb_xpath;
	  
	  @FindBy(xpath = "//h1[contains(@class,'search-form-header__title--full')]")
	  public WebElement text_adCountWithFiltersinListingPage_xpath;
	  
	  @FindBy(xpath = "//div[@class='grid__main']//div[contains(@class,'category-picker__item')]")
	  public List<WebElement> icon_L3CategoryIcon_xpath;
	  
	  @FindBy(xpath = "//div[@class='grid__main']//div[contains(@class,'category-picker__list')]")
	  public WebElement icon_categoryPickerList_xpath;
	  
	  @FindBy(xpath = "//div[@class='grid__main']//div[@class='category-picker__icon']/ancestor::div[contains(@class,'category-picker__item')]")
	  public List<WebElement> icon_L1andL2CategoryIcon_xpath;
	  
	  @FindBy(xpath = "//div[@class='panel search-filters-overview ']//span[text()='Save search']/parent::a")
	  public WebElement icon_saveSearch_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@placeHolder='Manufacturer']")
	  public WebElement icon_manufacturerFieldInFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//label[@class='fieldset__label checkbox-filter__label']/preceding-sibling::input")
	  public List<WebElement> checkBox_MakeunderSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-price-min']")
	  public WebElement input_priceFromUnderSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-price-max']")
	  public WebElement input_priceToUnderSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//legend[contains(.,'Transmission')]/..//div[@class='checkbox-filter__field ']")
	  public List<WebElement> checkBox_transmissionTypeUnderSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//legend[contains(.,'Advert type')]/..//div[@class='checkbox-filter__field ']")
	  public List<WebElement> checkBox_advertTypeUnderSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//div[contains(@class,'overview__group-title') and contains(.,'Overview')]")
	  public WebElement div_OverviewFilter_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//div[contains(@class,'overview__group-title') and contains(.,'Technical specs')]")
	  public WebElement div_technicalSpecsFilter_xpath;
	  
	  @FindBy(xpath = "//button[contains(.,'Apply') and contains(@class,'search-filters-overview') and @type='submit']")
	  public WebElement btn_submitInSideFilters_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-construction_year-min']")
	  public WebElement input_yearFrom_xpath;
	 
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-construction_year-max']")
	  public WebElement input_yearTo_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-mileage-min']")
	  public WebElement input_MileageFrom_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-mileage-max']")
	  public WebElement input_MileageTo_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-weight-min']")
	  public WebElement input_WeightFrom_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'search-filters-overview__main')]//input[@id='range-weight-max']")
	  public WebElement input_WeightTo_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-save-search']//span[.='Create alert']/..")
	  public WebElement span_CreateAlert_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'pager__counter')]//*")
	  public List<WebElement> span_pageNumbers_xpath;
	  
	  @FindBy(xpath = "//a[@title='Next']")
	  public WebElement link_Next_xpath;
	  
	  @FindBy(xpath = "//a[@title='Previous']")
	  public WebElement link_Previous_xpath;
	  
	  @FindBy(xpath = "//div[contains(.,'Top offer')]/ancestor::article")
	  public List<WebElement> div_TopOfferAds_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__name']//h3")
	  public List<WebElement> AdTitleInListing_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__name']/ancestor::article//img")
	  public List<WebElement> img_AdImageInListing_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__name']//following-sibling::time")
	  public List<WebElement> time_AdPostedTime_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__name']//p")
	  public List<WebElement> para_L3CategoryNameInListingTile_xpath;
	  
	  @FindBy(xpath = "//span[contains(@class,'price_') or contains(@class,'__amount') or contains(text(),'Price upon request')]")
	  public List<WebElement> div_adPriceinListingTile_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'offer-result__price-analysis')]")
	  public List<WebElement> div_TMVinListingTile_xpath;
	
	  @FindBy(xpath = "//div[@class='offer-result__details']//dd[@itemprop='productionDate']")
	  public List<WebElement> div_productionYearinAdTile_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__seller-info']//div[@class='offer-result__location link']")
	  public List<WebElement> div_AdLocation_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-result__seller-info']//a[contains(@id,'favorite_offer')]//span")
	  public List<WebElement> div_favoriteIconinListing_xpath;
	  
	  @FindBy(xpath = "//a[.='Reset']")
	  public WebElement link_filterReset_xpath;
	  
	  @FindBy(xpath = "//span[text()='Sort by']/parent::span//section[@id='search-sort']")
	  public WebElement section_Sorting_xpath;
	  
	  @FindBy(xpath = "//span[text()='Sort by']/parent::span//nav[@class='search-sort__options']//a")
	  public List<WebElement> options_Sorting_xpath;
	  
	  @FindBy(xpath = "//span[text()='Sort by']/parent::span//nav[@class='search-sort__options']//a[contains(.,'Date Published')]")
	  public WebElement link_DatePublishSorting_xpath;
	  
	  @FindBy(xpath = "//section[@id='filter-make']//span[.='Make']/../following-sibling::select[@id='select-make']")
	  public WebElement select_MakeFilter_xpath;
	  
	  @FindBy(xpath = "//section[@id='filter-make']//span[.='Model']/../following-sibling::select[@id='select-model']")
	  public WebElement select_ModelFilter_xpath;
	  
	  @FindBy(xpath = "//label[.='Location']/..//div[@class='ss-values']")
	  public WebElement div_LocationFilter_xpath;
	
	  @FindBy(xpath = "//span[contains(.,'Filters')]/ancestor::div[@class='panel search-filters-overview ']")
	  public WebElement div_FilterSection_xpath;
	  
	  @FindBy(xpath = "//a[@class='back-to-top__link']")
	  public WebElement link_BackToTop_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-save-search']//div[@class='column p-0']")
	  public WebElement div_createAlertText_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-save-search']//span[.='Login']/parent::a")
	  public WebElement div_LoginBtnIncreateAlert_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-save-search']//div[@class='success-message flash-message']")
	  public WebElement div_successMessageInCreatingAlert_xpath;
	  
	  @FindBy(xpath = "//div[@class='offer-save-search']//span[.='Remove alert']/..")
	  public WebElement div_RemoveAlertBtnInCreatingAlert_xpath;
	  
	  @FindBy(xpath = "(//div[@class='grid search__page-description'])[1]")
	  public WebElement div_Make_SEO_Content_xpath;
	
	  @FindBy(xpath = "(//div[@class='grid search__page-description'])[2]")
	  public WebElement div_Country_SEO_Content_xpath;
	 
	  @FindBy(xpath = "(//div[@class='grid search__page-description'])[1]//ul//li")
	  public List<WebElement> div_MakeList_SEO_Content_xpath;
	  
	  @FindBy(xpath = "(//div[@class='grid search__page-description'])[2]//ul//li")
	  public List<WebElement> div_CountryList_SEO_Content_xpath;
	  
	  @FindBy(xpath = " (//div[@class='grid search__page-description'])[1]//span[contains(.,'Show')]/ancestor::button")
	  public List<WebElement> button_showMoreLinkinSEO_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'save_search_message')]")
	  public WebElement div_saveSearchAlert_xpath;
	  
	 @FindBy(xpath = "//div[@class='panel search-filters-overview ']//span[text()='Save search']/parent::a//span[@class='icon ']")
	  public WebElement div_saveSearchStarIcon_xpath;
	  
	 //@FindBy(xpath = "//div[@class='panel search-filters-overview ']//span[text()='Save search']/parent::a//span[@class='icon ']//*[local-name()='svg' ]/*[local-name()='path']")
	//  public WebElement div_saveSearchStarIcon_xpath;
	
	  
	  @FindBy(xpath = "//div[contains(@class,'success_search_message')]")
	  public WebElement div_saveSearchSuccessMessage_xpath;
	
	  
   	  public AdListingTradusPage(RemoteWebDriver driver) throws Exception {
    	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
