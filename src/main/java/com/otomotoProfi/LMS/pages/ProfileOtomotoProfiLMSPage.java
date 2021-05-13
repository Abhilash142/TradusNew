package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileOtomotoProfiLMSPage {
	
	RemoteWebDriver driver = null;
	
	@FindBy(xpath = "//span[@class='multiselect__single']")
	public List<WebElement> countrySelected;

	@FindBy(xpath = "//label[text()='VAT number']/following-sibling::div//input")
	public WebElement VATTextField;

	@FindBy(xpath = "//label[text()='Company name']/following-sibling::div//input")
	public List<WebElement> companyNameTextField;

	@FindBy(xpath = "//label[text()='Address']/following-sibling::div//input")
	public List<WebElement> addressTextField;

	@FindBy(xpath = "//label[text()='City']/following-sibling::div//input")
	public List<WebElement> cityTextField;

	@FindBy(xpath = "//label[text()='ZIP code']/following-sibling::div//input")
	public List<WebElement> zipcodeTextField;

	@FindBy(xpath = "//label[text()='Contact person']/following-sibling::div//input")
	public WebElement contactPersonTextField;

	@FindBy(xpath = "//label[text()='Phone']/following-sibling::div//input")
	public List<WebElement> phoneTextField;

	@FindBy(xpath = "//label[text()='Mobile phone']/following-sibling::div//input")
	public WebElement mobilePhoneTextField;

	@FindBy(xpath = "//label[text()='Website']/following-sibling::div//input")
	public WebElement websiteTextField;

	@FindBy(xpath = "//h4[contains(.,'Billing information')]/parent::div//input[@class='input-switch vs-switch--input']")
	public WebElement billingInofrmationCheckBox;

	@FindBy(xpath = "//label[text()='Email']/following-sibling::div//input")
	public WebElement billingInfoEmailTextField;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement chooseFileButtonInDetailsTab;

	@FindBy(xpath = "//span[text()= 'Upload ']/parent::button")
	public WebElement uploadButtonInDetailsTab;

	@FindBy(xpath = "//div[@class='con-img vs-avatar--con-img']//img")
	public WebElement logoInProfilePage;

	@FindBy(xpath = "//label[text()='Company name']/parent::div/following-sibling::span")
	public List<WebElement> companyNameFieldDangerText;

	@FindBy(xpath = "//label[text()='Address']/parent::div/following-sibling::span")
	public WebElement AddressFieldDangerText;

	@FindBy(xpath = "//label[text()='City']/parent::div/following-sibling::span")
	public WebElement CityFieldDangerText;

	@FindBy(xpath = "//label[text()='ZIP code']/parent::div/following-sibling::span")
	public WebElement zipCodeFieldDangerText;

	@FindBy(xpath = "//label[text()='Contact person']/parent::div/following-sibling::span")
	public WebElement contactPersonFieldDangerText;

	@FindBy(xpath = "//label[text()='Phone']/parent::div/following-sibling::span")
	public List<WebElement> phoneFieldDangerText;

	@FindBy(xpath = "//label[text()='Mobile phone']/parent::div/following-sibling::span")
	public WebElement mobilePhoneFieldDangerText;

	@FindBy(xpath = "//label[text()='Website']/parent::div/following-sibling::span")
	public WebElement websiteFieldDangerText;

	@FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::span")
	public WebElement emailFieldDangerText;

	@FindBy(xpath = "//button[text()='Save changes ']")
	public WebElement saveChangesButtonUnderDetails;

	@FindBy(xpath = "//span[text()='Settings']/parent::button")
	public WebElement settingsTab;
	
	@FindBy(xpath = "//span[text()='Details']/parent::button")
	public WebElement detailsTab;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Email']")
	public WebElement EmailHeadingInsettingsTab;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Email']/following-sibling::div")
	public WebElement givenEmailInsettingsTab;

	@FindBy(xpath = "//div[text()='Spoken languages']")
	public WebElement spokenLanguagesTitleInSettings;

	@FindBy(xpath = "//div[contains(text(), 'indicate the languages')]")
	public WebElement spokenLanguagesSubTitleInSettings;

	@FindBy(xpath = "//div[@id='profile-settings']//div[contains(text(),'Spoken languages')]/parent::div/parent::div")
	public WebElement spokenLanguagesFieldInSettings;

	@FindBy(xpath = "//div[@id='profile-settings']//div[contains(text(),'Spoken languages')]/parent::div/parent::div//div[@class='multiselect w-full']")
	public WebElement spokenLanguagesDropdownInSettings;

	@FindBy(xpath = "//div[text()='Spoken languages']/parent::div/parent::div//span[text()='Nederlands']")
	public WebElement NederlandsLanguageInSettingsSpokenLanguageDropdown;

	@FindBy(xpath = "//div[text()='Spoken languages']/parent::div/following-sibling::div//button[text()='Save change ']")
	public WebElement saveChangeButtonForSpokenLanguages;

	@FindBy(xpath = "//div[@id='profile-settings']//span[contains(text(),'Select spoken')]")
	public WebElement spokenLanguage;

	@FindBy(xpath = "//span[contains(text(), 'spoken languages')]/parent::div/following-sibling::div//ul//li")
	public List<WebElement> spokenLanguagesDropdownList;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Language']")
	public WebElement LanguageHeadingInsettingsTab;

	@FindBy(xpath = "//div[contains(text(), 'preferred language')]")
	public WebElement LanguageSubHeadingInsettingsTab;

	@FindBy(xpath = "//div[@id='profile-settings']//select[contains(@class, 'block appearance-none')]")
	public WebElement languagesDropdownInSettings;

	@FindBy(xpath = "//div[contains(text(), 'Language')]/parent::div/following-sibling::div//select//option")
	public List<WebElement> languagesDropdownList;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Language']/parent::div/following-sibling::div//div//div[2]//button")
	public WebElement saveChangeButtonForLanguages;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='La langue']/parent::div/following-sibling::div//div//div[2]//button")
	public WebElement saveChangeButtonForLanguagesInFrance;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Taal']/parent::div/following-sibling::div//div//div[2]//button")
	public WebElement saveChangeButtonForLanguagesInNederlands;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Password']")
	public WebElement passwordChangeHeading;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Change your password']")
	public WebElement passwordChangeSubHeading;

	@FindBy(xpath = "//div[@id='profile-settings']//input[@name='password']")
	public WebElement passwordFieldInSettings;

	@FindBy(xpath = "//div[@id='profile-settings']//input[@name='password_confirmation']")
	public WebElement confirmPasswordFieldInSettings;

	@FindBy(xpath = "//div[@id='profile-settings']//div[text()='Password']/parent::div/following-sibling::div//div//div[3]//button")
	public WebElement saveChangeButtonForPasswordChange;

	@FindBy(xpath = "//div[@class='con-text-noti']")
	public WebElement successMessageUponChangingSettings;

	@FindBy(xpath = "//a[text()=' Export personal data ']")
	public WebElement exportPersonalDataLinkInSettings;

	@FindBy(xpath = "//a[text()=' Delete account ']")
	public WebElement deleteAccountLinkInSettings;

	@FindBy(xpath = "//h1[text()='How can we help you?']")
	public WebElement zendeskVerificationElement;

	@FindBy(xpath = "//div[@class='vx-col sm:w-2/3 w-full mb-4']//div//div[3]//ul//li")
	public List<WebElement> ExtraservicesDropdownList;

	@FindBy(xpath = "//span[text()='Delivery possible']/parent::span")
	public WebElement deliveryPossibleInExtraServicesDropdown;

	@FindBy(xpath = "//h3[text()=' Extra services that you provide ']/parent::header/parent::div//button[text()='Save change ']")
	public WebElement saveChangeButtonForExtraServicesDropdown;

	@FindBy(xpath = "//h2[contains(text(),'Profile')]")
	public WebElement profilePageVerificationElement;

	@FindBy(xpath = "//header[contains(@class, 'vs-navbar')]//button[contains(@class, 'parent-dropdown cursor-pointer')]")
	public WebElement profileIconOnHeader;

	@FindBy(xpath = "//div[contains(@class, 'vs-dropdown--menu')]//li[2]")
	public WebElement logoutOptionInProfileIconDropdown;

	@FindBy(xpath = "//h4[text()='Log in']")
	public WebElement LoginText;

	@FindBy(xpath = "//h2[text()='Services']")
	public WebElement ServicesHeading;

	@FindBy(xpath = "//h3[text()=' Extra services that you provide ']")
	public WebElement ServicesSubHeading;

	@FindBy(xpath = "//h2[text()='Services']/parent::header/parent::div//div[@class='multiselect__select']")
	public WebElement ServicesDropdown;

	@FindBy(xpath = "//h2[text()='Services']/parent::header/parent::div//div[@class='multiselect__tags']//span[@class='multiselect__tag']")
	public List<WebElement> SelectedServicesList;

	@FindBy(xpath = "//h2[text()='Services']/parent::header/parent::div//div[@class='multiselect__tags']//i")
	public WebElement CrossIconOnSelectedServices;

	@FindBy(xpath = "//div[@class='vx-col sm:w-2/3 w-full mb-4']//div//div[3]//ul//li[@class='multiselect__element']")
	public List<WebElement> ServicesDropdownList;

	@FindBy(xpath = "//a[text()='Show details about the extra services']")
	public WebElement ShowDetailsLinkUnderServices;

	@FindBy(xpath = "//a[text()='Show details about the extra services']/following-sibling::div//ul//li")
	public List<WebElement> ServicesListUnderShowDetails;

	@FindBy(xpath = "//li[contains(text(), 'This seller offers video call or online consulting.')]")
	public WebElement OnlineConsultingServiceUnderShowDetails;
	
	@FindBy(xpath = "//input[@name='request[anonymous_requester_email]']")
	public WebElement sendRqstPageElement;
	
	@FindBy(xpath = "//img[@alt='user-img']/ancestor::button/preceding::div//p[@class='font-semibold']")
	public WebElement userNameInHeader;

	public ProfileOtomotoProfiLMSPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/profile");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doLogIn(String UserName, String Password) throws Exception {
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.emailNameElement)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.emailNameElement);
		 }
		 cmdObj.login(UserName,Password);
		 explicitWaitFortheElementTobeVisible(driver,cmdObj.overviewUserDropdown);
	}

}
