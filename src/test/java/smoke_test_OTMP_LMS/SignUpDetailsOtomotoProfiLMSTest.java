package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.password;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.username;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.SignUpAccountsOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpDetailsOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class SignUpDetailsOtomotoProfiLMSTest extends BaseClass{
	
	/*
	 * Descritption: Verify the third step 'Details' tab is highlighted 
	 */
	@Test
	public void verifyThirdstepDetailsTabisHighlighted() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj=new SignUpDetailsOtomotoProfiLMSPage(driver);
		//waitTill(2000);
		accountPgObj.gotoDetailsPage(driver, "Smart",username, password);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,detailsPgObj.tabInfo);
		Assert.assertTrue((detailsPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 113, 206, 1)"),"Account section is not highlighted");
		Assert.assertTrue(getText(detailsPgObj.tabName).trim().equals("Details"),"Third tab name in sign up page is not Details");
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
			//waitTill(2000);
			accountPgObj.gotoDetailsPage(driver,userTypes[i] ,username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsCountryDropdown);
			waitTill(1000);
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
	 * Description: Verify Tax field is displaying on selecting any country and Verify VAT field is optional for Germany 
	 * and non EU country users
	 */
	@Test
	public void verifyTaxfieldfornonEUcountriesandVATfieldforEUcountries() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart", "Starter","Plus" };
		for (int i = 0; i < userTypes.length; i++) {
			//waitTill(2000);
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
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsTaxNoTextField), "Tax field is not present for non-EU country");
			randomInt = listOfCOuntriesNames.indexOf("Poland");
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
			//waitTill(2000);
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
			//waitTill(2000);
			accountPgObj.gotoDetailsPage(driver, userTypes[i], username, password);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,detailsPgObj.detailsVATNoTextField);
			sendKeys(detailsPgObj.detailsVATNoTextField,"1234567898765");
			waitTill(3000);
			Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).isEmpty(),
					"Alert for is displaying for incorrect VAT no");
			
		}
	}
	/*
	 * Description: Verify error message at contact person field on trying to proceed to next step without filling 
	 */
	@Test
	public void verifyErrorMessageAtContactPersonfieldifleftBlank() throws Exception {
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart"};
		for (int i = 0; i < userTypes.length; i++) {
			//waitTill(2000);
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
			try {
				click(detailsPgObj.createAnAccountButtoninDetailsPage);
			}catch (Exception E) {
				jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
			}
			waitTill(3000);
			Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim().equals("The contact person field is required"), "Contact person error message isn't correct when left blank");
			waitTill(1000);
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
			//waitTill(2000);
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
	 * Description: Verify error message at particular field on missing any mandatory field and trying to go to next step
	 */
	//@Test
	public void verifyErrorMessageatPerticualrFieldonMissingMandatoryFieldforEUuser() throws Exception
	{
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		SignUpDetailsOtomotoProfiLMSPage detailsPgObj = new SignUpDetailsOtomotoProfiLMSPage(driver);
		String[] userTypes = { "Smart" ,"Starter"};
		for (int i = 0; i < userTypes.length; i++) {
			//waitTill(2000);
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
			waitTill(1000);
			/*Assert.assertTrue(getText(detailsPgObj.billingEmailDangerTextindetailsBillingInfo).trim().equals("The email field is required"),
					"Error message is incorrect for email field in billing info when left blank");*/
			Assert.assertTrue(getText(detailsPgObj.phoneFieldDangerTextindetailsBillingInfo).trim().equals("The phone field is required"),
					"Error message is incorrect for phone field in billing info when left blank");
		}
	}

}
