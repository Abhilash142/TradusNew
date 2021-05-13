package sanity_test_TPRO;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.ContactTradusProPage;
import com.tradus.pro.pages.LoginTradusPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.switchWindow;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;


public class ContactTradusProTest extends BaseClass {
	/*
	 * Description: Verify 'Terms of use', 'Privacy policy' and 'contact' links are displaying on clicking 'Contact' link
	 */
	@Test(priority=1)
	public void verifyTermsOfUsePrivacyPolicyAndContactLinksAreDisplyingByClickingOnContactLink() throws Exception {
		ContactTradusProPage contactPage= new ContactTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, contactPage.ContactLink);
		jsClick(driver, contactPage.ContactLink);
		explicitWaitFortheElementTobeVisible(driver, contactPage.TermsOfUseLinkOnSideBar);
		Assert.assertTrue(verifyElementPresent(contactPage.TermsOfUseLinkOnSideBar), 
				"Terms of use link is not displaying after clicking on contact link");
		Assert.assertTrue(verifyElementPresent(contactPage.PrivacyPolicyLinkOnSideBar), 
				"Privacy policy link is not displaying after clicking on contact link");
		Assert.assertTrue(verifyElementPresent(contactPage.ContactLinkOnSideBar), 
				"Contact link is not displaying on sidebar after clicking on contact link");
	}
	/*
	 * Description: Verify redirecting to respective site zendesk pages on clicking them
	 */
	@Test(priority=2)
	public void verifyRedirectingToRespectiveSiteZenkdeskPagesByClickingOnTheLinks() throws Exception {
		ContactTradusProPage contactPage= new ContactTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, contactPage.ContactLink);
		jsClick(driver, contactPage.TermsOfUseLinkOnSideBar);
		String parentWindow = driver.getWindowHandle();
		switchWindow(driver, parentWindow);
		explicitWaitFortheElementTobeVisible(driver, contactPage.TermsOfUseHelpPageHeading);
		Assert.assertTrue(verifyElementPresent(contactPage.TermsOfUseHelpPageHeading), 
				"Page not navigated to Terms of use page upon clicking on terms of use link");
		loadUrl(driver, "https://pro.tradus.com/lms");
		explicitWaitFortheElementTobeVisible(driver, contactPage.ContactLink);
		jsClick(driver, contactPage.ContactLink);
		explicitWaitFortheElementTobeVisible(driver, contactPage.PrivacyPolicyLinkOnSideBar);
		jsClick(driver, contactPage.PrivacyPolicyLinkOnSideBar);
		String childWindow= driver.getWindowHandle();
		switchWindow(driver, childWindow);
		explicitWaitFortheElementTobeVisible(driver, contactPage.PrivacyPolicyHelpPageHeading);
		Assert.assertTrue(verifyElementPresent(contactPage.PrivacyPolicyHelpPageHeading), 
				"Page not navigated to Privacy policy page upon clicking on terms of use link");
		loadUrl(driver, "https://pro.tradus.com/lms");
		explicitWaitFortheElementTobeVisible(driver, contactPage.ContactLink);
		jsClick(driver, contactPage.ContactLink);
		explicitWaitFortheElementTobeVisible(driver, contactPage.ContactLinkOnSideBar);
		jsClick(driver, contactPage.ContactLinkOnSideBar);
		String nextChildWindow= driver.getWindowHandle();
		switchWindow(driver, nextChildWindow);
		explicitWaitFortheElementTobeVisible(driver, contactPage.contactHelpPageHeading);
		Assert.assertTrue(verifyElementPresent(contactPage.contactHelpPageHeading), 
				"Page not navigated to contact help page upon clicking on terms of use link");
	}
}
