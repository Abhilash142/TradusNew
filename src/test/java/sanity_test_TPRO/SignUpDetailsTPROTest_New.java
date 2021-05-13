package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.scrollUp;

import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.phoneNumberIN;
import static com.tradus.core.GlobalConstants.companyName;
import static com.tradus.core.GlobalConstants.webSIteLink;

import static com.tradus.core.ReadProp.getUserId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getAttribute;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpDetailsTPROPage_New;
import com.tradus.pro.pages.SignUpPackageTPROPage_New;
import com.tradus.pro.pages.SignupTPROPage;

public class SignUpDetailsTPROTest_New extends BaseClass {

	/*
	 * Description: Verify page is redirecting to TPRO landing page on clicking TPRO
	 * icon in header
	 * 
	 * @Test public void verifyPageisRedirectingToLandingPageTPro() throws Exception
	 * { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods();
	 * cm.verifyRedirectionofTPROLandingPageonClickingTPROIconinHeader(driver); }
	 * 
	 * 
	 * Description: Verify language drop down is displaying and 10 language options
	 * are displaying on clicking the drop down in header
	 * 
	 * @Test public void verifyLanguageDropdownandAllOptions() throws Exception{
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods();
	 * cm.verifyLanguageDropdownareDisplayingandAllLanguageOptionsarePresent(driver)
	 * ; }
	 * 
	 * 
	 * Description: Validate supportsilder's presence and functionalities
	 * 
	 * @Test public void validateSupportSlider() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.validateSupportSlider(driver); }
	 * 
	 * 
	 * Description:Verify 'Intelligent tools & data', 'Heavy machinery only' and
	 * 'Easy international trade' info is displaying under 'The benefits of selling
	 * on Tradus PRO Staging' text in left side of the page
	 * 
	 * @Test public void verifyBenifitsSection() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.verifyBenifitSectionandCorrespondingText(driver); }
	 * 
	 * 
	 * Description: Verify Sign in link and its Navigation
	 * 
	 * 
	 * @Test public void verifySignInLinkandItsNavigation() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000); CommonMethods cm=new
	 * CommonMethods(); cm.verifySignInLinkandItsNavigation(driver); }
	 * 
	 * 
	 * Description: Verify the third step 'Details' tab is highlighted
	 * 
	 * @Test public void verifyDetailsTabisHighlighted() throws Exception {
	 * SignUpPackageTPROPage_New pkjPgObj=new SignUpPackageTPROPage_New(driver);
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); accountPgObj.gotoDetailsPage(driver,
	 * "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,pkjPgObj.tabInfo);
	 * Assert.assertTrue((pkjPgObj.tabInfo).getCssValue("background-color").
	 * equals("rgba(0, 171, 189, 1)"),"Details section is not highlighted"); }
	 * 
	 * 
	 * Description: Verify back link and its functionality
	 * 
	 * @Test public void verifyBacklinkinDetailspageanditsFunctionlity() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * backButtoninDetailsPage); scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.backButtoninDetailsPage);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.
	 * accountsPageVerificationElement),
	 * "Accounts page isn't displayed upon clicking back button from details page");
	 * }
	 * 
	 * 
	 * Description: Verify Monthly cost info is displaying in the right side
	 * 
	 * @Test public void verifyMonthlyCostinfoDisplayingAtRightSide() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * monthlyCostSectioninDetailsPage);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * monthlyCostSectioninDetailsPage),
	 * "Monthly costs section is not displaying in Details page");
	 * 
	 * }
	 * 
	 * 
	 * Description: FAQ section, two questions and their content
	 * 
	 * @Test public void verifyFAQsectionandItsContent() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business", username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * FAQSectioninDetailsPage);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.FAQSectioninDetailsPage),
	 * "FAQ sesction is not present in details section");
	 * Assert.assertTrue(detailsPgObj.FAQsinDetailsPage.size()==
	 * 2,"Two FAQs are not displaying in details page"); scrollDown(driver);
	 * waitTill(2000); for(int i=0;i<detailsPgObj.FAQsinDetailsPage.size();i++) {
	 * if(!getAttribute(detailsPgObj.FAQsinDetailsPage.get(i),"class").contains(
	 * "open-item")){ switch (i) { case 0:
	 * click(detailsPgObj.FAQsinDetailsPage.get(i)); waitTill(1000); String
	 * firstContent=getText(detailsPgObj.FAQsinDetailsPage.get(i)).replace("\n",",")
	 * .trim(); //System.out.println(firstContent.replace(",keyboard_arrow_down",
	 * "")); Assert.assertTrue(firstContent.replace(",keyboard_arrow_down", "").
	 * equals("Why did my data pre-populate?,For customers in the EU with a VAT, we use the European Commission's VIES (VAT Information Exchange System) to pre-populate your information based on the VAT number entered. Based on the European Commission's VAT rules, your billing name & address must be registered with your VAT number to accurately charge or reverse charge VAT costs compulsory on your subscription. For customers in the EU with a VAT, we use the European Commission's VIES (VAT Information Exchange System) to pre-populate your information based on the VAT number entered. Based on the European Commission's VAT rules, your billing name & address must be registered with your VAT number to accurately charge or reverse charge VAT costs compulsory on your subscription."
	 * ), "Why did my data pre-populate? content has changed");
	 * Assert.assertTrue(firstContent.replace(",keyboard_arrow_down", "").
	 * equals("Why did my data pre-populate?,For customers in the EU with a VAT, we use the European Commission's VIES (VAT Information Exchange System) to pre-populate your information based on the VAT number entered. Based on the European Commission's VAT rules, your billing name & address must be registered with your VAT number to accurately charge or reverse charge VAT costs compulsory on your subscription."
	 * ), "Why did my data pre-populate? content has changed"); break;
	 * 
	 * case 1: click(detailsPgObj.FAQsinDetailsPage.get(i)); waitTill(1000); String
	 * secondContent=getText(detailsPgObj.FAQsinDetailsPage.get(i)).replace("\n",","
	 * ).trim(); //System.out.println(secondContent.replace(",keyboard_arrow_down",
	 * "")); Assert.assertTrue(secondContent.replace(",keyboard_arrow_down", "").
	 * equals("How will my contact information be used?,Only registered buyers who have created an account on can contact you. Interested buyers have the option to see your phone number, or send you an email. Only registered buyers who have created an account on can contact you. Interested buyers have the option to see your phone number, or send you an email."
	 * ), "How will my contact info be used? content has changed");
	 * Assert.assertTrue(secondContent.replace(",keyboard_arrow_down", "").
	 * equals("How will my contact information be used?,Only registered buyers who have created an account on can contact you. Interested buyers have the option to see your phone number, or send you an email."
	 * ), "How will my contact info be used? content has changed"); break; } } else
	 * { switch (i) { case 0:
	 * 
	 * String
	 * firstContent=getText(detailsPgObj.FAQsinDetailsPage.get(i)).replace("\n",",")
	 * .trim(); Assert.assertTrue(firstContent.replace(",keyboard_arrow_down", "").
	 * equals("Why did my data pre-populate?,For customers in the EU with a VAT, we use the European Commission's VIES (VAT Information Exchange System) to pre-populate your information based on the VAT number entered. Based on the European Commission's VAT rules, your billing name & address must be registered with your VAT number to accurately charge or reverse charge VAT costs compulsory on your subscription."
	 * ), "Why did my data pre-populate? content has changed"); break;
	 * 
	 * case 1:
	 * 
	 * String
	 * secondContent=getText(detailsPgObj.FAQsinDetailsPage.get(i)).replace("\n",","
	 * ).trim(); Assert.assertTrue(secondContent.replace(",keyboard_arrow_down",
	 * "").
	 * equals("How will my contact information be used?,Only registered buyers who have created an account on can contact you. Interested buyers have the option to see your phone number, or send you an email."
	 * ), "How will my contact info be used? content has changed"); break; } } } }
	 * 
	 * 
	 * Description: Verify Tax field is displaying on selecting any country and
	 * Verify VAT field is optional for Germany and non EU country users
	 * 
	 * @Test public void verifyTaxfieldfornonEUcountriesandVATfieldforEUcountries()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("India");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt)); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsTaxNoTextField),
	 * "Tax field is not present for non-EU country"); randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt)); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsVATNoTextField),
	 * "VAT field is not present for EU country"); randomInt =
	 * listOfCOuntriesNames.indexOf("Germany");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt)); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsVATNoOptionalTextField),
	 * "Optional VAT field is not present for Germany");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify company name, Phone, address, zip code, city, billing
	 * email, website and Payment refrerence fields are displaying in 'company
	 * details' section
	 * 
	 * @Test public void verifyAllfieldsarePresentinCompanyDetailsSection() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * if(!getAttribute(detailsPgObj.companyDetailsSection,"class").contains(
	 * "open-item")) { click(detailsPgObj.companyDetailsSection); waitTill(2000); }
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsCompanyNameTextField),
	 * "Company name field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPhoneTextField),
	 * "Phone number field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsCompanyAddressTextField),
	 * "Address field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsCompanyZIPTextField),
	 * "ZIP field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCityTextField),
	 * "City field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsCompanyWebsiteTextField),
	 * "Website field isn't present in Company details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsPaymentReference),
	 * "Payment reference field isn't present in Company details section"); }
	 * 
	 * 
	 * Description: Verify Company name, Address, city, zip code and billing emails
	 * fields are auto filled on giving valid EU VAT number (Ex:NL854502130B01)
	 * 
	 * @Test public void verifyAutofillingOffieldsonGivingEUVATno() throws Exception
	 * { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	 * //waitTill(5000); int i=0; while(i<3) {
	 * if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty())
	 * { waitTill(2000); i++; } else { break; } }
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyNameTextField,
	 * "value").equals("TRADUS B.V."),
	 * "Company name is not populated after entering valid VAT no");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyZIPTextField,
	 * "value").equals("1097DN"),
	 * "ZIP Code is not populated after entering valid VAT no");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsCompanyAddressTextField,
	 * "value").equals("WIBAUTSTRAAT 00137 C"),
	 * "Address is not populated after entering valid VAT no");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsCityTextField,
	 * "value").equals("AMSTERDAM"),
	 * "City is not populated after entering valid VAT no");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify error is displaying in VAT field for giving invalid vat
	 * for EU countries
	 * 
	 * @Test public void verifyErrorforInvalidVATforEUcountries() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"1234567898765"); waitTill(3000);
	 * Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().
	 * equals("Incorrect VAT number, please type a correct value"),
	 * "Alert for incorrect VAT is not correct");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify error message at phone number field if it's empty/invalid
	 * 
	 * @Test public void verifyErrorMessageAtPhonenumberFieldifitsInvalid() throws
	 * Exception{ SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	 * waitTill(3000); sendKeys(detailsPgObj.detailsPhoneTextField,"987654");
	 * waitTill(1000);
	 * Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().
	 * equals("This phone number is not valid."),
	 * "Correct error message is not displaying for invalid phone field");
	 * sendKeys(detailsPgObj.detailsPhoneTextField,""); waitTill(1000);
	 * Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().
	 * equals("The phone field is required"),
	 * "Correct error message is not displaying for blank phone field");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify Contact person and mobile phone number fields are
	 * displaying in contact details section
	 * 
	 * @Test public void verifyContactPersonandMobilePhoneFieldsinContactSection()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * contactDetailsSection);
	 * if(!getAttribute(detailsPgObj.contactDetailsSection,"class").contains(
	 * "open-item")) { click(detailsPgObj.contactDetailsSection); waitTill(2000); }
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsContactPersonTextField),
	 * "Contact person field isn't present in Contact details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsMobilePhoneTextField),
	 * "Mobile Phone number field isn't present in Contact details section");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsAvailableOnWhatsAppCheckbox),
	 * "Available on whats app checkbox isn't present in Contact details section");
	 * }
	 * 
	 * 
	 * Description: Verify error message at contact person field on trying to
	 * proceed to next step without filling
	 * 
	 * @Test public void verifyErrorMessageAtContactPersonfieldifleftBlank() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	 * waitTill(3000); scrollDown(driver); waitTill(3000);
	 * click(detailsPgObj.createAnAccountButtoninDetailsPage); waitTill(5000);
	 * Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim()
	 * .equals("The contact person field is required"),
	 * "Correct error message is not displaying for Contact Name field"); }
	 * 
	 * 
	 * Description: Verify on trying to go to next step without enabling the
	 * Whatsapp checkbox
	 * 
	 * @Test public void verifyTryingtoGotoNextstepwithoutenablingWhatsAppCheckbox()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01"); int i=0;
	 * while(i<3) { if(getAttribute(detailsPgObj.detailsCompanyNameTextField,
	 * "value").isEmpty()) { waitTill(2000); i++; } else { break; } }
	 * sendKeys(detailsPgObj.detailsPhoneTextField,"31234567887");
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
	 * scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying if whats app checkbox is not checked");
	 * 
	 * }
	 * 
	 * Description: Verify on trying to go to next step with enabling the Whatsapp
	 * checkbox
	 * 
	 * @Test public void verifyTryingtoGotoNextstepwithEnablingWhatsAppCheckbox()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01"); int i=0;
	 * while(i<3) { if(getAttribute(detailsPgObj.detailsCompanyNameTextField,
	 * "value").isEmpty()) { waitTill(2000); i++; } else { break; } }
	 * sendKeys(detailsPgObj.detailsPhoneTextField,"31234567887");
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
	 * scrollToElement(driver,detailsPgObj.detailsAvailableOnWhatsAppCheckbox);
	 * waitTill(2000); click(detailsPgObj.detailsAvailableOnWhatsAppCheckbox);
	 * scrollDown(driver); waitTill(2000);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying if whats app checkbox is checked"); }
	 * 
	 * 
	 * Description: Verify VAT amount also if applicable in monthly cost info
	 * 
	 * @Test public void verifyVATAmountinMonthlyCostifApplicable() throws Exception
	 * { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * vatSectionInMonthlyCost);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.vatSectionInMonthlyCost),
	 * "VAT section is not displaying if EU country is selected");
	 * Assert.assertTrue(getText(detailsPgObj.vatPriceInMonthlyCost).trim().equals(
	 * "€10.50"), "VAT amount is not same as €10.50 for EU countries");
	 * Assert.assertTrue(getText(detailsPgObj.totalPriceInMonthlyCost).trim().equals
	 * ("€60.50"),
	 * "Total price amount is not same as €60.50 for EU countries for 10 ads package"
	 * ); }
	 * 
	 * 
	 * Description: Verify only contact details and billing information sections are
	 * displaying for private user
	 * 
	 * @Test public void verifyConactandBillinginfoforPrivateUsers() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "indivisual",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * contactDetailsSectionforIndivisual),
	 * "Contact details section isn't present for indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * billingInfoSectionforIndivisual),
	 * "Billing info section isn't present for indivisaul user");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify full name, phone, mobile phone, address, city, zip code,
	 * country and billing email fields are displaying under contact details
	 * 
	 * @Test public void verifyPresenceOfAllAttributeunderContactDetailsSection()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "indivisual",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * fullNameFieldforIndivisualUser),
	 * "Full name field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * phoneNumberFieldforIndivisualUser),
	 * "Phone number field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * mobilePhoneNumberFieldforIndivisualUser),
	 * "Mobile phone field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * addressFieldforIndivisualUser),
	 * "Address field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * cityFieldforIndivisualUser), "City field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.ZIPfieldforIndivisualUser
	 * ), "ZIP field is present for Indivisual users");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.detailsCountryDropdown),
	 * "Country field is present for Indivisual users"); }
	 * 
	 * 
	 * Description: Verify all details are mandatory except mobile phone number
	 * 
	 * @Test public void verifyAlldetailsareMandatoryExceptMobilePhone() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "indivisual",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); scrollDown(driver); waitTill(2000);
	 * List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.createAnAccountButtoninDetailsPage); waitTill(2000);
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).trim().
	 * equals("The full name field is required"),
	 * "Alert is incorrect when Full name field is left blank");
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"Harish");
	 * Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling name field");
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.phoneNumberFieldDangerText).trim().
	 * equals("The phone field is required"),
	 * "Alert is incorrect when phone number field is left blank");
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,phoneNumber);
	 * Assert.assertTrue(getText(detailsPgObj.phoneNumberFieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling phone number field");
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).trim().
	 * equals("The address field is required"),
	 * "Alert is incorrect when address field is left blank");
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
	 * Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling address field ");
	 * 
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).trim().
	 * equals("The zip code field is required"),
	 * "Alert is incorrect when ZIP Code field is left blank");
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode);
	 * Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling ZIP field ");
	 * 
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).trim().
	 * equals("The country field is required"),
	 * "Alert is incorrect when country field is left blank");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling Country field");
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).trim().
	 * equals("The city field is required"),
	 * "Alert is incorrect when city field is left blank");
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
	 * Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).isEmpty(),
	 * "Alert is still displaying even after filling City field");
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.mobilePhonefieldDangerText).isEmpty(),
	 * "Alert is displaying for blank mobile number field though not mandatory");
	 * 
	 * click(detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * makePaymentButtonPaymentpage),
	 * "Make a payment button is not present in payment page for indivisual users");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify 'Use the same information for billing' toggle switch is
	 * displaying below the details
	 * 
	 * @Test public void verifyUseSameInfoTooglebelowDetails() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String[] user=
	 * {"indivisual","business"}; for(int i=0;i<user.length;i++) { String
	 * Uid=getUserId(); accountPgObj.gotoDetailsPage(driver, "indivisual",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.billingInfoSection);
	 * waitTill(2000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.billingInfoSection)
	 * ,"Billing info section is not present");
	 * //Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInformationTooglebutton),"Billing toogle button is not present"
	 * ); } }
	 * 
	 * 
	 * Description: Verify Contact person,Company name, billing email, address,
	 * city, zip code, country and phone number fields are displaying below 'Billing
	 * information text on ofcourse disabling the toggle switch
	 * 
	 * @Test public void verifyAllattributesinBillingInfoArea() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoCompanyTextbox),
	 * "Company field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoEmailTextbox),
	 * "Billing email field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoCountryTextbox),
	 * "Country field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoCityTextbox), "City field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoAddressTextbox),
	 * "Address field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoZIPTextbox), "ZIP field is present under billing info");
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * detailsBillingInfoPhoneTextbox),
	 * "Phone field is present under billing info"); }
	 * 
	 * 
	 * Description: Verify Company name, address, city and zip code fields are auto
	 * filled and disabled for valid EU VAT users
	 * 
	 * @Test public void verifyAutofillinginBillingInfoSectionforValidEUVatNo()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * accountPgObj.gotoDetailsPage(driver, "business",username);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01"); int i=0;
	 * while(i<3) { if(getAttribute(detailsPgObj.detailsCompanyNameTextField,
	 * "value").isEmpty()) { waitTill(2000); i++; } else { break; } }
	 * scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCompanyTextbox,
	 * "value").trim().equals("TRADUS B.V."),
	 * "Correct Company Name isn't displaying in billing address after filling valid VAT number."
	 * );
	 * Assert.assertFalse((detailsPgObj.detailsBillingInfoCompanyTextbox).isEnabled(
	 * ),
	 * "Company Name field isn't disable in billing address after filling valid VAT number."
	 * );
	 * 
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoAddressTextbox,
	 * "value").trim().equals("WIBAUTSTRAAT 00137 C"),
	 * "Correct address isn't displaying in billing address after filling valid VAT number."
	 * );
	 * Assert.assertFalse((detailsPgObj.detailsBillingInfoAddressTextbox).isEnabled(
	 * ),
	 * "Address field is disable in billing address after filling valid VAT number."
	 * );
	 * 
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCityTextbox,
	 * "value").trim().equals("AMSTERDAM"),
	 * "Correct city name isn't displaying in billing address after filling valid VAT number."
	 * );
	 * Assert.assertFalse((detailsPgObj.detailsBillingInfoCityTextbox).isEnabled(),
	 * "City name field isn't disable in billing address after filling valid VAT number."
	 * );
	 * 
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoZIPTextbox,
	 * "value").trim().equals("1097DN"),
	 * "Correct ZIP value isn't displaying in billing address after filling valid VAT number."
	 * );
	 * Assert.assertFalse((detailsPgObj.detailsBillingInfoZIPTextbox).isEnabled(),
	 * "ZIP Code field isn't disable in billing address after filling valid VAT number."
	 * );
	 * 
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify error message at particular field on missing any
	 * mandatory field and trying to go to next step for EU user VAT: NL854502130B01
	 * 
	 * @Test public void
	 * verifyErrorMessageAtperticualrFieldonMissingMandatoryFieldforEUuser() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	 * //waitTill(5000); int i=0; while(i<3) {
	 * if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty())
	 * { waitTill(2000); i++; } else { break; } }
	 * sendKeys(detailsPgObj.detailsPhoneTextField,"31234567887");
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
	 * scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCompanyTextbox,
	 * "value").trim().equals("TRADUS B.V."),
	 * "Correct Company Name isn't displaying in billing address after filling valid VAT number."
	 * );
	 * Assert.assertFalse((detailsPgObj.detailsBillingInfoCityTextbox).isEnabled(),
	 * "City name field isn't disable in billing address after filling valid VAT number."
	 * );
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,
	 * "value").trim().equals(Uid)
	 * ,"Emails in billing sextion isn't same as the inserted email in Accounts page"
	 * ); sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,"");
	 * sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,"");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(2000); Assert.assertTrue(getText(detailsPgObj.
	 * billingEmailDangerTextindetailsBillingInfo).trim().
	 * equals("The email field is required"),
	 * "Error message is incorrect for email field in billing info when left blank"
	 * ); Assert.assertTrue(getText(detailsPgObj.
	 * phoneFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The phone field is required"),
	 * "Error message is incorrect for email field in billing info when left blank"
	 * ); waitTill(5000); sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,Uid);
	 * sendKeys(detailsPgObj.detailsBillingInfoContactPersonTextbox,"Harish");
	 * sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,"31234567887");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying when billing info filled manually for EU user"
	 * ); }
	 * 
	 * 
	 * Description: Verify error message at particular field on missing any
	 * mandatory field and trying to go to next step for Non-EU user
	 * 
	 * @Test public void
	 * verifyErrorMessageatPerticualrFieldonMissingMandatoryFieldforNonEUuser()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("India");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsTaxNoTextField);
	 * sendKeys(detailsPgObj.detailsTaxNoTextField,"987654658");
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCompanyNameTextField); waitTill(2000);
	 * sendKeys(detailsPgObj.detailsCompanyNameTextField,companyName);
	 * sendKeys(detailsPgObj.detailsPhoneTextField,phoneNumberIN);
	 * sendKeys(detailsPgObj.detailsCompanyAddressTextField,companyAddress);
	 * sendKeys(detailsPgObj.detailsCompanyZIPTextField,zipCode);
	 * sendKeys(detailsPgObj.detailsCityTextField,cityName);
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
	 * scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCompanyTextbox,
	 * "value").trim().equals(companyName),
	 * "Correct Company Name isn't displaying in billing address for non-EU users");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoCityTextbox,
	 * "value").trim().equals(cityName),
	 * "Correct City Name isn't displaying in billing address for non-EU users");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoZIPTextbox,
	 * "value").trim().equals(zipCode),
	 * "Correct Zip code isn't displaying in billing address for non-EU users");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoAddressTextbox,
	 * "value").trim().equals(companyAddress),
	 * "Correct Company address isn't displaying in billing address for non-EU users"
	 * ); Assert.assertTrue(getAttribute(detailsPgObj.
	 * detailsBillingInfoContactPersonTextbox,"value").isEmpty(),
	 * "Contact person field isn't empty in billing info section for non-EU users");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,
	 * "value").isEmpty(),
	 * "Contact person field isn't empty in billing info section for non-EU users");
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoPhoneTextbox,
	 * "value").isEmpty(),
	 * "Phone field isn't empty in billing info section for non-EU users");
	 * sendKeys(detailsPgObj.detailsBillingInfoCompanyTextbox,"");
	 * sendKeys(detailsPgObj.detailsBillingInfoCityTextbox,"");
	 * sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,"");
	 * sendKeys(detailsPgObj.detailsBillingInfoAddressTextbox,"");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(2000); Assert.assertTrue(getText(detailsPgObj.
	 * billingEmailDangerTextindetailsBillingInfo).trim().
	 * equals("The email field is required"),
	 * "Error message is incorrect for email field in billing info when left blank"
	 * ); Assert.assertTrue(getText(detailsPgObj.
	 * companyContactPersonDangerTextinBillingInfo).trim().
	 * equals("The contact person field is required"),
	 * "Error message is incorrect for Contact person field in billing info when left blank"
	 * ); Assert.assertTrue(getText(detailsPgObj.
	 * phoneFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The phone field is required"),
	 * "Error message is incorrect for email field in billing info when left blank"
	 * ); Assert.assertTrue(getText(detailsPgObj.
	 * companyNameDangerTextindetailsBillingInfo).trim().
	 * equals("The company name field is required"),
	 * "Error message is incorrect for Company name field in billing info when left blank"
	 * );
	 * Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).
	 * trim().equals("The city field is required"),
	 * "Error message is incorrect for City field in billing info when left blank");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * addressFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The address field is required"),
	 * "Error message is incorrect for Address field in billing info when left blank"
	 * );
	 * Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo
	 * ).trim().equals("The zip code field is required"),
	 * "Error message is incorrect for ZIP Code field in billing info when left blank"
	 * ); sendKeys(detailsPgObj.detailsBillingInfoCompanyTextbox,companyName);
	 * sendKeys(detailsPgObj.detailsBillingInfoCityTextbox,cityName);
	 * sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,zipCode);
	 * sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,Uid);
	 * sendKeys(detailsPgObj.detailsBillingInfoContactPersonTextbox, "Harish");
	 * sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox,phoneNumberIN);
	 * sendKeys(detailsPgObj.detailsBillingInfoAddressTextbox,companyAddress);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying when billing info filled manually for non-EU user"
	 * );
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify error message at particular field on missing any
	 * mandatory field and trying to go to next step for private user
	 * 
	 * @Test public void
	 * verifyErrorMessageatPerticualrFieldonMissingMandatoryFieldforPrivateuser()
	 * throws Exception{ SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); waitTill(1000); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "private",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("India");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"Harish");
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,phoneNumberIN);
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode); scrollDown(driver);
	 * waitTill(2000); click(detailsPgObj.detailsBillingInformationTooglebutton);
	 * waitTill(1000);
	 * Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoEmailTextbox,
	 * "value").trim().isEmpty(),
	 * "Billing Email field is autopopulated in billing info section for private user"
	 * ); Assert.assertTrue(getAttribute(detailsPgObj.detailsBillingInfoZIPTextbox,
	 * "value").trim().equals(zipCode),
	 * "Zip code field isn't autopopulated in billing info section for private user"
	 * ); sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,"");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(2000); Assert.assertTrue(getText(detailsPgObj.
	 * billingEmailDangerTextindetailsBillingInfo).trim().
	 * equals("The email field is required"),
	 * "Error message is incorrect for email field in billing info when left blank"
	 * );
	 * Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo
	 * ).trim().equals("The zip code field is required"),
	 * "Error message is incorrect for ZIP Code field in billing info when left blank"
	 * ); sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox,Uid);
	 * 
	 * sendKeys(detailsPgObj.detailsBillingInfoZIPTextbox,zipCode);
	 * 
	 * sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox, phoneNumberIN);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying when billing info filled manually for private user"
	 * );
	 * 
	 * }
	 * 
	 * 
	 * (Sign up - Details page for Private users) Description : Validate all the
	 * fields
	 * 
	 * @Test public void validatePrivateDetailsPageFields() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); waitTill(2000); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "private",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * fullNameFieldforIndivisualUser);
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"$%^&#");
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,"$%^&#");
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser,"$%^&#");
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser,"$%^&#");
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,"$%^&#"); scrollDown(driver);
	 * waitTill(2000); click(detailsPgObj.detailsBillingInformationTooglebutton);
	 * waitTill(1000);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(1000);
	 * Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).trim().
	 * equals("The full name value is not valid"
	 * ),"Incorrect error message when Full name field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).trim().
	 * equals("The address value is not valid"
	 * ),"Incorrect error message when address field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).trim().
	 * equals("The city value is not valid"
	 * ),"Incorrect error message when city field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).trim().
	 * equals("The zip code value is not valid"
	 * ),"Incorrect error message when ZIP Code field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).
	 * trim().
	 * equals("The city field may only contain alphabetic characters as well as spaces"
	 * ),"Incorrect error message when city field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * addressFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The address value is not valid"
	 * ),"Incorrect error message when address field entered with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().
	 * equals("The zip code value is not valid"
	 * ),"Incorrect error message when ZIP field entered with wrong data");
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser," ");
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser," ");
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser," ");
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser," ");
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser," "); scrollDown(driver);
	 * waitTill(2000); click(detailsPgObj.detailsBillingInformationTooglebutton);
	 * sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox," ");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(1000);
	 * Assert.assertTrue(getText(detailsPgObj.fullNamefieldDangerText).trim().
	 * equals("The full name field is required"
	 * ),"Incorrect error message when Full name field left blank");
	 * Assert.assertTrue(getText(detailsPgObj.addressFieldDangerText).trim().
	 * equals("The address field is required"
	 * ),"Incorrect error message when address field left blank");
	 * Assert.assertTrue(getText(detailsPgObj.cityFieldDangerText).trim().
	 * equals("The city field is required"
	 * ),"Incorrect error message when city ffield left blank");
	 * Assert.assertTrue(getText(detailsPgObj.ZIPfieldDangerText).trim().
	 * equals("The zip code field is required"
	 * ),"Incorrect error message when ZIP Code field left blank");
	 * //Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).trim().
	 * equals("The country field is required"
	 * ),"Incorrect error message when country field left blank");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * billingEmailDangerTextindetailsBillingInfo).trim().
	 * equals("The email field is required"
	 * ),"Incorrect error message when contact person field left blank in billing info"
	 * ); //Assert.assertTrue(getText(detailsPgObj.
	 * countryFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The country field is required"
	 * ),"Incorrect error message when Country field left blank in billing info");
	 * 
	 * Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().
	 * equals("The zip code field is required"
	 * ),"Incorrect error message when ZIP field left blank in billing info");
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(2000);
	 * List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt)); waitTill(1000);
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,"Harish");
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,phoneNumber);
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode); waitTill(5000);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying for private user");
	 * 
	 * }
	 * 
	 * 
	 * (Sign up - Details page for Business users) Description : Validate all the
	 * fields
	 * 
	 * @Test public void validateAllFieldsinDetailsPageforBusinessUser() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); waitTill(2000); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver); String Uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",Uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown); sendKeys(detailsPgObj.detailsVATNoTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsCompanyNameTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsPhoneTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsCompanyAddressTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsCompanyZIPTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsCityTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsCompanyWebsiteTextField,"#$%^");
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"#$%^");
	 * scrollDown(driver); waitTill(2000);
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(2000);
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(1000); //
	 * Assert.assertTrue(getText(detailsPgObj.countryfieldDangerText).trim().
	 * equals("The country field is required"),
	 * "Alert in country field is incorrect if left blank");
	 * Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().
	 * equals("Incorrect VAT number, please type a correct value"),
	 * "Alert in tax field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsCompanyNamefieldDangerText).
	 * trim().equals("The company name value is not valid"),
	 * "Alert in company name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsAddressDangerText).trim().
	 * equals("The address value is not valid"),
	 * "Alert in company Address field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().
	 * equals("The zip code value is not valid"),
	 * "Alert in ZIP code field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsCityDangerText).trim().
	 * equals("The city value is not valid"),
	 * "Alert in city field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsWebsiteDangerText).trim().
	 * equals("The website field is not a valid URL"),
	 * "Alert in website field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim()
	 * .equals("The contact person value is not valid"),
	 * "Alert in Contact person field is incorrect when insert with wrong data");
	 * //Assert.assertTrue(getText(detailsPgObj.
	 * companyContactPersonDangerTextinBillingInfo).trim().
	 * equals("The contact person value is not valid"),
	 * "Alert in Contact person field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * companyNameDangerTextindetailsBillingInfo).trim().
	 * equals("The company name value is not valid"),
	 * "Alert in Compnay name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).
	 * trim().
	 * equals("The city field may only contain alphabetic characters as well as spaces"
	 * ), "Alert in City name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * addressFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The address value is not valid"),
	 * "Alert in address field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo
	 * ).trim().equals("The zip code value is not valid"),
	 * "Alert in zip code field is incorrect when insert with wrong data");
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(1000);
	 * scrollUp(driver); waitTill(2000); List<WebElement> listOfCountries =
	 * detailsPgObj.countryDropdownvaluesInnerHtml; ArrayList<String>
	 * listOfCOuntriesNames = listOfCountries.stream().map(c ->
	 * c.getAttribute("innerHTML").trim())
	 * .collect(Collectors.toCollection(ArrayList::new)); int randomInt =
	 * listOfCOuntriesNames.indexOf("Netherlands");
	 * click(detailsPgObj.detailsCountryDropdown); waitTill(1000);
	 * click(listOfCountries.get(randomInt));
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsVATNoTextField); sendKeys(detailsPgObj.detailsVATNoTextField," ");
	 * sendKeys(detailsPgObj.detailsCompanyNameTextField," ");
	 * sendKeys(detailsPgObj.detailsPhoneTextField," ");
	 * sendKeys(detailsPgObj.detailsCompanyAddressTextField," ");
	 * sendKeys(detailsPgObj.detailsCompanyZIPTextField," ");
	 * sendKeys(detailsPgObj.detailsCityTextField," ");
	 * sendKeys(detailsPgObj.detailsCompanyWebsiteTextField," ");
	 * sendKeys(detailsPgObj.detailsContactPersonTextField," "); scrollDown(driver);
	 * waitTill(2000); click(detailsPgObj.detailsBillingInformationTooglebutton);
	 * waitTill(2000); sendKeys(detailsPgObj.detailsBillingInfoEmailTextbox," ");
	 * sendKeys(detailsPgObj.detailsBillingInfoPhoneTextbox," ");
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * waitTill(1000);
	 * Assert.assertTrue(getText(detailsPgObj.VATfieldDangerText).trim().
	 * equals("The vat number field is required"),
	 * "Alert in VAT field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsCompanyNamefieldDangerText).
	 * trim().equals("The company name field is required"),
	 * "Alert in company name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsPhoneDangerText).trim().
	 * equals("The phone field is required"),
	 * "Alert in phone number field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsAddressDangerText).trim().
	 * equals("The address field is required"),
	 * "Alert in company Address field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsZIPCodeDangerText).trim().
	 * equals("The zip code field is required"),
	 * "Alert in ZIP code field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsCityDangerText).trim().
	 * equals("The city field is required"),
	 * "Alert in city field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsWebsiteDangerText).trim().
	 * equals("The website field is not a valid URL"),
	 * "Alert in website field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.detailsContactPersonDangerText).trim()
	 * .equals("The contact person field is required"),
	 * "Alert in Contact person field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * companyNameDangerTextindetailsBillingInfo).trim().
	 * equals("The company name field is required"),
	 * "Alert in Compnay name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.cityDangerTextindetailsBillingInfo).
	 * trim().equals("The city field is required"),
	 * "Alert in City name field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.
	 * addressFieldDangerTextindetailsBillingInfo).trim().
	 * equals("The address field is required"),
	 * "Alert in address field is incorrect when insert with wrong data");
	 * Assert.assertTrue(getText(detailsPgObj.zipFieldDangerTextindetailsBillingInfo
	 * ).trim().equals("The zip code field is required"),
	 * "Alert in zip code field is incorrect when insert with wrong data");
	 * click(detailsPgObj.detailsBillingInformationTooglebutton); waitTill(2000);
	 * scrollUp(driver);
	 * sendKeys(detailsPgObj.detailsVATNoTextField,"NL854502130B01");
	 * //waitTill(5000); int i=0; while(i<3) {
	 * if(getAttribute(detailsPgObj.detailsCompanyNameTextField, "value").isEmpty())
	 * { waitTill(2000); i++; } else { break; } }
	 * sendKeys(detailsPgObj.detailsContactPersonTextField,"Harish");
	 * sendKeys(detailsPgObj.detailsPhoneTextField,phoneNumber);
	 * sendKeys(detailsPgObj.detailsCompanyWebsiteTextField,webSIteLink);
	 * 
	 * jsClick(driver,detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(detailsPgObj.
	 * paymentPageVerificationElement),
	 * "Payment page is not displaying when billing info filled manually for business user"
	 * );
	 * 
	 * }
	 */

}
