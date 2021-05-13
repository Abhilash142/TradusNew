package com.tradus.pages;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitTill;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAlertTradusPage {
	
	public RemoteWebDriver driver;
	
	 @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='mysavedalerts']")
	  public WebElement link_MyAlert_xpath;
	 
	 @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='mysavedalerts']//span[contains(@class,'count')]//span")
	  public WebElement span_countOfsavedSearches_xpath;
	 
	  @FindBy(xpath = "//div[contains(@class,'user-account__saved-search')]//a[.='Delete']")
	  public List<WebElement> link_deleteInSavedSearch_xpath;
	  
	  @FindBy(xpath = "//div[contains(@class,'user-account__saved-search')]//div[contains(@class,'column-4')]")
	  public List<WebElement> div_filtersInAlert_xpath;
	  
	  public MyAlertTradusPage(RemoteWebDriver driver) throws Exception {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  public void navigateToMyAlertsPage() throws Exception {
			HomeTradusPage homePageObj=new HomeTradusPage(driver);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
			try {
				click(homePageObj.lable_UserMenu_xpath);
			} catch (Exception E) {
				jsClick(driver, homePageObj.lable_UserMenu_xpath);
			}
			waitTill(1500);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.link_myAlertPage_xpath);
			try {
				click(homePageObj.link_myAlertPage_xpath);
			} catch (Exception E) {
				jsClick(driver, homePageObj.link_myAlertPage_xpath);
			}
			waitTill(1500);
		}
		
}
