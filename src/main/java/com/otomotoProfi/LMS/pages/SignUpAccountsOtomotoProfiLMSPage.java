package com.otomotoProfi.LMS.pages;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpAccountsOtomotoProfiLMSPage {
	
	RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//div[@class='wizard-icon-container']")
	public WebElement tabInfo;
	
	@FindBy(xpath = "//h4[contains(.,'2. Create an account')]")
	public WebElement accountsPageVerificationElement;
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='email']")
	public WebElement emailField;
	
	@FindBy(xpath = "//form[@data-vv-scope]//input[@name='password']")
	public WebElement passWordField;
	
	@FindBy(xpath = "//input[@name='agreed']/ancestor::div[@class='mt-4']")
	public WebElement acceptacneCheckBoxSection;
	
	@FindBy(xpath = "//input[@name='agreed']")
	public WebElement agreeCheckBox;
	
	@FindBy(xpath = "//div[@class='wizard-card-footer clearfix']//div[contains(@class,'left')]")
	public WebElement backButton;
	
	@FindBy(xpath = "(//div[@class='wizard-card-footer clearfix']//div[contains(@class,'right')])[1]")
	public WebElement nextButton;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div")
	public WebElement monthlyCostSection;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Package']/parent::div//p")
	public WebElement numberOfAdsperPackageUnderMonthlyCost;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()=' Billing frequency ']/parent::div//p")
	public WebElement billingFrequencyUnderMonthlyCost;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Price']/parent::div//p")
	public WebElement priceUnderMonthlyCost;
	
	@FindBy(xpath = "//h2[text()='Monthly cost']/parent::div//div[text()='Package']/parent::div//a")
	public WebElement changePackageUnderMonthlyCost;
		
	@FindBy(xpath = "//input[@name='email']/../../..//div[contains(@class,'text-danger')]")
	public WebElement emailFieldDangerText;

	@FindBy(xpath = "//input[@name='password']/../../..//div[contains(@class,'text-danger')]")
	public WebElement passWordFieldDangerText;
	
	@FindBy(xpath = "//input[@name='agreed']/../../..//div[contains(@class,'text-danger')]")
	public WebElement agreeCheckBoxError;
	
	@FindBy(xpath = "//h1[contains(.,'Aktualny Regulamin')]")
	public WebElement termsPageVerify;
	
	@FindBy(xpath = "//h1[contains(.,'Polityka prywatności')]")
	public WebElement privacyPageVerify;
	
	@FindBy(xpath = "//h1[contains(.,'Polityka Plików Cookies i Podobnych Technologii')]")
	public WebElement cookiesPageVerify;
	
	@FindBy(xpath = "//input[@name='agreed']/../..//a")
	public WebElement termsOfUseLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[1]")
	public WebElement privacyLink;

	@FindBy(xpath = "//input[@name='agreed']/../../../div[3]//a[2]")
	public WebElement coockiesLink;
	
	@FindBy(xpath = "//h4[contains(.,'3. Account details')]")
	public WebElement detailsPageVerificationElement;
	
	@FindBy(xpath = "//input[@name='email']/../../..//div[contains(@class,'text-danger')]/a")
	public WebElement goToSignInPageErrorLinkOnEnteringRegisteredEmail;
	
	
	public SignUpAccountsOtomotoProfiLMSPage(RemoteWebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void gotoDetailsPage(RemoteWebDriver driver, String packageType, String username, String pwd) throws Exception {
		SignUpPackageOtomotoProfiLMSPage obj=new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage obj2=new SignUpAccountsOtomotoProfiLMSPage(driver);
		//waitTill(2000);
		obj.gotoAccountsPage(driver, packageType);
		explicitWaitFortheElementTobeVisible(driver,obj2.emailField);
		sendKeys(obj2.emailField,username);
		sendKeys(obj2.passWordField,pwd);
		try {
			click(obj2.agreeCheckBox);
		}catch (Exception E) {
			jsClick(driver,obj2.agreeCheckBox);
		}
		
		explicitWaitFortheElementTobeVisible(driver,obj2.nextButton);
		//waitTill(2000);
		try {
			click(obj2.nextButton);
		}catch (Exception E) {
			jsClick(driver,obj2.nextButton);
		}
	}
}
