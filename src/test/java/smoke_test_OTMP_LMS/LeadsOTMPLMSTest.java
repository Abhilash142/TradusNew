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
import static com.tradus.core.GlobalConstants.userNamePL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.otomotoProfi.LMS.pages.CommonMethod;
import com.otomotoProfi.LMS.pages.LeadsOTMPLMSPage;
import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.otomotoProfi.LMS.pages.OverviewOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class LeadsOTMPLMSTest extends BaseClass{
	/*
	 * Description: Verify leads page is displaying on clicking leads link from menu
	 */
	@Test
	public void verifyLeadspageisDisplayingonClickingLeadslink() throws Exception {
		OverviewOtomotoProfiLMSPage overviewPage= new OverviewOtomotoProfiLMSPage(driver);
		if(!driver.getCurrentUrl().equals("https://sprzedawca.otomotoprofi.pl/lms")) {
			overviewPage.doLogIn(testUserPL,pwd);
		}
		explicitWaitFortheElementTobeVisible(driver,overviewPage.overviewPageVerificationElement);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.leadsOptioninSiderBar);
	    jsClick(driver, overviewPage.leadsOptioninSiderBar);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, overviewPage.leadsPageVerificationElement);
		Assert.assertTrue(verifyElementPresent(overviewPage.leadsPageVerificationElement),
				"Leads page is not displaying by clicking on Leads link on sidebar");
	}
	/*
	 * Description: Verify graphs are displaying/updating properly and Description: Verify Popular ads section is displaying in leads page too
	 */
 // @Test
	public void verifyGraphsareDisplayingAndUpdatingProperly() throws Exception {
		LeadsOTMPLMSPage LeadsObj=new LeadsOTMPLMSPage(driver);
		/*	LeadsObj.doLogIn(userNamePL,pwd);
		loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/leads");
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(verifyElementPresent(LeadsObj.emailandPhoneLeadsGraph),
				"Email and Phone leads graph is not displying");
		explicitWaitFortheElementTobeVisible(driver,LeadsObj.popularAdssectioninLeads);
		softAssert.assertTrue(verifyElementPresent(LeadsObj.popularAdssectioninLeads), "Popular Ads section isn't present in Leads page");
		softAssert.assertTrue(verifyElementPresent(LeadsObj.visitsGraph), "Visits graph is not displaying");
		softAssert.assertTrue(verifyElementPresent(LeadsObj.leadsPerMonth), "Leads per month graph is displaying");
		int numberOfEmails = Integer.parseInt(getText(LeadsObj.numberOfEmailsLeads));
		int numberOfphnCallBacks = Integer.parseInt(getText(LeadsObj.numberOfPhoneCallbacksinLeads));
		int numberOfPhnCalls = Integer.parseInt(getText(LeadsObj.numberOfPhoneCalLeads));
		
		File leadsDataPL=new File(System.getProperty("user.dir") + "\\LeadDataPL.txt");
		BufferedReader br = new BufferedReader(new FileReader(leadsDataPL));
		String st;
		int email = 0;
		int callBacks = 0;
		int call = 0;
		while ((st = br.readLine()) != null) {
			String[] words = st.split("@");
			for (int i = 0; i <= words.length; i++) {
				switch (i) {
				case 0:
					email = Integer.parseInt(words[i].replace("Number of Email leads=", "").trim());
					break;
				case 1:
					callBacks = Integer.parseInt(words[i].replace("Number of callBacks =", "").trim());
					break;
				case 2:
					call = Integer.parseInt(words[i].replace("Number of phone call leads =", "").trim());
					break;

				}
			}
		}
		
		FileWriter fw = new FileWriter(leadsDataPL);
		String temp = "Number of Email leads=" + numberOfEmails + "@";
		temp += "Number of callBacks =" + numberOfphnCallBacks + "@";
		temp += "Number of phone call leads =" + numberOfPhnCalls;
		fw.write(temp);
		waitTill(3000);
		if (fw != null)
			fw.close();
		LeadsObj.leadsGenerationinOTMP();
		softAssert.assertTrue(numberOfEmails >= email, "Email leads are not updated properly");
		softAssert.assertTrue(numberOfphnCallBacks >= callBacks, "Phone callback leads are not updated properly");
		//softAssert.assertTrue(numberOfPhnCalls >= call, "Phone call leads are not updated properly");
		softAssert.assertAll();*/
		LeadsObj.leadsGenerationinOTMP();
	}
	
	/*
	 * Description: Verify initially no graphs are displaying below 'Email and phone leads', 'Visits', 'Leads per month' 
	 * and 'Leads per country' with info
	 */
	@Test
	public void verifyInitiallyNoGraphsAreDisplayingBelowEmailsAndPhoneLeadsVisitsLeadsPerMonthLeadsPerCountryWithInfo() throws Exception{
		LeadsOTMPLMSPage LeadsObj=new LeadsOTMPLMSPage(driver);
		LeadsObj.doLogIn(testUserPL,pwd);
		loadUrl(driver,"https://sprzedawca.otomotoprofi.pl/lms/leads");
		Assert.assertTrue(verifyElementPresent(LeadsObj.EmailsAndPhoneLeadsInfoHeading), 
				"Emails And Phone leads info heading is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.EmailsAndPhoneLeadsInfo), 
				"Emails And Phone leads info is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.VisitsInfoHeading), 
				"Visits info heading is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.VisitsInfo), 
				"Visits info is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerMonthInfoHeading), 
				"Leads Per Month info heading is not displaying in leads page");
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.leadsPerMonth);
		Assert.assertTrue(verifyElementPresent(LeadsObj.leadsPerMonth), 
				"Leads Per Month graph is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerCountryInfoHeading), 
				"Leads Per country info heading is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerCountryInfo), 
				"Leads Per country info is not displaying in leads page");
		Assert.assertFalse(verifyElementPresent(LeadsObj.emailandPhoneLeadsGraph), 
				"Emails and call leads graph is displaying in leads page initially");
		Assert.assertFalse(verifyElementPresent(LeadsObj.visitsGraph), 
				"Visits graph is displaying in leads page initially");
	}
}
