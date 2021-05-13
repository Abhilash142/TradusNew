package com.tradus.pages;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitTill;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountTradusPage {
	
	public RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//div[@class='user-account-page__list-wrapper']/following-sibling::ul//li//a[@id='myaccount']")
	public WebElement link_MyAccountsTab_xpath;
	
	@FindBy(xpath = "//input[@id='user-type-private']")
	public WebElement radioBtn_PrivateUser_xpath;
	
	@FindBy(xpath = "//input[@id='user-type-company']")
	public WebElement radioBtn_CompanyUser_xpath;

	@FindBy(xpath = "//h4[text()='Company Info']/parent::div")
	public WebElement div_CompanyInfoSection_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]")
	public WebElement div_PersonalInfoSection_xpath;
	
	@FindBy(xpath = "//h4[text()='Additional information']/following::div[@class='fieldset mb-3']")
	public WebElement div_additionalInfoSection_xpath;
	
	@FindBy(xpath = "(//h4[text()='Change password']/following::div[@class='fieldset d-flex f-wrap'])[1]")
	public WebElement div_changePasswordSection_xpath;
	
	@FindBy(xpath = "//div[@class='form-footer-links']//a[.='Delete your account']")
	public WebElement link_deleteAccount_xpath;
	
	@FindBy(xpath = "//div[@class='form-footer-links']//a[.='Export personal data']")
	public WebElement link_exportPersonalData_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='full_name']")
	public WebElement link_nameFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='email']")
	public WebElement link_emailFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='city_autocomplete']")
	public WebElement link_cityFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='postcode']")
	public WebElement link_ZipCodeFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "//select[@id='preferred_locale']")
	public WebElement select_languageFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='phone']")
	public WebElement input_phoneFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "//form[contains(@class,'user-profile mb-3')]//button[contains(@class,'profile-form__button')]")
	public WebElement button_updateProfileinrPersonalInfo_xpath;
	
	@FindBy(xpath = "//h4[text()='Company Info']/parent::div//input[@id='vat']")
	public WebElement input_vatFieldInComapanyInfo_xpath;
	
	@FindBy(xpath = "//h4[text()='Company Info']/parent::div//input[@id='company']")
	public WebElement input_companyFieldInComapanyInfo_xpath;
	
	@FindBy(xpath = "//h4[text()='Company Info']/parent::div//input[@id='website']")
	public WebElement input_websiteFieldInComapanyInfo_xpath;
	
	@FindBy(xpath = "//h4[text()='Company Info']/parent::div//input[@id='cphone']")
	public WebElement input_companyPhoneInComapanyInfo_xpath;
	
	@FindBy(xpath = "(//h4[text()='Change password']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='changepassword']")
	public WebElement input_newPasswordField_xpath;
	
	@FindBy(xpath = "(//h4[text()='Change password']/following::div[@class='fieldset d-flex f-wrap'])[1]//input[@id='repeatpassword']")
	public WebElement input_repeatPasswordField_xpath;
	
	@FindBy(xpath = "(//h4[text()='Change password']/following::div[@class='fieldset d-flex f-wrap'])[1]//button[contains(.,'Change Password')]")
	public WebElement btn_changePassword_xpath;
	
	@FindBy(xpath = "(//h4[text()='Personal Info']/following::div[@class='fieldset d-flex f-wrap'])[1]//span[.='Select language']/ancestor::div[@class='ss-multi-selected']")
	public WebElement div_spokenLanguageFieledinrPersonalInfo_xpath;
	
	@FindBy(xpath = "//div[@class='success-message mt-1']")
	public WebElement div_successMessageinMyAccounts_xpath;
	
	@FindBy(xpath = "//div[@class='error-message mt-1']")
	public WebElement div_errorMessageinMyAccounts_xpath;
	
	@FindBy(xpath = "//h4[text()='Additional information']/following::div[@class='fieldset mb-3']//a[contains(@class,'experience-customizer')]")
	public WebElement link_customizedTradusExp_xpath;
	
	@FindBy(xpath = "//h4[text()='Additional information']/following::div[@class='fieldset mb-3']//h2[contains(.,'equipment are you looking for?')]")
	public WebElement header_expCustomizerFirstModalVerify_xpath;
	
	@FindBy(xpath = "//div[@class='experience-customizer__tabs']//div[contains(@class,'customizer__box') and contains(.,'Transport' )]")
	public WebElement div_transportInexpCustomizerModal_xpath;
	
	@FindBy(xpath = "(//div[@class='experience-customizer__tabs']//a[contains(.,'Next')])[1]")
	public WebElement link_nextButtonInCategoryModal_xpath;
	
	@FindBy(xpath = "//div[@class='experience-customizer__tab']//h2[contains(.,'be more specific!')]")
	public WebElement header_L2ModalVerify_xpath;
	
	@FindBy(xpath = "(//div[contains(@class,'customizer__box') and contains(.,'Vans' )])[1]")
	public WebElement div_VanInL2Modal_xpath;
	
	@FindBy(xpath = "(//div[contains(@class,'experience-customizer__nav')]//a[contains(.,'Next')])[2]")
	public WebElement link_nextButtonInL2Modal_xpath;
	
	@FindBy(xpath = "//div[@class='experience-customizer__tab']//h2[contains(.,'purpose of your visit?')]")
	public WebElement header_purposeOfVisitModalVerify_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'experience-customizer__goal')]//div[contains(.,'To buy for my own use')]")
	public WebElement div_forOwnUserBtn_xpath;
	
	@FindBy(xpath = "//div[contains(@class,'experience-customizer__goal')]//div[contains(.,'In order to resale')]")
	public WebElement div_inOrderToReSellBtn_xpath;
	
	@FindBy(xpath = "//a[contains(@class,'button--brand') and contains(.,'Finish ')]")
	public WebElement link_finishButtonInLastModal_xpath;
	
	@FindBy(xpath = "(//div[contains(@class,'experience-customizer__nav')]//a[contains(.,'Back')])[2]")
	public WebElement link_backButtonInLastModal_xpath;
	
	@FindBy(xpath = "//div[@class='experience-customizer__close']")
	public WebElement link_closeIconInLastModal_xpath;
	
	
	public MyAccountTradusPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToMyAccountsPage() throws Exception {
		HomeTradusPage homePageObj=new HomeTradusPage(driver);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.lable_UserMenu_xpath);
		try {
			click(homePageObj.lable_UserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.lable_UserMenu_xpath);
		}
		waitTill(1500);
		explicitWaitFortheElementTobeVisible(driver,homePageObj.link_MyAccountFromUserMenu_xpath );
		try {
			click(homePageObj.link_MyAccountFromUserMenu_xpath);
		} catch (Exception E) {
			jsClick(driver, homePageObj.link_MyAccountFromUserMenu_xpath);
		}
		waitTill(1500);
	}

}
