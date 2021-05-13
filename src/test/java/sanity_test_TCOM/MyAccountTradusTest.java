package sanity_test_TCOM;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.switchWindow;

import static com.tradus.core.GlobalConstants.TCOM_User_1;
import static com.tradus.core.GlobalConstants.TCOM_User_3;
import static com.tradus.core.GlobalConstants.TCOM_User_4;
import static com.tradus.core.GlobalConstants.TCOM_pwd;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.HomeTradusPage;
import com.tradus.pages.LoginTradusPage;
import com.tradus.pages.MyAccountTradusPage;

public class MyAccountTradusTest extends BaseClass{
	
	/*
	 * Description: Verify my account tab is displaying on cliking the account link under user account dropdown
	 * and Verify 'Private person' and 'company person' radio buttons are displaying
	 */
	@Test
	public void verifyMyAccountTabisDisplayingOnClickingAccountLinkFromDropDown() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		waitTill(1500);
		loginPageObj.doLogin(TCOM_User_1, TCOM_pwd);
		waitTill(1000);
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		myAccountObj.navigateToMyAccountsPage();
		try {
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		}catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.button_updateProfileinrPersonalInfo_xpath), "My Accounts page isn't displaying when clicked on My Accounts link from User Menu");
		}
		waitTill(1000);
		SoftAssert softAssertion=new SoftAssert();
		//System.out.println(myAccountObj.link_MyAccountsTab_xpath.getCssValue("color"));
		//System.out.println(myAccountObj.link_MyAccountsTab_xpath.getCssValue("background-color"));
		softAssertion.assertTrue(myAccountObj.link_MyAccountsTab_xpath.getCssValue("color").equals("rgba(35, 31, 32, 1)"), "My Accounts Tab isn't highlighted when clicked on the My Accounts Link");
		softAssertion.assertTrue(myAccountObj.link_MyAccountsTab_xpath.getCssValue("background-color").equals("rgba(255, 255, 255, 1)"), "My Accounts Tab background color might have changed when opened");
		try {
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_PrivateUser_xpath);
			}catch (Exception E) {
				softAssertion.assertTrue(verifyElementPresent(myAccountObj.radioBtn_PrivateUser_xpath), "Private radio button isn't present in My Accounts page");
			}
		softAssertion.assertTrue(verifyElementPresent(myAccountObj.radioBtn_CompanyUser_xpath), "Company user radio button isn't present in My Accounts page");
		softAssertion.assertAll();
	}
	
	/*
	 * Description: Verify by clicking on 'Private person' radio button, Verify only 'Personal info' is displaying and
	 * Verify first, last names, email, country name, company, phone number and preferred langauage fields 
	 */
	@Test
	public void verifyPresenceOfAllAttributeinPrivatePersonSection() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_1);
		sendKeys(loginPageObj.passWord,TCOM_pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_PrivateUser_xpath );
		try {
			click(myAccountObj.radioBtn_PrivateUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_PrivateUser_xpath);
		}
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(myAccountObj.div_PersonalInfoSection_xpath), "Private section is not displaying on clicking private radio button in My Account page");
		Assert.assertFalse(verifyElementPresent(myAccountObj.div_CompanyInfoSection_xpath), "Company info section is displaying on clicking Private radio button in My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_nameFieledinrPersonalInfo_xpath), "Name field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_emailFieledinrPersonalInfo_xpath), "Email field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_cityFieledinrPersonalInfo_xpath), "City field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_ZipCodeFieledinrPersonalInfo_xpath), "Zip code field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.select_languageFieledinrPersonalInfo_xpath), "Language field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.input_phoneFieledinrPersonalInfo_xpath), "Phone number field is not displaying in personal info section of My Account page");
		Assert.assertTrue(verifyElementPresent(myAccountObj.div_spokenLanguageFieledinrPersonalInfo_xpath), "Spoken Language field is not displaying in personal info section of My Account page");
	}
	
	/*
	 * Description: Verify Name and mobile number as Mandatory fields and respective error for invalid input
	 */
	@Test
	public void verifyNameAndMobileNumberAsMandatoryFields() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_3);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_PrivateUser_xpath );
		try {
			click(myAccountObj.radioBtn_PrivateUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_PrivateUser_xpath);
		}
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.link_nameFieledinrPersonalInfo_xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		boolean name_Required = (Boolean) js.executeScript("return arguments[0].required;",myAccountObj.link_nameFieledinrPersonalInfo_xpath);
		boolean phn_Required = (Boolean) js.executeScript("return arguments[0].required;",myAccountObj.input_phoneFieledinrPersonalInfo_xpath);
		Assert.assertTrue(name_Required, "Name field in My Accounts page is non-mandatory field");
		Assert.assertTrue(phn_Required, "Phone field in My Accounts page is non-mandatory field");
		System.out.println(myAccountObj.link_nameFieledinrPersonalInfo_xpath.getCssValue("border-bottom-color"));
		String[] inputs= {"","$#@!"};
		for(int x=0;x<inputs.length;x++) {
			sendKeys(myAccountObj.link_nameFieledinrPersonalInfo_xpath,inputs[x]);
			sendKeys(myAccountObj.input_phoneFieledinrPersonalInfo_xpath,inputs[x]);
			try {
				click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			}catch(Exception E) {
				jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			}
			waitTill(7000);
			Assert.assertTrue(myAccountObj.link_nameFieledinrPersonalInfo_xpath.getCssValue("border-bottom-color").trim().equals("rgba(232, 64, 53, 1)"), "Border color didn't change upon updating Name field with invalid input");
			Assert.assertTrue(myAccountObj.input_phoneFieledinrPersonalInfo_xpath.getCssValue("border-bottom-color").trim().equals("rgba(232, 64, 53, 1)"), "Border color didn't change upon updating Phone number field with invalid input");
			Assert.assertFalse(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message is displaying upon trying save personal data with invalid input");
		}
		sendKeys(myAccountObj.link_nameFieledinrPersonalInfo_xpath,"Abhilash");
		sendKeys(myAccountObj.input_phoneFieledinrPersonalInfo_xpath,"9999999999");
		try {
			click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}
		try {
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the personal data with valid input");
		}
		Assert.assertTrue(getText(myAccountObj.div_successMessageinMyAccounts_xpath).trim().equals("Profile updated successfully."), "Profile updated successfully. message isn't displaying on updating profile with valid details");
	}
	
	/*
	 * Description: Email filed isn't editable and ZIP field isn't mandatory
	 */
	@Test
	public void verifyEmailFieldandZIPfield() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_3);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_PrivateUser_xpath );
		try {
			click(myAccountObj.radioBtn_PrivateUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_PrivateUser_xpath);
		}
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.link_emailFieledinrPersonalInfo_xpath );
		Assert.assertTrue(getAttribute(myAccountObj.link_emailFieledinrPersonalInfo_xpath,"class").trim().equals("fieldset__input disabled-field"),"Email field is editable in My Accounts page");
	    String[] inputs= {"","751002"};
	    for(String i:inputs) {
		sendKeys(myAccountObj.link_ZipCodeFieledinrPersonalInfo_xpath,i);
		waitTill(1000);
	    try {
			click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}
	    try {
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the Personal data without filling zip field");
		}
	   }
	}
	/*
	 * Description: Verify by changing the preferred language
	 */
	@Test
	public void verifyChangeinPreferedLanguage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_3);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_PrivateUser_xpath );
		try {
			click(myAccountObj.radioBtn_PrivateUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_PrivateUser_xpath);
		}
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.select_languageFieledinrPersonalInfo_xpath);
		Select s=new Select(myAccountObj.select_languageFieledinrPersonalInfo_xpath);
		SoftAssert softAssertion=new SoftAssert();
		String[] lang= {"de","en"};
		for(String i:lang) {
			s.selectByValue(i);
			try {
				click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			}catch(Exception E) {
				jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			}
		    try {
					explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
				}catch(Exception E) {
					softAssertion.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the Personal data with different language");
				}
		    switch(i) {
		    case "de":
		    	 softAssertion.assertTrue(getText(myAccountObj.div_successMessageinMyAccounts_xpath).trim().equals("Profil erfolgreich aktualisiert."),"Correct Success message isn't displaying on changing language to Deutsch");
		       break;
		    case "en":
		    	softAssertion.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the Personal data with different language");
		    	 break;
		    }
		}
			 softAssertion.assertAll();
	}
	
	/*
	 * Description: Verify by clicking 'Company user' radio button , Verify both 'company info' and 'Personal info' are displaying
	 */
	@Test
	public void verifyCompanyUserRadioButtonandCheckBothCompanyInforAndPersonalInfoAreDisplaying() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_3);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		try {
			click(myAccountObj.radioBtn_CompanyUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		}
		waitTill(2000);
		   try {
				explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_CompanyInfoSection_xpath);
			}catch(Exception E) {
				Assert.assertTrue(verifyElementPresent(myAccountObj.div_CompanyInfoSection_xpath), "Company section isn't displaying upon clicking company radio button");
			}
		   Assert.assertTrue(verifyElementPresent(myAccountObj.div_PersonalInfoSection_xpath), "Personal info section isn't displaying upon clicking company radio button");
		   Assert.assertTrue(verifyElementPresent(myAccountObj.input_vatFieldInComapanyInfo_xpath), "VAT Field isn't present under company info section");
		   Assert.assertTrue(verifyElementPresent(myAccountObj.input_companyFieldInComapanyInfo_xpath), "Company name Field isn't present under company info section");
		   Assert.assertTrue(verifyElementPresent(myAccountObj.input_websiteFieldInComapanyInfo_xpath), "Website Field isn't present under company info section");
		   Assert.assertTrue(verifyElementPresent(myAccountObj.input_companyPhoneInComapanyInfo_xpath), "Company phone Field isn't present under company info section");
	}
	
	/*
	 * Description: Verify error message on updating the profile page without company name
	 */
	@Test
	public void verifyErrorMessageOnUpdatingProfilePageWithOutCompanyName() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_4);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		try {
			click(myAccountObj.radioBtn_CompanyUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		boolean cname_Required = (Boolean) js.executeScript("return arguments[0].required;",myAccountObj.input_companyFieldInComapanyInfo_xpath);
		Assert.assertTrue(cname_Required, "Company Name field in My Accounts page is non-mandatory field");
		sendKeys(myAccountObj.input_companyFieldInComapanyInfo_xpath,"");
		try {
			click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}
		waitTill(1000);
		Assert.assertTrue(myAccountObj.input_companyFieldInComapanyInfo_xpath.getCssValue("border-bottom-color").trim().equals("rgba(232, 64, 53, 1)"), "Border color didn't change upon updating Company name field with invalid input");
		sendKeys(myAccountObj.input_companyFieldInComapanyInfo_xpath,"Sunfra");
		try {
			click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}
		 try {
				explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
			}catch(Exception E) {
				Assert.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving Company data with Company Name");
			}
	}
	
	/*
	 * Descritpion: Verify remaining fields which are not mandatory
	 */
	@Test
	public void verifyRemainingFieldsareNonMandatory() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_4);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		try {
			click(myAccountObj.radioBtn_CompanyUser_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.radioBtn_CompanyUser_xpath);
		}
		sendKeys(myAccountObj.input_companyPhoneInComapanyInfo_xpath,"");
		sendKeys(myAccountObj.input_websiteFieldInComapanyInfo_xpath,"");
		sendKeys(myAccountObj.input_vatFieldInComapanyInfo_xpath,"");
		try {
			click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		} catch (Exception E) {
			jsClick(driver, myAccountObj.button_updateProfileinrPersonalInfo_xpath);
		}
		 try {
				explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
			}catch(Exception E) {
				Assert.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the Company data without filling Phn, VAT and Website field");
			}
		sendKeys(myAccountObj.input_companyPhoneInComapanyInfo_xpath,"9999999999");
		sendKeys(myAccountObj.input_websiteFieldInComapanyInfo_xpath,"www.sunfra.com");
		sendKeys(myAccountObj.input_vatFieldInComapanyInfo_xpath,"123456789");
			try {
				click(myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			} catch (Exception E) {
				jsClick(driver, myAccountObj.button_updateProfileinrPersonalInfo_xpath);
			}
			 try {
					explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
				}catch(Exception E) {
					Assert.assertTrue(verifyElementPresent(myAccountObj.div_successMessageinMyAccounts_xpath), "Success message isn't displaying upon saving the Company data without filling Phn, VAT and Website field");
				}
	}
	/*
	 * Description: Verify page redirects to listing page on clicking start browsing button
	 */
	@Test
	public void verifyCustomizedTradusExperience() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,"abhilash+101@sunfra.com");
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_additionalInfoSection_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.div_additionalInfoSection_xpath), "Additional info section isn't displaying in My Acccounts page");
		}
		try {
			click(myAccountObj.link_customizedTradusExp_xpath);
		} catch (Exception E) {
			jsClick(driver, myAccountObj.link_customizedTradusExp_xpath);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.header_expCustomizerFirstModalVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.header_expCustomizerFirstModalVerify_xpath), "Category Selection model isn't displaying on clicking customize your tradus Exp button");
		}
		waitTill(1000);
		/*
		 * try { click(myAccountObj.div_transportInexpCustomizerModal_xpath); } catch
		 * (Exception E) { jsClick(driver,
		 * myAccountObj.div_transportInexpCustomizerModal_xpath); } waitTill(1000);
		 */
		try {
			click(myAccountObj.link_nextButtonInCategoryModal_xpath);
		} catch (Exception E) {
			jsClick(driver, myAccountObj.link_nextButtonInCategoryModal_xpath);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.header_L2ModalVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.header_L2ModalVerify_xpath), "L2 Category Selection model isn't displaying in customize your tradus Exp model");
		}
		waitTill(1000);
		try {
			click(myAccountObj.div_VanInL2Modal_xpath);
		} catch (Exception E) {
			jsClick(driver, myAccountObj.div_VanInL2Modal_xpath);
		}
		waitTill(1000);
		try {
			click(myAccountObj.link_nextButtonInL2Modal_xpath);
		} catch (Exception E) {
			jsClick(driver, myAccountObj.link_nextButtonInL2Modal_xpath);
		}
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.header_purposeOfVisitModalVerify_xpath);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.header_purposeOfVisitModalVerify_xpath), "Purpose of Visit model isn't displaying in customize your tradus Exp model");
		}
		waitTill(1000);
		Assert.assertTrue(verifyElementPresent(myAccountObj.div_forOwnUserBtn_xpath), "Buy for my own use button isn't displaying in customize your tradus Exp model");
		Assert.assertTrue(verifyElementPresent(myAccountObj.div_inOrderToReSellBtn_xpath), "Inorder to resell button isn't displaying in customize your tradus Exp model");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_finishButtonInLastModal_xpath), "Finish button isn't displaying in customize your tradus Exp model");
		Assert.assertTrue(verifyElementPresent(myAccountObj.link_backButtonInLastModal_xpath), "Back button isn't displaying in customize your tradus Exp model");
	   try {
	    	click(myAccountObj.link_closeIconInLastModal_xpath);
	   }catch (Exception E) {
		   jsClick(driver,myAccountObj.link_closeIconInLastModal_xpath);
	   }
	   waitTill(3000);
	}
	/*
	 * Description: Validate change password functionlity
	 */
	@Test
	public void verifyChangePasswordFunctionality() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_4);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_changePasswordSection_xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		boolean password_Required = (Boolean) js.executeScript("return arguments[0].required;",myAccountObj.input_newPasswordField_xpath);
		boolean repeatPassword_Required = (Boolean) js.executeScript("return arguments[0].required;",myAccountObj.input_repeatPasswordField_xpath);
		Assert.assertTrue(password_Required, "Password field in My Accounts page is non-mandatory field");
		Assert.assertTrue(repeatPassword_Required, "Repeat password field in My Accounts page is non-mandatory field");
		sendKeys(myAccountObj.input_newPasswordField_xpath,"123ABC");
		sendKeys(myAccountObj.input_repeatPasswordField_xpath,"XYZ234");
		try {
			click(myAccountObj.btn_changePassword_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.btn_changePassword_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_errorMessageinMyAccounts_xpath );
		Assert.assertTrue(getText(myAccountObj.div_errorMessageinMyAccounts_xpath).trim().equals("Passwords do not match."), "Correct error message isn't displaying when password values are mismatching");
		//System.out.println(getText(myAccountObj.div_errorMessageinMyAccounts_xpath));
		sendKeys(myAccountObj.input_newPasswordField_xpath,"tradus123");
		sendKeys(myAccountObj.input_repeatPasswordField_xpath,"tradus123");
		try {
			click(myAccountObj.btn_changePassword_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.btn_changePassword_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.div_successMessageinMyAccounts_xpath);
		Assert.assertTrue(getText(myAccountObj.div_successMessageinMyAccounts_xpath).trim().equals("Password updated successfully."), "Success message isn't displaying correctly after updating password");
	}
	/*
	 * Description: Verify Delete your account and expert personal data links
	 */
	@Test
	public void verifyDeleteAccountAndExportPersonalDataLink() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		LoginTradusPage loginPageObj = new LoginTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.element_homePageVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_loginTradus_xpath);
		try {
			click(homePageObj.link_loginTradus_xpath);
		}catch (Exception E) {
			jsClick(driver,homePageObj.link_loginTradus_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.tab_LoginPageVerify_xpath);
		sendKeys(loginPageObj.userName,TCOM_User_4);
		sendKeys(loginPageObj.passWord,pwd);
		try {
			click(homePageObj.tradusLoginButton);
		} catch (Exception E) {
			jsClick(driver, homePageObj.tradusLoginButton);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		String parentWindow=driver.getWindowHandle();
		MyAccountTradusPage myAccountObj=new MyAccountTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,myAccountObj.button_updateProfileinrPersonalInfo_xpath );
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.link_deleteAccount_xpath);
		}catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.link_deleteAccount_xpath),"Delete Account isn't present in My Account page");
		}
		try{
			explicitWaitFortheElementTobeVisible(driver,myAccountObj.link_exportPersonalData_xpath);
		}catch (Exception E) {
			Assert.assertTrue(verifyElementPresent(myAccountObj.link_exportPersonalData_xpath),"Export personal data isn't present in My Account page");
		}
		try {
			click(myAccountObj.link_deleteAccount_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.link_deleteAccount_xpath);
		}
		switchWindow(driver,parentWindow);
		SoftAssert softAssertion=new SoftAssert();
		waitTill(1000);
		try{
			explicitWaitFortheElementTobeVisible(driver,homePageObj.header_HelpPageVerify_xpath);
		}catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_HelpPageVerify_xpath),"Help page isn't displaying on clicking Delete Account button from My Accounts");
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		waitTill(1000);
		try {
			click(myAccountObj.link_exportPersonalData_xpath);
		}catch(Exception E) {
			jsClick(driver,myAccountObj.link_exportPersonalData_xpath);
		}
		switchWindow(driver,parentWindow);
		waitTill(1000);
		try{
			explicitWaitFortheElementTobeVisible(driver,homePageObj.header_HelpPageVerify_xpath);
		}catch (Exception E) {
			softAssertion.assertTrue(verifyElementPresent(homePageObj.header_HelpPageVerify_xpath),"Help page isn't displaying on clicking Export personal data button from My Accounts");
		}
		driver.close();
		driver.switchTo().window(parentWindow);
	}
}
