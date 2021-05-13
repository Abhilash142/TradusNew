package sanity_test_OTMP_LMS;

import com.otomotoProfi.LMS.pages.SignUpAccountsOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpDetailsOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.scrollUp;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;

import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.webSIteLink;
import static com.tradus.core.GlobalConstants.phoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tradus.core.GlobalConstants.password;

public class SignUpDetailsOtomotoProfiLMSTest extends BaseClass{
	
	/*
	 * Descritption: Verify the third step 'Details' tab is highlighted 
	 */
	@Test
	public void verifyThirdstepDetailsTabisHighlighted() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj=new SignUpDetailsOtomotoProfiLMSPage(driver);
		waitTill(2000);
		accountPgObj.gotoDetailsPage(driver, "Smart",username, password);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.tabInfo);
		Assert.assertTrue((detailsPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 113, 206, 1)"),"Account section is not highlighted");
		Assert.assertTrue(getText(detailsPgObj.tabName).trim().equals("Details"),"Third tab name in sign up page is not Details");
	}
	
	/*
	 * Description: Verify Monthly cost info is displaying in the right side
	 */
	@Test
	public void verifyMonthlyCostinfoDisplayingAtRightSide() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj=new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes= {"Smart","Starter","Plus"};
		for(int i=0;i<userTypes.length;i++) {
		waitTill(2000);
		accountPgObj.gotoDetailsPage(driver,userTypes[i] ,username, password);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.monthlyCostSectioninDetailsPage);
		Assert.assertTrue(verifyElementPresent(detailsPgObj.monthlyCostSectioninDetailsPage), "Monthly cost section isn't displaying in details page");
		}
	}
	
	/*
	 * Description: Verify VAT amount also if applicable in monthly cost info
	 */
	@Test
	public void verifyVATamountforApplicablecountriesinMonthlyCostsection() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj=new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes= {"Smart"};
		for(int i=0;i<userTypes.length;i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver,userTypes[i] ,username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			waitTill(2000);
			Assert.assertTrue(getText(detailsPgObj.detailsCountryDropdown).equals("Poland"), "Poland is not auto-selected in details page");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.vatSectionInMonthlyCost), "VAT section in month cost is not present for PL");
			Assert.assertTrue(getText(detailsPgObj.vatPriceInMonthlyCost).replaceAll("[^0-9,]","").trim().equals("64,17"), "VAT amount is not correct for PL");
			Assert.assertTrue(getText(detailsPgObj.totalPriceInMonthlyCost).replaceAll("[^0-9,]","").trim().equals("343,17"), "Total per month is not correct for PL");
			List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
					.collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
			Assert.assertFalse(verifyElementPresent(detailsPgObj.vatSectionInMonthlyCost), "VAT section in month cost is present for NL");			
		}
	}
	
	/*
	 * Description: verify FAQ section, two questions and their content
	 */
	@Test
	public void verifyFAQsectionanditsContent() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver, detailsPgObj.FAQSectioninDetailsPage);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.FAQSectioninDetailsPage),
					"FAQ sesction is not present in details section");
			Assert.assertTrue(detailsPgObj.FAQsinDetailsPage.size() == 2,
					"Two FAQs are not displaying in details page");
			scrollDown(driver);
			waitTill(2000);
			for (int j = 0; j < detailsPgObj.FAQsinDetailsPage.size(); j++) {

				switch (j) {
				case 0:
					click(detailsPgObj.FAQsinDetailsPage.get(j));
					waitTill(1000);
					String firstContent = getText(detailsPgObj.FAQsinDetailsPage.get(j)).replace("\n", ",").trim();
					Assert.assertTrue(firstContent.replace(",keyboard_arrow_down", "").equals(
							"Why did my data pre-populate?,For customers in the EU with a VAT, we use the European Commission's VIES (VAT Information Exchange System) to pre-populate your information based on the VAT number entered. Based on the European Commission's VAT rules, your billing name & address must be registered with your VAT number to accurately charge or reverse charge VAT costs compulsory on your subscription."),
							"Why did my data pre-populate? content has changed");
					break;

				case 1:
					click(detailsPgObj.FAQsinDetailsPage.get(j));
					waitTill(1000);
					String secondContent = getText(detailsPgObj.FAQsinDetailsPage.get(j)).replace("\n", ",").trim();
					Assert.assertTrue(secondContent.replace(",keyboard_arrow_down", "").equals(
							"How will my contact information be used?,Only registered buyers who have created an account on can contact you. Interested buyers have the option to see your phone number, or send you an email."),
							"How will my contact info be used? content has changed");
					break;
				}
			}
		}
	}
	
	/*
	 * Description: Verify Tax field is displaying on selecting any country and Verify VAT field is optional for Germany 
	 * and non EU country users
	 */
	@Test
	public void verifyTaxfieldfornonEUcountriesandVATfieldforEUcountries() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter","Plus" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
					.collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("India");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsTaxNoTextField), "Tax field is not present for non-EU country");
			randomInt = listOfCOuntriesNames.indexOf("Poland");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsVATNoTextField), "VAT field is not present for EU country");
			/*randomInt = listOfCOuntriesNames.indexOf("Germany");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsVATNoOptionalTextField), "Optional VAT field is not present for Germany");*/
			
		}
	}
	
	/*
	 * Description: Verify company name, Phone, address, zip code, city, website and Payment refrerence fields are displaying in 'company details' section
	 */
	@Test
	public void verifyAllfieldsarePresentinCompanyDetailsSection() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyNameTextField), "Company name field isn't present in Company details section");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPhoneTextField), "Phone number field isn't present in Company details section");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyAddressTextField), "Address field isn't present in Company details section");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyZIPTextField), "ZIP field isn't present in Company details section");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCityTextField), "City field isn't present in Company details section");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCompanyWebsiteTextField), "Website field isn't present in Company details section");
		}
	}
	
	/*
	 * Description: Verify Company name, Address, city and zip code fields are auto filled on giving valid EU VAT number (Ex:NL854502130B01)
	 */
	@Test
	public void verifyAutofillingOffieldsonGivingEUVATno() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter","Plus"};
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
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
			int j=0;
			while(j<3)
			{
				if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
					waitTill(2000);
				    j++;
				}
				else {
					break;
				}
			}
			Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").equals("TRADUS B.V."),
					"Company name is not populated after entering valid VAT no");
			Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyZIPTextField, "value").equals("1097DN"),
					"ZIP Code is not populated after entering valid VAT no");
			Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyAddressTextField, "value").equals("WIBAUTSTRAAT 00137 C"),
					"Address is not populated after entering valid VAT no");
			Assert.assertTrue(getAttribute(detailsPgObj.detailsCityTextField, "value").equals("AMSTERDAM"),
					"City is not populated after entering valid VAT no");
		}
	}
	
	/*
	 * Description: Verify error is displaying in VAT field for giving invalid vat for EU countries
	 */
	@Test
	public void verifyErrorisDisplayinginVATfieldforgivingInvalidVATforEU() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
			sendKeys(detailsPgObj.detailsVATNoTextField,"1234567898765");
			waitTill(3000);
			Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().equals("Incorrect VAT number, please type a correct value"),
					"Alert for incorrect VAT is not correct");
			
		}
	}	
	/*
	 * Description: Verify error message at phone number field if it's empty/invalid
	 */
	@Test
	public void verifyErrormessageatPhonnumberfieldifEmptyorInvalid() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
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
			int j=0;
			while(j<3)
			{
				if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
					waitTill(2000);
				    j++;
				}
				else {
					break;
				}
			}
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsPhoneTextField);
			sendKeys(detailsPgObj.detailsPhoneTextField,"1234567");
			waitTill(1000);
			Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().equals("This phone number is not valid."), "Phone number error message might have changed for incorrect input" );
			sendKeys(detailsPgObj.detailsPhoneTextField,"  ");
			Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().equals("The phone field is required"), "Phone number error message might have changed for blank space" );
		}
	}
	
	/*
	 * Description: Verify Contact person , mobile phone number fields are displaying in contact details section
	 */
	@Test
	public void verifyContactPersonandMobilePhoneFieldsinContactSection() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.contactDetailsSection);
			
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsContactPersonTextField), "Contact person text field is not present for +"+userTypes[i]+" package");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsMobilePhoneTextField), "Mobile phone text field is not present for +"+userTypes[i]+" package");
		}
	}
	
	/*
	 * Description: Verify error message at contact person field on trying to proceed to next step without filling 
	 */
	@Test
	public void verifyErrorMessageAtContactPersonfieldifleftBlank() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter"  };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream()
					.map(c -> c.getAttribute("innerHTML").trim()).collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			explicitWaitFortheElementTobeVisible(driver, detailsPgObj.detailsVATNoTextField);
			sendKeys(detailsPgObj.detailsVATNoTextField, "NL854502130B01");
			// waitTill(5000);
			int j = 0;
			while (j < 3) {
				if (getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
					waitTill(2000);
					j++;
				} else {
					break;
				}
			}
			explicitWaitFortheElementTobeVisible(driver, detailsPgObj.detailsPhoneTextField);
			sendKeys(detailsPgObj.detailsPhoneTextField, phoneNumber);
			scrollDown(driver);
			waitTill(1000);
			click(detailsPgObj.createAnAccountButtoninDetailsPage);
			waitTill(1000);
			Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim().equals("The contact person field is required"), "Contact person error message isn't incorrect when left blank");
		}
	}
	
	/*
	 * Description: Verify 'Use the same information for billing' toggle switch is displaying below the details
	 */
	@Test
	public void verifyUseSameInfoTooglebelowDetails() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter"  };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.billingInfoSection);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.billingInfoSection),"Billing info section is not present");
		}
		
	}
	
	/*
	 * Description: Verify Company name, billing email, address, city, zip code, country and phone number fields are displaying below 'Billing information text on ofcourse disabling the toggle switch
	 */
	@Test
	public void verifyAllattributesinBillingInfoArea() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter"  };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.billingInfoSection);
			scrollDown(driver);
			waitTill(2000);
			click(detailsPgObj.detailsBillingInformationTooglebutton);
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCompanyTextbox), "Company field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoEmailTextbox), "Billing email field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCountryTextbox), "Country field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoCityTextbox), "City field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoAddressTextbox), "Address field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoZIPTextbox), "ZIP field is present under billing info");
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsBillingInfoPhoneTextbox), "Phone field is present under billing info");
		}
		
		}
	/*
	 * Description: Verify Company name, address, city and zip code fields are auto filled and disabled for valid EU VAT users
	 */
	@Test
	public void verifyAutofillinginBillingInfoSectionforValidEUVatNo() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter"  };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream()
					.map(c -> c.getAttribute("innerHTML").trim()).collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			explicitWaitFortheElementTobeVisible(driver, detailsPgObj.detailsVATNoTextField);
			sendKeys(detailsPgObj.detailsVATNoTextField, "NL854502130B01");
			// waitTill(5000);
			int j = 0;
			while (j < 3) {
				if (getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
					waitTill(2000);
					j++;
				} else {
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
			
			Assert.assertFalse((detailsPgObj.countryDropdowninBillingSection).isEnabled(), 
					"Country dropdwon field isn't disable in billing address after filling valid VAT number.");
			
		}
	}
	
	/*
	 * Description:Validate all the fields
	 */
	@Test
	public void validateAllFieldsinDetailsPageforBusinessUser() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" };
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			sendKeys(detailsPgObj.detailsVATNoTextField,"#$%^");
			sendKeys(detailsPgObj.detailsCompanyNameTextField,"#$%^");
			sendKeys(detailsPgObj.detailsPhoneTextField,"#$%^");
			sendKeys(detailsPgObj.detailsCompanyAddressTextField,"#$%^");
			sendKeys(detailsPgObj.detailsCompanyZIPTextField,"#$%^");
			sendKeys(detailsPgObj.detailsCityTextField,"#$%^");
			sendKeys(detailsPgObj.detailsCompanyWebsiteTextField,"#$%^");
			sendKeys(detailsPgObj.detailsContactPersonTextField,"#$%^");
			scrollDown(driver);
			waitTill(2000);
			click(detailsPgObj.detailsBillingInformationTooglebutton);
			waitTill(2000);
			jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
			waitTill(1000);
		//	Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).trim().equals("The country field is required"), "Alert in country field is incorrect if left blank");
			Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().equals("Incorrect VAT number, please type a correct value"), "Alert in tax field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsCompanyNamefieldDangerText).trim().equals("The company name value is not valid"), "Alert in company name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsAddressDangerText).trim().equals("The address value is not valid"), "Alert in company Address field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().equals("The zip code value is not valid"), "Alert in ZIP code field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsCityDangerText).trim().equals("The city value is not valid"), "Alert in city field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsWebsiteDangerText).trim().equals("The website field is not a valid URL"), "Alert in website field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim().equals("The contact person value is not valid"), "Alert in Contact person field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.companyNameDangerTextindetailsBillingInfo).trim().equals("The company name field is required"), "Alert in Compnay name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).trim().equals("The city field may only contain alphabetic characters as well as spaces"), "Alert in City name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.addressFieldDangerTextindetailsBillingInfo).trim().equals("The address value is not valid"), "Alert in address field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo).trim().equals("The zip code value is not valid"), "Alert in zip code field is incorrect when insert with wrong data");
			
			click(detailsPgObj.detailsBillingInformationTooglebutton);
			waitTill(1000);
			scrollUp(driver);
			waitTill(2000);
			List<WebElement> listOfCountries = detailsPgObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
					.collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
			click(listOfCountries.get(randomInt));
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
			sendKeys(detailsPgObj.detailsVATNoTextField," ");
			sendKeys(detailsPgObj.detailsCompanyNameTextField," ");
			sendKeys(detailsPgObj.detailsPhoneTextField," ");
			sendKeys(detailsPgObj.detailsCompanyAddressTextField," ");
			sendKeys(detailsPgObj.detailsCompanyZIPTextField," ");
			sendKeys(detailsPgObj.detailsCityTextField," ");
			sendKeys(detailsPgObj.detailsCompanyWebsiteTextField," ");
			sendKeys(detailsPgObj.detailsContactPersonTextField," ");
			scrollDown(driver);
			waitTill(2000);
			click(detailsPgObj.detailsBillingInformationTooglebutton);
			waitTill(2000);
			sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox," ");
			sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox," ");
			jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
			waitTill(1000);
			Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().equals("The vat number field is required"), "Alert in VAT field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsCompanyNamefieldDangerText).trim().equals("The company name field is required"), "Alert in company name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().equals("The phone field is required"), "Alert in phone number field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsAddressDangerText).trim().equals("The address field is required"), "Alert in company Address field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().equals("The zip code field is required"), "Alert in ZIP code field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsCityDangerText).trim().equals("The city field is required"), "Alert in city field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsWebsiteDangerText).trim().equals("The website field is not a valid URL"), "Alert in website field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim().equals("The contact person field is required"), "Alert in Contact person field is incorrect when insert with wrong data");
			
			Assert.assertTrue(getText(detailsPgObj.companyNameDangerTextindetailsBillingInfo).trim().equals("The company name field is required"), "Alert in Compnay name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).trim().equals("The city field is required"), "Alert in City name field is incorrect when insert with wrong data");
			Assert.assertTrue(getText(detailsPgObj.addressFieldDangerTextindetailsBillingInfo).trim().equals("The address field is required"), "Alert in address field is incorrect when insert with wrong data");
			
		}
	}
	
	/*
	 * Description: Verify on trying back link, signp up account page should display
	 */
	@Test
	public void verifylandingOnAccountspageonClickingBacklinkfromDetails() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" ,"Starter"};
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			scrollDown(driver);
			waitTill(2000);
			explicitWaitFortheElementTobeVisible(driver, detailsPgObj.backButtoninDetailsPage);
			click(detailsPgObj.backButtoninDetailsPage);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.accountsPageVerificationElement), "User is not landing in accounts from details page ");
		}
	}
	
	/*
	 * Description: Verify error message at particular field on missing any mandatory field and trying to go to next step
	 */
	//@Test
	public void verifyErrorMessageatPerticualrFieldonMissingMandatoryFieldforEUuser() throws Exception
	{
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" ,"Starter"};
		for (int i = 0; i < userTypes.length; i++) {
			waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
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
			int j=0;
			while(j<3)
			{
				if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty()) {
					waitTill(2000);
				    j++;
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
			/*Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,"value").trim().equals(username),"Emails in billing sextion isn't same as the inserted email in Accounts page");*/
			sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,"");
			sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,"");
			jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
			waitTill(2000);
			/*Assert.assertTrue(getText(detailsPgObj.billingEmailDangerTextindetailsBillingInfo).trim().equals("The email field is required"),
					"Error message is incorrect for email field in billing info when left blank");*/
			Assert.assertTrue(getText(detailsPgObj.phoneFieldDangerTextindetailsBillingInfo).trim().equals("The phone field is required"),
					"Error message is incorrect for phone field in billing info when left blank");
		}
	}

}




