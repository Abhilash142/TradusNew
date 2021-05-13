package smoke_test_OTMP_LMS;

import static com.tradus.core.ActionElementClass.actionClick;
import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.dynamicSelect;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getCurrentUrl;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.scrollToElement;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.PLuser;
import static com.tradus.core.GlobalConstants.osName;
import static com.tradus.core.GlobalConstants.pwd;
import static com.tradus.core.GlobalConstants.userNamePL;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.otomotoProfi.LMS.pages.CreateStockOTMPLMSPage;
import com.otomotoProfi.LMS.pages.LoginOtomotoProfiLMSPage;
import com.tradus.core.BaseClass;

public class CreateStockOTMPLMSTest extends BaseClass {
	/*
	 * Description: Verify 'Upload picture', 'Price', 'Your vehicle', 'Custom description' sections are displaying initially
	 */
	@Test
	public void verifyUploadPicturePriceYourVehicleCustomDescription() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(userNamePL, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj=new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		Assert.assertTrue(verifyElementPresent(createStockObj.yourVehicleSectionInPostingForm),
				"Your vehicle section is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.priceSectionInPostingForm),
				"Price section is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.customeDescriptionSectionInPostingForm),
				"Custome Description section is not present");
		Assert.assertTrue(verifyElementPresent(createStockObj.uploadImageSectionInPostingForm),
				"Upload image section is not present");
	}
	
	/*
	 * Description: Verify few more sections 'Technical specifications', 'Engine and transmission', 'Dimensions', 'Options' , 'Overview', 'Additional details' and 'Extra information' are displaying after filling 'Price' and 'Your vehicle' data
	 */
	@Test
	public void verifyfewnewSectionsafterFillingPriceandYourVehicle() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(userNamePL, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj=new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		Assert.assertFalse(verifyElementPresent(createStockObj.TechnicalSpecSectionInPostingForm),
				"Technical specicifation section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.engineandTransmiddionSectionInPostingForm),
				"Engine & Transmiddion Section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.DimensionSectionInPostingForm),
				"Dimension Section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.OptionsSectionInPostingForm),
				"Options Section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.overViewSectionInPostingForm),
				"OverView Section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.additionalDetailsLabelInPostingForm),
				"Additional Details section is visible though price and vehicle data aren't filled");
		Assert.assertFalse(verifyElementPresent(createStockObj.extraInformationSectionInPostingForm),
				"Extra Information section is visible though price and vehicle data aren't filled");
		waitTill(1000);
		click(createStockObj.priceTypeFieldPostingForm);
		waitTill(1000);
		actionClick(driver, createStockObj.priceTypeasFixed);
		waitTill(1000);
		if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("PLN")) {
			click(createStockObj.currencyTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.currencyTypeasPLN);
		}
		sendKeys(createStockObj.netPriceFieldPostingForm, "10000");
		waitTill(1000);
		scrollToElement(driver, createStockObj.vehicleMakeFieldPostingForm);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasTransport);
		waitTill(3000);
		click(createStockObj.vehicleCategoryFieldPostingForm);
		actionClick(driver, createStockObj.vehicleCategoryasTrucks);
		waitTill(3000);
		click(createStockObj.vehicleSubCategoryFieldPostingForm);
		actionClick(driver, createStockObj.vehiclesubCategoryasTipper);
		waitTill(2000);
		click(createStockObj.vehicleMakeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleMakeasVolvo);
		waitTill(3000);
		click(createStockObj.vehicleModelFieldPostingForm);
		actionClick(driver, createStockObj.vehicleModelas8700);
		waitTill(4000);
		Assert.assertTrue(verifyElementPresent(createStockObj.TechnicalSpecSectionInPostingForm),
				"Technical specicifation section isn't visible though price and vehicle data are filled");
		Assert.assertTrue(verifyElementPresent(createStockObj.engineandTransmiddionSectionInPostingForm),
				"Engine & Transmiddion Section isn't visible though price and vehicle data are filled");
		Assert.assertTrue(verifyElementPresent(createStockObj.DimensionSectionInPostingForm),
				"Dimension Section isn't visible though price and vehicle data are filled");
		/*Assert.assertTrue(verifyElementPresent(createStockObj.OptionsSectionInPostingForm),
				"Options Section isn't visible though price and vehicle data are filled");*/
		Assert.assertTrue(verifyElementPresent(createStockObj.overViewSectionInPostingForm),
				"OverView Section isn't visible though price and vehicle data are filled");
		Assert.assertTrue(verifyElementPresent(createStockObj.additionalDetailsLabelInPostingForm),
				"Additional Details section isn't visible though price and vehicle data are filled");
		Assert.assertTrue(verifyElementPresent(createStockObj.extraInformationSectionInPostingForm),
				"Extra Information section isn't visible though price and vehicle data are filled");
	}
	
	/*
	 * Description: Verify error message at all mandatory fields upload image, Price type, currency, net price under Price section
     * Type, category, sub category(If applicable), Make, model, version (If applicable) under 'Your vehicle' section and 
     * Description field under 'custom description' section
	 */
	@Test
	public void verifyErrorMessagesUnderMandatoryFields() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(userNamePL, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj=new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		String temp = "";
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		jsClick(driver, createStockObj.postYourAdButton);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.errorAlertInPostingForm);
		waitTill(2000);
		WebElement[] mandatoryFields = { createStockObj.priceTypeFieldPostingForm, createStockObj.netPriceFieldPostingForm,
				createStockObj.descriptionAreainPostingForm, createStockObj.vehicleTypeFieldPostingForm,
				createStockObj.vehicleCategoryFieldPostingForm, createStockObj.vehicleSubCategoryFieldPostingForm,
				createStockObj.vehicleMakeFieldPostingForm, createStockObj.vehicleModelFieldPostingForm };
		WebElement[] errorText = { createStockObj.priceTypeFieldDangerText, createStockObj.netPriceFieldDangerText,
				createStockObj.vehicleDescriptionDangerText, createStockObj.vehicleTypeDangerText,
				createStockObj.vehicleCategoryDangerText, createStockObj.vehicleSubCategoryDangerText,
				createStockObj.vehicleMakeDangerText, createStockObj.vehicleModelDangerText };
		
		for(int i=0;i<mandatoryFields.length;i++) {
			switch(i) {
			case 0:
				Assert.assertTrue(getText(errorText[i]).equals("The price type field is required"),"Correct error under price type is not displaying");
				click(createStockObj.priceTypeFieldPostingForm);
				waitTill(1000);
				actionClick(driver, createStockObj.priceTypeasFixed);
				waitTill(1000);
				Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling price type");
				break;
			case 1:
				Assert.assertTrue(getText(errorText[i]).equals("The net price field is required"),"Correct error under net price is not displaying");
				sendKeys(createStockObj.netPriceFieldPostingForm,"1000");
				waitTill(1000);
				actionClick(driver,createStockObj.netPriceLabelInPostingForm);
				waitTill(1000);
				Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling price type");
				break;
			case 2:
				Assert.assertTrue(getText(errorText[i]).equals("The description (Polski) field is required"),"Correct error under Description is not displaying");
				sendKeys(createStockObj.descriptionAreainPostingForm,"Test Ad Test Ad Test Ad");
				waitTill(1000);
				Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling Description");
				scrollToElement(driver,createStockObj.vehicleTypeFieldPostingForm);
				waitTill(4000);
				break;
			case 3:
				Assert.assertTrue(getText(errorText[i]).equals("The type field is required"),"Correct error under Vehicle Type is not displaying");
				click(createStockObj.vehicleTypeFieldPostingForm);
				actionClick(driver, createStockObj.vehicleTypeasSpareParts);
				Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling Vehicle Type");
				waitTill(3000);
				break;
			case 4:
				Assert.assertTrue(getText(errorText[i]).equals("The category field is required"),"Correct error under category Type is not displaying");
				click(createStockObj.vehicleCategoryFieldPostingForm);
				waitTill(1000);
				click(createStockObj.categoryDropdownvalues
						.get(dynamicSelect(createStockObj.categoryDropdownvalues)));
				waitTill(1000);
				Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling Vehicle Category");
				waitTill(2000);
				break;
			case 5:
				if (!getAttribute(mandatoryFields[i], "class").contains("multiselect--disabled")) {
					Assert.assertTrue(getText(errorText[i]).equals("The subcategory field is required"),"Correct error under subcategory Type is not displaying");
					click(createStockObj.vehicleSubCategoryFieldPostingForm);
					waitTill(1000);
					click(createStockObj.subCategoryDropdownvalues
							.get(dynamicSelect(createStockObj.subCategoryDropdownvalues)));
					waitTill(1000);
					Assert.assertTrue(getText(errorText[i]).isEmpty(),"Alert still displays after filling Vehicle sub-Category");
					waitTill(2000);
					break;
				}
			case 6:
				if (!getAttribute(mandatoryFields[i], "class").contains("multiselect--disabled")) {
					Assert.assertTrue(getText(errorText[i]).equals("The make field is required"),
							"Correct error under make is not displaying for empty make field");
					click(createStockObj.vehicleMakeFieldPostingForm);
					waitTill(1000);
					click(createStockObj.makeDropdownvalues
							.get(dynamicSelect(createStockObj.makeDropdownvalues)));
					waitTill(1000);
					Assert.assertTrue(getText(errorText[i]).isEmpty(),
							"Alert still displays after filling Vehicle make");
					waitTill(2000);
					break;
				}
			case 7:
				if (!getAttribute(mandatoryFields[i], "class").contains("multiselect--disabled")) {
					Assert.assertTrue(getText(errorText[i]).equals("The model field is required"),
							"Correct error under make is not displaying for empty model field");
					click(createStockObj.vehicleModelFieldPostingForm);
					waitTill(1000);
					click(createStockObj.modelDropdownvalues
							.get(dynamicSelect(createStockObj.modelDropdownvalues)));
					waitTill(1000);
					Assert.assertTrue(getText(errorText[i]).isEmpty(),
							"Alert still displays after filling Vehicle model");
					waitTill(2000);
					break;
				}
			}
		}
	}
	
	/*
	 * Description: Verify able to preview ad and all the submitted details should display in preview ad and
	 * Verify able to publish the ad from Preview ad page too 
	 */
	@Test
	public void verifyAbletoseealltehdetailsaddedinPostingforminPreviewpage() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(PLuser, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj = new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		String temp = "";
		if (osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		waitTill(1000);
		click(createStockObj.priceTypeFieldPostingForm);
		waitTill(1000);
		actionClick(driver, createStockObj.priceTypeasFixed);
		waitTill(1000);
		if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("PLN")) {
			click(createStockObj.currencyTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.currencyTypeasPLN);
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
		waitTill(2000);
		click(createStockObj.vehicleVersionFieldPostingForm);
		actionClick(driver, createStockObj.vehicleVersionas110);
		waitTill(1000);
		sendKeys(createStockObj.netWeightAreainPostingForm, "100");
		sendKeys(createStockObj.grossWeightAreainPostingForm, "110");
		sendKeys(createStockObj.heightAreainPostingForm, "3");
		sendKeys(createStockObj.widthAreainPostingForm, "2");
		sendKeys(createStockObj.lenghtAreainPostingForm, "2.5");
		waitTill(1000);
		sendKeys(createStockObj.sellerReferenceAreainPostingForm, "100200300");
		//sendKeys(createStockObj.constructionYearAreainPostingForm, "2018");
		
		sendKeys(createStockObj.mileageAreainPostingForm, "1150");
		sendKeys(createStockObj.hoursRunAreainPostingForm, "360");
		waitTill(1000);
		sendKeys(createStockObj.fitsToFollowingMachineAreainPostingForm, "All");
		/*click(createStockObj.constructionMonthinPostingForm);
		click(createStockObj.makeMonthasDecember);*/
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
		String priceinPreview = getText(createStockObj.netPriceinPreviewpage).replaceAll("[^0-9,]","").trim();
		Assert.assertTrue(priceinPreview.equalsIgnoreCase("10,000"), "Net price is not same in preview page");
		/*Assert.assertTrue(getText(createStockObj.yearinPreviewpage).equalsIgnoreCase("2018"),
				"Manufacturing year is not same in preview page");*/
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
		Assert.assertTrue(getText(createStockObj.fitsToFollowingMachinesinPreviewpage).equalsIgnoreCase("All"),
				"FitsToFollowingMachines data are not same in preview page");
		Assert.assertTrue(getText(createStockObj.sellersRefinPreviewpage).equalsIgnoreCase("100200300"),
				"Seller ref data are not same in preview page");
		/*Assert.assertTrue(getText(createStockObj.constructionMonthinPreviewpage).equalsIgnoreCase("12"),
				"Construction month data are not same in preview page");*/
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
	}
	/*
	 * Description: Verify able to publish after filling mandatory fields
	 */
	@Test
	public void verifyAbletoPublishAfterfillingMandatoryFields() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(PLuser, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj=new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		String temp = "";
		if(osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		click(createStockObj.priceTypeFieldPostingForm);
		waitTill(1000);
		actionClick(driver, createStockObj.priceTypeasFixed);
		waitTill(1000);
		if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("PLN")) {
			click(createStockObj.currencyTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.currencyTypeasPLN);
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
		Assert.assertTrue(
				getText(createStockObj.successToastInPostingForm).replace("\n", ", ").trim()
						.contains("Successful action, Your ad was posted."),
				"Success message is not displayed while posting Ad with image and with all mandatory fields filled");
		String pageURL=driver.getCurrentUrl();
		Assert.assertTrue(getCurrentUrl(driver).equals(pageURL)
				,"Page is not navigating to All ads age after posting success");
	}
	
	/*
	 * Description: Verify able to publish the ad with all the filled fields
	 */
	@Test
	public void verifypublishingAdafterfillingMandatoryFieldswithValidCredentials() throws Exception {
		LoginOtomotoProfiLMSPage loginPage = new LoginOtomotoProfiLMSPage(driver);
		loginPage.setAccountEmailAndPassword(PLuser, pwd);
		jsClick(driver, loginPage.LoginButton);
		explicitWaitFortheElementTobeVisible(driver, loginPage.overviewPageVerificationElement);
		waitTill(2000);
		CreateStockOTMPLMSPage createStockObj = new CreateStockOTMPLMSPage(driver);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.postingFormVerificationElement);
		waitTill(2000);
		String temp = "";
		if (osName.equalsIgnoreCase("Windows"))
			temp = "\\Tire.jpg";
		else
			temp = "/Tire.jpg";
		createStockObj.uploadImageButtonInPostingForm.sendKeys(System.getProperty("user.dir") + temp);
		explicitWaitFortheElementTobeVisible(driver, createStockObj.successToastInPostingForm);
		click(createStockObj.priceTypeFieldPostingForm);
		waitTill(1000);
		actionClick(driver, createStockObj.priceTypeasFixed);
		waitTill(1000);
		if (!getText(createStockObj.currencyFieldAutofillValue).equalsIgnoreCase("PLN")) {
			click(createStockObj.currencyTypeFieldPostingForm);
			waitTill(1000);
			actionClick(driver, createStockObj.currencyTypeasPLN);
		}
		sendKeys(createStockObj.netPriceFieldPostingForm, "150");
		waitTill(2000);
		click(createStockObj.priceNegotialbleCheckBoxinPosting);
		click(createStockObj.exchangePossibleCheckBoxinPosting);
		click(createStockObj.rentPossibleCheckBoxinPosting);
		click(createStockObj.leasePossibleCheckBoxinPosting);
		scrollToElement(driver, createStockObj.vehicleCategoryFieldPostingForm);
		waitTill(2000);
		click(createStockObj.vehicleTypeFieldPostingForm);
		actionClick(driver, createStockObj.vehicleTypeasSpareParts);
		List<WebElement> elementsNotPresent = new ArrayList<WebElement>();
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
				case 3:
					if (verifyElementPresent(createStockObj.fitsToFollowingMachineAreainPostingForm)) {
						sendKeys(createStockObj.fitsToFollowingMachineAreainPostingForm, "All");
					} else {
						elementsNotPresent.add(createStockObj.fitsToFollowingMachineAreainPostingForm);
					}
					break;
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
	}
}
