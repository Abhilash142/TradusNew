package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

//import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.LandingTradusProPage;

public class LandingTradusProTest extends BaseClass{
	/*
	 * Description: Verify TPRO langing page is displaying on clicking the logo in
	 * sign up process
	 */
	@Test
	public void verifyTproLandingPageIsDisplayingByClickingTheLogoInSignupProcess() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		loadUrl(driver, "https://pro.tradus.com/signup");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TradusLogo);
		jsClick(driver, LandingPage.TradusLogo);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/"),
				"Landing page not displaying by clicking on logo in signup process");
	}
	
	/*
	 * Description: Verify TPRO logo, Benfits, Testimonals, Pricing, sign up now,
	 * login and languages drop down are displaying on top
	 */
	@Test
	public void verifyTproLogoBenefitsTestimonialsPricingSignUpNowLoginAndLanguagesDropdownAreDisplayingOnTop()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TradusLogo);
		
		Assert.assertTrue(verifyElementPresent(LandingPage.TradusLogo),
				"Tradus pro logo is not displaying in landing page");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.BenefitsLink),
				"Benefits link is not displaying in landing page");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TestimonialsLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.TestimonialsLink),
				"Testimonials link is not displaying in landing page");
		/*explicitWaitFortheElementTobeVisible(driver, LandingPage.PricingLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.PricingLink),
				"Pricing link is not displaying in landing page");*/
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SignupNowLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.SignupNowLink),
				"Signup now link is not displaying in landing page");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.LoginLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.LoginLink), "Login link is not displaying in landing page");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.LanguagesDropdown);
		Assert.assertTrue(verifyElementPresent(LandingPage.LanguagesDropdown),
				"Languages Dropdown is not displaying in landing page");
	}
	
	/*
	 * Description: Verify redirecting to respective sections on clicking Benfits,
	 * Testimonals, Pricing, sign up now and login links
	 
	@Test
	public void verifyRedirectingToRespectiveSectionsOnClickingBenefitsTestimonalsPicingSignUpNowAndLoginLinks()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		waitTill(3000);
		jsClick(driver, LandingPage.BenefitsLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#benefits"),
				"Not redirected to benefits section by clicking benefits link on top of the landing page");
		Long value1 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.CategoriesSectionHeading.getLocation().getY() <= value1+150
						&& value1-150 <= LandingPage.SignUpButton.getLocation().getY(),
				"Not redirected to benefits section by clicking benefits link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.TestimonialsLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#testimonials"),
				"Not redirected to testimonials section by clicking testimonials link on top of the landing page");
		Long value2 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.SignUpButton.getLocation().getY() <= value2+150
						&& value2-150 <= LandingPage.TestimonialsTablist.getLocation().getY(),
				"Not redirected to testimonials section by clicking testimonials link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.PricingLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#pricing"),
				"Not redirected to pricing section by clicking pricing link on top of the landing page");
		Long value3 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.StartSelleingOnTradusButtonInSignupSection.getLocation().getY() <= value3+150
						&& value3-150 <= LandingPage.ContactSalesButton.getLocation().getY(),
				"Not redirected to pricing section by clicking pricing link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.SignupNowLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#signup"),
				"Not redirected to signup section by clicking signup link on top of the landing page");
		Long value4 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.TestimonialsTablist.getLocation().getY() <= value4+150
						&& value4-150 <= LandingPage.StartSelleingOnTradusButtonInSignupSection.getLocation().getY(),
				"Not redirected to signup section by clicking signup link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.LoginLink);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.LoginPageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/login"),
				"Not redrected to Login page by clicking login link on top of the landing page");
		waitTill(3000);
	}*/
	/*
	 * Description: "Verify page is redirecting to sign up page on clicking 'Start
	 * selling on Tradus' link below 'THE SMART WAY TO TRADE HEAVY MACHINERY' text"
	 */
	@Test
	public void verifyPageRedirectingToSignupPageOnClickingStartSellingOnTradusLinkBelowTheSmartWayToTradeMachinaryText()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.StartSellingOnTradusButtonOnTop);
		jsClick(driver, LandingPage.StartSellingOnTradusButtonOnTop);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.packagePageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).contentEquals("https://pro.tradus.com/signup"),
				"Signup page is not displaying on clicking start selling on tradus link below the smart way to trade machinary text");
	}
	/*
	 * Description: Verify Transport, Farm, Construction and Material handling
	 * equipment category icons are displaying beside 'OUR CATEGORIES' text
	 */
	@Test
	public void verifyAllCategoriesIconsAreDisplayingBesideOurCategoriesText() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertEquals(LandingPage.CategoriesIconsListBesideOurCategoriesText.size(), 4,
				"4 Categories icons are not displaying beside our categories text for all categories");
	}
	/*
	 * Description: Verify 'intellignet tools and data', 'Heavy machineary info' and
	 * 'Easy internation trade' info's along with images are displaying
	 */
	@Test
	public void verifyIntelligentToolsAndDataHeavyMachinaryInfoAndEasyInternationalTradeInfosAlongWithImagesAreDisplaying()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertTrue(verifyElementPresent(LandingPage.IntelligentToolsAnddataInfoHeading),
				"Intelligent tools & data info heading is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.IntelligentToolsAnddataInfoTagLine),
				"Intelligent tools & data info tag line is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.IntelligentToolsAnddataInfo),
				"Intelligent tools & data info is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.IntelligentToolsAnddataImage),
				"Intelligent tools & data info image is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.HeavyMachinaryOnlyHeading),
				"Heavy machinary only info heading is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.HeavyMachinaryOnlyInfoTagline),
				"Heavy machinary only info tag line is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.HeavyMachinaryOnlyInfo),
				"Heavy machinary only info is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.HeavyMachinaryOnlyInfoImage),
				"Heavy machinary only info image is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.EasyInternationalTradeInfoHeading),
				"Easy international trading info heading is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.EasyInternationalTradeInfoTagline),
				"Easy international trading info tagline is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.EasyInternationalTradeInfo),
				"Easy international trading info is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.EasyInternationalTradeInfoImage),
				"Easy international trading info image is not displaying in landing page");
	}
	
	/*
	 * Description: Verify sign up and CRM info below 'SIGNUP IS EASY!'
	 */
	@Test
	public void verifySignUpAndCRMInfoBelowSignUpIsEasy() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SignupIsEasyHeading);
		Assert.assertTrue(verifyElementPresent(LandingPage.SignupIsEasyHeading),
				"Signup is easy heading is not displaying in signup section in landing page");
		Assert.assertEquals(LandingPage.SignupAdvantagesList.size(), 2,
				"Expected count of advantages in signup section is not displaying in landing page");
		Assert.assertEquals(LandingPage.SignupCRMInfoLst.size(), 10,
				"Expected count of signup CRM list is not displaying in signup section in landing page");
		for (int i = 0; i < LandingPage.SignupCRMInfoLst.size(); i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).contentEquals("AutoAct (Mobile .de)"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 1:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Autodata (CRM)"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 2:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("AutoDo"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 3:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Hexon"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 4:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Linemedia (Autoline)"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 5:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("TruckDelta (TNLbusiness .nl)"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 6:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("TwoSales"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 7:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Vehisell"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 8:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Webmobile24"),
						"Expected signup CRM list is not displaying in signup section in landing page");
				break;
			case 9:
				Assert.assertTrue(getText(LandingPage.SignupCRMInfoLst.get(i)).equals("Wheelerdelta"),
						"Expected signup CRM list is not displaying in signup section in landing page");
			}
		}

	}
	/*
	 * Description: Verify Maximum adverts count, Price and Excluding VAT info is
	 * displaying on the plans
	 */
	@Test
	public void verifyMaximumAdvertsCountPriceAndExcludingVATInfoIsDisplayingOnPlans() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		for (int i = 0; i < LandingPage.PlansListUnderPlansAndPricing.size(); i++) {
			if (i == 0) {

				String pkgtext = getText(LandingPage.PlansListUnderPlansAndPricing.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 10, Up to, 10 active adverts, 50 EUR, per month (Excl. VAT)"),
						"Tradus Basic 10 attributes are not dislayed");
			} else if (i == 1) {
				String pkgtext = getText(LandingPage.PlansListUnderPlansAndPricing.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 25, Up to, 25 active adverts, 100 EUR, per month (Excl. VAT)"),
						"Tradus Basic 25 attributes are not dislayed");
			} else {
				String pkgtext = getText(LandingPage.PlansListUnderPlansAndPricing.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 70, Up to, 70 active adverts, 250 EUR, per month (Excl. VAT)"),
						"Tradus Basic 70 attributes are not dislayed");
			}
		}
	}
	/*
	 * Description: Verify the success message after submitting the form
	 */
	/*@Test
	public void verifySuccessMessageAfterSubmittingTheSupportForm() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.ContactSalesButton);
		jsClick(driver, LandingPage.ContactSalesButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.FullNameInputFieldInSupportForm);
		sendKeys(LandingPage.FullNameInputFieldInSupportForm, "Testing");
		sendKeys(LandingPage.EmailInputFieldInSupportForm,userName);
		sendKeys(LandingPage.PhoneInputFieldInSupportForm, "31777888999");
		jsClick(driver, LandingPage.SubmitButtonInSupportForm);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SuccessmessageofSupportForm);
		Assert.assertTrue(
				getText(LandingPage.SuccessmessageofSupportForm).equals(
						"Your message has been successfully sent. One of our team members will contact you soon."),
				"Expected success message not displaying bu submitting the support form");
		waitTill(3000);
	}*/
	
	/*
	 * Description: Ensure all the links in footer are redirecting to Tradus.com
	 * pages (EX: Help pages, social links)
	 */
	//@Test
	public void verifyAllFooterHelpLinksAreRedirectingToRespctivePages() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TProLogoOnFooter);
		Assert.assertEquals(LandingPage.HelpLinksListOnFooter.size(), 4,
				"Expected number of help links are not dislaying on footer in landing page");
		for (int i = 0; i < LandingPage.HelpLinksListOnFooter.size(); i++) {
			waitTill(2000);
			jsClick(driver, LandingPage.HelpLinksListOnFooter.get(i));

			switch (i) {
			case 0:
				String parentWindow = driver.getWindowHandle();
				switchWindow(driver, parentWindow);
				explicitWaitFortheElementTobeVisible(driver, LandingPage.SellOnTradusButtonOnTcomHeader);
				Assert.assertTrue(getCurrentUrl(driver).equals("https://www.tradus.com/"),
						"Page not redirected tcom home page by clicking on For buyers: Tradus.com link on footer in landing page");
				break;
			case 1:
				explicitWaitFortheElementTobeVisible(driver, LandingPage.HelpPageVerificationElement);
				Assert.assertTrue(
						getCurrentUrl(driver).equals("https://help.tradus.com/hc/en-us/articles/360010639878-New-Terms-of-Use"),
						"Page not redirected terms page by clicking on Terms of use link on footer in landing page");
				break;
			case 2:
				explicitWaitFortheElementTobeVisible(driver, LandingPage.HelpPageVerificationElement);
				Assert.assertTrue(getCurrentUrl(driver).equals(
						"https://help.tradus.com/hc/en-us/signin?return_to=https%3A%2F%2Fhelp.tradus.com%2Fhc%2Fen-us%2Farticles%2F360000901425"),
						"Page not redirected privacy policies page by clicking on Privacy policy link on footer in landing page");
				break;
			case 3:
				explicitWaitFortheElementTobeVisible(driver, LandingPage.HelpPageVerificationElement);
				Assert.assertTrue(getCurrentUrl(driver).equals(
						"https://help.tradus.com/hc/en-us/signin?return_to=https%3A%2F%2Fhelp.tradus.com%2Fhc%2Fen-us%2Farticles%2F360000889385"),
						"Page not redirected cookies page by clicking on cookies policy link on footer in landing page");
			}
			loadUrl(driver, "https://pro.tradus.com");
			explicitWaitFortheElementTobeVisible(driver, LandingPage.CopyrightsTextOnFooter);
		}
	}
}
