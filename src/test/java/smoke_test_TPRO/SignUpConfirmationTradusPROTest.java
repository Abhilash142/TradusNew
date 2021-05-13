package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.mobileNumber;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.webSIteLink;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.GlobalConstants.companyName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpPackageSectionTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;

public class SignUpConfirmationTradusPROTest extends BaseClass {
	/* 
	 * Description: Verify 'edit this information 'link and redirecting to details page on clicking the link
	 */
	@Test
	public void verifyEditThisInformationInConfirmationSectionAndNavigation() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		/*waitTill(2000);
        signUpPkgObj.autoNavigateToCompanyPackagePage();*/
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "Company");
        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
        try {
        click(signUpPkgObj.nextButton);
        }catch(Exception e) {
        	jsClick(driver,signUpPkgObj.nextButton);
        }
        explicitWaitFortheElementTobeVisible(driver,signUpObj.editThisInformation);
        jsClick(driver, signUpObj.editThisInformation);
        waitTill(3000);
        Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
				"Details page is not by clicking on edit this information button in Confirmation section account summary");
	}
	
	/*
	 * Description: Verify all the details provided in details page and packages pages are displaying under 'Account summary'
	 */
	/*@Test
	public void verifyProvidedDetailsAreDisplayinginAccountSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		waitTill(2000);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "Company");
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
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
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
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
	}*/
	
	/*
	 * Description: Verify provided billing address details of company are displaying in billing summary of Confirmation page
	 */
    @Test
	public void verifyProvidedBillingDetailsForCompanyAreDisplayinginAccountSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		waitTill(2000);
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsVATNoTextField);
		waitForElement(signUpObj.detailsCountryText);
		List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("India");
		click(signUpObj.detailsCountryDropdown);
		waitTill(2000);
		click(listOfCountries.get(randomInt));
		waitTill(2000);
		sendKeys(signUpObj.detailsVATNoTextField, "IN1234");
		sendKeys(signUpObj.detailsContactPersonTextField, "contactperson");
		sendKeys(signUpObj.detailsCompanyNameTextField, companyName);
		sendKeys(signUpObj.detailsCityTextField, cityName);
		waitTill(2000);
		sendKeys(signUpObj.detailsCompanyAddressTextField, companyAddress);
		waitTill(1000);
		sendKeys(signUpObj.detailsCompanyZIPTextField, zipCode);
		waitTill(1000);
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, webSIteLink);
		waitTill(1000);
		sendKeys(signUpObj.detailsPhoneTextField, "9876545678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsBillingInfoContactPersonTextbox);
		sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "Billing contact person");
		sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "harishta2@olx.com");
		sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, "9876545678");
		waitTill(2000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
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
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCountry), "India",
				"Given country is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenPhone), "+919876545678",
				"Given phone is not displaying in Billing summary");
	}
	
	/* 
	 * Description: Verify provided billing address details of private user are displaying in billing summary of Confirmation page
	 */
	@Test
	public void verifyProvidedBillingDetailsForPrivateAreDisplayinginAccountSummary() throws Exception {

		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
		jsClick(driver, signUpObj.privateRadioButton);
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPrivateFullNameTextField);
		sendKeys(signUpObj.detailsPrivateFullNameTextField, "Tradus user");
		sendKeys(signUpObj.detailsCityTextField, "amsterdam");
		sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
		sendKeys(signUpObj.detailsCompanyZIPTextField, "345267");
		sendKeys(signUpObj.detailsPhoneTextField, "9876545678");
		waitForElement(signUpObj.detailsCountryText);
		List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("India");
		click(signUpObj.detailsCountryDropdown);
		waitTill(2000);
		click(listOfCountries.get(randomInt));
		waitTill(2000);
		jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
		sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "Billing private contact person");
		sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "harishta2@olx.com");
		sendKeys(signUpObj.detailsBillingInfoCityTextbox, "Private billing city");
		sendKeys(signUpObj.detailsBillingInfoAddressTextbox, "Private billing address");
		sendKeys(signUpObj.detailsBillingInfoZIPTextbox, "543G45");
		sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, "9876545678");
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpObj.BillingSummaryGivenCountry);
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
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenCountry), "India",
				"Given country is not displaying in Billing summary");
		Assert.assertEquals(getText(signUpObj.BillingSummaryGivenPhone), "+919876545678",
				"Given phone is not displaying in Billing summary");
	}
	/* 
	 * Description: Verify VAT is applied(21% for NL) for EU countries under package summary
	 */
	@Test
	public void verifyVATIsAppliedForEUCountriesUnderPackageSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		waitTill(2000);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpObj.PackageSummaryGivenVAT);
		Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "10.50 EUR",
				"VAT of Company package is not displaying correctly for EU Countries in Package Summary");
		loadUrl(driver, "https://pro.tradus.com/signup");
		explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
		signUpPkgObj.autoNavigateToPrivatePackagePage();
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		waitTill(2000);
		try {
			click(signUpPkgObj.nextButton);
			}catch(Exception e) {
				jsClick(driver,signUpPkgObj.nextButton);
			}
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
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpObj.PackageSummaryGivenVAT);
		Assert.assertEquals(getText(signUpObj.PackageSummaryGivenVAT), "1.68 EUR",
				"VAT is not displaying as zero for non EU countries in Package Summary");
	}
	
	/*
	 * Description: Verify all the details provided in details page and packages pages are displaying under 'Account summary'
	 */
	@Test
	public void verifyProvidedDetailsAreDisplayinginAccountSummary() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "Company");
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpObj.confirmation);
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCompanyName), "TRADUS B.V.",
				"Given company name is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenContactPerson), "Joost",
				"Given contact person is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenAddress), "WIBAUTSTRAAT 00137 C",
				"Given address is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenZipCode), "1097DN",
				"Given zip code is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCity), "AMSTERDAM",
				"Given city is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCountry), "India",
				"Given country is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenPhone), "+493025555338",
				"Given phone is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenVAT), "IN1234",
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
		sendKeys(signUpObj.detailsPhoneTextField, "9523232323");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "9523232323");
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.privateSinglePackage);
		try {
		click(signUpPkgObj.nextButton);
		}catch(Exception e) {
			jsClick(driver,signUpPkgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, signUpObj.AccountSummaryGivenFullName);
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenFullName), "Harish boyapati",
				"Given full name is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCity), "amsterdam",
				"Given city is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenAddress), "address",
				"Given address is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenZipCode), "345267",
				"Given zip code is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenCountry), "India",
				"Given country is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenWebsite), "tradus.com",
				"Given website not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenPhone), "+919523232323",
				"Given VAT is not displaying in Account summary");
		Assert.assertEquals(getText(signUpObj.AccountSummaryGivenMobilePhone), "+919523232323",
				"Given VAT is not displaying in Account summary");
	}
	

}
