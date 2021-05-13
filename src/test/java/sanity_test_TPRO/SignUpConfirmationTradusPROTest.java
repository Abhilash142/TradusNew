package sanity_test_TPRO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpPackageSectionTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;

public class SignUpConfirmationTradusPROTest extends BaseClass{
	
	/*
	 *  
	 * Description: Verify confirmation section is highlighed at the top
	 *
	 */
	@Test
	public void verifyConfirmationSectionIsHighlightedAtTop() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
			SignUpPackageSectionTradusPROPage signUpPkgObj= new SignUpPackageSectionTradusPROPage(driver);
			signUpPkgObj.autoNavigateToCompanyPackagePage();
			explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyFirstPackage);
		    click(signUpPkgObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.confirmation);
			waitTill(4000);
			String colorValue = (signUpObj.confirmationPageConfirmationElement).getCssValue("background-color");
			Assert.assertTrue(colorValue.equals("rgba(255, 136, 0, 1)"), "Confirmation section is not highlighted");
		}	
	
	/*
	 *  
	 * Description: Verify able to go to any page on clicking any section
	 *
	 */
	@Test
	public void verifyAbleToGoToAnyPageOnClickingOnAnySection() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyFirstPackage);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.confirmation);
		jsClick(driver, signUpObj.accountIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
		Assert.assertTrue(verifyElementPresent(signUpObj.emailField),
				"Account page is not displaying by clicking on account icon");
		jsClick(driver, signUpObj.detailsIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsCountryText);
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
				"Details page is not by clicking on details icon");
		jsClick(driver, signUpObj.packageIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionHeading),
				"Package page is not displaying by clicking on package icon");
		jsClick(driver, signUpObj.confirmationIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.confirmation);
		Assert.assertTrue(verifyElementPresent(signUpObj.confirmation),
				"Confirmation page is not displaying by clicking on confirmation icon");

	}

	/*
	 *  
	 * Description: Verify package page is displaying on clicking 'Back' button
	 *
	 */
	@Test
	public void verifyPackagePageByClikingOnBackFromConfirmationPage() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.confirmation);
		click(signUpObj.detailsBackbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionHeading),
				"Package page is not displaying upon clicking back from confirmation page");
}
	
	/*
	 *  
	 * Description: Verify 'edit this information 'link and redirecting to details page on clicking the link
	 *
	 */
	@Test
	public void verifyEditThisInformationInConfirmationSectionAndNavigation() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
        signUpPkgObj.autoNavigateToCompanyPackagePage();
        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
        click(signUpPkgObj.nextButton);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.editThisInformation);
        jsClick(driver, signUpObj.editThisInformation);
        waitTill(3000);
        Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
				"Details page is not by clicking on edit this information button in Confirmation section account summary");
	}
	
	/*
	 * Description: Verify all the details provided in details page and packages pages are displaying under 'Account summary'
	 */
	@Test
	public void verifyProvidedDetailsAreDisplayinginAccountSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.confirmation);
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCompanyName), "TRADUS B.V.",
				"Given company name is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenContactPerson), "Harish",
				"Given contact person is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenAddress), "WIBAUTSTRAAT 00137 C",
				"Given address is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenZipCode), "1097DN",
				"Given zip code is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCity), "AMSTERDAM",
				"Given city is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCountry), "Netherlands",
				"Given country is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenPhone), "+31777888999",
				"Given phone is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenVAT), "NL854502130B01",
				"Given VAT is not displaying in Account summary");
		jsClick(driver, signUpObj.accountIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
		jsClick(driver, signUpObj.privateRadioButton);
		jsClick(driver, signUpObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPrivateFullNameTextField);
		sendKeys(signUpObj.detailsPrivateFullNameTextField, "Harish boyapati");
		sendKeys(signUpObj.detailsCityTextField, "amsterdam");
		sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
		sendKeys(signUpObj.detailsCompanyZIPTextField, "345267");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "tradus.com");
		sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "31232823232");
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.AccountSummaryGivenFullName);
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenFullName), "Harish boyapati",
				"Given full name is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCity), "amsterdam",
				"Given city is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenAddress), "address",
				"Given address is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenZipCode), "345267",
				"Given zip code is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCountry), "Netherlands",
				"Given country is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenWebsite), "tradus.com",
				"Given website not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenPhone), "+31232323232",
				"Given VAT is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenMobilePhone), "+31232823232",
				"Given VAT is not displaying in Account summary");
	}
	
	/*
	 * Description: Verify provided billing address details of company are displaying in billing summary of Confirmation page
	 */
    @Test
	public void verifyProvidedBillingDetailsForCompanyAreDisplayinginAccountSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsVATNoTextField);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		sendKeys(signUpObj.detailsContactPersonTextField, "contactperson");
		sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
		jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsBillingInfoContactPersonTextbox);
		sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "Billing contact person");
		sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "harishta2@olx.com");
		sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, "31234567887");
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.BillingSummaryGivenContactPerson);
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenContactPerson), "Billing contact person",
				"Given contact person is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenEmail), "harishta2@olx.com",
				"Given email is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCompanyName), "TRADUS B.V.",
				"Given company name is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenAddress), "WIBAUTSTRAAT 00137 C",
				"Given address is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenZipCode), "1097DN",
				"Given zip code is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCity), "AMSTERDAM",
				"Given city is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCountry), "Netherlands",
				"Given country is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenPhone), "+31234567887",
				"Given phone is not displaying in Billing summary");
	}
	
	/*
	 *  
	 * Description: Verify provided billing address details of private user are displaying in billing summary of Confirmation page
	 *
	 */
	@Test
	public void verifyProvidedBillingDetailsForPrivateAreDisplayinginAccountSummary() throws Exception {

		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
		jsClick(driver, signUpObj.privateRadioButton);
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPrivateFullNameTextField);
		sendKeys(signUpObj.detailsPrivateFullNameTextField, "Tradus user");
		sendKeys(signUpObj.detailsCityTextField, "amsterdam");
		sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
		sendKeys(signUpObj.detailsCompanyZIPTextField, "345267");
		sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
		jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
		sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "Billing private contact person");
		sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "harishta2@olx.com");
		sendKeys(signUpObj.detailsBillingInfoCityTextbox, "Private billing city");
		sendKeys(signUpObj.detailsBillingInfoAddressTextbox, "Private billing address");
		sendKeys(signUpObj.detailsBillingInfoZIPTextbox, "543G45");
		sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, "31234567887");
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.AccountSummaryGivenContactPerson);
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenContactPerson), "Billing private contact person",
				"Given contact person is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenEmail), "harishta2@olx.com",
				"Given email is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenAddress), "Private billing address",
				"Given address is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenZipCode), "543G45",
				"Given zip code is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCity), "Private billing city",
				"Given city is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCountry), "Netherlands",
				"Given country is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenPhone), "+31234567887",
				"Given phone is not displaying in Billing summary");
	}
	
	/*
	 *  
	 * Description: Verify VAT is applied(21% for NL) for EU countries under package summary
	 *
	 */
	@Test
	public void verifyVATIsAppliedForEUCountriesUnderPackageSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.PackageSummaryGivenVAT);
		Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "10.50 EUR",
				"VAT of Company package is not displaying correctly for EU Countries in Package Summary");
		loadUrl(driver, "https://pro.tradus.com/signup");
		signUpPkgObj.autoNavigateToPrivatePackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.PackageSummaryGivenVAT);
		Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "1.68 EUR",
				"VAT of private package is not displaying correctly for EU Countries in Package Summary");
		jsClick(driver, signUpObj.detailsIcon);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		click(signUpObj.detailsCountryDropdown);
		click(listOfCountries.get(listOfCOuntriesNames.indexOf("Finland")));
		waitTill(2000);
		sendKeys(signUpObj.detailsPhoneTextField, "322334567");
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.PackageSummaryGivenVAT);
		Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "1.68 EUR",
				"VAT is not displaying as zero for non EU countries in Package Summary");
	}

	/*
	 *  
	 * Description: Verify VAT is zero for non EU countries under package summary
	 *
	 */
	@Test
	public void verifyVATIsNotAppliedForNonEUCountriesUnderPackageSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		signUpObj.setAccountUsernameAndPassword();
        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim()).collect(Collectors.toCollection(ArrayList::new));
		click(signUpObj.detailsCountryDropdown);
		click(listOfCountries.get(listOfCOuntriesNames.indexOf("India")));
		waitTill(2000);
        sendKeys(signUpObj.detailsVATNoTextField, "12345678912");
        waitTill(2000);
        sendKeys(signUpObj.detailsCompanyNameTextField, "company name");
        sendKeys(signUpObj.detailsCityTextField, "City");
        sendKeys(signUpObj.detailsCompanyAddressTextField, "Address");
        sendKeys(signUpObj.detailsCompanyZIPTextField, "673445");
        sendKeys(signUpObj.detailsContactPersonTextField, "Contact person");
        sendKeys(signUpObj.detailsPhoneTextField, "9876545678");
        jsClick(driver, signUpObj.detailsNextbutton);
        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
        click(signUpPkgObj.nextButton);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.PackageSummaryGivenVAT);
        Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "0.00 EUR", "VAT is not displaying as zero for non EU countries in Package Summary");
        jsClick(driver, signUpObj.detailsIcon);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsCountryDropdown);
        click(signUpObj.detailsCountryDropdown);
		click(listOfCountries.get(listOfCOuntriesNames.indexOf("Kuwait")));
		waitTill(2000);
        sendKeys(signUpObj.detailsPhoneTextField, "96512345");
        jsClick(driver, signUpObj.detailsNextbutton);
        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
        click(signUpPkgObj.nextButton);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.PackageSummaryGivenVAT);
        Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "0.00 EUR", "VAT is not displaying as zero for non EU countries in Package Summary");
        jsClick(driver, signUpObj.accountIcon);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		jsClick(driver, signUpObj.privateRadioButton);
	    waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPrivateFullNameTextField);
        sendKeys(signUpObj.detailsPrivateFullNameTextField, "Tradus user");
	    sendKeys(signUpObj.detailsCityTextField, "amsterdam");
	    sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
		sendKeys(signUpObj.detailsCompanyZIPTextField, "345267");
		click(signUpObj.detailsCountryDropdown);
		click(listOfCountries.get(listOfCOuntriesNames.indexOf("Libya")));
		sendKeys(signUpObj.detailsPhoneTextField, "322334567");
		jsClick(driver, signUpObj.detailsNextbutton);
        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.privateSinglePackage);
        click(signUpPkgObj.nextButton);
        explicitWaitFortheElementTobeVisible(driver,signUpObj.PackageSummaryGivenVAT);
        Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "0.00 EUR", "VAT is not displaying as zero for non EU countries in Package Summary");
	}

}
