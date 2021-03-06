package sanity_test_TPRO;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollToElement;

import static com.tradus.core.ReadProp.getUserId;

import static com.tradus.core.GlobalConstants.username;
import static com.tradus.core.GlobalConstants.phoneNumber;
import static com.tradus.core.GlobalConstants.cityName;
import static com.tradus.core.GlobalConstants.zipCode;
import static com.tradus.core.GlobalConstants.companyAddress;
import static com.tradus.core.GlobalConstants.contactPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getAttribute;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.SignUpAccountsTPROPage_New;
import com.tradus.pro.pages.SignUpConfirmationTPROPage_New;
import com.tradus.pro.pages.SignUpDetailsTPROPage_New;

public class SignUpConfirmationTPROTest_New extends BaseClass {

	/*
	 * Description: Verify confirmation steps is highighted, Verify all the given
	 * details in Details page are displaying under 'Customer summary' including
	 * billing information info in the left side for dealers
	 */
	/*
	 * @Test public void
	 * verifyConfirmationSectionisHighlightedandaddDetailsareDisplaying() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue((confirmationPgObj.tabInfo).getCssValue("background-color")
	 * .equals("rgba(0, 171, 189, 1)"),"Details section is not highlighted");
	 * Assert.assertTrue(getText(confirmationPgObj.companyNameinBllingPage).
	 * equals("TRADUS B.V."),
	 * "Company name varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.vatNumberinBillingPage).equals(
	 * "NL854502130B01"), "VAT no varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.addressInBillingPage).
	 * equals("WIBAUTSTRAAT 00137 C"),
	 * "Address varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.zipCodeInBillingPage).equals(
	 * "1097DN"), "ZIP Code varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.cityInBillingPage).equals(
	 * "AMSTERDAM"), "City varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.phoneNumberBillingPage).equals(
	 * "+31234567887"),
	 * "Phone number varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.countryInBillingPage).equals(
	 * "Netherlands"), "Country varies from details page to confirmation page");
	 * 
	 * 
	 * Assert.assertTrue(getText(confirmationPgObj.BillingContactPersonInBillingPage
	 * ).equals("Harish"), "Contact person for details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingEmailaddressInBillingPage)
	 * .equals(uid), "Billing email varies for details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingAddressInBillingPage).
	 * equals("WIBAUTSTRAAT 00137 C"),
	 * "Billing address varies for details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingZIPCodeInBillingPage).
	 * equals("1097DN"), "ZIP Code varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingCityInBillingPage).equals(
	 * "AMSTERDAM"), "City varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingPhoneInBillingPage).equals
	 * ("+31234567887"),
	 * "Phone number varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingCountryInBillingPage).
	 * equals("Netherlands"),
	 * "Country varies from details page to confirmation page");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify all the given details in Details page are displaying
	 * under 'Customer summary' including billing information info in the left side
	 * for dealers
	 * 
	 * @Test public void
	 * verifyConfirmationSectionisHighlightedandaddDetailsareDisplayingforIndivisualUser
	 * () throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "indivisual",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement); waitTill(2000);
	 * sendKeys(detailsPgObj.fullNameFieldforIndivisualUser,contactPerson);
	 * sendKeys(detailsPgObj.phoneNumberFieldforIndivisualUser,"31234567887");
	 * sendKeys(detailsPgObj.addressFieldforIndivisualUser,companyAddress);
	 * sendKeys(detailsPgObj.cityFieldforIndivisualUser,cityName);
	 * sendKeys(detailsPgObj.ZIPfieldforIndivisualUser,zipCode);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands"); scrollDown(driver);
	 * waitTill(2000); click(detailsPgObj.createAnAccountButtoninDetailsPage);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * paymentPageVerificationElement); waitTill(2000);
	 * Assert.assertTrue((confirmationPgObj.tabInfo).getCssValue("background-color")
	 * .equals("rgba(0, 171, 189, 1)"),"Details section is not highlighted");
	 * Assert.assertTrue(getText(confirmationPgObj.fullNameInBillingPage).equals(
	 * contactPerson), "Full name varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.addressInBillingPage).equals(
	 * companyAddress), "Address varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.zipCodeInBillingPage).equals(
	 * zipCode), "ZIP Code varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.cityInBillingPage).equals(
	 * cityName), "City varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.phoneNumberBillingPage).equals(
	 * "+31234567887"),
	 * "Phone number varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.countryInBillingPage).equals(
	 * "Netherlands"), "Country varies from details page to confirmation page");
	 * 
	 * Assert.assertTrue(getText(confirmationPgObj.billingEmailaddressInBillingPage)
	 * .equals(uid), "Billing email varies for details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingAddressInBillingPage).
	 * equals(companyAddress),
	 * "Billing address varies for details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingZIPCodeInBillingPage).
	 * equals(zipCode), "ZIP Code varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingCityInBillingPage).equals(
	 * cityName), "City varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingPhoneInBillingPage).equals
	 * ("+31234567887"),
	 * "Phone number varies from details page to confirmation page");
	 * Assert.assertTrue(getText(confirmationPgObj.billingCountryInBillingPage).
	 * equals("Netherlands"),
	 * "Country varies from details page to confirmation page");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify all 4 FAQ under customer summary
	 * 
	 * 
	 * public void verifyAll4FAQs() throws Exception { SignUpAccountsTPROPage_New
	 * accountPgObj=new SignUpAccountsTPROPage_New(driver);
	 * SignUpDetailsTPROPage_New detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); waitTill(2000);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * FAQSectionInBillingPage);
	 * //System.out.println(getText(confirmationPgObj.FAQSectionInBillingPage).
	 * replace("\n", ",").trim()); List<WebElement> FAQs=
	 * confirmationPgObj.FAQsInBillingPage; System.out.println(FAQs.size());
	 * click(confirmationPgObj.FAQno1); waitTill(1000);
	 * Assert.assertTrue(getText(confirmationPgObj.FAQinternalText.get(0)).
	 * equals("You will be billed on a recurring basis, once a month starting on the activation date of your account. youWillBeBilled"
	 * ) ,"Inside content of 1st FAQ has been changed");
	 * click(confirmationPgObj.FAQno2); waitTill(1000);
	 * Assert.assertTrue(getText(confirmationPgObj.FAQinternalText.get(1)).
	 * equals("Yes, you can request the cancellation of your account at any time. Upon cancellation, your account will remain live and you will be charged through the end of your current billing cycle. Cancellation requests for the next billing cycle must be received before the last day of your current billing cycle in order for cancellation to take effect. youCanRequestTheCancellation"
	 * ) ,"Inside content of 2nd FAQ has been changed");
	 * click(confirmationPgObj.FAQno3); waitTill(1000);
	 * Assert.assertTrue(getText(confirmationPgObj.FAQinternalText.get(2)).
	 * equals("Yes, you can request an upgrade or downgrade of your plan at any time. Changes to your plan will take place at the start of your next billing cycle. youCanRequestAnUpgradeOrDowngrade"
	 * ), "Inside content of 3rd FAQ has been changed");
	 * click(confirmationPgObj.FAQno4); waitTill(1000);
	 * Assert.assertTrue(getText(confirmationPgObj.FAQinternalText.get(3)).
	 * equals("For security purposes, our team reviews all accounts before your ads are shown to buyers. We will review your information within 24 hours of account creation. Your payment will be refunded if your account is not approved. forSecurityPurposesReviewAccount"
	 * ), "Inside content of 4th FAQ has been changed");
	 * 
	 * }
	 * 
	 * Description: Verify 'Order section' is displaying to the right side and
	 * Verify chosen package, price, vat and total price per month is displaying
	 * 
	 * @Test public void verifyOrderSectionandSubscribedPackageInfo() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * yourOrderHeadingInPaymentPage); waitTill(2000);
	 * Assert.assertTrue(getText(confirmationPgObj.yourOrderSectionBillingPage).
	 * replace("\n",
	 * ",").trim().equals("10 listings,???50.00,VAT ???10.50,Total per month,???60.50"),
	 * "Subscribed package details are not displaying correcly in your order section"
	 * );
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify 'Paypal', 'Credit card' and 'Stripe' options are
	 * displaying under 'Payment methods'
	 * 
	 * @Test public void
	 * verifyPaypalCreditAndStripeOptionsareDispalyingunderPaymenrMethods() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * yourOrderHeadingInPaymentPage);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * PaymentMethodSectioninBillingPage),
	 * "Payment methods section is not present in confrimation page");
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * makePaymentButtonSectionBillingPage),
	 * "Make payment button section is not present in confirmation page");
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.paypalButton),
	 * "Paypal section is not present in confirmation page");
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.stripeButton),
	 * "Stripe button section is not present in confirmation page");
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.creditCardButton),
	 * "Credit card section is not present in confirmation page");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify redirecting to respective payment methods on selecting
	 * and clicking on make payment button
	 * 
	 * @Test public void verifyRedirectingToRespectivePagesonClickingtheLinks()
	 * throws Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); scrollDown(driver); waitTill(2000);
	 * click(confirmationPgObj.stripeButton);
	 * click(confirmationPgObj.makePaymentButtonPaymentpage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * stripePaymentPopUpCancleButton); waitTill(1000);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * stripePaymentVerificationElement),
	 * "Stripe payment pop-up isn't displayed when clicked");
	 * click(confirmationPgObj.stripePaymentPopUpCancleButton); waitTill(2000);
	 * click(confirmationPgObj.creditCardButton);
	 * click(confirmationPgObj.makePaymentButtonPaymentpage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * creditCardPopUpVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * creditCardPopUpVerificationElement),
	 * "Credit card payment pop-up isn't displayed when clicked");
	 * 
	 * }
	 * 
	 * Description: Verify 'Thank you' page is displaying on clicking 'Verify
	 * payment information later' link
	 * 
	 * @Test public void
	 * verifyThankYouPageisDisplayingOnClickingVerifyPaymentInfoLater() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); scrollDown(driver);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * enterPaymentInfoLaterinPaymentPage);
	 * click(confirmationPgObj.enterPaymentInfoLaterinPaymentPage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * ThankYouPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * ThankYouPageVerificationElement),
	 * "Thank you page isn't displaying upon clicking enter payment info link in payment page"
	 * );
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify thank you message along with 'Your information has been
	 * recorded' text is displaying
	 * 
	 * @Test public void verifyThankYoumeesageAlongwithTextisPresent() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); scrollDown(driver);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * enterPaymentInfoLaterinPaymentPage);
	 * click(confirmationPgObj.enterPaymentInfoLaterinPaymentPage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * ThankYouPageVerificationElement);
	 * Assert.assertTrue(getText(confirmationPgObj.ThankYouPageVerificationElement).
	 * replace("\n",
	 * ",").trim().equals("Thank you,Your information has been recorded"),
	 * "Correct message isn't displaying in thank you page header");
	 * 
	 * }
	 * 
	 * 
	 * Description: Verify 'Oder summary' details
	 * 
	 * @Test public void verifyOrderSummenryinThankYouPage() throws Exception {
	 * SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); scrollDown(driver);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * enterPaymentInfoLaterinPaymentPage);
	 * click(confirmationPgObj.enterPaymentInfoLaterinPaymentPage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * ThankYouPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.monthlyCostSection);
	 * Assert.assertTrue(verifyElementPresent(accountPgObj.monthlyCostSection),
	 * "Monthly cost section isn't present in Thank you page");
	 * Assert.assertTrue(getText(accountPgObj.numberOfAdsperPackageUnderMonthlyCost)
	 * .trim().equals("10 listings"),
	 * "Ads per package isn't correct in Thank you page");
	 * Assert.assertTrue(getText(accountPgObj.billingFrequencyUnderMonthlyCost).trim
	 * ().equals("Monthly"), "Billing frequency isn't correct in Thank you page");
	 * Assert.assertTrue(getText(accountPgObj.priceUnderMonthlyCost).trim().equals(
	 * "???50.00"),
	 * "Price under Monthly cost section isn't correct in Thank you page");
	 * Assert.assertTrue(getText(confirmationPgObj.VATAmountinMonthlyCostSection).
	 * trim().equals("???10.50"),
	 * "VAT under Monthly cost section isn't correct in Thank you page");
	 * Assert.assertTrue(getText(confirmationPgObj.totalPriceinMonthlyCostSection).
	 * trim().equals("???60.50"), "Total per month isn't correct in Thank you page");
	 * }
	 * 
	 * 
	 * Description: Verify 'Login to TPRO' button, Verify login page is displaying
	 * on clicking the button
	 * 
	 * @Test public void verifyLoginButtoninThankYouPageanditsNavigation() throws
	 * Exception { SignUpAccountsTPROPage_New accountPgObj=new
	 * SignUpAccountsTPROPage_New(driver); SignUpDetailsTPROPage_New
	 * detailsPgObj=new SignUpDetailsTPROPage_New(driver);
	 * SignUpConfirmationTPROPage_New confirmationPgObj=new
	 * SignUpConfirmationTPROPage_New(driver); String uid=getUserId();
	 * accountPgObj.gotoDetailsPage(driver, "business",uid);
	 * explicitWaitFortheElementTobeVisible(driver,accountPgObj.
	 * detailsPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,detailsPgObj.
	 * detailsCountryDropdown);
	 * detailsPgObj.selectCountryFromDropdown("Netherlands");
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
	 * paymentPageVerificationElement); scrollDown(driver);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * enterPaymentInfoLaterinPaymentPage);
	 * click(confirmationPgObj.enterPaymentInfoLaterinPaymentPage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * ThankYouPageVerificationElement);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * loginButtoninThankYouPage);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * loginButtoninThankYouPage), "Log in button isn't present in thank you page");
	 * click(confirmationPgObj.loginButtoninThankYouPage);
	 * explicitWaitFortheElementTobeVisible(driver,confirmationPgObj.
	 * loginPageVerificationElement);
	 * Assert.assertTrue(verifyElementPresent(confirmationPgObj.
	 * loginPageVerificationElement),
	 * "User isn't landing to Login page upon clicking the button from thank you page"
	 * );
	 * 
	 * 
	 * }
	 */
}
