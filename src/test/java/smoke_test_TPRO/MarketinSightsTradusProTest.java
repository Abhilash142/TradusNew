package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.MarketinSightsTradusProPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

public class MarketinSightsTradusProTest extends BaseClass{
	/*
	 * Description: Verify market insights page is displaying on clicking the link from menu
	 */
	@Test
	public void verifyNavigationtoMarketInsightpageOnClickingLinkformMenu() throws Exception
	{
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		jsClick(driver,overviewObj.marketInsightOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightpageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/market-insights"), 
				"Market insight page is not displaying");
	}
	/*
	 * Description: Verify all the top leads makes are displaying randomly if category is not selected
	 */
	@Test
	public void verifyalltheTopLeadsMakesaredisplayingrnadomlyifCategoryisnotSelected() throws Exception
	{
		MarketinSightsTradusProPage misObj=new MarketinSightsTradusProPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/market-insights")) {
			misObj.doLogIn(userName,pwd);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/market-insights");
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
	 * Description: Verify make name, leads and statistics since last week and month are displaying
	 */
	/*@Test
	public void verifyaMakenameLeadsStatisticsinResults() throws Exception
	{
		MarketinSightsTradusProPage misObj = new MarketinSightsTradusProPage(driver);
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
		 }
        cmdObj.login(userName,pwd);
        explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		try {
			explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/market-insights");
			}
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		WebElement[] subcatVerficationElements = { misObj.transportsubCategoryVerificationElement,
				misObj.farmsubCategoryVerificationElement, misObj.constructionsubCategoryVerificationElement,
				misObj.sparePatrssubCategoryVerificationElement, misObj.MHEsubCategoryVerificationElement,
				misObj.PEMTsubCategoryVerificationElement };
		explicitWaitFortheElementTobeVisible(driver,misObj.marketInsightpageVerificationElement);
		Select categories = new Select(misObj.marketinSightsCategorySelectionBox);
		int a=0;
		while (a<5) {
			try{
				click(misObj.marketinSightsCategorySelectionBox);
			}catch(Exception e) {
				jsClick(driver,misObj.marketinSightsCategorySelectionBox);
			}
			if (!verifyElementPresent(misObj.marketinSightCategoryDropdownVerificationElement)) {
				try {
				click(misObj.marketinSightsCategorySelectionBox);
				}catch(Exception e) {
					jsClick(driver,misObj.marketinSightsCategorySelectionBox);
				}
				waitTill(2000);
				a++;
				if(a==5) {
					Assert.assertEquals(10,5,"Material Handling Equipment option isn't present under category dropdown in market insight page");
				}
				}
					
				
			 else {
				try {
				click(misObj.marketinSightsCategorySelectionBox);
				}catch(Exception e) {
					jsClick(driver,misObj.marketinSightsCategorySelectionBox);
				}
				break;
			}
		}
		
		List<WebElement> catOptions = categories.getOptions();
		for (int i = 1; i < catOptions.size(); i++) {
			try {
			click(catOptions.get(i));
			}catch(Exception e) {
				jsClick(driver,catOptions.get(i));
			}
			waitTill(2000);
			int b=0;
			while (b<5) {
				try {
				click(misObj.marketinSightssubCategorySelectionBox);
				}catch(Exception e) {
					jsClick(driver,misObj.marketinSightssubCategorySelectionBox);
				}
				if (!verifyElementPresent(subcatVerficationElements[i - 1])) {
					waitTill(1000);
					try {
					click(misObj.marketinSightssubCategorySelectionBox);
					}catch(Exception e) {
						jsClick(driver,misObj.marketinSightssubCategorySelectionBox);
					}
					waitTill(2000);
					b++;
					if(b==5) {
						Assert.assertEquals(10,5,"Subcategory verification element isn't present under sub-category dropdown in market insight page");
					}
				} else {
					try {
					click(misObj.marketinSightssubCategorySelectionBox);
					}catch(Exception e) {
						jsClick(driver,misObj.marketinSightssubCategorySelectionBox);
					}
					break;
				}
			}
			Select subCategories = new Select(misObj.marketinSightssubCategorySelectionBox);
			List<WebElement> subcatOptions = subCategories.getOptions();
			for (int j = 1; j < subcatOptions.size(); j++) {
				try {
				click(subcatOptions.get(j));
				}catch(Exception e) {
					jsClick(driver,subcatOptions.get(j));
				}
				// WebDriverWait wait=new WebDriverWait(driver, 10);
				// wait.until(ExpectedConditions.or(
				// ExpectedConditions.visibilityOf(misObj.marketinSightCnfNoResultsVerificationElement),
				// ExpectedConditions.visibilityOf(misObj.marketinSightCnfResultsVerificationElement)));
				waitTill(2000);
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
		cmdObj.logOut();
		explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
	}*/
}
