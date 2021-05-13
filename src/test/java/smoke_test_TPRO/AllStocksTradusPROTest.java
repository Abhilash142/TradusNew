package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.dynamicSelect;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.generateRandomNumber;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userName;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.AllStockTradusPROPage;
import com.tradus.pro.pages.CreateStockTradusProPage;
import com.tradus.pro.pages.LoginTradusPROPage;

public class AllStocksTradusPROTest extends BaseClass{
	/*
	 * Description: Verify posted ad with image, title, Category, type, sub type, Currency and price type are displaying below 'My stock' text
	 */
	@Test
	public void verifyPostedAdWithImageTitleCategoryTypeSubTypeCurrencyAndPriceAreDisplayingBelowMyStockText() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		waitTill(3000);
		while(!verifyElementPresent(AllStockPage.tradusLinkforMANtires)) {
			driver.navigate().refresh();
			waitTill(3000);
		}
		/*Assert.assertEquals(getText(AllStockPage.CountOfAllCategoryAds), "2 results for all categories", 
				"No of ads found is not showing as 2 ads");*/
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			/*switch(i) {
			case 0: Assert.assertTrue(AllStockPage.PostedAdsImages.get(i).getAttribute("src").equals("https://images.tradus.com/v1/bc71cea3-14fa-44d3-b115-8941000caa91.jpg"),
				    "Uploaded image is not displaying for 1st ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsTitles.get(i)).equals("Dionex 32"),
					"Given Title is not displaying for 1st ad in All stock page");
					Assert.assertTrue(getText(AllStockPage.PostedAdsCategoryTypeAndSubType.get(i)).equals("Spare parts / Other spare parts and tools / Tools"),
				    "Given category, Type & Sub type are not displaying for 1st ad in All stock page");
					Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 0"),
						    "Given currency & price are not displaying for 1st ad in All stock page");break;
			case 1: Assert.assertTrue(AllStockPage.PostedAdsImages.get(i).getAttribute("src").equals("https://images.tradus.com/v1/65487bf4-7650-4c26-b3bb-8d87d0c154bd.jpg"),
					"Uploaded image is not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsTitles.get(i)).equals("MAN"),
						"Given Title is not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsCategoryTypeAndSubType.get(i)).equals("Spare parts / Engines"),
					    "Given category, Type & Sub type are not displaying for 2nd ad in All stock page");
			        Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 100"),
					    "Given currency & price are not displaying for 2nd ad in All stock page");*/
		 
			
			        Assert.assertFalse(AllStockPage.PostedAdsImages.get(i).getAttribute("src").isEmpty(),
							"Uploaded image is not displaying for "+i+ " ad in All stock page");
			        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTitles.get(i)),
							"Given Title is not displaying for "+i+ " ad in All stock page");
			        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsCategoryTypeAndSubType.get(i)),
						    "Given category, Type & Sub type are not displaying for "+i+ " ad in All stock page");
			        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsCurrencyAndPrices.get(i)),
						    "Given currency & price are not displaying for 2nd ad in All stock page");
		}   
			
	}
	
	/*
	 * Description : Verify ad id, Price, TMV, Visits, emails and status details are displaying
	 */
	@Test
	public void verifyAdIdPriceTMVVisitsEmailsAndStatusDetailsAreDisplaying() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		waitTill(2000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		waitTill(3000);
		while(!verifyElementPresent(AllStockPage.tradusLinkforMANtires)) {
			driver.navigate().refresh();
			waitTill(3000);
		}
		for(int i=0; i<AllStockPage.PostedAds.size();i++)
		{
			/*switch(i) {
			case 0: Assert.assertTrue(getText(AllStockPage.PostedAdsAdIds.get(i)).equals("Ad ID: 2986865"),
				    "Expected Ad id is not displaying for 1st ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 0"),
				    "Given currency & price are not displaying for 1st ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsTMV.get(i)).equals("No price rating"),
				    "Tradus market value is not displaying as no price rating for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTMV.get(i)),
				    "Visits are not displaying for 1st ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsEmails.get(i)),
				    "Emails are not displaying for 1st ad in all stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsStatus.get(i)).equals("Tradus"),
				    "Status is not displaying as active on tradus for 1st ad in All stock page");break;
				    
			case 1: Assert.assertTrue(getText(AllStockPage.PostedAdsAdIds.get(i)).equals("Ad ID: 2986861"),
				    "Expected Ad id is not displaying for 2nd ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsCurrencyAndPrices.get(i)).equals("EUR 100"),
				    "Given currency & price are not displaying for 2nd ad in All stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsTMV.get(i)).equals("No price rating"),
				    "Tradus market value is not displaying as no price rating for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTMV.get(i)),
				    "Visits are not displaying for 2nd ad in all stock page");
			Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsEmails.get(i)),
				    "Emails are not displaying for 2nd ad in all stock page");
			Assert.assertTrue(getText(AllStockPage.PostedAdsStatus.get(i)).equals("Tradus"),
				    "Status is not displaying as active on tradus for 2nd ad in All stock page");
			}*/
			 Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsAdIds.get(i)),
					 "Expected Ad id is not displaying for "+i+ " ad in All stock page");
		        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsCurrencyAndPrices.get(i)),
		        		"Given currency & price are not displaying for "+i+ " ad in All stock page");
		        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsTMV.get(i)),
		        		"Tradus market value is not displaying as no price rating for "+i+ " ad in all stock page");
		        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsVisits.get(i)),
		        		"Visits are not displaying for "+i+ "  ad in all stock page");
		        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsEmails.get(i)),
		        		"Emails are not displaying for "+i+ " ad in all stock page");
		        Assert.assertTrue(verifyElementPresent(AllStockPage.PostedAdsStatus.get(i)),
		        		"Status is not displaying as active on tradus for "+i+ " ad in All stock page");
		}
	}
	
	/*
	 * Description : Verify 'Edit, delete and Promote' options are displaying for published ads
	 */
	@Test
	public void verifyEditDeleteAndPromoteOptionsAreDisplayingForPublishedAds() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		waitTill(3000);
		while(!verifyElementPresent(AllStockPage.tradusLinkforMANtires)) {
			driver.navigate().refresh();
			waitTill(3000);
		}
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
	@Test
	public void verifyTradusLinkIsDisplayingWhenAdIsPublished() throws Exception {
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		waitTill(3000);
		while(!verifyElementPresent(AllStockPage.tradusLinkforMANtires)) {
			driver.navigate().refresh();
			waitTill(3000);
		}
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
	 * 
	 */
	@Test
	public void verifyAbletoEditandUpdatetheAd() throws Exception{
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		AllStockTradusPROPage AllStockPage= new AllStockTradusPROPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.myStockOptioninSiderBar);
		jsClick(driver, AllStockPage.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.allMyStockOptioninSiderBar);
		jsClick(driver, AllStockPage.allMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.MyStockText);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.firstStockVerificationElement);
		jsClick(driver, AllStockPage.editButtonforMANtires);
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
		scrollToElement(driver, createStockObj.constructionYearAreainPostingForm);
		waitTill(3000);
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
		while(!verifyElementPresent(AllStockPage.tradusLinkforMANtires)) {
			waitTill(2000);
			driver.navigate().refresh();
		}
		jsClick(driver,AllStockPage.tradusLinkforMANtires);
		switchWindow(driver,parentURL);
		explicitWaitFortheElementTobeVisible(driver, AllStockPage.makeandModelonTradusADP);
		waitTill(3000);
		Assert.assertTrue(getText(AllStockPage.makeandModelonTradusADP).trim().equals("MAN MAN 18.324"), "Ad deatils for MAN MAN 18.324 ad is not displaying on Tradus");
		WebElement[] updatedVal= {AllStockPage.makeYearonTradusADP,AllStockPage.sellerRefNoonTradusADP,AllStockPage.vinNumberonTradusADP};
		String[] attributeName= {"MakeYear","SellerRef","VINNumber"};
		for(int i=0;i<updatedVal.length;i++) {
			Assert.assertTrue(getText(updatedVal[i]).trim().equals(actualInputs.get(i).trim()), ""+attributeName[i]+" is not updated properly");
		}
		
	}

}
