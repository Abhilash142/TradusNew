package smoke_test_TCOM;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.getValue;
import static com.tradus.core.ActionElementClass.moveToElement;

import static com.tradus.core.GlobalConstants.TCOM_User_1;
import static com.tradus.core.GlobalConstants.TCOM_pwd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdListingTradusPage;
import com.tradus.pages.HomeTradusPage;

public class AdListingTradusTest extends BaseClass{
	/*
	 * Description: Verify all the 5 categories namely Transport, Farm, construction, material handling 
	 * and spare parts categories are displaying on reset
	 */
	@Test
	public void verifyAllFiveCategoryIconWithNameOnClickingResetButton() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		try {
			click(homePageObj.button_searchResult_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.button_searchResult_xpath.get(0));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		AdListingTradusPage adListingObj=new AdListingTradusPage(driver);
		waitForElement(adListingObj.link_filterReset_xpath);
		try {
			click(adListingObj.link_filterReset_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.link_filterReset_xpath);
		}
		waitTill(2000);
		waitForElement(adListingObj.icon_L1andL2CategoryIcon_xpath.get(1));
		int size=adListingObj.icon_L1andL2CategoryIcon_xpath.size();
		Assert.assertTrue(size==5,"All L1 categories aren't displaying on clicking rest button in Listing page filter");
		String[] categories= {"Transport","Farm","Spare parts","Construction","Material handling"};
		for(int i=0;i<size;i++) {
			Assert.assertTrue(getText(adListingObj.icon_L1andL2CategoryIcon_xpath.get(i)).trim().contains(categories[i]),categories[i]+" category isn't displaying on clicking reset button");
		}
		Assert.assertTrue(getText(adListingObj.span_L1CategoryTypeinBreadCrumb_xpath).trim().equals("Search all categories"),"Category breadcrumb text in Listing isn't changing to 'Search all categories' upon clicking reset button");
	}
	
	/*
	 * Description: Verify the sort option right below the search field and Verify all the sorting options 
	 */
	@Test
	public void verifyTheSortOptionsRightBELOWTHESearchFieldandVerifyAlltheSortingOptions() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
		String[] sortingForTransport = { "Price: lowest first", "Price: highest first", "Mileage: lowest first",
				"Mileage: highest first", "Year: oldest first", "Year: newest first", "Weight: lowest first",
				"Weight: highest first", "Best match", "Date Published"};
		String[] sortingForFarm = { "Price: lowest first", "Price: highest first", "Mileage: lowest first",
				"Mileage: highest first", "Hours run: lowest first", "Hours run: highest first", "Year: oldest first",
				"Year: newest first", "Best match", "Date Published" };
		String[] sortingForConstructionAndMH = { "Price: lowest first", "Price: highest first",
				"Hours run: lowest first", "Hours run: highest first", "Year: oldest first", "Year: newest first",
				"Best match", "Date Published" };
		for (int i = 0; i < homePageObj.icon_L1Categories_xpath.size(); i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			} catch (Exception E) {
				jsClick(driver, homePageObj.icon_L1Categories_xpath.get(i));
			}
			try {
				click(homePageObj.button_searchResult_xpath.get(i));
			} catch (Exception E) {
				jsClick(driver, homePageObj.button_searchResult_xpath.get(i));
			}
			waitForElement(homePageObj.span_listingPageVerify_xpath);
			waitTill(1000);
			try {
				waitForElement(adListingObj.section_Sorting_xpath);
			} catch (Exception E) {
				Assert.assertTrue(verifyElementPresent(adListingObj.section_Sorting_xpath),
						"Sorting option isn't present in listing page for " + i + " category");
			}
			try {
				click(adListingObj.section_Sorting_xpath);
			} catch (Exception E) {
				jsClick(driver, adListingObj.section_Sorting_xpath);
			}
			waitForElement(adListingObj.options_Sorting_xpath.get(1));
			int size = adListingObj.options_Sorting_xpath.size();
			
			for (int j = 0; j < size; j++) {
				
				Assert.assertTrue(verifyElementPresent(adListingObj.options_Sorting_xpath.get(j)),
						"Sorting option isn't present");
				switch (i) {
				case 0:
					Assert.assertEquals(size,10,"10 sorting options aren't present for Transport category");
					Assert.assertTrue(
							getText(adListingObj.options_Sorting_xpath.get(j)).trim().equals(sortingForTransport[j]),
							sortingForTransport[j] + " isn't present for Transport categry");
					break;
				case 1:
					Assert.assertEquals(size,10,"10 sorting options aren't present for Farm category");
					Assert.assertTrue(
							getText(adListingObj.options_Sorting_xpath.get(j)).trim().equals(sortingForFarm[j]),
							sortingForFarm[j] + " isn't present for Farm categry");
					break;
				case 2:
					Assert.assertEquals(size,8,"8 sorting options aren't present for Construction category");
					Assert.assertTrue(
							getText(adListingObj.options_Sorting_xpath.get(j)).trim()
									.equals(sortingForConstructionAndMH[j]),
							sortingForConstructionAndMH[j] + " isn't present for Construction categry");
					break;
				case 3:
					Assert.assertEquals(size,8,"8 sorting options aren't present for Material handling category");
					Assert.assertTrue(
							getText(adListingObj.options_Sorting_xpath.get(j)).trim()
									.equals(sortingForConstructionAndMH[j]),
							sortingForConstructionAndMH[j] + " isn't present for Material handling categry");
					break;

				// System.out.println(getText(adListingObj.options_Sorting_xpath.get(j)).trim());
				}
			}
				driver.navigate().back();
				explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify Ads in Listing page are displaying with mandatory fields
	 */
	@Test
	public void verifyAdsinListingarePresentwithMandatoryIcons() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);

		try {
			click(homePageObj.icon_L1Categories_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(0));
		}
		try {
			click(homePageObj.button_searchResult_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(0));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		waitTill(1000);
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
		int size = adListingObj.AdTitleInListing_xpath.size();
		System.out.println(size);
		for (int x = 0; x < size; x++) {
			Assert.assertTrue(verifyElementPresent(adListingObj.img_AdImageInListing_xpath.get(x)),
					"Image in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getAttribute(adListingObj.img_AdImageInListing_xpath.get(x), "src").isEmpty()
							|| !getAttribute(adListingObj.img_AdImageInListing_xpath.get(x), "src").equals(null),
					"Image isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.AdTitleInListing_xpath.get(x)),
					"Ad title in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getText(adListingObj.AdTitleInListing_xpath.get(x)).trim().isEmpty()
							|| !getText(adListingObj.AdTitleInListing_xpath.get(x)).trim().equals(null),
					"Ad title isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.para_L3CategoryNameInListingTile_xpath.get(x)),
					"L3 name in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getText(adListingObj.para_L3CategoryNameInListingTile_xpath.get(x)).trim().isEmpty()
							|| !getText(adListingObj.para_L3CategoryNameInListingTile_xpath.get(x)).trim().equals(null),
					"Ad title isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.time_AdPostedTime_xpath.get(x)),
					"Ad posting time in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getText(adListingObj.time_AdPostedTime_xpath.get(x)).trim().isEmpty()
							|| !getText(adListingObj.time_AdPostedTime_xpath.get(x)).trim().equals(null),
					"Ad title isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.div_adPriceinListingTile_xpath.get(x)),
					"Price in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getText(adListingObj.div_adPriceinListingTile_xpath.get(x)).trim().isEmpty()
							|| !getText(adListingObj.div_adPriceinListingTile_xpath.get(x)).trim().equals(null),
					"Ad Price isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.div_AdLocation_xpath.get(x)),
					"Price in listing page isn't present  for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(
					!getText(adListingObj.div_AdLocation_xpath.get(x)).trim().isEmpty()
							|| !getText(adListingObj.div_AdLocation_xpath.get(x)).trim().equals(null),
					"Ad Price isn't displaying for the " + x + " Ad under Transport cateory");
			Assert.assertTrue(verifyElementPresent(adListingObj.div_favoriteIconinListing_xpath.get(x)),
					"Favorite icon in listing page isn't present  for the " + x + " Ad under Transport cateory");
		}
	}
	/*
	 * Description: Verify login page is displaying on clicking the favorite icon without login
	 */
	@Test
	public void verifyLoginPageOnClickingFavoriteIconwithoutLogin() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
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
		try {
			click(homePageObj.icon_L1Categories_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(0));
		}
		try {
			click(homePageObj.button_searchResult_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(0));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		waitForElement(adListingObj.div_favoriteIconinListing_xpath.get(0));
		try {
			click(adListingObj.div_favoriteIconinListing_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_favoriteIconinListing_xpath.get(0));
		}
		try{
			explicitWaitFortheElementTobeVisible(driver, homePageObj.tab_LoginPageVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(homePageObj.tab_LoginPageVerify_xpath),"Login page isn't displaying on clicking favorite icon in Listing page without login");
		}
	}
	/*
	 * Description: Verify favorite icon is highlighted on clicking icon after login and Verify count beside favorites text in user drop down is increasing when user favorites the ad
	 */
	@Test
	public void verifyFavoriteIconAfterLoginAndcountisUpdatinginUserDropdown() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
		if(verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.link_loginTradus_xpath);
			}catch(Exception E) {
				 jsClick(driver,homePageObj.link_loginTradus_xpath);
			 }
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
			sendKeys(homePageObj.tradusUidInLoginPage,TCOM_User_1);
			sendKeys(homePageObj.tradusPWDInLoginPage,TCOM_pwd);
			jsClick(driver,homePageObj.tradusLoginButton);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			}
		try {
			click(homePageObj.icon_L1Categories_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.icon_L1Categories_xpath.get(0));
		}
		try {
			click(homePageObj.button_searchResult_xpath.get(0));
		} catch (Exception E) {
			jsClick(driver, homePageObj.button_searchResult_xpath.get(0));
		}
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.section_Sorting_xpath);
		try {
			click(adListingObj.section_Sorting_xpath);
		} catch (Exception E) {
			jsClick(driver, adListingObj.section_Sorting_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adListingObj.link_DatePublishSorting_xpath);
		try {
			click(adListingObj.link_DatePublishSorting_xpath);
		} catch (Exception E) {
			jsClick(driver, adListingObj.link_DatePublishSorting_xpath);
		}
		waitForElement(homePageObj.lable_UserMenu_xpath);
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
		waitTill(1000);
		try {
			click(adListingObj.div_favoriteIconinListing_xpath.get(3));
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_favoriteIconinListing_xpath.get(3));
		}
		waitTill(1000);
		moveToElement(driver,adListingObj.AdTitleInListing_xpath.get(3));
		waitTill(2000);
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertTrue(adListingObj.div_favoriteIconinListing_xpath.get(3).getCssValue("color").equals("rgba(255, 136, 0, 1)"),"Star icon isn't highlighted on clicking favorite icon");
		//System.out.println(adListingObj.div_favoriteIconinListing_xpath.get(10).getCssValue("color"));
		/*waitTill(2000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int fab_count_new=Integer.parseInt(getText(homePageObj.span_CountOfFavoriteAdsunderUserMenu_xpath).trim());
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}*/
		//System.out.println(fab_count);
		//System.out.println(fab_count_new);
		//softAssertion.assertTrue(fab_count_new==fab_count+1,"Favorite count isn't incresed by one on clicking favorite Ad in Listing page");
		waitTill(2000);
		try { 
        	click(adListingObj.div_favoriteIconinListing_xpath.get(3));
	    }catch(Exception E) {
	    jsClick(driver,adListingObj.div_favoriteIconinListing_xpath.get(3)); 
	    }
		waitTill(1000);
		moveToElement(driver,adListingObj.AdTitleInListing_xpath.get(3));
		waitTill(2000);
		softAssertion.assertTrue(adListingObj.div_favoriteIconinListing_xpath.get(3).getCssValue("color").equals("rgba(255, 255, 255, 1)"),"Star icon isn't unhighlighted on clicking favorite icon already favorited Ad");
		/*	waitTill(3000);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}
		int updated_fab_count=Integer.parseInt(getText(homePageObj.span_CountOfFavoriteAdsunderUserMenu_xpath).trim());
		//System.out.println(fab_count);
		//System.out.println(updated_fab_count);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.lable_UserMenu_xpath);
		}*/
		//softAssertion.assertTrue(updated_fab_count==fab_count,"Favorite count isn't decresed by one on clicking favorite Ad in Listing page");
		softAssertion.assertAll();
	}
	/*
	 * Descritpion: Verify breadcrumbs is displaying below the seacrh field and Verify total ads count is displaying below the breadcrumbs
	 */
	@Test
	public void verifyBreadCrumbsisDisplayingBelowSearchField() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
		String breadCrumbs;String countWithCategories;
		int size=homePageObj.icon_L1Categories_xpath.size();
		for(int i=0;i<size;i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(i));
			l2.selectByIndex(5);
			waitTill(5000);
			String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(i)).replace("\n"," ").trim();
			int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
			if(result_home!=0) {
				try {
					click(homePageObj.button_searchResult_xpath.get(i));
				}catch(Exception E) {
					jsClick(driver,homePageObj.button_searchResult_xpath.get(i));
				}
			}
				else {
					Assert.assertTrue(result_home>0,"For "+i+" category and 5th L2 type, search result shows Zero results");
				}
			waitForElement(homePageObj.span_listingPageVerify_xpath);
			int numberOf_L3=adListingObj.icon_L3CategoryIcon_xpath.size();
			if(numberOf_L3>0) {
				try {
					click(adListingObj.icon_L3CategoryIcon_xpath.get(0));
				}catch(Exception E) {
					jsClick(driver,adListingObj.icon_L3CategoryIcon_xpath.get(0));
				}
			}
			waitTill(2000);
			waitForElement(adListingObj.nav_breadCrumb_xpath);
			//System.out.println(getText(adListingObj.text_adCountWithFiltersinListingPage_xpath).replace("\n",",").replace("cross",",").trim());
			breadCrumbs=getText(adListingObj.nav_breadCrumb_xpath).replace("\n",",").trim();
			countWithCategories=getText(adListingObj.text_adCountWithFiltersinListingPage_xpath).replace("\n",",").replace("cross",",");
			String[] elements = countWithCategories.split(" "); 
			int result_listing=Integer.parseInt(elements[0].replaceAll("[^0-9]", ""));
			//System.out.println(countWithCategories);
			//System.out.println(result_listing);
			switch(i) {
			case 0:
				
				Assert.assertTrue(breadCrumbs.replace("Breadcrumb,","").equals("Home,Transport,Trucks,Crane trucks"),"Transport>Trucks>Crane trucks breadcrumb aren't displaying properly");
				Assert.assertTrue(countWithCategories.contains("results for Transport , Trucks , Crane trucks ,"),"Result text with filter text might have changed for Transport category");
				Assert.assertTrue(result_listing>0, "For Transport+Trucks+Crane trucks, Ad count is displaying as Zero in Listing");
				break;
			case 1:
				Assert.assertTrue(breadCrumbs.replace("Breadcrumb,","").equals("Home,Farm,Harvesting,Combine harvesters"),"Farm>Harvesting>Combine harvesters breadcrumb aren't displaying properly");
				Assert.assertTrue(countWithCategories.contains("results for Farm , Harvesting , Combine harvesters ,"),"Result text with filter text might have changed for Farm category");
				Assert.assertTrue(result_listing>0, "For Farm+Harvesting+Combine harvesters, Ad count is displaying as Zero in Listing");
				break;
			case 2:
				Assert.assertTrue(breadCrumbs.replace("Breadcrumb,","").equals("Home,Construction,Cranes,Mobile cranes"),"Construction>Cranes>Mobile cranes breadcrumb aren't displaying properly");
				Assert.assertTrue(countWithCategories.contains("results for Construction , Cranes , Mobile cranes ,"),"Result text with filter text might have changed for Construction category");
				Assert.assertTrue(result_listing>0, "For Construction+Cranes+Mobile cranes, Ad count is displaying as Zero in Listing");
				break;
			case 4:
				Assert.assertTrue(breadCrumbs.replace("Breadcrumb,","").equals("Home,Material handling,Order pickers"),"Material handling>Order pickers breadcrumb aren't displaying properly");
				Assert.assertTrue(countWithCategories.contains("results for Material handling , Order pickers ,"),"Result text with filter text might have changed for Material Handling category");
				Assert.assertTrue(result_listing>0, "For Material handling+Order pickers, Ad count is displaying as Zero in Listing");
				break;
			}
			
			//System.out.print(breadCrumbs.replace("Breadcrumb,",""));
			//System.out.println();
			
			try {
		    	click(homePageObj.logo_tradus_xpath);
		    }catch (Exception E) {
		    	jsClick(driver, homePageObj.logo_tradus_xpath);
		    }
			explicitWaitFortheElementTobeVisible(driver, homePageObj.section_OfferOfTheDay_xpath);
		
	  }
	}
	
	/*
	 * Description: Verify selected category in home page is displaying as filter in ad listing page
	 */
	@Test
	public void verifySelectedCategoryInHomePageisDisplayingAsFilterinListingPage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver, homePageObj.button_searchResult_xpath.get(0));
		explicitWaitFortheElementTobeVisible(driver, homePageObj.element_homePageVerify_xpath);
		
		AdListingTradusPage adListingObj = new AdListingTradusPage(driver);
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
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		waitForElement(adListingObj.select_MakeFilter_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, adListingObj.select_ModelFilter_xpath);
		Assert.assertTrue(getValue(driver,adListingObj.select_MakeFilter_xpath).equalsIgnoreCase("Mercedes-Benz"),"Correct Make name isn't displaying in Listing page Filters");
		Assert.assertTrue(getValue(driver,adListingObj.select_ModelFilter_xpath).equalsIgnoreCase("Actros"),"Correct Model name isn't displaying in Listing page Filters");
		String temp=getText(adListingObj.div_LocationFilter_xpath).replace("\n",",");
		String[] elements = temp.split(" "); 
		Assert.assertTrue(elements[0].equals("Germany"),"Correct Model name isn't displaying in Listing page Filters");
		Assert.assertTrue(getValue(driver,adListingObj.input_priceToUnderSideFilters_xpath).equals("500,000"),"Correct Model name isn't displaying in Listing page Filters");
		Assert.assertTrue(getValue(driver,adListingObj.input_yearFrom_xpath).equals("1980"),"Correct Constructure Year isn't displaying in Listing page Filters");
		Assert.assertTrue(getValue(driver,adListingObj.input_MileageTo_xpath).equals("600000"),"Correct Mileasge isn't displaying in Listing page Filters");
		Assert.assertTrue(getValue(driver,adListingObj.input_WeightTo_xpath).equals("44000"),"Correct weight isn't displaying in Listing page Filters");
	    String temp_filters=getText(adListingObj.text_adCountWithFiltersinListingPage_xpath).replace("\n",",").replace("cross",",");
	    //System.out.println(Arrays.toString(o.split(" ", 2)));
	   Assert.assertTrue(temp_filters.contains("results for Transport , Trucks , Year (From): 1980 , Mileage (To): 600000 , Gross Weight (To): 44000 , Model: Actros , Make: Mercedes-Benz , Country: Germany , Price (To): 500000 ,"),"All selected filters aren't displaying correctly beside the Ads count ");
	
	}
	
	/*
	 * Description: Verify the filters and save search button displaying at the left side
	 */
	@Test
	public void verifyFiltersAndSaveSearchButtonAtLeftSide() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
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
		waitForElement(adListingObj.link_filterReset_xpath);
		waitTill(1000);
		try {
			explicitWaitFortheElementTobeVisible(driver,adListingObj.div_FilterSection_xpath);
		}catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(adListingObj.div_FilterSection_xpath), "Filter section isn't displaying for "+i+"th category");
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,adListingObj.icon_saveSearch_xpath);
		}catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(adListingObj.icon_saveSearch_xpath), "Save search link isn't displaying for "+i+"th category");
		}
		
	    driver.navigate().back();
	    explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
    }
	/*
	 * Description: Verify previous and Next text is Present in paginagtion and their functionality
	 */
	@Test
	public void verifyPreviousAndNextLinkandTheirNavigation() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
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
		waitForElement(adListingObj.link_Next_xpath);
		try {
			click(adListingObj.link_Next_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.link_Next_xpath);
		}
		waitTill(1000);
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		Assert.assertTrue(adListingObj.span_pageNumbers_xpath.get(1).getCssValue("color").equals("rgba(255, 255, 255, 1)"),"Second pagination button isn't highlighted on clicking next button");
		Assert.assertTrue(verifyElementPresent(adListingObj.link_Previous_xpath),"Previous button isn't displaying when user in second page");
		try {
			click(adListingObj.link_Previous_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.link_Previous_xpath);
		}
		waitTill(1000);
		waitForElement(homePageObj.span_listingPageVerify_xpath);
		Assert.assertTrue(adListingObj.span_pageNumbers_xpath.get(0).getCssValue("color").equals("rgba(255, 255, 255, 1)"),"First pagination button isn't highlighted on clicking previous button from second page");
		Assert.assertTrue(!verifyElementPresent(adListingObj.link_Previous_xpath),"Previous button is displaying when user in first page");
		try {
			click(homePageObj.logo_tradus_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.logo_tradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	/*
	 * Description: Veirfy alert along with button is displaying above footer in ad listing page
	 */
	//@Test
	public void verifyAlertAlongwithButtonisDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		SoftAssert softAssertion= new SoftAssert();
		if(verifyElementPresent(homePageObj.link_loginTradus_xpath)) {
			try {
				click(homePageObj.link_loginTradus_xpath);
			}catch(Exception E) {
				 jsClick(driver,homePageObj.link_loginTradus_xpath);
			 }
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
			sendKeys(homePageObj.tradusUidInLoginPage,TCOM_User_1);
			sendKeys(homePageObj.tradusPWDInLoginPage,TCOM_pwd);
			jsClick(driver,homePageObj.tradusLoginButton);
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
		waitForElement(adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		try {
			click(adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		}
		waitTill(2000);
		if(verifyElementPresent(adListingObj.icon_categoryPickerList_xpath))
			try {
				click(adListingObj.icon_L3CategoryIcon_xpath.get(1));
			}catch(Exception E) {
				jsClick(driver,adListingObj.icon_L3CategoryIcon_xpath.get(1));
			}
		waitForElement(adListingObj.div_createAlertText_xpath);
		//System.out.println(getText(adListingObj.div_createAlertText_xpath).replace("\n", ",").trim());
		softAssertion.assertTrue(verifyElementPresent(adListingObj.div_createAlertText_xpath), "Creat alert section isn't displaying for "+i+"th category Listing");
		waitTill(1000);
		softAssertion.assertTrue(getText(adListingObj.div_createAlertText_xpath).replace("\n", ",").trim().equals("Create alerts for new offers,Receive new offers based on filter options you apply on this page."), "Creat alert section text isn't correct for "+i+"th category Listing");
		try {
			click(adListingObj.span_CreateAlert_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.span_CreateAlert_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adListingObj.div_successMessageInCreatingAlert_xpath);
		//System.out.println(getText(adListingObj.div_successMessageInCreatingAlert_xpath).trim());
		softAssertion.assertTrue(getText(adListingObj.div_successMessageInCreatingAlert_xpath).trim().equals("Your alert has been created successfully."), "Correct sucess message isn't displaying for "+i+"th category Listing");
		waitTill(1000);
		try {
			click(adListingObj.div_RemoveAlertBtnInCreatingAlert_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_RemoveAlertBtnInCreatingAlert_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.div_successMessageInCreatingAlert_xpath);
		//System.out.println(getText(adListingObj.div_successMessageInCreatingAlert_xpath).trim());
		softAssertion.assertTrue(getText(adListingObj.div_successMessageInCreatingAlert_xpath).trim().equals("Your alert has been removed."), "Correct sucess message isn't displaying for "+i+"th category Listing");
		try {
			click(homePageObj.logo_tradus_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.logo_tradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
		softAssertion.assertAll();
	}
	
	/*
	 * Description: Verify Create an account page is displaying on clicking 'Create' button
	 */
	//@Test
	public void verifyLoginPageDisplayingOnClickingCreateButtonwithOutLogin() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
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
		waitForElement(adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		try {
			click(adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,adListingObj.icon_L1andL2CategoryIcon_xpath.get(i));
		}
		waitTill(2000);
		if(verifyElementPresent(adListingObj.icon_categoryPickerList_xpath))
			try {
				click(adListingObj.icon_L3CategoryIcon_xpath.get(1));
			}catch(Exception E) {
				jsClick(driver,adListingObj.icon_L3CategoryIcon_xpath.get(1));
			}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adListingObj.div_LoginBtnIncreateAlert_xpath);
		Assert.assertTrue(verifyElementPresent(adListingObj.div_LoginBtnIncreateAlert_xpath), "Login Button isn't present in create alert section if user isn't logged in for "+i+"th category");
		try {
			click(adListingObj.div_LoginBtnIncreateAlert_xpath);
		}catch(Exception E) {
			jsClick(driver,adListingObj.div_LoginBtnIncreateAlert_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		Assert.assertTrue(verifyElementPresent(homePageObj.tab_LoginPageVerify_xpath),"Login Page isn't displaying when clicked on Login button from create alert section for "+i+"th category");
		try {
			click(homePageObj.logo_tradus_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.logo_tradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
}
