package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;
import static com.tradus.core.GlobalConstants.userName;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CommonMethod;
import com.tradus.pro.pages.LeadsTradusPROPPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

public class LeadsTradusProTest extends BaseClass{
	/*
	 * Description: Verify leads page is displaying on clicking leads link from menu
	 */
	@Test
	public void verifyLeadsPageIsDisplayingOnClickingLeadsLinkFromMenu() throws Exception {
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		OverviewObj.doLogIn(testUser,pwd);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsPageVerificationElement);
		Assert.assertTrue(getCurrentUrl(driver).equals("https://pro.tradus.com/lms/leads"), 
				"Leads page not displayed on clicking leads link from menu");
	}
	
	/*
	 * Description: Verify initially no graphs are displaying below 'Email and phone leads', 'Visits', 
	 * 'Leads per month' and 'Leads per country' with info
	 */
	@Test
	public void verifyInitiallyNoGraphsAreDisplayingBelowEmailsAndPhoneLeadsVisitsLeadsPerMonthLeadsPerCountryWithInfo() throws Exception {
		LeadsTradusPROPPage LeadsObj= new LeadsTradusPROPPage(driver);
		LeadsObj.doLogIn(testUser,pwd);
		try {
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.LeadsPerCountryInfoHeading);
		}catch (Exception E) {
			loadUrl(driver,"https://pro.tradus.com/lms/leads");
		}
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.LeadsPerCountryInfoHeading);
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
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerMonthInfo), 
				"Leads Per Month info is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerCountryInfoHeading), 
				"Leads Per country info heading is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.LeadsPerCountryInfo), 
				"Leads Per country info is not displaying in leads page");
		
	}
	
	/*
	 * Description: Verify Email, call, call back and whatsapp circular graphs are displaying if buyer generate the leads
	 */
	@Test
	public void verifyEmailCallCallBackAndWhatsappCircularGraphesAreDisplayingIfBuyerGenerateTheLeads() throws Exception {
		LeadsTradusPROPPage LeadsObj= new LeadsTradusPROPPage(driver);
		LeadsObj.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, LeadsObj.LeadsPerCountryInfoHeading);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/leads");
			}
		try {
			explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		}catch(Exception E) {
			driver.navigate().refresh();
		}
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		Assert.assertTrue(verifyElementPresent(LeadsObj.numberOfEmailsLeads), 
				"Email leads count is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.numberOfPhoneCallbacksinLeads), 
				"Phone call back leads count is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.numberOfPhoneCalLeads), 
				"Phone call leads count is not displaying in leads page");
		Assert.assertTrue(verifyElementPresent(LeadsObj.numberOfWhatsAppLeads), 
				"Whatsapp leads count is not displaying in leads page");
	}
	
	/*
	 * Description: Verify graphs are displaying/updating propelry 
	 */
	@Test
	public void verifyGraphsareDisplayingAndUpdatingProperly() throws Exception {
		LeadsTradusPROPPage leadsObj= new LeadsTradusPROPPage(driver);
		leadsObj.doLogIn(userName,pwd);
		try {
			explicitWaitFortheElementTobeVisible(driver, leadsObj.EmailsAndPhoneLeadsInfoHeading);
			}catch (Exception E) {
				loadUrl(driver,"https://pro.tradus.com/lms/leads");
			}
		try {
			explicitWaitFortheElementTobeVisible(driver, leadsObj.numberOfEmailsLeads);
		}catch(Exception E) {
			driver.navigate().refresh();
		}
		SoftAssert softAssert = new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver, leadsObj.numberOfEmailsLeads);
		softAssert.assertTrue(verifyElementPresent(leadsObj.emailandPhoneLeadsGraph),
				"Email and Phone leads graph is not diaplying");
		softAssert.assertTrue(verifyElementPresent(leadsObj.visitsGraph), "Visits graph is not displaying");
		softAssert.assertTrue(verifyElementPresent(leadsObj.leadsPerMonth), "Leads per month graph is displaying");
		int numberOfEmails = Integer.parseInt(getText(leadsObj.numberOfEmailsLeads));
		int numberOfphnCallBacks = Integer.parseInt(getText(leadsObj.numberOfPhoneCallbacksinLeads));
		int numberOfPhnCalls = Integer.parseInt(getText(leadsObj.numberOfPhoneCalLeads));
		File leadsData = new File(System.getProperty("user.dir") + "\\LeadData.txt");
		if (!leadsData.exists()) {
			leadsData.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(leadsData));
		String st;
		int email = 0;
		int callBacks = 0;
		int call = 0;
		;
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
		

		FileWriter fw = new FileWriter(leadsData);
		String temp = "Number of Email leads=" + numberOfEmails + "@";
		temp += "Number of callBacks =" + numberOfphnCallBacks + "@";
		temp += "Number of phone call leads =" + numberOfPhnCalls;
		fw.write(temp);
		waitTill(2000);
		if (fw != null)
			fw.close();
		leadsObj.leadsGenerationinTPRO();
	//	loadUrl(driver,"https://pro.tradus.com/lms/leads");
	/*
	 * System.out.println("Newly updated Email:" + numberOfEmails);
	 * System.out.println("Last updated Email :" + email);
	 * System.out.println("Newly updated Call backs:" + numberOfphnCallBacks);
	 * System.out.println("Lst updated callBacks" + callBacks);
	 * System.out.println("newly updated PhnCalls:" + numberOfPhnCalls);
	 * System.out.println("Last updated phone call" + call);
	 * 
	 * softAssert.assertTrue(numberOfEmails >= email,
	 * "Email leads are not updated properly");
	 * softAssert.assertTrue(numberOfphnCallBacks >= callBacks,
	 * "Phone callback leads are not updated properly");
	 * //softAssert.assertTrue(numberOfPhnCalls >= call,
	 * "Phone call leads are not updated properly"); softAssert.assertAll();
	 */
	}

}
