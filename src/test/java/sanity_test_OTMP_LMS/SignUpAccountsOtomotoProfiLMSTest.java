package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.username;

import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.SignUpAccountsOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpPackageOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

public class SignUpAccountsOtomotoProfiLMSTest extends BaseClass{
	
  /*
   * Description: Verify the second step 'Account' is highlighted 
   */
	@Test
	public void verifytheSecondStepisHighlighted() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		waitTill(3000);
		Assert.assertTrue((accountPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 113, 206, 1)"),"Account section is not highlighted");
		Assert.assertTrue(getText(pkjPgObj.tabName).trim().equals("Account"),"2nd tab name in sign up page is not Account");

	}
	
	/*
	 * Description: Verify Monthly cost info is displaying in the right side
	 */
	@Test
	public void verifyMonthlyCostinfoisDisplayinginRightSide() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		Assert.assertTrue(verifyElementPresent(accountPgObj.monthlyCostSection), "Monthly cost section isn't present in Accounts page");
	}
	
	/*
	 * Description:Verify the 'price inc/exc.vat' text is displaying 
	 */
	@Test
	public void verifyPriceexcludingVATtextinMonthlyCost() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		waitTill(2000);
		Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).replace("\n", ",").trim().contains("Excluding VAT"),"Excluding VAT text is not displaying in price section for Business user");
	}
	
	/*
	 * Description: Verify redirecting to first step on clicking 'Change package' link and Verify by changing the package 
	 */
	@Test
	public void changePackageFunctionlity() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		Assert.assertTrue(getText(accountPgObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("5 listings"), "number of listing in monthly package is incorrect for 5 listing of smart package");
		click(accountPgObj.changePackageUnderMonthlyCost);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninSmartPackage);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.packagePageVerificationElement), "Package page isn't displaying upon clicking chnage package in Accounts page");
		Select s=new Select(pkjPgObj.ListingDropdowninSmartPackage);
		s.selectByValue("111");
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		Assert.assertTrue(getText(accountPgObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("130 listings"), "number of listing in monthly package is incorrect for 5 listing of smart package");
		click(accountPgObj.changePackageUnderMonthlyCost);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninStarterPackage);
		click(pkjPgObj.starterPackage);
		waitTill(1000);
		Select s1=new Select(pkjPgObj.ListingDropdowninStarterPackage);
		s1.selectByValue("227");
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		Assert.assertTrue(getText(accountPgObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("10 listings"), "number of listing in monthly package is incorrect for 5 listing of smart package");
		click(accountPgObj.changePackageUnderMonthlyCost);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninPlusPackage);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.packagePageVerificationElement), "Package page isn't displaying upon clicking chnage package in Accounts page");
		Select s2=new Select(pkjPgObj.ListingDropdowninPlusPackage);
		s2.selectByValue("240");
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.monthlyCostSection);
		Assert.assertTrue(getText(accountPgObj.numberOfAdsperPackageUnderMonthlyCost).trim().equals("1000 listings"), "number of listing in monthly package is incorrect for 1000 listing of Plus package");
	}
	
	/*
	 * Description: Verify 'Monthly' billing frequency text is displaying 
	 */
	@Test
	public void verifyBillingFrequencyasMonthly() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		waitTill(2000);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.billingFrequencyUnderMonthlyCost);
		Assert.assertTrue(getText(accountPgObj.billingFrequencyUnderMonthlyCost).trim().equals("Monthly"), "Billing frequency isn't displaying as monthly for smart package");
		click(accountPgObj.changePackageUnderMonthlyCost);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninStarterPackage);
		click(pkjPgObj.starterPackage);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.nextButton);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.billingFrequencyUnderMonthlyCost);
		Assert.assertTrue(getText(accountPgObj.billingFrequencyUnderMonthlyCost).trim().equals("Monthly"), "Billing frequency isn't displaying as monthly for starter package");
		
	}
	
	/*
	 * Description: Verify Email and password fields are displaying 
	 */
	@Test
	public void verifyEmailandPasswordfieldsareDisplaying() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		String userTypes[]= {"Starter","Smart","Plus"};
		for(int i=0;i<userTypes.length;i++) {
		pkjPgObj.gotoAccountsPage(driver, userTypes[i]);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(accountPgObj.emailField), "Email field isn't present in accounts page for "+userTypes[i]+" package");
		Assert.assertTrue(verifyElementPresent(accountPgObj.passWordField), "Password field isn't present in accounts pagefor "+userTypes[i]+" package");
		}
	}
	
	/*
	 *  Description: Verify 'Go to sign in page' link on giving already registered email in email field
	 *  Account used: harish.boyapati+0651@olx.com
	 */
	@Test
	public void verifyGotoSigninLinkongivingalreadyRegisterdAccount() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		pkjPgObj.gotoAccountsPage(driver, "Smart");
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
		sendKeys(accountPgObj.emailField,"harish.boyapati+0651@olx.com");
		sendKeys(accountPgObj.passWordField, pwd);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailFieldDangerText);
		Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).replace("\n", ",").equals("An account with this email already exists.,Go here to sign in"),
				" Error alert with an account already exits and sign link are not present ");
		click(accountPgObj.goToSignInPageErrorLinkOnEnteringRegisteredEmail);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.loginPageVerifcationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.loginPageVerifcationElement), "Login page isn't displaying on clicking goToSignInPage link for already registed account ");
		
	}
	
	/*
	 * Description: Verify error message on trying to give password less than 8 characters
	 */
	@Test
	public void verifyErrormsgonenteringPWDlessthan8Charactors() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		pkjPgObj.gotoAccountsPage(driver, "Smart");
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
		sendKeys(accountPgObj.emailField, username);
		sendKeys(accountPgObj.passWordField, "Invalid");
		waitTill(1000);
		Assert.assertTrue(getText(accountPgObj.passWordFieldDangerText).equals("The password field must be at least 8 characters"),
				" Error alert with an account already exits and sign link are not present ");
		sendKeys(accountPgObj.passWordField, "Invalid123");
		waitTill(1000);
		Assert.assertTrue(getText(accountPgObj.passWordFieldDangerText).isEmpty(),
				" Error alert with an account already exits and sign link are not present ");
		
	}
	
	/*
	 * Description: Verify acceptance checkbox
	 */
	@Test
	public void verifyAcceptanceCheckbox() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		String userTypes[]= {"Starter","Smart"};
		for(int i=0;i<userTypes.length;i++) {
			pkjPgObj.gotoAccountsPage(driver, userTypes[i]);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.acceptacneCheckBoxSection);
	        Assert.assertTrue(verifyElementPresent(accountPgObj.acceptacneCheckBoxSection), "Acceptance checkbox isn't present in accounts page for "+userTypes[i]+" package");
			waitTill(1000);
			click(accountPgObj.nextButton);
			waitTill(1000);
			Assert.assertTrue(getText(accountPgObj.agreeCheckBoxError).trim().equals("The Terms of Use field is required"), "Error message is not displaying when acceptance checkbox isn't checked");
			click(accountPgObj.agreeCheckBox);
			waitTill(1000);
			click(accountPgObj.nextButton);
			waitTill(1000);
			Assert.assertTrue(getText(accountPgObj.agreeCheckBoxError).isEmpty(), "Error message is still displaying when acceptance checkbox isn't checked");
		}
	}
	
	/*
	 * Description: Verify 'Terms of use', 'Privacy' and 'Cookes' links are redirecting to otomotoprofi.pl 
	 */
	@Test
	public void verifyTermsofUsePrivacyAndCookieslinksandNavigation() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		pkjPgObj.gotoAccountsPage(driver, "Smart");
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.acceptacneCheckBoxSection);
		Assert.assertTrue(verifyElementPresent(accountPgObj.termsOfUseLink), "Terms of use link isn't present in accounts page");
		Assert.assertTrue(verifyElementPresent(accountPgObj.privacyLink), "Privacy link isn't present in accounts page");
		Assert.assertTrue(verifyElementPresent(accountPgObj.coockiesLink), "Cookies link isn't present in accounts page");
		String parentWindow=driver.getWindowHandle();
		click(accountPgObj.termsOfUseLink);
		Set<String> windows=driver.getWindowHandles();
		Assert.assertTrue(windows.size()>1, "Terms of use link is not opened in new tab");
		waitTill(1000);
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(accountPgObj.termsPageVerify),
				"Terms of use link is not redirected to expected page");
		driver.close();
		driver.switchTo().window(parentWindow);
		click(accountPgObj.privacyLink);
		windows=driver.getWindowHandles();
		Assert.assertTrue(windows.size()>1, "Privacy link is not opened in new tab");
		waitTill(1000);
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(accountPgObj.privacyPageVerify),
				"Privacy is not redirected to expected page");
		driver.close();
		driver.switchTo().window(parentWindow);
		click(accountPgObj.coockiesLink);
		windows=driver.getWindowHandles();
		Assert.assertTrue(windows.size()>1, "Cookies link is not opened in new tab");
		waitTill(1000);
		switchWindow(driver, parentWindow);
		Assert.assertTrue(verifyElementPresent(accountPgObj.cookiesPageVerify),
				"Cookies is not redirected to expected page");
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	/*
	 * Description: Verify error message on trying to go to next page with invalid/fuzzy data in Email and password fields
	 */
	@Test
	public void verifyErrormessageOnTryingtoGotoNextPagewithwrongDatainEmailandPwdField() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		pkjPgObj.gotoAccountsPage(driver, "Plus");
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
		sendKeys(accountPgObj.emailField,"invalid");
		sendKeys(accountPgObj.passWordField,"  ");
		click(accountPgObj.agreeCheckBox);
		waitTill(1000);
		click(accountPgObj.nextButton);
		waitTill(2000);
		Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).trim().equals("The email field must be a valid email"), "Proper error message isn't displaying for invalid email field");
		Assert.assertTrue(getText(accountPgObj.passWordFieldDangerText).trim().equals("The password field is required"), "Proper error message isn't displaying for invalid email field");
	}
	
	/*
	 * Description: Verify able to go back to first step on clicking back link
	 */
	@Test
	public void verifyAbletogobacktoFirststeponclickingBackLink() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		String userTypes[]= {"Starter","Smart","Plus"};
		for(int i=0;i<userTypes.length;i++) {
			waitTill(1000);
			pkjPgObj.gotoAccountsPage(driver, userTypes[i]);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.backButton);
			click(accountPgObj.backButton);
			explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
			Assert.assertTrue(verifyElementPresent(pkjPgObj.packagePageVerificationElement), "Package page is not displaying on clicking back link from acounts page");
		}
		
	}
	
	/*
	 * Description: Verify details page is displaying on trying with valid credentials
	 */
	@Test
	public void verifyAbletogoDetailspageonClickingnextButton() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		waitTill(1000);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj = new SignUpAccountsOtomotoProfiLMSPage(driver);
		String userTypes[]= {"Starter","Smart","Plus"};
		for(int i=0;i<userTypes.length;i++) {
			waitTill(1000);
			pkjPgObj.gotoAccountsPage(driver, userTypes[i]);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.emailField);
			sendKeys(accountPgObj.emailField,username);
			sendKeys(accountPgObj.passWordField,pwd);
			click(accountPgObj.agreeCheckBox);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.nextButton);
			click(accountPgObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.detailsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.detailsPageVerificationElement), "Details page is not displaying on clicking next link from acounts page");
		}
	}
}
