package com.tradus.pro.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.waitForElement;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPackageSectionTradusPROPage {

   RemoteWebDriver driver = null;
   
   @FindBy(xpath = "//form[@data-vv-scope='step-1']//input[@name='email']")
	public WebElement initialPageEmailField;
	
	/*@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/h4")
	public WebElement companyPackageSectionHeading;*/
	
	@FindBy(xpath = "//form[@data-vv-scope]/h4")
	public WebElement companyPackageSectionHeading;
	
	@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/div[1]")
	public WebElement companyFirstPackage;
	
	@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/div[2]")
	public WebElement companySecondPackage;
	
	@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/div[3]")
	public WebElement companyThirdPackage;
	
	@FindBy(xpath = "(//input[@name='selected-package'])[1]")
	public WebElement companyFirstPackageRadioButton;
	
	@FindBy(xpath = "(//input[@name='selected-package'])[2]")
	public WebElement companySecondPackageRadioButton;
	
	@FindBy(xpath = "(//input[@name='selected-package'])[3]")
	public WebElement companyThirdPackageRadioButton;
	
	@FindBy(xpath = "//span[text()='Tradus Basic 10']")
	public WebElement companyFirstPackageName;
	
	@FindBy(xpath = "//span[text()='Tradus Basic 25']")
	public WebElement companySecondPackageName;
	
	@FindBy(xpath = "//span[text()='Tradus Basic 70']")
	public WebElement companyThirdPackageName;
	
	@FindBy(xpath = "//p[text()=' Up to 10 active adverts ']")
	public WebElement companyFirstPackageOffersText;
	
	@FindBy(xpath = "//p[text()=' Up to 25 active adverts ']")
	public WebElement companySecondPackageOffersText;
	
	@FindBy(xpath = "//p[text()=' Up to 70 active adverts ']")
	public WebElement companyThirdPackageOffersText;
	
	@FindBy(xpath = "//p[text()=' Up to 10 active adverts ']/..//p[text()='50 EUR']")
	public WebElement companyPriceOnFirstPackage;
	
	@FindBy(xpath = "//p[text()=' Up to 25 active adverts ']/..//p[text()='100 EUR']")
	public WebElement companyPriceOnSecondPackage;
	
	@FindBy(xpath = "//p[text()=' Up to 70 active adverts ']/..//p[text()='250 EUR']")
	public WebElement companyPriceOnThirdPackage;
	
	@FindBy(xpath = "//div[@class='vx-card__body']/div/p")
	public WebElement companyPackageSectionContent;
	
	@FindBy(xpath = "//div[@class='vx-card__body']//div[@class='getHelp']")
	public WebElement companyPackageSectionSendRequestButton;
	
	@FindBy(xpath = "//form[@data-vv-scope='step-3']/div/div[1]")
	public WebElement privateSinglePackage;
	
	@FindBy(xpath = "//input[@name='selected-package']")
	public WebElement privatePackageRadioButton;
	
	@FindBy(xpath = "//span[text()='Tradus Single 1']")
	public WebElement privatePackageName;
	
	@FindBy(xpath = "//p[text()=' Up to 1 active adverts ']")
	public WebElement privatePackageOffersText;
	
	@FindBy(xpath = "//p[text()=' Up to 1 active adverts ']/..//p[text()='8 EUR']")
	public WebElement privatePriceOnPackage;
	
	@FindBy(xpath = "//div[@class='wizard-footer-left']")
	public WebElement backButton;
	
	@FindBy(xpath = "//div[@class='wizard-footer-right']")
	public WebElement nextButton;
	
	/*@FindBy(xpath ="//div[@class='vx-col w-6/6']/..")
	public List<WebElement> numberOfPackagesAvailable;*/
	
	@FindBy(xpath ="//span[contains(.,'Tradus')]/ancestor::div[contains(@class,'vx-col w-full flex items')]")
	public List<WebElement> numberOfPackagesAvailable;
	
	@FindBy(xpath ="//form[@data-vv-scope='step-3']//span[contains(text(),'Tradus')]")
	public List<WebElement> PackageTypeText;
	
	@FindBy(xpath ="(//div[@class='vx-col w-6/6'])//div//p[contains(text(),'active adverts')]")
	public List<WebElement> PackagenumberOfOfferText;
	
	@FindBy(xpath ="(//div[@class='vx-col w-6/6'])//div//p[@class='text-sm']")
	public List<WebElement> PackageDurationText;
	
	@FindBy(xpath ="(//div[@class='vx-col w-6/6'])//div//p[contains(text(),'EUR')]")
	public List<WebElement> PackagePriceText;
	
	@FindBy(xpath = "//input[@name='selected-package']")
	public List<WebElement> companyPackageRadioButtons;
	
	
	public SignUpPackageSectionTradusPROPage(RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void autoNavigateToCompanyPackagePage()throws Exception
	{
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		signUpObj.setAccountUsernameAndPassword();
		waitTill(4000);
		waitForElement(signUpObj.detailsCountryText);
		if(!getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands")) {
			List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
					.collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(signUpObj.detailsCountryDropdown);
			waitTill(2000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
		}
		sendKeys(signUpObj.detailsVATNoTextField,"NL854502130B01");
		waitTill(5000);
		sendKeys(signUpObj.detailsContactPersonTextField,"Harish");
		sendKeys(signUpObj.detailsCompanyWebsiteTextField, "http://www.sunfra.com/");
		sendKeys(signUpObj.detailsPhoneTextField,"777 888999");
		sendKeys(signUpObj.detailsMobilePhoneTextField,"612345678");
		/*
		 * waitTill(4000); jsClick(driver,signUpObj.detailsAvailableOnWhatsAppCheckbox);
		 */
		waitTill(2000);
		try {
			click(signUpObj.detailsNextbutton);
		} catch (Exception e) {
			jsClick(driver, signUpObj.detailsNextbutton);
		}
	}

   public void autoNavigateToPrivatePackagePage()throws Exception
   {
	    SignupTPROPage signUpObj = new SignupTPROPage(driver);
		waitTill(2000);
		jsClick(driver,signUpObj.privateRadioButton);
		waitTill(1000);
		signUpObj.setAccountUsernameAndPassword();
		waitTill(4000);
		waitForElement(signUpObj.detailsCountryText);
		if(!getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands")) {
			List<WebElement> listOfCountries = signUpObj.countryDropdownvaluesInnerHtml;
			ArrayList<String> listOfCOuntriesNames = listOfCountries.stream().map(c -> c.getAttribute("innerHTML").trim())
					.collect(Collectors.toCollection(ArrayList::new));
			int randomInt = listOfCOuntriesNames.indexOf("Netherlands");
			click(signUpObj.detailsCountryDropdown);
			waitTill(2000);
			click(listOfCountries.get(randomInt));
			waitTill(2000);
		}
		sendKeys(signUpObj.detailsPrivateFullNameTextField,"Harish");
		sendKeys(signUpObj.detailsCityTextField,"AMSTERDAM");
		sendKeys(signUpObj.detailsCompanyAddressTextField,"WIBAUTSTRAAT 00137 C");
		sendKeys(signUpObj.detailsCompanyZIPTextField,"1097DN");
		sendKeys(signUpObj.detailsPhoneTextField,"777888999");
		waitTill(1000);
		jsClick(driver,signUpObj.detailsNextbutton);
   }
	
}
