package sanity_test_TPRO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.core.TestListenersClass;
import com.tradus.pro.pages.AllStockTradusPROPage;
import com.tradus.pro.pages.CreateStockTradusProPage;
import com.tradus.pro.pages.LeadsTradusPROPPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import static com.tradus.core.ActionElementClass.switchWindow;


public class OverviewPageTradusProTest extends BaseClass {
	
	/*
	 * Description: Verify overview page is displaying after login to the account
	 */
	@Test(priority=0)
	public void verifyOverviewPageAfterLoginToAccount() throws Exception {
		LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(testUser,pwd);
		click(loginPage.LoginButton);
		waitTill(3000);
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(7000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"),
	    		"Overview page is not displaying after login to account");
	}
	
	/*
	 * Description: Verify Tradus pro logo along with enabled radio button is displaying to the left side 
	 */
	@Test(priority=1)
	public void verifyTradusProLogoAlongWithEnabledRadioButtonToTheLeftSide() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
        Assert.assertTrue(verifyElementPresent(overviewPage.tradusProLogo), "Tradus logo is not displaying after login to account");
        Assert.assertTrue(verifyElementPresent(overviewPage.togglerUnderLogo), "Enabled radio button is not displaying after login to account");
	}
    /*
	 * Description: Verify Leads, My stock(Create, all), Market insights, profile, 
 	 * Monthly package and contact (Terms of user, Privacy policy and contact) links are displaying in the left side menu
	 */
	@Test(priority=2)
	public void verifyPresenceOfLinksinLeftsideMenu() throws Exception {
		
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewObj.overviewOptioninSiderBar),
				"Overview option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.leadsOptioninSiderBar),
				"Leads option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.myStockOptioninSiderBar),
				"My stock option is not present in side bar");
		click(overviewObj.myStockOptioninSiderBar);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.allMyStockOptioninSiderBar);
		Assert.assertTrue(verifyElementPresent(overviewObj.createMyStockOptioninSiderBar),
				"Create my stock option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.allMyStockOptioninSiderBar),
				"All my stock option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.marketInsightOptioninSiderBar),
				"Market insight option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.profileOptioninSiderBar),
				"Profile option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.monthlyPackageOptioninSiderBar),
				"Monthly package option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.contactOptioninSiderBar),
				"Contact option is not present in side bar");
		click(overviewObj.contactOptioninSiderBar);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.privacyOptionunderContactlinkSiderBar);
		Assert.assertTrue(verifyElementPresent(overviewObj.termsOptionunderContactlinkSiderBar),
				"Terms link under Contact option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.privacyOptionunderContactlinkSiderBar),
				"Privacy link under Contact option is not present in side bar");
		Assert.assertTrue(verifyElementPresent(overviewObj.contactOptionunderContactlinkSiderBar),
				"Contact link under Contact option is not present in side bar");
	}
	
	/*
	 * Description: Verify redirecting to respective pages on clicking the above links
	 */
	@Test
	public void verifyNavigationonClickingLinksfromSideMenu() throws Exception {
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		try {
		click(overviewObj.overviewOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.overviewOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"), 
				"Overview page not displayed");
		try {
		click(overviewObj.leadsOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.leadsOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/leads"), 
				"Leads page not displayed");
		try {
		click(overviewObj.myStockOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.myStockOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.allMyStockOptioninSiderBar);
		try {
		click(overviewObj.createMyStockOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.createMyStockOptioninSiderBar);
		}
		
		explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads/create"), 
				"Create stock page not displayed");
		try {
		click(overviewObj.allMyStockOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.allMyStockOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads"), 
				"All stock page not displayed");
		try {
		click(overviewObj.marketInsightOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.marketInsightOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightpageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/market-insights"), 
				"Market insight page is not displaying");
		try {
		click(overviewObj.profileOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.profileOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"), 
				"Profile page is not displaying");
		
		try {
		click(overviewObj.subscriptionDetailsinSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.subscriptionDetailsinSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.monthlyPackageOptioninSiderBar);
		try {
			click(overviewObj.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewObj.monthlyPackageOptioninSiderBar);
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.monthlyPackagePageVerificationElement);
			Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/subscription-details"), 
					"Monthly package page is not displaying");
		explicitWaitFortheElementTobeVisible(driver,overviewObj.billingButtonunderMonthlyPackage);
		try {
		click(overviewObj.billingButtonunderMonthlyPackage);
		}catch(Exception e) {
			jsClick(driver,overviewObj.billingButtonunderMonthlyPackage);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.billingPageverificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/billing"), 
				"Billing page is not displaying");
		
		explicitWaitFortheElementTobeVisible(driver,overviewObj.contactsLinkUnderSubscriptionDetails);
		try {
		click(overviewObj.contactsLinkUnderSubscriptionDetails);
		}catch(Exception e) {
			jsClick(driver,overviewObj.contactsLinkUnderSubscriptionDetails);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.contactsLinkVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/contracts"), 
				"Contacts page under Subscription Details is not displaying");
		/*try {
			click(overviewObj.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewObj.monthlyPackageOptioninSiderBar);
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.monthlyPackagePageVerificationElement);
			Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/subscription-details"), 
					"Monthly package page is not displaying");*/
		try {
		click(overviewObj.contactOptioninSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.contactOptioninSiderBar);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.privacyOptionunderContactlinkSiderBar);
		String parentWindow=driver.getWindowHandle();
		try {
		click(overviewObj.termsOptionunderContactlinkSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.termsOptionunderContactlinkSiderBar);
		}
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(overviewObj.termsPageVerificationElement), 
				"Terms page is not displaying");
		driver.close();
		driver.switchTo().window(parentWindow);
		try {
		click(overviewObj.privacyOptionunderContactlinkSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.privacyOptionunderContactlinkSiderBar);
		}
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(overviewObj.privacyPolicayPageVerificationElement), 
				"Privacy page is not displaying");
		driver.close();
		driver.switchTo().window(parentWindow);
		try {
		click(overviewObj.contactOptionunderContactlinkSiderBar);
		}catch(Exception e) {
			jsClick(driver,overviewObj.contactOptionunderContactlinkSiderBar);
		}
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(overviewObj.conatctPageVerificationElement), 
				"Contact page is not displaying");
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	/*
	 * Description: Verify overview, leads, Create, my stocks, profil and star icons are displaying at header
	 * Verify redirecting to respective pages on clicking the above links
     *  Also, Verify search field is displaying with all the suggestions on clicking the star icon
	 */
	@Test(priority=4)
	public void verifyPresenceOfHeaderIconsinOverviewPage() throws Exception {
		
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		List<WebElement> headerIcons=overviewObj.pageheaderIcons;
		for(int i=0;i<headerIcons.size();i++) {
        switch(i)
        {
        case 0:
		     Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		     Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"), 
				"Overview page not displayed");
        break;
        case 1:
             Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/leads"), 
						"Leads page not displayed");
        break;
        case 2:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads"), 
						"All stock page not displayed");
       break;
       case 3:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads/create"), 
						"Create stock page not displayed");
       break;
       case 4:
           Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"), 
						"Profile page is not displaying");
      break;
		}
		}
		Assert.assertTrue(verifyElementPresent(overviewObj.startIconOnPageHeader), 
				"Star icon missing from header");
		click(overviewObj.startIconOnPageHeader);
		waitTill(3000);
		Assert.assertTrue(verifyElementPresent(overviewObj.startIconSearchField),
				"Search box under star icon is nor displaying");
		List<WebElement> suggestions=overviewObj.startIconSuggestionLists;
		for(int i=0;i<suggestions.size();i++) {
			
		switch(i) {
		case 0:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("overview"),
					"Overview option is not displayed under star icon suggestion list");
			break;
		case 1:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("leads"),
					"Leads option is not displayed under star icon suggestion list");
			break;
			
		case 2:
			waitTill(2000);
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("myStock"),
					"MyStock option is not displayed under star icon suggestion list");
			break;
		case 3:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("addStock"),
					"Add Stock option is not displayed under star icon suggestion list");
			break;
		case 4:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("profile"),
					"Profile option is not displayed under star icon suggestion list");
			break;
		}
		}
	}
	
	/*
	 * Description: Verify English language is displaying at the right side in header
	 */
	@Test(priority=5)
	public void verifyEnglishlangDisplayingatRightSideinOverviewpageHeader() throws Exception {
		
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue(getText(overviewObj.languageAtHeader).trim().equals("English"),
				"English language is not displaying at the right side header");
	}
	
	/*
	 * Description: Verify the remaining languages are displaying on clicking the drop down
	 */
	@Test(priority=6)
	public void verifyRemaininglanguagedisplaysOnclickingLanguageDropdown() throws Exception {
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		click(overviewObj.languageAtHeader);
		String[] expectedLangOptions= {"Deutsch","English","Español","Français","Italiano","Nederlands","Polski","Português","Română","Русский"};
		List<WebElement> availableLangOptions=overviewObj.languageDropdownOptionsList;
		for(int i=0;i<expectedLangOptions.length;i++) {
			Assert.assertTrue(expectedLangOptions[i].equals(availableLangOptions.get(i).getText().trim()),
					expectedLangOptions[i]+" is not present in lang dropdown");
		}
	}
	/*
	 * Description: "Verify Popular ads text along with 'Image', 'ID', 'Title', 'Category',
	 *  'Created on', 'Visits', and 'Leads' are displaying 
	 */
	@Test(priority=8)
	public void verifyPresneceOfPopularAdsHeaders() throws Exception {
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue((getText(overviewObj.popularAdsText)).trim().equals("Popular ads"),
				"Popular Ads is not displaying in overview page");
		waitTill(2000);
		String[] expectedHeaders= {"Image","ID","Title","Category","Created on","Visits","Leads"};
		List<WebElement> actualHeaders=overviewObj.popularAdHeaders;
		for(int i=0;i<expectedHeaders.length;i++) {
			Assert.assertEquals(actualHeaders.get(i).getText().trim(), expectedHeaders[i],
					expectedHeaders[i]+" is not present.");
		}
	}
	
	/*
	 * Description: Verify visits per country data initally 'No data available' text displays
	 */
	@Test(priority=9)
	public void verifyNodataAvailableunderVisitsperCountryInitially() throws Exception {
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue(getText(overviewObj.visitsPerCountryText).trim().equals("Visits per country"),
				"Visits per country text not present");
		waitTill(2000);
		Assert.assertTrue(getText(overviewObj.visitsPerPageContent).trim().equals("No Data Available"),
				"No Data Available is not displaying under Visits per country tab initially");
	}
	
	/*
	 * Description: Verify overview link is highlghted by default 
	 */
	@Test(priority=10)
	public void verifyOverviewLinIsHighlightedByDefaultAfterLogin() throws Exception {
		OverviewTradusPROPage overviewObj= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewLinkOnSideBar);
	    Assert.assertTrue(getText(overviewObj.highlightedTab).equals("Overview"),
				"Overview link is not highlighted by default");
	}
	
	/*
	 * Description: Verify redirecting to respective pages on clicking the suggestions under star icon dropdown
	 */
	@Test(priority=11)
	public void verifyRedirectionOfSuggestionsInDropdownUnderStarIcon() throws Exception {
		OverviewTradusPROPage overviewObj = new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, overviewObj.overviewLinkOnSideBar);
		click(overviewObj.startIconOnPageHeader);
		waitTill(2000);
		for (int i = 0; i < overviewObj.startIconSuggestionLists.size(); i++) {
			new Actions(driver).moveToElement(overviewObj.startIconSuggestionLists.get(i)).click().build().perform();
			// jsClick(driver,overviewObj.startIconSuggestionLists.get(i));
			switch (i) {
			case 0:
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver, overviewObj.overviewPageVerificationElement);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"),
						"Overview page is not displaying by clicking on overview option under star icon dropdown list");
				break;

			case 1:
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver, overviewObj.leadsPageVerificationElement);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/leads"),
						"Leads page is not displaying by clicking on leads option under star icon dropdown list");
				break;

			case 2:
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver, overviewObj.allStockPageVerificationElement);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads"),
						"My stock page is not displaying by clicking on my stock option under star icon drodown list");
				break;

			case 3:
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver, overviewObj.createStockPageVerificationElement);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads/create"),
						"Add stock page is not displaying by clicking on add stock option under star icon dropdown list");
				break;

			case 4:
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver, overviewObj.profilePageVerificationElement);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"),
						"Profile page is not displaying by clicking on profile option under star icon dropdown list");
				break;
			}
			driver.navigate().refresh();
			waitForElement(overviewObj.overviewLinkOnSideBar);
			click(overviewObj.startIconOnPageHeader);
			waitTill(4000);
		}
	}

	
	/*
	 * Description: Verify suggestions are disappearing on enabling star icon beside the suggestions in search field
	 */
	@Test(priority=12)
	public void verifySuggestionsAreDisappearingByEnablingStarIconOnSuggestionInDropDown() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.startIconOnPageHeader);
	    click(overviewPage.startIconOnPageHeader);
	    int size=overviewPage.startIconSuggestionLists.size();
	    for (int i=0;i<size;i++)
	    {
	    click(overviewPage.starIconsOnSuggestions);
	    waitTill(2000);
	    switch(i) {
	    case 0:
		    Assert.assertFalse(verifyElementPresent(overviewPage.overviewInStartIconSuggestionList),
		    		"overview suggestion not disappeared by clicking on star icon on suggestions");
		    Assert.assertFalse(verifyElementPresent(overviewPage.overviewIconOnHeaderSection),
		    		"overview suggestion on header not disappeared by clicking on star icon on suggestions"); 
		    break;
	    case 1:
		    Assert.assertFalse(verifyElementPresent(overviewPage.leadsInStartIconSuggestionList),
		    		"leads suggestion not disappeared by clicking on star icon on suggestions");
		    Assert.assertFalse(verifyElementPresent(overviewPage.leadsIconOnHeaderSection),
		    		"leads suggestion on header not disappeared by clicking on star icon on suggestions");
		    break;
	    case 2:
		   Assert.assertFalse(verifyElementPresent(overviewPage.myStockInStartIconSuggestionList),
		    		"my stock suggestion not disappeared by clicking on star icon on suggestions");
		    Assert.assertFalse(verifyElementPresent(overviewPage.mystockIconOnHeaderSection),
		    		"my stock suggestion on header not disappeared by clicking on star icon on suggestions");
		    break;
	    case 3:
		  Assert.assertFalse(verifyElementPresent(overviewPage.addStockInStartIconSuggestionList),
		    	"add stock suggestion not disappeared by clicking on star icon on suggestions");
		    Assert.assertFalse(verifyElementPresent(overviewPage.addstockIconOnHeaderSection),
		    		"add stock suggestion on header not disappeared by clicking on star icon on suggestions");
		    break;
	    case 4:
		  Assert.assertFalse(verifyElementPresent(overviewPage.profileInStartIconSuggestionList),
		    	"profile suggestion not disappeared by clicking on star icon on suggestions");
		    Assert.assertFalse(verifyElementPresent(overviewPage.profileIconOnHeaderSection),
		    		"profile suggestion on header not disappeared by clicking on star icon on suggestions");
		    break;
	    }
		}
	    }

	/*
	 * Description: Verify the search icon is displaying in header
	 */
	@Test(priority=13)
	public void verifySearchIconIsDisplayingOnHeader() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.SearchIconOnHeader);
        Assert.assertTrue(verifyElementPresent(overviewPage.SearchIconOnHeader), "Search icon is not displaying on header");
	}
	
	/*
	 * Description: Verify search field is displaying with search place holder text and cross icon on clicking search icon
	 */
	@Test(priority=14)
	public void verifySearchFieldDisplayedAlongWithPlaceHolderTextAndCrossIconByClickingSeachIcon() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.SearchIconOnHeader);
		click(overviewPage.SearchIconOnHeader);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(overviewPage.SearchFieldOnHeader),
				"Search field is not displaying upon clicking search icon on header");
		Assert.assertTrue(getText(overviewPage.SearchFieldOnHeader).equals("Search..."),
				"Place holder text is not displaying on search field by clicking on search icon");
		Assert.assertTrue(verifyElementPresent(overviewPage.crossIconOnSearchField),
				"Cross icon is not displaying on search field upon clicking search icon on header");

	}
	
	/*
	 * Description: Verify search field is closed on clicking cross icon 
	 */
	@Test(priority=15)
	public void verifySearchFieldOnHeaderIsClosedByClickingOnCrossIcon() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.SearchIconOnHeader);
		click(overviewPage.SearchIconOnHeader);
		waitTill(2000);
		click(overviewPage.crossIconOnSearchField);
		waitTill(2000);
		Assert.assertFalse(verifyElementPresent(overviewPage.SearchFieldOnHeader),
				"Search field is displaying even after clicking on cross icon");

	}
	
	/*
	 * Description: Verify default logo is displaying if particular user is not haivng logo 
	 */
	@Test(priority = 17)
	public void verifyDefaultLogoOnHeaderIfSellerNotHavingLogo() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.sellerLogoonHeader);
		waitTill(3000);
		Assert.assertTrue(
				overviewPage.sellerLogoonHeader.getAttribute("src")
						.equals("https://pro.tradus.com/0854b2c5928a20a22ac79d7bce5b1b99.svg"),
				"Default logo is not displaying on header");
	}
	
	/*
	 * Description: Verify 'Profile' and 'Logout' options are displaying on clicking profile icon in header 
	 */
	@Test(priority=18)
	public void verifyProfileAndLogoutOptionsByClickingProfileIconOnHeader() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileIconOnHeader);
	    click(overviewPage.profileIconOnHeader);
	    waitTill(2000);
	    Assert.assertTrue(getText(overviewPage.profileOptionInProfileIconDropdown).equals("Profile"),
				"Profile option is not displaying in dropdown by clicking on profile icon");
	    Assert.assertTrue(getText(overviewPage.logoutOptionInProfileIconDropdown).equals("Log out"),
				"Logout option is not displaying in dropdown by clicking on profile icon");
	}
	
	/*
	 * Description: Verify redirecting to respective pages on clicking the above links 
	 */
	@Test(priority=19)
	public void verifyRedirectionOfProfileAndLogoutOptions() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileIconOnHeader);
	    click(overviewPage.profileIconOnHeader);
	    waitTill(1000);
	    click(overviewPage.profileOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profilePageVerificationElement);
	    waitTill(2000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"),
	    		"Profile page is not displaying by clicking on profile option under profile icon dropdown list");
	    click(overviewPage.logoutOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.LoginText);
	    waitTill(2000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/login"),
	    		"User not logged out from account by cicking on logout option in dropdown");
	}
	
	
	
	
	/*
	 * Description: Verify seller name along with their logo is displaying in header 
	 */
	@Test(priority=20)
	public void verifySellerNameAlongWithTheirLogoOnHeader() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		waitTill(3000);
		LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.sellerLogoonHeader);
		waitTill(3000);
		Assert.assertTrue(getText(overviewPage.sellerNameonHeader).equals("Harry"),
				"Seller name is not displaying on header");
		Assert.assertTrue(overviewPage.sellerLogoonHeader.getAttribute("src").contains("https://images.tradus.com/v1/7b0d2469-d8c1-4a6e-ab2b-1818e3566ed5.jpg"),
				"Seller logo is not displaying on header");	
	}
	
	/*
	 * Description: "Verify 'Total number of active ads','Total number of visits' 
	 * and 'Total of leads' along with icons and count are displaying 
	 */
	@Test(priority=22)
	public void verifyActiveAdsVistsLeadsCountandIconsaredisplaying() throws Exception {
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		/*LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword("harish.boyapati+0122@olx.com", "sunfra123");
		click(loginPage.LoginButton);*/
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		waitTill(2000);
		//for ActiveAds
		Assert.assertTrue(getText(overviewObj.totalActiveAdsText).trim().equals("Total number of active ads"),
				"Total number of active Ads text is not displaying");
		Assert.assertTrue(verifyElementPresent(overviewObj.iconInActiveAdsCountSection),
				"Icon is not displaying for total number of active Ads");
		waitTill(1000);
		Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalActiveAdsCount).trim())>0,
				"Total number of active Ads count is incorrect");
		
		//for visits
		Assert.assertTrue(getText(overviewObj.totalVisitsText).trim().equals("Total of visits"),
				"Total number of visit text is not displaying");
        Assert.assertTrue(verifyElementPresent(overviewObj.iconInVisitesCountSection),
				"Icon is not displaying for total number of visits");
        Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalVisitsCount).trim())>0,
				"Total number of visit count is incorrect");
      //for Leads
      	Assert.assertTrue(getText(overviewObj.totalLeadsText).trim().equals("Total of leads"),
      						"Total number of Leads text is not displaying");
      	Assert.assertTrue(verifyElementPresent(overviewObj.iconInTotalLeadsCountSection),
      						"Icon is not displaying for total number of Leads");
      	Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalLeadsCount).trim())>0,
      					"Total number of Leads count is incorrect");
	
	}
	
	/*
	 * Description: Verify published ad is displaying below 'Popular ads' 
	 */
	@Test(priority=23)
	public void verifyPublishedAdisDisplayingBelowPopularAds() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
		/*waitTill(3000);
		LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.sellerLogoonHeader);
		waitTill(3000);*/
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileIconOnHeader);
	    waitTill(2000);
	    jsClick(driver,overviewPage.myStockOptioninSiderBar);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.allMyStockOptioninSiderBar);
	    jsClick(driver,overviewPage.allMyStockOptioninSiderBar);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.allStockPageVerificationElement);
	    verifyElementPresent(overviewPage.activeAdinStockListing);
        waitTill(2000);
        explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewOptioninSiderBar);
        jsClick(driver,overviewPage.overviewOptioninSiderBar);
        explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
        waitTill(3000);
        Assert.assertTrue(verifyElementPresent(overviewPage.activeAdsunderPopularAds), "Published Ad is not displaying in Popular Ads section.");
        
	}
	
	/*
	 * Description: Verify the count is displaying/updating propelry by publishing,
	 * visitng and generating the leads
	 */
	@Test(priority = 25)
	public void verifytheCountisDisplayingandUpdatingproperlyBypublishingVisitingandGeneratingLeads() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		waitTill(3000);
		/*LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		click(loginPage.LoginButton);*/
		explicitWaitFortheElementTobeVisible(driver, overviewPage.sellerLogoonHeader);
		waitTill(3000);
		int visitCountOnWebSite = Integer.parseInt(getText(overviewPage.visitsCountunderPopularAds));
		int leadsCountOnWebSite = Integer.parseInt(getText(overviewPage.leadsCountunderPopularAds));
		waitTill(3000);
		File popularAdsData = new File(System.getProperty("user.dir") + "\\PopularAdsStats.txt");
		if (!popularAdsData.exists()) {
			popularAdsData.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(popularAdsData));
		String st;int visit=0;int leads=0;
		while ((st = br.readLine()) != null)
		{
		String[] words=st.split("@");
		for(int i=0;i<=words.length;i++) {
			switch(i)
			{
			case 0:
				 visit=Integer.parseInt(words[i].replace("Number of visits =", "").trim());
				break;
			case 1:
				 leads=Integer.parseInt(words[i].replace("Number of Leads =", "").trim());
				break;
			}
		}
		}
		//System.out.println(visit+"  "+leads);
		
		Assert.assertTrue(visitCountOnWebSite>visit && leadsCountOnWebSite>leads, " Visits and Leads count are not updating properly under popular Ads section");
		
		FileWriter fw = new FileWriter(popularAdsData);
		String temp = "Number of visits = " + visitCountOnWebSite + "@";
		temp += "Number of Leads = " + leadsCountOnWebSite;
		fw.write(temp);
		waitTill(3000);
		if (fw != null)
			fw.close();
		LeadsTradusPROPPage leadsObj=new LeadsTradusPROPPage(driver);
		leadsObj.leadsGenerationinTPRO();
		
	}

	/*
	 * Description: Verify login page is displaying on clicking 'Logout' link 
	 */
	@Test(priority=26)
	public void verifyLoginPageByClickingOnLogoutOptionInDropdown() throws Exception {
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileIconOnHeader);
	    click(overviewPage.profileIconOnHeader);
	    waitTill(1000);
	    click(overviewPage.logoutOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.LoginText);
	    waitTill(1000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/login"),
	    		"Login Page is not displaying by cicking on logout option in dropdown");
	}
	
	/*
	 * Description: Verify page redirecting to 'Create ad' page on clicking 'start' button in the pop up
	 */
		//@Test(priority=27)
		public void verifyPageRedirectingToCreateAdPageOnClickingPostButtonInThePopup() throws Exception {
			OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
			waitTill(2000);
			LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
			loginPage.setAccountEmailAndPassword("harish.boyapati+0289@olx.com", "sunfra123");
			jsClick(driver, loginPage.LoginButton);
			waitTill(5000);
			if(!verifyElementPresent(overviewObj.PostYourAdButtonOnWelcomePopup))
			{
				driver.navigate().refresh();
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.PostYourAdButtonOnWelcomePopup);
			jsClick(driver, overviewObj.PostYourAdButtonOnWelcomePopup);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
			Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/lms/ads/create"),
						"Page not redirected to create ad page on clicking post button on welcome popup");
			jsClick(driver, overviewObj.overviewOptioninSiderBar);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		}
		
		/*
		 * Description: Verify pop up should close on clicking 'Cross icon', Verify pop up should not display once closing the pop up or after publishing the ad
		 */
		//@Test(priority=28)
		public void verifyPopupShouldCloseOnClickingCrossIcon() throws Exception {
			OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.CloseIconOnWelcomePopup);
			jsClick(driver, overviewObj.CloseIconOnWelcomePopup);
			Assert.assertFalse(verifyElementPresent(overviewObj.TradusWelcomeBox),
					"Welcome popup displaying even after clicking cross icon");
			jsClick(driver, overviewObj.profileOptioninSiderBar);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
			jsClick(driver, overviewObj.overviewOptioninSiderBar);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
			Assert.assertFalse(verifyElementPresent(overviewObj.TradusWelcomeBox),
					"Welcome popup displaying even after clicking cross icon");
			jsClick(driver, overviewObj.profileIconOnHeader);
		     explicitWaitFortheElementTobeVisible(driver, overviewObj.logoutOptionInProfileIconDropdown);
		     jsClick(driver, overviewObj.logoutOptionInProfileIconDropdown);
				}
		
		/*
		 * Description: Verify pop up should not display after publishing the ad
		 */
		//@Test(priority=29)
		public void verifyPopupShouldNotDisplayAfterPublishingTheAd() throws Exception {
			CreateStockTradusProPage createStockObj= new CreateStockTradusProPage(driver);
			AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
			OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
			waitTill(2000);
			LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
			loginPage.setAccountEmailAndPassword("harish.boyapati+0289@olx.com", "sunfra123");
			jsClick(driver, loginPage.LoginButton);
			waitTill(5000);
			if(!verifyElementPresent(overviewObj.PostYourAdButtonOnWelcomePopup))
			{
				driver.navigate().refresh();
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.TradusWelcomeBox);
			jsClick(driver, overviewObj.PostYourAdButtonOnWelcomePopup);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
			createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpeg");
			explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
			waitTill(1000);
			scrollToElement(driver, createStockObj.priceSectionInPostingForm);
			waitTill(3000);
			click(createStockObj.priceTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.priceTypeasFixed);
			waitTill(1000);
			if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("EUR")) {
				click(createStockObj.currencyTypeFieldPostingForm);
				waitTill(1000);
				actionClick(driver, createStockObj.currencyTypeasEuro);
			}
			sendKeys(createStockObj.netPriceFieldPostingForm, "10000");
			waitTill(1000);
			scrollToElement(driver, createStockObj.yourVehicleSectionInPostingForm);
			waitTill(2000);
			click(createStockObj.vehicleTypeFieldPostingForm);
			actionClick(driver, createStockObj.vehicleTypeasSpareParts);
			waitTill(3000);
			click(createStockObj.vehicleCategoryFieldPostingForm);
			actionClick(driver, createStockObj.vehicleCategoryasTires);
			waitTill(2000);
			click(createStockObj.vehicleMakeFieldPostingForm);
			actionClick(driver, createStockObj.vehicleMakeasVolvo);
			waitTill(3000);
			click(createStockObj.vehicleModelFieldPostingForm);
			actionClick(driver, createStockObj.vehicleModelas8700);
			waitTill(4000);
			sendKeys(createStockObj.descriptionAreainPostingForm, "Ad");
			jsClick(driver, createStockObj.postYourAdButton);
			explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
			jsClick(driver, overviewObj.overviewOptioninSiderBar);
			explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
			waitTill(5000);
			Assert.assertFalse(verifyElementPresent(overviewObj.TradusWelcomeBox),
					"Welcome popup displaying even after clicking cross icon");
		}

}
