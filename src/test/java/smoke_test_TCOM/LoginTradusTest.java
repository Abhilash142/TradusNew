package smoke_test_TCOM;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.getTodayDate;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.TCOM_User_1;
import static com.tradus.core.GlobalConstants.TCOM_pwd;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;
import static com.tradus.core.ReadProp.getUserId;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.HomeTradusPage;
import com.tradus.pages.LoginTradusPage;

public class LoginTradusTest extends BaseClass{
	/*
	 * Descritpion:  Verify SignUp through google Link
	 */
	@Test
	public void verifySignUpThroughGoogleLink() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		waitTill(1000);
		String parent_window = driver.getWindowHandle();
		SoftAssert softAssertion = new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_SignUpwithGoogle_xpath);
		try {
			click(loginPageObj.link_SignUpwithGoogle_xpath);
		} catch (Exception e) {
			jsClick(driver, loginPageObj.link_SignUpwithGoogle_xpath);
		}
		waitTill(5000);

		if (driver.getWindowHandles().size() == 2) {
			switchWindow(driver, parent_window);
			try {
				explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_GooglePageVerify_xpath);
			} catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(loginPageObj.input_emailFieldinGooglePage_xpath),
						"Google page didn't displayed on clicking FB link from Registration page");
			}
			sendKeys(loginPageObj.input_emailFieldinGooglePage_xpath, "abhilash.automationtest@gmail.com");
			waitTill(2000);
			try {
				click(loginPageObj.btn_nextButtonInGooglePage_xpath);
			} catch (Exception e) {
				jsClick(driver, loginPageObj.btn_nextButtonInGooglePage_xpath);
			}
			try{
				explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_passwordFieldInGooglePage_xpath);
			}catch (Exception E) {
				driver.switchTo().window(parent_window);
			}
			sendKeys(loginPageObj.div_passwordFieldInGooglePage_xpath, pwd);
			waitTill(1000);
			try {
				click(loginPageObj.btn_nextButtonInGooglePage_xpath);
			} catch (Exception e) {
				jsClick(driver, loginPageObj.btn_nextButtonInGooglePage_xpath);
			}
			// waitForElement(loginPageObj.span_googleVerify_xpath);
			waitTill(5000);
			if (verifyElementPresent(loginPageObj.span_googleVerify_xpath)) {
				driver.close();
				driver.switchTo().window(parent_window);
				waitTill(1000);
			} else {
				driver.switchTo().window(parent_window);
				try {
					explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
				} catch (Exception E) {
					softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
							"User isn't able to register via Google sign up");
				}
			}
		} else {
			try {
				explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
			} catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
						"User isn't able to register via Google sign up");
			}
		}
		 waitTill(1000);
		softAssertion.assertAll();

	}
	/*
	 * Descritpion:  Verify Login through google Link
	 */
	//@Test
	public void verifyLoginThroughGoogleLink() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		String parent_window=driver.getWindowHandle();
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_googleLogin_xpath);
		try {
			click(loginPageObj.link_googleLogin_xpath);
		}catch(Exception e) {
			jsClick(driver,loginPageObj.link_googleLogin_xpath);
		}
		waitTill(5000);

		if (driver.getWindowHandles().size() == 2) {
		switchWindow(driver,parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_GooglePageVerify_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(loginPageObj.input_emailFieldinGooglePage_xpath),
					"Google page didn't displayed on clicking FB link from Registration page");
		}
		sendKeys(loginPageObj.input_emailFieldinGooglePage_xpath,"abhilash.automationtest@gmail.com");
		waitTill(2000);
		try {
			click(loginPageObj.btn_nextButtonInGooglePage_xpath);
		}catch(Exception e) {
			jsClick(driver,loginPageObj.btn_nextButtonInGooglePage_xpath);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_passwordFieldInGooglePage_xpath);
		}catch (Exception E) {
			driver.switchTo().window(parent_window);
		}
		sendKeys(loginPageObj.div_passwordFieldInGooglePage_xpath,pwd);
		waitTill(1000);
		try {
			click(loginPageObj.btn_nextButtonInGooglePage_xpath);
		}catch(Exception e) {
			jsClick(driver,loginPageObj.btn_nextButtonInGooglePage_xpath);
		}
	//	waitForElement(loginPageObj.span_googleVerify_xpath);
		waitTill(5000);
		if(verifyElementPresent(loginPageObj.span_googleVerify_xpath)) {
			driver.close();
			driver.switchTo().window(parent_window);
			waitTill(1000);
		}
		else {
         driver.switchTo().window(parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
					"User isn't logged in to Trauds via Google login");
		}
		}
		}else {
			try {
				explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
			} catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
						"User isn't logged in to Trauds via Google login");
			}
		}
	    waitTill(1000);
		softAssertion.assertAll();
	}
	
	/*
	 * Description: Verify login through fb Link
	 */
	@Test
	public void verifyLoginThroughFBLink() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		waitTill(1000);
		String parent_window=driver.getWindowHandle();
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_FBLogin_xpath);
		try {
			click(loginPageObj.link_FBLogin_xpath);
		}catch(Exception E) {
			jsClick(driver,loginPageObj.link_FBLogin_xpath);
		}
		waitTill(5000);

		if (driver.getWindowHandles().size() == 2) {
		switchWindow(driver,parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_FaceBookPageVerify_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(loginPageObj.input_emailFieldinFBPage_xpath),
					"Facebook page didn't displayed on clicking FB link from Login page");
		}
		waitTill(1000);
		waitForElement(loginPageObj.input_emailFieldinFBPage_xpath);
		if(verifyElementPresent(loginPageObj.input_emailFieldinFBPage_xpath) && verifyElementPresent(loginPageObj.input_passwordFieldinFBPage_xpath) && verifyElementPresent(loginPageObj.btn_loginButtoninFBPage_xpath) ) {
		sendKeys(loginPageObj.input_emailFieldinFBPage_xpath, "harish@sunfra.com");
		sendKeys(loginPageObj.input_passwordFieldinFBPage_xpath, TCOM_pwd);
		try {
			click(loginPageObj.btn_loginButtoninFBPage_xpath);
		}catch(Exception E) {
			jsClick(driver,loginPageObj.btn_loginButtoninFBPage_xpath);
		}
		}
		driver.switchTo().window(parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
					"User isn't logged in to Trauds via FB login");
		}
		}else {
			try {
				explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
			} catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
						"User isn't logged in to Trauds via FB login");
			}
		}
		waitTill(1000);
		softAssertion.assertAll();
	}
	/*
	 * Description: Verify SignUp through fb Link
	 */
	@Test
	public void verifySignUpThroughFBLink() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		waitTill(1000);
		String parent_window=driver.getWindowHandle();
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_SignUpwithFb_xpath);
		try {
			click(loginPageObj.link_SignUpwithFb_xpath);
		}catch(Exception E) {
			jsClick(driver,loginPageObj.link_SignUpwithFb_xpath);
		}
		waitTill(5000);

		if (driver.getWindowHandles().size() == 2) {
		switchWindow(driver,parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_FaceBookPageVerify_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(loginPageObj.input_emailFieldinFBPage_xpath),
					"Facebook page didn't displayed on clicking FB link from Registration page");
		}
		waitTill(1000);
		waitForElement(loginPageObj.input_emailFieldinFBPage_xpath);
		if(verifyElementPresent(loginPageObj.input_emailFieldinFBPage_xpath) && verifyElementPresent(loginPageObj.input_passwordFieldinFBPage_xpath) && verifyElementPresent(loginPageObj.btn_loginButtoninFBPage_xpath) ) {
		sendKeys(loginPageObj.input_emailFieldinFBPage_xpath, "harish@sunfra.com");
		sendKeys(loginPageObj.input_passwordFieldinFBPage_xpath, TCOM_pwd);
		try {
			click(loginPageObj.btn_loginButtoninFBPage_xpath);
		}catch(Exception E) {
			jsClick(driver,loginPageObj.btn_loginButtoninFBPage_xpath);
		}
		}
		driver.switchTo().window(parent_window);
		try {
			explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
					"User isn't logged in to Trauds via FB login");
		}
		}else {
			try {
				explicitWaitFortheElementTobeVisible(driver, homePageObj.lable_UserMenu_xpath);
			} catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(homePageObj.lable_UserMenu_xpath),
						"User isn't logged in to Trauds via FB login");
			}
		}
		waitTill(1000);
		softAssertion.assertAll();
	}
	
	/*
	 * Description: Verify Login tab is displaying on clicking the Login button from header
	 */
	@Test
	public void verifyLoginTabOnClickingLoginLinkfromHeader() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj=new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, homePageObj.tab_LoginPageVerify_xpath);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(homePageObj.tab_LoginPageVerify_xpath),
					"User isn't naviagting to Loging page on clicking link from Header");
		}
		 try {
		    explicitWaitFortheElementTobeVisible(driver,loginPageObj.input_keepMeLoginCheckBox_xpth); 
		  } catch (Exception E) {
		     Assert.assertTrue(verifyElementPresent(loginPageObj.input_keepMeLoginCheckBox_xpth),
		             "Login Tab isn't displaying when user clicks on Loging link from Header "); 
		}
	}
	/*
	 * Description: Verify All terms links are naviagting to respective Pages
	 */
	@Test
	public void verifyAllTermsLinksAreNavigatingToRepectivePagesFromSignUpWindow() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		waitTill(1000);
		String parent_Window=driver.getWindowHandle();
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_termsInRegistrationTab_xpath);
		try {
			click(loginPageObj.link_termsInRegistrationTab_xpath);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.link_termsInRegistrationTab_xpath);
		}
		switchWindow(driver,parent_Window);
		try {
		explicitWaitFortheElementTobeVisible(driver, homePageObj.header_TermsPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_TermsPageVerify_xpath),"Terms page isn't displaying on clicking Terms link from Sign up Tab");
		}
		driver.close();
		driver.switchTo().window(parent_Window);
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_PrivacyInRegistrationTab_xpath);
		try {
			click(loginPageObj.link_PrivacyInRegistrationTab_xpath);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.link_PrivacyInRegistrationTab_xpath);
		}
		switchWindow(driver,parent_Window);
		try {
		explicitWaitFortheElementTobeVisible(driver, homePageObj.header_PrivacyPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_PrivacyPageVerify_xpath),"Privacy page isn't displaying on clicking Privacy link from Sign up Tab");
		}
		driver.close();
		driver.switchTo().window(parent_Window);
		softAssertion.assertAll();
	}
	/*
	 * Description: Verify error message as 'Email already exists' on trying to register with exising account
	 */
	@Test
	public void verifyErrorMessageOnEnteringAlreadyRegisteredeEmail() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		waitTill(1000);
		sendKeys(loginPageObj.userNameInSignUp,TCOM_User_1);
		sendKeys(loginPageObj.PasswordInSignUp,pwd);
		try {
			click(loginPageObj.CreateAnAccountButton);
		}catch(Exception E) {
			jsClick(driver,loginPageObj.CreateAnAccountButton);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_ErrorMessage_xpath);
		Assert.assertTrue(getText(loginPageObj.div_ErrorMessage_xpath).trim().equals("This email already exist."),"Correct Error message isn't displaying on entering already registed user id");
	}
	/*
	 * Description: Verify 'Register as seller' redirecting to pro.tradus.com sign up page on clicking the link
	 */
	@Test
	public void verifyRegisterAsSellerRedirectingToProTradusPage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_SellerLogin_xpath);
		waitTill(1000);
		try {
			click(loginPageObj.link_SellerLogin_xpath);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.link_SellerLogin_xpath);
		}
		try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.header_SellingOnTradusPageVerify_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.header_SellingOnTradusPageVerify_xpath), "User is not landing to TradusPro Landing page on clicking Seller loging link on Tradus login page");
			 }
	}
	/*
	 * Description:Verify Pro tradus login up page is displaying on clicking the 'Login as seller' button
	 */
	@Test
	public void verifyProTradusLoginPageOnClickingLoginAsASeller() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		sendKeys(loginPageObj.userName,testUser);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		try {
			 explicitWaitFortheElementTobeVisible(driver,loginPageObj.div_BuyerSellerModel_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(loginPageObj.div_BuyerSellerModel_xpath), "Buyer Seller model isn't displaying on logging in with Seller Email");
			 }
		 try {
				click(loginPageObj.tradusLoginAsaSeller);
			} catch (Exception E) {
				jsClick(driver, loginPageObj.tradusLoginAsaSeller);
			}
		 try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.header_SellingOnTradusPageVerify_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.header_SellingOnTradusPageVerify_xpath), "Pro Tradus landing page isn't displaying on clicking login in as a Seller from the buyer seller model");
			 }
	}
	/*
	 * Description: Verify Login Functionality
	 */
	@Test
	public void verifyLoginFunctionality() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		sendKeys(loginPageObj.userName,TCOM_User_1);
		sendKeys(loginPageObj.passWord,TCOM_pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		try {
			 explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
			 }catch(Exception E) {
				 Assert.assertTrue(verifyElementPresent(homePageObj.element_homePageVerify_xpath), "User isn't log in to application sucessfully upon entering valid user id and password");
			 }
	}
	/*
	 * Description: Verify error message is displaying on trying to login with invalid credentials
	 */
	@Test
	public void verifyErrorMessageOnTryingToLoginWithInvalidCredentials() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		sendKeys(loginPageObj.userName,"abhilash+1480@sunfra.com");
		sendKeys(loginPageObj.passWord,TCOM_pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_ErrorMessage_xpath);
		Assert.assertTrue(getText(loginPageObj.div_ErrorMessage_xpath).trim().equals("Email or password is incorrect."), "Correct error message isn't displaying on entering invalid user id or password in login page");
	}
	
	/*
	 * Description: Verify Terms, Privacy, Forgot password and seller page navigations from login Page
	 */
	@Test
	public void verifyTermsPrivacyForgotPasswordandSellerPageNavigationfromLoginPage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.tradusLoginButton);
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_forgotPwd_xpath);
		try {
			click(loginPageObj.link_forgotPwd_xpath);
		}catch (Exception E) {
			jsClick(driver,loginPageObj.link_forgotPwd_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.h2_ForgotPasswordPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(loginPageObj.h2_ForgotPasswordPageVerify_xpath),"Recover password page isn't displaying on clicking forgot password link");
		}
		driver.navigate().back();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_Terms_xpath);
		try {
			click(loginPageObj.link_Terms_xpath);
		}catch (Exception E) {
			jsClick(driver,loginPageObj.link_Terms_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,homePageObj.header_TermsPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_TermsPageVerify_xpath),"Terms page isn't displaying on clicking Terms link from Login page");
		}
		driver.navigate().back();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_Privacy_xpath);
		try {
			click(loginPageObj.link_Privacy_xpath);
		}catch (Exception E) {
			jsClick(driver,loginPageObj.link_Privacy_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,homePageObj.header_PrivacyPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_PrivacyPageVerify_xpath),"Privacy page isn't displaying on clicking Privacy link from Login page");
		}
		driver.navigate().back();
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.link_SellerLogin_xpath);
		try {
			click(loginPageObj.link_SellerLogin_xpath);
		}catch (Exception E) {
			jsClick(driver,loginPageObj.link_SellerLogin_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,homePageObj.header_SellingOnTradusPageVerify_xpath);
		}catch(Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_SellingOnTradusPageVerify_xpath),"TPRO Landing page isn't displaying on clicking login as Seller link from Login page");
		}
		softAssertion.assertAll();
	}
	/*
	 * Descritpion: Verify error message as 'Please enter password/email' on trying to register without email and Password and
	 */
	@Test
	public void verifyErrorMessageforInvalidInputAndSuccessMessageForValidInputInSignUpPage() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.userNameInSignUp);
		sendKeys(loginPageObj.userNameInSignUp,"");
		sendKeys(loginPageObj.PasswordInSignUp,"");
		try {
			click(loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.CreateAnAccountButton);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_ErrorMessage_xpath);
		//System.out.println(getText(loginPageObj.div_ErrorMessage_xpath).trim());
		Assert.assertTrue(getText(loginPageObj.div_ErrorMessage_xpath).trim().equals("Email can not be blank"), "Correct error message isn't displaying in Sign up page when both user id and password fields are left blank");
		sendKeys(loginPageObj.userNameInSignUp,"abhilash+12345@sunfra.com");
		try {
			click(loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.CreateAnAccountButton);
		}
		//System.out.println(getText(loginPageObj.div_ErrorMessage_xpath).trim());
		Assert.assertTrue(getText(loginPageObj.div_ErrorMessage_xpath).trim().equals("Password can not be blank"), "Correct error message isn't displaying in Sign up page when password field left blank");
		sendKeys(loginPageObj.userNameInSignUp,"");
		sendKeys(loginPageObj.PasswordInSignUp,"12345");
		try {
			click(loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.CreateAnAccountButton);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_ErrorMessage_xpath);
		//System.out.println(getText(loginPageObj.div_ErrorMessage_xpath).trim());
		Assert.assertTrue(getText(loginPageObj.div_ErrorMessage_xpath).trim().equals("Email can not be blank"), "Correct error message isn't displaying in Sign up page when Email field left blank");
	}
	/*
	 * Description: Verify message as 'Your account was created. We sent an email to confirm your account.
	 */
	@Test
	public void verifyRegistrationSuccess() throws Exception {
		HomeTradusPage homePageObj = new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(2000);
		if(verifyElementPresent(homePageObj.lable_UserMenu_xpath)) {
			homePageObj.doLogOut();
		}
		explicitWaitFortheElementTobeVisible(driver, homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver, loginPageObj.SignUpTab);
		try {
			click(loginPageObj.SignUpTab);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.SignUpTab);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.CreateAnAccountButton),
					"Registration Tab isn't displaying on clicking Create An Account button from Login Page");
		}
		waitTill(1000);
		String date=getTodayDate();
		String u_id=getUserId("buyer","buyer_Userid");
		String email="abhilash+"+u_id+"+"+date+"@sunfra.com";
		sendKeys(loginPageObj.userNameInSignUp,email);
		sendKeys(loginPageObj.PasswordInSignUp,"tradus123");
		waitTill(2000);
		try {
			click(loginPageObj.CreateAnAccountButton);
		} catch (Exception E) {
			jsClick(driver, loginPageObj.CreateAnAccountButton);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_MyAccountTab_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.div_MyAccountTab_xpath), "My Accounts tab isn't displaying after successful Registration");
		}
		try{
			explicitWaitFortheElementTobeVisible(driver, loginPageObj.div_SignUpSuccess_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(loginPageObj.div_SignUpSuccess_xpath), "Success message isn't displaying in My Accounts tab after successful Registration");
		}
		Assert.assertTrue(getText(loginPageObj.div_SignUpSuccess_xpath).trim().equals("Your account was created. We sent an email to confirm your account."), "Correct success message isn't displayong after successful registration");
	}
}
