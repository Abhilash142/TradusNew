package sanity_test_TPRO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.core.TestListenersClass;
import com.tradus.pro.pages.SignUpPackageSectionTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;


import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.scrollUp;
import static com.tradus.core.ActionElementClass.scrollDown;

import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.password;
import static com.tradus.core.GlobalConstants.vatNumber;
import static com.tradus.core.GlobalConstants.companyName;
import static com.tradus.core.GlobalConstants.contactPerson;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.GlobalConstants.userName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tradus.core.GlobalConstants.webSIteLink;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.mobileNumber;
import static com.tradus.core.GlobalConstants.whatsAppAvailable;

public class SignupTPROTest extends BaseClass{
	
	/*
	 * Description : Verify page is redirecting to login page on clicking 'Sign
	 * in' link
	 */
	@Test
	public void VerifyPageIsRedirectingToLoginPageOnClickingSignInLink() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		Assert.assertTrue(verifyElementPresent(signUpObj.SignIn), "Sign in link is not present in SignUp Page");
		jsClick(driver,signUpObj.SignIn);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.loginPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpObj.LoginPage),
				"LoginPage is not displaying on clicking 'Sign in' link");
		}
	/*
	 * Description : Verify Sign in and language drop down as English default is
	 * displaying in the right side
	 */
	@Test
	public void VerifySignInAndLanguageDropDownAsEnglishDefaultIsDisplayingInTheRightSide() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		Assert.assertTrue(verifyElementPresent(signUpObj.SignIn),
				"SignIn Link/button is not displaying in the right.......");
		String ExpectedMessage = "English";
		String ActualMessage = getText(signUpObj.languageText).trim();
		Assert.assertEquals(ActualMessage, ExpectedMessage,
				"English default language is not displaying on the right side.....");
	}
	
	/*
	 * Description : Verify Tradus pro logo with 'The smart way to trade heavy
	 * machinery' is displaying on the left side
	 */

	@Test
	public void VerifyTradusProLogoWithTheSmartWayToTradeHeavyMachineryIsDisplayingOnTheLeftSide() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		Assert.assertTrue(verifyElementPresent(signUpObj.TRProLogo), "TRPro Logo is not displaying.......");
		String ExpectedMessage = "The smart way to trade heavy machinery";
		String ActualMessage = getText(signUpObj.proCaption);
		Assert.assertEquals(ActualMessage, ExpectedMessage,
				"The smart way to trade heavy machinery message is not displaying on the left side.....");
	}
	
	/*
	 * Description : Verify acceptance checkbox is allowing or not, if we didn't
	 * checked
	 */
	@Test
	public void verifyAcceptanceCheckbox() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		jsClick(driver,signUpObj.nextButton);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(signUpObj.agreeCheckBoxError), "Terms error message is not displaying");
		String errorMessage = signUpObj.agreeCheckBoxError.getText();
		Assert.assertEquals(errorMessage, "The Terms of Use field is required",
				"Terms error message text is not correct");
		try {
		click(signUpObj.agreeCheckBox);
		} catch(Exception e) {
			jsClick(driver,signUpObj.agreeCheckBox);
		}
		waitTill(2000);
		jsClick(driver,signUpObj.nextButton);
		waitTill(2000);
		errorMessage = signUpObj.agreeCheckBoxError.getText();
		Assert.assertTrue(errorMessage.isEmpty(), "After clicking checkbox 'Terms error message is displaying'");
	}
	
	/*
	 * Description : Verify country, VAT number, Company name, Address, city,
	 * postcode, contact person and phone fields are displaying if you have
	 * enabled 'Company' checkbox in Sign up initial page
	 */
	@Test
	public void verifyAllElementsDisplayedInDetailsSectionAfterSelectingCompanyRadioButtonOfSignUPPage()
			throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		String colorValue = (signUpObj.companyRadioButton).getCssValue("background-color");
		Assert.assertTrue(colorValue.equals("rgba(255, 136, 0, 1)"), "Company RadioButton is not highlighted");
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsCountryDropdown);
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
				"Country field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsVATNumberText),
				"VAT Number field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCompanyText),
				"Company field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCityText),
				"City field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsAddressText),
				"Address field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsZIPCodeText),
				"ZIP code field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsContactPersonText),
				"Contact Person field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsWebsiteText),
				"Website field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsPhoneText),
				"Phone field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsMobilephoneText),
				"Mobile Phone field is not displayed after entering the valid credentials in the Detail page");
	}
	
	/*
	 *
	 * Description: Verify Full name, Address, city, zip code, country and phone
	 * fields are displaying if you have enabled 'Private' checkbox in sign up
	 * initial page
	 */
	@Test
	public void verifyAllElementsDisplayedInDetailsSectionAfterSelectingPrivateRadioButtonOfSignUPPage()
			throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		jsClick(driver, signUpObj.privateRadioButton);
		waitTill(2000);
		String colorValue = (signUpObj.privateRadioButton).getCssValue("background-color");
		Assert.assertTrue(colorValue.equals("rgba(255, 136, 0, 1)"), "Private RadioButton is not highlighted");
		signUpObj.setAccountUsernameAndPassword();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPageDetailElement);
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
				"SignUp details page is not displayed");
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsFullameText),
				"Full name field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
				"Country field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsCityText),
				"City field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsAddressText),
				"Address field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsZIPCodeText),
				"ZIP code field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsWebsiteText),
				"Website field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsPhoneText),
				"Phone field is not displayed after entering the valid credentials in the Detail page");
		Assert.assertTrue(verifyElementPresent(signUpObj.detailsMobilephoneText),
				"Mobile Phone field is not displayed after entering the valid credentials in the Detail page");
	}
	/*
	 * Verify Company name, address, city and zip code fields are auto filled and disabled for valid EU VAT users
	 */
		@Test
		public void verifyBillingInfoCompanyNameCityAddressAndZipCodeAreDisabledForValidEUVATUsers() throws Exception{
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPageDetailElement);
			jsClick(driver,signUpObj.detailsBillingInformationTooglebutton);
			waitTill(2000);
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			String text = getAttribute(signUpObj.detailsCompanyNameTextField, "value").trim();
			while(text.isEmpty()) {
				waitTill(1000);
				text = getAttribute(signUpObj.detailsCompanyNameTextField, "value").trim();
			}
			Assert.assertFalse(signUpObj.detailsBillingInfoCompanyTextbox.isEnabled(), "Company name is not disabled");
			Assert.assertFalse(signUpObj.detailsBillingInfoCityTextbox.isEnabled(), "City is not disabled");
			Assert.assertFalse(signUpObj.detailsBillingInfoAddressTextbox.isEnabled(), "Address is not disabled");
			Assert.assertFalse(signUpObj.detailsBillingInfoZIPTextbox.isEnabled(), "ZIP code is not disabled");
		}
		
		/*
		 *  Verify Contact person, email, address, city, zip code, country and phone number fields are displaying
		 *  below 'Billing information text on disabling the toggle switch
		 */
		
		@Test
		public void verifyBillingInformationDetailsByDisablingToggleButton() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPageDetailElement);
			jsClick(driver,signUpObj.detailsBillingInformationTooglebutton);
			waitTill(6000);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoContactPersonTextbox),
					"Contact person textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoEmailTextbox),
					"Email textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoAddressTextbox),
					"Address textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoCityTextbox),
					"City textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoZIPTextbox),
					"Zip code textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoCountryTextbox),
					"Country textbox is not displaying in billing information");
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInfoPhoneTextbox),
					"Phone textbox is not displaying in billing information");
		}
		
		/*
		 * (Sign up - Details page for Company/Private users) Verify Whatsapp
		 * checkbox is displaying
		 * 
		 */
		@Test
		public void verifyCompanyAndPrivateDetailsPageWhatsAppCheckboxAlongWithText() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsAvailableOnWhatsAppCheckbox),
					"The whatsapp check box is not displaying for company details page");
			try{
				click(signUpObj.accountIcon);
			}catch(Exception e) {
				jsClick(driver,signUpObj.accountIcon);
			}
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			try{
				click(signUpObj.privateRadioButton);
			}catch(Exception e) {
				jsClick(driver,signUpObj.privateRadioButton);
			}
			jsClick(driver,signUpObj.nextButton);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsAvailableOnWhatsAppCheckbox),
					"The whatsapp check box is not displaying for private seller details page");
		}
		
		/*
		 * Description : Verify Company radio button is high lighted or not
		 */
		@Test
		public void verifyCompanyRadioButtonIsHighlighted() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			String radioButtonValue = (signUpObj.companyRadioBtn).getAttribute("value");
			Assert.assertTrue(radioButtonValue.equals("1"), "Company radio button is not highlighted by default");
		}
		
		/*
		 * Description : Verify details page is displaying on trying with valid
		 * credentials
		 */

		@Test
		public void verifyDetailsPageOnEnteringValidCredentials() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			waitTill(5000);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsNextbutton);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsCountryText),
					"Details page is not displayed after entering the valid credentials");
		}
		
		/*
		 * Description : Verify Details section is highlighted
		 */
		@Test
		public void verifyDetailsSectionIsHighlighted() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitTill(2000);
			String colorValue = (signUpObj.detailsPageDetailElement).getCssValue("background-color");
			Assert.assertTrue(colorValue.equals("rgba(255, 136, 0, 1)"), "Details section is not highlighted");
		}
		
		/*
		 * Description : Verify Email and password files displaying or not
		 */
		@Test
		public void verifyEmailPasswordFields() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			Assert.assertTrue(verifyElementPresent(signUpObj.emailField) && verifyElementPresent(signUpObj.passWordField),
					"Email and Password fields are not displaying");
		}
		
		/*
		 * Description : Verify error is displaying in VAT field for giving invalid
		 * vat for EU countries
		 */
		@Test
		public void verifyErrorDisplayedInVatFieldForGivingInvalidVATForEUCountries() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			click(signUpObj.detailsCountryDropdown);
			waitTill(2000);
			List<WebElement> listOfCountries = signUpObj.countryDropdownvalues;
			click(listOfCountries.get(75));
			waitTill(1000);
			sendKeys(signUpObj.detailsVATNoTextField, "GB231653279");
			waitTill(1000);
			Assert.assertTrue(signUpObj.detailsVATfieldDangerText.isDisplayed(),
					"Error message is not displayed for VAT field on giving invalid VAT for EU countries");
		}
		/*
		 * Description : Verify error message at acceptance check box if not enabled
		 */

		@Test
		public void verifyErrorMessageAtAcceptanceBox() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			sendKeys(signUpObj.emailField, username);
			sendKeys(signUpObj.passWordField, password);
			jsClick(driver,signUpObj.nextButton);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.agreeCheckBoxError),
					"The Terms of Use field is required message is not displayed at Acceptance checkbox");
		}
		
		/*
		 * (Sign up - Details page for Private users) Description : Validate all the
		 * fields
		 */
		@Test
		public void validatePrivateDetailsPageFields() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
			try {
			click(signUpObj.privateRadioButton);
			}catch (Exception e) {
				jsClick(driver,signUpObj.privateRadioButton);
			}
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPrivateFullNameTextField);
			jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
			waitTill(2000);
			sendKeys(signUpObj.detailsPrivateFullNameTextField, "&hgjj^%");
			sendKeys(signUpObj.detailsCityTextField, "#$ghg");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "hjh&*HHJ");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "&hgjj&*^%");
			sendKeys(signUpObj.detailsPhoneTextField, "67567");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "67566");
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "&hgjj&*^%");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "email");
			jsClick(driver, signUpObj.detailsNextbutton);
			waitTill(2000);
			Assert.assertEquals(signUpObj.detailsPrivateNamefieldDangerText.getText(), "The full name value is not valid",
					"The full name value is not valid error is not displaying upon giving special charecters");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city value is not valid",
					"The city value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address value is not valid",
					"The address value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code value is not valid",
					"The zip code value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsMobilePhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoPrivateContactPersonDangerText.getText(),
					"The contact person value is not valid",
					"The contact person value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoEmailDangerText.getText(),
					"The email field must be a valid email",
					"The email field must be a valid email error is not displaying");
			sendKeys(signUpObj.detailsPrivateFullNameTextField,"");
			sendKeys(signUpObj.detailsCityTextField, "");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "");
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox,"");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "");
			sendKeys(signUpObj.detailsPhoneTextField, "");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "");
			sendKeys(signUpObj.detailsPrivateFullNameTextField, "  ");
			sendKeys(signUpObj.detailsCityTextField, "   ");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "   ");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "  ");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "  ");
			sendKeys(signUpObj.detailsPhoneTextField, "  ");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "  ");
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "  ");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, "  ");
			jsClick(driver, signUpObj.detailsNextbutton);
			waitTill(2000);
			Assert.assertEquals(signUpObj.detailsPrivateNamefieldDangerText.getText(), "The full name field is required",
					"The full name value is not valid error is not displaying upon giving empty spaces");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city field is required",
					"The city field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address field is required",
					"The address field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code field is required",
					"The zip code field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsWebsiteDangerText.getText(), "The website field format is invalid",
					"The website field format is invalid error is not displaying");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(), "The phone field is required",
					"The phone field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsMobilePhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoPrivateContactPersonDangerText.getText(),
					"The contact person field is required", "The contact person field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoEmailDangerText.getText(), "The email field is required",
					"The email field is required error is not displaying");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField,"");
			sendKeys(signUpObj.detailsPrivateFullNameTextField, "Full name");
			sendKeys(signUpObj.detailsCityTextField, "city");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "zip code");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "website");
			sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "31232823232");
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "contact person");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, username);
			jsClick(driver, signUpObj.detailsNextbutton);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.packageDisplaying),
					"Package page is not displayed after entering the valid credentials");
		}
		/*
		 * Verify 'Terms of use', 'Privacy' and 'Cookies' links are redirecting to
		 * Tradus Zendesk pages
		 */

		@Test
		public void verifyTermsOfUsePrivacyCookiesLinksAreRedirectingToTradusZendeskPages() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			Assert.assertTrue(verifyElementPresent(signUpObj.termsOfUseLink), "Terms of use link is not present");
			try{
				click(signUpObj.termsOfUseLink);
				}catch(Exception e) {
					jsClick(driver,signUpObj.termsOfUseLink);
				}
			waitTill(2000);
			Set<String> windows = driver.getWindowHandles();
			Assert.assertTrue(windows.size() > 1, "Terms of use link is not opened in new tab");
			String parentWindow = driver.getWindowHandle();
			switchWindow(driver, parentWindow);
			Assert.assertTrue(verifyElementPresent(signUpObj.termsPageCheck),
					"Terms of use link is not redirected to Tradus Zendesk Page");
			driver.close();
			driver.switchTo().window(parentWindow);
			Assert.assertTrue(verifyElementPresent(signUpObj.privacyLink), "Privacy link is not present");
			try{
				click(signUpObj.privacyLink);
				}catch(Exception e) {
					jsClick(driver,signUpObj.privacyLink);
				}
			waitTill(2000);
			windows = driver.getWindowHandles();
			Assert.assertTrue(windows.size() > 1, "Privacy link is not opened in new tab");
			switchWindow(driver, parentWindow);
			Assert.assertTrue(verifyElementPresent(signUpObj.termsPageCheck),
					"Privacy link is not redirected to Tradus Zendesk Page");
			driver.close();
			driver.switchTo().window(parentWindow);
			Assert.assertTrue(verifyElementPresent(signUpObj.coockiesLink), "Cookies link is not present");
			try {
				click(signUpObj.coockiesLink);
			}catch(Exception e) {
				jsClick(driver,signUpObj.coockiesLink);
			}
			waitTill(2000);
			windows = driver.getWindowHandles();
			Assert.assertTrue(windows.size() > 1, "Cookies link is not opened in new tab");
			switchWindow(driver, parentWindow);
			Assert.assertTrue(verifyElementPresent(signUpObj.termsPageCheck),
					"Privacy link is not redirected to Tradus Zendesk Page");
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		/*
		 * Description : Verify error message for invalid email and password
		 * 
		 */
		@Test
		public void verifyErrorMessageWithInvalidDataInEmailAndPassword() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			sendKeys(signUpObj.emailField, "InvalidEmail");
			sendKeys(signUpObj.passWordField, "Invalid");
			jsClick(driver,signUpObj.nextButton);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.emailFieldDangerText),
					"Email error message is not displaying");
			String errorMessage = signUpObj.emailFieldDangerText.getText();
			Assert.assertEquals(errorMessage, "The email field must be a valid email",
					"The email error message text is not correct");
			Assert.assertTrue(verifyElementPresent(signUpObj.passWordFieldDangerText),
					"Password error message is not displaying");
			errorMessage = signUpObj.passWordFieldDangerText.getText();
			Assert.assertEquals(errorMessage, "The password field must be at least 8 characters",
					"The password error message text is not correct");
		}

		/*
		 * Description : Verify phone numbers are displaying or not at bottom
		 */
		@Test
		public void verifyPhoneNumbersAreDisplayingAtBottom() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
			Assert.assertTrue(verifyElementPresent(signUpObj.phoneNumberAtBottomDE),
					"Germany phone number is not displaying");
			Assert.assertTrue(verifyElementPresent(signUpObj.phoneNumberAtBottomNL),
					"Netherland phone number is not displaying");
			Assert.assertTrue(verifyElementPresent(signUpObj.phoneNumberAtBottomRO),
					"Roman phone number is not displaying");
		}
		
		/*
		 * Description : Verify Error message on entering password less than 8
		 * characters or not
		 */
		@Test
		public void verifyErrorMessageOnEnteringPasswordLessThanEightCharacters() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			sendKeys(signUpObj.emailField, username);
			sendKeys(signUpObj.passWordField, "12345");
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.passWordErrorMessgaeElement), 
					"No error msg displayed on entering password less than 8 characters");
			String errorTextOnEnteringPassWord = getText(signUpObj.passWordErrorMessgaeElement);
			Assert.assertTrue(errorTextOnEnteringPassWord.equals("The password field must be at least 8 characters"),
						"The password field must be at least 8 characters error message is not displaying");
		}
		
		/*
		 * (Sign up - Details page for Private users) Description: Verify
		 * 'Netherlands' country is autoselected
		 */
		@Test
		public void verifyPrivateDetailsPageCountryAutoSelected() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			jsClick(driver,signUpObj.privateRadioButton);
			signUpObj.setAccountUsernameAndPassword();
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsCountryDropdown);
	        Assert.assertEquals(getText(signUpObj.detailsCountryDropdown), "Netherlands", "Netherlands is not displaying as default country in details page");
		}
		
		/*
		 * Description : Verify 'Netherlands' country is autoselected 
		 */
		@Test
		public void verifyNetherlandsCountryIsAutoSelected() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands"),
					"Netherlands country is not autoselected");
		}
		
		/*
		 * Description : Verify user can change the country by selecting from drop
		 * down
		 */
		@Test
		public void verifyUserCanChangeTheCountryBySelectingValuesFromDropDown() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim()).collect(Collectors.toCollection(ArrayList::new));
			click(signUpObj.detailsCountryDropdown);
			click(listOfCountries.get(listOfCOuntriesNames.indexOf("India")));
			Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equals("India"),
					"Unable to select India from Country dropdown");
			waitTill(2000);
			click(signUpObj.detailsCountryDropdown);
			click(listOfCountries.get(listOfCOuntriesNames.indexOf("Antarctica")));
			waitTill(2000);
			Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equals("Antarctica"),
					"Unable to select Israle from Country dropdown");
		}
		
		/*
		 *Description: Verify on trying to go to next step without enabling the Whatsapp checkbox and
		 * viceversa Note: It should work in both the cases
		 */
		@Test
		public void verifyNavigatingToNextWithAndWithoutEnablingWhatsAppCheckbox() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			SignUpPackageSectionTradusPROPage signUpPkgObj= new SignUpPackageSectionTradusPROPage(driver);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsVATNoTextField);
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			sendKeys(signUpObj.detailsContactPersonTextField, "contactperson");
			sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
			jsClick(driver,signUpObj.detailsNextbutton);
	        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
			jsClick(driver,signUpObj.packageBackbutton);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
	        jsClick(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
	        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
	        jsClick(driver,signUpObj.accountIcon);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
	        jsClick(driver,signUpObj.privateRadioButton);
			waitTill(2000);
			jsClick(driver,signUpObj.nextButton);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPrivateFullNameTextField);
			sendKeys(signUpObj.detailsPrivateFullNameTextField, "Full name");
			sendKeys(signUpObj.detailsCityTextField, "city");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "zip code");
			sendKeys(signUpObj.detailsPhoneTextField, "31232323232");
			jsClick(driver,signUpObj.detailsNextbutton);
	        explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.privateSinglePackage);
	        jsClick(driver,signUpObj.packageBackbutton);
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
	        jsClick(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
		}
		
		/*
		 * Description :Verify error messages at Company name, address, city and Zip
		 * code fields as 'Please fill this field' on giving outside EU VAT number
		 * and the country should also be the outside EU in this case
		 */
		@Test
		public void verifyErrormessageformandatoryfieldsongivingoutsideEUVATno() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
					"SignUp details page is not displayed");
			jsClick(driver,signUpObj.detailsCountryDropdown);
			List<WebElement> listOfCountries = signUpObj.countryDropdownvalues;
			Random random = new Random();
			int randomInt = random.nextInt(listOfCountries.size());
			jsClick(driver,listOfCountries.get(randomInt));
			sendKeys(signUpObj.detailsVATNoTextField, "GB231653279");
			waitTill(4000);
			Assert.assertEquals(signUpObj.detailsCompanyNamefieldDangerText.getText(), "The company name field is required",
					"Error message for company name field is not displaying");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city field is required",
					"Error message for city field is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address field is required",
					"Error message for address field is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code field is required",
					"Error message for ZIP Code field is not displaying");
		}
		
		/* Description : Verify error message on trying to go next step
		 *  without filling any of the details
		 */
		@Test
		public void verifyErrorForMandatoryFieldsByClickingNextWithoutGivingValuesInPrivatedetails() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.emailField);
			click(signUpObj.privateRadioButton);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsCityTextField);
			sendKeys(signUpObj.detailsCityTextField, "city");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "897678");
			sendKeys(signUpObj.detailsPhoneTextField, "315678677");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsPrivateNamefieldDangerText.getText(), "The full name field is required",
					"The full name field is required error is not displaying");
			sendKeys(signUpObj.detailsCityTextField, "");
			sendKeys(signUpObj.detailsPrivateFullNameTextField, "username");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city field is required",
					"The city field is required error is not displaying");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "");
			sendKeys(signUpObj.detailsCityTextField, "city");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address field is required",
					"The address field is required error is not displaying");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code field is required",
					"The zip code field is required error is not displaying");
			sendKeys(signUpObj.detailsPhoneTextField,"");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "897678");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsPhoneDangerText),
					"The phone field is required error is not displaying");
			sendKeys(signUpObj.detailsPhoneTextField, "318976787");

			jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "Name");
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsBillingInfoEmailDangerText.getText(), "The email field is required",
					"The email field is required error is not displaying");
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox,"");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, username);
			jsClick(driver, signUpObj.detailsNextbutton);
			Assert.assertEquals(signUpObj.detailsBillingInfoPrivateContactPersonDangerText.getText(),
					"The contact person field is required", "The contact person field is required error is not displaying");
		}
		
		/*
		 * Description: Verify all the details entered in company name, address,
		 * city and Zip code are vanished on clearing VAT number from VAT field
		 */
		@Test
		public void verifyVarnishingOfPopulatedcompanyAddressCityZIPfieldsafterremovingVATno() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPageDetailElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
					"SignUp details page is not displayed");
			waitTill(2000);
			Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands"),
					"Netherlands country is not autoselected");
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			waitTill(3000);

			// Randomly checking whether fields are filled after inserting VAT no or
			// not
			Assert.assertTrue(getAttribute(signUpObj.detailsCompanyNameTextField, "value").equals("TRADUS B.V."),
					"Company name is not populated after entering valid VAT no");
			Assert.assertTrue(getAttribute(signUpObj.detailsCompanyZIPTextField, "value").equals("1097DN"),
					"ZIP Code is not populated after entering valid VAT no");
			sendKeys(signUpObj.detailsVATNoTextField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			waitTill(3000);
			Assert.assertTrue(getAttribute(signUpObj.detailsCompanyNameTextField, "value").isEmpty(),
					"Company name is still displayed after removing VAT no");
			Assert.assertTrue(getAttribute(signUpObj.detailsCityTextField, "value").isEmpty(),
					"City name is still displayed after removing VAT no");
			Assert.assertTrue(getAttribute(signUpObj.detailsCompanyAddressTextField, "value").isEmpty(),
					"Company address is still displayed after removing VAT no");
			Assert.assertTrue(getAttribute(signUpObj.detailsCompanyZIPTextField, "value").isEmpty(),
					"ZIP code is still displayed after removing VAT n ");
		}
		
		/* 
		 * Description: Verify error message on trying to go next step without
		 * filling any of the details
		 */
		@Test
		public void verifyErrormsgonClickingNextbtnwithoutfillinganyofthedetails() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPageDetailElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
					"SignUp details page is not displayed");
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
			waitTill(3000);
			Assert.assertEquals(signUpObj.detailsVATfieldDangerText.getText(),("The vat number field is required"),
					"Error message for VAT field is not displaying");
			Assert.assertEquals(signUpObj.detailsCompanyNamefieldDangerText.getText(),("The company name field is required"),
					"Error message for company name field is not displaying");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(),("The city field is required"),
					"Error message for city field is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(),("The address field is required"),
					"Error message for address field is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(),("The zip code field is required"),
					"Error message for ZIP Code field is not displaying");
			Assert.assertEquals(signUpObj.detailsContactPersonDangerText.getText(),("The contact person field is required"),
					"Error message for Contact person field is not displaying");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(),("The phone field is required"),
					"Error message for phone field is not displaying");
			driver.navigate().refresh();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			jsClick(driver,signUpObj.privateRadioButton);
			signUpObj.setAccountUsernameAndPassword();
	        explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsCityTextField);
			jsClick(driver,signUpObj.detailsNextbutton);
			waitTill(3000);
			Assert.assertEquals(getText(signUpObj.detailsPrivateNamefieldDangerText),("The full name field is required"),
					"Error message for full name field isn't displaying for Private user");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(),("The city field is required"),
					"Error message for city field is not displaying for Private user");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(),("The address field is required"),
					"Error message for address field is not displaying for Private user");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(),("The zip code field is required"),
					"Error message for ZIP Code field is not displaying for Private user");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(),("The phone field is required"),
					"Error message for phone field is not displaying for Private user");
		}
		/*
		 * Description : Verify Company name, Address, city and zip code fields are
		 * auto filled on giving valid EU VAT number (Ex:NL854502130B01)
		 */

		@Test
		public void verifyFewFieldsAreAutofilledOnGivingValidEUVATNumber() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			waitTill(2000);
			if(!getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands")) {
				List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
				ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
						.collect(Collectors.toCollection(ArrayList::new));
				int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
				click(signUpObj.detailsCountryDropdown);
				waitTill(2000);
				click(listOfCountries.get(randomInt));
				waitTill(2000);
			}
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			jsClick(driver,signUpObj.detailsCompanyText);
			waitTill(8000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String actualCountry = (String) js.executeScript("return document.getElementsByName('company-name')[0].value");
			String actualCity = (String) js.executeScript("return document.getElementsByName('company-city')[0].value");
			String actualAddress = (String) js
					.executeScript("return document.getElementsByName('company-address')[0].value");
			String actualZipcode = (String) js.executeScript("return document.getElementsByName('company-zip')[0].value");
			Assert.assertTrue(
					!actualCountry.isEmpty() && !actualCity.isEmpty() && !actualAddress.isEmpty()
							&& !actualZipcode.isEmpty(),
					"Company name, Address, city and zip code fields are not autofilled by giving Valid VAT number");
		}
		
		/*
		 * Description : Verify on package page displaying on entering valid details
		 */
		@Test
		public void verifyPackagePageDisplayingOnEntreringValidDetailsForPrivateUser() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "private");
		}
		
		/*
		 * Description : Verify package selection highlighted by default
		 */
		@Test
		public void verifyPackageSectioHighLightedByDefault() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "company");
			String radioValue = (signUpObj.packageSelectedDefaultElement).getAttribute("value").trim();
			Assert.assertTrue(radioValue.equals("84"), "Package is not selected by default");
		}
		
		@Test
		public void verifyAllFieldsInDetailSection() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPageDetailElement);
			jsClick(driver, signUpObj.detailsBillingInformationTooglebutton);
			fillUpTheDetailsPage(signUpObj, "&hgjj^%", "67566");
			Assert.assertEquals(signUpObj.detailsCompanyNamefieldDangerText.getText(),
					"The company name value is not valid",
					"The company name value is not valid error is not displaying upon giving special charecters");
			Assert.assertEquals(signUpObj.detailsContactPersonDangerText.getText(), "The contact person value is not valid",
					"The contact person value is not valid error is not displaying upon giving special charecters");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city value is not valid",
					"The city value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address value is not valid",
					"The address value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code value is not valid",
					"The zip code value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsWebsiteDangerText.getText(), "The website field is not a valid URL",
					"The website field is not a valid URL error is not displaying");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsMobilePhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCompanyContactPersonDangerText.getText(),
					"The contact person value is not valid",
					"The billing contact person value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCompanyNameDangerText.getText(),
					"The company name value is not valid",
					"The billing company name value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoEmailDangerText.getText(),
					"The email field must be a valid email",
					"The billing email field must be a valid email error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoAddressDangerText.getText(), "The address value is not valid",
					"The billing address value is not valid error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCityDangerText.getText(),
					"The city field may only contain alphabetic characters as well as spaces",
					"The billing city field may only contain alphabetic characters as well as spaces error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoZIPCodeDangerText.getText(),
					"The zip code field format is invalid",
					"The billing zip code field format is invalid error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoPhoneDangerText.getText(), "This phone number is not valid.",
					"The billing phone number is not valid. error is not displaying");
			waitTill(2000);
			fillUpTheDetailsPage(signUpObj, "   ", "   ");
			Assert.assertEquals(signUpObj.detailsCompanyNamefieldDangerText.getText(), "The company name field is required",
					"The company name value is not a valid text, error is not displaying upon giving empty spaces");
			Assert.assertEquals(signUpObj.detailsCityDangerText.getText(), "The city field is required",
					"The city field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsAddressDangerText.getText(), "The address field is required",
					"The address field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsZIPCodeDangerText.getText(), "The zip code field is required",
					"The zip code field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsContactPersonDangerText.getText(), "The contact person field is required",
					"The contact person field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsWebsiteDangerText.getText(), "The website field is not a valid URL",
					"The website field is not a valid URL error is not displaying");
			Assert.assertEquals(signUpObj.detailsPhoneDangerText.getText(), "The phone field is required",
					"The phone field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsMobilePhoneDangerText.getText(), "This phone number is not valid.",
					"This phone number is not valid. error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCompanyContactPersonDangerText.getText(),
					"The contact person field is required",
					"The billing contact person field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCompanyNameDangerText.getText(),
					"The company name field is required",
					"The billing company name field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoEmailDangerText.getText(), "The email field is required",
					"The billing email field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoAddressDangerText.getText(), "The address field is required",
					"The billing address field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoCityDangerText.getText(), "The city field is required",
					"The billing city field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoZIPCodeDangerText.getText(), "The zip code field is required",
					"The billing zip code field is required error is not displaying");
			Assert.assertEquals(signUpObj.detailsBillingInfoPhoneDangerText.getText(), "The phone field is required",
					"The billing phone field is required error is not displaying");
			scrollUp(driver);
			waitTill(1000);
			sendKeys(signUpObj.detailsVATNoTextField, "NL465");
			waitTill(1000);
			Assert.assertEquals(getText(signUpObj.detailsVATfieldDangerText), "This number is not valid.",
					"This number is not valid. error is not displaying");
			waitTill(1000);
			sendKeys(signUpObj.detailsVATNoTextField, "    ");
			waitTill(1000);
			Assert.assertEquals(getText(signUpObj.detailsVATfieldDangerText), "The vat number field is required",
					"The vat number field is required error is not displaying");
			jsClick(driver,signUpObj.detailsCompanyCountry);
			waitTill(2000);
			jsClick(driver,signUpObj.detailsCompanyCountrySelectText);
			waitTill(2000);
			sendKeys(signUpObj.detailsVATNoTextField, "IN34576879");
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsCompanyNamefieldDangerText);
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, "contact person");
			sendKeys(signUpObj.detailsBillingInfoCompanyTextbox, "contact person");
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, username);
			sendKeys(signUpObj.detailsBillingInfoAddressTextbox, "Address");
			sendKeys(signUpObj.detailsBillingInfoCityTextbox, "City");
			sendKeys(signUpObj.detailsBillingInfoZIPTextbox, "code");
			sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, "9876543210");
			sendKeys(signUpObj.detailsCompanyNameTextField, "Full name");
			sendKeys(signUpObj.detailsContactPersonTextField, "Full name");
			sendKeys(signUpObj.detailsCityTextField, "city");
			sendKeys(signUpObj.detailsCompanyAddressTextField, "address");
			sendKeys(signUpObj.detailsCompanyZIPTextField, "zip code");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "website@aaa.com");
			sendKeys(signUpObj.detailsPhoneTextField, "9876543210");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "9876543210");
			jsClick(driver,signUpObj.detailsBillingCompanyCountry);
			waitTill(2000);
			jsClick(driver,signUpObj.detailsBillingCompanyCountrySelectText);
			waitTill(2000);
			scrollDown(driver);
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.packageDisplaying);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.packageDisplaying),
					"Package page is not displayed after entering the valid credentials");
		}
		public void fillUpTheDetailsPage(SignupTPROPage signUpObj, String data1, String data2) {
			sendKeys(signUpObj.detailsCompanyNameTextField, data1);
			sendKeys(signUpObj.detailsCityTextField, data1);
			sendKeys(signUpObj.detailsCompanyAddressTextField, data1);
			sendKeys(signUpObj.detailsCompanyZIPTextField, data1);
			sendKeys(signUpObj.detailsContactPersonTextField, data1);
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, data1);
			sendKeys(signUpObj.detailsPhoneTextField, data2);
			sendKeys(signUpObj.detailsMobilePhoneTextField, data2);
			sendKeys(signUpObj.detailsBillingInfoCompanyTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoContactPersonTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoEmailTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoAddressTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoCityTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoZIPTextbox, data1);
			sendKeys(signUpObj.detailsBillingInfoPhoneTextbox, data1);
			try {
				jsClick(driver, signUpObj.detailsNextbutton);
				waitTill(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * Description : Verify on trying back link, signup up initial page should
		 * display
		 */
		@Test
		public void verifyOnTryingBackLinkFromDeatilsPageToAccountsPage() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			String tabName = getText(signUpObj.commonElementToCheckTabByText).trim();
			Assert.assertTrue(tabName.equals("Details"),
					"Details page is not displayed after entering the valid credentials");
			jsClick(driver,signUpObj.detailsBackbutton);
			waitTill(2000);
			tabName = getText(signUpObj.commonElementToCheckTabByText).trim();
			Assert.assertTrue(tabName.equals("Account"),
					"Account page is not displayed after clicking back button from Details Page");
		}
		
		/*
		 * Description : Verify on package page displaying on entering valid details
		 */
		@Test
		public void verifyPackagePageDisplayingOnEntreringValidDetails() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "company");
		}
		
		/*
		 * Description : Verify package selection highlighted by default
		 */
		@Test
		public void verifyPackageSectionHighlightedByDefaultForPrivateUser() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "private");
			String radioValue = (signUpObj.packageSelectedDefaultElement).getAttribute("value").trim();
			Assert.assertTrue(radioValue.equals("83"), "Package is not selected by default");
		}
		
		/*
		 * Description : Verify error message on missing particular mandatory field
		 */
		@Test
		public void verifyErrorMessageOnMissingParticularMandatoryField() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitTill(2000);
			signUpObj.setAccountUsernameAndPassword();
			waitForElement(signUpObj.detailsCountryText);
			String[] fields = { "VAT number", "Company name", "City", "Address", "ZIP code", "Contact person", "Phone" };
			for (int count = 0; count < fields.length; count++) {
				for (int exCount = 0; exCount < fields.length; exCount++) {
					if (exCount != count) {
						switch (exCount) {
						case 0:
							sendKeys(signUpObj.detailsVATNoTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsVATNoTextField, vatNumber);
							waitTill(4000);
							break;
						case 1:
							sendKeys(signUpObj.detailsCompanyNameTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCompanyNameTextField, companyName);
							waitTill(2000);
							break;
						case 2:
							sendKeys(signUpObj.detailsCityTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCityTextField, cityName);
							waitTill(2000);
							break;
						case 3:
							sendKeys(signUpObj.detailsCompanyAddressTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCompanyAddressTextField, companyAddress);
							waitTill(1000);
							break;
						case 4:
							sendKeys(signUpObj.detailsCompanyZIPTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCompanyZIPTextField, zipCode);
							waitTill(1000);
							break;
						case 5:
							sendKeys(signUpObj.detailsContactPersonTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsContactPersonTextField, contactPerson);
							waitTill(1000);
							break;
						case 6:
							sendKeys(signUpObj.detailsPhoneTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsPhoneTextField, phoneNumber);
							waitTill(1000);
							break;
						}
					} else {
						switch (exCount) {
						case 0:
							sendKeys(signUpObj.detailsVATNoTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(4000);
							break;
						case 1:
							sendKeys(signUpObj.detailsCompanyNameTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(2000);
							break;
						case 2:
							sendKeys(signUpObj.detailsCityTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(2000);
							break;
						case 3:
							sendKeys(signUpObj.detailsCompanyAddressTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						case 4:
							sendKeys(signUpObj.detailsCompanyZIPTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						case 5:
							sendKeys(signUpObj.detailsContactPersonTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						case 6:
							sendKeys(signUpObj.detailsPhoneTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						}
					}
				}
				jsClick(driver,signUpObj.detailsNextbutton);
				waitTill(2000);
				switch(count)
				{
				case 0:
					Assert.assertTrue(getText(signUpObj.detailsVATfieldDangerText).equals("The vat number field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 1:
					Assert.assertTrue(getText(signUpObj.detailsCompanyNamefieldDangerText).equals("The company name field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;	
				case 2:
					Assert.assertTrue(getText(signUpObj.detailsCityDangerText).equals("The city field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 3:
					Assert.assertTrue(getText(signUpObj.detailsAddressDangerText).equals("The address field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 4:
					Assert.assertTrue(getText(signUpObj.detailsZIPCodeDangerText).equals("The zip code field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 5:
					Assert.assertTrue(getText(signUpObj.detailsContactPersonDangerText).equals("The contact person field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 6:
					Assert.assertTrue(getText(signUpObj.detailsPhoneDangerText).equals("The phone field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				}
			}
		}
		
		/*
		 * Description : Verify on trying back link, signup up initial page should
		 * display
		 */
		@Test
		public void verifyOnTryingBackLinkFromDeatilsPageToAccountsPageForPrivateUser() throws Exception{
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitTill(3000);
			sendKeys(signUpObj.emailField,username);
			sendKeys(signUpObj.passWordField,password);
			new Actions(driver).click(signUpObj.privateRadioButton).perform();
			waitTill(1000);
			jsClick(driver,signUpObj.agreeCheckBox);
			waitTill(2000);
			jsClick(driver,signUpObj.nextButton);
			waitTill(2000);
			String tabName = getText(signUpObj.commonElementToCheckTabByText).trim();
			Assert.assertTrue(tabName.equals("Details"),
					"Details page is not displayed after entering the valid credentials");
			jsClick(driver,signUpObj.detailsBackbutton);
			waitTill(2000);
			tabName = getText(signUpObj.commonElementToCheckTabByText).trim();
			Assert.assertTrue(tabName.equals("Account"),
					"Account page is not displayed after clicking back button from Details Page");
		}
		
		/*
		 * Description : Verify error message on missing particular mandatory field
		 */
		@Test
		public void verifyErrorMessageOnMissingParticularMandatoryFieldForPrivateUser() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitTill(2000);
			sendKeys(signUpObj.emailField, username);
			sendKeys(signUpObj.passWordField, password);
			click(signUpObj.privateRadioButton);
			click(signUpObj.agreeCheckBox);
			waitTill(2000);
			jsClick(driver,signUpObj.nextButton);
			waitForElement(signUpObj.detailsCountryText);
			String[] fields = { "Full name", "City", "Address", "ZIP code", "Phone" };
			for (int count = 0; count < fields.length; count++) {
				for (int exCount = 0; exCount < fields.length; exCount++) {
					if (exCount != count) {
						switch (exCount) {
						case 0:
							sendKeys(signUpObj.detailsPrivateFullNameTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsPrivateFullNameTextField, contactPerson);
							waitTill(4000);
							break;
						case 1:
							sendKeys(signUpObj.detailsCityTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCityTextField, cityName);
							waitTill(2000);
							break;
						case 2:
							sendKeys(signUpObj.detailsCompanyAddressTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCompanyAddressTextField, companyAddress);
							waitTill(1000);
							break;
						case 3:
							sendKeys(signUpObj.detailsCompanyZIPTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsCompanyZIPTextField, zipCode);
							waitTill(1000);
							break;
						case 4:
							sendKeys(signUpObj.detailsPhoneTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							sendKeys(signUpObj.detailsPhoneTextField, phoneNumber);
							waitTill(1000);
							break;
						}
					} else {
						switch (exCount) {
						case 0:
							sendKeys(signUpObj.detailsPrivateFullNameTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(4000);
							break;
						case 1:
							sendKeys(signUpObj.detailsCityTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(2000);
							break;
						case 2:
							sendKeys(signUpObj.detailsCompanyAddressTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(2000);
							break;
						case 3:
							sendKeys(signUpObj.detailsCompanyZIPTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						case 4:
							sendKeys(signUpObj.detailsPhoneTextField,Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
							waitTill(1000);
							break;
						}
					}
				}
				jsClick(driver,signUpObj.detailsNextbutton);
				waitTill(2000);
				switch(count)
				{
				case 0:
					Assert.assertTrue(getText(signUpObj.detailsPrivateNamefieldDangerText).equals("The full name field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 1:
					Assert.assertTrue(getText(signUpObj.detailsCityDangerText).equals("The city field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 2:
					Assert.assertTrue(getText(signUpObj.detailsAddressDangerText).equals("The address field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 3:
					Assert.assertTrue(getText(signUpObj.detailsZIPCodeDangerText).equals("The zip code field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				case 4:
					Assert.assertTrue(getText(signUpObj.detailsPhoneDangerText).equals("The phone field is required"),
							"Error message for "+fields[count]+" is not displaying");
					break;
				}
			}
		}
		/*
		 *  Verify 'Use the same information for billing' toggle switch is displaying below the details
		 */
		@Test
		public void verifyToggleSwitchIsDisplayingForBillingInformation() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitTill(2000);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsNextbutton);
			//waitTill(4000);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsBillingInformationToggle),
					"Same information for billing toggle switch is not displaying");
		}
		
		/*
		 * Description: Verify error message is displaying at phone number field if
		 * it's different country number
		 */
		@Test
		public void verifyErrormsgforPhoneNumberifitdoesntmatchwithCountryformat() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.setAccountUsernameAndPassword();
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsPageDetailElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
					"SignUp details page is not displayed");
			waitTill(2000);
			Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands"),
					"Netherlands country is not autoselected");
			sendKeys(signUpObj.detailsPhoneTextField, "745 145683");
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
			Assert.assertTrue(getText(signUpObj.detailsPhoneDangerText).length() < 2,
					"Error message still displayed even after entering valid phone number for Netherlands");
			List<WebElement> listOfCountries = signUpObj.countryDropdownvalues;
			Random random = new Random();
			int randomInt = random.nextInt(listOfCountries.size());
			click(signUpObj.detailsCountryDropdown);
			waitTill(2000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
			jsClick(driver,signUpObj.detailsNextbutton);
			waitTill(2000);
			Assert.assertTrue(getText(signUpObj.detailsPhoneDangerText).equals("This phone number is not valid."),
					"Invalid phone number error message has not displayed");
		}
		/*
		 *  Verify VAT is applied for EU country Private users too though they don't have any company name and VAT number
		 */
		@Test
		public void verifyVATApplicableForEUCountryPrivateUsersThoughDontHaveCompanyNameAndVAT() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitForElement(signUpObj.nextButton);
			actionClick(driver,signUpObj.privateRadioButton);
			signUpObj.setAccountUsernameAndPassword();
			Assert.assertFalse(verifyElementPresent(signUpObj.detailsVATNoTextField),
					"VAT field is present for private user");
			Assert.assertFalse(verifyElementPresent(signUpObj.detailsCompanyNameTextField),
					"Company Name field is present for private user");
		}
		
		/*
		 * Description : Verify package selection highlighted by default
		 */
		@Test
		public void verifyPackageSectioHighLightedByDefaultForPrivateUser() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "private");
			String radioValue = (signUpObj.packageSelectedDefaultElement).getAttribute("value").trim();
			Assert.assertTrue(radioValue.equals("83"), "Package is not selected by default");
		}
		
		/*
		 * Description : Verify Error message on entering already registered email
		 * or not and check link
		 */
		@Test
		public void verifyErrorMessageOnEnteringAlreadyRegisteredEmail() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			sendKeys(signUpObj.emailField, userName);
			waitTill(5000);
			Assert.assertTrue(getText(signUpObj.emailFieldDangerText).equals("An account with this email already exists. Go here to sign in"),
			" Error alert with an account already exits and sign link are not present ");
			click(signUpObj.goToSignInPageErrorLinkOnEnteringRegisteredEmail);
			waitForElement(signUpObj.loginPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.loginPageVerificationElement),
					"Login page is not working on entering register email in signup page");
		}
		
		/*
		 * Verify checkout page is displaying on clicking 'Create an account' button with all valid data
		 */ 
		@Test
		public void verifyCheckoutPageIsDisplayingOnClickingCreateAnAccountWithValidData() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			SignUpPackageSectionTradusPROPage  signUpPkgObj=new SignUpPackageSectionTradusPROPage(driver);
		    sendKeys(signUpObj.emailField, "harish.boyapati+1098@olx.com");
			sendKeys(signUpObj.passWordField, password);
			jsClick(driver,signUpObj.agreeCheckBox);
			waitTill(2000);
			jsClick(driver,signUpObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.detailsCountryDropdown);
			sendKeys(signUpObj.detailsVATNoTextField,"NL854502130B01");
			waitTill(4000);
			sendKeys(signUpObj.detailsContactPersonTextField,"Harish");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
			sendKeys(signUpObj.detailsPhoneTextField,"777 888999");
			sendKeys(signUpObj.detailsMobilePhoneTextField,"612345678");
			waitTill(1000);
			jsClick(driver,signUpObj.detailsNextbutton);
			waitTill(2000);
			explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
			click(signUpPkgObj.nextButton);
			waitTill(1000);
			waitForElement(signUpObj.createAnAccount);
			click(signUpObj.createAnAccount);
			waitTill(2000);
			waitForElement(signUpObj.checkoutPage);
			Assert.assertTrue(verifyElementPresent(signUpObj.checkoutPage), "Its not redirected to checkout page");
		}
		
		/*
		 * Description: Verify full name, email and phone number fields are displaying on clicking 'Reach out to our sales team' button and verify those fields
		 * and able to submit it
		 */
		@Test
		public void verifyFieldsinSalesRequestFormAndSuccessMessageafterSendingIt() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.ReachOutToOurSalesTeam);
			jsClick(driver, signUpObj.ReachOutToOurSalesTeam);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.SubmitButtonInSupportForm);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.FullNameInputFieldInSupportForm), "Full name field in support form is missing");
			Assert.assertTrue(verifyElementPresent(signUpObj.EmailInputFieldInSupportForm), "Email field in support form is missing");
			Assert.assertTrue(verifyElementPresent(signUpObj.PhoneInputFieldInSupportForm), "Phone nuber field in support form is missing");
			sendKeys(signUpObj.FullNameInputFieldInSupportForm,"Testing");
			sendKeys(signUpObj.EmailInputFieldInSupportForm,"automation.testing.sunfra@gmail.com");
			sendKeys(signUpObj.PhoneInputFieldInSupportForm,"31777888999");
			waitTill(2000);
			jsClick(driver, signUpObj.SubmitButtonInSupportForm);
			explicitWaitFortheElementTobeVisible(driver, signUpObj.SuccessmessageofSupportForm);
			Assert.assertTrue(
					getText(signUpObj.SuccessmessageofSupportForm).equals(
							"Your message has been successfully sent. One of our team members will contact you soon."),
					"Expected success message not displaying bu submitting the support form");
			waitTill(3000);	
		}
		
		/*
		 * Description: Verify welcome text along with 'Start by creating your account' text is displaying 
		 */
		@Test
		public void verifyWelcomeTextalongwithStartbyCreatingAccountisDisplaying() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		waitTill(2000);
		String headerText = getText(signUpObj.signUpPageHeader).replace("\n", ", ").trim();
		Assert.assertTrue(headerText.equals("Welcome to Tradus PRO, Start by creating your account"),
				"Welcome to Tradus PRO, Start by creating your account text is not displayng in signUp page header");
	}
		/*
		 * Description: Verify Account, Details, package and confirmation stages and by default Account stage should be highlighted
		 */
		@Test
		public void verifyDifferentStagesOfAccountisVisibleandAccountStageisHighlighted() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		waitTill(2000);
		List<WebElement> accountStages=signUpObj.signUpStages;
		for(int i=0;i<accountStages.size();i++) {
			Assert.assertTrue(verifyElementPresent(accountStages.get(i)), " "+i+" stages is not present in sighUp Initial page");
			if(i==0)
			{
				Assert.assertTrue(getAttribute(accountStages.get(i),"class").isEmpty(), "Account section is not highlighted on launching signUp page");
			}
			else {
				Assert.assertTrue(getAttribute(accountStages.get(i),"class").equals("disabled"), " "+i+" stage is highlighted on launching signUp page");
			}
		}
		}
		
		/*
		 * Description: Verify company and Radio check boxes displaying below the stages
		 */
		@Test
		public void verifyComoanyandPrivateRadioBtnsBelowSignUpStages() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			waitTill(2000);
			Assert.assertTrue(verifyElementPresent(signUpObj.companyRadioBtnbelowStages), "Company radio button is not present below signUp Link");
			Assert.assertTrue(verifyElementPresent(signUpObj.privateRadioBtnBelowStages), "Private radio button is not present below signUp Link");
		}	
}

