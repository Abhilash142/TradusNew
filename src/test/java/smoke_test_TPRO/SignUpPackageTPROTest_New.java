package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.getAttribute;


import static com.tradus.core.GlobalConstants.userName;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

import sanity_test_TPRO.CommonMethods;

public class SignUpPackageTPROTest_New extends BaseClass {
	
	/*
	 * Description: Verify page is redirecting to TPRO landing page on clicking TPRO icon in header
	 */
	@Test
	public void verifyPageisRedirectingToTProLandingPage() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifyRedirectionofTPROLandingPageonClickingTPROIconinHeader(driver);
	}
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	@Test
	public void verifyLanguageDropdownandAllOptions() throws Exception{
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
	}
	
	/*
	 * Description: Validate supportsilder's presence and functionalities
	 */
	@Test
	public void validateSupportSlider() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.validateSupportSlider(driver);
	}
	
	/*
	 * Description: Verify the first step 'Package' is highlighted
	 */
	@Test
	public void verifyPackageSectionIsHighlighted() throws Exception
	{
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tabInfo);
		Assert.assertTrue((signUpPackageObj.tabInfo).getCssValue("background-color").equals("rgba(0, 171, 189, 1)"),"Package section is not highlighted");
	}
	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	
	@Test
	public void verifySignInLinkandItsNavigation() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifySignInLinkandItsNavigation(driver);
	}

	/*
	 * Description:Verify two tabs 'For businesses' and 'For individuals' are displaying under '1. Please select your plan'' text
	 * and Verify able to switch from businesses tab to individaul tab & viceversa
	 */
	@Test
	public void verifyTwoTabswithPleaseSelectYourPlanText() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		Assert.assertTrue(getText(signUpPackageObj.packagePageVerificationElement).equals("1. Please select your plan"),
				"Please select your plan text has been changed");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.forBusinessButton),"For business tab in package page is not present");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.forIndivisualsButton),"For private tab in package page is not present");
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.indivisualPackageVerificationElement);
		Assert.assertTrue(signUpPackageObj.packageTiles.size()==2, "Indivisual package page is not displaying on clicking the tab in packages page");
		jsClick(driver,signUpPackageObj.forBusinessButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.businessPackageVerificationElement);
		waitTill(1000);
		Assert.assertTrue(signUpPackageObj.packageTiles.size()==2, "Business package page is not displaying on clicking the tab in packages page");
	}
	
	/*
	 * Description: Verify two packages namely 'Tradus Basic' and 'Tradus premium' are displaying in businesses tab
	 */
	@Test
	public void verifyPackagesinBusinessTab() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusBasicPackage), "Tradus Basic package is not present for business users");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusPremiumPackage), "Tradus Premium package is not present for business users");
	}

	/*
	 * Description: Contact form Validation
	 */
	@Test
	public void validateContactForm() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packageSlider);
		waitTill(2000);
		Actions a=new Actions(driver);
		a.dragAndDrop(signUpPackageObj.packageSlider,signUpPackageObj.numberOfListingInListingBar.get(8)).build().perform();
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.contactSales);
		jsClick(driver,signUpPackageObj.contactSales);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.EmailInputFieldInSupportForm);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.FullNameInputFieldInSupportForm), "Full name field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.EmailInputFieldInSupportForm), "Email field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.companyNameInputFieldInSupportForm), "Company field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.PhoneInputFieldInSupportForm), "Phone number field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.SubmitButtonInSupportForm), "Submit button is not present in support form");
		sendKeys(signUpPackageObj.FullNameInputFieldInSupportForm,"Testing");
		sendKeys(signUpPackageObj.EmailInputFieldInSupportForm,userName);
		sendKeys(signUpPackageObj.companyNameInputFieldInSupportForm,"Tradus");
		sendKeys(signUpPackageObj.PhoneInputFieldInSupportForm,"+919999999999");
		/*try {
			click(signUpPackageObj.SubmitButtonInSupportForm);
		}catch(Exception E) {
			//jsClick(driver,signUpPackageObj.SubmitButtonInSupportForm);
			actionClick(driver,signUpPackageObj.SubmitButtonInSupportForm);
		}
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.SuccessmessageofSupportForm);	
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.SuccessmessageofSupportForm), "Success message not displaying on submitting the support form");*/
	}
	
	/*
	 * Description: Verify inside content of business package
	 */
	@Test
	public void verifyInsidecontentofBusinessPackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue(signUpPackageObj.basicPackageHighlights.size()==3, "Three highlights are not displaying in starter package");
		Assert.assertTrue(signUpPackageObj.premiumPackageHighlights.size()==6, "Six highlights are not displaying in smart package");
        //for starter package
		for(int i=0;i<signUpPackageObj.basicPackageHighlights.size();i++) {
			switch (i) {
				case 0:
					Assert.assertTrue(getText(signUpPackageObj.basicPackageHighlights.get(i)).equals("Post to Tradus.com"), "Post to Tradus.com info in Basic package isn't correct");
			        break;
				case 1:
					Assert.assertTrue(getText(signUpPackageObj.basicPackageHighlights.get(i)).equals("Real-time market insights"), "Real-time market insights info in Basic package isn't correct");
			        break;
				case 2:
					Assert.assertTrue(getText(signUpPackageObj.basicPackageHighlights.get(i)).equals("Manual ad “bump up”"), "Manual Ad bump up info in Basic package isn't correct");
			        break;
			}
		}
		
		for(int i=0;i<signUpPackageObj.premiumPackageHighlights.size();i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("All benefits from Basic package"), "All features from Basic package in Premium package isn't correct");
		        break;
			case 1:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("Automatic ad bump up"), "Bump up info in premium package isn't correct");
		        break;
			case 2:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("Eligible for offer of the day on homepage"), "Offer of the day info in Premium package isn't correct");
		        break;
			case 3:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("Eligible for featured offer on homepage"), "Featured offer info in Premium package isn't correct");
		        break;
			case 4:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("Top ads on listing page"), "Top ads on listing page info in Premium package isn't correct");
		        break;
			case 5:
				Assert.assertTrue(getText(signUpPackageObj.premiumPackageHighlights.get(i)).equals("Cross-post to OtomotoProfi"), "Cross-post to OtomotoProfi info in Premium package isn't correct");
		        break;
			}
		}
	}
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in Basic and Premium package and verify custom box along with 'Contact sales' link is displaying beside packages
	 */
	@Test
	public void packagePriceandPricePerAdsareChangingOnSelectingNumberofListinginBusinessPackage() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		String[][] arr1 = { { "10,00", "10,00" }, { "6,00", "30,00" }, { "5,00", "50,00" }, { "4,00", "80,00" },
				{ "3,50", "105,00" }, { "3,25", "130,00" }, { "3,00", "150,00" }, { "2,50", "175,00" } };
		String[][] arr2 = { { "13,00", "13,00" }, { "7,80", "39,00" }, { "6,50", "65,00" }, { "5,20", "104,00" },
				{ "4,57", "137,00" }, { "4,22", "169,00" }, { "3,90", "195,00" }, { "3,26", "228,00" } };
		Actions a=new Actions(driver);
		int size=pkjPgObj.numberOfListingInListingBar.size();
		for (int i = 0; i < size; i++) {
			a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(i)).build().perform();
			waitTill(2000);
			if(i==size-1) {
				explicitWaitFortheElementTobeVisible(driver,pkjPgObj.contactSales);
				Assert.assertTrue(getText(pkjPgObj.contactSalesTile).replace("\n",",").trim().equals("Custom,Want to list more than 70 ads per month?,Our sales team will give you a quote customized to your needs.,CONTACT SALES"), "Custom section in packages page is incorrect");
				Assert.assertTrue(verifyElementPresent(pkjPgObj.contactSales), "Contact sales link is not present in custom section");
				break;
			}
		    Assert.assertTrue(
					getText(pkjPgObj.basicPackagePriceText).replaceAll("[^0-9,]", "").trim().equals(arr1[i][0]),
					"Price isn't correct for" + i + " th slider value in basic package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.basicPackagePriceText).contains("€"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.basicPackagePriceperMonth).replaceAll("[^0-9,]", "").trim().equals(arr1[i][1]),
					"Price per listing isn't correct for " + i
							+ " th dropdown value in basic package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.basicPackagePriceperMonth).contains("€"),
					"Unit isn't present in price per listing");
			Assert.assertTrue(
					getText(pkjPgObj.premiumPackagePriceText).replaceAll("[^0-9,]", "").trim().equals(arr2[i][0]),
					"Price isn't correct for" + i + " th dropdown value in premium package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.premiumPackagePriceText).contains("€"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.premiumPackagePriceperMonth).replaceAll("[^0-9,]", "").trim().equals(arr2[i][1]),
					"Price per listing isn't correct for " + i
							+ " th dropdown value in premium package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.premiumPackagePriceperMonth).contains("€"),
					"Unit isn't present in price per listing");
		}
	}
	
	/*
	 * Description: Verify able to select any package from basic package and proceed to next step
	 */
	@Test
	public void verfyAbletoSelectanyPackageandProceedtonextStep() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		Actions a=new Actions(driver);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(0)).build().perform();
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
	    	click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("1 listing"), "1 listing isn't displaying in monthly cost page");
		try{
	    	click(accountsObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(4)).build().perform();
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
	    	click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 30 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("30 listings"), "30 listing isn't displaying in monthly cost page");
		try{
			click(accountsObj.backButton);;
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(7)).build().perform();
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
			click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 70 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("70 listings"), "70 listing isn't displaying in monthly cost page");
	}
	
	/*
	 * Description: Verify able to select Premium package from premium package and proceed to next step
	 */
	@Test
	public void verifyAbletoSelectPremiumPackageandGoToNextstep() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		waitTill(2000);
		Actions a=new Actions(driver);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(0)).build().perform();
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
			click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("1 listing"), "1 listing isn't displaying in monthly cost page");
		try{
			click(accountsObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(5)).build().perform();
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
			click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 40 listing from premium package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("40 listings"), "40 listings isn't displaying in monthly cost page");
		try{
			click(accountsObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.listingBarinPackagePage);
		a.dragAndDrop(pkjPgObj.packageSlider,pkjPgObj.numberOfListingInListingBar.get(7)).build().perform();
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		try{
			click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 70 listing from premium package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("70 listings"), "70 listings isn't displaying in monthly cost page");
	}
	/*
	 * Description: Verify two packages namely 'Tradus Basic' and 'Tradus premium' are displaying in indivisual tab
	 */
	@Test
	public void verifyPackagesinIndivisualTab() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusBasicPackage), "Tradus Basic package is not present for business users");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusPremiumPackage), "Tradus Premium package is not present for business users");
	}
	
	/*
	 * Description: Verify inside content of indivisual package
	 */
	@Test
	public void verifyInsidecontentofPrivatePackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		waitTill(1000);
		//System.out.println(getText(signUpPackageObj.tradusBasicPackage).replace("\n",",").trim());
		//System.out.println(getText(signUpPackageObj.tradusPremiumPackage).replace("\n",",").trim());
		Assert.assertTrue(getText(signUpPackageObj.tradusBasicPackage).replace("\n",",").trim().equals("Tradus Basic,1 listing,€ 10,00,Per listing,€ 10,00 per month,Post to Tradus.com,Real-time market insights,Manual ad “bump up”,* Prices excluding VAT"),"Basic package Listing package insights are not correct for Indivisual user");
		Assert.assertTrue(getText(signUpPackageObj.tradusPremiumPackage).replace("\n",",").trim().equals("Tradus Premium,1 listing,€ 13,00,Per listing,€ 13,00 per month,All benefits from Basic package,Automatic ad bump up,Eligible for offer of the day on homepage,Eligible for featured offer on homepage,Top ads on listing page,Cross-post to OtomotoProfi,* Prices excluding VAT"),"Premium package insights are not correct for Indivisual user");
	}
	
	/*
	 * Description:Verify able to proceed to next step on choosing the individual package
	 */
	@Test
	public void verifyAbletoProceedtoNextsteponChoosingtheIndivisualPackage() throws Exception{
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		waitTill(1000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.nextButton);
		try{
			click(signUpPackageObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,signUpPackageObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		//System.out.println(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim());
		Assert.assertTrue(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim().equals("€ 10,00,Excluding VAT"), "1 listing isn't displaying in monthly cost page for indivisual basic package");
		try{
			click(accountsObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.packagePageVerificationElement);
		waitTill(1000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		try{
			click(signUpPackageObj.tradusPremiumPackage);
		}catch(Exception E) {
			jsClick(driver,signUpPackageObj.tradusPremiumPackage);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.nextButton);
		jsClick(driver,signUpPackageObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		//System.out.println(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim());
		Assert.assertTrue(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim().equals("€ 13,00,Excluding VAT"), "1 listing isn't displaying in monthly cost page for basic package");
	}
	
	/*
	 * Description: Verify listing bar is displaying for company/bussiness users
	 */
	@Test
	public void verifyListingBarisDispalayingForCompanyUser() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		try {
			explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.listingBarinPackagePage);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(signUpPackageObj.listingBarinPackagePage),"Listing Bar isn't displaying in Company user package page");
		}
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.indivisualPackageVerificationElement);
		Assert.assertFalse(verifyElementPresent(signUpPackageObj.listingBarinPackagePage),"Listing Bar is displaying in Private user package page");
	}
	
	/*
	 * Description: Verify the bar toggle is on 40 count and basic package is highlighted on visiting the page
	 */
	@Test
	public void verifyBarToggleIsOn40CountandBasicPackageIsHighlighted() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.listingBarinPackagePage);
		waitTill(2000);
		Assert.assertTrue(getAttribute(signUpPackageObj.numberOfListingInListingBar.get(5),"class").trim().equals("text-sm transition transition-all duration-250 ease-in-out font-bold text-secondary text-base pt-3"),"Bar toggle isn't at 40 on vising the package page");
	   // System.out.println(signUpPackageObj.tradusBasicPackage.getCssValue("style"));
	    Assert.assertTrue(getAttribute(signUpPackageObj.tradusBasicPackage,"class").trim().equals("block package rounded-lg shadow border-solid bg-white w-full cursor-pointer border-2 border-shamrock"),"Tradus basic package isn't highlighted on vising the package page");
	    Assert.assertTrue(getText(signUpPackageObj.numberOfListinginBasicPackage).trim().equals("40 listings"),"Basic package isn't displaying for 40 listing");
	    Assert.assertTrue(getText(signUpPackageObj.numberOfListinginPremiumPackage).trim().equals("40 listings"),"Premium package isn't displaying for 40 listing");
	}
}
