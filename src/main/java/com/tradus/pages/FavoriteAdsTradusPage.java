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

public class FavoriteAdsTradusPage {
public RemoteWebDriver driver = null;
	
     @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='myfavorites']")
     public WebElement link_myFavoriteTab_xpath;
     
     @FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='myfavorites']//span[contains(@class,'total')]//span")
	 public WebElement span_countOfFavoriteAds_xpath;
	
     @FindBy(xpath = "//div[@class='favorites-list']//article[contains(@class,'offer-result')]")
	 public List<WebElement> favoriteAdsinFavoriteListing_xpath;
   
     @FindBy(xpath = "//div[@class='favorites-list']//article[contains(@class,'offer-result')]//a[contains(@id,'favorite_offer')]//span")
	 public List<WebElement> link_starIconinFavoriteListing_xpath;
   
     @FindBy(xpath = "//p[.='You have no favorites added.']")
	 public WebElement text_noFavoritePresentText_xpath;
   
     @FindBy(xpath = "//div[@class='favorites-list']//article[contains(@class,'offer-result')]//h3")
	 public List<WebElement> title_AdTitleinFavoriteListing_xpath;
   
	
	
	public FavoriteAdsTradusPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToFavoriteAdsPage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		waitTill(1500);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_FavoriteAdsPage_xpath );
		try {
			click(homePageObj.link_FavoriteAdsPage_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_FavoriteAdsPage_xpath);
		}
		waitTill(1500);
	}
	
}
