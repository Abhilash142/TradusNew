package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.jsClick;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.SignUpAccountsOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.SignUpPackageOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

import sanity_test_TPRO.CommonMethods;

public class SignUpPackageOtomotoProfiLMSTests  extends BaseClass{
	
	/*
	 * Description: Verify language drop down is displaying and 10 language options are displaying 
	 * on clicking the drop down in header
	 */
	@Test
	public void verifyLanguageDropdownandAllOptions() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj=new SignUpPackageOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver,pkjPgObj.packagePageVerificationElement);
		CommonMethods cm=new CommonMethods();
		cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver);
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
					Assert.assertTrue(getText(pkjPgObj.starterPackageHighlights.get(i)).trim().equals("Duration 30 days"), "Duretion info in starter package isn't correct");
			        break;
				case 1:
					System.out.println(getText(pkjPgObj.starterPackageHighlights.get(i)));
					Assert.assertTrue(getText(pkjPgObj.starterPackageHighlights.get(i)).trim().equals("Export to OtomotoPROFI.pl"), "Export info in starter package isn't correct");
			        break;
			}
		}
		
		for(int i=0;i<pkjPgObj.smartPackageHighlights.size();i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).trim().equals("Duration 30 days"), "Duretion info in smart package isn't correct");
		        break;
			case 1:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).trim().equals("Export to OtomotoPROFI.pl"), "Export info in smart package isn't correct");
		        break;
			case 2:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).trim().equals("Export to Otomoto.pl, OLX.pl and OLX.ua"), "Export info to sister sites in smart package isn't correct");
		        break;
			case 3:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).trim().equals("Automatic bumps and other promotions at OtomotoPROFI.pl"), "Auto bumping info in smart package isn't correct");
		        break;
			case 4:
				Assert.assertTrue(getText(pkjPgObj.smartPackageHighlights.get(i)).trim().equals("Promotions at Otomoto and OLX"), "Promowania w Otomoto i OLX");
		        break;
			
			}
		}
		for(int i=0;i<pkjPgObj.plusPackageHighlights.size();i++) {
			switch (i) {
			case 0:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Duration 30 days"), "Duretion info in smart package isn't correct");
		        break;
			case 1:
			    Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Export to OtomotoPROFI.pl"), "Export info in smart package isn't correct");
		        break;
			case 2:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Export to Otomoto.pl, OLX.pl and OLX.ua"), "Export info to sister sites in smart package isn't correct");
		        break;
			case 3:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Automatic bumps and other promotions at OtomotoPROFI.pl"), "Auto bumping info in smart package isn't correct");
		        break;
			case 4:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Promotions at Otomoto and OLX"), "Promotion to Otomoto and OLX aren't displaying");
		        break;
			case 5:
				Assert.assertTrue(getText(pkjPgObj.plusPackageHighlights.get(i)).trim().equals("Export to Tradus.com"), "Export to Tradus.com isn't displaying");
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
			waitTill(1000);
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
			waitTill(1000);
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
			waitTill(1000);
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
	 * Description: verify navigation to Accounts page by selecting any number of listing from starter packages
	 */
	@Test
	public void verifyNavigationtoAccountspagebychoosingAnyListingfromStarterPackage() throws Exception{
		SignUpPackageOtomotoProfiLMSPage pkjPgObj = new SignUpPackageOtomotoProfiLMSPage(driver);
		SignUpAccountsOtomotoProfiLMSPage accountPgObj= new SignUpAccountsOtomotoProfiLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.starterPackage);
		//click(pkjPgObj.starterPackage);
		//waitTill(2000);
		Select s=new Select(pkjPgObj.ListingDropdowninStarterPackage);
		//List<WebElement> dropdownList=s.getOptions();
		s.selectByValue("226");
		waitTill(1000);
		try{
	    	click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
		explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting 5 listing from starter package");
		try{
	    	click(accountPgObj.backButton);
		}catch(Exception E) {
			jsClick(driver,accountPgObj.backButton);
		}
		explicitWaitFortheElementTobeVisible(driver, pkjPgObj.packagePageVerificationElement);
		s.selectByValue("228");
		waitTill(1000);
		try{
	    	click(pkjPgObj.nextButton);
		}catch(Exception E) {
			jsClick(driver,pkjPgObj.nextButton);
		}
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
		waitTill(2000);
		Select s=new Select(pkjPgObj.ListingDropdowninSmartPackage);
		String[] val= {"102","106","111","113"};
		for(int i=0;i<val.length;i++) {
			s.selectByValue(val[i]);
			waitTill(1000);
			try{
		    	click(pkjPgObj.nextButton);
			}catch(Exception E) {
				jsClick(driver,pkjPgObj.nextButton);
			}
			explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting listing value "+i+" from starter package");
			try{
		    	click(accountPgObj.backButton);
			}catch(Exception E) {
				jsClick(driver,accountPgObj.backButton);
			}
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
		Select s=new Select(pkjPgObj.ListingDropdowninPlusPackage);
		String[] val= {"229","232","238","240"};
		for(int i=0;i<val.length;i++) {
			s.selectByValue(val[i]);
			waitTill(1000);
			try{
		    	click(pkjPgObj.nextButton);
			}catch(Exception E) {
				jsClick(driver,pkjPgObj.nextButton);
			}
		    explicitWaitFortheElementTobeVisible(driver, accountPgObj.accountsPageVerificationElement);
			Assert.assertTrue(verifyElementPresent(pkjPgObj.accountsPageVerificationElement), "Account page isn't displaying upon clicking next button after selecting listing value "+i+" from starter package");
			try{
		    	click(accountPgObj.backButton);
			}catch(Exception E) {
				jsClick(driver,accountPgObj.backButton);
			}
			explicitWaitFortheElementTobeVisible(driver, pkjPgObj.plusPackage);
			waitTill(1000);
		}
	}
}
