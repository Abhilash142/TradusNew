package sanity_test_TPRO;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.AllStockTradusPROPage;
import com.tradus.pro.pages.CreateStockTradusProPage;
import com.tradus.pro.pages.LoginTradusPROPage;

import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.actionClick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.dynamicSelect;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.generateRandomNumber;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.switchWindow;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllStockTradusPROTest extends BaseClass{
	
	/*
	 * Description: Verify posted ad with image, title, Category, type, sub type, Currency and price type are displaying below 'My stock' text
	 */
	@Test(priority=1)
	public void verifyPostedAdWithImageTitleCategoryTypeSubTypeCurrencyAndPriceAreDisplayingBelowMyStockText() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		/*loadUrl(driver, "https://pro.tradus.com/login");
		waitTill(4000);
		driver.manage().window().maximize();
		explicitWaitFortheElementTobeVisible(driver, loginPage.emailTextField);*/
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		waitTill(5000);
	//	Assert.assertEquals(getText(AllStockPage.CountOfAllCategoryAds), "2 results for all categories", 
		//		"No of ads found is not showing as 2 ads");
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			switch(i) {
			case 1: Assert.assertTrue(AllStockPage.PostedAdsImages.get(i).getAttribute("src").equals("https://images.tradus.com/v1/86e3d807-9e31-4c3b-a93d-1e3896d7fc2f.jpg"),
				    "Uploaded image is not displaying for 1st ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsTitles.get(i)).equals("Cosnet 76"),
					"Given Title is not displaying for 1st ad in All stock page");
					Assert.assertTrue(getText(AllStockPage.PostedAdsCategoryTypeAndSubType.get(i)).equals("Spare parts / Other spare parts and tools / Tools"),
				    "Given category, Type & Sub type are not displaying for 1st ad in All stock page");
					Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 100"),
						    "Given currency & price are not displaying for 1st ad in All stock page");break;
			/*case 1: Assert.assertTrue(AllStockPage.PostedAdsImages.get(i).getAttribute("src").equals("https://images.tradus.com/v1/00d24f9e-51a1-4f25-919f-23f9d46a1e64.jpg"),
					"Uploaded image is not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsTitles.get(i)).equals("Dionex 32"),
						"Given Title is not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsCategoryTypeAndSubType.get(i)).equals("Spare parts / Other spare parts and tools / Tools"),
					    "Given category, Type & Sub type are not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 0"),
					    "Given currency & price are not displaying for 2nd ad in All stock page");*/
			}
		}
	}
	
	/*
	 * Description : Verify ad id, Price, TMV, Visits, emails and status details are displaying
	 */
	@Test(priority=2)
	public void verifyAdIdPriceTMVVisitsEmailsAndStatusDetailsAreDisplaying() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		Assert.assertEquals(AllStockPage.PostedAds.size(), 2, 
				"No of ads found is not showing as 2 ads");
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			switch(i) {
			/*case 0: Assert.assertTrue(getText(AllStockPage.PostedAdsAdIds.get(i)).equals("Ad ID: 2884508"),
				    "Expected Ad id is not displaying for 1st ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 100"),
				    "Given currency & price are not displaying for 1st ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsTMV.get(i)).equals("No price rating"),
				    "Tradus market value is not displaying as no price rating for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTMV.get(i)),
				    "Visits are not displaying for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsEmails.get(i)),
				    "Emails are not displaying for 1st ad in all stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsStatus.get(i)).equals("Tradus"),
				    "Status is not displaying as active on tradus for 1st ad in All stock page");break;*/
			case 0: Assert.assertTrue(getText(AllStockPage.PostedAdsAdIds.get(i)).equals("Ad ID: 2884509"),
				    "Expected Ad id is not displaying for 2nd ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 0"),
				    "Given currency & price are not displaying for 2nd ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsTMV.get(i)).equals("No price rating"),
				    "Tradus market value is not displaying as no price rating for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTMV.get(i)),
				    "Visits are not displaying for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsEmails.get(i)),
				    "Emails are not displaying for 2nd ad in all stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsStatus.get(i)).equals("Tradus"),
				    "Status is not displaying as active on tradus for 2nd ad in All stock page");
			}
		}
	}
	
	/*
	 * Description : Verify 'Edit, delete and Promote' options are displaying for published ads
	 */
	@Test(priority=3)
	public void verifyEditDeleteAndPromoteOptionsAreDisplayingForPublishedAds() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		/*Assert.assertEquals(AllStockPage.PostedAds.size(), 2, 
				"No of ads found is not showing as 2 ads");*/
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			switch(i) {
			case 0: Assert.assertTrue(verifyElementPresent(AllStockPage.EditOptionOnPostedAds.get(i)),
				    "Edit option is not displaying for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.DeleteOptionOnPostedAds.get(i)),
				    "Delete option is not displaying for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PromoteOptionOnPostedAds.get(i)),
				    "Promote option is not displaying for 1st ad in all stock page");break;
			case 1: Assert.assertTrue(verifyElementPresent(AllStockPage.EditOptionOnPostedAds.get(i)),
				    "Edit option is not displaying for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.DeleteOptionOnPostedAds.get(i)),
				    "Delete option is not displaying for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PromoteOptionOnPostedAds.get(i)),
				    "Promote option is not displaying for 2nd ad in all stock page");
			}
			}
	}
																		
	/*
	 * Description : Verify 'Tradus' link is displaying when ad is published
	 */
	@Test(priority=4)
	public void verifyTradusLinkIsDisplayingWhenAdIsPublished() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		/*Assert.assertEquals(AllStockPage.PostedAds.size(), 2, 
				"No of ads found is not showing as 2 ads");*/
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			Assert.assertTrue(verifyElementPresent(AllStockPage.TradusLinkOnPostedAds.get(i)),
				    "Tradus link is not displaying on posted ads in all stock page");
		}
	}
	
	/*
	 * Description: Verify able to edit and update the ad and Verify updated details in TCOM
	 * [Note: Checking this with Cosnet 76 Ad]
	 */
	@Test(priority=5)
	public void verifyAbletoEditandUpdatetheAd() throws Exception{
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		waitTill(2000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword("automation.testing.sunfra@gmail.com", "tradus123");
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.secondStockVerificationElement);
		jsClick(driver, AllStockPage.EditOptionOnPostedAds.get(1));
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(3000);
		scrollToElement(driver, createStockObj.vehicleVersionFieldPostingForm);
		waitTill(7000);
		click(createStockObj.fuelTypeinPosting);
		click(createStockObj.fuelTypeDropdownvalues
				.get(dynamicSelect(createStockObj.fuelTypeDropdownvalues)));
		waitTill(1000);
		scrollToElement(driver, createStockObj.conditioninPostingForm);
		waitTill(4000);
		click(createStockObj.conditioninPostingForm);
		click(createStockObj.conditionDropdownvalues
				.get(dynamicSelect(createStockObj.conditionDropdownvalues)));
		waitTill(1000);
		sendKeys(createStockObj.constructionYearAreainPostingForm,generateRandomNumber(2015,2021));
		sendKeys(createStockObj.sellerReferenceAreainPostingForm,generateRandomNumber(369258,369300));
		sendKeys(createStockObj.VINAreainPostingForm,generateRandomNumber(21144567,21144600));
		waitTill(3000);
		List<String> actualInputs=new ArrayList<String>();
		actualInputs.add(getAttribute(createStockObj.constructionYearAreainPostingForm,"value"));
		actualInputs.add(getAttribute(createStockObj.sellerReferenceAreainPostingForm,"value"));
		actualInputs.add(getAttribute(createStockObj.VINAreainPostingForm,"value"));
		actualInputs.add(getText(createStockObj.fuelTypeinPosting));
		actualInputs.add(getText(createStockObj.conditioninPostingForm));
		waitTill(2000);
		jsClick(driver,AllStockPage.saveButtoninPostingForm);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		Assert.assertTrue(
				getText(createStockObj.successToastInPostingForm).replace("\n", ", ").trim()
						.contains("Successful action, Your ad was posted."),
				"Success message is not displayed while posting Ad with image and with all mandatory fields filled");
		String pageURL=driver.getCurrentUrl();
		Assert.assertTrue(getCurrentUrl(driver).equals(pageURL)
				,"Page is not navigating to All ads age after posting success");
		waitTill(3000);
		String parentURL=driver.getCurrentUrl();
		jsClick(driver,AllStockPage.TradusLinkOnPostedAds.get(0));
		switchWindow(driver,parentURL);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.makeandModelonTradusADP);
		waitTill(3000);
		Assert.assertTrue(getText(AllStockPage.makeandModelonTradusADP).trim().equals("MAN MAN 18.324"), "Ad deatils for MAN MAN 18.324 ad is not displaying on Tradus");
		WebElement[] updatedVal= {AllStockPage.makeYearonTradusADP,AllStockPage.sellerRefNoonTradusADP,AllStockPage.vinNumberonTradusADP};
		String[] attributeName= {"MakeYear","SellerRef","VINNumber"};
		for(int i=0;i<updatedVal.length;i++) {
			Assert.assertTrue(getText(updatedVal[i]).trim().equals(actualInputs.get(i).trim()), ""+attributeName[i]+" is not upldated properly");
		}
		
	}
	
    /*
 * Description : Verify ad should be removed in Tcom as well on clicking delete button, Verify deleted ad should not display across Tcom
 */

//@Test(priority=5)
public void verifyAdShouldBeRemovedInTcomAswellOnClickingDeleteButton() throws Exception {
	LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
	CreateStockTradusProPage createStockObj= new CreateStockTradusProPage(driver);
	AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
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
	sendKeys(createStockObj.netPriceFieldPostingForm, "10000");
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
	actionClick(driver, createStockObj.vehicleMakeasVolvo);
	waitTill(3000);
	click(createStockObj.vehicleModelFieldPostingForm);
	actionClick(driver, createStockObj.vehicleModelas8700);
	waitTill(4000);
	sendKeys(createStockObj.descriptionAreainPostingForm, "Ad");
	jsClick(driver, createStockObj.postYourAdButton);
	explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
	for(int i=0;i<12;i++)
	{
		if(verifyElementPresent(AllStockPage.SparePartsTestAd))
		{
			break;
		}
		else 
		{
			if(i==11)
			{
				Assert.assertTrue(verifyElementPresent(AllStockPage.SparePartsTestAd), "Inserted ad not displaying in All stock page");
			}
			driver.navigate().refresh();
			waitTill(10000);
		}
	}
	explicitWaitFortheElementTobeVisible(driver, AllStockPage.TradusLinkOnSparePartsAd);
	jsClick(driver, AllStockPage.TradusLinkOnSparePartsAd);
	String parentWindow= driver.getWindowHandle();
	switchWindow(driver, parentWindow);
	String adURL= getCurrentUrl(driver);
	String childWindow= driver.getWindowHandle();
	switchWindow(driver, childWindow);
	waitTill(10000);
	jsClick(driver, AllStockPage.DeleteOptionOnSparePartsAd);
	explicitWaitFortheElementTobeVisible(driver, AllStockPage.YesButtonOnAdDeletePopup);
	jsClick(driver, AllStockPage.YesButtonOnAdDeletePopup);
	explicitWaitFortheElementTobeVisible(driver, AllStockPage.successToastInAllStockPage);
	loadUrl(driver, adURL);
	for(int i=0;i<12;i++)
	{
		if(verifyElementPresent(AllStockPage.SparePartsTestAdTitle))
		{
			if(i==11)
			{
				Assert.assertFalse(verifyElementPresent(AllStockPage.SparePartsTestAdTitle), "Deleted ad still displaying even after deleting");
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
