package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.scrollDown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;
import com.tradus.pro.pages.ProfileTradusPROPage;


import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

public class ProfileTradusPROTest extends BaseClass {
	/*
	 * Description: Verify profile page is displaying on clicking the link
	 */
	@Test
	public void verifyProfilePageIsDisplayingByClickingOnProfileLinkOnSidebar() throws Exception {
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms")) {
			overviewPage.doLogIn(testUser,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.languageDropdowninHeader);
		jsClick(driver,overviewPage.languageDropdowninHeader);
		new Actions(driver).moveToElement(overviewPage.EnglishOptionFromHeader).click().build().perform();
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profileLinkOnSideBar);
		//jsClick(driver, overviewPage.profileLinkOnSideBar);
		try {
			click(overviewPage.profileLinkOnSideBar);
		}catch (Exception E) {
			jsClick(driver, overviewPage.profileLinkOnSideBar);
		}
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profilePageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewPage.profilePageVerificationElement),
				"Profile page is not displayng by clicking on profile link on sidebar");
		
	}
	
	/*
	 * Description: Verify all the details are prefilled with the details provided
	 * while filling sign up form
	 */
	@Test
	public void verifyAllTheDetailsArePrefilledInProfilePageForCompanyWithDetailsProvidedWhileFillingSignupForm()
			throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
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
		Assert.assertTrue(profilePage.contactPersonTextField.get(0).getAttribute("value").equals("Test"),
				"Given contact person in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.phoneTextField.get(0).getAttribute("value").equals("31777888999"),
				"Given phone number in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.mobilePhoneTextField.getAttribute("value").equals("31612345678"),
				"Given mobile phone number in signup details page is not displayng in profile page");
		Assert.assertTrue(profilePage.websiteTextField.getAttribute("value").equals("www.sunfra.com/"),
				"Given website in signup details page is not displayng in profile page");
	//	Assert.assertFalse(verifyElementPresent(profilePage.enabledWhatsappToggler),
			//	"Whatsapp togler is enabled in details even when the user didn't enabled while signup");
		jsClick(driver, profilePage.billingInofrmationCheckBox);
		waitTill(2000);
		//explicitWaitFortheElementTobeVisible(driver, profilePage.billingInfoEmailTextField);
		/*Assert.assertTrue(profilePage.companyNameTextField.get(1).getAttribute("value").equals("TRADUS B.V."),
				"Given company name in signup details billing page is not displayng in profile page");*/
		/*Assert.assertTrue(profilePage.contactPersonTextField.get(1).getAttribute("value").equals("Harish"),
				"Given contact person in signup details billing page is not displayng in profile page");*/
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
	 * Description: Verify able to selelct the drop downs and save the changes
	 */
	@Test
	public void verifyAbleToSelectSpokenLanguagesAndServicesDropdownsAndSaveChangesInSettings() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
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
		try {
			click(profilePage.saveChangeButtonForSpokenLanguages);
			}
			catch(Exception e) {
				jsClick(driver,profilePage.saveChangeButtonForSpokenLanguages);
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
				"Your spoken languages setting has been updated.",
				"Expected success message not displaying upon updating the spoken language");
		jsClick(driver, profilePage.detailsTab);
		driver.navigate().refresh();
		explicitWaitFortheElementTobeVisible(driver, profilePage.chooseFileButtonInDetailsTab);
		jsClick(driver, profilePage.ExtraservicesDropdownList.get(2));
		waitTill(2000);
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings),
				"The list of services you provide has been updated.",
				"Expected success message not displaying upon updating the extra services");

	}

	/*
	 * Description: Verify export personal data and delete account links and
	 * redirecting to 'Zendesk' help pages on clicking them
	 */
	@Test
	public void verifyRedirectionOfExportPersonalDataAndDeleteAccountLinks() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.exportPersonalDataLinkInSettings);
		try {
			click( profilePage.exportPersonalDataLinkInSettings);
			}
			catch(Exception E) {
				jsClick(driver, profilePage.exportPersonalDataLinkInSettings);
			}
		try {
			click(profilePage.deleteAccountLinkInSettings);
			}
			catch(Exception E) {
				jsClick(driver, profilePage.deleteAccountLinkInSettings);
			}
		String parentWindow=driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		switchWindow(driver, parentid);
		explicitWaitFortheElementTobeVisible(driver, profilePage.zendeskVerificationElement);
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://help.tradus.com/hc/en-us/requests/new?ticket_form_id=360000046569",
				"Page not redirected to Zendesk by clicking on delete account link");
		switchWindow(driver, childid);
		explicitWaitFortheElementTobeVisible(driver, profilePage.zendeskVerificationElement);
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://help.tradus.com/hc/en-us/requests/new?ticket_form_id=360000046569",
				"Page not redirected to Zendesk by clicking on export personal data link");
		driver.switchTo().window(parentWindow);
	}

	/*
	 * Description: Verify able to update the password and save the changes
	 */
	@Test
	public void verifyAbleToUpdateThePasswordAndSaveChanges() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.EmailHeadingInsettingsTab);
		waitTill(2000);
		sendKeys(profilePage.passwordFieldInSettings, pwd);
		sendKeys(profilePage.confirmPasswordFieldInSettings, pwd);
		try{
			click(profilePage.saveChangeButtonForPasswordChange);
		}catch (Exception E) {
		jsClick(driver, profilePage.saveChangeButtonForPasswordChange);
		}
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
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		SoftAssert softAssertion= new SoftAssert();
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		jsClick(driver, profilePage.settingsTab);
		explicitWaitFortheElementTobeVisible(driver, profilePage.languagesDropdownInSettings);
		Select s = new Select(profilePage.languagesDropdownInSettings);
		s.selectByVisibleText("Nederlands");
		jsClick(driver, profilePage.saveChangeButtonForLanguages);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		softAssertion.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Uw taal is bijgewerkt",
				"Expected success message not displaying upon updating the language");
		s.selectByVisibleText("English");
		waitTill(3000);
		jsClick(driver, profilePage.saveChangeButtonForLanguagesInNederlands);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		softAssertion.assertEquals(getText(profilePage.successMessageUponChangingSettings), "Your language has been updated",
				"Expected success message not displaying upon updating the language");
		softAssertion.assertAll();
	}
	/*
	 * Description: Verify services field is displaying along with save changes
	 * button and show details links are displaying
	 */
	@Test
	public void verifyServicesFieldIsDisplayingAlongWithSaveChangesButtonAndShowDetailsLink() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
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
	 * Description: Verify the info about services are displaying propelry on
	 * clicking the show details link
	 */
	@Test
	public void verifyInfoAboutServicesAreDisplayingProperlyOnclickingTheShowDetailsLink() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		waitTill(2000);
		scrollDown(driver);
		explicitWaitFortheElementTobeVisible(driver, profilePage.OnlineConsultingServiceUnderShowDetails);
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
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		jsClick(driver, profilePage.ShowDetailsLinkUnderServices);
		explicitWaitFortheElementTobeVisible(driver, profilePage.OnlineConsultingServiceUnderShowDetails);
		waitTill(1000);
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
	 * Description: Verify able to save the services on clicking save changes button, Verify able to save all the options
	 */
	@Test
	public void verifyAbleToSaveTheServicesOnclickingSaveChangesButton() throws Exception {
		ProfileTradusPROPage profilePage = new ProfileTradusPROPage(driver);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", profilePage.ServicesDropdown);*/
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/lms/profile")) {
			profilePage.doLogIn(testUser,pwd);
		}
			try {
			explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/profile");
			}
		explicitWaitFortheElementTobeVisible(driver, profilePage.profilePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, profilePage.ShowDetailsLinkUnderServices);
		scrollToElement(driver,profilePage.ServicesDropdown);
		waitTill(2000);
		for(int i=0;i<profilePage.ServicesDropdownList.size();i++)
		{
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
		}
		waitTill(1000);
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "The list of services you provide has been updated.", 
				"Expected success message not displaying upon updating the extra services");
		int s= profilePage.SelectedServicesList.size();
		for(int i=0;i<s;i++)
		{
			click(profilePage.CrossIconOnSelectedServices);
		}
		waitTill(1000);
		jsClick(driver, profilePage.saveChangeButtonForExtraServicesDropdown);
		explicitWaitFortheElementTobeVisible(driver, profilePage.successMessageUponChangingSettings);
		Assert.assertEquals(getText(profilePage.successMessageUponChangingSettings), "The list of services you provide has been updated.", 
				"Expected success message not displaying upon updating the extra services");
	}
}
