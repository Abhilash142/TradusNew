package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userName;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.FogrotPasswordOTMPLMSPage;
import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.tradus.pro.pages.ForgotPasswordPage;
import com.tradus.pro.pages.LoginTradusPROPage;

public class ForgotPasswordOTMPLMSTest extends BaseClass{
	
	/*
	 * Description: Verify forgot password page is displaying on clicking the link in login page
	 */
	@Test
	public void VerifyForgotPasswordPageIsDisplayingOnClickingTheLinkInLoginPage() throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		try {
		click(loginPage.forgotPasswordLink);
		}catch(Exception e) {
			jsClick(driver, loginPage.forgotPasswordLink);
		}
		waitTill(3000);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		Assert.assertTrue(forgotPasswordPageObj.forgotPasswordPageHeading.getText().equals("Recover your password"),"Forgot password page is not displaying on clicking the link in login page");
		
	}
	
	/*
	 * Description: Verify signin link should display in header
	 */
	@Test
	public void verifySignInLinkIsDisplayingInForgotPasswordPage()throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
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
	 * Description: Verify 'Recover your password, Please enter your email address to reset your password.' text alogn with email field 
	 */
	@Test
	public void verifyForgetPasswordPageHeadingAndInfoTextAlongWithEmailField() throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
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
	 * Description: Verify 'Back to login' button and redirecting to login page on clicking 
	 */
	@Test
	public void verifyBackToLoginButtonInForgetPasswordPageAndItsNavigation() throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try {
		click(loginPage.forgotPasswordLink);
		}catch (Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordLoginPageLink);
		Assert.assertTrue(verifyElementPresent(forgotPasswordPageObj.forgotPasswordLoginPageLink), "Back to login link isn't present in forgot password page");
		try {
			click(forgotPasswordPageObj.forgotPasswordLoginPageLink);
			}catch (Exception e) {
				jsClick(driver,forgotPasswordPageObj.forgotPasswordLoginPageLink);
			}
		explicitWaitFortheElementTobeVisible(driver,loginPage.emailTextField);
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(loginPage.emailTextField), "User isn't landing on login page on clicking back to login button from forgot password page");
	}
   
	/*
	 * Description: Verify success message 'We've sent you an email with a link to reset your password. You may close this tab and check your email.' on submitting valid email - Removed and it is expected
	 */
	@Test
	public void verifySuccessMessageUponSubmittingValidEmailInForgetPasswordPage() throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		jsClick(driver,loginPage.forgotPasswordLink);
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, testUserPL);
		jsClick(driver,forgotPasswordPageObj.forgotPasswordRecoveryButton);
		waitTill(2000);
	    Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordSuccessMessage), "We've sent you an email with a link to reset your password. You may close this tab and check your email.", "Success message is not displaying upon submitting the forget password page with valid ceredentials");
	}
	
	/*
	 * Descritpion: Verify error message 'The email field is required' on entering and removing the email in the field
	 */
	@Test
	public void verifyErrorByEnteringAndRemovingEmailInForgetPasswordPage() throws Exception{
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		FogrotPasswordOTMPLMSPage forgotPasswordPageObj =  new FogrotPasswordOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,loginPage.forgotPasswordLink);
		try{
			click(loginPage.forgotPasswordLink);
		}catch (Exception e) {
			jsClick(driver,loginPage.forgotPasswordLink);
		}
		explicitWaitFortheElementTobeVisible(driver,forgotPasswordPageObj.forgotPasswordPageHeading);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, testUserPL);
		sendKeys(forgotPasswordPageObj.forgotPasswordEmailInputField, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTill(2000);
		Actions a= new Actions(driver);
		a.click(forgotPasswordPageObj.forgotPasswordRecoveryButton).build().perform();
		waitTill(2000);
		Assert.assertEquals(getText(forgotPasswordPageObj.forgotPasswordBlankEmailDangerText), "The email field is required", "This field is required error is not diaplying upon submitting the forget password form by removing the given email");
	}
	

}
