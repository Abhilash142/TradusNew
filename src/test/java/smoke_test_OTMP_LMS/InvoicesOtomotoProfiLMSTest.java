package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
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
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/billing")) {
			overviewPage.doLogIn(testUserPL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
		explicitWaitFortheElementTobeVisible(driver,overviewPage.monthlyPackageOptioninSiderBar);
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
		InvoicesOtomotoProfiLMSPage invoicePage=new InvoicesOtomotoProfiLMSPage(driver);
		 if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms/billing")) {
			    invoicePage.doLogIn(testUserPL,pwd);
				loadUrl(driver, "https://sprzedawca.otomotoprofi.pl/lms/billing");
			}
		 explicitWaitFortheElementTobeVisible(driver,invoicePage.billingPageverificationElement);
		 waitTill(2000);
		List<WebElement> headers=invoicePage.billingPageHeaders;
		Assert.assertTrue(headers.size()==5, "5 headers aren't displaying in invoice page");
		String[] siteheaders= {"Creation Date","Due Date","Description","Amount Payable","PDF"};
		for(int i=0;i<headers.size();i++) {
			Assert.assertTrue(getText(headers.get(i)).trim().equals(siteheaders[i]), ""+i+"th Heders is not correct");
		}
	}

}
