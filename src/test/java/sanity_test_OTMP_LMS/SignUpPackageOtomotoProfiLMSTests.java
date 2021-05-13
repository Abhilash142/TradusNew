package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.waitTill;

import java.util.List;

import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.getAttribute;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.SignUpAccountsOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpPackageOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;

import sanity_test_TPRO.CommonMethods;

public class SignUpPackageOtomotoProfiLMSTests extends BaseClass{
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	@Test
	public void verifyLanguageDropdownandAllOptions() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
	}
	
	/*
	 * Description:Verify 'Intelligent tools & data', 'Heavy machinery only' and 'Easy international trade' info is displaying under 'The benefits of selling on Tradus PRO Staging' text in left side of the page
	 */
	@Test
	public void verifyBenifitsSection() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.benifitsSection);
	    Assert.assertTrue(getText(pkjPgObj.benifitsSection).replace("\n", ",").equals("Benefits of selling on OTOMOTO Profi,Wide reach of your ads,4.4 billion views on the OLX Group websites per month,Huge number of potential customers,7.1 million unique users on OTOMOTO,Export to leading websites,Possibility to export advertisements to OTOMOTO, OLX.pl and OLX.ua websites,* data source Gemius / PBI"),
	    		"Benifits section texts has been chnaged");
		
	}
	
	/*
	 * Description: Verify Sign in link and its Navigation
	 */
	
	@Test
	public void verifySignInLinkandItsNavigation() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.loginLink);
		click(pkjPgObj.loginLink);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.loginPageVerifcationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.loginPageVerifcationElement), "User is not navigating to sign in page upon clicking login link");
	}
	
	/*
	 * Description: Verify the first step 'Package' is highlighted
	 */
	@Test
	public void verifyPackageSectionIsHighlighted() throws Exception
	{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.tabInfo);
		waitTill(2000);
		Assert.assertTrue((pkjPgObj.tabInfo).getCssValue("background-color").equals("rgba(0, 113, 206, 1)"),"Package section is not highlighted");
		Assert.assertTrue(getText(pkjPgObj.tabName).trim().equals("Package"),"1st tab name in sign up page is not Package");
	}
	
	/*
	 * Description: Verify three packages are displaying under '1. Please choose the package ..'' text
	 * and verify price exculding VAT text
	 */
	@Test
	public void verifyTwoPackagesareDisplayingUnderPleaseChoosePackageText() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		Assert.assertTrue(getText(pkjPgObj.packagePageVerificationElement).trim().equals("1. Please choose the package that suits your needs. Packages are valid for placing ads in all categories."),
				"Package page heading might have changed");
		int size=pkjPgObj.numberOfPackages.size();
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		Assert.assertTrue(size==3, "Two packages are not displaying in packages page");
		Assert.assertTrue(verifyElementPresent(pkjPgObj.smartPackage), "Smart package isn't present in package page");
		Assert.assertTrue(verifyElementPresent(pkjPgObj.starterPackage), "Starter package isn't present in package page");
		Assert.assertTrue(verifyElementPresent(pkjPgObj.plusPackage), "Plus package isn't present in package page");
	}
	
	/*
	 * Description: Verify inside content of each package
	 */
	@Test
	public void verifyInsidecontentofeachPackage() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.smartPackage);
		Assert.assertTrue(pkjPgObj.starterPackageHighlights.size()==2, "Two highlights are not displaying in Starter package");
		Assert.assertTrue(pkjPgObj.smartPackageHighlights.size()==5, "Five highlights are not displaying in Smart package");
		Assert.assertTrue(pkjPgObj.plusPackageHighlights.size()==6, "Six highlights are not displaying in Plus package");
		//for starter package
		for(int i=0;i<pkjPgObj.starterPackageHighlights.size();i++) {
			switch (i) {
				case 0:
					Assert.assertTrue(getText(pkjPgObj.starterPackageHighlights.get(i)).equals("Czas emisji 30 dni"), "Duretion info in starter package isn't correct");
			        break;
				case 1:
					Assert.assertTrue(getText(pkjPgObj.starterPackageHighlights.get(i)).equals("Publikacja oferty w OtomotoPROFI.pl"), "Export info in starter package isn't correct");
			        break;
			}
		}
		
		for(int i=0;i<pkjPgObj.smartPackageHighlights.size();i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).equals("Czas emisji 30 dni"), "Duretion info in smart package isn't correct");
		        break;
			case 1:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).equals("Publikacja oferty w OtomotoPROFI.pl"), "Export info in smart package isn't correct");
		        break;
			case 2:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).equals("Publikacja oferty w Otomoto.pl, OLX.pl i OLX.ua"), "Export info to sister sites in smart package isn't correct");
		        break;
			case 3:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).equals("Automatyczne podbicia ogłoszenia i inne promowania w OtomotoPROFI.pl"), "Auto bumping info in smart package isn't correct");
		        break;
			case 4:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).equals("Promowania w Otomoto i OLX"), "Promowania w Otomoto i OLX");
		        break;
			
			}
		}
		for(int i=0;i<pkjPgObj.plusPackageHighlights.size();i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Czas emisji 30 dni"), "Duretion info in smart package isn't correct");
		        break;
			case 1:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Publikacja oferty w OtomotoPROFI.pl"), "Export info in smart package isn't correct");
		        break;
			case 2:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Publikacja oferty w Otomoto.pl, OLX.pl i OLX.ua"), "Export info to sister sites in smart package isn't correct");
		        break;
			case 3:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Automatyczne podbicia ogłoszenia i inne promowania w OtomotoPROFI.pl"), "Auto bumping info in smart package isn't correct");
		        break;
			case 4:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Promowania w Otomoto i OLX"), "Promotion to Otomoto and OLX aren't displaying");
		        break;
			case 5:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).equals("Publikacja oferty w Tradus.com"), "Export to Tradus.com isn't displaying");
		        break;
				
			}
		}
	}
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in smart package
	 */
	@Test
	public void packagePriceandPriceperAdsarechangingonSelectingnumberofListinginSmartPackage() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninSmartPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninSmartPackage);
		List<WebElement> allOptions = s.getOptions();
		String[][] arr = { { "279,00", "55,80" }, { "549,00", "54,90" }, { "979,00", "48,95" }, { "1369,00", "45,63" },
				{ "1819,00", "45,48" }, { "2139,00", "42,78" }, { "2629,00", "37,56" }, { "3109,00", "34,54" },
				{ "3609,00", "32,81" }, { "4109,00", "31,61" }, { "4609,00", "30,73" }, { "6919,00", "6,92" } };
		for (int i = 0; i < allOptions.size(); i++) {
			click(allOptions.get(i));
			waitTill(2000);
			Assert.assertTrue(
					getText(pkjPgObj.smartPackagePriceText).replaceAll("[^0-9,]", "").trim().equals(arr[i][0]),
					"Price isn't correct for" + i + " th dropdown value in smart package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.smartPackagePriceText).contains("zł"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.smartPackagePriceperListing).replaceAll("[^0-9,]", "").trim().equals(arr[i][1]),
					"Price per listing isn't correct for" + i
							+ " th dropdown value in smart package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.smartPackagePriceperListing).contains("zł"),
					"Unit isn't present in price per listing");
		}
	}
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in starter package
	 */
	@Test
	public void packagePriceandPriceperAdsarechangingonSelectingnumberofListinginStarterPackage() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninStarterPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninStarterPackage);
		List<WebElement> allOptions = s.getOptions();
		String[][] arr = { { "33,00", "6,60" }, { "66,00", "6,60" }, { "117,00", "5,85" }};
		for (int i = 0; i < allOptions.size(); i++) {
			click(allOptions.get(i));
			waitTill(2000);
			Assert.assertTrue(
					getText(pkjPgObj.starterPackagePriceText).replaceAll("[^0-9,]", "").trim().equals(arr[i][0]),
					"Price isn't correct for" + i + " th dropdown value in starter package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.smartPackagePriceText).contains("zł"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.starterPackagePriceperListing).replaceAll("[^0-9,]", "").trim().equals(arr[i][1]),
					"Price per listing isn't correct for" + i
							+ " th dropdown value in smart package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.starterPackagePriceperListing).contains("zł"),
					"Unit isn't present in price per listing");
		}
	}
	
	/*
	 * Description: Verify package price and price per Ads text is updating on selecting listing in Plus package
	 */
	@Test
	public void packagePriceandPriceperAdsarechangingonSelectingnumberofListinginPlusPackage() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.ListingDropdowninPlusPackage);
		Select s = new Select(pkjPgObj.ListingDropdowninPlusPackage);
		List<WebElement> allOptions = s.getOptions();
		String[][] arr = { { "430,00", "86,00" }, { "800,00", "80,00" }, { "1381,00", "69,05" },{"1896,00","63,20"},{"2472,00","61,80"},{"2892,00","57,84"},{"3508,00","50,11"},
				{"4036,00","44,84"},{"4565,00","41,50"},{"5088,00","39,14"},{"5637,00","37,58"},{"10164,00","10,16"}};
		for (int i = 10; i < allOptions.size(); i++) {
			click(allOptions.get(i));
			waitTill(2000);
			Assert.assertTrue(
					getText(pkjPgObj.plusPackagePriceText).replaceAll("[^0-9,]", "").trim().equals(arr[i][0]),
					"Price isn't correct for" + i + " th dropdown value in starter package number of listing dropdown");
			
			Assert.assertTrue(getText(pkjPgObj.plusPackagePriceText).contains("zł"),
					"Unit isn't present in package price");
			Assert.assertTrue(
					getText(pkjPgObj.PlusPackagePriceperListing).replaceAll("[^0-9,]", "").trim().equals(arr[i][1]),
					"Price per listing isn't correct for" + i
							+ " th dropdown value in smart package number of listing dropdown");
			Assert.assertTrue(getText(pkjPgObj.PlusPackagePriceperListing).contains("zł"),
					"Unit isn't present in price per listing");
		}
	}
	
	
	
	/*
	 * Description: Validate tooltips in starter package
	 */
	@Test
	public void validateTooltipsinStarterPackage() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.starterPackage);
		List<WebElement> tooltips_starter=pkjPgObj.toolTipsinStarterPackage;
		Actions a=new Actions(driver);
		for(int i=0;i<tooltips_starter.size();i++) {
			switch (i) {
			case 0:
				a.moveToElement(tooltips_starter.get(i)).build().perform();
				waitTill(2000);
			    Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Pakiet jest aktywny 30 dni od aktywacji. Ogłoszenia będą aktywne do momentu wygaśnięcia pakietu"), "Starter package 1st tooltip content has been changed");
			    break;
			case 1:
				a.moveToElement(tooltips_starter.get(i)).build().perform();
				waitTill(2000);
			    Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Wszystkie Twoje ogłoszenia zostają opublikowane na OtomotoPROFI.pl"), "Starter package 2nd tooltip content has been changed");
			    break;
			}
		}
		List<WebElement> tooltips_smart=pkjPgObj.toolTipsinSmartPackage;
		for(int i=0;i<tooltips_smart.size();i++) {
			switch (i) {
			case 0:
				a.moveToElement(tooltips_smart.get(i)).build().perform();
				waitTill(2000);
			    Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Pakiet jest aktywny 30 dni od aktywacji. Ogłoszenia będą aktywne do momentu wygaśnięcia pakietu"), "Smart package 1st tooltip content has been changed");
			    break;
			case 1:
				a.moveToElement(tooltips_smart.get(i)).build().perform();
				waitTill(2000);
			    Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Wszystkie Twoje ogłoszenia zostają opublikowane na OtomotoPROFI.pl"), "Smart package 2nd tooltip content has been changed");
			    break;
			case 2:
				a.moveToElement(tooltips_smart.get(i)).build().perform();
				waitTill(2000);
			    Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Wszystkie Twoje ogłoszenia otrzymują dodatkowe wyróżnienie na Otomoto.pl, Olx.pl oraz Olx.ua przez 30 dni od daty publikacji"), "Smart package 3rd tooltip content has been changed");
			    break;
			case 3:
				a.moveToElement(tooltips_smart.get(i)).build().perform();
				waitTill(2000);
			  //  Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Na OtomotoPROFI.pl twoje ogłoszenia będą podbijane automatycznie co 10 dni. Ponadto otrzymają 7 dniowe podświetlenie  oraz pojawią się w “Wyróżnionych ogłoszeniach” na 3 dni"), "Smart package 4th tooltip content has been changes");
			    break;
			case 4:
				a.moveToElement(tooltips_smart.get(i)).build().perform();
				waitTill(2000);
			   // Assert.assertTrue(getText(pkjPgObj.toolTipsContent).trim().equals("Twoje ogłoszenia wyeksportowane do Otomoto.pl otrzymają także dodatkowe befefity, takie same jak w  Pakiecie Srebrnym w Otomoto. Więcej szczegółów tutaj"), "Smart package 5th tooltip content has been changed");
			    break;
			
			}
			
		}
		
	}
	
	/*
	 * Description: verify VAT and invoice info below package section
	 */
	@Test
	public void verifyVATandInvoiceinfoBelowpackagesection() throws Exception {
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.priceExcludingVATtext);
		Assert.assertTrue(getText(pkjPgObj.priceExcludingVATtext).trim().equals("Prices exclude VAT. Invoice issued after the package activation and should be paid within 30 days."), 
				"VAT text and invoice info below package section might have changed");

	}
	
	/*
	 * Description: verify navigation to Accounts page by selecting any number of listing from starter packages
	 */
	@Test
	public void verifyNavigationtoAccountspagebychoosingAnyListingfromStarterPackage() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.starterPackage);
		click(pkjPgObj.starterPackage);
		waitTill(2000);
		Select s=new Select(pkjPgObj.ListingDropdowninStarterPackage);
		//List<WebElement> dropdownList=s.getOptions();
		s.selectByValue("99");
		waitTill(2000);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 5 listing from starter package");
		click(accountPgObj.backButton);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		s.selectByValue("101");
		waitTill(2000);
		click(pkjPgObj.nextButton);
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 20 listing from starter package");	
	}
	
	/*
	 * Description: verify navigation to Accounts page by selecting any number of listing from smart packages
	 */
	@Test
	public void verifyNavigationtoAccountspagebychoosingAnyListingfromSmartPackage() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		click(pkjPgObj.smartPackage);
		waitTill(2000);
		Select s=new Select(pkjPgObj.ListingDropdowninSmartPackage);
		String[] val= {"102","106","111","113"};
		for(int i=0;i<val.length;i++) {
			s.selectByValue(val[i]);
			waitTill(2000);
			click(pkjPgObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting listing value "+i+" from starter package");
			click(accountPgObj.backButton);
			explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
			waitTill(1000);
		}
	}
	
	/*
	 * Description: verify navigation to Accounts page by selecting any number of listing from Plus packages
	 */
	@Test
	public void verifyNavigationtoAccountspagebychoosingAnyListingfromPlusPackage() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.plusPackage);
		waitTill(2000);
		click(pkjPgObj.plusPackage);
		waitTill(2000);
		Select s=new Select(pkjPgObj.ListingDropdowninPlusPackage);
		String[] val= {"229","232","238","240"};
		for(int i=0;i<val.length;i++) {
			s.selectByValue(val[i]);
			waitTill(2000);
			click(pkjPgObj.nextButton);
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting listing value "+i+" from starter package");
			click(accountPgObj.backButton);
			explicitWaitFortheElementTobeVisible(driver, pkjPgObj.plusPackage);
			waitTill(1000);
		}
	}
	
	/*
	 * Description: Verify by default radio button is enabled for 'Profi smart 5' package 
	 */
	@Test
	public void verifybyDefaultRadioButtonisEnabledforProfileSmartpackage() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.smartPackage);
		waitTill(2000);
		Assert.assertTrue(getAttribute(pkjPgObj.smartPackageBackground,"class").contains("border-shamrock"),"Smart package background isn't highlighted");
		Assert.assertFalse(getAttribute(pkjPgObj.starterPackageBackground,"class").contains("border-shamrock"),"Starter package background is highlighted");
		Assert.assertFalse(getAttribute(pkjPgObj.plusPackageBackground,"class").contains("border-shamrock"),"Plus package background is highlighted");
	}
}
