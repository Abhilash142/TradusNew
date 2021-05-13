package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.LandingTradusProPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

public class LandingTradusProTest extends BaseClass{
	/*
	 * Description: Verify TPRO landing page (www.pro.tradus.com) is displaying on
	 * clicking 'Sell on Traud' button in header and footer in TCOM
	 */
	@Test(priority = 1)
	public void verifyTproLandingPageIsDisplayingByClickingOnSellOnTradusButtonOnHeaderAndFooterInTcom()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		waitTill(2000);
		loadUrl(driver, "https://www.tradus.com/");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SellOnTradusButtonOnTcomHeader);
		waitTill(1000);
		jsClick(driver, LandingPage.SellOnTradusButtonOnTcomHeader);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		waitTill(2000);
		/*Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/"),
				"Landing page not displaying by clicking on sell on tradus button on header in TCOM");*/
		Assert.assertTrue(verifyElementPresent(LandingPage.StartSellingOnTradusButtonOnTop) && verifyElementPresent(LandingPage.BackgroundImage)
				,"Landing page not displaying by clicking on sell on tradus button on header in TCOM");
		loadUrl(driver, "https://www.tradus.com/");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SellOnTradusButtonOnTcomFooter);
		String parentWindow= driver.getWindowHandle();
		jsClick(driver, LandingPage.SellOnTradusButtonOnTcomFooter);
		switchWindow(driver, parentWindow);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		/*Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/"),
				"Landing page not displaying by clicking on sell on tradus button on footer in TCOM");*/
		Assert.assertTrue(verifyElementPresent(LandingPage.StartSellingOnTradusButtonOnTop) && verifyElementPresent(LandingPage.BackgroundImage)
				,"Landing page not displaying by clicking on sell on tradus button on header in TCOM");
	}

	/*
	 * Description: Verify TPRO langing page is displaying on clicking the logo in
	 * sign up process
	 */
	@Test(priority = 2)
	public void verifyTproLandingPageIsDisplayingByClickingTheLogoInSignupProcess() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		loadUrl(driver, "https://pro.tradus.com/signup");
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TradusLogo);
		jsClick(driver, LandingPage.TradusLogo);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/"),
				"Landing page not displaying by clicking on logo in signup process");
		waitTill(3000);
	}

	/*
	 * Description: Verify TPRO logo, Benfits, Testimonals, Pricing, sign up now,
	 * login and languages drop down are displaying on top
	 */
	@Test(priority = 3)
	public void verifyTproLogoBenefitsTestimonialsPricingSignUpNowLoginAndLanguagesDropdownAreDisplayingOnTop()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TradusLogo);
		Assert.assertTrue(verifyElementPresent(LandingPage.TradusLogo),
				"Tradus pro logo is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.BenefitsLink),
				"Benefits link is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.TestimonialsLink),
				"Testimonials link is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.PricingLink),
				"Pricing link is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.SignupNowLink),
				"Signup now link is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.LoginLink), "Login link is not displaying in landing page");
		Assert.assertTrue(verifyElementPresent(LandingPage.LanguagesDropdown),
				"Languages Dropdown is not displaying in landing page");
	}

	/*
	 * Description: Verify default language selected is English
	 */
	@Test(priority = 4)
	public void verifyDefaultLanguageSelectedIsEnglish() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BackgroundImage);
		Assert.assertTrue(getText(LandingPage.LanguagesDropdown).equalsIgnoreCase("English"),
				"English is not slected as default language in landing page");
	}

	/*
	 * Description: Verify redirecting to respective sections on clicking Benfits,
	 * Testimonals, Pricing, sign up now and login links
	 */
	@Test(priority = 5)
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
				LandingPage.CategoriesSectionHeading.getLocation().getY() <= value1
						&& value1 <= LandingPage.SignUpButton.getLocation().getY(),
				"Not redirected to benefits section by clicking benefits link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.TestimonialsLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#testimonials"),
				"Not redirected to testimonials section by clicking testimonials link on top of the landing page");
		Long value2 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.SignUpButton.getLocation().getY() <= value2
						&& value2 <= LandingPage.TestimonialsTablist.getLocation().getY(),
				"Not redirected to testimonials section by clicking testimonials link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.PricingLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#pricing"),
				"Not redirected to pricing section by clicking pricing link on top of the landing page");
		Long value3 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.StartSelleingOnTradusButtonInSignupSection.getLocation().getY() <= value3
						&& value3 <= LandingPage.ContactSalesButton.getLocation().getY(),
				"Not redirected to pricing section by clicking pricing link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.SignupNowLink);
		waitTill(3000);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/#signup"),
				"Not redirected to signup section by clicking signup link on top of the landing page");
		Long value4 = (Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(
				LandingPage.TestimonialsTablist.getLocation().getY() <= value4
						&& value4 <= LandingPage.StartSelleingOnTradusButtonInSignupSection.getLocation().getY(),
				"Not redirected to signup section by clicking signup link on top of the landing page");

		executor.executeScript("window.scrollTo(0,document.body.scrollTop)");
		waitTill(3000);
		jsClick(driver, LandingPage.LoginLink);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.LoginPageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/login"),
				"Not redrected to Login page by clicking login link on top of the landing page");
	}

	/*
	 * Description: Verify Background image (Man with smiling face)
	 */
	@Test(priority = 6)
	public void verifyBackgroundImage() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BackgroundImage);
		Assert.assertTrue(verifyElementPresent(LandingPage.BackgroundImage),
				"Background image is not displaying in landing page");
	}

	/*
	 * Description: "Verify page is redirecting to sign up page on clicking 'Start
	 * selling on Tradus' link below 'THE SMART WAY TO TRADE HEAVY MACHINERY' text"
	 */
	@Test(priority = 7)
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
	@Test(priority = 8)
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
	@Test(priority = 9)
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
	 * Description: Verify Sign up page is displaying on clicking 'Sign up now'
	 * button
	 */
	@Test(priority = 10)
	public void verifySignUpPageIsDisplayingOnClickingSignUpNowButton() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		jsClick(driver, LandingPage.SignUpButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.packagePageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).contentEquals("https://pro.tradus.com/signup"),
				"Signup page is not displaying on clicking on signup button in overview page");
	}

	/*
	 * Description: Verify all(6) testimonals below 'SUCCESS STORIES FROM OUR
	 * CUSTOMERS'
	 */
	@Test(priority = 11)
	public void verifyAllTestimonialsBelowSuccessStoriesFromOurCustomers() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertEquals(LandingPage.TestimonialsList.size(), 5,
				"All 65 testimonials are not displaying under Success stories from our customer text");
	}

	/*
	 * Description: Verify first 3 testimonals is displaying in one slide and
	 * remaining 3 in another slide
	 */
	@Test(priority = 12)
	public void verifyFirstThreeTestimonialsAreDisplayingInOneSlideAndNextThreeAreDisplayingInAnotherSlide()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertEquals(LandingPage.TestimonialsListInASlide.size(), 3,
				"3 testimonials are not displaying in 1st slide under Success stories from our customer text");
		jsClick(driver, LandingPage.NextIconInTestinominals);
		Assert.assertEquals(LandingPage.TestimonialsListInASlide.size(), 2,
				"2 testimonials are not displaying in 2nd slide under Success stories from our customer text");
	}

	/*
	 * Description: Verify overview page is displaying on clicking TPRO logo after
	 * login
	 */
	@Test(priority = 13)
	public void verifyOverviewPageIsDisplayingOnClickingTproLogoAfterLogin() throws Exception {
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		waitTill(3000);
		OverviewTradusPROPage overviewPage = new OverviewTradusPROPage(driver);
		loadUrl(driver, "https://pro.tradus.com/login");
		explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profileLinkOnSideBar);
		jsClick(driver, overviewPage.profileLinkOnSideBar);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.profilePageVerificationElement);
		jsClick(driver, overviewPage.tradusProLogo);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.popularAdsText);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/lms"),
				"overview page not displaying by clicking on logo after login");
		jsClick(driver, overviewPage.profileIconOnHeader);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.logoutOptionInProfileIconDropdown);
		jsClick(driver, overviewPage.logoutOptionInProfileIconDropdown);
	}

	/*
	 * Description: Verify by checking left and right arrows
	 */
	@Test(priority = 14)
	public void verifyByCheckingLeftAndRightArrows() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		Assert.assertEquals(LandingPage.TestimonialsListInASlide.size(), 3,
				"3 testimonials are not displaying in 1st slide under Success stories from our customer text");
		jsClick(driver, LandingPage.NextIconInTestinominals);
		Assert.assertEquals(LandingPage.TestimonialsListInASlide.size(), 2,
				"2 testimonials are not displaying in 2nd slide under Success stories from our customer text");
		jsClick(driver, LandingPage.PreviousIconInTestinominals);
		Assert.assertEquals(LandingPage.TestimonialsListInASlide.size(), 3,
				"3 testimonials are not displaying in 1st slide under Success stories from our customer text");
	}

	/*
	 * Description: Verify sign up and CRM info below 'SIGNUP IS EASY!'
	 */
	@Test(priority = 15)
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
	 * Description: Verify Sign up page is displaying on clicking 'Start selling on
	 * Tradus' button
	 */
	@Test(priority = 16)
	public void verifySignUpPageIsDisplayingOnStartSelleningOnTradusButtonInSignUpSection() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		jsClick(driver, LandingPage.StartSelleingOnTradusButtonInSignupSection);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.packagePageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/signup"),
				"Signup page is not displaying on clicking on signup button in signup section in landing page");
	}

	/*
	 * Description: Verify all plans are displaying (Basic 10, 25 & 70)
	 */
	@Test(priority = 17)
	public void verifyAllPlansAreDisplayingUnderPlansAndPricingSection() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		int size = LandingPage.PlansListUnderPlansAndPricing.size();
		Assert.assertEquals(size, 3, "3 plans are not displaying under plans and pricing");
		Assert.assertEquals(getText(LandingPage.PlansTitlesListUnderPlansAndPricing.get(0)), "Tradus Basic 10",
				"Tradus basic 10 plan is not displaying under plans and prices");
		Assert.assertTrue(getText(LandingPage.PlansTitlesListUnderPlansAndPricing.get(1)).equals("Tradus Basic 25"),
				"Tradus basic 25 plan is not displaying under plans and prices");
		Assert.assertTrue(getText(LandingPage.PlansTitlesListUnderPlansAndPricing.get(2)).equals("Tradus Basic 70"),
				"Tradus basic 70 plan is not displaying under plans and prices");
	}

	/*
	 * Description: Verify Maximum adverts count, Price and Excluding VAT info is
	 * displaying on the plans
	 */
	@Test(priority = 18)
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
	 * Description: Verify page is redirecting to Sign up page on clicking the plans
	 */
	@Test(priority = 19)
	public void verifyPageIsRedirectingToSignUpPageOnClickingThePlans() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");
		for (int i = 0; i < LandingPage.PlansListUnderPlansAndPricing.size(); i++) {
			jsClick(driver, LandingPage.PlansListUnderPlansAndPricing.get(i));
			explicitWaitFortheElementTobeVisible(driver, LandingPage.packagePageVerificationElement);
			Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/signup"),
					"Signup page is not displaying on clicking the plans under price and planning");
			driver.navigate().back();
			explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		}
	}

	/*
	 * Description: Verify Sign up page is displaying on clicking 'Start selling on
	 * Tradus' button
	 */
	@Test(priority = 20)
	public void verifySignUpPageIsDisplayingByClickingStartSelleingOnTradusButtonInPlansAndPricingSection()
			throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.BenefitsLink);
		jsClick(driver, LandingPage.StartSelleingOnTradusButtonInPlansAndPicing);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.packagePageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/signup"),
				"Signup page is not displaying on clicking on signup button in plans and pricing section in landing page");
		waitTill(3000);
	}

	/*
	 * Description: Verify Support form is displaying on clicking 'Contact sales'
	 * and 'Get support' buttons
	 */
	@Test(priority = 21)
	public void verifySupportFormIsDisplayingOnClickingContactSalesAndGetSupportButtons() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.ContactSalesButton);
		jsClick(driver, LandingPage.ContactSalesButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.FullNameInputFieldInSupportForm);
		Assert.assertTrue(verifyElementPresent(LandingPage.FullNameInputFieldInSupportForm),
				"Support form not displayed by clicking on contact sales button in landing page");
		jsClick(driver, LandingPage.CloseIcon);
		jsClick(driver, LandingPage.GetSupportButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.FullNameInputFieldInSupportForm);
		Assert.assertTrue(verifyElementPresent(LandingPage.FullNameInputFieldInSupportForm),
				"Support form not displayed by clicking on get support button in landing page");
	}

	/*
	 * Description: Verify able to submit the form
	 */
	@Test(priority = 22)
	public void verifyAbleToSubmitTheSupportForm() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.ContactSalesButton);
		jsClick(driver, LandingPage.ContactSalesButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.FullNameInputFieldInSupportForm);
		sendKeys(LandingPage.FullNameInputFieldInSupportForm, "Testing");
		sendKeys(LandingPage.EmailInputFieldInSupportForm, userName);
		sendKeys(LandingPage.PhoneInputFieldInSupportForm, "31777888999");
		jsClick(driver, LandingPage.SubmitButtonInSupportForm);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SuccessmessageofSupportForm);
		Assert.assertTrue(verifyElementPresent(LandingPage.SuccessmessageofSupportForm),
				"Success message not displaying on submitting the support form");
	}

	/*
	 * Description: Verify the success message after submitting the form
	 */
	@Test(priority = 23)
	public void verifySuccessMessageAfterSubmittingTheSupportForm() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.ContactSalesButton);
		jsClick(driver, LandingPage.ContactSalesButton);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.FullNameInputFieldInSupportForm);
		sendKeys(LandingPage.FullNameInputFieldInSupportForm, "Testing");
		sendKeys(LandingPage.EmailInputFieldInSupportForm, userName);
		sendKeys(LandingPage.PhoneInputFieldInSupportForm, "31777888999");
		jsClick(driver, LandingPage.SubmitButtonInSupportForm);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.SuccessmessageofSupportForm);
		Assert.assertTrue(
				getText(LandingPage.SuccessmessageofSupportForm).equals(
						"Your message has been successfully sent. One of our team members will contact you soon."),
				"Expected success message not displaying bu submitting the support form");
		waitTill(3000);
	}

	/*
	 * Description: Verify TPRO Logo, For buyers: Tradus.com, Terms of use, privacy
	 * policy and cookies policy links are displaying in footer
	 */
	@Test(priority = 24)
	public void verifyTPROLogoOnFooter() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TProLogoOnFooter);
		Assert.assertTrue(verifyElementPresent(LandingPage.TProLogoOnFooter),
				"TPro logo is not displaying on footer in landing page");
		Assert.assertEquals(LandingPage.HelpLinksListOnFooter.size(), 4,
				"Expected number of help links are not dislaying on footer in landing page");
		for (int i = 0; i < LandingPage.HelpLinksListOnFooter.size(); i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(LandingPage.HelpLinksListOnFooter.get(i)).equals("For buyers: Tradus.com"),
						"For buyers: Tradus.com link is not displaying on footer in landing page");
				break;
			case 1:
				Assert.assertEquals(getText(LandingPage.HelpLinksListOnFooter.get(i)), "Terms of Use",
						"Terms of Use link is not displaying on footer in landing page");
				break;
			case 2:
				Assert.assertTrue(getText(LandingPage.HelpLinksListOnFooter.get(i)).equals("Privacy Policy"),
						"Privacy Policy link is not displaying on footer in landing page");
				break;
			case 3:
				Assert.assertTrue(getText(LandingPage.HelpLinksListOnFooter.get(i)).equals("Cookies policy"),
						"Cookies policy link is not displaying on footer in landing page");
			}
		}
	}

	/*
	 * Description: Verify copyrights text
	 */
	@Test(priority = 25)
	public void verifyCopyRightsTextOnFooter() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.CopyrightsTextOnFooter);
		Assert.assertTrue(verifyElementPresent(LandingPage.CopyrightsTextOnFooter),
				"Copy rights text is not displaying on footer in landing page");
		waitTill(3000);
	}

	/*
	 * Description: Verify social sites icons (Youtube, Instagram, Facebook and
	 * Linked in) are displaying and redirecting to respective pages properly
	 */
	@Test(priority = 26)
	public void verifySocialSitesAndtheirRedirection() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.CopyrightsTextOnFooter);
		Assert.assertEquals(LandingPage.SocialSitesListOnFooter.size(), 4,
				"Expected number of social sites icons are not dislaying on footer in landing page");
		for (int i = 0; i < 3; i++) {
			jsClick(driver, LandingPage.SocialSitesListOnFooter.get(i));
			String parentWindow = driver.getWindowHandle();
			switchWindow(driver, parentWindow);
			switch (i) {
			case 0:
				Assert.assertTrue(
						getCurrentUrl(driver).equals(
								"https://www.youtube.com/watch?v=JwsMzQ5aB5E&list=PLXZ_iV-2LAkon_nlRhjlPLcZCcDhRRvRW"),
						"Page not redirected to respective youtube page");
				break;
			case 1:
				Assert.assertTrue(getCurrentUrl(driver).equals("https://www.instagram.com/traduscom/"),
						"Page not redirected to respective instagram page");
				break;
			case 2:
				Assert.assertTrue(getCurrentUrl(driver).equals("https://www.facebook.com/tradus/"),
						"Page not redirected to respective facebook page");
			}
			loadUrl(driver, "https://pro.tradus.com");
			explicitWaitFortheElementTobeVisible(driver, LandingPage.CopyrightsTextOnFooter);
		}
		waitTill(3000);
	}

	/*
	 * Description: Ensure all the links in footer are redirecting to Tradus.com
	 * pages (EX: Help pages, social links)
	 */
	@Test(priority = 27)
	public void verifyAllFooterHelpLinksAreRedirectingToRespctivePages() throws Exception {
		LandingTradusProPage LandingPage = new LandingTradusProPage(driver);
		explicitWaitFortheElementTobeVisible(driver, LandingPage.TProLogoOnFooter);
		Assert.assertEquals(LandingPage.HelpLinksListOnFooter.size(), 4,
				"Expected number of help links are not dislaying on footer in landing page");
		for (int i = 0; i < LandingPage.HelpLinksListOnFooter.size(); i++) {
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
						getCurrentUrl(driver).equals("https://help.tradus.com/hc/en-us/articles/115001631049"),
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
