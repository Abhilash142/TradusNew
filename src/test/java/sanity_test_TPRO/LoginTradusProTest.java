package sanity_test_TPRO;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.core.TestListenersClass;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;
import com.tradus.pro.pages.SignupTPROPage;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

public class LoginTradusProTest extends BaseClass{
	/*
	 * Description : Verify error message 'Email/password are incorrect' on submitting invalid credentials
	 */
	@Test
	public void VerifyEmailAndPasswordErrorMessageOnGivingInvalidCredentials() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword("invalid","@#$");
		new Actions(driver).click(loginPage.emailNameElement).perform();
		waitTill(2000);
		Assert.assertTrue(loginPage.emailErrorMessage.getText().equals("The email field must be a valid email"), "Email field has accepted invalid input");
		Assert.assertTrue(loginPage.passwordErrorMessage.getText().equals("The password field must be at least 7 characters"), "The password field has accepted less than 7 characters");
	}

	/*
	 * Description: Verify error message 'Please go to confirmation email and activate the account' displaying 
	 * on trying to login without activating the account from confirmation email
	 */
	@Test
	public void verifyErroruponLoginwithoutActivatingAccount() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		String[] userid = {"harish.boyapati+1065@olx.com","harish.boyapati+1064@olx.com"};
		for(int i=0;i<userid.length;i++) {
		loadUrl(driver,"https://pro.tradus.com/login");
		explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
		loginPage.setAccountEmailAndPassword(userid[i],"12345678");
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,loginPage.unConfirmedEmailDangerText);
		Assert.assertEquals(getText(loginPage.unConfirmedEmailDangerText).trim(), 
				"There was an error. Please try again or get in touch with our support team.",
				"Proper error message is not displaying upon trying to log in with unConfromed email id");
		}
	}
	
	/*
	 * Description: Verify overview page is displaying on submitting with valid credentials
	 */
	@Test
	public void verifyOverviewPageOnSublittingwithValidCredentials() throws Exception{
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName,pwd);
		click(loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"),
		"Overview page is not displyed");
		Assert.assertTrue(getAttribute(loginPage.overviewOptioninSiderBar,"class").
				equals("router-link-exact-active router-link-active"), "Overview link is not highlighted");
		waitTill(2000);
		new Actions(driver).moveToElement(loginPage.overviewUserDropdown).click().build().perform();
		waitTill(6000);
		new Actions(driver).moveToElement(loginPage.overviewLogoutLink).click().build().perform();
		waitTill(2000);
	}
	
	/*
	 *  Description: Verify sign in link is not displaying
	 */
		
		public void verifySignInLinkIsNotDisplaying() throws Exception{
			SignUpPackageTPROPage_New signUpPackageObj=new SignUpPackageTPROPage_New(driver);
			explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.packagePageVerificationElement);
			explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.loginLink);
			jsClick(driver,signUpPackageObj.loginLink);
			explicitWaitFortheElementTobeVisible(driver,signUpPackageObj.loginPageVerificationElement);
			waitTill(6000);
			Assert.assertFalse(verifyElementPresent(signUpPackageObj.loginLink), "The Sign In link is displaying in Login page");
		}
		
		/*
		 *  Description: Verify Login text along with 'Welcome back! Please log in to your account.' text
		 */
		@Test
		public void verifyLoginTextWithWelcomeBackPleaseLogInToYourAccount() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			loadUrl(driver,"https://pro.tradus.com/signup");
			explicitWaitFortheElementTobeVisible(driver,signUpObj.SignIn);
			click(signUpObj.SignIn);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.loginPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.LoginPage), "Log in text is not displaying");
			Assert.assertTrue(verifyElementPresent(signUpObj.welcomeBackTextInLogInPage),
					"'Welcome back! Please log in to your account.' is not displaying");
		}
		
		/*
		 *  Description: Verify Email and password fields are displaying
		 */
		@Test
		public void verifyEmailPasswordFieldsAreDisplaying() throws Exception {
			LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
			//loadUrl(driver,"https://pro.tradus.com/login");
			waitTill(5000);
			explicitWaitFortheElementTobeVisible(driver,loginPage.LoginButton);
			Assert.assertTrue(verifyElementPresent(loginPage.emailNameElement), "Login Email field is not displaying");
			Assert.assertTrue(verifyElementPresent(loginPage.passwordNameElement), "Login Password field is not displaying");
		}
		
		/*
		 *  Description: Verify forgot password and register links are displaying and redirecting to respective pages on clicking
		 */
		@Test
		public void verifyForgotPasswordRegisterLinksAreDisplayingAndRedirectingToRespectivePagesOnClicking() throws Exception {
			SignupTPROPage signUpObj = new SignupTPROPage(driver);
			loadUrl(driver,"https://pro.tradus.com/signup");
			explicitWaitFortheElementTobeVisible(driver,signUpObj.SignIn);
			click(signUpObj.SignIn);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.loginPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(signUpObj.loginPageForgotPassword), "Login page forgot password link is not displaying");
			Assert.assertTrue(verifyElementPresent(signUpObj.loginPageRegister), "Login page register link is not displaying");
			click(signUpObj.loginPageForgotPassword);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.recoverPasswordPage);
			Assert.assertTrue(verifyElementPresent(signUpObj.recoverPasswordPage),"Forgot password link is not redirected to respective page");
			click(signUpObj.recoverPasswordPageBackButton);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.loginPageEmailTextField);
			click(signUpObj.loginPageRegister);
			explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
			Assert.assertTrue(verifyElementPresent(signUpObj.emailField), "Register link is not redirected to respective page");
		}

}
