package smoke_test_TCOM;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.TCOM_User_2;
import static com.tradus.core.GlobalConstants.pwd;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdDetailsTradusPage;
import com.tradus.pages.AdListingTradusPage;
import com.tradus.pages.HomeTradusPage;
import com.tradus.pages.SaveSearchTradusPage;

public class SaveSearchTradusTest extends BaseClass{
	/*
	 * Description: Verify Login page is displaying on clicking the 'Save search' link without login
	 */
	@Test
	public void verifyLoginPageisDisplayingOnClickingSaveSearchLinkWithOutLogin() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(1000);
		if(!verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.lable_UserMenu_xpath);
			}catch(Exception E) {
				jsClick(driver,homePageObj.lable_UserMenu_xpath);
			}
			try {
				click(homePageObj.link_SignOut_xpath);
			}catch(Exception E) {
				jsClick(driver,homePageObj.link_SignOut_xpath);
			}
			waitForElement(homePageObj.link_loginTradus_xpath);
			loadUrl(driver,"https://www.tradus.com/");
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
		int size=homePageObj.icon_L1Categories_xpath.size();
		for(int i=0;i<size;i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitForElement(homePageObj.button_searchResult_xpath.get(i));
		try {
			click(homePageObj.button_searchResult_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,homePageObj.button_searchResult_xpath.get(i));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		try {
			click(adListingObj.icon_saveSearch_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_saveSearch_xpath);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(homePageObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking Save search buttton without login for "+i+"th category");
		}
		try {
			click(homePageObj.logo_tradus_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.logo_tradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	/*
	 * Description: Verify the save search icon is highlighted after applying the filters and Verify the search is highlighted after refreshing the page too
	 */
	@Test
	public void verifySaveSearchIconisHighlightedandremainsHighlightedOnRefreshingThePage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.link_loginTradus_xpath);
			}catch(Exception E) {
				 jsClick(driver,homePageObj.link_loginTradus_xpath);
			 }
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
			sendKeys(homePageObj.tradusUidInLoginPage,TCOM_User_2);
			sendKeys(homePageObj.tradusPWDInLoginPage,pwd);
			jsClick(driver,homePageObj.tradusLoginButton);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			}
		
		try {
			click(homePageObj.icon_L1Categories_xpath.get(2));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(2));
		}
		waitForElement(homePageObj.button_searchResult_xpath.get(2));
		try {
			click(homePageObj.button_searchResult_xpath.get(2));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(2));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		try {
			click(adListingObj.icon_L1andL2CategoryIcon_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_L1andL2CategoryIcon_xpath.get(0));
		}
		SoftAssert softAssert=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		try {
			click(adListingObj.icon_saveSearch_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_saveSearch_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adListingObj.div_saveSearchSuccessMessage_xpath);
		softAssert.assertTrue(adListingObj.div_saveSearchStarIcon_xpath.getCssValue("fill").equals("rgb(255, 136, 0)"),"Favorite icon isn't highlighted when search is being saved");
		//System.out.println("Color after favorited: "+adListingObj.div_saveSearchStarIcon_xpath.getCssValue("fill"));
		driver.navigate().refresh();
		explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		waitTill(1000);
		softAssert.assertTrue(adListingObj.div_saveSearchStarIcon_xpath.getCssValue("fill").equals("rgb(255, 136, 0)"),"Favorite search icon isn't highlighted when page is refreshed");
		try {
			click(adListingObj.icon_saveSearch_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_saveSearch_xpath);
		}
		waitTill(2000);
		//System.out.println("Color after unfavorited: "+adListingObj.div_saveSearchStarIcon_xpath.getCssValue("fill"));
		softAssert.assertTrue(adListingObj.div_saveSearchStarIcon_xpath.getCssValue("fill").equals("rgb(255, 255, 255)"),"Save search icon isn't unhighlighted when clicked on Favorite icon for already saved listing");
		softAssert.assertAll();
	}
	/*
	 * Description: Verify the saved searches are displaying under my saved searches tab in My accounts and
	 *  Verify saved search tab is highlighted in my accounts page on clicking the 'My saved searches' link under my account 
	 */
	@Test
	public void verifyFavoriteSearchTabAndSamePageDisplayingOnRefreshingThePage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.link_loginTradus_xpath);
			}catch(Exception E) {
				 jsClick(driver,homePageObj.link_loginTradus_xpath);
			 }
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
			sendKeys(homePageObj.tradusUidInLoginPage,TCOM_User_2);
			sendKeys(homePageObj.tradusPWDInLoginPage,pwd);
			jsClick(driver,homePageObj.tradusLoginButton);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			}
		try {
			click(homePageObj.icon_L1Categories_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(0));
		}
		waitForElement(homePageObj.button_searchResult_xpath.get(0));
		try {
			click(homePageObj.button_searchResult_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(0));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		waitTill(2000);
		try {
			click(adListingObj.icon_saveSearch_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_saveSearch_xpath);
		}
		waitTill(1000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		try {
			click(homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		}
		SoftAssert softAssert=new SoftAssert();
		SaveSearchTradusPage saveSearchObj=new SaveSearchTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,saveSearchObj.link_SaveSearchTab_xpath);
		softAssert.assertTrue(verifyElementPresent(saveSearchObj.link_SaveSearchTab_xpath), "Saved Search page isn't displaying on clicking Save search Link from User Menu");
		softAssert.assertTrue(saveSearchObj.link_SaveSearchTab_xpath.getCssValue("color").equals("rgba(35, 31, 32, 1)"), "Save searches Tab isn't highlighted when clicked on the save search Link");
		softAssert.assertTrue(saveSearchObj.link_SaveSearchTab_xpath.getCssValue("background-color").equals("rgba(255, 255, 255, 1)"), "Save searches Tab background color might have changed");
		driver.navigate().refresh();
		explicitWaitFortheElementTobeVisible(driver,saveSearchObj.link_SaveSearchTab_xpath);
		softAssert.assertTrue(saveSearchObj.link_SaveSearchTab_xpath.getCssValue("color").equals("rgba(35, 31, 32, 1)"), "Save searches Tab isn't highlighted when clicked on the save search Link");
		softAssert.assertTrue(saveSearchObj.link_SaveSearchTab_xpath.getCssValue("background-color").equals("rgba(255, 255, 255, 1)"), "Save searches Tab background color might have changed");
	    try {
			click(saveSearchObj.link_deleteInSavedSearch_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,saveSearchObj.link_deleteInSavedSearch_xpath.get(0));
		}
	   waitTill(1000);
	   softAssert.assertAll();
	}
	/*
	 * Description: Verify saved search ads are displaying in another tab on clicking the search in Saved search tab, Verify the option as remove notification to delete the saved search
	 * and Verify Delete Option Is Displaying On MysavedSearch Tab And Verify Counts By Clicking Delete Option
	 */
	@Test
	public void verifySaveSearchesAreDisplayingInOtherTabAndDeleteLinkFunctionality() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.link_loginTradus_xpath);
			}catch(Exception E) {
				 jsClick(driver,homePageObj.link_loginTradus_xpath);
			 }
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
			sendKeys(homePageObj.tradusUidInLoginPage,TCOM_User_2);
			sendKeys(homePageObj.tradusPWDInLoginPage,pwd);
			jsClick(driver,homePageObj.tradusLoginButton);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			}
		try {
			click(homePageObj.icon_L1Categories_xpath.get(1));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(1));
		}
		waitForElement(homePageObj.button_searchResult_xpath.get(1));
		try {
			click(homePageObj.button_searchResult_xpath.get(1));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(1));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		try {
			click(adListingObj.icon_saveSearch_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_saveSearch_xpath);
		}
		waitTill(1000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		try {
			click(homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.link_FavoriteSearchFromUserMenu_xpath);
		}
		SaveSearchTradusPage saveSearchObj=new SaveSearchTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,saveSearchObj.link_SaveSearchTab_xpath);
		String parentWindow=driver.getWindowHandle();
		try {
			click(saveSearchObj.div_filtersInSaveSearches_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,saveSearchObj.div_filtersInSaveSearches_xpath.get(0));
		}
		Set<String> wins=driver.getWindowHandles();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(wins.size()==2, "New Tab didn't open on clicking Saved searches from save search page");
		switchWindow(driver,parentWindow);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
	    String filters_in_Listing=getText(adListingObj.nav_breadCrumb_xpath).replace("Breadcrumb", "");
	    softAssert.assertTrue(filters_in_Listing.replace("\n", ",").trim().equals(",Home,Farm"), "Listing is not filtered properly when navigated from saved search page");
       // System.out.println(filters_in_Listing.replace("\n", ",").trim());
	    driver.close();
	    driver.switchTo().window(parentWindow);
	    int savedSearch_count=Integer.parseInt(getText(saveSearchObj.span_countOfsavedSearches_xpath).replaceAll("[^0-9]", ""));
	    softAssert.assertTrue(savedSearch_count>=1, "Correct count isn't dislaying in save search page");
	    try {
			click(saveSearchObj.link_deleteInSavedSearch_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,saveSearchObj.link_deleteInSavedSearch_xpath.get(0));
		}
	   waitTill(1000);
	   explicitWaitFortheElementTobeVisible(driver,saveSearchObj.link_SaveSearchTab_xpath);
	   int new_savedSearch_Count=Integer.parseInt(getText(saveSearchObj.span_countOfsavedSearches_xpath).replaceAll("[^0-9]", ""));
	   softAssert.assertTrue(new_savedSearch_Count<savedSearch_count, "Save search count isn't updating properly on deleting the Searches");
	   softAssert.assertAll();
	}
	
}
