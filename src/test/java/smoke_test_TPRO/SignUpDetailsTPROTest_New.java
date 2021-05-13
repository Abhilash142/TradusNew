package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.phoneNumberIN;
import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.ReadProp.getUserId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpDetailsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

import sanity_test_TPRO.CommonMethods;

public class SignUpDetailsTPROTest_New extends BaseClass {
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	@Test
	public void verifyLanguageDropdownandAllOptions() throws Exception{
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "private", username);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
	}
	
	/*
	 * Description: Validate supportsilder's presence and functionalities
	 */
	@Test
	public void validateSupportSlider() throws Exception {
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business", username);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.validateSupportSlider(driver);
	}
	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	
	@Test
	public void verifySignInLinkandItsNavigation() throws Exception {
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "private", username);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifySignInLinkandItsNavigation(driver);
	}
	
	/*
	 * Description: Verify the third step 'Details' tab is highlighted 
	 */
	@Test
	public void verifyDetailsTabisHighlighted() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business",username);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.tabInfo);
		Assert.assertTrue((accountPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 171, 189, 1)"),"Details section is not highlighted");
	}
	
	/*
	 * Description: Verify Monthly cost info is displaying in the right side
	 */
	@Test
	public void verifyMonthlyCostinfoDisplayingAtRightSide() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business", username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.monthlyCostSectioninDetailsPage);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.monthlyCostSectioninDetailsPage), "Monthly costs section is not displaying in Details page");
	}
	
	/*
	 * Description: Verify Tax field is displaying on selecting any country and Verify VAT field is optional for Germany 
	 * and non EU country users
	 */
	@Test
	public void verifyTaxfieldfornonEUcountriesandVATfieldforEUcountries() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("India");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsTaxNoTextField), "Tax field is not present for non-EU country");
		randomInt = listOfCOuntriesNames.indexOf("Netherlands");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsVATNoTextField), "VAT field is not present for EU country");
		/*randomInt = listOfCOuntriesNames.indexOf("Germany");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsVATNoOptionalTextField), "Optional VAT field is not present for Germany");*/
		
	}
	/*
	 * Description: Verify company name, Phone, address, zip code, city, billing email, website and Payment refrerence fields are displaying in 'company details' section
	 */
	@Test
	public void verifyAllfieldsarePresentinCompanyDetailsSection() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		/*if(!getAttribute(detailsPgObj.companyDetailsSection,"class").contains("open-item")) {
			click(detailsPgObj.companyDetailsSection);
			waitTill(2000);
		}*/
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyNameTextField), "Company name field isn't present in Company details section");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPhoneTextField), "Phone number field isn't present in Company details section");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyAddressTextField), "Address field isn't present in Company details section");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyZIPTextField), "ZIP field isn't present in Company details section");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCityTextField), "City field isn't present in Company details section");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyWebsiteTextField), "Website field isn't present in Company details section");
		//Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPaymentReference), "Payment reference field isn't present in Company details section");
	}
	
	/*
	 * Description: Verify Company name, Address, city, zip code and billing emails fields are auto filled on giving valid EU VAT number (Ex:NL854502130B01)
	 */
	@Test
	public void verifyAutofillingOffieldsonGivingEUVATno() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
		sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
		//waitTill(5000);
		int i=0;
		while(i<3)
		{
			if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
				waitTill(2000);
			    i++;
			}
			else {
				break;
			}
		}
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
		Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").equals("TRADUS B.V."),
				"Company name is not populated after entering valid VAT no");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyZIPTextField, "value").equals("1097DN"),
				"ZIP Code is not populated after entering valid VAT no");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyAddressTextField, "value").equals("WIBAUTSTRAAT 00137 C"),
				"Address is not populated after entering valid VAT no");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsCityTextField, "value").equals("AMSTERDAM"),
				"City is not populated after entering valid VAT no");
		
	}
	
	/*
	 * Description: Verify VAT amount also if applicable in monthly cost info
	 */
	@Test
	public void verifyVATAmountinMonthlyCostifApplicable() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "business",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		/*explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));*/
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.vatSectionInMonthlyCost);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.vatSectionInMonthlyCost), "VAT section is not displaying if EU country is selected");
	    Assert.assertTrue(getText(detailsPgObj.vatPriceInMonthlyCost).trim().equals("€ 35,49"), "VAT amount is not same as €27,30 for EU countries for 40 Ads listing");
	    Assert.assertTrue(getText(detailsPgObj.totalPriceInMonthlyCost).trim().equals("€ 204,49"), "Total price amount is not same as €157,30 for EU countries for 40 Ads listing");
	}
	
	/*
	 * Description: Verify only contact details and billing information sections are displaying for private user
	 */
	@Test
	public void verifyConactandBillinginfoforPrivateUsers() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "indivisual",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.contactDetailsSectionforIndivisual), "Contact details section isn't present for indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.billingInfoSectionforIndivisual), "Billing info section isn't present for indivisaul user");

	}
	
	/*
	 * Description: Verify full name, phone, mobile phone, address, city, zip code, country and billing email fields are displaying under contact details
	 */
	@Test
	public void verifyPresenceOfAllAttributeunderContactDetailsSection() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		detailsPgObj.gotoDetailsPage(driver, "indivisual",username);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.fullNameFieldforIndivisualUser), "Full name field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.phoneNumberFieldforIndivisualUser), "Phone number field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.mobilePhoneNumberFieldforIndivisualUser), "Mobile phone field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.addressFieldforIndivisualUser), "Address field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.cityFieldforIndivisualUser), "City field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.ZIPfieldforIndivisualUser), "ZIP field is present for Indivisual users");
		Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCountryDropdown), "Country field is present for Indivisual users");
	}
	
	/*
	 * Description: Verify all details are mandatory except mobile phone number
	 */
	@Test
	public void verifyAlldetailsareMandatoryExceptMobilePhone() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		String Uid=getUserId("Seller","userid");
		detailsPgObj.gotoDetailsPage(driver, "indivisual",Uid);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		scrollDown(driver);
		waitTill(2000);
		click(detailsPgObj.createAnAccountButtoninDetailsPage);
		waitTill(1000);
		Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).trim().equals("The full name field is required"),
				"Alert is incorrect when Full name field is left blank");
		sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"Harish");
		Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).isEmpty(),
				"Alert is still displaying even after filling name field");
		
		Assert.assertTrue(getText(detailsPgObj.phoneNumberFieldDangerText).trim().equals("The phone field is required"), 
				"Alert is incorrect when phone number field is left blank");
		sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,phoneNumber);
		Assert.assertTrue(getText(detailsPgObj.phoneNumberFieldDangerText).isEmpty(),
				"Alert is still displaying even after filling phone number field");
		
		Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).trim().equals("The address field is required"),
				"Alert is incorrect when address field is left blank");
		sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
		Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).isEmpty(),
				"Alert is still displaying even after filling address field ");
		
		
		Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).trim().equals("The zip code field is required"),
				"Alert is incorrect when ZIP Code field is left blank");
		sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode);
		Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).isEmpty(),
				"Alert is still displaying even after filling ZIP field ");
		
		
		/*Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).trim().equals("The country field is required"),
				"Alert is incorrect when country field is left blank");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));*/
		Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).isEmpty(),
				"Alert is still displaying even after filling Country field");
		
		Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).trim().equals("The city field is required"),
				"Alert is incorrect when city field is left blank");
		sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
		Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).isEmpty(),
				"Alert is still displaying even after filling City field");
		
		Assert.assertTrue(getText(detailsPgObj.mobilePhonefieldDangerText).isEmpty(),
				"Alert is displaying for blank mobile number field though not mandatory");

		/*click(detailsPgObj.createAnAccountButtoninDetailsPage);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.paymentPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.makePaymentButtonPaymentpage), "Make a payment button is not present in payment page for indivisual users");*/
		
	}
	/*
	 * Description: Verify Contact person,Company name, billing email, address, city, zip code, country and phone number fields are displaying
	 *  below 'Billing information text on ofcourse disabling the toggle switch
	 */
	@Test
	public void verifyAllattributesinBillingInfoArea() throws Exception {
	SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
	SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	detailsPgObj.gotoDetailsPage(driver, "business",username);
	explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
	scrollDown(driver);
	waitTill(2000);
	click(detailsPgObj.detailsBillingInformationTooglebutton);
	waitTill(1000);
	//Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoContactPersonTextbox), "Contact person field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCompanyTextbox), "Company field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoEmailTextbox), "Billing email field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCountryTextbox), "Country field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCityTextbox), "City field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoAddressTextbox), "Address field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoZIPTextbox), "ZIP field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoPhoneTextbox), "Phone field is present under billing info");
	Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPaymentReference), "Payment reference field isn't present in Company details section");
	}
	
	/*
	 * Description: Verify Company name, address, city and zip code fields are auto filled and disabled for valid EU VAT users
	 */
	@Test
	public void verifyAutofillinginBillingInfoSectionforValidEUVatNo() throws Exception {
	SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
	SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	detailsPgObj.gotoDetailsPage(driver, "business",username);
	explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
	
	sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	int i=0;
	while(i<3)
	{
		if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
			waitTill(2000);
		    i++;
		}
		else {
			break;
		}
	}
	scrollDown(driver);
	waitTill(2000);
	click(detailsPgObj.detailsBillingInformationTooglebutton);
	waitTill(1000);
	Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCompanyTextbox,"value").trim().equals("TRADUS B.V."),
			"Correct Company Name isn't displaying in billing address after filling valid VAT number.");
	Assert.assertFalse((detailsPgObj.detailsBillingInfoCompanyTextbox).isEnabled(), 
			"Company Name field isn't disable in billing address after filling valid VAT number.");
	
	Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoAddressTextbox,"value").trim().equals("WIBAUTSTRAAT 00137 C"),
			"Correct address isn't displaying in billing address after filling valid VAT number.");
	Assert.assertFalse((detailsPgObj.detailsBillingInfoAddressTextbox).isEnabled(), 
			"Address field is disable in billing address after filling valid VAT number.");
	
	Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCityTextbox,"value").trim().equals("AMSTERDAM"),
			"Correct city name isn't displaying in billing address after filling valid VAT number.");
	Assert.assertFalse((detailsPgObj.detailsBillingInfoCityTextbox).isEnabled(), 
			"City name field isn't disable in billing address after filling valid VAT number.");
	
	Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoZIPTextbox,"value").trim().equals("1097DN"),
			"Correct ZIP value isn't displaying in billing address after filling valid VAT number.");
	Assert.assertFalse((detailsPgObj.detailsBillingInfoZIPTextbox).isEnabled(), 
			"ZIP Code field isn't disable in billing address after filling valid VAT number.");
	
		
	}
	
	/*@Test
	public void verifyErrorMessageAtperticualrFieldonMissingMandatoryFieldforEUuser() throws Exception
	{
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		String Uid=getUserId();
		accountPgObj.gotoDetailsPage(driver, "business",Uid);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
		sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
		//waitTill(5000);
		int i=0;
		while(i<3)
		{
			if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
				waitTill(2000);
			    i++;
			}
			else {
				break;
			}
		}
		sendKeys(detailsPgObj.detailsPhoneTextField,"31234567887");
		sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
		scrollDown(driver);
		waitTill(2000);
		click(detailsPgObj.detailsBillingInformationTooglebutton);
		waitTill(1000);
		Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCompanyTextbox,"value").trim().equals("TRADUS B.V."),
				"Correct Company Name isn't displaying in billing address after filling valid VAT number.");
		Assert.assertFalse((detailsPgObj.detailsBillingInfoCityTextbox).isEnabled(), 
				"City name field isn't disable in billing address after filling valid VAT number.");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,"value").trim().equals(Uid),"Emails in billing sextion isn't same as the inserted email in Accounts page");
		sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,"");
		sendKeys(detailsPgObj.detailsBillingInfoContactPersonTextbox,"");
		sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,"");
		jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
		waitTill(2000);
		Assert.assertTrue(getText(detailsPgObj.billingEmailDangerTextindetailsBillingInfo).trim().equals("The email field is required"),
				"Error message is incorrect for email field in billing info when left blank");
		Assert.assertTrue(getText(detailsPgObj.companyContactPersonDangerTextinBillingInfo).trim().equals("The contact person field is required"),
				"Error message is incorrect for Contact person field in billing info when left blank");
		Assert.assertTrue(getText(detailsPgObj.phoneFieldDangerTextindetailsBillingInfo).trim().equals("The phone field is required"),
				"Error message is incorrect for email field in billing info when left blank");
		sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,Uid);
		sendKeys(detailsPgObj.detailsBillingInfoContactPersonTextbox,"Harish");
		sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,"31234567887");
		jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.paymentPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.paymentPageVerificationElement), "Payment page is not displaying when billing info filled manually for EU user");
	}
	
	 * Description: Verify error message at particular field on missing any mandatory field and trying to go to next step for private user
	 
	@Test
	public void verifyErrorMessageatPerticualrFieldonMissingMandatoryFieldforPrivateuser() throws Exception{
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		waitTill(1000);
		SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
		String Uid=getUserId();
		accountPgObj.gotoDetailsPage(driver, "private",Uid);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
		List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
		ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
				.collect(Collectors.toCollection(ArrayList::new));
		int randomInt = listOfCOuntriesNames.indexOf("India");
		click(detailsPgObj.detailsCountryDropdown);
		waitTill(1000);
		click(listOfCountries.get(randomInt));
		sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"Harish");
		sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,phoneNumberIN);
		sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
		sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
		sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode);
		scrollDown(driver);
		waitTill(2000);
		click(detailsPgObj.detailsBillingInformationTooglebutton);
		waitTill(1000);
		Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoContactPersonTextbox,"value").trim().isEmpty(),
				"Contact person field is autopopulated in billing info section for private user");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,"value").trim().isEmpty(),
				"Billing Email field is autopopulated in billing info section for private user");
		Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoZIPTextbox,"value").trim().equals(zipCode),
				"Zip code field isn't autopopulated in billing info section for private user");
		sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,"");
		jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
		waitTill(2000);
		Assert.assertTrue(getText(detailsPgObj.billingEmailDangerTextindetailsBillingInfo).trim().equals("The email field is required"),
				"Error message is incorrect for email field in billing info when left blank");
		Assert.assertTrue(getText(detailsPgObj.companyContactPersonDangerTextinBillingInfo).trim().equals("The contact person field is required"),
				"Error message is incorrect for Contact person field in billing info when left blank");
		Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo).trim().equals("The zip code field is required"),
				"Error message is incorrect for ZIP Code field in billing info when left blank");
		sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,Uid);
		
		sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,zipCode);
		sendKeys(detailsPgObj.detailsBillingInfoContactPersonTextbox, "Harish");
		sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox, phoneNumberIN);
		jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.paymentPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.paymentPageVerificationElement), "Payment page is not displaying when billing info filled manually for private user");

	}
*/
}
