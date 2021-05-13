package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.getValue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.MonthlyPackageTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;
import com.tradus.pro.pages.SignUpAccountsCheckoutTradusProPage;

public class MonthlyPackageTradusPROTest extends BaseClass{
	/*
	 * Description: Verify selected package while signing up is displaying under 'Your active package is below' 
	 * if seller paid for the package along with respective Status and tooltip is displaying
	 * Also, upcoming package displaying near Active package
	 */

	@Test
	public void verifySelectedPackageWhileSigningUpIsDisplayingUnderYourActivePackageSectionIfSellerPaid() throws Exception {
		 MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
			 monthlypackagePage.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.PaidPackageTitle);
		Assert.assertEquals(getText(monthlypackagePage.PaidPackageTitle).replace("\n",",").trim(), "Tradus Premium,90 listings",
				"Selected package while signingUp is not displaying under 'You are subscribed to...' section in monthly package page");
		Assert.assertEquals(getText(monthlypackagePage.packageStatusText).trim(), "Active","Active status isn't displaying for paid package");
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.upcomingPackage);
			}catch(Exception E) {
				Assert.assertTrue(verifyElementPresent(monthlypackagePage.upcomingPackage),"Upcoming package is displaying in monthly package page");
			}
		Actions a =new Actions(driver);
		a.moveToElement(monthlypackagePage.packageStatusText).build().perform();
		waitTill(2000);
		Assert.assertEquals(getText(monthlypackagePage.PackageStatusTooltip).trim(), "You can start selling on Tradus","Active package toottip might have changed in Subscription details page");

	}
	
	/*
	 * Description: Verify selected package while signing up is displaying under 'You are subscribed to Tradus Basic 10 package. 
	 * along with respective Status and tooltip is displaying and pay package button is displaying
	 */
	
	@Test
	public void verifySelectedPackageWhileSigningUpIsDisplayingUnderYourAreSubscribedSectionIfSellerHaveNotPaid() throws Exception {
		 MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		 monthlypackagePage.doLogIn(testUser,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.subscribedPackageTitle);
		//System.out.println(getText(monthlypackagePage.subscribedPackageTitle).replace("\n",",").trim());
		if (getText(monthlypackagePage.subscribedPackageTitle).contains("1 listing")) {
			Assert.assertEquals(getText(monthlypackagePage.subscribedPackageTitle).replace("\n",",").trim(), "Tradus Premium,1 listing",
					"Selected package while signingUp is not displaying under subscribed package section in monthly package page");
		} else {
			Assert.assertEquals(getText(monthlypackagePage.subscribedPackageTitle).replace("\n",",").trim(), "Tradus Basic,1 listing",
					"Selected package while signingUp is not displaying under subscribed package section in monthly package page");
		}
		Assert.assertEquals(getText(monthlypackagePage.packageStatusText).trim(), "Pending payment","Pending payment status isn't displaying for unpaid package");
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.PayNowButtonForSelectedPackage), "Pay Now button not displaying in monthly package page even of the seller haven't paid for the selected package");
		Actions a =new Actions(driver);
		a.moveToElement(monthlypackagePage.packageStatusText).build().perform();
		waitTill(2000);
		Assert.assertEquals(getText(monthlypackagePage.PackageStatusTooltip).trim(), "The below package is pending payment. Please complete payment now to activate your account.","Pending payment toottip might have changed in Subscription details page");
	}
	
	
	
	/*
	 * Description: Verify page is redirecting to buy package page on clicking 'Buy package/'Pay package' button and Credit card button and SEPA details are displaying for unpaid package
	 */
	@Test
	public void verifyRedirectionToBuyPackagePageOnClickingBuyPackageORPayPackageButtonsAndverifyPaymentOptions() throws Exception {
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(testUser,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.subscribedPackageTitle);
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.PayNowButtonForSelectedPackage);
		try {
			click(monthlypackagePage.PayNowButtonForSelectedPackage);
		}catch(Exception E) {
			jsClick(driver,monthlypackagePage.PayNowButtonForSelectedPackage);
		}
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.buyPackagePageTitle);
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.buyPackagePageTitle), "Page not navigated to Buy package page by clicking on Pay Package button on selected package");
		//System.out.println(getText(monthlypackagePage.paymentTextWithPrice).trim());
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.paymentTextWithPrice);
		waitTill(2000);
		Assert.assertTrue(getText(monthlypackagePage.paymentTextWithPrice).trim().equals("Your total payment is € 15,73 incl. VAT"), "Payment amount with text has been changed");
		int size=monthlypackagePage.paymentOptionsinForPrePaidUser.size();
		Assert.assertTrue(size==1,"Only one payment options are not present in monthly package page");
		Assert.assertTrue(getText(monthlypackagePage.paymentOptionsinForPrePaidUser.get(0)).trim().equals("Credit card"), "Credit card option isn't present in packages page");
	}
	
	/*
	 * Description: Verify page is redirecting to buy package page on clicking 'Buy package/'Pay package' button and Verify Credit card button and SEPA details are displaying for paid package
	 */
	@Test
	public void verifyRedirectionToBuyPackagePageOnClickingBuyPackageORPayPackageButtonsAndverifyPaymentOptionsForUpgreadingPackage() throws Exception {
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.upcomingPackage);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		try {
			click(monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		}catch(Exception E) {
			jsClick(driver,monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		}
		try {
		    explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.buyPackagePageTitle);
		}catch(Exception E) {
		    Assert.assertTrue(verifyElementPresent(monthlypackagePage.buyPackagePageTitle), "Page not navigated to Buy package page by clicking on Pay Package button on selected package");
		}
		waitTill(2000);
		Assert.assertTrue(getText(monthlypackagePage.paymentTextWithPrice).trim().equals("Your total payment is € 228,00 incl. VAT"), "Payment amount with text has been changed");
		int size=monthlypackagePage.paymentOptionsinForPrePaidUser.size();
		Assert.assertTrue(size==1,"Only one payment options are not present in monthly package page");
		Assert.assertTrue(getText(monthlypackagePage.paymentOptionsinForPrePaidUser.get(0)).trim().equals("Credit card"), "Credit card option isn't present in packages page");
		//Assert.assertTrue(getText(monthlypackagePage.paymentOptionsinMonthlyPackage.get(1)).trim().equals("Direct debit"), "Direct debit option isn't present in packages page");
	}

	/*
	 * Description: Verify payment screens are displaying correctly on clicking both payment options for unpaid user
	 */
	
	@Test
	public void verifyPaymentScreensonClickingCreditCardandSepaOptionsforUnpaidUser() throws Exception{
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(testUser,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.subscribedPackageTitle);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.PayNowButtonForSelectedPackage);
		try {
			click(monthlypackagePage.PayNowButtonForSelectedPackage);
		}catch(Exception E) {
			jsClick(driver,monthlypackagePage.PayNowButtonForSelectedPackage);
		}
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.buyPackagePageTitle);
		waitTill(2000);
		int size=monthlypackagePage.paymentOptionsinForPrePaidUser.size();
		Assert.assertTrue(size==1,"Only one payment options are not present in monthly package page");
		for(int i=0;i<size;i++) {
			jsClick(driver,monthlypackagePage.paymentOptionsinForPrePaidUser.get(i));
			waitTill(1000);
			switch(i) {
			case 0:
				explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.payPackageButtoninPaymentScreen);
			    waitTill(2000);
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.cardHoldersName), "Card hoders name field isn't present in credit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.cardNumberFieldInCreditCardPaymentScreen), "Card number field isn't present in credit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.emailFieldInCreditCardPaymentScreen), "Email field isn't present in credit card payment screen");
			    Assert.assertTrue(getText(monthlypackagePage.packageInfoInCreditCardPaymentScreen).trim().equals("Tradus Premium 1 - 1 month - € 15,73"), "Package info & price aren't displaying in credit card payment screen");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.cardHoldersName).trim().equals("Test"), "Card holders name in credit card payment screen is not prefilled correctly");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.emailFieldInCreditCardPaymentScreen).trim().equals(testUser), "Emaild id in credit card payment screen is not prefilled correctly");
			    break; 
			/*case 1:
				explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.initiateDebitinPaymentScreen);
			    waitTill(2000);
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.ibanFieldinPaymentScreen), "iBan field isn't present in direct debit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.nameFieldInSEPAPaymentScreen), "Name field isn't present in direct debit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.emailFieldInSEPAPaymentScreen), "Email field isn't present in direct debit card payment screen");
			    Assert.assertTrue(getText(monthlypackagePage.packageInfoInSEPAPaymentScreen).trim().equals("Tradus Premium 1 - 1 month - € 15,73"), "Package info & price aren't displaying in direct debit card payment screen");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.nameFieldInSEPAPaymentScreen).trim().equals("Test"), "Card holders name in credit card payment screen is not prefilled correctly");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.emailFieldInSEPAPaymentScreen).trim().equals(testUser), "Emaild id in credit card payment screen is not prefilled correctly");
			    Assert.assertTrue(getText(monthlypackagePage.paymentInfoInSEPAPaymentScreen).trim().equals("By providing your payment information and confirming this payment, you authorise (A) Tradus PRO and Stripe, our payment service provider, to send instructions to your bank to debit your account and (B) your bank to debit your account in accordance with those instructions. As part of your rights, you are entitled to a refund from your bank under the terms and conditions of your agreement with your bank. A refund must be claimed within 8 weeks starting from the date on which your account was debited. Your rights are explained in a statement that you can obtain from your bank. You agree to receive notifications for future debits up to 2 days before they occur."), "Payment info in direct debit card payment screen might have chnaged");
			    break;*/
			}
            jsClick(driver,monthlypackagePage.cancleButtoninPaymentScreen);
            waitTill(2000);
		}
	}
	
	/*
	 * Description: Verify payment screens are displaying correctly on clicking both payment options while upgrading package
	 */
	
	@Test
	public void verifyPaymentScreensonClickingCreditCardandSepaOptionsWhileUpgreadingPackage() throws Exception{
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.upcomingPackage);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		try {
			click(monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		}catch(Exception E) {
			jsClick(driver,monthlypackagePage.payNowButtonUnderThisIsYourUpcomingPackage);
		}
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.buyPackagePageTitle);
		waitTill(2000);
		int size=monthlypackagePage.paymentOptionsinForPrePaidUser.size();
		Assert.assertTrue(size==1,"Only one payment options are not present in monthly package page");
		for(int i=0;i<size;i++) {
			jsClick(driver,monthlypackagePage.paymentOptionsinForPrePaidUser.get(i));
			waitTill(2000);
			switch(i) {
			case 0:
				explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.payPackageButtoninPaymentScreen);
			    waitTill(1000);
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.cardHoldersName), "Card hoders name field isn't present in credit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.cardNumberFieldInCreditCardPaymentScreen), "Card number field isn't present in credit card payment screen");
			    Assert.assertTrue(verifyElementPresent(monthlypackagePage.emailFieldInCreditCardPaymentScreen), "Email field isn't present in credit card payment screen");
			    Assert.assertTrue(getText(monthlypackagePage.packageInfoInCreditCardPaymentScreen).trim().equals("Tradus Premium 70 - 1 month - € 228,00"), "Package info & price aren't displaying in credit card payment screen");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.cardHoldersName).trim().equals("Harry"), "Card holders name in credit card payment screen is not prefilled correctly");
			    Assert.assertTrue(getValue(driver,monthlypackagePage.emailFieldInCreditCardPaymentScreen).trim().equals(userName), "Emaild id in credit card payment screen is not prefilled correctly");
			    break; 
			}
            jsClick(driver,monthlypackagePage.cancleButtoninPaymentScreen);
            waitTill(1000);
		}
	}
	/*
	 * Description: Verify inside content of active package and 'current subscription period' details are displaying for active package
	 */
	@Test
	public void verifyInsideContentOfActivePackageAndCurentSubScriptionPeriod() throws Exception {
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.PaidPackageTitle);
		System.out.println("Active Package:"+ getText(monthlypackagePage.PaidPackageTile).replace("\n",",").trim());
		//Assert.assertTrue(getText(monthlypackagePage.PaidPackageTile).replace("\n",",").trim().equals("10 listings,Active,€50.00,Per subscription period,Price excluding VAT €50.00,VAT €0.00,Billing frequency 1 month - Recurring,Payment terms 30 days from the start of the subscription"),"Active package inside content might have changed");
		//System.out.println(getText(monthlypackagePage.subscriptionPeriodText));
		Assert.assertTrue(getText(monthlypackagePage.subscriptionPeriodText).equals("Subscription Period: 24/02/2021 - 23/02/2022"),"Current subscription period value might have changed");
	}
	/*
	 * Description: Validate cancel package functionlity
	 */
	@Test
	public void vaidateCancelPackageFunctionlity() throws Exception {
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		monthlypackagePage.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.PaidPackageTitle);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.canclePackageLink);
		try {
			click(monthlypackagePage.canclePackageLink);
		}catch(Exception E) {
			jsClick(driver, monthlypackagePage.canclePackageLink);
		}
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.confirmButtonInPackageCancelPopUp);
		System.out.println("Cancle Popup:"+getText(monthlypackagePage.inSideContentOfPackageCancelPopUp).trim());
		//Assert.assertTrue(getText(monthlypackagePage.inSideContentOfPackageCancelPopUp).trim().equals("Are you sure you want to cancel your current Tradus PRO package? If yes, cancellation will be effective the end of the current billing cycle: 23/02/2022. Per the Terms of Use."),"Inside content of cancel popup might have changed");
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.termsLinkInPackageCancelPopUp),"Terms link in cancel package pop up isn't present");
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.goBackButtonInPackageCancelPopUp),"Go back link in cancel package pop up isn't present");
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.confirmButtonInPackageCancelPopUp),"Confirm button in cancel package pop up isn't present");
	    try {
	    	click(monthlypackagePage.cancelIconInPackageCancelPopUp);
	    }catch(Exception E) {
	    	jsClick(driver,monthlypackagePage.cancelIconInPackageCancelPopUp);
	    }
	    waitTill(1000);
	    Assert.assertFalse(verifyElementPresent(monthlypackagePage.confirmButtonInPackageCancelPopUp),"Cancel package pop-up isn't getting closed on clicking cancel icon");
	}
	/*
	 * Descritpion: Verify upcoming package is displaying beside active package
	 */
	/*@Test
	public void verifyUpcomingPackageisDisplayingBesideActivePackage() throws Exception {
		MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		 CommonMethod cmdObj=new  CommonMethod(driver);
				 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
					 cmdObj.logOut();
					 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
				 }
		 cmdObj.login(userName,pwd);
		explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		try {
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.packageUnderThisIsYourUpcomingPackage);
		}catch(Exception E) {
			Assert.assertTrue(verifyElementPresent(monthlypackagePage.packageUnderThisIsYourUpcomingPackage),"Upcoming package is displaying in monthly package page");
		}
		System.out.println("Upcoming Package"+getText(monthlypackagePage.packageUnderThisIsYourUpcomingPackage).replace("\n",",").trim());
		//Assert.assertTrue(getText(monthlypackagePage.packageUnderThisIsYourUpcomingPackage).replace("\n",",").trim().equals("listing,€228.00,Per subscription period,Price excluding VAT €228.00,VAT €0.00,Billing frequency 1 month - Recurring"),"Inside contain upcoming packages might have changed");
		cmdObj.logOut();
		explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
	}*/
	
	/*
     * Description: Verify pay package button is displaying if sellers haven't paid for the package
     */
	/*@Test
	public void verifyPayPackageButtonIfSellerNotPaidForTheSelectedPackage() throws Exception {
		 MonthlyPackageTradusPROPage monthlypackagePage = new MonthlyPackageTradusPROPage(driver);
		 CommonMethod cmdObj=new  CommonMethod(driver);
				 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
					 cmdObj.logOut();
					 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
				 }
		 cmdObj.login(testUser,pwd);
		explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		try {
			explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.monthlyPackagePageVerificationElement);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/subscription-details");
			}
		explicitWaitFortheElementTobeVisible(driver,monthlypackagePage.monthlyPackagePageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver, monthlypackagePage.subscribedPackageTitle);
		Assert.assertTrue(verifyElementPresent(monthlypackagePage.PayNowButtonForSelectedPackage), "Pay Now button not displaying in monthly package page even of the seller haven't paid for the selected package");
		cmdObj.logOut();
		explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
	}*/

}
