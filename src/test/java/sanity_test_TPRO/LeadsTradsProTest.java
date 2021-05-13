package sanity_test_TPRO;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.getCurrentUrl;

import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.testUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.LeadsTradusPROPPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

public class LeadsTradsProTest extends BaseClass{
	
	/*
	 * Description: Verify leads page is displaying on clicking leads link from menu
	 */
	@Test(priority= 1)
	public void verifyLeadsPageIsDisplayingOnClickingLeadsLinkFromMenu() throws Exception {
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		waitTill(3000);
		LoginTradusPROPage loginObj = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, loginObj.emailTextField);
		loginObj.setAccountEmailAndPassword(testUser, pwd);
		jsClick(driver, loginObj.LoginButton);
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
	@Test(priority= 2)
	public void verifyInitiallyNoGraphsAreDisplayingBelowEmailsAndPhoneLeadsVisitsLeadsPerMonthLeadsPerCountryWithInfo() throws Exception {
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		waitTill(3000);
		LoginTradusPROPage loginObj = new LoginTradusPROPage(driver);
		explicitWaitFortheElementTobeVisible(driver, loginObj.emailTextField);
		loginObj.setAccountEmailAndPassword(testUser, pwd);
		jsClick(driver, loginObj.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsPageVerificationElement);
		LeadsTradusPROPPage LeadsObj= new LeadsTradusPROPPage(driver);
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
	@Test(priority= 3)
	public void verifyEmailCallCallBackAndWhatsappCircularGraphesAreDisplayingIfBuyerGenerateTheLeads() throws Exception {
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		waitTill(2000);
		LoginTradusPROPage loginObj = new LoginTradusPROPage(driver);
		waitTill(2000);
		LeadsTradusPROPPage LeadsObj= new LeadsTradusPROPPage(driver);
		explicitWaitFortheElementTobeVisible(driver, loginObj.emailTextField);
		loginObj.setAccountEmailAndPassword(userName,pwd);
		jsClick(driver, loginObj.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
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
	 * Description: Verify graphs below emails and phone leads per country and leads per month are disappearing by deleting the ad
	 */
	//@Test
	/*public void verifyGraphsBelowEmailsAndPhoneLeadsLeadsPerCountryAndLeadsPerMonthAreDisappearingByDeletingTheAd() throws Exception {
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		CreateStockTradusProPage createStockObj= new CreateStockTradusProPage(driver);
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		LeadsTradusPROPPage LeadsObj= new LeadsTradusPROPPage(driver);
		loadUrl(driver, "https://pro.tradus.com/login");
		waitTill(4000);
		driver.manage().window().maximize();
		explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);
		loginPage.setAccountEmailAndPassword("automation.testing.sunfra@gmail.com", "tradus123");
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.createMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.priceTypeFieldPostingForm);
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpeg");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		waitTill(1000);
		scrollToElement(driver, createStockObj.priceSectionInPostingForm);
		waitTill(3000);
		click(createStockObj.priceTypeFieldPostingForm);
		waitTill(1000);
		actionClick(driver, createStockObj.priceTypeasFixed);
		waitTill(1000);
		if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("EUR")) {
			click(createStockObj.currencyTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.currencyTypeasEuro);
		}
		sendKeys(createStockObj.netPriceFieldPostingForm, "20000");
		waitTill(1000);
		scrollToElement(driver, createStockObj.yourVehicleSectionInPostingForm);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasSpareParts);
		waitTill(3000);
		click(createStockObj.vehicleCategoryFieldPostingForm);
		actionClick(driver, createStockObj.vehicleCategoryasTires);
		waitTill(2000);
		click(createStockObj.vehicleMakeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleMakeasJCB);
		waitTill(3000);
		click(createStockObj.vehicleModelFieldPostingForm);
		actionClick(driver, createStockObj.vehicleModelas100);
		waitTill(4000);
		sendKeys(createStockObj.descriptionAreainPostingForm, "Ad");
		jsClick(driver, createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		for(int i=0;i<12;i++)
		{
			if(verifyElementPresent(LeadsObj.SparePartsTestAd))
			{
				break;
			}
			else 
			{
				if(i==11)
				{
					Assert.assertTrue(verifyElementPresent(LeadsObj.SparePartsTestAd), "Inserted ad not displaying in All stock page");
				}
				driver.navigate().refresh();
				waitTill(10000);
			}
		}
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.TradusLinkOnSparePartsAd);
		jsClick(driver, LeadsObj.TradusLinkOnSparePartsAd);
		String parentWindow= driver.getWindowHandle();
		switchWindow(driver, parentWindow);
		String adURL= getCurrentUrl(driver);
		String childWindow= driver.getWindowHandle();
		switchWindow(driver, childWindow);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		String a= getText(LeadsObj.numberOfEmailsLeads);
		String b= getText(LeadsObj.numberOfPhoneCallbacksinLeads);
		jsClick(driver, OverviewObj.profileIconOnHeader);
        explicitWaitFortheElementTobeVisible(driver, OverviewObj.logoutOptionInProfileIconDropdown);
        jsClick(driver, OverviewObj.logoutOptionInProfileIconDropdown);
        loadUrl(driver, "https://www.tradus.com/account/login#tab-login");
		loadUrl(driver, adURL);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.RequestAPriceButtonInAdDetails);
		jsClick(driver, LeadsObj.RequestAPriceButtonInAdDetails);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.LoginTab);
		jsClick(driver, LeadsObj.LoginTab);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.EmailField);
		sendKeys(LeadsObj.EmailField, "automation.test.sunfra@gmail.com");
		sendKeys(LeadsObj.PwdField, "tradus123");
		jsClick(driver, LeadsObj.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.LoginAsBuyerButton);
		jsClick(driver, LeadsObj.LoginAsBuyerButton);
		loadUrl(driver, adURL);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.sendButtonInAdDetails);
		jsClick(driver, LeadsObj.sendButtonInAdDetails);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.CloseIconInSuccessPopup);
		jsClick(driver, LeadsObj.CloseIconInSuccessPopup);
		loadUrl(driver, "https://pro.tradus.com/login");
        explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);
		loginPage.setAccountEmailAndPassword("automation.testing.sunfra@gmail.com", "tradus123");
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		for(int i=0;i<12;i++)
		{
			if(getText(LeadsObj.numberOfEmailsLeads).equals(a) && getText(LeadsObj.numberOfPhoneCallbacksinLeads).equals(b))
			{
				if(i==11)
				{
					Assert.assertFalse(getText(LeadsObj.numberOfEmailsLeads).equals(a), "Genereated leads are not updated in leads page");
					Assert.assertFalse(getText(LeadsObj.numberOfPhoneCallbacksinLeads).equals(b), "Genereated leads are not updated in leads page");
				}
				driver.navigate().refresh();
				waitTill(10000);
			}
			else 
			{
				break;
			}
		}
		jsClick(driver, OverviewObj.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.DeleteLinkOnSparePartsAd);
		jsClick(driver, LeadsObj.DeleteLinkOnSparePartsAd);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.YesButtonOnAdDeletePopup);
		jsClick(driver, AllStockPage.YesButtonOnAdDeletePopup);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.successToastInAllStockPage);
		loadUrl(driver, adURL);
		for(int i=0;i<12;i++)
		{
			if(verifyElementPresent(LeadsObj.SparePartsTestAdTitle))
			{
				if(i==11)
				{
					Assert.assertFalse(verifyElementPresent(LeadsObj.SparePartsTestAdTitle), "Deleted ad still displaying even after deleting");
				}
				driver.navigate().refresh();
				waitTill(10000);
			}
			else 
			{
				break;
			}
		}
		loadUrl(driver, "https://pro.tradus.com/lms/leads");
		explicitWaitFortheElementTobeVisible(driver, LeadsObj.numberOfEmailsLeads);
		for(int i=0;i<12;i++)
		 {
				if(getText(LeadsObj.numberOfEmailsLeads).equals(a) && getText(LeadsObj.numberOfPhoneCallbacksinLeads).equals(b))
				{
					if(i==11)
					{
						Assert.assertFalse(getText(LeadsObj.numberOfEmailsLeads).equals(a), "Genereated leads are not updated in leads page");
						Assert.assertFalse(getText(LeadsObj.numberOfPhoneCallbacksinLeads).equals(b), "Genereated leads are not updated in leads page");
					}
					driver.navigate().refresh();
					waitTill(10000);
			}
				else
				{
					break;
				}
		}
	}
}
*/
	
	/*
	 * Description: Verify graphs are displaying/updating propelry 
	 */
	@Test(priority= 5)
	public void verifyGraphsareDisplayingAndUpdatingProperly() throws Exception {
		LeadsTradusPROPPage leadsObj = new LeadsTradusPROPPage(driver);
		OverviewTradusPROPage OverviewObj= new OverviewTradusPROPage(driver);
		waitTill(2000);
		LoginTradusPROPage loginObj = new LoginTradusPROPage(driver);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver, loginObj.emailTextField);
		loginObj.setAccountEmailAndPassword(userName,pwd);
		jsClick(driver, loginObj.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, OverviewObj.leadsOptioninSiderBar);
		jsClick(driver, OverviewObj.leadsOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, leadsObj.EmailsAndPhoneLeadsInfoHeading);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(leadsObj.emailandPhoneLeadsGraph),
				"Email and Phone leads graph is not diaplying");
		Assert.assertTrue(verifyElementPresent(leadsObj.visitsGraph), "Visits graph is not displaying");
		Assert.assertTrue(verifyElementPresent(leadsObj.leadsPerMonth), "Leads per month graph is displaying");
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
		Assert.assertTrue(numberOfEmails >= email, "Email leads are not updated properly");
		Assert.assertTrue(numberOfphnCallBacks >= callBacks, "Phone callback leads are not updated properly");
		Assert.assertTrue(numberOfPhnCalls >= call, "Phone call leads are not updated properly");

		FileWriter fw = new FileWriter(leadsData);
		String temp = "Number of Email leads=" + numberOfEmails + "@";
		temp += "Number of callBacks =" + numberOfphnCallBacks + "@";
		temp += "Number of phone call leads =" + numberOfPhnCalls;
		fw.write(temp);
		waitTill(3000);
		if (fw != null)
			fw.close();
		leadsObj.leadsGenerationinTPRO();
	}
}
