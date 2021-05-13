package sanity_test_TCOM;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.moveToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.GlobalConstants.TCOM_User_5;
import static com.tradus.core.GlobalConstants.TCOM_User_2;
import static com.tradus.core.GlobalConstants.TCOM_User_4;
import static com.tradus.core.GlobalConstants.pwd;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdDetailsTradusPage;
import com.tradus.pages.AdListingTradusPage;
import com.tradus.pages.FavoriteAdsTradusPage;
import com.tradus.pages.HomeTradusPage;
import com.tradus.pages.LoginTradusPage;

public class FavoriteAdsTradusTest extends BaseClass{
	
	/*
	 * Description: Verify Favorited Ad is getting displayed in favorite listing and increment in count
	 */
	@Test
	public void verifyFavoriteAdsFunctionlity() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		loginPageObj.doLogin(TCOM_User_5, pwd);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		try {
			click(homePageObj.icon_L1Categories_xpath.get(1));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(1));
		}
		waitTill(1500);
		try {
			click(homePageObj.button_searchResult_xpath.get(1));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(1));
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
		try {
			click(adListingObj.section_Sorting_xpath);
		} catch (Exception E) {
			jsClick(driver, adListingObj.section_Sorting_xpath);
		}
		waitForElement(adListingObj.link_DatePublishSorting_xpath);
		try {
			click(adListingObj.link_DatePublishSorting_xpath);
		} catch (Exception E) {
			jsClick(driver, adListingObj.link_DatePublishSorting_xpath);
		}
		waitTill(1000);
		String adTitle=getText(adListingObj.AdTitleInListing_xpath.get(3)).trim();
		//System.out.println(getText(adListingObj.AdTitleInListing_xpath.get(3)));
		try {
			click(adListingObj.div_favoriteIconinListing_xpath.get(3));
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_favoriteIconinListing_xpath.get(3));
		}
		waitTill(1000);
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertTrue(adListingObj.div_favoriteIconinListing_xpath.get(3).getCssValue("color").equals("rgba(255, 136, 0, 1)"),"Star icon isn't highlighted on clicking favorite icon");
		waitTill(1000);
		FavoriteAdsTradusPage favoriteObj=new FavoriteAdsTradusPage(driver);
		favoriteObj.navigateToFavoriteAdsPage();
		waitTill(2000);
		softAssertion.assertTrue(favoriteObj.link_myFavoriteTab_xpath.getCssValue("color").equals("rgba(35, 31, 32, 1)"), "My Accounts Tab isn't highlighted when clicked on the My Accounts Link");
		softAssertion.assertTrue(favoriteObj.link_myFavoriteTab_xpath.getCssValue("background-color").equals("rgba(255, 255, 255, 1)"), "My Accounts Tab background color might have changed when opened");
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int fab_count=Integer.parseInt(getText(homePageObj.span_CountOfFavoriteAdsunderUserMenu_xpath).trim());
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
	   String adTitleInFavorites=getText(favoriteObj.title_AdTitleinFavoriteListing_xpath.get(0)).trim();
	  // System.out.println(getText(favoriteObj.title_AdTitleinFavoriteListing_xpath.get(0)));
		softAssertion.assertEquals(adTitleInFavorites.equals(adTitle), "Favorited Ad from listing page isn't displaying in Favorite Ad Listing Page");
		try {
			click(favoriteObj.link_starIconinFavoriteListing_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,favoriteObj.link_starIconinFavoriteListing_xpath.get(0));
		}
		waitTill(1000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int new_fab_count=Integer.parseInt(getText(homePageObj.span_CountOfFavoriteAdsunderUserMenu_xpath).trim());
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		softAssertion.assertEquals(new_fab_count<fab_count, "Count isn't updating on removing favorite Ads");
		softAssertion.assertAll();
	
	}
	/*
	 * Description: Verify No Ads text when Ads not present in Favorite Ads Page
	 */
	@Test
	public void verifyNoAdsTextinFavoriteAdsPage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		loginPageObj.doLogin(TCOM_User_2, pwd);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		FavoriteAdsTradusPage favoriteObj=new FavoriteAdsTradusPage(driver);
		favoriteObj.navigateToFavoriteAdsPage();
		try {
			explicitWaitFortheElementTobeVisible(driver, favoriteObj.text_noFavoritePresentText_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(favoriteObj.text_noFavoritePresentText_xpath),"You have no favorites added text isn't present in no results Favorite Listing");
		}
	}

	/*
	 * Description: Verify the respective ad is favorited when we search with particular ad from search field
	 */
	@Test
	public void FavoriteIconIsHighlightedWhenSearchedFromSearchField() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		loginPageObj.doLogin(TCOM_User_4, pwd);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,"https://www.tradus.com/en/spare-parts/buses/other-buses-spare-parts/fendt/fendt-5255-l-7508147");
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		try {
			click(adDetailsObj.link_FavoriteIcon_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_FavoriteIcon_xpath);
		}
		waitTill(2000);
		loadUrl(driver,"https://www.tradus.com/");
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.input_searchField_xpath);
		sendKeys(homePageObj.input_searchField_xpath,"7508147");
		waitTill(2000);
		try {
		    	click(homePageObj.button_searchIcon_xpath);
		    }catch(Exception E) {
		    	jsClick(driver,homePageObj.button_searchIcon_xpath);
		    }
		explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertTrue(adListingObj.AdTitleInListing_xpath.size()==1,"Only one Ad isn't displaying on searching Ad with Ad id");
		//System.out.println(adListingObj.AdTitleInListing_xpath.size());
		softAssertion.assertTrue(adListingObj.div_favoriteIconinListing_xpath.get(0).getCssValue("color").equals("rgba(255, 136, 0, 1)"),"Star icon isn't highlighted when ad is searched via search box");
		try {
			click(adListingObj.div_favoriteIconinListing_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_favoriteIconinListing_xpath.get(0));
		}
		waitTill(1000);
		moveToElement(driver,adListingObj.AdTitleInListing_xpath.get(0));
		waitTill(2000);
		
		softAssertion.assertTrue(adListingObj.div_favoriteIconinListing_xpath.get(0).getCssValue("color").equals("rgba(255, 255, 255, 1)"),"Star icon isn't unhighlighted on clicking favorite icon already favorited Ad");
		softAssertion.assertAll();
	}
}
