package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;

import java.util.Set;

import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.getCurrentUrl;

import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userName;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;
import com.tradus.pro.pages.SignupTPROPage;

public class SignUpAccountsTProTest_New extends BaseClass {

	/*
	 * Description: Verify page is redirecting to TPRO landing page on clicking TPRO
	 * icon in header
	 */
	/*
	 * @Test public void verifyPageisRedirectingToLandingPageTPro() throws Exception
	 * { SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * waitTill(1000); pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * accountsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods();
	 * cm.verifyRedirectionofTPROLandingPageonClickingTPROIconinHeader(driver); }
	 * 
	 * 
	 * Description: Verify language drop down is displaying and 10 language options
	 * are displaying on clicking the drop down in header
	 * 
	 * @Test public void verifyLanguageDropdownandAllOptions() throws Exception{
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * waitTill(1000); pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * accountsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods();
	 * cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver)
	 * ; }
	 * 
	 * 
	 * Description: Validate supportsilder's presence and functionalities
	 * 
	 * @Test public void validateSupportSlider() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * waitTill(1000); pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * accountsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.validateSupportSlider(driver); }
	 * 
	 * 
	 * Description:Verify 'Intelligent tools & data', 'Heavy machinery only' and
	 * 'Easy international trade' info is displaying under 'The benefits of selling
	 * on Tradus PRO Staging' text in left side of the page
	 * 
	 * @Test public void verifyBenifitsSection() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * waitTill(1000); pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * accountsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.verifyBenifitSectionandCorrespondingText(driver); }
	 * 
	 * 
	 * Description: Verify Sign in link and its Navigation
	 * 
	 * 
	 * @Test public void verifySignInLinkandItsNavigation() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * waitTill(1000); pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * accountsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.verifySignInLinkandItsNavigation(driver); }
	 * 
	 * 
	 * Description:Verify the second step 'Account' is highlighted
	 * 
	 * @Test public void verifytheSecondStepisHighlighted() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); pkjPgObj.gotoAccountsPage(driver,
	 * "business"); explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(getText(pkjPgObj.tabName).trim().equals("Account"),
	 * "Accounts tab is not displaying");
	 * Assert.assertTrue((pkjPgObj.tabInfo).getCssValue("background-color").
	 * equals("rgba(0, 171, 189, 1)"),"Package section is not highlighted"); }
	 * 
	 * 
	 * Description: Verify Monthly cost info is displaying in the right side
	 * 
	 * @Test public void verifyMonthlyCostinfoisDisplayinginRightSide() throws
	 * Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.monthlyCostSection),
	 * "Monthly costs section is not displaying in Accounts page");
	 * 
	 * }
	 * 
	 * 
	 * Description:Verify the 'price inc/exc.vat' text is displaying
	 * 
	 * @Test public void verifyPriceexcludingVATtextinMonthlyCost() throws Exception
	 * { SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); pkjPgObj.gotoAccountsPage(driver,
	 * "business"); explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).replace("\n",
	 * ",").trim().contains("Excluding VAT"
	 * ),"Excluding VAT text is not displaying in price section for Business user");
	 * pkjPgObj.gotoAccountsPage(driver, "indivisual");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).replace("\n",
	 * ",").trim().contains("Excluding VAT"
	 * ),"Excluding VAT text is not displaying in price section for Business user");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify redirecting to first step on clicking 'Change package'
	 * link and Verify by changing the package
	 * 
	 * @Test public void changePackageFunctionlity() throws Exception {
	 * SignUpPackageTPROPage_New signUpPackageObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * signUpAccountObj= new SignUpAccountsTPROPage_New(driver);
	 * explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.
	 * packagePageVerificationElement); waitTill(1000); for(int
	 * i=0;i<signUpPackageObj.packageTiles.size()-1;i++) {
	 * click(signUpPackageObj.packageTiles.get(i)); waitTill(1000);
	 * jsClick(driver,signUpPackageObj.nextButton);
	 * explicitWaitFortheElementTobeVisible(driver,signUpAccountObj.
	 * accountsPageVerificationElement); waitTill(1000); switch (i) {
	 * 
	 * case 0:{
	 * Assert.assertTrue(getText(signUpAccountObj.priceUnderMonthlyCost).replace(
	 * "\n",",").trim().equals("€10.00,Excluding VAT"
	 * ),"Selected basic package is not displaying in Accounts page"); break; } case
	 * 1:{
	 * Assert.assertTrue(getText(signUpAccountObj.priceUnderMonthlyCost).replace(
	 * "\n",",").trim().equals("€13.00,Excluding VAT"
	 * ),"Selected premium package is not displaying in Accounts page"); break; } }
	 * click(signUpAccountObj.changePackageUnderMonthlyCost);
	 * explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.
	 * tradusBasicPackage); Assert.assertTrue(verifyElementPresent(signUpPackageObj.
	 * packagePageVerificationElement),
	 * "Package page is not displaying after clicking change package if "
	 * +i+" package is selected"); } signUpPackageObj.gotoAccountsPage(driver,
	 * "indivisual"); explicitWaitFortheElementTobeVisible(driver,signUpAccountObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * click(signUpAccountObj.changePackageUnderMonthlyCost);
	 * explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.
	 * indivisualPackageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(signUpPackageObj.
	 * packagePageVerificationElement),
	 * "Package page is not displaying after clicking change package if for indivisual user"
	 * );
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify 'Monthly' billing frequency text is displaying
	 * 
	 * @Test public void verifybillingFrequencyasMonthly() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); pkjPgObj.gotoAccountsPage(driver,
	 * "business"); explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(getText(accountPgObj.billingFrequencyUnderMonthlyCost).trim
	 * ().equals("Monthly"),
	 * "billing frequency under Monthly costs is not present for Business user");
	 * pkjPgObj.gotoAccountsPage(driver, "indivisual");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(getText(accountPgObj.billingFrequencyUnderMonthlyCost).trim
	 * ().equals("Monthly"),
	 * "billing frequency under Monthly costs is not present for Indivisual user");
	 * }
	 * 
	 * 
	 * Description: Verify Email and password fields are displaying
	 * 
	 * @Test public void verifyEmailandPasswordFields() throws Exception{
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); pkjPgObj.gotoAccountsPage(driver,
	 * "business"); explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.emailField),
	 * "Email field is not present in Account page");
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.passWordField),
	 * "Passwoard field is not present in Account page"); }
	 * 
	 * 
	 * Description: Verify 'Go to sign in page' link on giving already registered
	 * email in email field
	 * 
	 * @Test public void verifyGotoSigninPagelinkOnivingAlreadyRegisteredEmail()
	 * throws Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * 
	 * }
	 * 
	 * 
	 * Description : Verify error message for invalid email and password
	 * 
	 * @Test public void verifyErrormessageforInvalidEmailandPassword() throws
	 * Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver); String[] user=
	 * {"business","indivisual"}; for(int i=0;i<user.length;i++) {
	 * pkjPgObj.gotoAccountsPage(driver, user[i]);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.emailField);
	 * waitTill(2000); sendKeys(accountPgObj.emailField,"InvalidEmail");
	 * sendKeys(accountPgObj.passWordField,"invalid");
	 * jsClick(driver,accountPgObj.nextButton); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.emailFieldDangerText),
	 * "Email error message is not displaying"); String errorMessage =
	 * accountPgObj.emailFieldDangerText.getText();
	 * Assert.assertEquals(errorMessage, "The email field must be a valid email",
	 * "The email error message text is not correct");
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.passWordFieldDangerText),
	 * "Password error message is not displaying"); errorMessage =
	 * accountPgObj.passWordFieldDangerText.getText();
	 * Assert.assertEquals(errorMessage,
	 * "The password field must be at least 8 characters",
	 * "The password error message text is not correct"); } }
	 * 
	 * 
	 * Description: Verify presence Acceptance checkbox and error message if not
	 * selected
	 * 
	 * @Test public void verifyAcceptanceCheckboxAnditsFunctionality() throws
	 * Exception {
	 * 
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); String[] user= {"business","indivisual"};
	 * for(int i=0;i<user.length;i++) { pkjPgObj.gotoAccountsPage(driver, user[i]);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.acceptacneCheckBoxSection
	 * ), "Accepatacne checkbox section is not present for"+user[i]+" user");
	 * click(accountPgObj.nextButton); waitTill(1000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.agreeCheckBoxError),
	 * "Terms error message is not displaying for"+user[i]+" user"); String
	 * errorMessage = accountPgObj.agreeCheckBoxError.getText();
	 * Assert.assertEquals(errorMessage, "The Terms of Use field is required",
	 * "Terms error message text is not correct for"+user[i]+" user"); try {
	 * click(accountPgObj.agreeCheckBox); } catch(Exception e) {
	 * jsClick(driver,accountPgObj.agreeCheckBox); } waitTill(1000);
	 * jsClick(driver,accountPgObj.nextButton); waitTill(1000); errorMessage =
	 * accountPgObj.agreeCheckBoxError.getText();
	 * Assert.assertTrue(errorMessage.isEmpty(),
	 * "After clicking checkbox 'Terms error message is displaying for"+user[i]
	 * +" user"); } }
	 * 
	 * 
	 * Description: Verify 'Terms of use', 'Privacy' and 'Cookes' links are
	 * redirecting to Tradus Zendesk pages
	 * 
	 * @Test public void
	 * verifyTermsOfUsePrivacyCookiesLinksAreRedirectingToTradusZendeskPages()
	 * throws Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(1000); String
	 * parentWindow=driver.getWindowHandle(); click(accountPgObj.termsOfUseLink);
	 * Set<String> windows=driver.getWindowHandles();
	 * Assert.assertTrue(windows.size()>1,
	 * "Terms of use link is not opened in new tab"); switchWindow(driver,
	 * parentWindow);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.termsPageVerify),
	 * "Terms of use link is not redirected to Tradus Zendesk Page");
	 * driver.close(); driver.switchTo().window(parentWindow);
	 * click(accountPgObj.privacyLink); windows=driver.getWindowHandles();
	 * Assert.assertTrue(windows.size()>1, "Privacy link is not opened in new tab");
	 * switchWindow(driver, parentWindow);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.privacyPageVerify),
	 * "Privacy is not redirected to Tradus Zendesk Page"); driver.close();
	 * driver.switchTo().window(parentWindow); click(accountPgObj.coockiesLink);
	 * windows=driver.getWindowHandles(); Assert.assertTrue(windows.size()>1,
	 * "Cookies link is not opened in new tab"); switchWindow(driver, parentWindow);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.cookiesPageVerify),
	 * "Cookies is not redirected to Tradus Zendesk Page"); driver.close();
	 * driver.switchTo().window(parentWindow);
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify error message on trying to go to next page with
	 * invalid/fuzzy data in Email and password fields
	 * 
	 * @Test public void
	 * verifyErrormessageOnTryingtoGotoNextPagewithwrongDatainEmailandPwdField()
	 * throws Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(1000);
	 * click(accountPgObj.nextButton); waitTill(1000);
	 * Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).trim().
	 * equals("The email field is required"),
	 * "Correct Alert is not displaying when Email field is blank");
	 * Assert.assertTrue(getText(accountPgObj.passWordFieldDangerText).trim().
	 * equals("The password field is required"),
	 * "Correct Alert is not displaying when Password field is blank");
	 * sendKeys(accountPgObj.emailField,"InvalidEmail");
	 * sendKeys(accountPgObj.passWordField,"    "); click(accountPgObj.nextButton);
	 * waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.emailFieldDangerText),
	 * "Email error message is not displaying"); String errorMessage =
	 * accountPgObj.emailFieldDangerText.getText();
	 * Assert.assertEquals(errorMessage, "The email field must be a valid email",
	 * "The email error message text is not correct");
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.passWordFieldDangerText),
	 * "Password error message is not displaying"); errorMessage =
	 * accountPgObj.passWordFieldDangerText.getText();
	 * Assert.assertEquals(errorMessage, "The password field is required",
	 * "The password error message text is not correct"); }
	 * 
	 * 
	 * Description:Verify able to go back to first step on clicking back link
	 * 
	 * @Test public void verifyBacklinkFunctionality() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); String[] user= {"business","indivisual"};
	 * for(int i=0;i<user.length;i++) { pkjPgObj.gotoAccountsPage(driver, user[i]);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); click(accountPgObj.backButton);
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.
	 * packagePageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(pkjPgObj.
	 * packagePageVerificationElement),
	 * "Package page is not displaying upon clicking back link from Account page for "
	 * +user[i]+" user"); } }
	 * 
	 * 
	 * Description: Verify details page is displaying on trying with valid
	 * credentials
	 * 
	 * @Test public void verifyDetailsPageonClickingNextButtonwithValidCredentials()
	 * throws Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver); String[] user=
	 * {"business","indivisual"}; for(int i=0;i<user.length;i++) {
	 * pkjPgObj.gotoAccountsPage(driver, user[i]);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * accountsPageVerificationElement); waitTill(1000);
	 * sendKeys(accountPgObj.emailField,username);
	 * sendKeys(accountPgObj.passWordField,pwd); click(accountPgObj.agreeCheckBox);
	 * click(accountPgObj.nextButton);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.
	 * detailsPageVerificationElement),
	 * "Details page is not displaying upon clicking back link from Account page for "
	 * +user[i]+" user"); } }
	 * 
	 * 
	 * Description: Verify 'Go to sign in page' link on giving already registered
	 * email in email field
	 * 
	 * @Test public void verifyErrorMessageOnEnteringAlreadyRegisteredEmail() throws
	 * Exception { SignUpPackageTPROPage_New pkjPgObj=new
	 * SignUpPackageTPROPage_New(driver); SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * pkjPgObj.gotoAccountsPage(driver, "business");
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.emailField);
	 * sendKeys(accountPgObj.emailField,userName);
	 * sendKeys(accountPgObj.passWordField,pwd);
	 * Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).replace("\n",
	 * ",").equals("An account with this email already exists.,Go here to sign in"),
	 * " Error alert with an account already exits and sign link are not present ");
	 * click(accountPgObj.goToSignInPageErrorLinkOnEnteringRegisteredEmail);
	 * waitForElement(accountPgObj.loginPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.
	 * loginPageVerificationElement),
	 * "Login page is not working on entering register email in signup page");
	 * 
	 * }
	 */
}
