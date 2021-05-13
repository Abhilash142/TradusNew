package sanity_test_TCOM;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.generateRandomNumber;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollDown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.getText;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdDetailsTradusPage;
import com.tradus.pages.AdListingTradusPage;
import com.tradus.pages.HomeTradusPage;

public class HomeTradusTest extends BaseClass{
	
	// Description: Verify the Cookies message along with 'learn more' link in the home page on visiting for the first time  
	@Test
	public void verifyCookiesMessageandLearnmoreLinkinHomePageonVisistingforFirstTime() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.cookiesInfo_tradus_xpath);
		Assert.assertTrue(verifyElementPresent(homePageObj.cookiesInfo_tradus_xpath), "Cookies info isn't displaying for visiting site for first time");
		Assert.assertTrue(verifyElementPresent(homePageObj.link_learnMoreinCookiesInfo_xpath), "Learn more link isn't present in Cookies info ");
	    String parentWindow=driver.getWindowHandle();
		try {
	    	click(homePageObj.link_learnMoreinCookiesInfo_xpath);
	    }catch (Exception E) {
	    	jsClick(driver, homePageObj.link_learnMoreinCookiesInfo_xpath);
	    }
		switchWindow(driver,parentWindow);
	    explicitWaitFortheElementTobeVisible(driver,homePageObj.header_CookiesPage_xpath);
	    Assert.assertTrue(verifyElementPresent(homePageObj.header_CookiesPage_xpath), "User isn't landed in cookies page on clicking learn more link");
	}
	
	// Description: Verify Tradus logo in the header and same page is displaying on clicking the Tradus logo from header
	@Test
	public void verifyTradusLogoinHeader() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.logo_tradus_xpath), "Tradus logo isn't displayed in home page");
		try {
	    	click(homePageObj.logo_tradus_xpath);
	    }catch (Exception E) {
	    	jsClick(driver, homePageObj.logo_tradus_xpath);
	    }
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.element_homePageVerify_xpath), "Tradus home isn't displayed on clicking the Tradus Logo");
	}
	
	/*Description: Verify search field in header, verify the suggestions are not displaying on entering single character in search field and
	* Verify the cross icon in search field on entering the characters in search field
	*/
	@Test
	public void verifySearchFieldFunctionality() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.input_searchField_xpath), "Search field isn't displayed in home page");
	    sendKeys(homePageObj.input_searchField_xpath,"F");
	    waitTill(2000);
	    Assert.assertTrue(verifyElementPresent(homePageObj.button_searchBoxClear_xpath), "Cross button isn't displaying upon entering charactor in search box");
		System.out.println(homePageObj.list_autoCompleteSuggestion_xpath.size());
		Assert.assertTrue(homePageObj.list_autoCompleteSuggestion_xpath.size()==0, "Suggestion list is displaying when only one charactor is entered in Search box");
		sendKeys(homePageObj.input_searchField_xpath,"Tr");
		waitTill(5000);
		//System.out.println(getText(homePageObj.button_searchBoxClear_xpath));
		Assert.assertTrue(homePageObj.list_autoCompleteSuggestion_xpath.size()>0, "Suggestion list isn't displaying when more than one charactor is entered in Search box");
	    try {
	    	click(homePageObj.button_searchBoxClear_xpath);
	    }catch(Exception E) {
	    	jsClick(driver,homePageObj.button_searchBoxClear_xpath);
	    }
	    waitTill(2000);
	    Assert.assertTrue(!verifyElementPresent(homePageObj.button_searchBoxClear_xpath), "Cross button is displaying even after removing the text from search word");
	}
	
	/*
	 * Description: Verify ad lising page is displaying by clicking on search icon and Verify resultant ads are displaying on searching with specific keywords
	 */
	@Test
	public void verifyAdListingonClickingSearchIconwithSpecificKeyword() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.input_searchField_xpath), "Search field isn't displayed in home page");
		sendKeys(homePageObj.input_searchField_xpath,"Scania");
		waitTill(5000);
		try {
		    	click(homePageObj.button_searchIcon_xpath);
		    }catch(Exception E) {
		    	jsClick(driver,homePageObj.button_searchIcon_xpath);
		    }
		 try {
		 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
		 }catch(Exception E) {
			 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on search icon");
		 }
		 
		 for(int i=0;i<homePageObj.div_AdTitlesinResults_xpath.size();i++) {
			 String temp=homePageObj.div_AdTitlesinResults_xpath.get(i).getText().replace("Status", "").replace("\n", ",").trim();
			 Assert.assertTrue(temp.contains("Scania"), "Listing isn't filtered as per the keyword search");
		 }
	}
	
	/*
	 * Description: Verify dropdown on cliking the English language from header and verify '20 langaugaes' in the dropdown at present
	 */
	@Test
	public void verifyLanguageDropdown() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Select s =new Select(homePageObj.dropdown_languageOptions_xpath);
		List<WebElement> lang=s.getOptions();
		ArrayList<String> expectedLang=new ArrayList<String>(Arrays.asList("Български","Dansk","Deutsch","Ελληνικά","English","Español","Français","Hrvatski","Magyar","Italiano","Lietuviškai","Nederlands","Polski","Português","Română","Русский","Slovensko","Srpski","Türkçe","Українська"));
		Assert.assertTrue(lang.size()==20, "20 languages aren't present under language dropdown");
		for(int i=0;i<lang.size();i++) {
			Assert.assertTrue(lang.get(i).getText().trim().equals(expectedLang.get(i)), i+" option isn't present in dropdown");
		}
	}
	
	/*
	 * Description: Verify the message at the top stating as 'Switch to English' when changed to any other langauage apart English and Verify the text displaying in English when clicked on the 'Switch to English' text
	 */
	@Test
	public void verifySwicthToEnglishTextAnditsFunctionlity() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		Select s =new Select(homePageObj.dropdown_languageOptions_xpath);
		String langValue[]= {"bg","nl","it"};
		for(int i=0;i<langValue.length;i++){
		s.selectByIndex(0);
		 try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.link_switchToEnglish_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.link_switchToEnglish_xpath), "Switch to English text isn't displaying when language is changed to "+langValue[i]);
			 }
		 try {
		    	click(homePageObj.link_switchToEnglish_xpath);
		    }catch(Exception E) {
		    	jsClick(driver,homePageObj.link_switchToEnglish_xpath);
		    }
		 try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		    }catch(Exception E) {
		    	Assert.assertTrue(verifyElementPresent(homePageObj.element_homePageVerify_xpath),"Text isn't chaning to English upon clicking switch to English link");
		    }
		}
	}
	
	/*
	 * Description: Verify the currencty dropdown displaying beside 'Language' dropdown and Verify 13 types of currecies displaying in the dropdown at present
	 */
	@Test
	public void verifyCurrencyDropdownand13TypeOfCurrencies() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		 try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_currency_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.dropdown_currency_xpath), "Currency dropdown isn't displaying in Home page");
			 }
		Select s=new Select(homePageObj.dropdown_currency_xpath);
		List<WebElement> l=s.getOptions();
		Assert.assertTrue(l.size()==13, "13 type of currency options aren't present");
	}
	
	/*
	 * Description: Verify the Login page displaying on clicking Login link from header 
	 */
	@Test
	public void verifyLoginPageOnClickingLoginLink() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		 try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.link_loginTradus_xpath), "Login link isn't present in Home page");
			 }
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch(Exception E) {
			 jsClick(driver,homePageObj.link_loginTradus_xpath);
		 }
		try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.tab_LoginPageVerify_xpath), "User isn't naviagting to Login page on clicking link from Header");
			 }
	 }
	
	/*
	 * Description: Verify page is redirecting to pro.tradus.com in new tab on clicking the 'Start selling' button in the header 
	 */
	@Test
	public void verifyPageNavigatesToProTradusPageOnClickingStartSellingOnTraudsButton() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellOnTradus_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.link_sellOnTradus_xpath), "Sell on Tradus link isn't present in Home page");
			 }
		try {
			click(homePageObj.link_sellOnTradus_xpath);
		}catch(Exception E) {
			 jsClick(driver,homePageObj.link_sellOnTradus_xpath);
		 }
		try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.header_SellingOnTradusPageVerify_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.header_SellingOnTradusPageVerify_xpath), "User is not landing to TradusPro Landing page on clicking Sell on Tradus link");
			 }
	}
	
	/*
	 * Description: Verify Transport, Farm, Construction and Material handling equipment filters are displaying in Home page
	 */
	@Test
	public void verifyTransportFarmConstructionAndMaterialHandling() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropdown_languageOptions_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertTrue(homePageObj.icon_L1Categories_xpath.size()==4, "4 L1 categories are not displaying in Homepage");
		String actualCategories[]= {"Transport","Farm","Construction","Material handling"};
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			//System.out.println(homePageObj.icon_L1Categories_xpath.get(i).getText().trim());
			Assert.assertTrue(homePageObj.icon_L1Categories_xpath.get(i).getText().trim().contains(actualCategories[i]), actualCategories[i]+" categories link isn't displaying in Home page");
		}

	}
	
	/*
	 * Description: Verify Category, country, make, model, year and price filters for all categories
	 */
	@Test
	public void verifyCategoryCountryMakeModelYearPricefiltersforAllCategories() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_L2Categories_xpath.get(i)), "L2 Category dropdown isn't displaying for "+i+" th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Country_xpath.get(i)), "Country dropdown isn't displaying for "+i+" th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Make_xpath.get(i)), "Make dropdown isn't displaying for "+i+" th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Model_xpath.get(i)), "Model dropdown isn't displaying for "+i+" th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_YearFrom_xpath.get(i)), "Year dropdown isn't displaying for "+i+" th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Price_xpath.get(i)), "Price dropdown isn't displaying for "+i+" th category");
		}
	}
	
	/*
	 * Description: Verify Weight and mileage extra filters in transport cateogory 
	 */
	@Test
	public void verifyWeightAndMileageFiltersforTransportCategories() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Weight_xpath.get(0)), "Weight dropdown isn't displaying for Transport Category");
		Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Mileage_xpath), "Mileage dropdown isn't displaying for Transport Category");
	}
	
	/*
	 * Description: Verify weight filter in Constructuon category
	 */
	@Test
	public void verifyWeightFilterInConstructionCategory() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		try {
			click(homePageObj.icon_L1Categories_xpath.get(2));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_L1Categories_xpath.get(2));
		}
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(homePageObj.dropDown_Weight_xpath.get(1)), "Mileage dropdown isn't displaying for Construction Category");
	}
	
	/*
	 * Description: Verify detailed search link below filters for all categories
	 */
	@Test
	public void verifyDetailedSearchLinkBelowFiltersforAllCategories() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(homePageObj.link_detailedSearch_xpath.get(i)), "Detailed search link isn't present for "+i+" th L1 categories link");
		}
	}
	
	/*
	 * Description: Verify detailed search page is displaying on clicking detailed search link below every category in home page
	 */
	@Test
	public void verifyDetailedSearchPageonClickingDetailedSearchlinkBelowHomePage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		String actualCategories[]= {"Transport","Farm","Construction","Material handling"};
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(2000);
			try {
				click(homePageObj.link_detailedSearch_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.link_detailedSearch_xpath.get(i));
			}
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.div_DetailsSearchPageVerify_xpath);
				 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.div_DetailsSearchPageVerify_xpath), "User is not landing to Listing page on clicking detailed search link for "+actualCategories[i]+"th category");
				 }
			Assert.assertTrue(getText(homePageObj.ul_CategoryNameinDetailedSearch_xpath).trim().equals(actualCategories[i]), actualCategories[i]+" isn't displaying in detailed search page");
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify Offer of the day ads are displaying for all categories and Verify 'Offer of the day' label, ad title with their type & image, seller name with their location, price of the ad and view offer links 
	 */
	@Test
	public void verifyOfferOftheDaySectionforAllCategories() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(2000);
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.section_OfferOfTheDay_xpath);
				 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.section_OfferOfTheDay_xpath), "Offer of the day section isn't displaying for "+i+"th category");
				 }
			Assert.assertTrue(verifyElementPresent(homePageObj.div_offerOfTheDayinTag_xpath.get(i)), "Offer of the day tag isn't displaying for "+i+"th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.title_offerOfTheDay_xpath.get(i)), "Title of Offer of the day tag isn't displaying for "+i+"th category");
			//System.out.println(homePageObj.title_offerOfTheDay_xpath.get(i).getText());
			Assert.assertTrue((!homePageObj.title_offerOfTheDay_xpath.get(i).getText().isEmpty()), "Title of Offer of the day section length is zero for "+i+"th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.h4_CategoryinOfferOfTheDay_xpath.get(i)), "Category in Offer of the day section isn't displaying for "+i+"th category");
			Assert.assertTrue((!homePageObj.h4_CategoryinOfferOfTheDay_xpath.get(i).getText().isEmpty()), "Category length is zero in Offer of the day section for "+i+"th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.h4_DealerNameinOfferOfTheDay_xpath.get(i)), "Dealer name in Offer of the day section isn't displaying for "+i+"th category");
			Assert.assertTrue((!homePageObj.h4_CategoryinOfferOfTheDay_xpath.get(i).getText().isEmpty()), "Dealer name length is zero in Offer of the day section for "+i+"th category");
			Assert.assertTrue(verifyElementPresent(homePageObj.h4_DealerLocationinOfferOfTheDay_xpath.get(i)), "Dealer location in Offer of the day section isn't displaying for "+i+"th category");
		    Assert.assertTrue((!homePageObj.h4_DealerLocationinOfferOfTheDay_xpath.get(i).getText().isEmpty()), "Dealer location length is zero in Offer of the day section for "+i+"th category");
		    Assert.assertTrue(verifyElementPresent(homePageObj.h4_AdPriceinOfferOfTheDay_xpath.get(i)), "Price in Offer of the day section isn't displaying for "+i+"th category");
		    Assert.assertTrue((!homePageObj.h4_AdPriceinOfferOfTheDay_xpath.get(i).getText().isEmpty()), "Price length is zero in Offer of the day section for "+i+"th category");
		    Assert.assertTrue(verifyElementPresent(homePageObj.link_viewOfferinOfferoftheDay_xpath.get(i)), "View link in Offer of the day section isn't displaying for "+i+"th category");
		    Assert.assertTrue(verifyElementPresent(homePageObj.img_AdImageOfferinOfferOfTheDay_xpath.get(i)), "Image in Offer of the day section isn't displaying for "+i+"th category");
		}
	}
	
	/*
	 * Description: Verify respective details page is displaying on clicking the image, ad title and view offer links 
	 */
	@Test
	public void verifyAdDetailsDisplayingOnClickingTitlefromOfferOfTheDay() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
		String adTitle=homePageObj.title_offerOfTheDay_xpath.get(i).getText().trim();
		//System.out.println(adTitle);
		try {
			click(homePageObj.img_AdImageOfferinOfferOfTheDay_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,homePageObj.img_AdImageOfferinOfferOfTheDay_xpath.get(i));
		}
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		try{
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(adDetailsObj.title_AdDetailsVerify_xpath), "ADP isn't displaying for on clicking image on offer of the day "+i+"th category");
		}
		//System.out.println(adDetailsObj.title_AdDetails_xpath.getText().trim());
		//Assert.assertTrue(adTitle.contains(adDetailsObj.title_AdDetails_xpath.getText().trim()), "Same Ad isn't displaying in ADP on click offer of the day");
	    driver.navigate().back();
	    explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify respective details page is displaying on clicking the ad title links 
	 */
	@Test
	public void verifyAdDetailsDisplayingOnClickingImagefromOfferOfTheDay() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
		String adTitle=homePageObj.title_offerOfTheDay_xpath.get(i).getText().trim();
		//System.out.println(adTitle);
		try {
			click(homePageObj.title_offerOfTheDay_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,homePageObj.title_offerOfTheDay_xpath.get(i));
		}
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		try{
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(adDetailsObj.title_AdDetailsVerify_xpath), "ADP isn't displaying for on clicking offer of the day "+i+"th category");
		}
		//System.out.println(adDetailsObj.title_AdDetails_xpath.getText().trim());
		//Assert.assertTrue(adTitle.contains(adDetailsObj.title_AdDetails_xpath.getText().trim()), "Same Ad isn't displaying in ADP on click offer of the day");
	    driver.navigate().back();
	    explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify respective details page is displaying on clicking the view offer links
	 */
	@Test
	public void verifyAdDetailsDisplayingOnClickingViewOfferfromOfferOfTheDay() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
		String adTitle=homePageObj.title_offerOfTheDay_xpath.get(i).getText().trim();
		try {
			click(homePageObj.link_viewOfferinOfferoftheDay_xpath.get(i));
		}catch(Exception E) {
			jsClick(driver,homePageObj.link_viewOfferinOfferoftheDay_xpath.get(i));
		}
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		try{
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(adDetailsObj.title_AdDetailsVerify_xpath), "ADP isn't displaying for on clicking offer of the day "+i+"th category");
		}
		//Assert.assertTrue(adTitle.contains(adDetailsObj.title_AdDetails_xpath.getText().trim()), "Same Ad isn't displaying in ADP on click offer of the day");
	    driver.navigate().back();
	    explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify 'Featured offers' section with see all link
	 */
	@Test
	public void verifyFeaturedOfferSectionwithSeeAllLink() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(homePageObj.link_SeeAllLinkwithFeatureOffer_xpath.get(i)), "See All link isn't present for "+i+"th category");
			switch(i) {
			case 0:
				Assert.assertTrue(homePageObj.article_FeaturedOfferForTransport_xpath.size()==6, "Ads are not displaying under featured offers for "+i+"th category");
			    break;
			case 1:
				Assert.assertTrue(homePageObj.article_FeaturedOfferForFarm_xpath.size()==6, "Ads are not displaying under featured offers for "+i+"th category");
			    break;
			case 2:
				Assert.assertTrue(homePageObj.article_FeaturedOfferForConstruction_xpath.size()==6, "Ads are not displaying under featured offers for "+i+"th category");
			    break;
			case 3:
				Assert.assertTrue(homePageObj.article_FeaturedOfferForMT_xpath.size()==6, "Ads are not displaying under featured offers for "+i+"th category");
			    break; 
			}
		}
	}
	
	/*
	 * Description: Verify page is redirecting to Transport category ad listing page with 'Date published' as sorting option on clicking 'See all' link
	 */
	@Test
	public void verifyPageisRedirectingtoListingPageOnClickingSeeAllListingFromFeaturedOffers() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		AdListingTradusPage listingObj=new AdListingTradusPage(driver);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			try {
				click(homePageObj.link_SeeAllLinkwithFeatureOffer_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.link_SeeAllLinkwithFeatureOffer_xpath.get(i));
			}
			explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			switch(i) {
			case 0:
				Assert.assertTrue(getText(listingObj.span_L1CategoryTypeinBreadCrumb_xpath).trim().equals("Transport"), "Transport link isn't displaying on clicking See All link from featured offers ");
				Assert.assertTrue(getText(listingObj.span_SelectedSortingType_xpath).trim().equals("Date Published"), "Date Published sorting isn't applied on clicking See All link from featured offers ");
				Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0, "Featured Ads aren't displaying on clicking see All link for Transport category");
				break;
			case 1:
				Assert.assertTrue(getText(listingObj.span_L1CategoryTypeinBreadCrumb_xpath).trim().equals("Farm"), "Farm link isn't displaying on clicking See All link from featured offers ");
				Assert.assertTrue(getText(listingObj.span_SelectedSortingType_xpath).trim().equals("Date Published"), "Date Published sorting isn't applied on clicking See All link from featured offers ");
				Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0, "Featured Ads aren't displaying on clicking see All link for Farm category");
				break;
			case 2:
				Assert.assertTrue(getText(listingObj.span_L1CategoryTypeinBreadCrumb_xpath).trim().equals("Construction"), "Construction link isn't displaying on clicking See All link from featured offers ");
				Assert.assertTrue(getText(listingObj.span_SelectedSortingType_xpath).trim().equals("Date Published"), "Date Published sorting isn't applied on clicking See All link from featured offers ");
				Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0, "Featured Ads aren't displaying on clicking see All link for Construction category");
				break;
			case 3:
				Assert.assertTrue(getText(listingObj.span_L1CategoryTypeinBreadCrumb_xpath).trim().equals("Material handling"), "Farm link isn't displaying on clicking See All link from featured offers ");
				Assert.assertTrue(getText(listingObj.span_SelectedSortingType_xpath).trim().equals("Date Published"), "Date Published sorting isn't applied on clicking See All link from featured offers ");
				Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0, "Featured Ads aren't displaying on clicking see All link for Material handling category");
				break;
			}
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	/*
	 * Description: Verify respective ad details page is displaying on clicking each feature ad
	 */
	@Test
	public void verifyRespectiveAdDetailsAreDisplayingOnClickingFeaturedOffers() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			int k=Integer.parseInt(generateRandomNumber(0,5));
			switch(i) {
			case 0:
				String title=getText(homePageObj.title_FeaturedOffersForTransport_xpath.get(k));
				String price=getText(homePageObj.price_FeaturedOffersForTransport_xpath.get(k));
				try {
					click(homePageObj.title_FeaturedOffersForTransport_xpath.get(k));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_FeaturedOffersForTransport_xpath.get(k));
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				waitTill(1000);
				if(title.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()))
				     Assert.assertTrue(title.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()), title+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Transport from Home page");
				else
					Assert.assertTrue(price.equals(getText(adDetailsObj.netPriceInOfferHeader_xpath).trim()), title+" and "+price+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Transport from Home page");
				break;
			
			case 1:
				String title1=getText(homePageObj.title_FeaturedOffersForFarm_xpath.get(k));
				String price1=getText(homePageObj.price_FeaturedOffersForFarm_xpath.get(k));
				try {
					click(homePageObj.title_FeaturedOffersForFarm_xpath.get(k));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_FeaturedOffersForFarm_xpath.get(k));
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				waitTill(1000);
				if(title1.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()))
					Assert.assertTrue(title1.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()), title1+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Farm from Home page");
				else
					Assert.assertTrue(price1.equals(getText(adDetailsObj.netPriceInOfferHeader_xpath).trim()), title1+" and "+price1+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Transport from Home page");
			    break;
			
			case 2:
				String title2=getText(homePageObj.title_FeaturedOffersForConstruction_xpath.get(k));
				String price2=getText(homePageObj.price_FeaturedOffersForConstruction_xpath.get(k));
				try {
					click(homePageObj.title_FeaturedOffersForConstruction_xpath.get(k));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_FeaturedOffersForConstruction_xpath.get(k));
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				waitTill(1000);
				if(title2.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()))
					Assert.assertTrue(title2.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()), title2+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Construction from Home page");
				else
					Assert.assertTrue(price2.equals(getText(adDetailsObj.netPriceInOfferHeader_xpath).trim()), title2+" and "+price2+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Transport from Home page");
			    break;
			
			case 3:
				String title3=getText(homePageObj.title_FeaturedOffersForMT_xpath.get(k));
				String price3=getText(homePageObj.price_FeaturedOffersForMT_xpath.get(k));
				try {
					click(homePageObj.title_FeaturedOffersForMT_xpath.get(k));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_FeaturedOffersForMT_xpath.get(k));
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
				waitTill(1000);
				
				if(title3.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()))
					Assert.assertTrue(title3.contains(getText(adDetailsObj.title_AdDetails_xpath).trim()), title3+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Construction from Home page");
				else
					Assert.assertTrue(price3.equals(getText(adDetailsObj.netPriceInOfferHeader_xpath).trim()), title3+" and "+price3+" Ad isn't displaying in Ad details page on clicking link from Featured Ads for Transport from Home page");
			    break;
			}
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify new ads are replacing by old ones on frequent refresh the page
	 */
	@Test
	public void verifyNewAdsareReplacingByOldAdsonFrequentlyRefreshingThePage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			ArrayList<String> adIds=new ArrayList<String>();
			ArrayList<String> newAdIds=new ArrayList<String>();
			
			for(int j=0;j<homePageObj.article_FeaturedOfferForTransport_xpath.size();j++) {
				String temp=getAttribute(homePageObj.article_FeaturedOfferForTransport_xpath.get(j),"data-offer-id");
				adIds.add(temp.replace("offer-", ""));
			}
			driver.navigate().refresh();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			for(int j=0;j<homePageObj.article_FeaturedOfferForTransport_xpath.size();j++) {
				String temp=getAttribute(homePageObj.article_FeaturedOfferForTransport_xpath.get(j),"data-offer-id");
				newAdIds.add(temp.replace("offer-", ""));
			}
			Assert.assertFalse(adIds.equals(newAdIds), "New featured Ads aren't displaying upon refreshing the page for "+i+" th category");
		}
	}
	/*
	 * Description: Verify check our sellers section along with see all link  and verify page is redirecting to Seller catalog page on clicking see all link
	 */
	@Test
	public void sellerSectionwithSeeAllLinkanditsNavigation() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(homePageObj.link_checkOutourSeller_xpath.get(i)),"Promoted seller list isn't displaying for "+i+" category");
			switch(i) {
			case 0:
				Assert.assertTrue(homePageObj.li_proSellerListforTransport_xpath.size()>0,"Promoted sellers are not displaying for Transport category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    Assert.assertTrue(getText(homePageObj.li_categoryInSellerPage_xpath).trim().equals("Transport"),"User isn't landing to Transport category seller page");
			    Assert.assertTrue(getText(homePageObj.text_selectedCategoryInSellerList_xpath).replace("✕","").trim().equals("Transport"),"Category Filter isn't selected when sellers page is clikced for Transport category");
			    break;
			case 1:
				Assert.assertTrue(homePageObj.li_proSellerListforFarm_xpath.size()>0,"Promoted sellers are not displaying for Farm category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    Assert.assertTrue(getText(homePageObj.li_categoryInSellerPage_xpath).trim().equals("Farm"),"User isn't landing to Farm category seller page");
			    Assert.assertTrue(getText(homePageObj.text_selectedCategoryInSellerList_xpath).replace("✕","").trim().equals("Farm"),"Category Filter isn't selected when sellers page is clikced for Farm category");
			    break;
			case 2:
				Assert.assertTrue(homePageObj.li_proSellerListforConstruction_xpath.size()>0,"Promoted sellers are not displaying for Construction category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    Assert.assertTrue(getText(homePageObj.li_categoryInSellerPage_xpath).trim().equals("Construction"),"User isn't landing to Construction category seller page");
			    Assert.assertTrue(getText(homePageObj.text_selectedCategoryInSellerList_xpath).replace("✕","").trim().equals("Construction"),"Category Filter isn't selected when sellers page is clikced for Construction category");
			    break;
			case 3:
				Assert.assertTrue(homePageObj.li_proSellerListforMaterialhandling_xpath.size()>0,"Promoted sellers are not displaying for Material handling category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    Assert.assertTrue(getText(homePageObj.li_categoryInSellerPage_xpath).trim().equals("Material handling"),"User isn't landing to Material handling category seller page");
			    Assert.assertTrue(getText(homePageObj.text_selectedCategoryInSellerList_xpath).replace("✕","").trim().equals("Material handling"),"Category Filter isn't selected when sellers page is clikced for Material handling category");
			    break;
			}
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	/*
	 * Description: Verify page is redirecting to seller details page on clicking the individual sellers 
	 */
	@Test
	public void verifyPageisRedirectingToSellerDetailsPageonClickingIndivisualSeller() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			int num; String title;
			switch(i) {
			case 0:
			    num= Integer.parseInt(generateRandomNumber(0,homePageObj.li_proSellerListforTransport_xpath.size()));
			    title=getAttribute(homePageObj.li_proSellerListforTransport_xpath.get(num),"title");
			    try {
					click(homePageObj.li_proSellerListforTransport_xpath.get(num));
				}catch(Exception E) {
					 jsClick(driver,homePageObj.li_proSellerListforTransport_xpath.get(num));
				}
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
			    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().equals(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    Assert.assertTrue(verifyElementPresent(homePageObj.header_chooseCategoryHeaderinSellerCatlog_xpath),"Choose category header isn't displaying in seller catlog page for Transport category for "+title+" dealer");
			    break;
			case 1:
				    num= Integer.parseInt(generateRandomNumber(0,homePageObj.li_proSellerListforFarm_xpath.size()));
				    title=getAttribute(homePageObj.li_proSellerListforFarm_xpath.get(num),"title");
				    try {
						click(homePageObj.li_proSellerListforFarm_xpath.get(num));
					}catch(Exception E) {
						 jsClick(driver,homePageObj.li_proSellerListforFarm_xpath.get(num));
					}
				    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
				    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().equals(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
				    Assert.assertTrue(verifyElementPresent(homePageObj.header_chooseCategoryHeaderinSellerCatlog_xpath),"Choose category header isn't displaying in seller catlog page for Farm category for "+title+" dealer");
				    break;
			case 2:
			    	num= Integer.parseInt(generateRandomNumber(0,homePageObj.li_proSellerListforConstruction_xpath.size()));
				    title=getAttribute(homePageObj.li_proSellerListforConstruction_xpath.get(num),"title");
				    try {
						click(homePageObj.li_proSellerListforConstruction_xpath.get(num));
					}catch(Exception E) {
						 jsClick(driver,homePageObj.li_proSellerListforConstruction_xpath.get(num));
					}
				    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
				    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().equals(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
				    Assert.assertTrue(verifyElementPresent(homePageObj.header_chooseCategoryHeaderinSellerCatlog_xpath),"Choose category header isn't displaying in seller catlog page for Construction category for "+title+" dealer");
				    break;
			case 3:
				    num= Integer.parseInt(generateRandomNumber(0,homePageObj.li_proSellerListforMaterialhandling_xpath.size()));
				    title=getAttribute(homePageObj.li_proSellerListforMaterialhandling_xpath.get(num),"title");
				    try {
						click(homePageObj.li_proSellerListforMaterialhandling_xpath.get(num));
					}catch(Exception E) {
						 jsClick(driver,homePageObj.li_proSellerListforMaterialhandling_xpath.get(num));
					}
				    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
				    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().equals(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
				    Assert.assertTrue(verifyElementPresent(homePageObj.header_chooseCategoryHeaderinSellerCatlog_xpath),"Choose category header isn't displaying in seller catlog page for MH category for "+title+" dealer");
					break;
			}
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);

		}
	}
	/*
	 * Description: Verify respective category ads are displaying in seller details page on clicking under any category in home page
	 */
	@Test
	public void verifyCategroyAdsDisplayingOnCategroyinHomePage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			int num; String title;
			Assert.assertTrue(verifyElementPresent(homePageObj.link_checkOutourSeller_xpath.get(i)),"Promoted seller list isn't displaying for "+i+" category");
			switch(i) {
			case 0:
				Assert.assertTrue(homePageObj.li_proSellerListforTransport_xpath.size()>0,"Promoted sellers are not displaying for Transport category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    num=Integer.parseInt(generateRandomNumber(0,homePageObj.sellerTilesInSellerListing_xpath.size()));
			    title=getText(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
			    try {
					click(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
			    Assert.assertTrue(getText(homePageObj.title_categoryInSellerCatelog_xpath).trim().equals("Transport"),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().contains(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    break;
			case 1:
				Assert.assertTrue(homePageObj.li_proSellerListforFarm_xpath.size()>0,"Promoted sellers are not displaying for Farm category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    num=Integer.parseInt(generateRandomNumber(0,homePageObj.sellerTilesInSellerListing_xpath.size()));
			    title=getText(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
			    try {
					click(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
			    Assert.assertTrue(getText(homePageObj.title_categoryInSellerCatelog_xpath).trim().equals("Farm"),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().contains(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    break;
			case 2:
				Assert.assertTrue(homePageObj.li_proSellerListforConstruction_xpath.size()>0,"Promoted sellers are not displaying for Construction category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    num=Integer.parseInt(generateRandomNumber(0,homePageObj.sellerTilesInSellerListing_xpath.size()));
			    title=getText(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
			    try {
					click(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
			    Assert.assertTrue(getText(homePageObj.title_categoryInSellerCatelog_xpath).trim().equals("Construction"),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().contains(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    break;
			case 3:
				Assert.assertTrue(homePageObj.li_proSellerListforMaterialhandling_xpath.size()>0,"Promoted sellers are not displaying for Material handling category in Home page");
			    jsClick(driver,homePageObj.link_checkOutourSeller_xpath.get(i));
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.li_categoryInSellerPage_xpath);
			    num=Integer.parseInt(generateRandomNumber(0,homePageObj.sellerTilesInSellerListing_xpath.size()));
			    title=getText(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
			    try {
					click(homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}catch(Exception E) {
					jsClick(driver,homePageObj.title_sellerNameinSellerListing_xpath.get(num));
				}
			    explicitWaitFortheElementTobeVisible(driver,homePageObj.link_sellerPageVerify_xpath);
			    Assert.assertTrue(getText(homePageObj.title_categoryInSellerCatelog_xpath).trim().equals("Material handling"),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    Assert.assertTrue(getText(homePageObj.header_sellerTitle_xpath).trim().contains(title),"Correct dealer name isn't displaying for "+title+ "dealer on navigating from home page");
			    break;
			}
			loadUrl(driver,"https://www.tradus.com/en/");
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
	}
	
	/*
	 * Description: Verify 'SEO' category along with their type links displaying above footer links
	 */
	@Test
	public void verifySEOCategoryareDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		ArrayList<String> actualSEOheaders=new ArrayList<String>(Arrays.asList("Transport", "Farm", "Construction", "Material handling", "Top Manufacturers", "Countries"));
		ArrayList<String> SEOTransportSubCategories=new ArrayList<String>(Arrays.asList("Trucks", "Vans", "Semi-trailers", "Tractor units", "Trailers", "Utility service","Buses / coaches"));
		ArrayList<String> SEOFarmSubCategories=new ArrayList<String>(Arrays.asList("Tractors","Hay/Forage","Fertilizer applicators", "Tillage", "Harvesting", "Planting / Sowing", "Agri trailers", "Livestock equipment", "Forestry machinery", "Garden machinery", "Processing and storage", "Potato equipment", "Wine growing equipment", "Irrigation equipment"));
		ArrayList<String> SEOConstructionSubCategories=new ArrayList<String>(Arrays.asList("Excavators", "Loaders", "Attachments", "Telescopic handlers", "Aerial platforms", "Road construction equipment", "Cranes", "Generators", "Dump trucks", "Crushing equipment", "Dozers", "Compressors Drilling equipment","Concrete equipment"));
		ArrayList<String> SEOMHSubCategories=new ArrayList<String>(Arrays.asList("Forklifts","Stackers","Pallet trucks","Reach trucks", "Container handler", "Order pickers","Side loaders", "Rough terrain forklift", "Other warehouse equipment","Reach stacker","Tow tractor","Narrow aisle truck", "4-Way reach trucks"));
		ArrayList<String> SEOtopManufacturers=new ArrayList<String>(Arrays.asList("Mercedes-Benz","Claas","John Deere","MAN","Caterpillar", "DAF", "Fendt", "Iveco","Krone","Kuhn","Linde", "Massey Ferguson", "New Holland","Other", "Renault", "Scania", "Volvo"));
		ArrayList<String> SEOCountries=new ArrayList<String>(Arrays.asList("Germany","Netherlands","Belgium","Denmark", "France","Czechia", "Poland", "Spain", "Austria", "Italy", "Norway","Sweden","United Kingdom", "Romania", "Ukraine", "Finland", "Russia", "Greece", "Hungary", "Slovakia", "Luxembourg","Turkey","United Arab Emirates","Switzerland","Portugal","Bosnia & Herzegovina", "Ireland","Latvia","Belarus", "Hong Kong SAR China","Japan", "Vietnam"));
	
		List<String> newSEOHeader=new ArrayList<String>();
		for(int i=0;i<homePageObj.link_categoryLinksinBottom_xpath.size();i++) {
			String x=getText(homePageObj.link_categoryLinksinBottom_xpath.get(i)).replace(":","").trim();
			newSEOHeader.add(x);
		}
		Assert.assertTrue(actualSEOheaders.equals(newSEOHeader),"SEO headers aren't displaying correctly in home page");
	}
	/*
	 * Description: Verify Links for corresponding SEO linKs are displaying
	 */
	@Test
	public void verifySubCatgeoriesalongwithSEOLinksareDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		ArrayList<String> SEOTransportSubCategories=new ArrayList<String>(Arrays.asList("Trucks", "Vans", "Semi-trailers", "Tractor units", "Trailers", "Utility service","Buses / coaches"));
		ArrayList<String> SEOFarmSubCategories=new ArrayList<String>(Arrays.asList("Tractors","Hay/Forage","Fertilizer applicators", "Tillage", "Harvesting", "Planting / Sowing", "Agri trailers", "Livestock equipment", "Forestry machinery", "Garden machinery", "Processing and storage", "Potato equipment", "Wine growing equipment", "Irrigation equipment"));
		ArrayList<String> SEOConstructionSubCategories=new ArrayList<String>(Arrays.asList("Excavators", "Loaders", "Attachments", "Telescopic handlers", "Aerial platforms", "Road construction equipment", "Cranes", "Generators", "Dump trucks", "Crushing equipment", "Dozers", "Compressors", "Drilling equipment","Concrete equipment"));
		ArrayList<String> SEOMHSubCategories=new ArrayList<String>(Arrays.asList("Forklifts","Stackers","Pallet trucks","Reach trucks", "Container handler", "Order pickers","Side loaders", "Rough terrain forklift", "Other warehouse equipment","Tow tractor","Reach stacker","Narrow aisle truck", "4-Way reach trucks"));
		ArrayList<String> SEOtopManufacturers=new ArrayList<String>(Arrays.asList("Mercedes-Benz","Claas","John Deere","MAN","Caterpillar", "DAF", "Fendt", "Iveco","Krone","Kuhn","Linde", "Massey Ferguson", "New Holland","Other", "Renault", "Scania", "Volvo"));
		ArrayList<String> SEOCountries=new ArrayList<String>(Arrays.asList("Germany","Netherlands","Belgium","Denmark", "France","Czechia", "Poland", "Spain", "Austria", "Italy", "Norway","Sweden","United Kingdom", "Romania", "Ukraine", "Finland", "Russia", "Greece", "Hungary", "Slovakia", "Luxembourg","Turkey","United Arab Emirates","Switzerland","Portugal","Bosnia & Herzegovina", "Ireland","Latvia","Belarus", "Hong Kong SAR China","Japan", "Vietnam"));
		ArrayList<String> newList=new ArrayList<String>();
		for(int i=0;i<homePageObj.link_categoryLinksinBottom_xpath.size();i++) {
	    switch(i) {
	    case 0:
	    	for(int k=0;k<homePageObj.link_L2CategoriesUnderTransport_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_L2CategoriesUnderTransport_xpath.get(k)).trim());
	    	}
	    	
	    	Assert.assertTrue(SEOTransportSubCategories.equals(newList),"All subCatgeory links aren't displaying properly for Transport category");
	    	newList.clear();
	    	break;
	    case 1:
	    	jsClick(driver,homePageObj.link_showMoreLinkForFarm_xpath);
	    	waitTill(2000);
	    	for(int k=0;k<homePageObj.link_L2CategoriesUnderFarm_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_L2CategoriesUnderFarm_xpath.get(k)).trim());
	    	}
	    	Assert.assertTrue(SEOFarmSubCategories.equals(newList),"All subCatgeory links aren't displaying properly for Farm category");
	    	newList.clear();
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForFarm_xpath).trim().equals("Show less ›"),"Show less links isn't displaying if show more is clicked");
	    	jsClick(driver,homePageObj.link_showMoreLinkForFarm_xpath);
	    	waitTill(2000);
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForFarm_xpath).trim().equals("Show more ›"),"Show more links isn't displaying if show less is clicked");
	    	break;
	    case 2:
	    	jsClick(driver,homePageObj.link_showMoreLinkForConstruction_xpath);
	    	waitTill(2000);
	    	for(int k=0;k<homePageObj.link_L2CategoriesUnderConstruction_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_L2CategoriesUnderConstruction_xpath.get(k)).trim());
	    	}
	    	Assert.assertTrue(SEOConstructionSubCategories.equals(newList),"All subCatgeory links aren't displaying properly for Construction category");
	    	newList.clear();
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForConstruction_xpath).trim().equals("Show less ›"),"Show less links isn't displaying if show more is clicked");
	    	jsClick(driver,homePageObj.link_showMoreLinkForConstruction_xpath);
	    	waitTill(2000);
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForConstruction_xpath).trim().equals("Show more ›"),"Show more links isn't displaying if show less is clicked");
	    	break;
	    case 3:
	    	jsClick(driver,homePageObj.link_showMoreLinkForMH_xpath);
	    	waitTill(2000);
	    	for(int k=0;k<homePageObj.link_L2CategoriesUnderMaterialHandling_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_L2CategoriesUnderMaterialHandling_xpath.get(k)).trim());
	    	}
	        Assert.assertTrue(SEOMHSubCategories.equals(newList),"All subCatgeory links aren't displaying properly for MaterialHandling category");
	    	newList.clear();
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForMH_xpath).trim().equals("Show less ›"),"Show less links isn't displaying if show more is clicked");
	    	jsClick(driver,homePageObj.link_showMoreLinkForMH_xpath);
	    	waitTill(2000);
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForMH_xpath).trim().equals("Show more ›"),"Show more links isn't displaying if show less is clicked");
	    	break;
	    case 4:
	    	jsClick(driver,homePageObj.link_showMoreLinkForTopManufacture_xpath);
	    	waitTill(2000);
	    	for(int k=0;k<homePageObj.link_topManufacturersList_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_topManufacturersList_xpath.get(k)).trim());
	    	}
	    	Assert.assertTrue(SEOtopManufacturers.equals(newList),"All subCatgeory links aren't displaying properly for Top Manufacturers");
	    	newList.clear();
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForTopManufacture_xpath).trim().equals("Show less ›"),"Show less links isn't displaying if show more is clicked");
	    	jsClick(driver,homePageObj.link_showMoreLinkForTopManufacture_xpath);
	    	waitTill(2000);
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForTopManufacture_xpath).trim().equals("Show more ›"),"Show more links isn't displaying if show less is clicked");
	    	break;
	    	
	    case 5:
	    	jsClick(driver,homePageObj.link_showMoreLinkForCountries_xpath);
	    	waitTill(2000);
	    	for(int k=0;k<homePageObj.link_countriesList_xpath.size();k++) {
	    		newList.add(getText(homePageObj.link_countriesList_xpath.get(k)).trim());
	    	}
	    	Assert.assertTrue(SEOCountries.equals(newList),"All subCatgeory links aren't displaying properly for County List");
	    	newList.clear();
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForCountries_xpath).trim().equals("Show less ›"),"Show less links isn't displaying if show more is clicked");
	    	jsClick(driver,homePageObj.link_showMoreLinkForCountries_xpath);
	    	waitTill(2000);
	    	Assert.assertTrue(getText(homePageObj.link_showMoreLinkForCountries_xpath).trim().equals("Show more ›"),"Show more links isn't displaying if show less is clicked");
	    	break;
	    }
	  }
   }
	/*
	 * Description: Verify Back to top and its functionality
	 */
	@Test
	public void verifyBackToTopLinkanditsFunctionlity() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(1000);
		scrollDown(driver);
		waitTill(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_BackToTop_xpath);
		try {
			click(homePageObj.link_BackToTop_xpath);
		}catch(Exception E) {
			jsClick(driver,homePageObj.link_BackToTop_xpath);
		}
		waitTill(3000);
		Long value=(Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(value<100, "Page isn't moving to top of the page when clicked on the Back to top link");
	}
	
	/*
	 * Description: Verify the Tradus logo with a tag on 'an olx company' and text 'Your expert global marketplace for heavy machinery' in footer
	 */
	@Test
	public void verifyTradusLogoaAndCopyRightText() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertTrue(verifyElementPresent(homePageObj.logo_BottomHomePage_xpath),"Tradus logo isn't present in bottom menu");
		Assert.assertTrue(getAttribute(homePageObj.logo_BottomHomePage_xpath,"src").trim().equals("https://www.tradus.com/assets/tradus/app-logo/logo-tradus-olx-white-b05db834c2.svg"),"Correct logo isn't present in bottom menu");
		Assert.assertTrue(verifyElementPresent(homePageObj.tagLine_Tradus_xpath),"Tradus tag Line isn't present in bottom menu");
		Assert.assertTrue(getText(homePageObj.tagLine_Tradus_xpath).trim().equals("Your expert global marketplace for heavy machinery"),"Tradus tag Line isn't correct in bottom menu");
		Assert.assertTrue(verifyElementPresent(homePageObj.para_TradusCopyRight_xpath),"Tradus copy right text isn't present in bottom of the page");
		Assert.assertTrue(getText(homePageObj.para_TradusCopyRight_xpath).trim().equals("© Tradus 2021"),"Tradus copy right Line isn't correct in bottom menu");
	}
	/*
	 * Description: Verify Home, about, Terms of use, Tradus blog, Privacy policy, help, start selling on Tradus and Cookies policy links in footer
	 */
	@Test
	public void verifyFooterLinksAndNavigation() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
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
				//loadUrl(driver,armyTruckNewURL);
				driver.navigate().back();
				explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
				break;
			case 1:
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_aboutUsPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_aboutUsPageVerify_xpath), "About us page isn't displaying on clicking link from bottom menu");
				waitTill(2000);
				driver.navigate().back();
				explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
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
				driver.navigate().back();
				explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
				break; 
			}
		}
	}
	/*
	 * Description: Verify Download the tradus app along with App store and Google store icons are displaying  and their navigation
	 */
	@Test
	public void verifyAppLinksAndTheirNaviagation() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertTrue(homePageObj.link_storeLinks_xpath.size()==2,"Two store Links aren't displaying in bottom of home page");
		String parentWindow=driver.getWindowHandle();
		for(int i=0;i<homePageObj.link_storeLinks_xpath.size();i++) {
			try {
				click(homePageObj.link_storeLinks_xpath.get(i));
			}catch (Exception E) {
				jsClick(driver,homePageObj.link_storeLinks_xpath.get(i));
			}
			waitTill(1000);
			switch(i) {
			case 0:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_PlayStoreVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_PlayStoreVerify_xpath), "Play store page isn't displaying on clicking play store link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break; 
			case 1:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.header_AppStoreVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.header_AppStoreVerify_xpath), "App store page isn't displaying on clicking App store link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
		}
	}
	/*
	 * Description: Verify Youtube, instagram, Facebook and Linkedin links are displaying and redirecting to respective sites
	 */
	@Test
	public void verifySocialLinksandtheirNavigations() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertTrue(homePageObj.link_socialSites_xpath.size()==4,"Four social site Links aren't displaying in bottom of home page");
		String parentWindow=driver.getWindowHandle();
		for(int i=0;i<homePageObj.link_socialSites_xpath.size();i++) {
			try {
				click(homePageObj.link_socialSites_xpath.get(i));
			}catch (Exception E) {
				jsClick(driver,homePageObj.link_socialSites_xpath.get(i));
			}
			waitTill(1000);
			switch(i) {
			case 0:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.title_YouTubePageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.title_YouTubePageVerify_xpath), "Youtube isn't displaying on clicking youtube link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break; 
			case 1:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.title_InstagramPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.title_InstagramPageVerify_xpath), "Instgram page isn't displaying on clicking Instagram link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			case 2:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.title_FBPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.title_FBPageVerify_xpath), "Face book page isn't displaying on clicking FB link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			case 3:
				switchWindow(driver,parentWindow);
				explicitWaitFortheElementTobeVisible(driver,homePageObj.title_LinkedInPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(homePageObj.title_LinkedInPageVerify_xpath), "Linkedin page isn't displaying on clicking Linkedin link from bottom of Home page");
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
		}
	}
	/*
	 * Descritpion:Verify Recently viewed ads section after login
	 */
	@Test
	public void recentlyViewedAdsPostLogin() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertFalse(verifyElementPresent(homePageObj.div_recentlyViewedAds_xpath),"Recenty viewed Ads are displaying before login");
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch(Exception E) {
			 jsClick(driver,homePageObj.link_loginTradus_xpath);
		 }
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
		sendKeys(homePageObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(homePageObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,homePageObj.tradusLoginButton);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Assert.assertTrue(verifyElementPresent(homePageObj.div_recentlyViewedAds_xpath),"Recenty viewed Ads aren't displaying after login");
	}
	/*
	 * Descritpion:Verify all recently viewed ads are displaying under that section
	 */
	@Test
	public void allRecentlyViewedAdsareDisplayingUnderRecentlyViewedAdsListing() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch(Exception E) {
			 jsClick(driver,homePageObj.link_loginTradus_xpath);
		 }
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
		sendKeys(homePageObj.tradusUidInLoginPage,"harish.boyapati+1456@olx.com");
		sendKeys(homePageObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,homePageObj.tradusLoginButton);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		try {
			click(homePageObj.icon_L1Categories_xpath.get(2));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_L1Categories_xpath.get(2));
		}
		waitTill(2000);
		try {
			click(homePageObj.button_searchResult_xpath.get(2));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(2));
			}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
		int size=homePageObj.div_AdHeadinginResults_xpath.size();
		Assert.assertTrue(size>0, "Ads are not displaying in Listing page on visiting for Transport category");
		List<WebElement> results=homePageObj.div_AdHeadinginResults_xpath;
		waitTill(2000);
		try {
			click(results.get(5));
			}catch(Exception E) {
				jsClick(driver,results.get(5));
			}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		ArrayList<String> adIdFromDetails=new ArrayList<String>();
		ArrayList<String> adIdFromrecentlyViewedAds=new ArrayList<String>();
		String temp=getText(adDetailsObj.div_TradusIDInAdDetails_xpath).trim();
		adIdFromDetails.add(temp);
		for(int i=0;i<5;i++) {
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_TradusIDInAdDetails_xpath);
			waitTill(2000);
			temp=getText(adDetailsObj.div_TradusIDInAdDetails_xpath).trim();
			adIdFromDetails.add(temp);
			try {
				click(adDetailsObj.nav_nextButton_xpath);
			}catch (Exception E) {
				jsClick(driver,adDetailsObj.nav_nextButton_xpath);
			}
			waitTill(2000);
		}
		try {
			click(adDetailsObj.logo_tradus_xpath);
		}catch (Exception E) {
			jsClick(driver,adDetailsObj.logo_tradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.div_recentlyViewedAds_xpath);
		//driver.navigate().refresh();
		//explicitWaitFortheElementTobeVisible(driver,homePageObj.div_recentlyViewedAds_xpath);
		int numberOfAds=homePageObj.adTiles_recentlyViewed_xpath.size();
		for(int i=0;i<numberOfAds;i++) {
			String tempID=getAttribute(homePageObj.adTiles_recentlyViewed_xpath.get(i),"data-offer-id").replace("offer-","").trim();
			adIdFromrecentlyViewedAds.add(tempID);
		}
		waitTill(2000);
		//Collections.sort(adIdFromDetails);
	//	Collections.sort(adIdFromrecentlyViewedAds);
		System.out.println(adIdFromDetails);
		System.out.println(adIdFromrecentlyViewedAds);
	//	Assert.assertTrue(adIdFromDetails.equals(adIdFromrecentlyViewedAds),"Recently viewed Ads aren't updating properly");
	}
    /*
     * Description: Verify Navigation to Ad listing page on clicking on search icon 
     */
	@Test
	public void verifyNavigationToAdListingPageOnClickingResultsButtonWithOutApplyingFilters() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdListingTradusPage adDListingObj=new AdListingTradusPage(driver);
		String resultsInHomePage; String resultsInListingPage; 
		String catgories[]= {"results for Transport","results for Farm","results for Construction","results for Material handling"};
		SoftAssert softAssertion= new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		for(int i=0;i<homePageObj.icon_L1Categories_xpath.size();i++) {
			try {
				click(homePageObj.icon_L1Categories_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.icon_L1Categories_xpath.get(i));
			}
			waitTill(1000);
			resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(i)).replace("\n"," ").trim();
			try {
				click(homePageObj.button_searchResult_xpath.get(i));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(i));
			}
			
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on results button for"+i+"th Category");
				 }
			waitTill(2000);
			resultsInListingPage=getText(adDListingObj.text_adCountWithFiltersinListingPage_xpath).replace("cross","").trim();
			softAssertion.assertTrue(resultsInListingPage.contains(catgories[i]),catgories[i]+" isn't displaying near search count in Ad listing page");
			int result_listing=Integer.parseInt(resultsInListingPage.replaceAll("[^0-9]", ""));
			int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
			softAssertion.assertTrue(result_listing>=result_home, "For "+i+" category Ad count from Home page doesn't match with Listing");
			softAssertion.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()<=32 && homePageObj.div_AdTitlesinResults_xpath.size()>=28,"Ads count in Ad listing page might be less than 28 or greater than 32 for "+i+" category");
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		}
		softAssertion.assertAll();
	}
	/*
	 * Description: Verify Listing page after applying all transport category filters
	 */
	@Test
	public void verifyListingPageAfterApplyingAllTransportCategoryFilters() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdListingTradusPage adDListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(0));
		Select make=new Select(homePageObj.dropDown_Make_xpath.get(0));
		Select model=new Select(homePageObj.dropDown_Model_xpath.get(0));
		Select yearFrom=new Select(homePageObj.dropDown_YearFrom_xpath.get(0));
		Select priceUpto=new Select(homePageObj.dropDown_Price_xpath.get(0));
		Select mileageUpto=new Select(homePageObj.dropDown_Mileage_xpath);
		Select weightUpto=new Select(homePageObj.dropDown_Weight_xpath.get(0));
		Select[] filters= {l2,yearFrom,priceUpto,mileageUpto,weightUpto};
		int l2_Num=Integer.parseInt(generateRandomNumber(0, (l2.getOptions()).size()-1));
		
		
		int year_Num=Integer.parseInt(generateRandomNumber(0, (yearFrom.getOptions()).size()-1));
		int price_Num=Integer.parseInt(generateRandomNumber(0, (priceUpto.getOptions()).size()-1));
		int mileage_Num=Integer.parseInt(generateRandomNumber(0, (mileageUpto.getOptions()).size()-1));
		int weight_Num=Integer.parseInt(generateRandomNumber(0, (weightUpto.getOptions()).size()-1));
		int[] temp_Num= {l2_Num,year_Num,price_Num,mileage_Num,weight_Num};
		for(int i=0;i<filters.length;i++) {
			filters[i].selectByIndex(temp_Num[i]);
			waitTill(4000);
			if(i==0) {
				explicitWaitFortheElementTobeVisible(driver,homePageObj.dropDown_Country_xpath.get(0));
				try {
					click(homePageObj.field_Country_xpath.get(0));
				}catch(Exception E) {
					jsClick(driver,homePageObj.field_Country_xpath.get(0));
				}
				waitTill(2000);
				Assert.assertTrue(getAttribute(homePageObj.field_Country_xpath.get(0),"class").contains("ss-open"), "Country dropdown isn't open when clicked on country field in Transport category");
				List<WebElement> countries= homePageObj.div_listOfCountries_xpath;
				System.out.println(countries.size());
				int x=Integer.parseInt(generateRandomNumber(0, countries.size()-1));
				try {
					click(countries.get(x));
				}catch(Exception E) {
					jsClick(driver,countries.get(x));
				}
				waitTill(3000);
				int make_Num=Integer.parseInt(generateRandomNumber(0, (make.getOptions()).size()-1));
				make.selectByIndex(make_Num);
			}
			if(i==1) {
				int size=model.getOptions().size();
				System.out.println(size);
				if(size>1) {
					int model_Num=Integer.parseInt(generateRandomNumber(0, (model.getOptions()).size()-1));
					model.selectByIndex(model_Num);
				}
			}
		}
		String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(0)).replace("\n"," ").trim();
		int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
		System.out.println(resultsInHomePage);
		if(result_home==0) {
			Assert.assertTrue(getAttribute(homePageObj.button_searchResult_xpath.get(0),"aria-disabled").equals("true"),"Result button isn't disabled when results are Zero");
		}
		else {
			try {
				click(homePageObj.button_searchResult_xpath.get(0));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(0));
			}
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on results button for transport Category with other filters");
				 }
			String resultsInListingPage=getText(adDListingObj.text_adCountWithFiltersinListingPage_xpath).replace("cross","").trim();
			String[] elements = resultsInListingPage.split(" "); 
			int result_listing=Integer.parseInt(elements[0].replaceAll("[^0-9]", ""));
			Assert.assertTrue(result_listing>0 || result_listing<=result_home+100, "For transport category Ad count from Home page doesn't match with Listing");
			Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0,"Ads count in Ad listing page isn't correct when transport category applied with other filters");
		}
	}
	
	/*
	 * Description: Verify Listing page after applying all Farm category filters
	 */
	@Test
	public void verifyListingPageAfterApplyingAllFarmCategoryFilters() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdListingTradusPage adDListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		int k=1;
		try {
			click(homePageObj.icon_L1Categories_xpath.get(k));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_L1Categories_xpath.get(k));
		}
		waitTill(1000);
		Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(k));
		Select make=new Select(homePageObj.dropDown_Make_xpath.get(k));
		Select model=new Select(homePageObj.dropDown_Model_xpath.get(k));
		Select yearFrom=new Select(homePageObj.dropDown_YearFrom_xpath.get(k));
		Select priceUpto=new Select(homePageObj.dropDown_Price_xpath.get(k));
		Select[] filters= {l2,yearFrom,priceUpto};
		int l2_Num=Integer.parseInt(generateRandomNumber(0, (l2.getOptions()).size()-1));
		int year_Num=Integer.parseInt(generateRandomNumber(0, (yearFrom.getOptions()).size()-1));
		int price_Num=Integer.parseInt(generateRandomNumber(0, (priceUpto.getOptions()).size()-1));
		int[] temp_Num= {l2_Num,year_Num,price_Num};
		for(int i=0;i<filters.length;i++) {
			filters[i].selectByIndex(temp_Num[i]);
			waitTill(4000);
			if(i==0) {
				explicitWaitFortheElementTobeVisible(driver,homePageObj.dropDown_Country_xpath.get(k));
				try {
					click(homePageObj.field_Country_xpath.get(k));
				}catch(Exception E) {
					jsClick(driver,homePageObj.field_Country_xpath.get(k));
				}
				waitTill(2000);
				Assert.assertTrue(getAttribute(homePageObj.field_Country_xpath.get(k),"class").contains("ss-open"),"Country dropdown isn't open when clicked on country field in Farm category");
				List<WebElement> countries= homePageObj.div_listOfCountries_xpath;
				System.out.println(countries.size());
				int x=Integer.parseInt(generateRandomNumber(0, countries.size()-1));
				try {
					click(countries.get(x));
				}catch(Exception E) {
					jsClick(driver,countries.get(x));
				}
				waitTill(3000);
				int make_Num=Integer.parseInt(generateRandomNumber(0, (make.getOptions()).size()-1));
				make.selectByIndex(make_Num);
			}
			if(i==1) {
				int size=model.getOptions().size();
				System.out.println(size);
				if(size>1) {
					int model_Num=Integer.parseInt(generateRandomNumber(0, (model.getOptions()).size()-1));
					model.selectByIndex(model_Num);
				}
			}
		}
		String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(k)).replace("\n"," ").trim();
		int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
		System.out.println(resultsInHomePage);
		if(result_home==0) {
			Assert.assertTrue(getAttribute(homePageObj.button_searchResult_xpath.get(k),"aria-disabled").equals("true"),"Result button isn't disabled when results are Zero");
		}
		else {
			try {
				click(homePageObj.button_searchResult_xpath.get(k));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(k));
			}
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on results button for transport Category with other filters");
				 }
			String resultsInListingPage=getText(adDListingObj.text_adCountWithFiltersinListingPage_xpath).replace("cross","").trim();
			String[] elements = resultsInListingPage.split(" "); 
			int result_listing=Integer.parseInt(elements[0].replaceAll("[^0-9]", ""));
			Assert.assertTrue(result_listing>0 || result_listing<=result_home+100, "For transport category Ad count from Home page doesn't match with Listing");
			Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0,"Ads count in Ad listing page isn't correct when transport category applied with other filters");
		}
	}
	
	/*
	 * Description: Verify Listing page after applying all Construction category filters
	 */
	@Test
	public void verifyListingPageAfterApplyingAllConstructionCategoryFilters() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdListingTradusPage adDListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		int k=2;
		try {
			click(homePageObj.icon_L1Categories_xpath.get(k));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_L1Categories_xpath.get(k));
		}
		waitTill(1000);
		Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(k));
		Select make=new Select(homePageObj.dropDown_Make_xpath.get(k));
		Select model=new Select(homePageObj.dropDown_Model_xpath.get(k));
		Select yearFrom=new Select(homePageObj.dropDown_YearFrom_xpath.get(k));
		Select priceUpto=new Select(homePageObj.dropDown_Price_xpath.get(k));
		Select weightUpto=new Select(homePageObj.dropDown_Weight_xpath.get(1));
		Select[] filters= {l2,yearFrom,priceUpto,weightUpto};
		int l2_Num=Integer.parseInt(generateRandomNumber(0, (l2.getOptions()).size()-1));
		int year_Num=Integer.parseInt(generateRandomNumber(0, (yearFrom.getOptions()).size()-1));
		int price_Num=Integer.parseInt(generateRandomNumber(0, (priceUpto.getOptions()).size()-1));
		int weight_Num=Integer.parseInt(generateRandomNumber(0, (weightUpto.getOptions()).size()-1));
		int[] temp_Num= {l2_Num,year_Num,price_Num,weight_Num};
		for(int i=0;i<filters.length;i++) {
			filters[i].selectByIndex(temp_Num[i]);
			waitTill(4000);
			if(i==0) {
				explicitWaitFortheElementTobeVisible(driver,homePageObj.dropDown_Country_xpath.get(k));
				try {
					click(homePageObj.field_Country_xpath.get(1));
				}catch(Exception E) {
					jsClick(driver,homePageObj.field_Country_xpath.get(1));
				}
				waitTill(2000);
				Assert.assertTrue(getAttribute(homePageObj.field_Country_xpath.get(1),"class").contains("ss-open"),"Country dropdown isn't open when clicked on country field in Construction category");
				List<WebElement> countries= homePageObj.div_listOfCountries_xpath;
				System.out.println(countries.size());
				int x=Integer.parseInt(generateRandomNumber(0, countries.size()-1));
				try {
					click(countries.get(x));
				}catch(Exception E) {
					jsClick(driver,countries.get(x));
				}
				waitTill(3000);
				int make_Num=Integer.parseInt(generateRandomNumber(0, (make.getOptions()).size()-1));
				make.selectByIndex(make_Num);
			}
			if(i==1) {
				int size=model.getOptions().size();
				System.out.println(size);
				if(size>1) {
					int model_Num=Integer.parseInt(generateRandomNumber(0, (model.getOptions()).size()-1));
					model.selectByIndex(model_Num);
				}
			}
		}
		String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(k)).replace("\n"," ").trim();
		int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
		System.out.println(resultsInHomePage);
		if(result_home==0) {
			Assert.assertTrue(getAttribute(homePageObj.button_searchResult_xpath.get(k),"aria-disabled").equals("true"),"Result button isn't disabled when results are Zero");
		}
		else {
			try {
				click(homePageObj.button_searchResult_xpath.get(k));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(k));
			}
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on results button for transport Category with other filters");
				 }
			String resultsInListingPage=getText(adDListingObj.text_adCountWithFiltersinListingPage_xpath).replace("cross","").trim();
			String[] elements = resultsInListingPage.split(" "); 
			int result_listing=Integer.parseInt(elements[0].replaceAll("[^0-9]", ""));
			Assert.assertTrue(result_listing>0 || result_listing<=result_home+100, "For transport category Ad count from Home page doesn't match with Listing");
			Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0,"Ads count in Ad listing page isn't correct when transport category applied with other filters");
		}
	}
	
	/*
	 * Description: Verify Listing page after applying all Material handling category filters
	 */
	@Test
	public void verifyListingPageAfterApplyingAllMaterialHandlingCategoryFilters() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		AdListingTradusPage adDListingObj=new AdListingTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		int k=3;
		try {
			click(homePageObj.icon_L1Categories_xpath.get(k));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_L1Categories_xpath.get(k));
		}
		waitTill(1000);
		Select l2=new Select(homePageObj.dropDown_L2Categories_xpath.get(k));
		Select make=new Select(homePageObj.dropDown_Make_xpath.get(k));
		Select model=new Select(homePageObj.dropDown_Model_xpath.get(k));
		Select yearFrom=new Select(homePageObj.dropDown_YearFrom_xpath.get(k));
		Select priceUpto=new Select(homePageObj.dropDown_Price_xpath.get(k));
		Select[] filters= {l2,yearFrom,priceUpto};
		int l2_Num=Integer.parseInt(generateRandomNumber(0, (l2.getOptions()).size()-1));
		int year_Num=Integer.parseInt(generateRandomNumber(0, (yearFrom.getOptions()).size()-1));
		int price_Num=Integer.parseInt(generateRandomNumber(0, (priceUpto.getOptions()).size()-1));
		int[] temp_Num= {l2_Num,year_Num,price_Num};
		for(int i=0;i<filters.length;i++) {
			filters[i].selectByIndex(temp_Num[i]);
			waitTill(4000);
			if(i==0) {
				explicitWaitFortheElementTobeVisible(driver,homePageObj.dropDown_Country_xpath.get(k));
				try {
					click(homePageObj.field_Country_xpath.get(1));
				}catch(Exception E) {
					jsClick(driver,homePageObj.field_Country_xpath.get(1));
				}
				waitTill(2000);
				Assert.assertTrue(getAttribute(homePageObj.field_Country_xpath.get(1),"class").contains("ss-open"),"Country dropdown isn't open when clicked on country field in Material Handling category");
				List<WebElement> countries= homePageObj.div_listOfCountries_xpath;
				System.out.println(countries.size());
				int x=Integer.parseInt(generateRandomNumber(0, countries.size()-1));
				try {
					click(countries.get(x));
				}catch(Exception E) {
					jsClick(driver,countries.get(x));
				}
				waitTill(3000);
				int make_Num=Integer.parseInt(generateRandomNumber(0, (make.getOptions()).size()-1));
				make.selectByIndex(make_Num);
			}
			if(i==1) {
				int size=model.getOptions().size();
				System.out.println(size);
				if(size>1) {
					int model_Num=Integer.parseInt(generateRandomNumber(0, (model.getOptions()).size()-1));
					model.selectByIndex(model_Num);
				}
			}
		}
		String resultsInHomePage=getText(homePageObj.button_searchResult_xpath.get(k)).replace("\n"," ").trim();
		int result_home=Integer.parseInt(resultsInHomePage.replaceAll("[^0-9]", ""));
		System.out.println(resultsInHomePage);
		if(result_home==0) {
			Assert.assertTrue(getAttribute(homePageObj.button_searchResult_xpath.get(k),"aria-disabled").equals("true"),"Result button isn't disabled when results are Zero");
		}
		else {
			try {
				click(homePageObj.button_searchResult_xpath.get(k));
			}catch(Exception E) {
				jsClick(driver,homePageObj.button_searchResult_xpath.get(k));
			}
			try {
				 explicitWaitFortheElementTobeVisible(driver,homePageObj.span_listingPageVerify_xpath);
			 }catch(Exception E) {
					 Assert.assertTrue(verifyElementPresent(homePageObj.span_listingPageVerify_xpath), "Listing page isn't displayed when clicked on results button for transport Category with other filters");
				 }
			String resultsInListingPage=getText(adDListingObj.text_adCountWithFiltersinListingPage_xpath).replace("cross","").trim();
			String[] elements = resultsInListingPage.split(" "); 
			int result_listing=Integer.parseInt(elements[0].replaceAll("[^0-9]", ""));
			Assert.assertTrue(result_listing>0 || result_listing<=result_home+100, "For transport category Ad count from Home page doesn't match with Listing");
			Assert.assertTrue(homePageObj.div_AdTitlesinResults_xpath.size()>0,"Ads count in Ad listing page isn't correct when transport category applied with other filters");
		}
	}
	
	/*
	 * Descritpion: Test country dropdown in Home page filter
	 */
	@Test
	public void countryDropdowninHomePage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.dropDown_Country_xpath.get(0));
		try {
			click(homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}
		waitTill(2000);
		Assert.assertTrue(getAttribute(homePageObj.field_Country_xpath.get(0),"class").contains("ss-open"),"Country dropdown isn't open when clicked on country field in Transport category");
		Assert.assertTrue(getAttribute(homePageObj.icon_addIconInCountryDropdown_xpath.get(0),"class").equals("ss-plus ss-cross"),"Plus icon isn't changing to cross icon when clicked");
		List<WebElement> countries= homePageObj.div_listOfCountries_xpath;
		try {
			click(countries.get(1));
		}catch(Exception E) {
			jsClick(driver,countries.get(1));
		}
		Assert.assertTrue(getAttribute(homePageObj.icon_addIconInCountryDropdown_xpath.get(0),"class").equals("ss-plus"),"Cross icon isn't changing to plus on selecting country");
		
		//String s=getText(homePageObj.span_SelectedCountry_xpath.get(0));
		//System.out.println(s);
		try {
			click(homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.icon_addIconInCountryDropdown_xpath.get(0));
		}
		waitTill(2000);
		Assert.assertTrue(getAttribute(homePageObj.div_listOfCountries_xpath.get(1),"class").equals("ss-option multiple-select__option ss-disabled ss-option-selected"),"Seleted option isn't disabled when selected");
		sendKeys(homePageObj.input_SearchBoxUnderCountryDropdown_xpath.get(0),"Net");
		waitTill(1000);
		try {
			click(homePageObj.div_listOfCountries_xpath.get(0));
		}catch(Exception E) {
			jsClick(driver,homePageObj.div_listOfCountries_xpath.get(0));
		}
		String[] EU_Countries={"Netherlands","Germany"};
		for(int i=0;i<homePageObj.span_SelectedCountry_xpath.size();i++) {
			Assert.assertTrue(getText(homePageObj.span_SelectedCountry_xpath.get(i)).equals(EU_Countries[i]),"Selected "+EU_Countries[i]+ "name isn't displaying in Country dropdown");
		}
		for(int i=0;i<homePageObj.icon_deleteIconNearSelectedCountry_xpath.size();i++) {
			jsClick(driver,homePageObj.icon_deleteIconNearSelectedCountry_xpath.get(i));
			if(i==1) 
				Assert.assertTrue(getText(homePageObj.span_emptyCountryDropdown_xpath.get(i)).equals("Any"),"'Any' text isn't displaying upon deleting all countries");
			else
			    Assert.assertFalse(getText(homePageObj.span_SelectedCountry_xpath.get(i)).equals(EU_Countries[i]),"Removed "+EU_Countries[i]+ "name is still displaying in Country dropdown");
			   waitTill(1000);
		}
	}
	/*
	 * Description: Verify the ads in home page, ad view page and in ad listing page by changing the currency from header in home page
	 */
	@Test
	public void verifyCurrencyUnitsAreUpdatingOnChangingCurrencyType() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch(Exception E) {
			 jsClick(driver,homePageObj.link_loginTradus_xpath);
		 }
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tradusUidInLoginPage);
		sendKeys(homePageObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
		sendKeys(homePageObj.tradusPWDInLoginPage,"sunfra123");
		jsClick(driver,homePageObj.tradusLoginButton);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		String[] currencyType= {"USD","GBP","PLN","EUR"};
		String[] currencyIcon= {"$","£","PLN","€"};
		Select s =new Select(homePageObj.dropdown_currency_xpath);
		for(int c=0;c<currencyType.length;c++) {
			s.selectByValue(currencyType[c]);
			waitTill(2000);
			for(int i=0;i<homePageObj.price_FeaturedOffersForTransport_xpath.size();i++) {
				String temp=getText(homePageObj.price_FeaturedOffersForTransport_xpath.get(i)).trim();
				if(!temp.equals("On request") && !temp.equals("Auction")) {
					Assert.assertTrue(temp.contains(currencyIcon[c]),"Unit isn't changing properly on updating currency type to "+currencyType[c]+" for featured offer"+i+" ad");
				}
			}
			for(int i=0;i<homePageObj.adTiles_recentlyViewed_xpath.size();i++) {
				String temp=getText(homePageObj.span_priceInRecentlyViewedAds_xpath.get(i)).trim();
				if(!temp.equals("On request") && !temp.equals("Auction")) {
					Assert.assertTrue(temp.contains(currencyIcon[c]),"Unit isn't changing properly on updating currency type to "+currencyType[c]+" for "+i+" featured offer");
					}	
			}
			Assert.assertTrue(getText(homePageObj.span_unitNearPriceFilter_xpath.get(0)).trim().equals(currencyType[c]),"Currency unit isn't updating properly near price filter upon updating the currency type to"+currencyType[c]);
		    String temp=getText(homePageObj.h4_AdPriceinOfferOfTheDay_xpath.get(0)).trim();
		    if(!temp.equals("On request") && !temp.equals("Auction")) {
				Assert.assertTrue(temp.contains(currencyIcon[c]),"Unit isn't changing properly near offer of the day on updating currency type to "+currencyType[c]);
			}
		}
	}
}

