package sanity_test_TCOM;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.getAttribute;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdDetailsTradusPage;
import com.tradus.pages.HomeTradusPage;

public class AdDetailsTradusTest extends BaseClass{
	
	/*String armyTruckURL="https://www.tradus.com/en/transport/trucks/army-truck/man/man-tgl-2005-7223617";
	String dionexURL="https://www.tradus.com/en/spare-parts/other-spare-parts-and-tools/tools/dionex/dionex-32-5837514";
	String caterpillarURL="https://www.tradus.com/en/construction/dump-trucks/articulated-dump-trucks/caterpillar/caterpillar-725c-from-first-owner-nice-machine-tailgate-2014-7226570";
	String dafSparePartsURL="https://www.tradus.com/en/spare-parts/other-spare-parts-and-tools/other-spare-parts/daf/daf-xf105-7173000";*/
	
	String armyTruckNewURL="https://www.tradus.com/en/transport/trucks/army-truck/man/man-tgl-2005-7223617";
	String dionexNewURL="https://www.tradus.com/en/spare-parts/other-spare-parts-and-tools/tools/dionex/dionex-32-5837514";
	//String caterpillarNewURL="https://www.tradus.com/en/construction/excavators/wheeled-excavators/caterpillar/caterpillar-m322d-roto-tilt-blade-outriggers-2007-7320103/advert-v2";
	String caterpillarNewURL="https://www.tradus.com/en/spare-parts/cabins/caterpillar/caterpillar-m-7326462";
	String RenaultMidlumNewURL="https://www.tradus.com/en/transport/trucks/box-trucks/renault/renault-midlum-180-12-2003-7183234";
	String dafSparePartsNewURL="https://www.tradus.com/en/material-handling/forklifts/linde/linde-p-30-c-1190-2015-7283906";
	
	/*
	 * Description: Verify Search field along with icon is displaying
	 */
	@Test
	public void verifySearchFieldAlomgwithIconisDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_MANAdDetails_xpath);
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(homePageObj.input_searchField_xpath), "Search field isn't displayed in Ad details page");
		Assert.assertTrue(verifyElementPresent(homePageObj.button_searchIcon_xpath), "Search button isn't displayed in Ad details page");
	}
	
	/*
	 * Description: Verify Selected categories along with make and title is displaying in breadcrumb
	 */
	@Test
	public void verifySelectedCatrgoriesAlongwithMakeandTitleisDisplayinginBreadcrumb() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_MANAdDetails_xpath);
		waitTill(1000);
		int size=adDetailsObj.link_Breadcrumb_xpath.size();
		Assert.assertTrue(size==5,"All breadcrumb links are not displaying");
		String[] breadCurmbLinks= {"Home","Transport","Trucks","ArmyMilitaryTrucks","MAN"};
		for(int i=0;i<size;i++) {
			String temp=getText(adDetailsObj.link_Breadcrumb_xpath.get(i)).replaceAll("\\s","").replace("/", "").trim();
			Assert.assertTrue(temp.equals(breadCurmbLinks[i]), breadCurmbLinks[i] +"link isn't displaying in breadcrumb");
		}
	}
	
	/*
	 * Description: Verify the previous and next links are displaying
	 */
	@Test
	public void verifyPreviousandNextlinksareDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.icon_L1Categories_xpath.get(0));
		waitTill(2000);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
				}catch(Exception E) {
					jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
				}
			waitTill(1000);
			try {
				click(homePageObj.button_searchResult_xpath.get(i));
				}catch(Exception E) {
					jsClick(driver,homePageObj.button_searchResult_xpath.get(i));
				}
			explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			int size=homePageObj.div_AdHeadinginResults_xpath.size();
			Assert.assertTrue(size>0, "Ads are not displaying in Listing page on visiting for "+i+" th category");
			List<WebElement> results=homePageObj.div_AdHeadinginResults_xpath;
			waitTill(2000);
			try {
				click(results.get(4));
				}catch(Exception E) {
					jsClick(driver,results.get(4));
				}
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		    Assert.assertTrue(verifyElementPresent(adDetailsObj.nav_nextButton_xpath), "Next button isn't present for"+i+" L1 category");
		    Assert.assertTrue(verifyElementPresent(adDetailsObj.nav_previousButton_xpath), "Previous button isn't present for"+i+" L1 category");
		    try {
				click(adDetailsObj.link_HomeinBreadcrumb_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.link_HomeinBreadcrumb_xpath);
				}

		    explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		    waitTill(2000);
		}
	}
	
	
	/*
	 * Description: Verify Ad title along with other attributes are displaying
	 */
	@Test
	public void verifyAdTitlewithOtherAttribute() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		Assert.assertTrue(getText(adDetailsObj.title_AdDetails_xpath).equals("MAN TGL 15.250"),"Ad title isn't displaying correctly in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.link_headerCategory_xpath).equals("Army / Military Trucks"),"L3 categories isn't displaying correctly in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.time_AdPostingTime_xpath),"Posting time isn't present in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.netPriceInOfferHeader_xpath).equals("€24 000"),"Net price isn't correct in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.priceRatngInOfferHeader_xpath).replace("\n", ",").trim().equals("HIGH PRICE,Tradus Market Value €12 993"),"Price rating stats aren't correct in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.div_steerSideInOfferHeader_xpath).trim().equals("Left hand"),"Steering side data isn't displaying correctly in Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.div_yearOfManufacturingInOfferHeader_xpath).trim().equals("2005"),"Manufacturing year isn't displaying correctly in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.div_hoursRunInOfferHeader_xpath).trim().equals("56,000 h"),"Hours run data isn't displaying correctly in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.div_mileageInOfferHeader_xpath).trim().equals("38,500 km"),"Mileage isn't displaying correctly in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_emailUnderContactSeller_xpath),"Email button under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callBackUnderContactSeller_xpath),"Call back under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callButtonUnderContactSeller_xpath),"Call button under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_emailforSimilarAlert_xpath),"Email for similar offer link under Contact us section isn't present in Ad details page");
		//System.out.println(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim());
		Assert.assertTrue(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim().equals("Truck dealers,Typically responds via email within 1 day.,Bangalore, India,Registered on Tradus less than a year ago,View all ads (0)"),"Dealer info section date might have changes in Ad details page");
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.div_dealerInfo_xpath),"Map section isn't present in Ad details page");
	   
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.div_TMVsection_xpath),"TMV section isn't present in Ad details page");
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.link_aboutTMV_xpath),"About TMV info button isn't present in Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.span_netPriceinTMVForMAN_xpath).trim().equals("€24 000"),"Net price value isn't correct under TMV section of Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.span_TMVpriceForMAN_xpath).trim().equals("€12 993"),"TMV value isn't correct under TMV section of in Ad details page");
	}
	
	/*
	 * Descritpion: Verify the login page is displaying without login on clicking the offers button
	 */
	@Test
	public void verifyLoginPageisDisplayingwithoutLoginonClickingtheOffers() throws Exception {
	AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
	loadUrl(driver,dionexNewURL);
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
	waitTill(1000);
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_FavoriteIcon_xpath);
	try {
		click(adDetailsObj.link_FavoriteIcon_xpath);
	}catch(Exception E) {
		jsClick(driver,adDetailsObj.link_FavoriteIcon_xpath);
	}
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
	Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking favorite button in ADP without login");
	}
	
	/*
	 * Description: Verify price rating lable and redirecting to price rating info on clicking the link
	 */
	@Test
	public void verifyPriceRatinglaleandredirectingTothatSectiononClickingtheLink() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		try {
			click(adDetailsObj.link_TMVlinkInHeader_xpath);
		}catch (Exception E) {
			jsClick(driver,adDetailsObj.link_TMVlinkInHeader_xpath);
		}
		waitTill(5000);
		//System.out.println(adDetailsObj.header_TMVvaluationHeader_xpath.getLocation().getY());
		//System.out.println(adDetailsObj.header_DescritpionvHeader_xpath.getLocation().getY());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitTill(3000);
		Long value=(Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(adDetailsObj.header_TMVvaluationHeader_xpath.getLocation().getY()-200<=value && value<=adDetailsObj.header_DescritpionvHeader_xpath.getLocation().getY()+100 , "Page is not scrolling to proper section on clicking TMV link");
	}
	
	/*
	 * Description: Verify sellers logo and their name is displaying
	 */
	@Test
	public void verifySellersLogoAndtheirName() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		//System.out.println(getAttribute(adDetailsObj.img_DealerLogo_xpath,"src"));
		Assert.assertTrue(getAttribute(adDetailsObj.img_DealerLogo_xpath,"src").equals("https://images.tradus.com/v1/7a1efbe4-2f24-44e4-9b1e-abb073d4a434.jpg"),"Correct dealer logo isn't displaying in ADP");
		//System.out.println(getText(adDetailsObj.img_DealerName_xpath).trim());
		Assert.assertTrue(getText(adDetailsObj.img_DealerName_xpath).trim().equals("Truck dealers"), "Correct dealer name isn't displaying in Ad details page");
	}
	
	/*
	 * Description: Verify View all ads link is displaying and respective ads of particular user are displaying on clicking the 'View all ads' link
	 */
	@Test
	public void verifyViewAllAdslinkpresenceandFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,RenaultMidlumNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_ViewAllAds_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_ViewAllAds_xpath), "View all Ads link isn't present in Delaer All Ads page");
	    try {
	    	click(adDetailsObj.link_ViewAllAds_xpath);
	    }catch(Exception E) {
	    	jsClick(driver,adDetailsObj.link_ViewAllAds_xpath);
	    }
	    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.span_DealerNameinAllAdspage_xpath);
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.AdCountinDealerAllAds_xpath), "Results for BAS TRUCKS isn't displaying in Dealer all Ads listing page");
	    Assert.assertTrue(Integer.parseInt((getText(adDetailsObj.AdCountinDealerAllAds_xpath).replace("results for Mestebeld Trucks B.V.", "").trim()))>0, "Ad count is appered as zero/incorrect in Dealer all Ads page");
	}
	
	/*
	 * Description: Verify ads are displaying below Frequently viewed by other customers 
	 */
	@Test
	public void verifyAdsareDisplayingbelowFrequentlyViewedbyOtherCustomers() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.section_frequentlyViewedAds_xpath);
		int size=adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.size();
		Assert.assertTrue(size>0,"Ads aren't displaying under frequently searched section in offer details page");
	    try {
	    	click(adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(6),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	    try {
	    	click(adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    //Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(11),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	    try {
	    	click(adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    //Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(5),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	
	    try {
	    	click(adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(0),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	    }
	
	/*
	 * Description: Verify Back to top link along with upward arrow is displaying
	 */
	@Test
	public void verfyBackToTopLinkanditsFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		scrollDown(driver);
		waitTill(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_BackToTop_xpath);
		try {
			click(adDetailsObj.link_BackToTop_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_BackToTop_xpath);
		}
		waitTill(3000);
		Long value=(Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(value<100, "Page isn't moving to top of the page when clicked on the Back to top link");
		
	}
	/*
	 * Description: Verify all the subtype links are displaying along with 'See all categories' link above footer
	 */
	@Test
	public void verifyAllsubtypesareDisplayingalongwithSeeAllCategorieslinkinFooter() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		
		int size=adDetailsObj.div_transportCategoryInBottom_xpath.size();
		Assert.assertTrue(size==6, "For transport category 6 links aren't displaying in bottom menu");
		ArrayList<String> TransportL2=new ArrayList<String>(Arrays.asList("Trucks","Vans","Semi-trailers","Tractor units","Trailers","See all"));
		for(int i=0;i<6;i++) {
			Assert.assertTrue(TransportL2.contains(getText(adDetailsObj.div_transportCategoryInBottom_xpath.get(i)).trim()), TransportL2.get(i)+" link isn't displaying under Transport category");
		}
		int size1=adDetailsObj.div_farmCategoryInBottom_xpath.size();
		Assert.assertTrue(size1==6, "For Farm category 6 links aren't displaying in bottom menu");
		ArrayList<String> FarmL2=new ArrayList<String>(Arrays.asList("Tractors","Hay/Forage","Fertilizer applicators","Tillage","Harvesting","See all"));
		for(int i=0;i<6;i++) {
			Assert.assertTrue(FarmL2.contains(getText(adDetailsObj.div_farmCategoryInBottom_xpath.get(i)).trim()), TransportL2.get(i)+" link isn't displaying under Farm category");
		}
		int size2=adDetailsObj.div_constructionCategoryInBottom_xpath.size();
		Assert.assertTrue(size2==6, "For construction category 6 links aren't displaying in bottom menu");
		ArrayList<String> constructionL2=new ArrayList<String>(Arrays.asList("Excavators","Loaders","Attachments","Telescopic handlers","Aerial platforms","See all"));
		for(int i=0;i<6;i++) {
			Assert.assertTrue(constructionL2.contains(getText(adDetailsObj.div_constructionCategoryInBottom_xpath.get(i)).trim()), constructionL2.get(i)+" link isn't displaying under construction category");
		}
		int size3=adDetailsObj.div_materialHandlingCategoryInBottom_xpath.size();
		Assert.assertTrue(size3==6, "For MT category 6 links aren't displaying in bottom menu");
		ArrayList<String> MTL2=new ArrayList<String>(Arrays.asList("Forklifts","Stackers","Pallet trucks","Reach trucks","Container handler","Other warehouse equipment","See all"));
		for(int i=0;i<6;i++) {
			Assert.assertTrue(MTL2.contains(getText(adDetailsObj.div_materialHandlingCategoryInBottom_xpath.get(i)).trim()), MTL2.get(i)+" link isn't displaying under material handling category");
		}
	}
	
	/*
	 * Description: Verify page is redirecting to categories page on clicking 'See all categories' link
	 */
	@Test
	public void verifySeeAllCategroyLinkandVerifyItsNavigations() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		waitTill(2000);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		try {
			click(adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_categoryPageVerify_xpath);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.tradus.com/en/categories"), "Page isn't naviagted to all categories page on clicking the see all category link");
	}
	
	/*
	 * Description:  Verify all the footer links
	 */
	@Test
	public void verifyAllfooterLinksanditsNavigation() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		int foorterLinksSize=homePageObj.link_bottomLinks_xpath.size();
		Assert.assertTrue(foorterLinksSize==9, "All footer links aren't displaying ");
		String parentWindow=driver.getWindowHandle();
		for(int i=0;i<foorterLinksSize;i++) {
			try {
				click(homePageObj.link_bottomLinks_xpath.get(i));
			}catch (Exception E) {
				jsClick(driver,homePageObj.link_bottomLinks_xpath.get(i));
			}
			switch(i) {
			case 0:
				explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.element_homePageVerify_xpath), "Home page isn't displaying on clicking link from bottom menu");
				waitTill(2000);
				loadUrl(driver,armyTruckNewURL);
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				break;
			case 1:
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_aboutUsPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_aboutUsPageVerify_xpath), "About us page isn't displaying on clicking link from bottom menu");
				waitTill(2000);
				loadUrl(driver,armyTruckNewURL);
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				break;
			case 2:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_TermsPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_TermsPageVerify_xpath), "Terms page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;   
			case 3:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_blogPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_blogPageVerify_xpath), "Blog page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;     
			case 4:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_PrivacyPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_PrivacyPageVerify_xpath), "Privacy page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;   
			case 5:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_HelpPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_HelpPageVerify_xpath), "Help page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break; 
			    
			case 6:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_SellingOnTradusPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_SellingOnTradusPageVerify_xpath), "Selling on Tradus page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break; 
			    
			case 7:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_CookiesPage_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_CookiesPage_xpath), "Cookies on Tradus page isn't displaying on clicking link from bottom menu");
				driver.close();
				driver.switchTo().window(parentWindow);
				break; 
			    
			case 8:
				explicitWaitFortheElementTobeVisible(driver,homePageObj.logo_OtomotoProfi_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.logo_OtomotoProfi_xpath), "Profi page on Tradus page isn't displaying on clicking link from bottom menu");
				waitTill(2000);
				loadUrl(driver,armyTruckNewURL);
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				break; 
				
			}
			
		}
		
	}
	
	/*
	 * Description: Verify Ad description is displaying along with translate text
	 */
	@Test
	public void verifyAdDescriptionAlongwithTranslateText() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,caterpillarNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_DescriptionSection_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_descriptionInEnglishLanguage_xpath), "English Language option isn't present in description section");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_otherLanguageOptioninDescription_xpath), "Other Language option isn't present in description section");
		try {
			click(adDetailsObj.link_showMoreInDescription_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_showMoreInDescription_xpath);
		}
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_showLessInDescription_xpath), "Showless link isn't displaying in description section if  showmore is clicked");
		try {
			click(adDetailsObj.link_showLessInDescription_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_showLessInDescription_xpath);
		}
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_showMoreInDescription_xpath), "Showmore link isn't displaying in description section if showless is clicked");
	}
	
	/*
	 * Description:Verify all the overview sepcifications displaying
	 */
	@Test
	public void verifyAlltheOverviewSpecsareDisplaying() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_OverviewSection_xpath);
		if(verifyElementPresent(adDetailsObj.span_showMoreinOverview_xpath)) {
			try {
				click(adDetailsObj.span_showMoreinOverview_xpath);
			}catch (Exception E) {
				jsClick(driver,adDetailsObj.span_showMoreinOverview_xpath);
			}
		}
		waitTill(2000);
		Assert.assertTrue(getText(adDetailsObj.div_makeInAdDetailsPage_xpath).trim().equals("MAN"), "Correct make name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_modelInAdDetailsPage_xpath).trim().equals("TGL"), "Correct model name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_conditionInAdDetailsPage_xpath).trim().equals("Semi-new"), "Correct condition isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_loaderCraneMakeInAdDetailsPage_xpath).trim().equals("Copma"), "Correct Loader Crane Make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_axlesMakeInAdDetailsPage_xpath).trim().equals("BPW"), "Correct Axle make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_firstRegistartionYearInAdDetails_xpath).trim().equals("2014"), "Correct registration month isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_firstRegistartionMonthInAdDetails_xpath).trim().equals("4"), "Correct registration month isn't displaying in ADP");
		//System.out.println(getText(adDetailsObj.div_firstRegistartionYearInAdDetails_xpath).trim());
		//System.out.println(getText(adDetailsObj.div_firstRegistartionMonthInAdDetails_xpath).trim());
		Assert.assertTrue(getText(adDetailsObj.div_cabHeaterMakeInAdDetailsPage_xpath).trim().equals("Hydronic"), "Correct cab heater make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_tyreConditionInAdDetailsPage_xpath).trim().equals("2500 mm"), "Correct tyre condition isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_breakTypesInAdDetails_xpath).trim().equals("Disc"), "Correct break type isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_frontAxleBreakTypesInAdDetails_xpath).trim().equals("Disc"), "Correct front Axle break type isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_RearAxleBreaksTypeInAdDetailsPage_xpath).trim().equals("Disc"), "Correct rear Axle break type isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_BodyMakeInAdDetailsPage_xpath).trim().equals("Volvo"), "Correct body make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_secondAxleBrakesTypeInAdDetailsPage_xpath).trim().equals("Drum"), "Correct second axle break type isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_rearAxleTyreConditionInAdDetailsPage_xpath).trim().equals("3000 mm"), "Correct rear axle tyre condition isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_bodyVolumeInAdDetailsPage_xpath).trim().equals("5600 cbm"), "Correct body volume isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_YearInAdDetails_xpath).trim().equals("2005"), "Year data isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_MileageInAdDetails_xpath).trim().equals("38,500 km"), "Mileage data isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_hoursRunInOfferHeader_xpath).trim().equals("56,000 h"), "Hours run data isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_SteeringSideInAdDetails_xpath).trim().equals("Left hand"), "Streeing wheel side data isn't displaying in ADP");
	    Assert.assertTrue(getText(adDetailsObj.div_cabinInAdDetailsPage_xpath).trim().equals("Day cab"), "Cabin type data isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_TradusIDInAdDetails_xpath).trim().equals("7223617"), "Tradus ID isn't displaying in ADP");
	
	}
	
	/*
	 * Description: Verify Technical  Specifications, Engine and Transmission, options, dimensions and Additional details are displaying if details exists
	 */
	@Test
	public void verifyOtherSpecificationsAreDisplayingProperly() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_OverviewSection_xpath);
		if(verifyElementPresent(adDetailsObj.span_showMoreinOverview_xpath)) {
			try {
				click(adDetailsObj.span_showMoreinOverview_xpath);
			}catch (Exception E) {
				jsClick(driver,adDetailsObj.span_showMoreinOverview_xpath);
			}
		}
		waitTill(2000);
		Assert.assertTrue(getText(adDetailsObj.div_fuelConsumptionInAdDetails_xpath).trim().equals("18 L/h"), "Correct Fuel Consumption Overall value name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_secondAxleTireSizeInAdDetails_xpath).trim().equals("16"), "Correct Second Axle Tire Size value name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_grossWeightInAdDetails_xpath).trim().equals("1,780 kg"), "Correct gross weight value name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_netWeightInAdDetails_xpath).trim().equals("1,500 kg"), "Correct net weight value name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_bodyTypeInAdDetails_xpath).trim().equals("Articulated"), "Correct body type name isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_priceOptionsInAdDetails_xpath).trim().equals("Exchange is possible, Rent is possible"), "Correct price option isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_chassisOptionsInAdDetails_xpath).trim().equals("Aluminium, Articulated, Drawbar coupling, Lift axles, Lifting system Disc, Lifting system Share, Steel, Tail lift chassis options, Topping system Flail"), "Correct chassis option isn't displaying in ADP");
		//System.out.println(getText(adDetailsObj.div_chassisOptionsInAdDetails_xpath).trim());
		Assert.assertTrue(getText(adDetailsObj.div_transmissionMakeInAdDetails_xpath).trim().equals("Renault"), "Correct transmission Make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_engineMakeInAdDetails_xpath).trim().equals("Isuzu"), "Correct engine Make isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_engineTypeInAdDetails_xpath).trim().equals("V Type"), "Correct engine type isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_numberOfGearsInAdDetails_xpath).trim().equals("6"), "Correct number of gears isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_numberOfFuelTanksInAdDetails_xpath).trim().equals("2"), "Correct number of fuel Tanks isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_FuelTankCapacityInAdDetails_xpath).trim().equals("40 l"), "Correct fuel Tanks capacity isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_transmissionModelInAdDetails_xpath).trim().equals("MT-3481"), "Correct transmission model isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_engineModelInAdDetails_xpath).trim().equals("EMTA-5063"), "Correct engine model isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_emissionLevelInAdDetails_xpath).trim().equals("Euro 3"), "Correct emission level isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_EngineInAdDetails_xpath).trim().equals("Diesel"), "Correct engine isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_TransmissionInAdDetails_xpath).trim().equals("AS Tronic"), "Correct transmission isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_EngineCapacityInAdDetails_xpath).trim().equals("3400 cc"), "Correct engine capacity isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_powerInAdDetails_xpath).trim().equals("3600 hp"), "Correct engine power isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_cylindersInAdDetails_xpath).trim().equals("8 cyl."), "Correct cylinder isn't displaying in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_tankTrailerSectionsInAdDetails_xpath).trim().equals("987654112"), "Tank Trailer Number Of Sections value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_NoOfValvesInAdDetails_xpath).trim().equals("4"), "Number of values value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_adblueTankCapacityInAdDetails_xpath).trim().equals("20 l"), "Adblue tank capacity value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_coolingUnitInAdDetails_xpath).trim().equals("Yes"), "Cooling unti value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_numberOfSeatsInAdDetails_xpath ).trim().equals("3"), "Number of seats value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_optionsAndAttachmentsInAdDetails_xpath).trim().equals("2-piece boom, 4 WD, APS, Adblue Tank, Auto lubrication system, Bale Spike, Boom suspension, Cabin - Open, Cabin - Regular, Continuously Variable Transmission, CVT, Forks, Front and mid mount scarifier, Front linkage, GPS/Guidance System, Gravel Bucket, Hammer/shear hydraulic circuit, Header extension for rape seed harvesting, Pallet Forks, Power shift transmission, Quick locks, SATNAV, Safety line rupture valve - loader, Second hydraulic circuit, Self leveling, Skid rails, Snow Blade, Snow Bucket, Standard digging bucket, Straw chopper, Sunflower equipment, Track guards, Weighloader"),"Options and attachments data aren't correct");
		
		//System.out.println(getText(adDetailsObj.div_optionsAndAttachmentsInAdDetails_xpath));
		Assert.assertTrue(getText(adDetailsObj.div_interiorInAdDetails_xpath).trim().equals("Adjustabable steering wheel, Air conditioning, Auxiliary heating, Cabin suspension - mechanical, Cruise control, Differential lock, Driver seat air cushioned, Emergency triangle, Engine brake, Heated seats, Heater, Immobiliser, Motor heater, Retarder/ Intarder, Seat back tables, Seat belts, Side doors, Single bunk, Sleeping bunk, TV-Video, Toilet, Toolbox, Twin bunks"), "Interior data are incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_exteriorInAdDetails_xpath).trim().equals("ABD, ABS, BDF container compatible, Central lubrication system, Chassis side skirts, Drum brakes, EBV, Forced steering, Headlights washer, Particulate filter, Roof spoiler, Tail lift, Two fuel tanks, Winter tires, Xenon lights"), "Exterior data are incorrect in ADP");
		//System.out.println(getText(adDetailsObj.div_interiorInAdDetails_xpath));
		//System.out.println(getText(adDetailsObj.div_exteriorInAdDetails_xpath));
		Assert.assertTrue(getText(adDetailsObj.div_cabinTypeInAdDetails_xpath).trim().equals("Comfort"), "Cabin type value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_tireSizeInDimention_xpath).trim().equals("13"), "Tire size value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_bodyModelInDetails_xpath).trim().equals("Cargo"), "Body model value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_cargoLengthInDetails_xpath).trim().equals("36 m"), "Cargo length value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_heightInDetails_xpath).trim().equals("4.00 m"), "Height value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_cargoWidthInDetails_xpath).trim().equals("6 m"), "Cargo width value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_widthInDetails_xpath).trim().equals("4.00 m"), "Width value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_cargoHeightInDetails_xpath).trim().equals("18 m"), "Cargo Height value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_lengthInDetails_xpath).trim().equals("9 m"), "Length value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_wheelBaseInDetails_xpath).trim().equals("300 cm"), "Wheel base value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_frontTyreSizeInDetails_xpath).trim().equals("24"), "Front tire size is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_rearTyreSizeInDetails_xpath).trim().equals("30"), "Rear tire size is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_axleConfigSizeInDetails_xpath).trim().equals("10x6"), "Axle config value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_suspensionTypeInDetails_xpath).trim().equals("Hydraulic"), "Suspension type value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_maxPayloadInDetails_xpath).trim().equals("2,400 kg"), "Max payload value is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_technicalInspectionDateInDetails_xpath).trim().equals("02-10-2019"), "Technical inspection data is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_registrationNumberInDetails_xpath).trim().equals("3887"), "Registration Number is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_technicalInspecsValidTillInDetails_xpath).trim().equals("02-10-2021 text"), "Techinical inspection valid till data is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_VINNumberInDetails_xpath).trim().equals("28455MAT45CO2648"), "VIN number data is incorrect in ADP");
		Assert.assertTrue(getText(adDetailsObj.div_numberOfAxelsInDetails_xpath).trim().equals("2"), "Number of Axles data is incorrect in ADP");
	}
	
	/*
	 * Descritpion: Verify favorited ads in favorites list
	 */
	@Test
	public void verifyAdisFavoritedPostLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,caterpillarNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		//System.out.println(adDetailsObj.link_FavoriteLink_xpath.getCssValue("background-color"));
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_OverviewSection_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_FavoriteIcon_xpath);
		try {
			click(adDetailsObj.link_FavoriteIcon_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_FavoriteIcon_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
		try {
			click(adDetailsObj.tab_LoginPageVerify_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.tab_LoginPageVerify_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
		sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,adDetailsObj.tradusLoginButton);
		waitTill(5000);
		loadUrl(driver,caterpillarNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(5000);
        Assert.assertTrue(getAttribute(adDetailsObj.link_FavoriteLink_xpath,"title").trim().equals("Remove from favorites"), "Star icon isn't highlighted after login");
		//System.out.println(adDetailsObj.link_FavoriteLink_xpath.getCssValue("background-color"));
        try {
        	click(adDetailsObj.div_userMenu_xpath);
        }catch(Exception e) {
        	jsClick(driver,adDetailsObj.div_userMenu_xpath);
        }
		waitTill(2000);
		try {
        	click(adDetailsObj.div_favAdsLinkunderUserMenu_xpath);
        }catch(Exception e) {
        	jsClick(driver,adDetailsObj.div_favAdsLinkunderUserMenu_xpath);
        }
		waitTill(5000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_AdVerifyinFavListing_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_AdVerifyinFavListing_xpath), "Respective Ad isn't present under favorite listing");
		 try {
	        	click(adDetailsObj.div_favIconinFavAdListing_xpath);
	        }catch(Exception e) {
	        	jsClick(driver,adDetailsObj.div_favIconinFavAdListing_xpath);
	        }
		 waitTill(3000);
	}
	
	/*
	 * Description: Verify count of images, left and righ arrows, enlarge, zoom and close icons in image view 
	 */
	@Test
	public void verifyAttributesinImageExtendedView() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.img_CoverImgOfMANTGL_xpath), "Cover image might have changed for MAN TLG");
		try {
			click(adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}
		waitTill(5000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_ImageCountforImgViewPage_xpath), "Image counter isn't present in extedned image view page");
		Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals("1 / 9"), "Correct image counter isn't present in extedned image view page");
		//Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ZoomInandOutForImgViewPage_xpath), "Zoom option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_fullScreenInImgViewPage_xpath), "Full screen option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CloseButtononImgViewPage_xpath), "Cancle option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_LeftArrowForImgViewPage_xpath), "Left arrow isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_RightArrowForImgViewPage_xpath), "Right arrow isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ReportBtnImgViewPage_xpath), "Report button isn't present in extedned image view page");
	}
	
	/*
	 * Descritpion: Verify the Contact seller and Show the phone numbers buttons are displaying in the last image in enlarge view and verify action without login
	 */
	@Test
	public void ContactSellerAndShowPhonenumberFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.img_CoverImgOfMANTGL_xpath), "Cover image might have changed for MAN TLG");
		try {
			click(adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}
		
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		for(int i=0;i<8;i++) {
			int j=i+1;
			Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals(""+j+" / 9"), "Correct image counter isn't present in extedned image view page "+i+j+"");
			try {
				click(adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}
			waitTill(2000);
			if(i==7) {
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ContactSellerinImgViewPage_xpath), "Contact seller button isn't present in last image of  extedned image view page");
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CallBtninImgViewPage_xpath), "Call button isn't present in last image of  extedned image view page");
				try {
					click(adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath),"Login page isn't displaying when contact seller link is clicked before login");
			    waitTill(1000);
			    driver.navigate().back();
			    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_CallBtninImgViewPage_xpath);
			    try {
					click(adDetailsObj.btn_CallBtninImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_CallBtninImgViewPage_xpath);
				}
			    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath),"Login page isn't displaying when call link is clicked in image zoom view page before login");
			}
		}
	}
	
	/*
	 * Description: Verify the Contact seller and Show the phone numbers buttons are displaying in the last image in enlarge view and verify action with login
	 */
	@Test
	public void ContactSellerAndShowPhonenumberFunctionalitywithLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
		sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,adDetailsObj.tradusLoginButton);
		waitTill(5000);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		try {
			click(adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		for(int i=0;i<8;i++) {
			int j=i+1;
			Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals(""+j+" / 9"), "Correct image counter isn't present in extedned image view page "+i+j+"");
			try {
				click(adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}
			waitTill(2000);
			if(i==7) {
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ContactSellerinImgViewPage_xpath), "Contact seller button isn't present in last image of  extedned image view page");
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CallBtninImgViewPage_xpath), "Call button isn't present in last image of  extedned image view page");
				try {
					click(adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.div_sellerContactFormVerify_xpath),"Contact form isn't displaying when contact seller link is clicked after login");
				try {
					click(adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
				}
				waitTill(2000);
				try {
					click(adDetailsObj.btn_CallOptioninImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_CallOptioninImgViewPage_xpath);
				}
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_ContactSellerforCallTextInExtendedView_xpath);
				Assert.assertTrue(getText(adDetailsObj.div_UnhidePhoneNumberInExtednedImgPage_xpath).trim().equals("+918867853090"),"Correct phonenumber isn't visible on clicking the call button");
			}
		}
	}
	
	/*
	 * Description: Verify the images count is displaying for the last image in below cover image if exists
	 */
	@Test
	public void verifyImagecountDisplayingontheLastImage() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.count_onLastImg_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.count_onLastImg_xpath), "Ad count isn't present on Last image in ADP");
		String count=getText(adDetailsObj.count_onLastImg_xpath).replace("\n", ",").trim();
		//System.out.println(count);
		Assert.assertTrue(count.replace(",images", "").equals("+ 3"), "Ad count isn't correct on last image of ADP");
		
	}
	
	/*
	 * Description: Verify cover image is displaying in Large and other images below it
	 */
	@Test
	public void verifyCoverImageisDisplayinginLargeAndOtherbelowToThat() throws Exception{
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		int numberOfImgs=(adDetailsObj.img_AdImageinDetaislPage_xpath).size();
		Assert.assertTrue(numberOfImgs==5, "Cover image and 4 other images aren't displaying in Ad details page");
		
		int coverImgHeight=adDetailsObj.img_AdImageinDetaislPage_xpath.get(0).getRect().height;
		int coverImgWidth=adDetailsObj.img_AdImageinDetaislPage_xpath.get(0).getRect().width;
		Assert.assertTrue(coverImgHeight==540 && coverImgWidth==720, "Large cover image isn't displaying in ADP");
		for(int i=1;i<5;i++) {
			int otherImgHeight=adDetailsObj.img_AdImageinDetaislPage_xpath.get(i).getRect().height;
			int otherImgWidth=adDetailsObj.img_AdImageinDetaislPage_xpath.get(i).getRect().width;
			Assert.assertTrue(otherImgHeight==124 && otherImgWidth==165, ""+i+" th image below cover image isn't displaying properly in ADP");
		}
	}
	
	/*
	 * Description: Verify default image should not zoom if particular ad is not having any ad images
	 */
	@Test
	public void verifyDefaultImageandUnabletoZoomIn() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,dafSparePartsNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		
		String src=getAttribute(adDetailsObj.img_defaultImageinDetaislPage_xpath,"src");
		//System.out.println(src);
		Assert.assertTrue(src.trim().contains("https://www.tradus.com/assets/tradus/offer-result/material-handling.svg"), "Default image isn't displaying in ADP");
		
		try {
			click(adDetailsObj.img_defaultImageinDetaislPage_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_defaultImageinDetaislPage_xpath);
		}
		waitTill(2000);
		//System.out.println(getAttribute(adDetailsObj.div_CoverImgSectioninDetaislPage_xpath,"class").trim());
		Assert.assertTrue(getAttribute(adDetailsObj.div_CoverImgSectioninDetaislPage_xpath,"class").trim().equals("pswp"), "Default image is zooming in ADP");
	}
	
	/*
	 * Description: Verify email, call and call back buttton navigation before login
	 */
	@Test
	public void verifyEmailCallBackAndCallButtonNavigationsBeforeLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		WebElement[] ele= {adDetailsObj.link_emailUnderContactSeller_xpath,adDetailsObj.link_callBackUnderContactSeller_xpath,adDetailsObj.link_callButtonUnderContactSeller_xpath};
	    for(int i=0;i<ele.length;i++) {
	    	try {
	    		click(ele[i]);
	    	}catch(Exception E) {
	    		jsClick(driver,ele[i]);
	    	}
	    	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
	    	Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking "+i+" th link from contact section");
	        waitTill(1000);
	        driver.navigate().back();
	        explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
	    }
	}
	
	/*
	 * Description: Verify email, call and call back buttton navigation after login
	 */
	@Test
	public void verifyEmailCallBackAndCallButtonNavigationsAfterLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
		sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,adDetailsObj.tradusLoginButton);
		waitTill(5000);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		
		try {
			click(adDetailsObj.link_emailUnderContactSeller_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_sellerContactFormVerify_xpath),"Contact form isn't displaying on clicking the link");
		try {
			click(adDetailsObj.div_sendButtonInContactForm_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.text_leadFormSubmitSuccessinTradus_xpath);
		try {
			click(adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
		}
		waitTill(2000);
		
		try {
			click(adDetailsObj.link_callBackUnderContactSeller_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_callBackUnderContactSeller_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_sendButtonInCallBackForm_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callBackFormVerify_xpath),"Call back form isn't displaying on clicking the link");
		try {
			click(adDetailsObj.link_sendButtonInCallBackForm_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_sendButtonInCallBackForm_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.text_leadFormSubmitSuccessinTradus_xpath);
		try {
			click(adDetailsObj.btn_closeIconInCallBackSuccessModel_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.btn_closeIconInCallBackSuccessModel_xpath);
		}
		
		waitTill(2000);
		try {
			click(adDetailsObj.link_callOptionInContactSection_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_callOptionInContactSection_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_ContactSellerforCallText_xpath);
		Assert.assertTrue(getText(adDetailsObj.div_UnhidePhoneNumber_xpath).trim().equals("+918867853090"),"Correct phonenumber isn't visible on clicking the call button");
	}
	
	/*
	 * Descritpion: Verify TMV slider is displaying correctly
	 * 
	 * The x co-ordinate values are values of starting point
	 */
	@Test
	public void verifyTMVsiderisPointingCorrectly() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		int netPrice=Integer.parseInt(getText(adDetailsObj.div_TMVNetPrice_xpath).replaceAll("[^0-9]", "").trim());
		int TMVPrice=Integer.parseInt(getText(adDetailsObj.div_TMVPrice_xpath).replaceAll("[^0-9]", "").trim());
		//System.out.println(netPrice);
		//System.out.println(TMVPrice);
        int location=adDetailsObj.div_TMVPricePointer_xpath.getLocation().x;
		
		int verylowPriceSection=adDetailsObj.div_VeryLowPriceSectionInTMV_xpath.getLocation().x;
		int lowPriceSection=adDetailsObj.div_LowPriceSectionInTMV_xpath.getLocation().x;
		int averagePriceSection=adDetailsObj.div_AveragePriceSectionInTMV_xpath.getLocation().x;
		int highPriceSection=adDetailsObj.div_HighPriceSectionInTMV_xpath.getLocation().x;
		int veryHighPriceSection=adDetailsObj.div_VeryHighPriceSectionInTMV_xpath.getLocation().x;
		
		//System.out.println(location);
		
		if(netPrice>TMVPrice) {
			Assert.assertTrue(location>=highPriceSection && location<=1055, "TMV slider isn't placed properly for Higher price Ads");
		}
		else if(netPrice<TMVPrice) {
			Assert.assertTrue(location<averagePriceSection && location>=verylowPriceSection, "TMV slider isn't placed properly for lower price Ads");
		}
		else {
			Assert.assertTrue(location>=averagePriceSection && location<highPriceSection, "TMV slider isn't placed properly for average price Ads");
		}
	}
	
	/*
	 * Description: Verify Print button and its functionality
	 */
	@Test
	public void verifyPrintButtonAndItsFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.span_PrintBtn_xpath);
		String parentWindow=driver.getWindowHandle();
		try {
			click(adDetailsObj.span_PrintBtn_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.span_PrintBtn_xpath);
		}
		waitTill(2000);
		switchWindow(driver,parentWindow);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_AdHeaderInPrintPage_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.span_PrintPageVerify_xpath),"Print page isn't displaying on clicking print button");
	}
	
	/*
	 * Descritpion: Report abuse overlay navigation
	 */
	@Test
	public void reportAbuseNavigation() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_reportAbuse_xpath);
		try {
			click(adDetailsObj.link_reportAbuse_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_reportAbuse_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_reportAbuseSubmit_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.header_reportAbuseWrapper_xpath),"Report abuse form isn't displaying on clicking report link");
	}
	
	/*
	 * Descritpion: Send me email alerts for similar offers with login
	 */
	@Test
	public void verifySendSimilarAlertlinkFunctionlityWithLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
		sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,adDetailsObj.tradusLoginButton);
		waitTill(5000);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		try {
			click(adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}
		waitTill(2000);
		Assert.assertTrue(getText(adDetailsObj.link_SendAlertForSimilarOffer_xpath).trim().equals("Remove alerts for similar offers"), "Send alert test isn't changed after clicking the link");
		 try {
	        	click(adDetailsObj.div_userMenu_xpath);
	        }catch(Exception e) {
	        	jsClick(driver,adDetailsObj.div_userMenu_xpath);
	        }
			waitTill(2000);
			try {
	        	click(adDetailsObj.div_myAlertsLinkunderUserMenu_xpath);
	        }catch(Exception e) {
	        	jsClick(driver,adDetailsObj.div_myAlertsLinkunderUserMenu_xpath);
	        }
			waitTill(5000);
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_AdVerifyinAlertListing_xpath);
			Assert.assertTrue(verifyElementPresent(adDetailsObj.div_AdVerifyinAlertListing_xpath), "Respective Ad isn't present under Alert listing");
			 try {
		        	click(adDetailsObj.link_deleteForMANinAlertList_xpath);
		        }catch(Exception e) {
		        	jsClick(driver,adDetailsObj.link_deleteForMANinAlertList_xpath);
		        }
			 waitTill(3000);
	}
	
	/*
	 * Description: Send me email alerts for similar offers without login
	 */
	@Test
	public void verifySendSimilarAlertlinkFunctionlityWithoutLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		try {
			click(adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking receive alert link in ADP without login");
	}
	
	/*
	 * Description: Price units are changing on changing currency type
	 */
	@Test
	public void priceUnitsAreChangeingAsPerCurrencyType() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.dropdown_currency_xpath);
		String[] units= {"€","$","CHF","DKK","£","HUF","PLN","RON","RUB","SEK","TRY","UAH","ZAR"};
		Select s=new Select(adDetailsObj.dropdown_currency_xpath);
		List<WebElement> currencyOps=s.getOptions();
		for(int i=0;i<currencyOps.size();i++) {
			s.selectByIndex(i);
			waitTill(2000);
			String netPrice=getText(adDetailsObj.netPriceInOfferHeader_xpath);
			Assert.assertTrue(netPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for Net price in header");
			Assert.assertTrue((Integer.parseInt(netPrice.replaceAll("[^0-9]","").trim()))>0, "TMV net Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String tmvNetPrice=getText(adDetailsObj.div_TMVNetPrice_xpath);
			Assert.assertTrue(tmvNetPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for TMV net price in header");
			Assert.assertTrue(Integer.parseInt(tmvNetPrice.replaceAll("[^0-9]","").trim())>0, "TMV net Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String tmvPrice=getText(adDetailsObj.div_TMVPrice_xpath);
			Assert.assertTrue(tmvPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for TMV price");
			Assert.assertTrue(Integer.parseInt(tmvPrice.replaceAll("[^0-9]","").trim())>0, "TMV Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String priceInTMVPara=getText(adDetailsObj.span_AdPriceInTMVDescription_xpath);
			Assert.assertTrue(priceInTMVPara.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of price in TMV section");
			Assert.assertTrue(Integer.parseInt(priceInTMVPara.replaceAll("[^0-9]","").trim())>0, "Price in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String TMVPriceInDescription=getText(adDetailsObj.span_TMVPriceInTMVDescription_xpath);
			Assert.assertTrue(TMVPriceInDescription.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of TMV price in TMV section");
			Assert.assertTrue(Integer.parseInt(TMVPriceInDescription.replaceAll("[^0-9]","").trim())>0, "TMVPrice in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String estimatePrice=getText(adDetailsObj.span_TMVEsitamtedPriceDifference_xpath);
			Assert.assertTrue(estimatePrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of esitmate price in TMV section");
			Assert.assertTrue(Integer.parseInt(estimatePrice.replaceAll("[^0-9]","").trim())>0, "Estamate price in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
		
		}
	}
}
