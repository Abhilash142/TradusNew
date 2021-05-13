package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.loadUrl;

import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;
import static com.tradus.core.GlobalConstants.userNamePL;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.MonthlyPackageOTMPLMSPage;
import com.tradus.core.BaseClass;

public class MonthlyPackageOTMPLMSTest extends BaseClass{
	/*
	 * Description: Verify Package name, 'Up to XX active adverts', price, per month (Exc.vat)' texts are displaying inside the package
	 */
	@Test
	public void validateSubscribedPackageinsightText() throws Exception {
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(userNamePL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageInsights);
	    waitTill(1000);
	  //  System.out.println(getText(pkgObj.selectedPackageInsights).replace("\n", ",").trim());
	    Assert.assertTrue(getText(pkgObj.selectedPackageInsights).replace("\n", ",").trim().equals("Profi Smart,5 listings,55,80 zł,Per listing,279,00 zł per month,Duration 30 days,Export to OtomotoPROFI.pl,Export to Otomoto.pl, OLX.pl and OLX.ua,Automatic bumps and other promotions at OtomotoPROFI.pl,Promotions at Otomoto and OLX"), "Package insights under subscribed package aren't displaying correctly");
	}
	
	/*
	 * Description: Verify Profi starter and smart packages are displaying under 'Interested in other packages' text
	 */
	@Test
	public void verifyPresenceofOtherPackagesinMonthlyPackagePage() throws Exception {
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(userNamePL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    int size= pkgObj.packagesUnderInterestedInOtherPackagesSection.size();
	    Assert.assertTrue(size==3, "Two packages aren't displaying under interested in other package section");
	    Assert.assertTrue(getText(pkgObj.availablePackageHeaders.get(0)).trim().equals("Profi Starter"), "Profi Starter package isn't displaying");
	    Assert.assertTrue(getText(pkgObj.availablePackageHeaders.get(1)).trim().equals("Profi Smart"), "Profi Smart package isn't displaying");
	    Assert.assertTrue(getText(pkgObj.availablePackageHeaders.get(2)).trim().equals("Profi Plus"), "Profi Plus package isn't displaying");
	}
	
	/*
	 * Description: Verify 'buy package' button is displaying below packages and cancel subscription link
	 */
	@Test
	public void verifyUpgreadPakcagebuttonforBoththePackagesandcancelLink() throws Exception {
		
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(userNamePL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    
	    int size= pkgObj.upgradePackageButtonForSelectedPackage.size();
	    Assert.assertTrue(size==3, "Two upgrade packages buttons aren't displaying under interested in other package section");
	    Assert.assertTrue(verifyElementPresent(pkgObj.upgradePackageButtonForSelectedPackage.get(0)), "Profi Starter package upgrade package button isn't displaying");
	    Assert.assertTrue(verifyElementPresent(pkgObj.upgradePackageButtonForSelectedPackage.get(1)), "Profi Smart package upgrade package button isn't displaying");
	    Assert.assertTrue(verifyElementPresent(pkgObj.upgradePackageButtonForSelectedPackage.get(2)), "Profi Plus package upgrade package button isn't displaying");
	    Assert.assertTrue(verifyElementPresent(pkgObj.cancelSubscripion), "Cancel subscription link isn't displaying");
		
	}
	
	/*
	 * Description: Verify page is redirecting to activate package on clicking 'Buy package' button
	 * and Verify Otomotoprofi zendesk page is displaying on clicking the 'Send request' button
	 */
	@Test
	public void verifyPageisRedirectingroActivatePackageoageonClickingByPackagePage() throws Exception {
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(testUserPL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    int size= pkgObj.upgradePackageButtonForSelectedPackage.size();
	    for(int i=0;i<size;i++) {
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(3000);
		jsClick(driver,pkgObj.upgradePackageButtonForSelectedPackage.get(i));
		explicitWaitFortheElementTobeVisible(driver,pkgObj.activatePackagepageHeading);
		Assert.assertTrue(verifyElementPresent(pkgObj.sendRequestBtninActivatePackagePage), "User isn't navigating to activate package page on clicking upgrade package button");
		jsClick(driver,pkgObj.sendRequestBtninActivatePackagePage);
		explicitWaitFortheElementTobeVisible(driver,pkgObj.sendOrderPageHeader);
		waitTill(3000);
		Assert.assertTrue(verifyElementPresent(pkgObj.aboutApplicationsectioninSendRqstPage), "Send rqst page might have changed");
		loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    }
	}
	/*
	 * Description: Verify total amount including vat text is displaying, change request button and send request button
	 */
	@Test
	public void verifyTotalAmountincludingVATinActivatePackagePageforSmartPackage() throws Exception{
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(testUserPL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    Select s= new Select(pkgObj.ListingDropdowninSmartPackage);
	    String[] values= {"102","110","113"};
	    for(int i=0;i<values.length;i++) {
			s.selectByValue(values[i]);
			waitTill(1000);
			jsClick(driver, pkgObj.upgradePackageButtonForSelectedPackage.get(1));
			explicitWaitFortheElementTobeVisible(driver, pkgObj.activatePackagepageHeading);
			waitTill(2000);
			Assert.assertTrue(getText(pkgObj.changePackageText).trim().equals(
					"Changing the package is currently possible via request to our customer support only. Please send request to change the package."),
					"Change package text might have changed");
			Assert.assertTrue(verifyElementPresent(pkgObj.sendRequestBtninActivatePackagePage),
					"Send request button isn't present in page");
			switch(i) {
			case 0:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 279.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 5 listing");
			   break;
			   
			case 1:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 3609.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 110 listing");
			   break;
			
			case 2:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 6919.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 1000 listing");
			   break;
				
			}
			driver.navigate().back();
			 explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
			    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
			    waitTill(3000);
	    }
	}
	
	
	/*
	 * Description: Verify total amount including vat text is displaying, change request button and send request button
	 */
	@Test
	public void verifyTotalAmountincludingVATinActivatePackagePageforPlusPackage() throws Exception{
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(testUserPL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    Select s= new Select(pkgObj.ListingDropdowninPlusPackage);
	    String[] values= {"231","236","240"};
	    for(int i=0;i<values.length;i++) {
			s.selectByValue(values[i]);
			waitTill(1000);
			jsClick(driver, pkgObj.upgradePackageButtonForSelectedPackage.get(2));
			explicitWaitFortheElementTobeVisible(driver, pkgObj.activatePackagepageHeading);
			waitTill(2000);
			Assert.assertTrue(getText(pkgObj.changePackageText).trim().equals(
					"Changing the package is currently possible via request to our customer support only. Please send request to change the package."),
					"Change package text might have changed");
			Assert.assertTrue(verifyElementPresent(pkgObj.sendRequestBtninActivatePackagePage),
					"Send request button isn't present in page");
			waitTill(2000);
			switch(i) {
			case 0:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 1381.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 20 listing");
			   break;
			   
			case 1:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 4036.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 90 listing");
			   break;
			
			case 2:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 10164.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 1000 listing");
			   break;
				
			}
			driver.navigate().back();
			 explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
			    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
			    waitTill(3000);
	    }
	}
	
	/*
	 * Description: Verify total amount including vat text is displaying, change request button and send request button
	 */
	@Test
	public void verifyTotalAmountincludingVATinActivatePackagePageforStarterPackage() throws Exception{
	    MonthlyPackageOTMPLMSPage pkgObj=new MonthlyPackageOTMPLMSPage(driver);
	    pkgObj.doLogIn(testUserPL,pwd);
		loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/subscription-details");
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
	    waitTill(2000);
	    Select s= new Select(pkgObj.ListingDropdowninStarterPackage);
	    String[] values= {"226","228"};
	    for(int i=0;i<values.length;i++) {
			s.selectByValue(values[i]);
			waitTill(1000);
			jsClick(driver, pkgObj.upgradePackageButtonForSelectedPackage.get(0));
			explicitWaitFortheElementTobeVisible(driver, pkgObj.activatePackagepageHeading);
			waitTill(2000);
			Assert.assertTrue(getText(pkgObj.changePackageText).trim().equals(
					"Changing the package is currently possible via request to our customer support only. Please send request to change the package."),
					"Change package text might have changed");
			Assert.assertTrue(verifyElementPresent(pkgObj.sendRequestBtninActivatePackagePage),
					"Send request button isn't present in page");
			switch(i) {
			case 0:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 33.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 20 listing");
			   break;
			   
			case 1:
				Assert.assertTrue(
						getText(pkgObj.packageAmountTextinActivatePackagePage).trim()
								.equals("Your total amount is 117.00 PLN incl. VAT"),
						"Package price including VAT isn't correctly displaying in activate package page for 90 listing");
			   break;
			
			}
			driver.navigate().back();
			 explicitWaitFortheElementTobeVisible(driver,pkgObj.monthlyPackagePageVerificationElement);
			    explicitWaitFortheElementTobeVisible(driver,pkgObj.selectedPackageTitle);
			    waitTill(3000);
	    }
		
	}
}
