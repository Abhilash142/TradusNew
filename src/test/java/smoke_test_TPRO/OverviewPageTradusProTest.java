package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LeadsTradusPROPPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

public class OverviewPageTradusProTest extends BaseClass {
	/*
	 * Description: Verify overview page is displaying after login to the account
	 */
	@Test
	public void verifyOverviewPageAfterLoginToAccount() throws Exception {
		LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/login")) {
			CommonMethod cmdObj=new  CommonMethod(driver);
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
		}
		loginPage.setAccountEmailAndPassword(userName,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"),
	    		"Overview page is not displaying after login to account");
	  
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
	@Test
	public void verifyPresenceOfHeaderIconsinOverviewPage() throws Exception {
		/*LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
		waitTill(3000);*/
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		List<WebElement> headerIcons=overviewObj.pageheaderIcons;
		for(int i=0;i<headerIcons.size();i++) {
        switch(i)
        {
        case 0:
		     Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
		     try {
		     click(headerIcons.get(i));
		     }catch(Exception e) {
		    	 jsClick(driver,headerIcons.get(i));
		     }
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		     Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"), 
				"Overview page not displayed");
        break;
        case 1:
             Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
             try {
		     click(headerIcons.get(i));
             }catch(Exception e) {
            	 jsClick(driver,headerIcons.get(i));
             }
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.leadsPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/leads"), 
						"Leads page not displayed");
        break;
        case 2:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
            try {
		     click(headerIcons.get(i));
            }catch(Exception e) {
            	jsClick(driver,headerIcons.get(i));
            }
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.allStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads"), 
						"All stock page not displayed");
       break;
       case 3:
            Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
            try {
		     click(headerIcons.get(i));
            }catch(Exception e)
            {
            	jsClick(driver,headerIcons.get(i));
            }
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.createStockPageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/ads/create"), 
						"Create stock page not displayed");
       break;
       case 4:
           Assert.assertTrue(verifyElementPresent(headerIcons.get(i)), 
					"icon missing from "+i+" place");
           try {
		     click(headerIcons.get(i));
           }catch(Exception e) {
        	   jsClick(driver,headerIcons.get(i));
           }
		     explicitWaitFortheElementTobeVisible(driver,overviewObj.profilePageVerificationElement);
			 Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"), 
						"Profile page is not displaying");
      break;
		}
		}
		Assert.assertTrue(verifyElementPresent(overviewObj.startIconOnPageHeader), 
				"Star icon missing from header");
		try {
		click(overviewObj.startIconOnPageHeader);
		}
		catch(Exception e) {
			jsClick(driver,overviewObj.startIconOnPageHeader);
		}
		waitTill(3000);
		Assert.assertTrue(verifyElementPresent(overviewObj.startIconSearchField),
				"Search box under star icon is nor displaying");
		List<WebElement> suggestions=overviewObj.startIconSuggestionLists;
		for(int i=0;i<suggestions.size();i++) {
			
			switch (i) {
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
	 * Description: "Verify Popular ads text along with 'Image', 'ID', 'Title', 'Category',
	 *  'Created on', 'Visits', and 'Leads' are displaying 
	 */
	@Test
	public void verifyPresneceOfPopularAdsHeaders() throws Exception {
		/*
		 * LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		 * loginPage.setAccountEmailAndPassword(userName,pwd); try {
		 * click(loginPage.LoginButton); }catch(Exception e) {
		 * jsClick(driver,loginPage.LoginButton); } waitTill(3000);
		 */
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		Assert.assertTrue((getText(overviewObj.popularAdsText)).trim().equals("Popular ads"),
				"Popular Ads is not displaying in overview page");
		waitTill(1000);
		String[] expectedHeaders= {"Image","ID","Title","Category","Created on","Visits(All time)","Leads(All time)"};
		List<WebElement> actualHeaders=overviewObj.popularAdHeaders;
		for(int i=0;i<expectedHeaders.length;i++) {
			Assert.assertEquals(actualHeaders.get(i).getText().replace("\n", "").trim(), expectedHeaders[i],
					expectedHeaders[i]+" is not present.");
		}
	}
	
	/*
	 * Description: Verify search field is displaying with search place holder text and cross icon on clicking search icon
	 */
	@Test
	public void verifySearchFieldDisplayedAlongWithPlaceHolderTextAndCrossIconByClickingSeachIcon() throws Exception {
	/*	LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
		waitTill(3000);*/
		OverviewTradusPROPage overviewObj=new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, overviewObj.SearchIconOnHeader);
		try {
		click(overviewObj.SearchIconOnHeader);
		}catch(Exception e) {
			jsClick(driver,overviewObj.SearchIconOnHeader);
		}
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(overviewObj.SearchFieldOnHeader),
				"Search field is not displaying upon clicking search icon on header");
		Assert.assertTrue(getText(overviewObj.SearchFieldOnHeader).equals("Search..."),
				"Place holder text is not displaying on search field by clicking on search icon");
		Assert.assertTrue(verifyElementPresent(overviewObj.crossIconOnSearchField),
				"Cross icon is not displaying on search field upon clicking search icon on header");
	}
	
	/*
	 * Description: Verify redirecting to respective pages on clicking the above links 
	 */
	@Test
	public void verifyRedirectionOfProfileAndLogoutOptions() throws Exception {
		/*
		 * LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		 * loginPage.setAccountEmailAndPassword(userName,pwd); try {
		 * click(loginPage.LoginButton); }catch(Exception e) {
		 * jsClick(driver,loginPage.LoginButton); }
		 */
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewPage.doLogIn(userName,pwd);
		}
		
		//LoginTradusPROPage loginPage= new LoginTradusPROPage(driver);
		/*loginPage.setAccountEmailAndPassword("harish.boyapati.sunfra@gmail.com", "sunfra123");
		click(loginPage.LoginButton);*/
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileIconOnHeader);
	    try {
	    click(overviewPage.profileIconOnHeader);
	    }catch(Exception e) {
	    	jsClick(driver,overviewPage.profileIconOnHeader);
	    }
	    waitTill(1000);
	    try {
	    click(overviewPage.profileOptionInProfileIconDropdown);
	    }catch(Exception e) {
	    	jsClick(driver,overviewPage.profileOptionInProfileIconDropdown);
	    }
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profilePageVerificationElement);
	    waitTill(2000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile"),
	    		"Profile page is not displaying by clicking on profile option under profile icon dropdown list");
	    /*try {
	    click(overviewPage.logoutOptionInProfileIconDropdown);
	    }catch(Exception e) {
	    	jsClick(driver,overviewPage.logoutOptionInProfileIconDropdown);
	    }
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.LoginText);
	    waitTill(2000);
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/login"),
	    		"User not logged out from account by cicking on logout option in dropdown");*/
	    

	}
	
	/*
	 * Description: "Verify 'Total number of active ads','Total number of visits' 
	 * and 'Total of leads' along with icons and count are displaying [Ex:harish.boyapati+0122@olx.com, sunfra123]
	 */
	@Test
	public void verifyActiveAdsVistsLeadsCountandIconsaredisplaying() throws Exception {
		OverviewTradusPROPage overviewObj= new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewObj.doLogIn(userName,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewObj.overviewPageVerificationElement);
		//for ActiveAds
		Assert.assertTrue(getText(overviewObj.adsAvailabeforPublishingText).trim().equals("Total ads available for publishing"),
				"Total ads available for publishing text is not displaying");
		Assert.assertTrue(verifyElementPresent(overviewObj.iconInActiveAdsCountSection),
				"Icon is not displaying for total number of active Ads");
		waitTill(1000);
		/*Assert.assertTrue(getText(overviewObj.totalActiveAdsCount).trim().equals("2 out of 10"),
				"Total number of active Ads count is incorrect");*/
		
		//for visits
		Assert.assertTrue(getText(overviewObj.totalVisitsText).trim().equals("Total of visits"),
				"Total number of visit text is not displaying");
        Assert.assertTrue(verifyElementPresent(overviewObj.iconInVisitesCountSection),
				"Icon is not displaying for total number of visits");
        Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalVisitsCount).replace(".", "").trim())>0,
				"Total number of visit count is incorrect");
      //for Leads
      	Assert.assertTrue(getText(overviewObj.totalLeadsText).trim().equals("Total of leads"),
      						"Total number of Leads text is not displaying");
      	Assert.assertTrue(verifyElementPresent(overviewObj.iconInTotalLeadsCountSection),
      						"Icon is not displaying for total number of Leads");
      	Assert.assertTrue(Integer.parseInt(getText(overviewObj.totalLeadsCount).replace(".", "").trim())>0,
      					"Total number of Leads count is incorrect");
	}
	
	/*
	 * Description: Verify the count is displaying/updating propelry by publishing,
	 * visitng and generating the leads
	 */
	/*@Test
	public void verifytheCountisDisplayingandUpdatingproperlyBypublishingVisitingandGeneratingLeads() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		waitTill(3000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
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
		temp += "Number of Leads = " + visitCountOnWebSite;
		fw.write(temp);
		waitTill(3000);
		if (fw != null)
			fw.close();
		LeadsTradusPROPPage leadsObj=new LeadsTradusPROPPage(driver);
		leadsObj.leadsGenerationinTPRO();
		
	}*/
}
