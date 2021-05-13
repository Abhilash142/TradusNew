package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;

import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userNamePL;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.ProfileOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class ProfileOtomotoProfiLMSTest extends BaseClass{
	
	/*
	 * Description: Verify profile page is displaying on clicking the link
	 */
	@Test
	public void verifyProfilePageIsDisplayingByClickingOnProfileLinkOnSidebar() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileOptioninSiderBar);
	    jsClick(driver, overviewPage.profileOptioninSiderBar);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profilePageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewPage.profilePageVerificationElement),
				"Profile page is not displayng by clicking on profile link on sidebar");
	}
	
	/*
	 * Description: Verify all the details are prefilled with the details provided while filling sign up form
	 */
	@Test
	public void verifyAllTheDetailsArePrefilledInProfilePageWithDetailsProvidedWhileFillingSignupForm() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileOptioninSiderBar);
	    jsClick(driver, overviewPage.profileOptioninSiderBar);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profilePageVerificationElement);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.countrySelected.get(0)).equals("Netherlands"),
				"Selected country in signup details page is not displayng in profile page");
		Assert.assertTrue((profilePage.VATTextField.getAttribute("value")).equals("NL854502130B01"),
				"Given VAT number in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.companyNameTextField.get(0).getAttribute("value").equals("TRADUS B.V."),
				"Given company name in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.addressTextField.get(0).getAttribute("value").equals("WIBAUTSTRAAT 00137 C"),
				"Given address in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.cityTextField.get(0).getAttribute("value").equals("AMSTERDAM"),
				"Given city in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.zipcodeTextField.get(0).getAttribute("value").equals("1097DN"),
				"Given ZIP code in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.contactPersonTextField.getAttribute("value").equals("Harry logisticks"),
				"Given contact person in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.phoneTextField.get(0).getAttribute("value").equals("493025555338"),
				"Given phone number in signup details page is not displayng in profile page");
		jsClick(driver, profilePage.billingInofrmationCheckBox);
		explicitWaitFortheElementTobeVisible(driver, profilePage.billingInfoEmailTextField);
		/*Assert.assertTrue(profilePage.companyNameTextField.get(1).getAttribute("value").equals("TRADUS B.V."),
				"Given company name in signup details billing page is not displayng in profile page");*/
		/*Assert.assertTrue(
				profilePage.billingInfoEmailTextField.getAttribute("value").equals(testUser),
				"Given email in signup details billing page is not displayng in profile page");*/
		Assert.assertTrue(profilePage.addressTextField.get(1).getAttribute("value").equals("WIBAUTSTRAAT 00137 C"),
				"Given address in signup details billing page is not displayng in profile page");
		Assert.assertTrue(profilePage.cityTextField.get(1).getAttribute("value").equals("AMSTERDAM"),
				"Given city in signup details billing page is not displayng in profile page");
		Assert.assertTrue(profilePage.zipcodeTextField.get(1).getAttribute("value").equals("1097DN"),
				"Given zip code in signup details billing page is not displayng in profile page");
		/*Assert.assertTrue(profilePage.phoneTextField.get(1).getAttribute("value").equals("31777888999"),
				"Given phone in signup details billing page is not displayng in profile page");*/
		Assert.assertTrue(getText(profilePage.countrySelected.get(1)).equals("Netherlands"),
				"Selected country in signup details billing page is not displayng in profile page");
	}
	
	/*
	 * Description: Verify able to upload image 
	 */
	@Test
	public void verifyAbletoUploadLogo() throws Exception {
	OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
	LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
	loginPage.setAccountEmailAndPassword(userNamePL,pwd);
	try {
	click(loginPage.LoginButton);
	}catch(Exception e) {
		jsClick(driver,loginPage.LoginButton);
	}
    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
    explicitWaitFortheElementTobeVisible(driver,overviewPage.profileOptioninSiderBar);
    jsClick(driver, overviewPage.profileOptioninSiderBar);
	waitTill(2000);
	explicitWaitFortheElementTobeVisible(driver, overviewPage.profilePageVerificationElement);
	ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
	explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
	explicitWaitFortheElementTobeVisible(driver, profilePage.chooseFileButtonInDetailsTab);
	
	profilePage.chooseFileButtonInDetailsTab.sendKeys(System.getProperty("user.dir") + "\\TradusLogo.png");
	waitTill(4000);
	click(profilePage.uploadButtonInDetailsTab);
	explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
	Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
			"Your logo has been successfully updated.",
			"Success message not displaying upon uploading the image in profile page");
	waitTill(2000);
	Assert.assertTrue(profilePage.logoInProfilePage.getAttribute("src").contains("https://images.tradus.com/v1/"),
			"Uploaded logo is not displaying in profile page");
	Assert.assertTrue(overviewPage.sellerLogoonHeader.getAttribute("src").contains("https://images.tradus.com/v1/"),
			"Uploadd seller logo is not displaying on header");
	}

	/*
	 * Description: Validate all the fields
	 */
	@Test
	public void validateAllTheFieldsInProfilePageDetails() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		sendKeys(profilePage.companyNameTextField.get(0), "%^");
		Assert.assertTrue(
				getText(profilePage.companyNameFieldDangerText.get(0)).equals("The company name value is not valid"),
				"Respective error message not displaying upon giving invali data in the company name field in details page");

		sendKeys(profilePage.addressTextField.get(0), "$%");
		Assert.assertTrue(getText(profilePage.AddressFieldDangerText).equals("The address value is not valid"),
				"Respective error message not displaying upon giving invalid data in the address field in details page");

		sendKeys(profilePage.cityTextField.get(0), "^&*");
		Assert.assertTrue(getText(profilePage.CityFieldDangerText).equals("The city value is not valid"),
				"Respective error message not displaying upon giving ivalid value in the city field in details page");

		sendKeys(profilePage.zipcodeTextField.get(0), "(*");
		Assert.assertTrue(getText(profilePage.zipCodeFieldDangerText).equals("The zip code value is not valid"),
				"Respective error message not displaying upon giving ivalid value in the zip code field in details page");

		sendKeys(profilePage.contactPersonTextField, "&* ");
		Assert.assertTrue(
				getText(profilePage.contactPersonFieldDangerText)
						.equals("The contact person value is not valid"),
				"Respective error message not displaying upon giving ivalid value in the contact person field in details page");

		sendKeys(profilePage.phoneTextField.get(0), "3177788899");
		Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(0)).equals("This phone number is not valid."),
				"Respective error message not displaying upon giving ivalid value in the phone field in details page");

		sendKeys(profilePage.mobilePhoneTextField, "3178788899");
		Assert.assertTrue(getText(profilePage.mobilePhoneFieldDangerText).equals("This phone number is not valid."),
				"Respective error message not displaying upon giving ivalid value in the mobile phone field in details page");

		sendKeys(profilePage.websiteTextField, "^&^");
		Assert.assertTrue(getText(profilePage.websiteFieldDangerText).equals("The website field is not a valid URL"),
				"Respective error message not displaying upon giving ivalid value in the website field in details page");

		jsClick(driver, profilePage.billingInofrmationCheckBox);
		explicitWaitFortheElementTobeVisible(driver, profilePage.billingInfoEmailTextField);
		sendKeys(profilePage.billingInfoEmailTextField, "harish");
		Assert.assertTrue(getText(profilePage.emailFieldDangerText).equals("The email field must be a valid email"),
				"Respective error message not displaying upon giving ivalid value in the email field in billing details page");

		sendKeys(profilePage.phoneTextField.get(1), "3177788899");
		Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(1)).equals("This phone number is not valid."),
				"Respective error message not displaying upon giving ivalid value in the phone field in billing details page");
		
		sendKeys(profilePage.companyNameTextField.get(1), "%^");
		waitTill(3000);
		Assert.assertTrue(
				getText(profilePage.companyNameFieldDangerText.get(1)).equals("The company name value is not valid"),
				"Respective error message not displaying upon giving invali data in the company name field in billing details page");

	}
	
	/*
	 * Description: Verify error message is dispalying on missing one field too
	 * i.e., all fields are mandatory
	 */
	@Test
	public void verifyErrorMessageOnMissingAnyFieldInProfilePageDetails() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		sendKeys(profilePage.companyNameTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.companyNameFieldDangerText.get(0)).equals("The company name field is required"),
				"Error message not displaying upon missing the company name field in details page");
		sendKeys(profilePage.companyNameTextField.get(0), "TRADUS B.V.");
		sendKeys(profilePage.addressTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.AddressFieldDangerText).equals("The address field is required"),
				"Error message not displaying upon missing the address field in details page");
		sendKeys(profilePage.addressTextField.get(0), "WIBAUTSTRAAT 00137 C");
		sendKeys(profilePage.cityTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.CityFieldDangerText).equals("The city field is required"),
				"Error message not displaying upon missing the city field in details page");
		sendKeys(profilePage.cityTextField.get(0), "AMSTERDAM");
		sendKeys(profilePage.zipcodeTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.zipCodeFieldDangerText).equals("The zip code field is required"),
				"Error message not displaying upon missing the zip code field in details page");
		sendKeys(profilePage.zipcodeTextField.get(0), "1097DN");
		sendKeys(profilePage.contactPersonTextField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(
				getText(profilePage.contactPersonFieldDangerText).equals("The contact person field is required"),
				"Error message not displaying upon missing the contact person field in details page");
		sendKeys(profilePage.contactPersonTextField, "Test");
		sendKeys(profilePage.phoneTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(0)).equals("The phone field is required"),
				"Error message not displaying upon missing the phone field in details page");
		sendKeys(profilePage.phoneTextField.get(0), "31777888999");
		jsClick(driver, profilePage.billingInofrmationCheckBox);
		explicitWaitFortheElementTobeVisible(driver, profilePage.billingInfoEmailTextField);
		sendKeys(profilePage.billingInfoEmailTextField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.emailFieldDangerText).equals("The email field is required"),
				"Error message not displaying upon missing the email field in billing details page");
		sendKeys(profilePage.billingInfoEmailTextField, "harish.boyapati.sunfra@gmail.com");
		sendKeys(profilePage.phoneTextField.get(1), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(1)).equals("The phone field is required"),
				"Error message not displaying upon missing the phone field in billing details page");
		sendKeys(profilePage.phoneTextField.get(1), "31777888999");
		sendKeys(profilePage.companyNameTextField.get(1), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.companyNameFieldDangerText.get(1)).equals("The company name field is required"),
				"Error message not displaying upon missing the company name field in details page");
		sendKeys(profilePage.companyNameTextField.get(1), "TRADUS B.V.");
	}
	
	/*
	 * Description: Verify spoken languages field displaying in 'Settings' text 
	 */
	@Test
	public void verifySpokenLanguageFieldDisplayingBelowSettingText() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.spokenLanguagesFieldInSettings);
		Assert.assertTrue(verifyElementPresent(profilePage.spokenLanguagesFieldInSettings),
				"Spoken languages field is not displaying in settings tab of profile page");
	}
	
	/*
	 * Description: Verify all the languages which are present in header are displaying in the drop down
	 */
	@Test
	public void verifyAllLanguagesarePresentinHeaderareDisplayinginDropdown() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj=new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, overviewObj.languageAtHeader);
		List<WebElement> siteLangOps= overviewObj.languageDropdownOptionsList;
		Select s=new Select(profilePage.languagesDropdownInSettings);
		List<WebElement> langOpsinSettings=s.getOptions();
		for(int i=0;i<siteLangOps.size();i++) {
			Assert.assertTrue(
					 siteLangOps.get(i).getText().trim()
							.equals(langOpsinSettings.get(i).getText().trim()),
							langOpsinSettings.get(i).getText().trim() + " is not present in lang dropdown");
		}
	}
	
	/*
	 * Description: Verify able to select the drop downs and save the changes
	 */
	@Test
	public void verifyAbleToSelectSpokenLanguagesAndServicesDropdownsAndSaveChangesInSettings() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.spokenLanguagesFieldInSettings);
		try {
		click(profilePage.spokenLanguagesDropdownInSettings);
		}
		catch(Exception e) {
			jsClick(driver,profilePage.spokenLanguagesDropdownInSettings);
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.NederlandsLanguageInSettingsSpokenLanguageDropdown);
		jsClick(driver, profilePage.NederlandsLanguageInSettingsSpokenLanguageDropdown);
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForSpokenLanguages);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
				"Your spoken languages setting has been updated.",
				"Expected success message not displaying upon updating the spoken language");
		waitTill(2000);
		jsClick(driver, profilePage.detailsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.chooseFileButtonInDetailsTab);
		waitTill(2000);
		jsClick(driver, profilePage.ExtraservicesDropdownList.get(2));
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
				"The list of services you provide has been updated.",
				"Expected success message not displaying upon updating the extra services");
	}
	
	/*
	 * Description: Verify email, new passord creation fields and language drop down fields are displayign below settings text
	 */
	@Test
	public void verifyEmailAndNewPasswordCreationFieldsAndLanguageDropdownAreDisplayingUnderSettings()
			throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.EmailHeadingInsettingsTab);
		Assert.assertTrue(verifyElementPresent(profilePage.EmailHeadingInsettingsTab),
				"Email heading is not displaying in settings page");
		Assert.assertEquals(getText(profilePage.givenEmailInsettingsTab), "automation.test.sunfra+01@gmail.com",
				"Given email is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.LanguageHeadingInsettingsTab),
				"language heading is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.LanguageSubHeadingInsettingsTab),
				"language sub heading is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.languagesDropdownInSettings),
				"language dropdown is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.saveChangeButtonForLanguages),
				"save change button for language dropdown is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.passwordChangeHeading),
				"password change heading is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.passwordChangeSubHeading),
				"password change sub heading is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.passwordFieldInSettings),
				"password field is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.confirmPasswordFieldInSettings),
				"confirm password field is not displaying in settings page");
		Assert.assertTrue(verifyElementPresent(profilePage.saveChangeButtonForPasswordChange),
				"save change button for password field is not displaying in settings page");
	}
	
	/*
	 * Description: Verify export personal data and delete account links and redirecting to 'Zendesk' help pages on clicking them
	 */
	@Test
	public void verifyRedirectionOfExportPersonalDataAndDeleteAccountLinks() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.EmailHeadingInsettingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.exportPersonalDataLinkInSettings);
		String parentid=driver.getWindowHandle();
		jsClick(driver, profilePage.exportPersonalDataLinkInSettings);
		waitTill(1000);
		switchWindow(driver,parentid);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pomoc.otomoto.pl/hc/pl/requests/new?ticket_form_id=70373"), "Export personal data link isn't navigating properly");
		driver.switchTo().window(parentid);
		explicitWaitFortheElementTobeVisible(driver, profilePage.deleteAccountLinkInSettings);
		jsClick(driver, profilePage.deleteAccountLinkInSettings);
		waitTill(1000);
		switchWindow(driver,parentid);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pomoc.otomoto.pl/hc/pl/requests/new?ticket_form_id=70373"), " Delete account link isn't navigating properly");
		driver.switchTo().window(parentid);
	}
	
	/*
	 * Description: Verify able to update the password and save the changes
	 */
	@Test
	public void verifyAbleToUpdateThePasswordAndSaveChanges() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.passwordFieldInSettings);
		sendKeys(profilePage.passwordFieldInSettings, pwd);
		sendKeys(profilePage.confirmPasswordFieldInSettings, pwd);
		jsClick(driver, profilePage.saveChangeButtonForPasswordChange);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
				"The password was successfully updated.",
				"'The password was successfully updated.' success message not displaying upon changing the password");
	}
	
	/*
	 * Description: Verify able to update the language
	 */
	@Test
	public void verifyAbleToUpdateTheLanguageInSettings() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		waitTill(2000);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.passwordFieldInSettings);
		explicitWaitFortheElementTobeVisible(driver, profilePage.languagesDropdownInSettings);
		Select s = new Select(profilePage.languagesDropdownInSettings);
		s.selectByVisibleText("Nederlands");
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForLanguages);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Uw taal is bijgewerkt",
				"Expected success message not displaying upon updating the language");
		waitTill(2000);
		s.selectByVisibleText("English");
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForLanguagesInNederlands);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		waitTill(2000);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Your language has been updated",
				"Expected success message not displaying upon updating the language");
	}
	
	/*
	 * Description: Verify services field is displaying along with save changes button and show details links are displaying
	 */
	@Test
	public void verifyServicesFieldIsDisplayingAlongWithSaveChangesButtonAndShowDetailsLink() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		Assert.assertTrue(verifyElementPresent(profilePage.ServicesHeading),
				"Services heading is not displaying in profile page");
		Assert.assertTrue(verifyElementPresent(profilePage.ServicesSubHeading),
				"Services sub heading is not displaying in profile page");
		Assert.assertTrue(verifyElementPresent(profilePage.ServicesDropdown),
				"Services dropdown is not displaying in profile page");
		Assert.assertTrue(verifyElementPresent(profilePage.saveChangeButtonForExtraServicesDropdown),
				"Save changes button for services is not displaying in profile page");
		Assert.assertTrue(verifyElementPresent(profilePage.ShowDetailsLinkUnderServices),
				"Show details link is not displaying in profile page");
	}
	
	/*
	 * Description: Verify the info about services are displaying propelry on clicking the show details link
	 */
	@Test
	public void verifyInfoAboutServicesAreDisplayingProperlyOnclickingTheShowDetailsLink() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		explicitWaitFortheElementTobeVisible(driver, profilePage.OnlineConsultingServiceUnderShowDetails);
		scrollDown(driver);
		waitTill(2000);
		Assert.assertEquals(profilePage.ServicesListUnderShowDetails.size(), 6,
				"Expected number of services are not displaying in services dropdown in profile page");
		int size = profilePage.ServicesListUnderShowDetails.size();
		
		for (int i = 0; i < size; i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(
						getText(profilePage.ServicesListUnderShowDetails.get(i))
								.equals("Online consulting - This seller offers video call or online consulting."),
						"Online consulting Service info under show details link is not displaying as expected");
				break;
			case 1:
				Assert.assertTrue(
						getText(profilePage.ServicesListUnderShowDetails.get(i)).equals(
								"Online contract - The purchase contract can be closed online with this seller."),
						"Online contract Service info under show details link is not displaying as expected");
				break;
			case 2:
				Assert.assertTrue(
						getText(profilePage.ServicesListUnderShowDetails.get(i))
								.equals("Delivery possible - This seller offers delivery to the buyer."),
						"Delivery possible Service info under show details link is not displaying as expected");
				break;
			case 3:
				Assert.assertTrue(
						getText(profilePage.ServicesListUnderShowDetails.get(i))
								.equals("Reservation - Possible Long-term reservation is possible for this vehicle."),
						"Reservation Service info under show details link is not displaying as expected");
				break;
			case 4:
				Assert.assertTrue(getText(profilePage.ServicesListUnderShowDetails.get(i)).equals(
						"Outside regular office hours - This seller is available outside regular office hours."),
						"Outside regular office hours Service info under show details link is not displaying as expected");
				break;
			case 5:
				Assert.assertTrue(
						getText(profilePage.ServicesListUnderShowDetails.get(i))
								.equals("Garage open - The garage of this seller is open."),
						"Garage open Service info under show details link is not displaying as expected");
			}
		}
	}
	
	/*
	 * Description: Verify all the services mentioned in show details links are displaying in the services drop down
	 */
	@Test
	public void verifyAllTheServicesMentionedInShowDetailsLinksAreDisplayingInTheServicesDropdown() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		explicitWaitFortheElementTobeVisible(driver, profilePage.OnlineConsultingServiceUnderShowDetails);
		waitTill(3000);
		Assert.assertEquals(profilePage.ServicesListUnderShowDetails.size(), 6, 
				"Expected number of services are not displaying in services dropdown in profile page");
		int size= profilePage.ServicesListUnderShowDetails.size();
		for(int i=0;i<size;i++)
		{
			Assert.assertTrue(getText(profilePage.ServicesListUnderShowDetails.get(i)).contains(getText(profilePage.ServicesDropdownList.get(i))),
					"Services mentioned in show details link are not displaying in services dropdown");
		}
	}
	
	/*
	 * Description: Verify able to save the services on clicking save changes button and Verify able to save all the options
	 */
	@Test
	public void verifyAbletoSavetheServicesonClickingonSaveChanges() throws Exception {
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(1000);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		scrollToElement(driver,profilePage.ServicesDropdown);
		waitTill(2000);
		int i=0;
		while(i<profilePage.ServicesDropdownList.size())
		{
			waitTill(2000);
			try {
			click(profilePage.ServicesDropdown);
			}catch(Exception e) {
				jsClick(driver,profilePage.ServicesDropdown);
			}
			waitTill(2000);
			try {
			click(profilePage.ServicesDropdownList.get(i));
			}catch(Exception e) {
				jsClick(driver,profilePage.ServicesDropdownList.get(i));
			}
			waitTill(2000);
			jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
			explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
			Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "The list of services you provide has been updated.", 
					"Expected success message not displaying upon updating the extra services");
		    i++;
		}
		
		int s= profilePage.SelectedServicesList.size();
		for(int j=0;j<s;j++)
		{
			click(profilePage.CrossIconOnSelectedServices);
		}
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "The list of services you provide has been updated.", 
				"Expected success message not displaying upon updating the extra services");
	}
	
	
}
