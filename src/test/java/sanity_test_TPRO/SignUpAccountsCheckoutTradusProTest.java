package sanity_test_TPRO;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsCheckoutTradusProPage;
import com.tradus.pro.pages.SignUpPackageSectionTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tradus.core.GlobalConstants.pwd;

import java.util.List;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.getCurrentUrl;


public class SignUpAccountsCheckoutTradusProTest extends BaseClass{
	/*
	 * Description: Verify Site name (Tradus PRO) is displaying at the top
	 */
	@Test
	public void verifySiteLogoInCheckOutPage() throws Exception {
		
		String[] userNames= {"harish.boyapati+1131@olx.com","harish.boyapati+1132@olx.com","harish.boyapati+1133@olx.com"};
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj=new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj= new SignUpAccountsCheckoutTradusProPage(driver);
		for (int i = 0; i <=2; i++) {
			explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
			sendKeys(signUpObj.emailField, userNames[i]);
			sendKeys(signUpObj.passWordField, pwd);
			jsClick(driver, signUpObj.agreeCheckBox);
			waitTill(2000);
			jsClick(driver, signUpObj.nextButton);
			waitForElement(signUpObj.detailsCountryText);
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			waitTill(2000);
			sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
			sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
			waitTill(1000);
			jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
			waitTill(1000);
			jsClick(driver, signUpObj.detailsNextbutton);
			waitTill(2000);
			List<WebElement> companyPackagesRadiobtn = signUpPkgObj.companyPackageRadioButtons;
			jsClick(driver, companyPackagesRadiobtn.get(i));
			waitTill(2000);
			click(signUpPkgObj.nextButton);
			waitTill(2000);
			jsClick(driver, signUpObj.createAnAccount);
			waitTill(2000);
			driver.manage().window().maximize();
			explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPageElement);
			Assert.assertTrue(verifyElementPresent(CheckoutObj.TRProLogo),
					"TRPro logo is not displaying in account check out page");
			loadUrl(driver, "https://pro.tradus.com/signup");
		}
		//for private
		explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
		jsClick(driver,signUpObj.privateRadioButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
		sendKeys(signUpObj.emailField,"harish.boyapati+1134@olx.com");
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(1000);
		jsClick(driver, signUpObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPhoneTextField);
		sendKeys(signUpObj.detailsPrivateFullNameTextField,"Harish");
		sendKeys(signUpObj.detailsCityTextField,"AMSTERDAM");
		sendKeys(signUpObj.detailsCompanyAddressTextField,"WIBAUTSTRAAT 00137 C");
		sendKeys(signUpObj.detailsCompanyZIPTextField,"1097DN");
		sendKeys(signUpObj.detailsPhoneTextField,"777888999");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		waitTill(2000);
		driver.manage().window().maximize();
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPageElement);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.TRProLogo), 
				"TRPro logo is not displaying in account check out page for private user");
	}
	
	/*
	 * Verify package name along with total amount(Including VAT) displaying in the pop up
	 * and error message while submitting credit card popup with invalid value
	 */
	
	@Test
	public void verifyPackageNameandPriceAmountandErrormsgwhilesubmitingCreditCardwithinvalidInfo() throws Exception
	{
		String[] userNames = { "harish.boyapati+1135@olx.com", "harish.boyapati+1136@olx.com",
				"harish.boyapati+1137@olx.com", };
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		Actions a = new Actions(driver);
		for (int i = 0; i <=2; i++) {
			explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
			sendKeys(signUpObj.emailField, userNames[i]);
			sendKeys(signUpObj.passWordField, pwd);
			jsClick(driver, signUpObj.agreeCheckBox);
			waitTill(2000);
			jsClick(driver, signUpObj.nextButton);
			waitForElement(signUpObj.detailsCountryText);
			sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
			waitTill(2000);
			sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
			sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
			sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
			sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
			waitTill(1000);
			jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
			waitTill(1000);
			jsClick(driver, signUpObj.detailsNextbutton);
			waitTill(2000);
			List<WebElement> companyPackagesRadiobtn = signUpPkgObj.companyPackageRadioButtons;
			jsClick(driver, companyPackagesRadiobtn.get(i));
			waitTill(2000);
			click(signUpPkgObj.nextButton);
			waitTill(2000);
			jsClick(driver, signUpObj.createAnAccount);
			waitTill(4000);
			driver.manage().window().maximize();
			explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutCreditCardLink);
			waitTill(2000);
			jsClick(driver, CheckoutObj.CheckoutCreditCardLink);
			waitTill(2000);
			explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPackageCreditCardPaymentButton);
			waitTill(2000);
			WebElement element = driver.findElement(By.xpath("//input[@class='__PrivateStripeElement-input']"));
			waitTill(2000);
			switch (i) {

			case 0:
				Assert.assertEquals(getText(CheckoutObj.CheckoutPackageInfoinPaymentPopup).trim(),
						"Tradus Basic 10 - 60.50 EUR",
						"Tradus Basic 10 package info is not visible in credit card pop-up");
				a.moveToElement(element).click().sendKeys("8795641235684123").sendKeys(Keys.TAB).sendKeys("0825")
						.sendKeys("754").build().perform();
				waitTill(2000);
				jsClick(driver, CheckoutObj.CheckoutPackageCreditCardPaymentButton);
				waitTill(3000);
				Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPackageCreditCardSumbitDangerText),
						"Credit card details error message is not displaying");
				break;

			case 1:
				Assert.assertEquals(getText(CheckoutObj.CheckoutPackageInfoinPaymentPopup).trim(),
						"Tradus Basic 25 - 121.00 EUR",
						"Tradus Basic 25 package info is not visible in credit card pop-up");
				a.moveToElement(element).click().sendKeys("8795623235684123").sendKeys(Keys.TAB).sendKeys("0924")
						.sendKeys("654").build().perform();
				waitTill(2000);
				jsClick(driver, CheckoutObj.CheckoutPackageCreditCardPaymentButton);
				waitTill(3000);
				Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPackageCreditCardSumbitDangerText),
						"Credit card details error message is not displaying");
				break;

			case 2:
				Assert.assertEquals(getText(CheckoutObj.CheckoutPackageInfoinPaymentPopup).trim(),
						"Tradus Basic 70 - 302.50 EUR",
						"Tradus Basic 70 package info is not visible in credit card pop-up");
				a.moveToElement(element).click().sendKeys("8795623235684223").sendKeys(Keys.TAB).sendKeys("0223")
						.sendKeys("619").build().perform();
				waitTill(2000);
				jsClick(driver, CheckoutObj.CheckoutPackageCreditCardPaymentButton);
				waitTill(3000);
				Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPackageCreditCardSumbitDangerText),
						"Credit card details error message is not displaying");
				break;

			}
			loadUrl(driver, "https://pro.tradus.com/signup");
		}

		// for private
		explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
		jsClick(driver, signUpObj.privateRadioButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.passWordField);
		sendKeys(signUpObj.emailField, "harish.boyapati+1138@olx.com");
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(1000);
		jsClick(driver, signUpObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsPhoneTextField);
		sendKeys(signUpObj.detailsPrivateFullNameTextField, "Harish");
		sendKeys(signUpObj.detailsCityTextField, "AMSTERDAM");
		sendKeys(signUpObj.detailsCompanyAddressTextField, "WIBAUTSTRAAT 00137 C");
		sendKeys(signUpObj.detailsCompanyZIPTextField, "1097DN");
		sendKeys(signUpObj.detailsPhoneTextField, "777888999");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutCreditCardLink);
		jsClick(driver, CheckoutObj.CheckoutCreditCardLink);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPackageCreditCardPaymentButton);
		waitTill(2000);
		WebElement element = driver.findElement(By.xpath("//input[@class='__PrivateStripeElement-input']"));
		waitTill(2000);
		Assert.assertEquals(getText(CheckoutObj.CheckoutPackageInfoinPaymentPopup).trim(), "Tradus Single 1 - 9.68 EUR",
				"Tradus single 1 package info is not visible in credit card pop-up");
		a.moveToElement(element).click().sendKeys("8795623235656923").sendKeys(Keys.TAB).sendKeys("1123")
				.sendKeys("909").build().perform();
		waitTill(2000);
		jsClick(driver, CheckoutObj.CheckoutPackageCreditCardPaymentButton);
		waitTill(3000);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPackageCreditCardSumbitDangerText),
				"Credit card details error message is not displaying");
	}
	/*
	 * Description :
	 * 
	 * Verify 'You're almost ready' text along with paypal link is displaying Verify
	 * billing page is displaying on clicking paypal link Verify 'Credit card'
	 * option is displaying Verify pop up is displaying on clicking 'Credit card'
	 * button
	 */
	@Test
	public void VerifyPaypalLinkAlongWithYouareAlmostReadyTextIsDisplaying() throws Exception {
		String email = "harish.boyapati+1139@gmail.com";
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		sendKeys(signUpObj.emailField, email);
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		waitTill(2000);
		sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPagePayPalLink);
		String currentURL = getCurrentUrl(driver);
		Assert.assertTrue(CheckoutObj.CheckoutPageElement.getText().contains("You're almost ready!"),
				" You're almost ready! text message is not displaying in the Account checkout page");
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPagePayPalLink),
				"Paypal link is not displayed in the Account checkout page");
		jsClick(driver, CheckoutObj.CheckoutPagePayPalLink);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.paypalPaymentPageText);
		Assert.assertTrue(CheckoutObj.paypalPaymentPageText.getText().equals("Pay with PayPal"),
				"Not navigated to the Paypal payment page");
		loadUrl(driver, currentURL);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPageElement);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutCreditCardLink),
				"Credit card option is not displayed in Account checkout page");
		jsClick(driver, CheckoutObj.CheckoutCreditCardLink);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.cardHolderNameField);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.cardHolderNameField),
				"pop up is not displayed on clicking 'Credit card' button");
	}
	
	/*
	 * Description : Verify Paypal Button is diaplaying or not
	 */

	@Test
	public void verifyPaypalButtonIsDisplayingOrNot() throws Exception {
		String email = "harish.boyapati+1140@gmail.com";
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		sendKeys(signUpObj.emailField, email);
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		waitTill(2000);
		sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPagePayPalLink);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPagePayPalLink),
				"Paypal link is not displayed in the Account checkout page");
	}

	/*
	 * Description : Verify Paypal login page is diaplaying or not
	 */
	
	@Test
	public void verifyPaypalLoginPageIsDisplayingOrNot() throws Exception {
		String email = "harish.boyapati+1141@gmail.com";
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		sendKeys(signUpObj.emailField, email);
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		waitTill(2000);
		sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPagePayPalLink);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPagePayPalLink),
				"Paypal link is not displayed in the Account checkout page");
		jsClick(driver, CheckoutObj.CheckoutPagePayPalLink);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.paypalPaymentPageText);
		Assert.assertTrue(CheckoutObj.paypalPaymentPageText.getText().equals("Pay with PayPal"),
				"Not navigated to the Paypal payment page");
	}

	/*
	 * Description : Verify Paypal Payment cancel Button is diaplaying or not
	 */
	
	@Test
	public void verifyCancelAndReturnToTradusIsDisplayingOrNot() throws Exception {
		String email = "harish.boyapati+1142@gmail.com";
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		sendKeys(signUpObj.emailField, email);
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		waitTill(2000);
		sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPagePayPalLink);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPagePayPalLink),
				"Paypal link is not displayed in the Account checkout page");
		jsClick(driver, CheckoutObj.CheckoutPagePayPalLink);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.paypalPaymentPageText);
		Assert.assertTrue(CheckoutObj.paypalPaymentCancel.getText().equals("Cancel and return to Tradus PRO"),
				"cancel and return to Tradus PRO is not displaying");
	}
	
	/*
	 * Description : verify On Clicking Cancel And Return To Tradus Is Navigating To Login Page
	 */

	@Test
	public void verifyOnClickingCancelAndReturnToTradusIsNavigatingToLoginPage() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		String email= "harish.boyapati+1143@olx.com";
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignUpAccountsCheckoutTradusProPage CheckoutObj = new SignUpAccountsCheckoutTradusProPage(driver);
		sendKeys(signUpObj.emailField, email);
		sendKeys(signUpObj.passWordField, pwd);
		jsClick(driver, signUpObj.agreeCheckBox);
		waitTill(2000);
		jsClick(driver, signUpObj.nextButton);
		waitForElement(signUpObj.detailsCountryText);
		sendKeys(signUpObj.detailsVATNoTextField, "NL854502130B01");
		waitTill(2000);
		sendKeys(signUpObj.detailsContactPersonTextField, "Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField, "777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField, "612345678");
		waitTill(1000);
		jsClick(driver, signUpObj.detailsAvailableOnWhatsAppCheckbox);
		waitTill(1000);
		jsClick(driver, signUpObj.detailsNextbutton);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.nextButton);
		click(signUpPkgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.createAnAccount);
		jsClick(driver, signUpObj.createAnAccount);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.CheckoutPagePayPalLink);
		Assert.assertTrue(verifyElementPresent(CheckoutObj.CheckoutPagePayPalLink),
				"Paypal link is not displayed in the Account checkout page");
		jsClick(driver, CheckoutObj.CheckoutPagePayPalLink);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.paypalPaymentPageText);
		Assert.assertTrue(CheckoutObj.paypalPaymentCancel.getText().equals("Cancel and return to Tradus PRO"),
				"cancel and return to Tradus PRO is not displaying");
		jsClick(driver, CheckoutObj.paypalPaymentCancel);
		explicitWaitFortheElementTobeVisible(driver,CheckoutObj.errorMessageOncancelPaypalPayment);
		Assert.assertTrue(
				CheckoutObj.errorMessageOncancelPaypalPayment.getText().trim().equals("Payment was unsuccessfull"),
				"Payment was unsuccessfull error message is not displaying");
	}
	

}
