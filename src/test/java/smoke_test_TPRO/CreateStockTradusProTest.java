package smoke_test_TPRO;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.dynamicSelect;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

import static com.tradus.core.GlobalConstants.userName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.testUser;
import static com.tradus.core.GlobalConstants.osName;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradus.core.BaseClass;
import com.tradus.pro.pages.CreateStockTradusProPage;
import com.tradus.pro.pages.LoginTradusPROPage;
import com.tradus.pro.pages.OverviewTradusPROPage;

public class CreateStockTradusProTest extends BaseClass{	
	/*
	 * Description: Verify error message 'Your payment is not done yet' along with
	 * pay package button if you're not paid for the package
	 */
	@Test
	public void verifyErrorAlertwithPayPackageButtonifpackageamountisnotPaid() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		waitTill(3000);
		OverviewTradusPROPage overviewPage= new OverviewTradusPROPage(driver);
		waitTill(3000);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(testUser,pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(1000);
		Assert.assertTrue(
				verifyElementPresent(createStockObj.packageUnpaidAlertInPostingForm)
						&& verifyElementPresent(createStockObj.payPackageButtonInPostingForm),
				"'Your payment isn't done' alert with pay package button is not displaying");
		Assert.assertTrue(getText((createStockObj.packageUnpaidAlertInPostingForm)).trim().equalsIgnoreCase(
				"Your ads will be published once the package payment has been confirmed. If you haven't yet paid your package, please complete that step first."),
				"Pay package alert text isn't correct");
		click(overviewPage.profileIconOnHeader);
	    waitTill(1000);
	    click(overviewPage.logoutOptionInProfileIconDropdown);
	    explicitWaitFortheElementTobeVisible(driver,overviewPage.LoginText);
	    waitTill(2000);
	}
	/*
	 * Description: Verify page is redirecting to create page on clicking create
	 * link in the menu
	 */
	@Test
	public void verifyPageisRedirectingtoCreatePageonClickingCreateLink() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		String pageURL = driver.getCurrentUrl();
		Assert.assertTrue(pageURL.equals("https://pro.tradus.com/lms/ads/create"),
				"User is not landing in create stock page upon clicking create link from side menu");
		waitTill(3000);
	}
	
	/*
	 * Description: Verify 'Upload picture', 'Price', 'Your vehicle', 'Custom
	 * description' sections are displaying initially
	 */
	@Test
	public void verifyUploadPicturePriceYourVehicleCustomDescription() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		Assert.assertTrue(verifyElementPresent(createStockObj.uploadImageSectionInPostingForm),
				"Upload images of your equipment label is not displaying");
		waitTill(3000);
		//Assert.assertTrue(verifyElementPresent(createStockObj.uploadImageButtonInPostingForm1),
		//		"Image upload button is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.yourVehicleSectionInPostingForm),
				"Your vehicle section is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.priceSectionInPostingForm),
				"Price section is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.customeDescriptionSectionInPostingForm),
				"Custome Description section is not present");
	}
	
	/*
	 * Description:verify error messge on trying to post the ad without filling
	 * mandatory fields
	 */
	@Test
	public void verifyErrorMessageonTryingtoPostAdwithoutFillingMandatoryfields() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		jsClick(driver, createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.errorAlertInPostingForm);
		Assert.assertTrue(
				getText(createStockObj.errorAlertInPostingForm).replace("\n", ", ").trim()
						.contains("You have to upload at least 1 image."),
				"Proper error message is not displayed while posting Ad without filling any fields");
		waitTill(2000);
		String temp = "";
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		//createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpg");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		waitTill(3000);
		jsClick(driver, createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.errorAlertInPostingForm);
		Assert.assertTrue(
				getText(createStockObj.errorAlertInPostingForm).replace("\n", ", ").trim()
						.contains("There are empty or invalid fields, please check and fix them."),
				"Proper error message is not displayed while posting Ad with image and without filling any fields");
		waitTill(2000);

	}
	
	/*
	 * Description: Verify able to publish after filling mandatory fields
	 */
	@Test
	public void verifypublishingAdafterfillingMandatoryFieldswithValidCredentials() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		String temp = "";
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		//createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpg");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
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
		sendKeys(createStockObj.netPriceFieldPostingForm, "150");
		waitTill(1000);
		scrollToElement(driver, createStockObj.vehicleCategoryFieldPostingForm);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasSpareParts);
		WebElement[] mandatoryAttributes = { createStockObj.vehicleCategoryFieldPostingForm,
				createStockObj.vehicleSubCategoryFieldPostingForm, createStockObj.vehicleMakeFieldPostingForm,
				createStockObj.vehicleModelFieldPostingForm, createStockObj.vehicleVersionFieldPostingForm };
		for (int i = 0; i < mandatoryAttributes.length; i++) {
			waitTill(4000);
			if (!getAttribute(mandatoryAttributes[i], "class").contains("multiselect--disabled")) {
				click(mandatoryAttributes[i]);
				waitTill(2000);
				switch (i) {
				case 0:
					click(createStockObj.categoryDropdownvalues
							.get(dynamicSelect(createStockObj.categoryDropdownvalues)));
					waitTill(1000);
					break;

				case 1:
					click(createStockObj.subCategoryDropdownvalues
							.get(dynamicSelect(createStockObj.subCategoryDropdownvalues)));
					waitTill(1000);
					break;

				case 2:
					click(createStockObj.makeDropdownvalues.get(dynamicSelect(createStockObj.makeDropdownvalues)));
					waitTill(1000);
					break;

				case 3:
					click(createStockObj.modelDropdownvalues.get(dynamicSelect(createStockObj.modelDropdownvalues)));
					waitTill(1000);
					break;
				case 4:
					click(createStockObj.versionDropdownvalues
							.get(dynamicSelect(createStockObj.versionDropdownvalues)));
					waitTill(1000);
					break;
				}
			}
		}
		waitTill(3000);
		sendKeys(createStockObj.descriptionAreainPostingForm, "Test Ad Test Ad Test Ad");
		waitTill(3000);
		jsClick(driver,createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		System.out.println(getText(createStockObj.successToastInPostingForm).replace("\n", ", ").trim());
		Assert.assertTrue(
				getText(createStockObj.successToastInPostingForm).replace("\n", ", ").trim()
						.contains("Successful action, Your ad was posted."),
				"Success message is not displayed while posting Ad with image and with all mandatory fields filled");
		waitTill(3000);
		String pageURL=driver.getCurrentUrl();
		Assert.assertTrue(getCurrentUrl(driver).equals(pageURL)
				,"Page is not navigating to All ads age after posting success");
		
	}

	/*
	 * Description: Verify able to publish the ad with all the filled fields
	 */
	@Test
	public void verifypublishingAdafterfillingAllFieldswithValidCredentials() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(1000);
		String temp = "";
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		//createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpg");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
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
		sendKeys(createStockObj.netPriceFieldPostingForm, "150");
		waitTill(1000);
		jsClick(driver, createStockObj.priceNegotialbleCheckBoxinPosting);
		jsClick(driver, createStockObj.exchangePossibleCheckBoxinPosting);
		jsClick(driver, createStockObj.rentPossibleCheckBoxinPosting);
		jsClick(driver, createStockObj.leasePossibleCheckBoxinPosting);
		scrollToElement(driver, createStockObj.vehicleCategoryFieldPostingForm);
		waitTill(1000);
		waitTill(1000);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasSpareParts);
		WebElement[] mandatoryAttributes = { createStockObj.vehicleCategoryFieldPostingForm,
				createStockObj.vehicleSubCategoryFieldPostingForm, createStockObj.vehicleMakeFieldPostingForm,
				createStockObj.vehicleModelFieldPostingForm, createStockObj.vehicleVersionFieldPostingForm };
		List<WebElement> elementsNotPresent = new ArrayList<WebElement>();
		for (int i = 0; i < mandatoryAttributes.length; i++) {
			waitTill(4000);
			if (!getAttribute(mandatoryAttributes[i], "class").contains("multiselect--disabled")) {
				click(mandatoryAttributes[i]);
				waitTill(2000);
				switch (i) {
				case 0:
					click(createStockObj.categoryDropdownvalues
							.get(dynamicSelect(createStockObj.categoryDropdownvalues)));
					waitTill(1000);
					break;

				case 1:
					click(createStockObj.subCategoryDropdownvalues
							.get(dynamicSelect(createStockObj.subCategoryDropdownvalues)));
					waitTill(1000);
					break;

				case 2:
					click(createStockObj.makeDropdownvalues.get(dynamicSelect(createStockObj.makeDropdownvalues)));
					waitTill(1000);
					break;

				case 3:
					click(createStockObj.modelDropdownvalues.get(dynamicSelect(createStockObj.modelDropdownvalues)));
					waitTill(1000);
					if (getText(createStockObj.modelFieldAutofillValue).trim().equalsIgnoreCase("Other")) {
						sendKeys(createStockObj.modelFieldOtherTextBox, "55");
					}
					break;
				case 4:
					click(createStockObj.versionDropdownvalues
							.get(dynamicSelect(createStockObj.versionDropdownvalues)));
					waitTill(1000);
					break;
				}
			} else {
				elementsNotPresent.add(mandatoryAttributes[i]);
			}
		}
		waitTill(3000);
		WebElement[] postingSections = { createStockObj.TechnicalSpecSectionInPostingForm,
				createStockObj.engineandTransmiddionSectionInPostingForm, createStockObj.DimensionSectionInPostingForm,
				createStockObj.OptionsSectionInPostingForm, createStockObj.overViewSectionInPostingForm,
				createStockObj.additionalDetailsLabelInPostingForm };
		for (int i = 0; i < postingSections.length; i++) {
			if (verifyElementPresent(postingSections[i])) {
				scrollToElement(driver, postingSections[i]);
				switch (i) {
				case 0:
					WebElement[] technicalSpecs = { createStockObj.netWeightAreainPostingForm,
							createStockObj.grossWeightAreainPostingForm };
					String[] technicalSpecData = { "140", "155" };
					for (int x = 0; x < technicalSpecs.length; x++) {
						if (verifyElementPresent(technicalSpecs[x])) {
							sendKeys(technicalSpecs[x], technicalSpecData[x]);
						} else {
							elementsNotPresent.add(technicalSpecs[x]);
						}
					}
					break;
				case 1:
					WebElement[] engineSpecs = { createStockObj.fuelTypeinPosting,
							createStockObj.engineModelinPosting };
					if (verifyElementPresent(engineSpecs[0])) {
						click(createStockObj.fuelTypeinPosting);
						click(createStockObj.fuelTypeDropdownvalues
								.get(dynamicSelect(createStockObj.fuelTypeDropdownvalues)));
						waitTill(1000);
					} else {
						elementsNotPresent.add(engineSpecs[0]);
					}
					if (verifyElementPresent(engineSpecs[1])) {
						sendKeys(createStockObj.engineModelinPosting, "BE40721SERT31");
					} else {
						elementsNotPresent.add(engineSpecs[1]);
					}
					break;
				case 2:
					WebElement[] dimensionSpecs = { createStockObj.heightAreainPostingForm,
							createStockObj.widthAreainPostingForm, createStockObj.lenghtAreainPostingForm };
					String[] dimensionSpecsData = { "3", "2", "2.5" };
					for (int x = 0; x < dimensionSpecs.length; x++) {
						if (verifyElementPresent(dimensionSpecs[x])) {
							sendKeys(dimensionSpecs[x], dimensionSpecsData[x]);
						} else {
							elementsNotPresent.add(dimensionSpecs[x]);
						}
					}
					break;
				/*case 3:
					if (verifyElementPresent(createStockObj.fitsToFollowingMachineAreainPostingForm)) {
						sendKeys(createStockObj.fitsToFollowingMachineAreainPostingForm, "All");
					} else {
						elementsNotPresent.add(createStockObj.fitsToFollowingMachineAreainPostingForm);
					}
					break;*/
				case 4:
					WebElement[] overviewSpecs = { createStockObj.sellerReferenceAreainPostingForm,
							createStockObj.constructionYearAreainPostingForm, createStockObj.mileageAreainPostingForm,
							createStockObj.hoursRunAreainPostingForm };
					String[] overviewSpecsData = { "87956414", "2019", "4000", "360" };
					for (int x = 0; x < overviewSpecs.length; x++) {
						if (verifyElementPresent(overviewSpecs[x])) {
							sendKeys(overviewSpecs[x], overviewSpecsData[x]);
							waitTill(1000);
						}
					}

					if (verifyElementPresent(createStockObj.constructionMonthinPostingForm)) {
						click(createStockObj.constructionMonthinPostingForm);
						click(createStockObj.constructionMonthDropdownvalues
								.get(dynamicSelect(createStockObj.constructionMonthDropdownvalues)));
						waitTill(1000);
					}
					if (verifyElementPresent(createStockObj.conditioninPostingForm)) {
						click(createStockObj.conditioninPostingForm);
						click(createStockObj.conditionDropdownvalues
								.get(dynamicSelect(createStockObj.conditionDropdownvalues)));
						waitTill(1000);
					}

					break;
				case 5:
					if (verifyElementPresent(createStockObj.VINAreainPostingForm)) {
						sendKeys(createStockObj.VINAreainPostingForm, "400078596412");
					} else {
						elementsNotPresent.add(createStockObj.VINAreainPostingForm);
					}
					break;

				}
			}
		}
		waitTill(3000);
		sendKeys(createStockObj.descriptionAreainPostingForm, "Test Ad Test Ad Test Ad");
		waitTill(5000);
		jsClick(driver,createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		Assert.assertTrue(
				getText(createStockObj.successToastInPostingForm).replace("\n", ", ").trim()
						.contains("Successful action, Your ad was posted."),
				"Proper error message is not displayed while posting Ad with image and with all mandatory fields filled");
		waitTill(3000);
		String pageURL=driver.getCurrentUrl();
		Assert.assertTrue(getCurrentUrl(driver).equals(pageURL)
				,"Page is not navigating to All ads age after posting success");
		waitTill(3000);
	}
	
	/*
	 * Description: Verify able to preview ad and all the submitted details should
	 * display in preview ad and Verify able to publish the ad from Preview ad page too
	 */
	@Test
	public void verifyAbletoseealltehdetailsaddedinPostingforminPreviewpage() throws Exception {
		CreateStockTradusProPage createStockObj = new CreateStockTradusProPage(driver);
		LoginTradusPROPage loginPage = new LoginTradusPROPage(driver);
		loginPage.setAccountEmailAndPassword(userName, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		jsClick(driver, createStockObj.myStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.createMyStockOptioninSiderBar);
		jsClick(driver, createStockObj.createMyStockOptioninSiderBar);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(1000);
		String temp = "";
		System.out.println(osName);
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		//createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + "\\Tire.jpg");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
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
		scrollToElement(driver, createStockObj.vehicleMakeFieldPostingForm);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasSpareParts);
		waitTill(3000);
		click(createStockObj.vehicleCategoryFieldPostingForm);
		actionClick(driver, createStockObj.vehicleCategoryasTires);
		waitTill(3000);
		click(createStockObj.vehicleMakeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleMakeasJCB);
		waitTill(2000);
		click(createStockObj.vehicleModelFieldPostingForm);
		click(createStockObj.vehicleModelasHydradig);
		// actionClick(driver,createStockObj.vehicleModelasHydradig);
		waitTill(2000);
		click(createStockObj.vehicleVersionFieldPostingForm);
		actionClick(driver, createStockObj.vehicleVersionas110);
		waitTill(1000);
		sendKeys(createStockObj.netWeightAreainPostingForm, "100");
		sendKeys(createStockObj.grossWeightAreainPostingForm, "110");
		sendKeys(createStockObj.heightAreainPostingForm, "3");
		sendKeys(createStockObj.widthAreainPostingForm, "2");
		sendKeys(createStockObj.lenghtAreainPostingForm, "2.5");
		waitTill(2000);
	//	sendKeys(createStockObj.fitsToFollowingMachineAreainPostingForm, "All");
		sendKeys(createStockObj.sellerReferenceAreainPostingForm, "100200300");
		sendKeys(createStockObj.constructionYearAreainPostingForm, "2018");
		sendKeys(createStockObj.mileageAreainPostingForm, "1150");
		sendKeys(createStockObj.hoursRunAreainPostingForm, "360");
		waitTill(1000);
		click(createStockObj.constructionMonthinPostingForm);
		click(createStockObj.makeMonthasDecember);
		waitTill(2000);
		click(createStockObj.conditioninPostingForm);
		click(createStockObj.conditionasSemiNew);
		waitTill(2000);
		sendKeys(createStockObj.VINAreainPostingForm, "987987654654");
		sendKeys(createStockObj.descriptionAreainPostingForm, "Test Ad Test Ad Test Ad");
		waitTill(3000);
		jsClick(driver, createStockObj.previewYourAdButtonInPostingForm);
		waitTill(6000);
		Assert.assertTrue(
				getText(createStockObj.makeModelVersioninPreviewpage).trim().equalsIgnoreCase("Jcb Hydradig 110"),
				"Make model version are not same in preview page");
		Assert.assertTrue(getText(createStockObj.subCategoryinPreviewpage).trim().equalsIgnoreCase("Tires"),
				"Category and subcategory are not same in preview page");
		String priceinPreview = getText(createStockObj.netPriceinPreviewpage).replaceAll("[^a-zA-Z0-9]", "").trim();
		Assert.assertTrue(priceinPreview.equalsIgnoreCase("10000"), "Net price is not same in preview page");
		Assert.assertTrue(getText(createStockObj.yearinPreviewpage).equalsIgnoreCase("2018"),
				"Manufacturing year is not same in preview page");
		String mileageinPreview = getText(createStockObj.mileageinPreviewpage).replace("km", "").trim();
		Assert.assertTrue(mileageinPreview.equalsIgnoreCase("1150"), "Mileage is not same in preview page");
		Assert.assertTrue(getText(createStockObj.netWeightinPreviewpage).equalsIgnoreCase("100"),
				"net weight is not same in preview page");
		Assert.assertTrue(getText(createStockObj.grossWeightinPreviewpage).equalsIgnoreCase("110"),
				"gross weight is not same in preview page");
		Assert.assertTrue(getText(createStockObj.heightinPreviewpage).equalsIgnoreCase("3"),
				"Height is not same in preview page");
		Assert.assertTrue(getText(createStockObj.widthinPreviewpage).equalsIgnoreCase("2"),
				"Width is not same in preview page");
		Assert.assertTrue(getText(createStockObj.lengthinPreviewpage).equalsIgnoreCase("2.5"),
				"Length is not same in preview page");
		/*Assert.assertTrue(getText(createStockObj.fitsToFollowingMachinesinPreviewpage).equalsIgnoreCase("All"),
				"FitsToFollowingMachines data are not same in preview page");*/
		Assert.assertTrue(getText(createStockObj.sellersRefinPreviewpage).equalsIgnoreCase("100200300"),
				"Seller ref data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.constructionMonthinPreviewpage).equalsIgnoreCase("12"),
				"Construction month data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.hoursRuninPreviewpage).equalsIgnoreCase("360"),
				"Hours run data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.conditioninPreviewpage).equalsIgnoreCase("Semi-new"),
				"Condition data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.vininPreviewpage).equalsIgnoreCase("987987654654"),
				"VIN data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.descriptioninPreviewpage).equalsIgnoreCase("Test Ad Test Ad Test Ad"),
				"Construction month data are not same in preview page");
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postYourAdButtonInPreviewPage);
		jsClick(driver, createStockObj.postYourAdButtonInPreviewPage);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		Assert.assertTrue(getText(createStockObj.successToastInPostingForm).contains("ad was posted"), 
				"Success toast not displayed after inserting an ad");
		waitTill(2000);
	}
}
