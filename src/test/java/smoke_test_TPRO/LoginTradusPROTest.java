package smoke_test_TPRO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;


public class LoginTradusPROTest extends BaseClass {
	
	/*
	 * Description: Verify Email and password fields are displaying
	 */
	@Test
	public void verifyEmailPasswordFieldsAreDisplaying() throws Exception {
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/login")) {
			 CommonMethod cmdObj=new  CommonMethod(driver);
			 cmdObj.logOut();
		}
		explicitWaitFortheElementTobeVisible(driver,loginPage.passwordTextField);
		explicitWaitFortheElementTobeVisible(driver, loginPage.LoginButton);
		Assert.assertTrue(verifyElementPresent(loginPage.emailNameElement), "Login Email field is not displaying");
		Assert.assertTrue(verifyElementPresent(loginPage.passwordNameElement),
				"Login Password field is not displaying");
	}

	/*
	 * Description: Verify sign in link is not displaying
	 */
	/*@Test
	public void verifySignInLinkIsNotDisplaying() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.SignIn);
		jsClick(driver, signUpObj.SignIn);
		explicitWaitFortheElementTobeVisible(driver, signUpObj.loginPageVerificationElement);
		Assert.assertFalse(verifyElementPresent(signUpObj.SignIn), "The Sign In link is displaying");
	}*/


	/*
	 * Description : Verify error message 'Email/password are incorrect' on
	 * submitting invalid credentials
	 */
	@Test
	public void VerifyEmailAndPasswordErrorMessageOnGivingInvalidCredentials() throws Exception {
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/login")) {
			 CommonMethod cmdObj=new  CommonMethod(driver);
			 cmdObj.logOut();
		}
		explicitWaitFortheElementTobeVisible(driver,loginPage.passwordTextField);
		loginPage.setAccountEmailAndPassword("invalid", "@#$");
		new Actions(driver).click(loginPage.emailNameElement).perform();
		waitTill(2000);
		Assert.assertTrue(loginPage.emailErrorMessage.getText().equals("The email field must be a valid email"),
				"Email field has accepted invalid input");
		Assert.assertTrue(
				loginPage.passwordErrorMessage.getText().equals("The password field must be at least 7 characters"),
				"The password field has accepted less than 7 characters");
	}
	/*
	 * Description: Verify overview page is displaying on submitting with valid
	 * credentials
	 */
	@Test
	public void verifyOverviewPageOnSubmittingwithValidCredentials() throws Exception {
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		if(!driver.getCurrentUrl().equals("https://pro.tradus.com/login")) {
			 CommonMethod cmdObj=new  CommonMethod(driver);
			 cmdObj.logOut();
		}
		explicitWaitFortheElementTobeVisible(driver,loginPage.passwordTextField);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		try{
			click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://pro.tradus.com/lms"), "Overview page is not diaplyed");
		Assert.assertTrue(getAttribute(loginPage.overviewOptioninSiderBar, "class")
				.equals("router-link-exact-active router-link-active"), "Overview link is not highlighted");
	}

}