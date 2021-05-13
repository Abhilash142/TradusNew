package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.jsClick;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.core.BaseClass;
import com.tradus.core.TestListenersClass;
import com.tradus.pro.pages.ForgotPasswordPage;


public class ForgotPasswordTradusPROTest extends BaseClass{
	
	/*
	 * Description : Verify forgot password page is displaying on clicking the link in login page
	 */
	@Test
	public void VerifyForgotPasswordPageIsDisplayingOnClickingTheLinkInLoginPage() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		try {
		click(loginPage.forgotPasswordLink);
		}catch(Exception e) {
			jsClick(driver, loginPage.forgotPasswordLink);
		}
		waitTill(3000);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		Assert.assertTrue(forgotPasswordPageObj.forgotPasswordPageHeading.getText().equals("Recover your password"),"Forgot password page is not displaying on clicking the link in login page");
	}
	
	/*
	 * Description : Verify signin link should display in header
	 */
	@Test
	public void verifySignInLinkIsDisplayingInForgotPasswordPage()throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try {
		click(loginPage.forgotPasswordLink);
		}catch (Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.forgotPasswordSignInLink),"Sign In link has not displayed in the Forgot Password Page");
	}
	
	/*
	 * Description : Verify 'Recover your password, Please enter your email address to reset your password.' text along with email field 
	 */
	@Test
	public void verifyForgetPasswordPageHeadingAndInfoTextAlongWithEmailField() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try {
		click(loginPage.forgotPasswordLink);
		}catch (Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordPageHeading), "Recover your password","Recover your password heading is not displaying in forget password page");
		Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordInfoText), "Please enter your email address to reset your password.","Info text is not displaying as expected in forget password page");
		Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.forgotPasswordEmailInputField), "Email field is not displaying in forget password page");
	}

	/*
	 * Description : Verify 'Back to login' button and redirecting to login page on clicking 
	 */
	@Test
	public void verifyBackToLoginButtonInForgetPasswordPageAndItsNavigation() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try {
		click(loginPage.forgotPasswordLink);
		}catch(Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordLoginPageLink);
		try {
			click(forgotPasswordPageObj.forgotPasswordLoginPageLink);
			}catch(Exception e) {
				jsClick(driver,forgotPasswordPageObj.forgotPasswordLoginPageLink);
			}
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginText);
        Assert.assertTrue(verifyElementPresent(loginPage.LoginText), "User not navigated to login page upon clicking on back to login button in forget password page");
	}
	
	/*
	 * Description : Verify error message 'The email field is required' on entering and removing the email in the field
	 */
	@Test
	public void verifyErrorByEnteringAndRemovingEmailInForgetPasswordPage() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try{
			click(loginPage.forgotPasswordLink);
		}catch (Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTill(2000);
		Actions a= new Actions(driver);
		a.click(forgotPasswordPageObj.forgotPasswordRecoveryButton).build().perform();
		//jsClick(driver, forgotPasswordPageObj.forgotPasswordRecoveryButton);
		waitTill(2000);
		Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordBlankEmailDangerText), "The email field is required", "This field is required error is not diaplying upon submitting the forget password form by removing the given email");
	}
	
	/*
	 * Description : Verify 'An account with this email address does not exist.' error message on giving invalid email
	 */
	@Test
	public void verifyErrorMessageByGivingUnregisteredEmailInForgetPasswordPage() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try{
			click(loginPage.forgotPasswordLink);
		}catch(Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, "harishtra+177356@outlook.com");
		try {
		click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		//explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordUnregisteredEmailDangerText);
		waitTill(3000);
		Assert.assertFalse(verifyElementPresent(forgotPasswordPageObj.forgotPasswordUnregisteredEmailDangerText), "Error message is displaying upon giving unregistered email in forget password page");
		//Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordUnregisteredEmailDangerText), "An account with this email address does not exist.", "Error message is not displaying upon giving unregistered email in forget password page");
	}
	
	/*
	 * Description : Verify success message 'We've sent you an email with a link to reset your password. You may close this tab and check your email.' on submitting valid email
	 */
	@Test
	public void verifySuccessMessageUponSubmittingValidEmailInForgetPasswordPage() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		jsClick(driver,loginPage.forgotPasswordLink);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
		jsClick(driver,forgotPasswordPageObj.forgotPasswordRecoveryButton);
		waitTill(2000);
	    Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordSuccessMessage), "We've sent you an email with a link to reset your password. You may close this tab and check your email.", "Success message is not displaying upon submitting the forget password page with valid ceredentials");
	}
	
	/*
	 * Description : Verify login page is displaying on clicking 'Cancel' button 
	 */
	/*@Test(priority=1)
	public void verifyLoginPageIsDisplayingByClickingOnCancelOptionInForgetPasswordpage() throws Exception{
		loadUrl(driver,"https://pro.tradus.com/forgot-password");
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
		click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
		waitTill(1000);
		loadUrl(driver,"https://accounts.google.com/signin");
		waitTill(3000);
		
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
		sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, userName);
		click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, pwd);
		click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		waitTill(3000);
		System.out.println("Google account page "+driver.getCurrentUrl());
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
		System.out.println(driver.getCurrentUrl());
	    driver.switchTo().frame(0);
	    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
	    String parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
	    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
	    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
	    parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.setNewPasswordCancelButton);
		click(forgotPasswordPageObj.setNewPasswordCancelButton);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
	    explicitWaitFortheElementTobeVisible(driver,loginPage.LoginText);
        Assert.assertTrue(verifyElementPresent(loginPage.LoginText), "User not navigated to login page upon clicking on back to login button in forget password page");
        
	}*/
	/*
	 *  Description: Verify page is redirecting to reset password page on clicking 'Reset' button in received 'Reset password' email
	 */
	/*@Test(priority=2)
	public void verifyNavigationtoResetPasswordPageonclickingResetButtonfromEmail()throws Exception{
		
		loadUrl(driver,"https://pro.tradus.com/forgot-password");
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
		click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
		loadUrl(driver,"https://accounts.google.com/signin");
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
		sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, "harish.boyapati.sunfra@gmail.com");
		click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, "sunfra@123");
		click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
		driver.switchTo().frame(0);
	    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
	    String parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
	    loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
	    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
	    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
	    String parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordPageElement);
	    Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.ResetPasswordPageElement),
	    		"Reset password page is not displayed");
	}*/
	
	/*
	 * Description : Verify 'Your password has been reset' message displaying in login page on resetting the password with valid data
	 */
    /*@Test(priority=3)
	public void verifySuccessMessageUponResettingPasswordWithValidData() throws Exception {
		ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loadUrl(driver,"https://pro.tradus.com/forgot-password");
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
		click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
		loadUrl(driver,"https://accounts.google.com/signin");
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
		sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, "harish.boyapati.sunfra@gmail.com");
		click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, "sunfra@123");
		click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
		driver.switchTo().frame(0);
	    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
	    String parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
		loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
	    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
	    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
	    String parentWindow=driver.getWindowHandle();
	    switchWindow(driver, parentWindow);
	    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordPageElement);
	    sendKeys(forgotPasswordPageObj.setNewPasswordTextBox, pwd);
	    sendKeys(forgotPasswordPageObj.ConifrmPasswordTextBox, pwd);
	    click(forgotPasswordPageObj.setNewPasswordPageRecoverPasswordButton);
	    explicitWaitFortheElementTobeVisible(driver,loginPage.PasswordResetSuccessMessage);
	    Assert.assertTrue(verifyElementPresent(loginPage.PasswordResetSuccessMessage), "Your password has been successfully reset. success message not displaying in login page upon resetting the password with valid data");
	    
    }*/
    /*
	 *  Description: Verify set a new password text along with 'Password' and 'Confirm password' fields displaying 
	 */
   /* @Test(priority=4)
	   public void verifypresenceofAllElementsinForgotPwdForm()throws Exception{
		    loadUrl(driver,"https://pro.tradus.com/forgot-password");
		    ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
			sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
			click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
			loadUrl(driver,"https://accounts.google.com/signin");
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
			sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, "harish.boyapati.sunfra@gmail.com");
			click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, "sunfra@123");
			click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
			driver.switchTo().frame(0);
		    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
			loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
		    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
		    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordPageTitle);
		    Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.ResetPasswordPageTitle),
		    		"Reset password page is not displayed");
		    Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.resetPasswordPwdElement),
		    		"Password field  is not displayed in reset password form");
		    Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.resetPasswordPwdCnfElement),
		    		"Confirm Password field  is not displayed in reset password form");
	  }*/
    
    /*
	  *Description: Verify error message 'The password field must be at least 8 characters' on entering the password less than 8 characters
	  */
	  /* @Test(priority=5)
	   public void verifyPasswordLengthlessthan8charactorsErrorMessage()throws Exception{
		 
		    loadUrl(driver,"https://pro.tradus.com/forgot-password");
		    ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
			sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
			click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
			loadUrl(driver,"https://accounts.google.com/signin");
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
			sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, "harish.boyapati.sunfra@gmail.com");
			click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, "sunfra@123");
			click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
			driver.switchTo().frame(0);
		    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
			loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
		    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
		    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordPageTitle);
		    sendKeys(forgotPasswordPageObj.resetPasswordPwdTextfield, "12345");
		    sendKeys(forgotPasswordPageObj.resetPasswordCnfPwdTextfield, "12345");
		    waitTill(2000);
		    new Actions(driver).click(forgotPasswordPageObj.recoverPasswordbtn).perform();
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.resetPasswordDangerText);
		    Assert.assertEquals(getText(forgotPasswordPageObj.resetPasswordDangerText), "The password field must be at least 8 characters",
		    		"At least 8 charactors error is not displaying for password field");
		    Assert.assertEquals(getText(forgotPasswordPageObj.resetCnfPasswordDangerText), "The confirm password field must be at least 8 characters",
		    		"At least 8 charactors error is not displaying for confirm password field");
	  }*/
	  /*
	   *  Description: Verify error message 'The confirm password confirmation does not match' on entering different passwords
	   *  in both the fields
	   */
    /*  @Test(priority=6)
	   public void verifyPasswordmissmatchErrorinResetPasswordform()throws Exception{
		    loadUrl(driver,"https://pro.tradus.com/forgot-password");
		    ForgotPasswordPage forgotPasswordPageObj =  new ForgotPasswordPage(driver);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
			sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, userName);
			click(forgotPasswordPageObj.forgotPasswordRecoveryButton);
			loadUrl(driver,"https://accounts.google.com/signin");
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailFillEmailPageElement);
			sendKeys(forgotPasswordPageObj.gmailSignInPageUseridField, "harish.boyapati.sunfra@gmail.com");
			click(forgotPasswordPageObj.gmailSignInPageUidNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			sendKeys(forgotPasswordPageObj.gmailSignInPagePasswordField, "sunfra@123");
			click(forgotPasswordPageObj.gmailSignInPagePasswdNextbtn);
			explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.googleAccountVerificationElement);
			driver.switchTo().frame(0);
		    click(forgotPasswordPageObj.gmailLinkinGoogleApps);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
			loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
			forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.GmailInboxPageVerificationElement);
		    click(forgotPasswordPageObj.RecoveryPasswordEmailThread);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordbtninEmail);
		    click(forgotPasswordPageObj.ResetPasswordbtninEmail);
		    String parentWindow=driver.getWindowHandle();
		    switchWindow(driver, parentWindow);
		    forgotPasswordPageObj =  new ForgotPasswordPage(driver);
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.ResetPasswordPageTitle);
		    sendKeys(forgotPasswordPageObj.resetPasswordPwdTextfield, "12345678");
		    sendKeys(forgotPasswordPageObj.resetPasswordCnfPwdTextfield, "12345123");
		    waitTill(2000);
		    new Actions(driver).click(forgotPasswordPageObj.recoverPasswordbtn).perform();
		    explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.resetCnfPasswordDangerText);
		    Assert.assertTrue(getText(forgotPasswordPageObj.resetCnfPasswordDangerText).trim().equals("The confirm password confirmation does not match"),
		    		"Password missmatch error is not displaying under confirm password field in reset password page");
		    loadUrl(driver,"https://mail.google.com/mail/u/0/#inbox");
		    click(forgotPasswordPageObj.emailUserDropdown);
		    waitTill(3000);
	        new Actions(driver).moveToElement(forgotPasswordPageObj.emailSignoutButton).click().build().perform();
	        waitTill(3000);
			}*/
}
	