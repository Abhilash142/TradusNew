package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.GlobalConstants.osName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userNamePL;
import static com.tradus.core.GlobalConstants.PLuser;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.ProfileOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class ProfileOtomotoProfiLMSTest extends BaseClass{
	/*
	 * Description: Verify all the details are prefilled with the details provided while filling sign up form
	 */
	@Test
	public void verifyAllTheDetailsArePrefilledInProfilePageWithDetailsProvidedWhileFillingSignupForm() throws Exception {
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
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
	OverviewOtomotoProfiLMSPage overviewObj=new OverviewOtomotoProfiLMSPage(driver);
	ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
	waitForElement(profilePage.userNameInHeader);
	if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
		profilePage.doLogIn(testUserPL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
	}
	explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
	explicitWaitFortheElementTobeVisible(driver, profilePage.chooseFileButtonInDetailsTab);
	String temp = "";
	if(osName.equalsIgnoreCase("Windows"))
		temp = "\\TradusLogo.png";
	else
		temp = "/TradusLogo.png";
	profilePage.chooseFileButtonInDetailsTab.sendKeys(System.getProperty("user.dir") + temp);
	waitTill(4000);
	click(profilePage.uploadButtonInDetailsTab);
	explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
	Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
			"Your logo has been successfully updated.",
			"Success message not displaying upon uploading the image in profile page");
	waitTill(2000);
	Assert.assertTrue(profilePage.logoInProfilePage.getAttribute("src").contains("https://images.tradus.com/v1/"),
			"Uploaded logo is not displaying in profile page");
	System.out.println(overviewObj.sellerLogoonHeader.getAttribute("src"));
	Assert.assertTrue(overviewObj.sellerLogoonHeader.getAttribute("src").contains("https://images.tradus.com/v1/"),
			"Uploadd seller logo is not displaying on header");
	}
	/*
	 * Description: Verify error message is dispalying on missing one field too
	 * i.e., all fields are mandatory
	 */
	@Test
	public void verifyErrorMessageOnMissingAnyFieldInProfilePageDetails() throws Exception {
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		
		sendKeys(profilePage.companyNameTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(getText(profilePage.companyNameFieldDangerText.get(0)).equals("The company name field is required"),
				"Error message not displaying upon missing the company name field in details page");
		sendKeys(profilePage.companyNameTextField.get(0), "TRADUS B.V.");
		sendKeys(profilePage.addressTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(getText(profilePage.AddressFieldDangerText).equals("The address field is required"),
				"Error message not displaying upon missing the address field in details page");
		sendKeys(profilePage.addressTextField.get(0), "WIBAUTSTRAAT 00137 C");
		sendKeys(profilePage.cityTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(getText(profilePage.CityFieldDangerText).equals("The city field is required"),
				"Error message not displaying upon missing the city field in details page");
		sendKeys(profilePage.cityTextField.get(0), "AMSTERDAM");
		sendKeys(profilePage.zipcodeTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(getText(profilePage.zipCodeFieldDangerText).equals("The zip code field is required"),
				"Error message not displaying upon missing the zip code field in details page");
		sendKeys(profilePage.zipcodeTextField.get(0), "1097DN");
		sendKeys(profilePage.contactPersonTextField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(
				getText(profilePage.contactPersonFieldDangerText).equals("The contact person field is required"),
				"Error message not displaying upon missing the contact person field in details page");
		sendKeys(profilePage.contactPersonTextField, "Harry logisticks");
		sendKeys(profilePage.phoneTextField.get(0), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(1000);
		Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(0)).equals("The phone field is required"),
				"Error message not displaying upon missing the phone field in details page");
		sendKeys(profilePage.phoneTextField.get(0), "493025555338");
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
		//waitTill(2000);
		/*Assert.assertTrue(getText(profilePage.phoneFieldDangerText.get(1)).equals("The phone field is required"),
				"Error message not displaying upon missing the phone field in billing details page");
		sendKeys(profilePage.phoneTextField.get(1), "31777888999");*/
		sendKeys(profilePage.companyNameTextField.get(1), Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		jsClick(driver, profilePage.saveChangesButtonUnderDetails);
		waitTill(2000);
		Assert.assertTrue(getText(profilePage.companyNameFieldDangerText.get(1)).equals("The company name field is required"),
				"Error message not displaying upon missing the company name field in details page");
		sendKeys(profilePage.companyNameTextField.get(1), "TRADUS B.V.");
	}
	/*
	 * Description: Verify all the languages which are present in header are displaying in the drop down
	 */
	@Test
	public void verifyAllLanguagesarePresentinHeaderareDisplayinginDropdown() throws Exception {
		OverviewOtomotoProfiLMSPage overviewObj=new OverviewOtomotoProfiLMSPage(driver);
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Abhilash")) {
			profilePage.doLogIn(PLuser,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
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
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Abhilash")) {
			profilePage.doLogIn(PLuser,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
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
	 * Description: Verify export personal data and delete account links and redirecting to 'Zendesk' help pages on clicking them
	 */
	@Test
	public void verifyRedirectionOfExportPersonalDataAndDeleteAccountLinks() throws Exception {
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile") || !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.EmailHeadingInsettingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.exportPersonalDataLinkInSettings);
		String parentid=driver.getWindowHandle();
		jsClick(driver, profilePage.exportPersonalDataLinkInSettings);
		waitTill(1000);
		switchWindow(driver,parentid);
		//System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://pomoc.otomotoprofi.pl/hc/pl/requests/new?ticket_form_id"), "Export personal data link isn't navigating properly");
		Assert.assertTrue(verifyElementPresent(profilePage.sendRqstPageElement), "Email field isn't present in Export personal data page");
		driver.switchTo().window(parentid);
		explicitWaitFortheElementTobeVisible(driver, profilePage.deleteAccountLinkInSettings);
		jsClick(driver, profilePage.deleteAccountLinkInSettings);
		waitTill(1000);
		switchWindow(driver,parentid);
		//System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://pomoc.otomotoprofi.pl/hc/pl/requests/new?ticket_form_id"), " Delete account link isn't navigating properly");
		Assert.assertTrue(verifyElementPresent(profilePage.sendRqstPageElement), "Email field isn't present in Export personal data page");
		driver.switchTo().window(parentid);
	}
	/*
	 * Description: Verify able to update the password and save the changes
	 */
	@Test
	public void verifyAbleToUpdateThePasswordAndSaveChanges() throws Exception {
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
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
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Abhilash")) {
			profilePage.doLogIn(PLuser,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
		jsClick(driver,profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.passwordFieldInSettings);
		explicitWaitFortheElementTobeVisible(driver, profilePage.languagesDropdownInSettings);
		Select s = new Select(profilePage.languagesDropdownInSettings);
		s.selectByVisibleText("Nederlands");
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForLanguages);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Uw taal is bijgewerkt",
				"Expected success message not displaying upon updating the language");
		waitTill(2000);
		s.selectByVisibleText("English");
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForLanguagesInNederlands);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		softAssertion.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Your language has been updated",
				"Expected success message not displaying upon updating the language");
	}
	/*
	 * Description: Verify all the services mentioned in show details links are displaying in the services drop down
	 */
	@Test
	public void verifyAllTheServicesMentionedInShowDetailsLinksAreDisplayingInTheServicesDropdown() throws Exception {
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
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
		ProfileOtomotoProfiLMSPage profilePage = new ProfileOtomotoProfiLMSPage(driver);
		waitForElement(profilePage.userNameInHeader);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/profile")|| !getText(profilePage.userNameInHeader).trim().contains("Harry")) {
			profilePage.doLogIn(testUserPL,pwd);
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.settingsTab);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		scrollToElement(driver,profilePage.ServicesDropdown);
		waitTill(2000);
		int i=0;
		while(i<profilePage.ServicesDropdownList.size())
		{
			waitTill(1000);
			try {
			click(profilePage.ServicesDropdown);
			}catch(Exception e) {
				jsClick(driver,profilePage.ServicesDropdown);
			}
			waitTill(1000);
			try {
			click(profilePage.ServicesDropdownList.get(i));
			}catch(Exception e) {
				jsClick(driver,profilePage.ServicesDropdownList.get(i));
			}
			waitTill(1000);
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
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "The list of services you provide has been updated.", 
				"Expected success message not displaying upon updating the extra services");
	}
	

}
