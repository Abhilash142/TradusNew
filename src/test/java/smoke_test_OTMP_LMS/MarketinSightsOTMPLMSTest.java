package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userName;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.MarketinSightsOTMPLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class MarketinSightsOTMPLMSTest extends BaseClass{
	/*
	 * Description: Verify market insights page is displaying on clicking the link from menu
	 */
	@Test
	public void verifyMarketInsightsPageisDisplayingonClickingtheLinkfromMenu() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewPage.doLogIn(testUserPL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.marketInsightOptioninSiderBar);
	    jsClick(driver, overviewPage.marketInsightOptioninSiderBar);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.marketInsightOptioninSiderBar);
		Assert.assertTrue(verifyElementPresent(overviewPage.marketInsightOptioninSiderBar),
				"Market insights page is not displaying by clicking on profile link on sidebar");
	}
	
	/*
	 * Description: Verify all the top leads makes are displaying randomly if category is not selected
	 */
	@Test
	public void verifyalltheTopLeadsMakesaredisplayingrnadomlyifCategoryisnotSelected() throws Exception
	{
	    MarketinSightsOTMPLMSPage misObj=new MarketinSightsOTMPLMSPage(driver);
	    if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/market-insights")) {
	    	misObj.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/market-insights");
		}
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
	 * Description:Verify make name, leads and statistics since last week and month are displaying
	 */
	//@Test(priority=3)
	public void verifyaMakenameLeadsStatisticsinResults() throws Exception
	{
	    MarketinSightsOTMPLMSPage misObj=new MarketinSightsOTMPLMSPage(driver);
	    if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/market-insights")) {
	    	misObj.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/market-insights");
		}
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		waitTill(1000);
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

}
