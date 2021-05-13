package sanity_test_TCOM;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

import static com.tradus.core.GlobalConstants.TCOM_User_5;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdListingTradusPage;
import com.tradus.pages.HomeTradusPage;
import com.tradus.pages.LoginTradusPage;
import com.tradus.pages.MyAlertTradusPage;

public class MyAlertTradusTest extends BaseClass{

	/*
	 * Description: Verify Create Alert functionality
	 */
	@Test
	public void createAlertFunctionality() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		loginPageObj.doLogin(TCOM_User_5, pwd);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(0));
		Select make=new Select(homePageObj.dropDown_Make_xpath.get(0));
		Select model=new Select(homePageObj.dropDown_Model_xpath.get(0));
		Select yearFrom=new Select(homePageObj.dropDown_YearFrom_xpath.get(0));
		Select priceUpto=new Select(homePageObj.dropDown_Price_xpath.get(0));
		Select mileageUpto=new Select(homePageObj.dropDown_Mileage_xpath);
		Select weightUpto=new Select(homePageObj.dropDown_Weight_xpath.get(0));
		l2.selectByValue("2");
		waitTill(2000);
		make.selectByValue("mercedes-benz");
		yearFrom.selectByValue("1980");
		priceUpto.selectByValue("500000");
		mileageUpto.selectByValue("600000");
		weightUpto.selectByValue("44000");
		waitTill(3000);
		model.selectByValue("actros");
		try {
			click(homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}
		waitForElement(homePageObj.input_SearchBoxUnderCountryDropdown_xpath.get(0));
		sendKeys(homePageObj.input_SearchBoxUnderCountryDropdown_xpath.get(0),"Ger");
		waitTill(2000);
		try {
			click(homePageObj.div_listOfCountries_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.div_listOfCountries_xpath.get(0));
		}
		waitTill(2000);
		String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(0)).replace("\n"," ").trim();
		int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
		if(result_home!=0) {
			try {
				click(homePageObj.button_searchResult_xpath.get(0));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(0));
			}
		}
			else {
				Assert.assertTrue(result_home>0,"For Truck>>Mercedes-Benz>>Actros>>Germany>>1980>>500000>>600000>>44000, search result shows Zero results");
			}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(adListingObj.div_RemoveAlertBtnInCreatingAlert_xpath)) {
			try {
				click(adListingObj.div_RemoveAlertBtnInCreatingAlert_xpath);
			}catch (Exception E) {
				jsClick(driver,adListingObj.div_RemoveAlertBtnInCreatingAlert_xpath);
			}
			waitTill(2000);
		}
		explicitWaitFortheElementTobeVisible(driver,adListingObj.span_CreateAlert_xpath);
		try {
			click(adListingObj.span_CreateAlert_xpath);
		}catch (Exception E) {
			jsClick(driver,adListingObj.span_CreateAlert_xpath);
		}
		waitTill(1000);
		MyAlertTradusPage alertsObj=new MyAlertTradusPage(driver);
		alertsObj.navigateToMyAlertsPage();
		SoftAssert softAssertion= new SoftAssert();
		waitTill(2000);
		softAssertion.assertTrue(alertsObj.link_MyAlert_xpath.getCssValue("color").equals("rgba(35, 31, 32, 1)"), "My Accounts Tab isn't highlighted when clicked on the My Accounts Link");
		softAssertion.assertTrue(alertsObj.link_MyAlert_xpath.getCssValue("background-color").equals("rgba(255, 255, 255, 1)"), "My Accounts Tab background color might have changed when opened");
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		waitTill(2000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int fab_count=Integer.parseInt(getText(alertsObj.span_countOfsavedSearches_xpath).replaceAll("[^0-9]", "").trim());
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		//System.out.println(getText(alertsObj.div_filtersInAlert_xpath.get(0)));
		softAssertion.assertTrue(getText(alertsObj.div_filtersInAlert_xpath.get(0)).trim().equalsIgnoreCase("Trucks | Germany"), "Saved alert isn't displaying in Tradus My Alerts page");
		try {
			click(alertsObj.link_deleteInSavedSearch_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,alertsObj.link_deleteInSavedSearch_xpath.get(0));
		}
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int new_fab_count=Integer.parseInt(getText(alertsObj.span_countOfsavedSearches_xpath).replaceAll("[^0-9]", "").trim());
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		softAssertion.assertTrue(new_fab_count<fab_count,"Count isn't updating properly on deleting Alert");
		//System.out.println(fab_count);
		//System.out.println(new_fab_count);
		softAssertion.assertAll();
	}
}
