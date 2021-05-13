package sanity_test_TPRO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.MarketinSightsTradusProPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.waitTill;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import java.util.List;

import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;


public class MarketinSightsTradusProTest extends BaseClass{
	
	/*
	 * Description: Verify market insights page is displaying on clicking the link from menu
	 */
	@Test(priority=0)
	public void verifyNavigationtoMarketInsightpageOnClickingLinkformMenu() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(2000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
		click(overviewObj.marketInsightOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightpageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/market-insights"), 
				"Market insight page is not displaying");
	}
	
	/*
	 * Description: Verify category and sub category drop downs are displaying below 'Most popular vehicles' text
	 */
	@Test(priority=1)
	public void verifyCategoryandSubCategoryTextsDiplayingbelowMostPopularVehicleText() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(4000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver,loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightOptioninSiderBar);
		waitTill(2000);
		MarketinSightsTradusProPage misObj=new MarketinSightsTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		Assert.assertTrue(verifyElementPresent(misObj.marketinSightCateorylabel), 
				"Category is not present under Most popular vehicles");
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(misObj.marketinSightsubCateorylabel), 
				"Sub-Category is not present under Most popular vehicles");
	}
	
	/*
	 * Description: Verify all the top leads makes are displaying randomly if category is not selected
	 */
	@Test(priority=2)
	public void verifyalltheTopLeadsMakesaredisplayingrnadomlyifCategoryisnotSelected() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(4000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver,loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightOptioninSiderBar);
		waitTill(2000);
		MarketinSightsTradusProPage misObj=new MarketinSightsTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		Select s=new Select(misObj.marketinSightsCategorySelectionBox);
		Assert.assertTrue(getText(s.getFirstSelectedOption()).equals("-"),
				"Category dropdown is not empty upon navigation first time");
		waitTill(1000);
		Assert.assertFalse(getText(misObj.marketinSightSearchResultArea).equals("There were no leads for this (sub)category in the last week."),
				"No leads are displayed when category is not selected");
		Assert.assertTrue(misObj.marketinSightfilterResultscount.size()>=1,
				"Top leads are not displaying randomly on visiting market insights page");
	}
	/*
	 * Description: Verify make name, leads and statistics since last week and month are displaying
	 */
	@Test(priority=3)
	public void verifyaMakenameLeadsStatisticsinResults() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(4000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver,loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightOptioninSiderBar);
		waitTill(2000);
		MarketinSightsTradusProPage misObj = new MarketinSightsTradusProPage(driver);
		WebElement[] subcatVerficationElements = { misObj.transportsubCategoryVerificationElement,
				misObj.farmsubCategoryVerificationElement, misObj.constructionsubCategoryVerificationElement,
				misObj.sparePatrssubCategoryVerificationElement, misObj.MHEsubCategoryVerificationElement,
				misObj.PEMTsubCategoryVerificationElement };
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		Select categories = new Select(misObj.marketinSightsCategorySelectionBox);
		while (true) {
			click(misObj.marketinSightsCategorySelectionBox);
			if (!verifyElementPresent(misObj.marketinSightCategoryDropdownVerificationElement)) {
				click(misObj.marketinSightsCategorySelectionBox);
				waitTill(2000);
			} else {
				click(misObj.marketinSightsCategorySelectionBox);
				break;
			}
		}
		List<WebElement> catOptions = categories.getOptions();
		for (int i = 1; i < catOptions.size(); i++) {
			click(catOptions.get(i));
			waitTill(4000);
			while (true) {
				click(misObj.marketinSightssubCategorySelectionBox);
				if (!verifyElementPresent(subcatVerficationElements[i - 1])) {
					click(misObj.marketinSightssubCategorySelectionBox);
					waitTill(2000);
				} else {
					click(misObj.marketinSightssubCategorySelectionBox);
					break;
				}
			}
			Select subCategories = new Select(misObj.marketinSightssubCategorySelectionBox);
			List<WebElement> subcatOptions = subCategories.getOptions();
			for (int j = 1; j < subcatOptions.size(); j++) {
				click(subcatOptions.get(j));
				// WebDriverWait wait=new WebDriverWait(driver, 10);
				// wait.until(ExpectedConditions.or(
				// ExpectedConditions.visibilityOf(misObj.marketinSightCnfNoResultsVerificationElement),
				// ExpectedConditions.visibilityOf(misObj.marketinSightCnfResultsVerificationElement)));
				waitTill(4000);
				if (!getText(misObj.marketinSightSearchResultArea)
						.equals("There were no leads for this (sub)category in the last week.")) {
					List<WebElement> numberOfStocks=misObj.marketinSightfilterResultscount;
					List<WebElement> makeModelName = misObj.marketinSightResultsMakeandModelNames;
					List<WebElement> leadCount = misObj.marketinSightLeadsCount;
					List<WebElement> leadweekStats = misObj.marketinSightLeadsStatsLastWeek;
					List<WebElement> leadmonthStats = misObj.marketinSightLeadsStatsLastMonth;
					for (int k = 0; k < numberOfStocks.size(); k++) {
						Assert.assertTrue(verifyElementPresent(makeModelName.get(k)),
								"Make and model name is not displaying for " + k + "th row of"
										+ getText(catOptions.get(i)) + " make and " + getText(subcatOptions.get(j))
										+ " model search results");
						Assert.assertTrue(verifyElementPresent(leadCount.get(k)),
								"Leads Count is not displaying for " + k + "th row of" + getText(catOptions.get(i))
										+ " make and " + getText(subcatOptions.get(j)) + " model search results");
						Assert.assertTrue(verifyElementPresent(leadweekStats.get(k)),
								"Weekly leads stats is not displaying for " + k + "th row of"
										+ getText(catOptions.get(i)) + " make and " + getText(subcatOptions.get(j))
										+ " model search results");
						Assert.assertTrue(verifyElementPresent(leadmonthStats.get(k)),
								"Monthly leads stats is not displaying for " + k + "th row of"
										+ getText(catOptions.get(i)) + " make and " + getText(subcatOptions.get(j))
										+ " model search results");
					}
				}
			}
		}
	}
	/*
	 * Description: Verify respective default picture is displaying for respective make
	 */
	@Test(priority=4)
	public void verifyrespectiveDefaultPicturesforrespectiveMakes() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(4000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver,loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightOptioninSiderBar);
		waitTill(2000);
		MarketinSightsTradusProPage misObj = new MarketinSightsTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		waitTill(4000);
		Assert.assertTrue(misObj.marketinSightfilterResultscount.size()>=1,
				"Top leads are not displaying randomly on visiting market insights page");
		for(int i=0;i<misObj.marketinSightfilterResultscount.size();i++)
		{
			Assert.assertTrue(verifyElementPresent(misObj.logoinDisplayedTopLeads.get(i)), 
					"Logo is not present in leads row no "+i);
		}
	}
	/*
	 * Description: Verify all the top leads makes are displaying based on selected category
	 *  if category/sub category is selected
	 *  Note: At present, validating with the top leads list as per their leads count in descending order
	 */
	@Test(priority=5)
	public void verifyAllTopLeadsaredisplayingasperselctedMakeandModel() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		waitTill(4000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver,loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightOptioninSiderBar);
		waitTill(2000);
		MarketinSightsTradusProPage misObj = new MarketinSightsTradusProPage(driver);
		WebElement[] subcatVerficationElements = { misObj.transportsubCategoryVerificationElement,
				misObj.farmsubCategoryVerificationElement, misObj.constructionsubCategoryVerificationElement,
				misObj.sparePatrssubCategoryVerificationElement, misObj.MHEsubCategoryVerificationElement,
				misObj.PEMTsubCategoryVerificationElement };
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		Select categories = new Select(misObj.marketinSightsCategorySelectionBox);
		while (true) {
			click(misObj.marketinSightsCategorySelectionBox);
			if (!verifyElementPresent(misObj.marketinSightCategoryDropdownVerificationElement)) {
				click(misObj.marketinSightsCategorySelectionBox);
				waitTill(2000);
			} else {
				click(misObj.marketinSightsCategorySelectionBox);
				break;
			}
		}
		List<WebElement> catOptions = categories.getOptions();
		for (int i = 1; i < catOptions.size(); i++) {
			click(catOptions.get(i));
			while (true) {
				click(misObj.marketinSightssubCategorySelectionBox);
				if (!verifyElementPresent(subcatVerficationElements[i - 1])) {
					click(misObj.marketinSightssubCategorySelectionBox);
					waitTill(2000);
				} else {
					click(misObj.marketinSightssubCategorySelectionBox);
					break;
				}
			}
			Select subCategories = new Select(misObj.marketinSightssubCategorySelectionBox);
			List<WebElement> subcatOptions = subCategories.getOptions();
			for (int j = 1; j < subcatOptions.size(); j++) {
				click(subcatOptions.get(j));
				waitTill(5000);
				
				if (!getText(misObj.marketinSightSearchResultArea).equals("There were no leads for this (sub)category in the last week.")
						&& misObj.marketinSightfilterResultscount.size()>1) {
					int totalAds=misObj.marketinSightfilterResultscount.size();
					int leadsCountofFirstAd=Integer.parseInt(getText(misObj.marketinSightLeadsCount.get(0)).trim().replace(" leads", ""));
					int leadsCounofLastAd=Integer.parseInt(getText(misObj.marketinSightLeadsCount.get(totalAds-1)).trim().replace(" leads", ""));
					Assert.assertTrue(leadsCountofFirstAd>=leadsCounofLastAd, 
							"Leads count of 1st Ad is less than leads count of last Ad for"+ getText(subcatOptions.get(j))+"of"+ getText(catOptions.get(i)) );
				}
				}
			}
		}
	public void waitForElementLoading(WebElement location_ele, WebElement verification_ele) throws Exception
	{
		int count = 0;
		while (count < 10) {
			click(location_ele);
			if (!verifyElementPresent(verification_ele)) {
				click(location_ele);
				waitTill(2000);
				count++;
			} else {
				click(location_ele);
				break;
			}
			if(count==9)
			{
				throw new Exception(verification_ele+" not found");
			}
		}
	}
}
