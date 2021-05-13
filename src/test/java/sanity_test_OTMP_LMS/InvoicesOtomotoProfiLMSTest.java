package sanity_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.getText;

import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUserPL;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.InvoicesOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class InvoicesOtomotoProfiLMSTest extends BaseClass{
	
	/*
	 * Description: Verify invoices page is displaying on clicking invoices link from hamburger menu
	 */
	@Test
	public void verifyInvoicepagenavigationOnclickingLinkfromSideMenu() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(2000);
	    try {
			click(overviewPage.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewPage.monthlyPackageOptioninSiderBar);
			}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.packageButtonunderMonthlyPackage);
		click(overviewPage.billingButtonunderMonthlyPackage);
		explicitWaitFortheElementTobeVisible(driver,overviewPage.billingPageverificationElement);
		Assert.assertTrue(verifyElementPresent(overviewPage.billingPageverificationElement), "Invoice page isn't displaying on clicking on the link from side menu");
	}
	
	/*
	 * Description: Verify Invoices number, issue date, gross amount and PDF texts are displaying
	 */
	@Test
	public void verifyInvoiceNumberDateGrossAmtandPDFheadersareDisplaying() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(2000);
	    try {
			click(overviewPage.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewPage.monthlyPackageOptioninSiderBar);
			}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.packageButtonunderMonthlyPackage);
		click(overviewPage.billingButtonunderMonthlyPackage);
		explicitWaitFortheElementTobeVisible(driver,overviewPage.billingPageverificationElement);
		waitTill(1000);
		InvoicesOtomotoProfiLMSPage invoicePage=new InvoicesOtomotoProfiLMSPage(driver);
		List<WebElement> headers=invoicePage.billingPageHeaders;
		Assert.assertTrue(headers.size()==4, "4 headers aren't displaying in invoice page");
		String[] siteheaders= {"Invoice Number","Issue Date","Gross Amount","PDF"};
		for(int i=0;i<headers.size();i++) {
			Assert.assertTrue(getText(headers.get(i)).trim().equals(siteheaders[i]), ""+i+"th Heders is not correct");
		}
	}
	
	/*
	 * Description: Verify 'no invoices number' text is displaying for non paid users
	 */
	@Test
	public void verifyNoinvoiceAvailabletextInitially() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		LoginOtomotoProfiLMSPage loginPage= new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(testUserPL,pwd);
		try {
		click(loginPage.LoginButton);
		}catch(Exception e) {
			jsClick(driver,loginPage.LoginButton);
		}
	    explicitWaitFortheElementTobeVisible(driver,loginPage.overviewPageVerificationElement);
	    waitTill(2000);
	    try {
			click(overviewPage.monthlyPackageOptioninSiderBar);
			}catch(Exception e) {
				jsClick(driver,overviewPage.monthlyPackageOptioninSiderBar);
			}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.packageButtonunderMonthlyPackage);
		click(overviewPage.billingButtonunderMonthlyPackage);
		explicitWaitFortheElementTobeVisible(driver,overviewPage.billingPageverificationElement);
		waitTill(2000);
		InvoicesOtomotoProfiLMSPage invoicePage=new InvoicesOtomotoProfiLMSPage(driver);
		Assert.assertTrue(getText(invoicePage.invoicePageBody).trim().equals("No Invoices Available"), "No invoice text isn't displaying initially ");
	}

}
