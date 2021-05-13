package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.username;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

import sanity_test_TPRO.CommonMethods;

public class SignUpAccountsTProTest_New extends BaseClass {
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	@Test
	public void verifyLanguageDropdownandAllOptions() throws Exception{
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		accountPgObj.gotoAccountsPage(driver, "business");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
	}
	
	/*
	 * Description: Validate supportsilder's presence and functionalities
	 */
	@Test
	public void validateSupportSlider() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		
		accountPgObj.gotoAccountsPage(driver, "private");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.validateSupportSlider(driver);
	}
	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	
	@Test
	public void verifySignInLinkandItsNavigation() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		accountPgObj.gotoAccountsPage(driver, "business");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifySignInLinkandItsNavigation(driver);
	}

	/*
	 * Description:Verify the second step 'Account' is highlighted 
	 */
	@Test
	public void verifytheSecondStepisHighlighted() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		accountPgObj.gotoAccountsPage(driver, "business");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.tabInfo);
		Assert.assertTrue(getText(accountPgObj.tabName).trim().equals("Account"), "Accounts tab is not displaying");
		//System.out.println((accountPgObj.tabInfo).getCssValue("background-color"));
		Assert.assertTrue((accountPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 171, 189, 1)"),"Account section is not highlighted");
	}
	
	/*
	 * Description: Verify Monthly cost info is displaying in the right side
	 */
	@Test
	public void verifyMonthlyCostinfoisDisplayinginRightSide() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		accountPgObj.gotoAccountsPage(driver, "business");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		try {
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.monthlyCostSection);
		}catch(Exception E){
			Assert.assertTrue(verifyElementPresent(accountPgObj.monthlyCostSection), "Monthly costs section is not displaying in Accounts page");
		}
	}
	
	/*
	 * Description:Verify the 'price inc/exc.vat' text is displaying 
	 */
	@Test
	public void verifyPriceexcludingVATtextinMonthlyCost() throws Exception {
		SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
		accountPgObj.gotoAccountsPage(driver, "business");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.monthlyCostSection);
		Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).replace("\n", ",").trim().contains("Excluding VAT"),"Excluding VAT text is not displaying in price section for Business user");
		accountPgObj.gotoAccountsPage(driver, "indivisual");
		explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
		Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).replace("\n", ",").trim().contains("Excluding VAT"),"Excluding VAT text is not displaying in price section for Business user");
	}
	
		/*
		 * Description: Verify Email and password fields are displaying 
		 */
		@Test
		public void verifyEmailandPasswordFields() throws Exception{
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			accountPgObj.gotoAccountsPage(driver, "business");
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
			try {
				explicitWaitFortheElementTobeVisible(driver,accountPgObj.emailField);
			}catch(Exception E){
				Assert.assertTrue(verifyElementPresent(accountPgObj.emailField), "Email field is not present in Account page");
			}
			Assert.assertTrue(verifyElementPresent(accountPgObj.passWordField), "Passwoard field is not present in Account page");
		}
		
		/*
		 * Description: Verify presence Acceptance checkbox and error message if not selected
		 */
		@Test
		public void verifyAcceptanceCheckboxAnditsFunctionality() throws Exception {
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			String[] user= {"business","indivisual"};
			for(int i=0;i<user.length;i++) {
			accountPgObj.gotoAccountsPage(driver, user[i]);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.acceptacneCheckBoxSection), "Accepatacne checkbox section is not present for"+user[i]+" user");
			click(accountPgObj.nextButton);
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(accountPgObj.agreeCheckBoxError), "Terms error message is not displaying for"+user[i]+" user");
			String errorMessage = accountPgObj.agreeCheckBoxError.getText();
			Assert.assertEquals(errorMessage, "The Terms of Use field is required",
					"Terms error message text is not correct for"+user[i]+" user");
			try {
			click(accountPgObj.agreeCheckBox);
			} catch(Exception e) {
				jsClick(driver,accountPgObj.agreeCheckBox);
			}
			jsClick(driver,accountPgObj.nextButton);
			waitTill(1000);
			errorMessage = accountPgObj.agreeCheckBoxError.getText();
			Assert.assertTrue(errorMessage.isEmpty(), "After clicking checkbox 'Terms error message is displaying for"+user[i]+" user");
		}
		}
		/*
		 * Description: Verify error message on trying to go to next page with invalid/fuzzy data in Email and password fields
		 */
		@Test
		public void verifyErrormessageOnTryingtoGotoNextPagewithwrongDatainEmailandPwdField() throws Exception {
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			accountPgObj.gotoAccountsPage(driver, "business");
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
			click(accountPgObj.nextButton);
			waitTill(1000);
			Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).trim().equals("The email field is required"), "Correct Alert is not displaying when Email field is blank");
			Assert.assertTrue(getText(accountPgObj.passWordFieldDangerText).trim().equals("The password field is required"), "Correct Alert is not displaying when Password field is blank");
			sendKeys(accountPgObj.emailField,"InvalidEmail");
	        sendKeys(accountPgObj.passWordField,"    ");
			click(accountPgObj.nextButton);
			waitTill(1000);
			Assert.assertTrue(verifyElementPresent(accountPgObj.emailFieldDangerText),
					"Email error message is not displaying");
			String errorMessage = accountPgObj.emailFieldDangerText.getText();
			Assert.assertEquals(errorMessage, "The email field must be a valid email",
					"The email error message text is not correct");
			Assert.assertTrue(verifyElementPresent(accountPgObj.passWordFieldDangerText),
					"Password error message is not displaying");
			errorMessage = accountPgObj.passWordFieldDangerText.getText();
			Assert.assertEquals(errorMessage, "The password field is required",
					"The password error message text is not correct");
		}
		
		/*
		 * Description:Verify able to go back to first step on clicking back link
		 */
		@Test
		public void verifyBacklinkFunctionality() throws Exception {
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			accountPgObj.gotoAccountsPage(driver, "business");
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
			click(accountPgObj.backButton);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.packagePageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.packagePageVerificationElement), "Package page is not displaying upon clicking back link from Account page for business user");
		
		}
		
		/*
		 * Description: Verify details page is displaying on trying with valid credentials
		 */
		@Test
		public void verifyDetailsPageonClickingNextButtonwithValidCredentials() throws Exception {
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			String[] user= {"business","indivisual"};
			for(int i=0;i<user.length;i++) {
			accountPgObj.gotoAccountsPage(driver, user[i]);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.accountsPageVerificationElement);
			sendKeys(accountPgObj.emailField,username);
	        sendKeys(accountPgObj.passWordField,pwd);
	        click(accountPgObj.agreeCheckBox);
			click(accountPgObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.detailsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.detailsPageVerificationElement), "Details page is not displaying upon clicking back link from Account page for "+user[i]+" user");
		}
		}

		/*
		 * Description: Verify 'Go to sign in page' link on giving already registered email in email field
		 */
		@Test
		public void verifyErrorMessageOnEnteringAlreadyRegisteredEmail() throws Exception {
			SignUpAccountsTPROPage_New accountPgObj=new SignUpAccountsTPROPage_New(driver);
			accountPgObj.gotoAccountsPage(driver, "business");
			explicitWaitFortheElementTobeVisible(driver,accountPgObj.emailField);
			sendKeys(accountPgObj.emailField,userName);
			sendKeys(accountPgObj.passWordField,pwd);
			Assert.assertTrue(getText(accountPgObj.emailFieldDangerText).replace("\n", ",").equals("An account with this email already exists.,Go here to sign in"),
			" Error alert with an account already exits and sign link are not present ");
			click(accountPgObj.goToSignInPageErrorLinkOnEnteringRegisteredEmail);
			waitForElement(accountPgObj.loginPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(accountPgObj.loginPageVerificationElement),
					"Login page is not working on entering register email in signup page");
		}
		/*
		 * Description: Verify redirecting to first step on clicking 'Change package' link and Verify by changing the package 
		 */
		/*	@Test
		public void changePackageFunctionlity() throws Exception {
			SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
			SignUpAccountsTPROPage_New signUpAccountObj= new SignUpAccountsTPROPage_New(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
			waitTill(1000);
			for(int i=0;i<signUpPackageObj.packageTiles.size();i++) {
				try {
					click(signUpPackageObj.packageTiles.get(i));
				}catch(Exception E) {
					jsClick(driver,signUpPackageObj.packageTiles.get(i));
				}
				waitTill(2000);
				try {
					click(signUpPackageObj.nextButton);
				}catch(Exception E) {
					jsClick(driver,signUpPackageObj.nextButton);
				}
				explicitWaitFortheElementTobeVisible(driver,signUpAccountObj.accountsPageVerificationElement);
				waitTill(1000);
				switch (i) {
				
				case 0:{
					Assert.assertTrue(getText(signUpAccountObj.priceUnderMonthlyCost).replace("\n",",").trim().equals("€130.00,Excluding VAT"),"Selected basic package is not displaying in Accounts page");
					break;
				}
				case 1:{
					Assert.assertTrue(getText(signUpAccountObj.priceUnderMonthlyCost).replace("\n",",").trim().equals("€169.00,Excluding VAT"),"Selected premium package is not displaying in Accounts page");
					break;
				}
				}
				click(signUpAccountObj.changePackageUnderMonthlyCost);
				explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.tradusBasicPackage);
				Assert.assertTrue(verifyElementPresent(signUpPackageObj.packagePageVerificationElement), "Package page is not displaying after clicking change package if "+i+" package is selected");
			}
		}*/
}
