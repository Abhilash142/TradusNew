package com.tradus.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveSearchTradusPage {
	
	public RemoteWebDriver driver;
	
	  @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='mysavedsearch']")
	  public WebElement link_SaveSearchTab_xpath;
	  
	  @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='mysavedsearch']//span[contains(@class,'count')]//span")
	  public WebElement span_countOfsavedSearches_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'user-account__saved-search')]//a[.='Delete']")
	  public List<WebElement> link_deleteInSavedSearch_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'user-account__saved-search')]//div[contains(@class,'column-4')]")
	  public List<WebElement> div_filtersInSaveSearches_xpath;
	  
	  @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='myfavorites']")
	  public WebElement link_FavoriteAdsTab_xpath;
	  
	  public SaveSearchTradusPage(RemoteWebDriver driver) throws Exception {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	
	  }
}
