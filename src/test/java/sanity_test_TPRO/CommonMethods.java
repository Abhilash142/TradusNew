package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.switchWindow;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;



public class CommonMethods {

	/*
	 * Description: Verify page is redirecting to TPRO landing page on clicking TPRO icon in header
	 */
	
	public void verifyRedirectionofTPROLandingPageonClickingTPROIconinHeader(RemoteWebDriver driver) throws Exception {
		SignUpAccountsTPROPage_New signUpObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.TRProLogo);
		jsClick(driver,signUpObj.TRProLogo);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.landingPageVerificationElement);
		waitTill(1000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/"), 
				"Upon clicking TPRO Logo user is not navigating to Landing page");
	}
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	
	
	public void verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(RemoteWebDriver driver) throws Exception {
		SignUpAccountsTPROPage_New signUpObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.languageDropdown);
		jsClick(driver,signUpObj.languageDropdown);
		waitTill(1000);
		String[] expectedLangOptions= {"Deutsch","English","Español","Français","Italiano","Nederlands","Polski","Português","Română","Русский"};
		List<WebElement> availableLangOptions=signUpObj.languageDropdownOptionsList;
		for(int i=0;i<expectedLangOptions.length;i++) {
			Assert.assertTrue(expectedLangOptions[i].equals(availableLangOptions.get(i).getText().trim()),
					expectedLangOptions[i]+" is not present in lang dropdown");
		}
	}
	
	/*
	 * Description: Validate supportsilder's presence and functionalities
	 */
	
	public void validateSupportSlider(RemoteWebDriver driver) throws Exception {
		SignUpAccountsTPROPage_New signUpObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.getSupportButton);
		jsClick(driver,signUpObj.getSupportButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.supportSectionVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpObj.supportSectionVerificationElement), "Support slider didn't open upon clicking GetSupport button");	
		waitTill(1000);
		Assert.assertTrue(getText(signUpObj.contactSectioninSupportSlider).replace("\n", ", ").trim().
				equals("You can call us at:, +49 30 2555 5338, +31 23 799 6576, +40 31 630 2046, We are available Monday through Friday 09:00 - 17:00 Central European Time., We support the following languages on the phone: English, German, Dutch, French, Italian, Romanian, and Russian., If you would like to contact us during the weekend or outside of working hours, you can leave us a voicemail and one of our team members will get back to you."),
				"Text present in Contact section of support slider has changed");
		Assert.assertTrue(getText(signUpObj.emailSectioninSupportSlider).replace("\n", ", ").trim().equals("You can email us at support@tradus.com., We support all languages via email."),
				"Text present in Email section of support slider has changed");
		Assert.assertTrue(getText(signUpObj.chatSectioninSupportSlider).replace("\n", ", ").trim().equals("Click here to chat with us."),
				"Text present in Chat section of support slider has changed");
		String parentWindow=driver.getWindowHandle();
		jsClick(driver,signUpObj.chatLinkinSupportSlider);
		switchWindow(driver, parentWindow);
		try {
			explicitWaitFortheElementTobeVisible(driver,signUpObj.chatPageVerificationElement);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(signUpObj.chatPageVerificationElement),"Help page isn't displaying on clicking chat link from support slider");
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		jsClick(driver,signUpObj.supportSectionCloseButton);
		waitTill(2000);
		Assert.assertFalse(verifyElementPresent(signUpObj.supportSectionVerificationElement),"Support slider is not closed");
		
	}
	
	/*
	 * Description:Verify 'Intelligent tools & data', 'Heavy machinery only' and 'Easy international trade' info is displaying under 'The benefits of selling on Tradus PRO Staging' text in left side of the page
	 */
	
	public void verifyBenifitSectionandCorrespondingText(RemoteWebDriver driver) throws Exception
	{
		SignUpAccountsTPROPage_New signUpObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.benifitsSection);
		Assert.assertTrue(verifyElementPresent(signUpObj.benifitsSection), "Benifits section is not present in the left side of the page");
		Assert.assertTrue((getText(signUpObj.benifitsSection).replace("\n", ", ").trim()).
				equals("The benefits of selling on Tradus PRO, Intelligent tools & data, Sell smarter thanks to real-time insights into the used heavy machinery market, Heavy machinery only, Connect with serious heavy machinery buyers on a platform specifically designed for heavy machinery trading, Easy international trade, Reach buyers internationally and communicate seamlessly in their language with smart translations")
						, "Text present in benifits section has changed");
		
	}
	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	public void verifySignInLinkandItsNavigation(RemoteWebDriver driver) throws Exception {
		SignUpAccountsTPROPage_New signUpObj=new SignUpAccountsTPROPage_New(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.loginLink);
		jsClick(driver,signUpObj.loginLink);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.loginPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(signUpObj.loginPageVerificationElement), "User is not navigated to Login page on clisking sigh in link");
	}
}
