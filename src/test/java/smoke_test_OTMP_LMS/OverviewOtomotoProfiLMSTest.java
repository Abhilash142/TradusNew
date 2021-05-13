package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.userNamePL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.LeadsOTMPLMSPage;
import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.otomotoProfi.LMS.pages.CommonMethod;

public class OverviewOtomotoProfiLMSTest extends BaseClass{
	/*
	 * Description:Verify overview page is displaying after login to the account
	 */
	@Test
	public void verifyOverviewPageAfterLoginToAccount() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/login")) {
			CommonMethod cmdObj=new  CommonMethod(driver);
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.emailNameElement);
		}
		loginPage.setAccountEmailAndPassword(userNamePL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms"),
	    		"Overview page is not displaying after login to account");
	}
	/*
	 * Description: Verify Otomotoprofi logo along with enabled radio button is displaying to the left side 
	 */
	@Test
	public void verifyOTMPLogoAlongWithEnabledRadioButtonToTheLeftSide() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewPage.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
	    waitTill(2000);
        Assert.assertTrue(verifyElementPresent(overviewPage.OTMPLMSLogo), "Otomoto logo is not displaying after login to account");
        Assert.assertTrue(verifyElementPresent(overviewPage.togglerUnderLogo), "Enabled radio button is not displaying after login to account");
	    Assert.assertFalse(getAttribute(overviewPage.togglerUnderLogo,"style").equals("display: none;"), "Side menu collapse radio button isn't enable");
	}
	
	/*
	 *  Description:Verify redirecting to respective pages on clicking the above links
	 */
	@Test
	public void verifyNavigationonClickingLinksfromSideMenu() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewOptioninSiderBar);
	    click(overviewObj.overviewOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms"), 
				"Overview page not displayed");
		click(overviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/leads"), 
				"Leads page not displayed");
		click(overviewObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.allMyStockOptioninSiderBar);
		click(overviewObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/ads/create"), 
				"Create stock page not displayed");
		click(overviewObj.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/ads"), 
				"All stock page not displayed");
		click(overviewObj.marketInsightOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.marketInsightpageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/market-insights"), 
				"Market insight page is not displaying");
		click(overviewObj.profileOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile"), 
				"Profile page is not displaying");
		try {
			click(overviewObj.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewObj.monthlyPackageOptioninSiderBar);
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.packageButtonunderMonthlyPackage);
			try {
				click(overviewObj.packageButtonunderMonthlyPackage);
				}catch(Exception e) {
					jsClick(driver,overviewObj.packageButtonunderMonthlyPackage);
				}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.monthlyPackagePageVerificationElement);
			Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/subscription-details"), 
					"Monthly package page is not displaying");
			explicitWaitFortheElementTobeVisible(driver,overviewObj.billingButtonunderMonthlyPackage);
			try {
			click(overviewObj.billingButtonunderMonthlyPackage);
			}catch(Exception e) {
				jsClick(driver,overviewObj.billingButtonunderMonthlyPackage);
			}
			explicitWaitFortheElementTobeVisible(driver,overviewObj.billingPageverificationElement);
			Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/billing"), 
					"Invoices page is not displaying");
		click(overviewObj.contactOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.privacyOptionunderContactlinkSiderBar);
		String parentWindow=driver.getWindowHandle();
		click(overviewObj.termsOptionunderContactlinkSiderBar);
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(overviewObj.termsPageVerificationElement), 
				"Terms page is not displaying");
		driver.close();
		driver.switchTo().window(parentWindow);
		click(overviewObj.privacyOptionunderContactlinkSiderBar);
		switchWindow(driver, parentWindow);
		/*explicitWaitFortheElementTobeVisible(driver,overviewObj.privacyPolicayPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewObj.privacyPolicayPageVerificationElement), 
				"Privacy page is not displaying");*/
		driver.close();
		driver.switchTo().window(parentWindow);
		click(overviewObj.contactOptionunderContactlinkSiderBar);
		switchWindow(driver, parentWindow);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.conatctPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewObj.conatctPageVerificationElement), 
				"Contact page is not displaying");
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	/*
	 * Description: Verify overview, leads, Create, my stocks, profil and star icons are displaying at header  and star icons are displaying at header
	 * Verify redirecting to respective pages on clicking the above links
     *  Also, Verify search field is displaying with all the suggestions on clicking the star icon
	 */
	@Test
	public void verifyPresenceOfHeaderIconsinOverviewPage() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    waitTill(2000);
	    List<WebElement> headerIcons=overviewObj.pageheaderIcons;
		for(int i=0;i<headerIcons.size();i++) {
        switch(i)
        {
        case 0:
		     Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		     Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms"), 
				"Overview page not displayed");
        break;
        case 1:
             Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/leads"), 
						"Leads page not displayed");
        break;
        case 2:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/ads"), 
						"All stock page not displayed");
       break;
       case 3:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/ads/create"), 
						"Create stock page not displayed");
       break;
       case 4:
           Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     click(headerIcons.get(i));
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile"), 
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
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("Overview"),
					"Overview option is not displayed under star icon suggestion list");
			break;
		case 1:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("Leads"),
					"Leads option is not displayed under star icon suggestion list");
			break;
			
		case 2:
			waitTill(2000);
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("My stock"),
					"MyStock option is not displayed under star icon suggestion list");
			break;
		case 3:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("Add stock"),
					"Add Stock option is not displayed under star icon suggestion list");
			break;
		case 4:
			Assert.assertTrue(getText(suggestions.get(i)).trim().equals("Profile"),
					"Profile option is not displayed under star icon suggestion list");
			break;
		}
		}
	}
	
	/*
	 * Description: Verify redirecting to respective pages on clicking the suggestions too
	 */
	@Test
	public void verifyredirectingtorespectivePagesonclinkingfromSuggestions() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.startIconOnPageHeader);
	    click(overviewObj.startIconOnPageHeader);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.startIconSuggestionListVerify);
		waitTill(1000);
		List<WebElement> suggestions=overviewObj.startIconSuggestionLists;
		int size=suggestions.size();
		waitTill(1000);
		click(overviewObj.startIconOnPageHeader);
		for(int i=0;i<size;i++) {
			click(overviewObj.startIconOnPageHeader);
		    explicitWaitFortheElementTobeVisible(driver,overviewObj.startIconSuggestionListVerify);
		    click(suggestions.get(i));
		    
			switch(i) {
			case 0:
				explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
				Assert.assertTrue(verifyElementPresent(overviewObj.popularAdsText),"User isn't navigating to Overview page on clicking Overview button from suggestions");
				break;
			
			case 1:
				explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
				Assert.assertTrue(verifyElementPresent(overviewObj.leadsPageVerificationElement),"User isn't navigating to Leads page on clicking Leads button from suggestions");
				break;
			
			case 2:
				explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
				Assert.assertTrue(verifyElementPresent(overviewObj.allStockPageVerificationElement),"User isn't navigating to All stocks page on clicking My stock button from suggestions");
				break;
				
			case 3:
				explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
				Assert.assertTrue(verifyElementPresent(overviewObj.createStockPageVerificationElement),"User isn't navigating to Create stocks page on clicking Create stock button from suggestions");
				break;
			
			case 4:
				explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
				Assert.assertTrue(verifyElementPresent(overviewObj.profilePageVerificationElement),"User isn't navigating to Profile page on clicking Profile button from suggestions");
				break;
		}
	}
 }
	

	/*
	 * Description: Verify search field is displaying with search place holder text and cross icon on clicking search icon
	 */
	@Test
	public void verifySearchFieldDisplayedAlongWithPlaceHolderTextAndCrossIconByClickingSeachIcon() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver, overviewObj.SearchIconOnHeader);
		click(overviewObj.SearchIconOnHeader);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(overviewObj.SearchFieldOnHeader),
				"Search field is not displaying upon clicking search icon on header");
		Assert.assertTrue(getText(overviewObj.SearchFieldOnHeader).equals("Search..."),
				"Place holder text is not displaying on search field by clicking on search icon");
		Assert.assertTrue(verifyElementPresent(overviewObj.crossIconOnSearchField),
				"Cross icon is not displaying on search field upon clicking search icon on header");
	}
	
	/*
	 * Description: Verify search field is closed on clicking cross icon 
	 */
	@Test
	public void verifySearchFieldOnHeaderIsClosedByClickingOnCrossIcon() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver, overviewObj.SearchIconOnHeader);
		click(overviewObj.SearchIconOnHeader);
		explicitWaitFortheElementTobeVisible(driver, overviewObj.crossIconOnSearchField);
		click(overviewObj.crossIconOnSearchField);
		waitTill(1000);
		Assert.assertFalse(verifyElementPresent(overviewObj.SearchFieldOnHeader),
				"Search field is displaying even after clicking on cross icon");
	}
	
	/*
	 * Description: Verify seller name along with their logo is displaying in header
	 */
	@Test
	public void verifySellerNameAlongWithTheirLogoOnHeader() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver, overviewObj.sellerLogoonHeader);
		waitTill(3000);
		Assert.assertTrue(getText(overviewObj.sellerNameonHeader).equals("Harry"),
				"Seller name is not displaying on header");
		System.out.println(overviewObj.sellerLogoonHeader.getAttribute("src"));
		Assert.assertTrue(overviewObj.sellerLogoonHeader.getAttribute("src").contains("https://images.tradus.com/v1"),
				"Seller logo is not displaying on header");	
	}
	/*
	 * Description: Verify redirecting to respective pages on clicking the above links 
	 */
	@Test
	public void verifyRedirectionOfProfileAndLogoutOptions() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.profileIconOnHeader);
	    click(overviewObj.profileIconOnHeader);
	    waitTill(1000);
	    click(overviewObj.profileOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
	    waitTill(2000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile"),
	    		"Profile page is not displaying by clicking on profile option under profile icon dropdown list");
	    click(overviewObj.logoutOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.loginPageVerify);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/login"),
	    		"User not logged out from account by cicking on logout option in dropdown");
	}
	/*
	 * Description: Verify 'Total number of active ads' , 'Total number of visits' and 'Total of leads' along with icons and count are displaying
     * Note: Initially the count will be zero for new users/no active ads
	 */
	@Test
	public void verifyActiveAdsVistsLeadsCountandIconsaredisplaying() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    waitTill(1000);
		//for ActiveAds
		Assert.assertTrue(getText(overviewObj.adsAvailabeforPublishingText).trim().equals("Total ads available for publishing"),
				"Total ads available for publishing text is not displaying");
		Assert.assertTrue(verifyElementPresent(overviewObj.iconInActiveAdsCountSection),
				"Icon is not displaying for total number of active Ads");
		waitTill(1000);
		/*
		 * Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalActiveAdsCount).
		 * trim())>0, "Total number of active Ads count is incorrect");
		 */
		Assert.assertTrue(getText(overviewObj.totalActiveAdsCount).trim().equals("1 out of 5"),"Total ads available for publishing count is incorrect");
		
		//for visits
		Assert.assertTrue(getText(overviewObj.totalVisitsText).trim().equals("Total of visits"),
				"Total number of visit text is not displaying");
        Assert.assertTrue(verifyElementPresent(overviewObj.iconInVisitesCountSection),
				"Icon is not displaying for total number of visits");
        Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalVisitsCount).trim())>=0,
				"Total number of visit count is incorrect");
      //for Leads
      	Assert.assertTrue(getText(overviewObj.totalLeadsText).trim().equals("Total of leads"),
      						"Total number of Leads text is not displaying");
      	Assert.assertTrue(verifyElementPresent(overviewObj.iconInTotalLeadsCountSection),
      						"Icon is not displaying for total number of Leads");
      	Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalLeadsCount).trim())>=0,
      					"Total number of Leads count is incorrect");	
	}
	
	/*
	 * Description: Verify Popular ads text along with 'Image', 'ID', 'Title', 'Category', 'Created on', 'Visits', and 'Leads' are displaying 
     * 
	 */
	@Test
	public void verifyPresneceOfPopularAdsHeaders() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,overviewObj.popularAdsText);
	    Assert.assertTrue((getText(overviewObj.popularAdsText)).trim().equals("Popular ads"),
				"Popular Ads is not displaying in overview page");
		waitTill(2000);
		String[] expectedHeaders= {"Image","ID","Title","Category","Created on","Visits(All time)","Leads(All time)"};
		List<WebElement> actualHeaders=overviewObj.popularAdHeaders;
		for(int i=0;i<expectedHeaders.length;i++) {
			Assert.assertEquals(actualHeaders.get(i).getText().replace("\n", "").trim(), expectedHeaders[i],
					expectedHeaders[i]+" is not present.");
		}
	}
	/*
	 * Description:Verify the count is displaying/updating propelry by publishing, visitng and generating the leads
	 */
	//@Test
	public void verifytheCountisDisplayingandUpdatingproperlyBypublishingVisitingandGeneratingLeads() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsCountunderPopularAds);
	    int visitCountOnWebSite = Integer.parseInt(getText(overviewObj.visitsCountunderPopularAds));
		int leadsCountOnWebSite = Integer.parseInt(getText(overviewObj.leadsCountunderPopularAds));
	    File adsStats=new File(System.getProperty("user.dir")+"\\PopularAdsStatsPL.txt");
	    BufferedReader br=new BufferedReader(new FileReader(adsStats));
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
		Assert.assertTrue(visitCountOnWebSite>=visit && leadsCountOnWebSite>=leads, " Visits and Leads count are not updating properly under popular Ads section");
		FileWriter fw = new FileWriter(adsStats);
		String temp = "Number of visits = " + visitCountOnWebSite + "@";
		temp += "Number of Leads = " + leadsCountOnWebSite;
		fw.write(temp);
		waitTill(2000);
		if (fw != null)
			fw.close();
		LeadsOTMPLMSPage LeadsObj=new LeadsOTMPLMSPage(driver);
		LeadsObj.leadsGenerationinOTMP();
	
	}
	
	/*
	 * Description: Verify published ad is displaying below 'Popular ads' 
	 */
	@Test
	public void verifyPublishedAdisDisplayingBelowPopularAds() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewObj.doLogIn(userNamePL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewObj.popularAdssection);
	    waitTill(1000);
	    Assert.assertTrue(verifyElementPresent(overviewObj.activeAdsunderPopularAds), "Active Ad isn't displaying under popular Ads in overview page");
	}
	

}
