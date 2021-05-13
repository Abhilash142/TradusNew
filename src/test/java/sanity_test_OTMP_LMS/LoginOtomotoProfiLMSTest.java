package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpPackageOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;
import com.tradus.pro.pages.SignupTPROPage;

public class LoginOtomotoProfiLMSTest extends BaseClass{
	
	/*
	 * Description:Verify sign in link is not displaying 
	 */
	@Test
	public void verifySignInLinkIsNotDisplaying() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.loginLink);
		jsClick(driver,pkjPgObj.loginLink);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.loginPageVerifcationElement);
		waitTill(2000);
		Assert.assertFalse(verifyElementPresent(pkjPgObj.loginLink), "The Sign In link is displaying in Login page");
	}
	
	 /*
	  * Description: Verify Login text alogng with 'Welcome back! Please log in to your account.' text
	  */
	@Test
	public void verifyLoginTextWithWelcomeBackPleaseLogInToYourAccount() throws Exception {
		LoginOtomotoProfiLMSPage loginObj=new LoginOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginObj.emailTextField);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(loginObj.LoginText), "Log in text is not displaying");
		Assert.assertTrue(verifyElementPresent(loginObj.LoginToYourAccount),
				"'Welcome back! Please log in to your account.' is not displaying");
	}
	
	/*
	 * Description: Verify Email and password fields are displaying 
	 */
	@Test
	public void verifyEmailandPasswordfieldsareDisplaying() throws Exception{
		LoginOtomotoProfiLMSPage loginObj=new LoginOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginObj.LoginText);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(loginObj.emailNameElement), "Login Email field is not displaying");
		Assert.assertTrue(verifyElementPresent(loginObj.passwordNameElement), "Login Password field is not displaying");
	}
	
	/*
	 * Description: Verify forgot password and register links are displaying and redirecting to respective pages on clicking
	 */
	@Test
	public void verifyForgotPasswordRegisterLinksAreDisplayingAndRedirectingToRespectivePagesOnClicking() throws Exception {
		LoginOtomotoProfiLMSPage loginObj=new LoginOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginObj.LoginText);
		Assert.assertTrue(verifyElementPresent(loginObj.loginPageForgotPassword), "Login page forgot password link is not displaying");
		Assert.assertTrue(verifyElementPresent(loginObj.loginPageRegister), "Login page register link is not displaying");
		click(loginObj.loginPageForgotPassword);
		explicitWaitFortheElementTobeVisible(driver,loginObj.recoverPasswordPage);
		Assert.assertTrue(verifyElementPresent(loginObj.recoverPasswordPage),"Forgot password link is not redirected to respective page");
		click(loginObj.recoverPasswordPageBackButton);
		explicitWaitFortheElementTobeVisible(driver,loginObj.emailTextField);
		explicitWaitFortheElementTobeVisible(driver,loginObj.loginPageRegister);
		click(loginObj.loginPageRegister);
		explicitWaitFortheElementTobeVisible(driver,loginObj.packagePageVerificationElement);
		Assert.assertTrue(verifyElementPresent(loginObj.packagePageVerificationElement),"Register link is not redirected to respective page");
	}
	
	/*
	 * Description: Verify error message 'Email/password are incorrect' on submitting invalid credentials
	 */
	@Test
	public void VerifyEmailAndPasswordErrorMessageOnGivingInvalidCredentials() throws Exception{
		LoginOtomotoProfiLMSPage loginObj=new LoginOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginObj.LoginText);
		loginObj.setAccountEmailAndPassword("invalid","@#$");
		new Actions(driver).click(loginObj.emailNameElement).perform();
		waitTill(2000);
		Assert.assertTrue(loginObj.emailErrorMessage.getText().equals("The email field must be a valid email"), "Email field has accepted invalid input");
		Assert.assertTrue(loginObj.passwordErrorMessage.getText().equals("The password field must be at least 7 characters"), "The password field has accepted less than 7 characters");
	}
	
	/*
	 * Descritpion: Verify overview page is displaying on submitting with valid credentials
	 */
	@Test
	public void verifyOverviewPageOnSublittingwithValidCredentials() throws Exception{
		LoginOtomotoProfiLMSPage loginObj=new LoginOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginObj.LoginText);
		loginObj.setAccountEmailAndPassword(testUserPL,pwd);
		click(loginObj.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,loginObj.overviewPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(loginObj.overviewPageVerificationElement),"Overview page isn't displaying on clicking login button with valid credential");
	}
	

}
