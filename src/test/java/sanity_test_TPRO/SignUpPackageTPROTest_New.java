package sanity_test_TPRO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.SignUpPackageOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.tradus.pro.pages.OverviewTradusPROPage;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

import static com.tradus.core.GlobalConstants.userName;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.getCurrentUrl;


import java.util.List;

public class SignUpPackageTPROTest_New extends BaseClass{
	
	/*
	 * Description: Verify page is redirecting to TPRO landing page on clicking TPRO icon in header
	 */
	@Test
	public void verifyPageisRedirectingToLandingPageTPro() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
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
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
	}
	
	/*
	 * Description: Validate supportsilder's presence and functionalities
	 */
	@Test
	public void validateSupportSlider() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		CommonMethods cm=new CommonMethods();
		cm.validateSupportSlider(driver);
	}
	
	/*
	 * Description:Verify 'Intelligent tools & data', 'Heavy machinery only' and 'Easy international trade' info is displaying under 'The benefits of selling on Tradus PRO Staging' text in left side of the page
	 */
	@Test
	public void verifyBenifitsSection() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		CommonMethods cm=new CommonMethods();
		cm.verifyBenifitSectionandCorrespondingText(driver);
	}

	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	
	@Test
	public void verifySignInLinkandItsNavigation() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		CommonMethods cm=new CommonMethods();
		cm.verifySignInLinkandItsNavigation(driver);
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
	 * Description:Verify two tabs 'For businesses' and 'For individuals' are displaying under '1. Please select your plan'' text
	 * and Verify able to switch from businesses tab to individaul tab & viceversa
	 */
	@Test
	public void verifyTwoTabswithPleaseSelectYourPlanText() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		Assert.assertTrue(getText(signUpPackageObj.packagePageVerificationElement).equals("1. Please select your plan"),
				"Please select your plan text has been changed");
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.forBusinessButton),"For business tab in package page is not present");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.forIndivisualsButton),"For private tab in package page is not present");
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.indivisualPackageVerificationElement);
		waitTill(1000);
		Assert.assertTrue(signUpPackageObj.packageTiles.size()==2, "Indivisual package page is not displaying on clicking the tab in packages page");
		jsClick(driver,signUpPackageObj.forBusinessButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.businessPackageVerificationElement);
		waitTill(1000);
		Assert.assertTrue(signUpPackageObj.packageTiles.size()==3, "Business package page is not displaying on clicking the tab in packages page");
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
	 * Description: Verify 'Price excluding VAT' text is displaying below the package boxes
	 */
	@Test
	public void verifyPriceExcludingVATtestisPresentbelowPackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		waitTill(2000);
		int size=signUpPackageObj.exculdingVatText.size();
		Assert.assertTrue(size==2, "3 Excluding VAT text isn't present in dealer's package selection page");
		for(int i=0;i<size;i++) {
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.exculdingVatText.get(i)), "Excluding VAT text is not present");
		Assert.assertTrue(getText(signUpPackageObj.exculdingVatText.get(i)).trim().equals("* Prices excluding VAT"), "Excluding VAT text is not correct");
	}
	}
	
	/*
	 * Description: Verify custom box along with 'Contact sales' link is displaying beside packages
	 */
	@Test
	 public void verifyCustomBoxwithContactSalesLink() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.packageTiles.get(2)), "Custome section isn't present in Packages page");
		Assert.assertTrue(getText(signUpPackageObj.packageTiles.get(2)).replace("\n",",").trim().equals("Custom,Want to list more than 70 ads per month?,Our sales team will give you a quote customized to your needs.,CONTACT SALES"), 
				"Custom section in packages page is incorrect");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.contactSales), "Contact sales link is not present in custom section");

	}
	
	/*
	 * Description: Contact form Validation
	 */
	@Test
	public void validateContactForm() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.contactSales);
		jsClick(driver,signUpPackageObj.contactSales);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.EmailInputFieldInSupportForm);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.FullNameInputFieldInSupportForm), "Full name field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.EmailInputFieldInSupportForm), "Email field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.PhoneInputFieldInSupportForm), "Phone number field is not present in support form");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.SubmitButtonInSupportForm), "Submit button is not present in support form");
		sendKeys(signUpPackageObj.FullNameInputFieldInSupportForm,"Testing");
		sendKeys(signUpPackageObj.EmailInputFieldInSupportForm,userName);
		sendKeys(signUpPackageObj.PhoneInputFieldInSupportForm,"31777888999");
		jsClick(driver,signUpPackageObj.SubmitButtonInSupportForm);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.SuccessmessageofSupportForm);	
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.SuccessmessageofSupportForm), "Success message not displaying on submitting the support form");
	}
	
	/*
	 * Description: Verify inside content of business package
	 */
	@Test
	public void verifyInsidecontentofBusinessPackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		
		Assert.assertTrue(signUpPackageObj.basicPackageHighlights.size()==1, "Two highlights are not displaying in starter package");
		Assert.assertTrue(signUpPackageObj.premiumPackageHighlights.size()==6, "Five highlights are not displaying in smart package");
        //for starter package
		for(int i=0;i<signUpPackageObj.basicPackageHighlights.size();i++) {
			switch (i) {
				case 0:
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
	 * Description: Verify inside content of indivisual package
	 */
	@Test
	public void verifyInsidecontentofPrivatePackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		waitTill(1000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		waitTill(1000);
		//System.out.println(getText(signUpPackageObj.tradusBasicPackage).replace("\n",",").trim());
		//System.out.println(getText(signUpPackageObj.tradusPremiumPackage).replace("\n",",").trim());
		Assert.assertTrue(getText(signUpPackageObj.tradusBasicPackage).replace("\n",",").trim().equals("Tradus Basic,1 listing,€10.00,Per listing,€10.00 per month,Manual ad “bump up”,* Prices excluding VAT"),"Basic package Listing package insights are not correct for Indivisual user");
		Assert.assertTrue(getText(signUpPackageObj.tradusPremiumPackage).replace("\n",",").trim().equals("Tradus Premium,1 listing,€13.00,Per listing,€13.00 per month,All benefits from Basic package,Automatic ad bump up,Eligible for offer of the day on homepage,Eligible for featured offer on homepage,Top ads on listing page,Cross-post to OtomotoProfi,* Prices excluding VAT"),"Premium package insights are not correct for Indivisual user");
	}
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in Basic package
	 */
	/*@Test
	public void packagePriceandPriceperAdsarechangingonSelectingnumberofListinginBasicPackage() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninBasicPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninBasicPackage);
		List<WebElement> allOptions = s.getOptions();
		String[][] arr = { { "10.00", "10.00" }, { "6.00", "30.00" }, { "5.00", "50.00" }, { "4.00", "80.00" },
				{ "3.50", "105.00" }, { "3.25", "130.00" }, { "3.00", "150.00" }, { "2.50", "175.00" } };
		for (int i = 0; i < allOptions.size(); i++) {
			click(allOptions.get(i));
			waitTill(2000);
			//System.out.println(getText(pkjPgObj.basicPackagePriceText).replaceAll("[^0-9.]", "").trim());
			Assert.assertTrue(
					getText(pkjPgObj.basicPackagePriceText).replaceAll("[^0-9.]", "").trim().equals(arr[i][0]),
					"Price isn't correct for" + i + " th dropdown value in basic package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.basicPackagePriceText).contains("€"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.basicPackagePriceperListing).replaceAll("[^0-9.]", "").trim().equals(arr[i][1]),
					"Price per listing isn't correct for " + i
							+ " th dropdown value in basic package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.basicPackagePriceperListing).contains("€"),
					"Unit isn't present in price per listing");
		}
	}*/
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in Premium package
	 */
	/*@Test
	public void packagePriceandPriceperAdsarechangingonSelectingnumberofListinginPremiumPackage() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninPremiumPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninPremiumPackage);
		List<WebElement> allOptions = s.getOptions();
		String[][] arr = { { "13.00", "13.00" }, { "7.80", "39.00" }, { "6.50", "65.00" }, { "5.20", "104.00" },
				{ "4.57", "137.00" }, { "4.22", "169.00" }, { "3.90", "195.00" }, { "3.26", "228.00" } };
		for (int i = 0; i < allOptions.size(); i++) {
			click(allOptions.get(i));
			waitTill(2000);
			Assert.assertTrue(
					getText(pkjPgObj.premiumPackagePriceText).replaceAll("[^0-9.]", "").trim().equals(arr[i][0]),
					"Price isn't correct for" + i + " th dropdown value in premium package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.premiumPackagePriceText).contains("€"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.premiumPackagePriceperListing).replaceAll("[^0-9.]", "").trim().equals(arr[i][1]),
					"Price per listing isn't correct for " + i
							+ " th dropdown value in premium package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.premiumPackagePriceperListing).contains("€"),
					"Unit isn't present in price per listing");
		}
	}*/
	
	/*
	 * Description: Verify able to select any package from basic package and proceed to next step
	 */
	@Test
	public void verfyAbletoSelectanyPackageandProceedtonextStep() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninBasicPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninBasicPackage);
		s.selectByValue("114");
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
		s.selectByValue("118");
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		waitTill(1000);
		try{
	    	click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("30 listings"), "30 listing isn't displaying in monthly cost page");
		try{
			click(accountsObj.backButton);;
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		s.selectByValue("121");
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		waitTill(1000);
		try{
			click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("70 listings"), "30 listing isn't displaying in monthly cost page");
	}
	
	/*
	 * Description: Verify able to select Premium pakcage from premium package and proceed to next step
	 */
	@Test
	public void verifyAbletoPremiumSelectPackagefromPremiumandgotoNextstep() throws Exception {
		SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninPremiumPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninPremiumPackage);
		s.selectByValue("132");
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
		s.selectByValue("137");
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
		s.selectByValue("139");
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
		waitTill(2000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusBasicPackage), "Tradus Basic package is not present for business users");
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.tradusPremiumPackage), "Tradus Premium package is not present for business users");
	}
	
	/*
	 * Description: Verify insights of indivisual package
	 */
	@Test
	public void verifyInsightsofIndivisualPackage() throws Exception {
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		waitTill(2000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		Assert.assertTrue((getText(signUpPackageObj.packageTiles.get(0)).replace("\n",",").trim().equals("Tradus Basic,1 listing,€10.00,Per listing,€10.00 per month,Manual ad “bump up”,* Prices excluding VAT")),"Content of Tradus Basic package for indivisual user might have changed");
		Assert.assertTrue((getText(signUpPackageObj.packageTiles.get(1)).replace("\n",",").trim().equals("Tradus Premium,1 listing,€13.00,Per listing,€13.00 per month,All benefits from Basic package,Automatic ad bump up,Eligible for offer of the day on homepage,Eligible for featured offer on homepage,Top ads on listing page,Cross-post to OtomotoProfi,* Prices excluding VAT")),"Content of Tradus Premium package for indivisual user might have changed");
	}
	
	/*
	 * Description:Verify able to proceed to next step on choosing the individual package
	 */
	@Test
	public void verifyAbletoProceedtoNextsteponChoosingtheIndivisualPackage() throws Exception{
		SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
		SignUpAccountsTPROPage_New accountsObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
		waitTill(2000);
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
		Assert.assertTrue(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim().equals("€13.00,Excluding VAT"), "1 listing isn't displaying in monthly cost page for indivisual basic package");
		try{
			click(accountsObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountsObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.packagePageVerificationElement);
		waitTill(2000);
		jsClick(driver,signUpPackageObj.forIndivisualsButton);
		explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
		try{
			click(signUpPackageObj.tradusBasicPackage);
		}catch(Exception E) {
			jsClick(driver,signUpPackageObj.tradusBasicPackage);
		}
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.nextButton);
		jsClick(driver,signUpPackageObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpPackageObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpPackageObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 1 listing from basic package");
		explicitWaitFortheElementTobeVisible(driver, accountsObj.numberOfAdsperPackageUnderMonthlyCost);
		Assert.assertTrue(getText(accountsObj.priceUnderMonthlyCost).replace("\n", ",").trim().equals("€10.00,Excluding VAT"), "1 listing isn't displaying in monthly cost page for basic package");
	}
}
