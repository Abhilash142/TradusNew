package com.tradus.pro.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.tradus.core.ActionElementClass.loadUrl;

public class LandingTradusProPage {
RemoteWebDriver driver = null;
	
	@FindBy(xpath= "//header[@class='app-header']//span[text()='Sell on Tradus']")
	public WebElement SellOnTradusButtonOnTcomHeader;
	
	@FindBy(xpath= "//footer[@class='app-footer']//a[text()='Start selling on Tradus']")
	public WebElement SellOnTradusButtonOnTcomFooter;
	
	@FindBy(xpath= "//img[@alt='Tradus']")
	public WebElement TradusLogo;
	
	@FindBy(xpath= "//section[@class='hero bg-grey-brown']//img[@alt='Tradus']")
	public WebElement TProLogoOnHeader;
	
	@FindBy(xpath= "//footer[@class='bg-black py-16 lg:py-24']//img[@alt='Tradus']")
	public WebElement TProLogoOnFooter;
	
	@FindBy(xpath= "//footer[@class='bg-black py-16 lg:py-24']//img[@alt='Tradus']]")
	public WebElement TcomLinkOnFooter;
	
	@FindBy(xpath= "//footer[@class='bg-black py-16 lg:py-24']//nav[@class='flex flex-wrap']//li//a")
	public List<WebElement> HelpLinksListOnFooter;
	
	@FindBy(xpath= "//footer[@class='bg-black py-16 lg:py-24']//div[text()='© Tradus 2020']")
	public WebElement CopyrightsTextOnFooter;
	
	@FindBy(xpath= "//div[contains(@class, 'footer__social')]//a")
	public List<WebElement> SocialSitesListOnFooter;
	
	@FindBy(xpath= "//h1[text()=' Terms of Use']")
	public WebElement TermsOfUsePageVerificationElement;
	
	@FindBy(xpath= "//h1[text()='How can we help you?']")
	public WebElement HelpPageVerificationElement;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//a[@href='#benefits']")
	public WebElement BenefitsLink;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//a[@href='#testimonials']")
	public WebElement TestimonialsLink;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//a[@href='#pricing']")
	public WebElement PricingLink;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//a[@href='#signup']")
	public WebElement SignupNowLink;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//div[contains(@class, 'ml-4 xl:ml-auto')]//a[@href='/login']")
	public WebElement LoginLink;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__nav')]//button[contains(@class, 'vs-con-dropdown')]")
	public WebElement LanguagesDropdown;
	
	@FindBy(xpath= "//img[@alt='Tradus PRO']")
	public WebElement BackgroundImage;
	
	@FindBy(xpath= "//div[contains(@class, 'hero__intro text')]//a[text()='Start selling on Tradus']")
	public WebElement StartSellingOnTradusButtonOnTop;
	
	@FindBy(xpath = "//h4[contains(.,'1. Please select your plan')]")
	public WebElement packagePageVerificationElement;
	
	@FindBy(xpath= "//h4[text()='Log in']")
	public WebElement LoginPageVerificationElement;
	
	@FindBy(xpath= "//h2[text()=' Our Categories ']")
	public WebElement CategoriesSectionHeading;
	
	@FindBy(xpath= "//h2[text()=' Our Categories ']/following-sibling::ul//li//div")
	public List<WebElement> CategoriesIconsListBesideOurCategoriesText;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//h3[text()=' Intelligent tools & data ']")
	public WebElement IntelligentToolsAnddataInfoHeading;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//h4[text()=' Sell smarter than your competitors ']")
	public WebElement IntelligentToolsAnddataInfoTagLine;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//p[contains(text(), 'customers receive real-time data')]")
	public WebElement IntelligentToolsAnddataInfo;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//img[@alt='Intelligent tools & data']")
	public WebElement IntelligentToolsAnddataImage;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap md:flex-row-reverse mt-16 md:mt-32']//h3[text()=' Heavy machinery only ']")
	public WebElement HeavyMachinaryOnlyHeading;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap md:flex-row-reverse mt-16 md:mt-32']//h4[text()=' More tools to meet your needs ']")
	public WebElement HeavyMachinaryOnlyInfoTagline;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap md:flex-row-reverse mt-16 md:mt-32']//p")
	public WebElement HeavyMachinaryOnlyInfo;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap md:flex-row-reverse mt-16 md:mt-32']//img[@alt='Heavy machinery only']")
	public WebElement HeavyMachinaryOnlyInfoImage;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//h3[text()=' Easy international trade ']")
	public WebElement EasyInternationalTradeInfoHeading;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//h4[text()= ' Communicate with buyers anywhere ']")
	public WebElement EasyInternationalTradeInfoTagline;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//p[contains(text(),'We market your listings for you: across')]")
	public WebElement EasyInternationalTradeInfo;
	
	@FindBy(xpath= "//div[@class='benefits__item flex flex-wrap mt-16 md:mt-32']//img[@alt='Communicate with buyers anywhere']")
	public WebElement EasyInternationalTradeInfoImage;
	
	@FindBy(xpath= "//div[@class='text-center mt-16 md:mt-24']//a[text()='Sign up now']")
	public WebElement SignUpButton;
	
	@FindBy(xpath= "//section[@id='testimonials']//div[@role='tabpanel']")
	public List<WebElement> TestimonialsList;
	
	@FindBy(xpath= "//section[@id='testimonials']//div[contains(@class, 'VueCarousel-slide VueCarousel-slide-active')]")
	public List<WebElement> TestimonialsListInASlide;
	
	@FindBy(xpath= "//section[@id='testimonials']//button[@aria-label='Next page']")
	public WebElement NextIconInTestinominals;
	
	@FindBy(xpath= "//section[@id='testimonials']//button[@aria-label='Previous page']")
	public WebElement PreviousIconInTestinominals;
	
	@FindBy(xpath= "//span[contains(.,'Success stories')]/../..")
	public WebElement TestimonialsHeading;
	
	@FindBy(xpath= "//section[@id='testimonials']//div[@role='tablist']")
	public WebElement TestimonialsTablist;
	
	@FindBy(xpath= "//span[text()='Benefits of selling on Tradus PRO']")
	public WebElement BenefitsHeadng;
	
	@FindBy(xpath= "//span[text()='Plans and pricing']")
	public WebElement PlansAndPricingHeading;
	
	@FindBy(xpath= "//a[text()='CONTACT SALES']")
	public WebElement ContactSalesButton;
	
	@FindBy(xpath= "//a[text()='Get support']")
	public WebElement GetSupportButton;
	
	@FindBy(xpath= "//section[@id='signup']//span[text()='Signup is easy!']")
	public WebElement SignupIsEasyHeading;
	
	@FindBy(xpath= "//span[text()='Signup is easy!']/ancestor::div//ul[@class='signup__advantages text-xl md:text-2xl']//li")
	public List<WebElement> SignupAdvantagesList;
	
	@FindBy(xpath= "//span[text()='Signup is easy!']/ancestor::div//ul[contains(@class, 'signup__integrators grid')]//li")
	public List<WebElement> SignupCRMInfoLst;
	
	@FindBy(xpath= "//section[@id='signup']//a[text()='Start selling on Tradus']")
	public WebElement StartSelleingOnTradusButtonInSignupSection;
	
	@FindBy(xpath= "//section[@id='pricing']//div[contains(@class, 'plans__item md:flex-1 ')]")
	public List<WebElement> PlansListUnderPlansAndPricing;
	
	@FindBy(xpath= "//section[@id='pricing']//h2[@class='text-2xl md:text-4xl font-extrabold mb-4']")
	public List<WebElement> PlansTitlesListUnderPlansAndPricing;
	
	@FindBy(xpath= "//section[@id='pricing']//a[text()='Start selling on Tradus']")
	public WebElement StartSelleingOnTradusButtonInPlansAndPicing;
	
	@FindBy(xpath= "//i[text()='close']")
	public WebElement CloseIcon;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='name']")
	public WebElement FullNameInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='email']")
	public WebElement EmailInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//input[@name='phone']")
	public WebElement PhoneInputFieldInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//span[contains(.,'Send request')]")
	public WebElement SubmitButtonInSupportForm;
	
	@FindBy(xpath= "//div[@class='p-8']//p[contains(text(), 'message has been successfully sent.')]")
	public WebElement SuccessmessageofSupportForm;
	
	public LandingTradusProPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://pro.tradus.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
