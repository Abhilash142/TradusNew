package sanity_test_TPRO;

import com.tradus.pro.pages.SignUpPackageSectionTradusPROPage;
import com.tradus.pro.pages.SignupTPROPage;
import com.tradus.core.BaseClass;
import com.tradus.core.TestListenersClass;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
//import static com.sunfra.tradus.core.GE.driver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListenersClass.class)
public class SignUpPackageSectionTradusPROTest extends BaseClass{

	/*
	 * Verify on clicking account section, should able to go account page and 
	 * all the details should be prefilled and viceversa
	 */
    @Test
	public void verifyNavigatingDetailsTabandEnsurepresenceofallpreenteredData() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj=new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionHeading), "Company package selection page is not displayed");
		//jsClick(driver,signUpPkgObj.backButton);
		new Actions(driver).moveToElement(signUpPkgObj.backButton).click().build().perform();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.detailsMobilephoneText);
		/*Assert.assertTrue(verifyElementPresent(signUpObj.detailsPageDetailElement),
				"SignUp details page is not displayed");*/
		System.out.println(signUpObj.detailsCountryDropdown.getAttribute("innerHTML"));
		Assert.assertTrue(getText(signUpObj.detailsCountryDropdown).equalsIgnoreCase("Netherlands"),
				"Netherlands country is not autoselected");
		Assert.assertTrue(getAttribute(signUpObj.detailsVATNoTextField,"value").equals("NL854502130B01"),
				"Vat number is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsCompanyNameTextField,"value").equals("TRADUS B.V."),
				"Company name is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsCityTextField,"value").equals("AMSTERDAM"),
				"City name is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsCompanyAddressTextField,"value").equals("WIBAUTSTRAAT 00137 C"),
				"Company address is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsCompanyZIPTextField,"value").equals("1097DN"),
				"ZIP Code is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsContactPersonTextField,"value").equals("Harish"),
				"Conatct person name is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsCompanyWebsiteTextField,"value").equals("http://www.sunfra.com/"),
				"Website is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsPhoneTextField,"value").equals("777 888999"),
				"Phone number is not populated upon navigating back from package page");
		Assert.assertTrue(getAttribute(signUpObj.detailsMobilePhoneTextField,"value").equals("612345678"),
				"Mobile phone number is not populated upon navigating back from package page");
		Assert.assertTrue(signUpObj.detailsAvailableOnWhatsAppCheckbox.isEnabled(), 
				"Whats app check box is not enabled");
	}
	/*
	 * Verify 3 packages under 'How many ads do you want to list' 
	 * namely 'Tradus basic 10', Tradus basic '25' and 'Tradus basic 70' for company users
	 * Tradus basic 10 - uptp 10 active adverts - 50 Euros/month
	 * Tradus basic 25- up to 25 active adverts - 100 euros/month
	 * Trauds basic 70 -  upto 70 active advers - 250 euros/month"
	 */
	@Test
	public void verifyThreePackagesandtheirinsightsinCompanyPackagePage() throws Exception {
		SignUpPackageSectionTradusPROPage signUpPkgObj = new SignUpPackageSectionTradusPROPage(driver);
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		//signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "Company");
		explicitWaitFortheElementTobeVisible(driver, signUpPkgObj.companyPackageSectionHeading);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionHeading),
				"Company package selection page is not displayed");
		waitTill(2000);
		Assert.assertTrue(signUpPkgObj.numberOfPackagesAvailable.size() == 3,
				"3 Packages are not present in company packages page");
		for (int i = 0; i < signUpPkgObj.numberOfPackagesAvailable.size(); i++) {
			switch (i) {
			case 0: {

				String pkgtext = getText(signUpPkgObj.numberOfPackagesAvailable.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 10, Up to 10 active adverts, €50.00, per month (Excl. VAT)"),
						"Tradus Basic 10 attributes are not dislayed");
				break;
			}
			case 1: {
				String pkgtext = getText(signUpPkgObj.numberOfPackagesAvailable.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 25, Up to 25 active adverts, €100.00, per month (Excl. VAT)"),
						"Tradus Basic 25 attributes are not dislayed");
				break;
			}
			case 2: {
				String pkgtext = getText(signUpPkgObj.numberOfPackagesAvailable.get(i));
				Assert.assertTrue(
						pkgtext.replace("\n", ", ")
								.equals("Tradus Basic 70, Up to 70 active adverts, €250.00, per month (Excl. VAT)"),
						"Tradus Basic 70 attributes are not dislayed");
				break;
			}
			}
		}
	}
	
	/*
	 * Description:Verify only one package is displaying 'Tradus private 1' package is displaying for Private users
     *  Tradus Private 1 - upto 1 active advert - 8 euro/month"
	 */
	@Test
	public void verifyOnlyOnePackageforPrivateuseranditsinsights() throws Exception {
		SignUpPackageSectionTradusPROPage signUpPkgObj=new SignUpPackageSectionTradusPROPage(driver);
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		//signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpObj.commonFunctionForCheckingPackageWithValidDetails(signUpObj, "private");
		//signUpPkgObj.autoNavigateToPrivatePackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.privatePackageName);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.privatePackageName),
				"Private package selection page is not displayed");
		waitTill(2000);
		Assert.assertTrue(signUpPkgObj.numberOfPackagesAvailable.size()==1,
				"Only one package is not present in private packages page");
		String pkgtext=getText(signUpPkgObj.numberOfPackagesAvailable.get(0));
		//System.out.println(pkgtext.replace("\n",", "));
		Assert.assertTrue(pkgtext.replace("\n",", ").equals("Tradus Single 1, Up to 1 active adverts, €8.00, per month (Excl. VAT)"),
				"Tradus Single 1 attributes are not dislayed");
	}
	/*
	 * Description: Verify the 1st package i.,e tradus basic 10 is highlighted for company users 
	 */
	@Test
	public void verifyTradusBasic10highlightedinPackagepageforCompanyUser() throws Exception {
		SignUpPackageSectionTradusPROPage signUpPkgObj=new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionHeading),
				"Company package selection page is not displayed");
		waitTill(2000);
		String attValue=(signUpPkgObj.companyFirstPackageRadioButton).getAttribute("value");
		Assert.assertTrue(attValue.equals("84"), "tradus basic 10 isn't highlighted for company users");
	}
	
	/*
	 * Description: Verify 'You want to post more than 70 ads' text along with send request button is displaying
	 */
	@Test
	public void verifyYouWantToPostMoreThan70AdsAndRequestButtonInCompanyPackageSection() throws Exception {
		SignUpPackageSectionTradusPROPage signUpPkgObj= new SignUpPackageSectionTradusPROPage(driver);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionContent);
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionContent),
				"You want to post more than 70 ads?..text is not displaying in company users signup package page");
		Assert.assertTrue(verifyElementPresent(signUpPkgObj.companyPackageSectionSendRequestButton),
				"Send Request button is not displaying in company users signup package page");
	}
	
	/*
	 * Description: Verify confirmation page is displaying on choosing the valid package and clicking next button
	 */
	@Test
	public void verifyConfirmationPageonChoosingValidPackageAndClickingNext() throws Exception {
		SignupTPROPage signUpObj = new SignupTPROPage(driver);
		SignUpPackageSectionTradusPROPage signUpPkgObj= new SignUpPackageSectionTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
		signUpPkgObj.autoNavigateToCompanyPackagePage();
		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
             for(int i=0;i<signUpPkgObj.companyPackageRadioButtons.size();i++)
             {
            	 jsClick(driver, signUpPkgObj.companyPackageRadioButtons.get(i));
            	 waitTill(2000);
            	 click(signUpPkgObj.nextButton);
         		explicitWaitFortheElementTobeVisible(driver,signUpObj.confirmation);
         		Assert.assertTrue(verifyElementPresent(signUpObj.confirmation),
        				"Confirmation page is not displaying upon selecting valid package and clicking next");
         		jsClick(driver, signUpObj.packageIcon);
        		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.companyPackageSectionHeading);
             }
                loadUrl(driver, "https://pro.tradus.com/signup");
        		explicitWaitFortheElementTobeVisible(driver,signUpObj.emailField);
                signUpPkgObj.autoNavigateToPrivatePackagePage();
        		explicitWaitFortheElementTobeVisible(driver,signUpPkgObj.privateSinglePackage);
        		click(signUpPkgObj.nextButton);
        		explicitWaitFortheElementTobeVisible(driver,signUpObj.confirmation);
        		Assert.assertTrue(verifyElementPresent(signUpObj.confirmation),
        				"Confirmation page is not displaying upon selecting valid package and clicking next");
}
}
