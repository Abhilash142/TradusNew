package com.tradus.pro.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStockTradusProPage {
	public RemoteWebDriver driver=null;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/parent::div")
	public WebElement myStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/ancestor::div[contains(@class,'sidebar-group-open')]//span[text()='Create']")
	public WebElement createMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//section[contains(@class,'main-sidebar')]//span[text()='My stock']/ancestor::div[8]//span[text()='All']")
	public WebElement allMyStockOptioninSiderBar;
	
	@FindBy(xpath = "//span[contains(.,'Post')]/parent::button[contains(@class,'button-primary vs-button-filled')]")
	public WebElement postYourAdButton;
	
	@FindBy(xpath = "//h3[.='Your vehicle']")
	public WebElement postingFormVerificationElement;
	
	@FindBy(xpath = "//h4[contains(.,'Media')]")
	public WebElement mediaLabelInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Upload images')]/ancestor::div[@class='vx-card mb-8']")
	public WebElement uploadImageSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Price')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement priceSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Your vehicle')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement yourVehicleSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Custom description')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement customeDescriptionSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Technical specifications')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement TechnicalSpecSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Dimensions')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement DimensionSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Options')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement OptionsSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Engine and Transmission')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement engineandTransmiddionSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Overview')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement overViewSectionInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Additional details')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement additionalDetailsLabelInPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'Extra information')]/ancestor::div[contains(@class,'vs-collapse-item')]")
	public WebElement extraInformationSectionInPostingForm;
	
	@FindBy(xpath = "//span[contains(.,'Preview your ad ')]/parent::button")
	public WebElement previewYourAdButtonInPostingForm;
	
	@FindBy(xpath = "//input[@name='images[]']")
	public WebElement uploadImageButtonInPostingForm;
	
	@FindBy(xpath = "//input[@name='images[]' and @type='file']")
	public WebElement uploadImageButtonInPostingForm1;
	
	@FindBy(xpath = "//div[@class='vs-alert']/p[contains(.,'package payment has been confirmed')]")
	public WebElement packageUnpaidAlertInPostingForm;
	
	@FindBy(xpath = "//div[@class='vs-alert']/descendant::span[.=' Pay package ']/parent::button")
	public WebElement payPackageButtonInPostingForm;
	
	@FindBy(xpath = "//div[contains(@class,'vs-noti-danger activeNoti')]")
	public WebElement errorAlertInPostingForm;
	
	@FindBy(xpath = "//div[contains(@class,'vs-noti-success activeNoti')]")
	public WebElement successToastInPostingForm;
	
	@FindBy(xpath = "//button[contains(.,'Leave page')]")
	public WebElement LeavepageButtonInPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Price type')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement priceTypeFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Currency')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement currencyTypeFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Net price')]/parent::div/descendant::input")
	public WebElement netPriceFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Type')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleTypeFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Category')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleCategoryFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Subcategory')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleSubCategoryFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Make')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleMakeFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Model')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleModelFieldPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Version')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement vehicleVersionFieldPostingForm;
	
	@FindBy(xpath = "//h3[contains(.,'description')]/ancestor::div[contains(@class,'collapse-item')]//textarea")
	public WebElement descriptionAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Net Weight')]/parent::div/descendant::input")
	public WebElement netWeightAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Gross Weight')]/parent::div/descendant::input")
	public WebElement grossWeightAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Height')]/parent::div/descendant::input")
	public WebElement heightAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Width')]/parent::div/descendant::input")
	public WebElement widthAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Length')]/parent::div/descendant::input")
	public WebElement lenghtAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Fits To')]/parent::div/descendant::input")
	public WebElement fitsToFollowingMachineAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Sellers')]/parent::div/descendant::input")
	public WebElement sellerReferenceAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Construction Year')]/parent::div/descendant::input")
	public WebElement constructionYearAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Mileage')]/parent::div/descendant::input")
	public WebElement mileageAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Hours')]/parent::div/descendant::input")
	public WebElement hoursRunAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'VIN')]/parent::div/descendant::input")
	public WebElement VINAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'YouTube')]/parent::div/descendant::input")
	public WebElement YoutubeAreainPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Month')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement constructionMonthinPostingForm;
	
	@FindBy(xpath = "//label[contains(.,'Condition')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement conditioninPostingForm;
	
	@FindBy(xpath = "//span[contains(.,'Fixed')]/parent::li")
	public WebElement priceTypeasFixed;
	
	@FindBy(xpath = "//span[contains(.,'EUR')]/parent::li")
	public WebElement currencyTypeasEuro;
	
	@FindBy(xpath = "//span[contains(.,'Transport')]/parent::li")
	public WebElement vehicleTypeasTransport;
	
	@FindBy(xpath = "//span[contains(.,'parts')]/parent::li")
	public WebElement vehicleTypeasSpareParts;
	
	@FindBy(xpath = "//span[contains(.,'Trucks')]/parent::li")
	public WebElement vehicleCategoryasTrucks;
	
	@FindBy(xpath = "//span[contains(.,'Tires')]/parent::li")
	public WebElement vehicleCategoryasTires;
	
	
	@FindBy(xpath = "//span[contains(.,'Tipper')]/parent::li")
	public WebElement vehiclesubCategoryasTipper;
	
	@FindBy(xpath = "//span[contains(.,'Volvo')]/parent::li")
	public WebElement vehicleMakeasVolvo;
	
	@FindBy(xpath = "//span[contains(.,'Jcb')]/parent::li")
	public WebElement vehicleMakeasJCB;
	
	@FindBy(xpath = "//span[contains(.,'8700')]/parent::li")
	public WebElement vehicleModelas8700;
	
	@FindBy(xpath = "//span[contains(.,'Hydradig')]/parent::li")
	public WebElement vehicleModelasHydradig;
	
	@FindBy(xpath = "//span[contains(.,'110')]/parent::li")
	public WebElement vehicleVersionas110;
	
	@FindBy(xpath = "//span[contains(.,'Semi-new')]/parent::li")
	public WebElement conditionasSemiNew;
	
	@FindBy(xpath = "//span[contains(.,'12')]/parent::li")
	public WebElement makeMonthasDecember;
	
	@FindBy(xpath = "//label[contains(.,'Currency')]/parent::div/descendant::span[1]")
	public WebElement currencyFieldAutofillValue;
	
	@FindBy(xpath = "//label[contains(.,'Model')]/parent::div/child::div[contains(@class,'multiselect')]/descendant::span[1]")
	public WebElement modelFieldAutofillValue;
	
	@FindBy(xpath = "//label[contains(.,'Price')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement priceTypeFieldDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Currency')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement currencyTypeFieldDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Net')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement netPriceFieldDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Type')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement vehicleTypeDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Category')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement vehicleCategoryDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Subcategory')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement vehicleSubCategoryDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Make')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement vehicleMakeDangerText;
	
	@FindBy(xpath = "//label[contains(.,'Model')]/parent::div/child::div[contains(@class,'text-danger')]")
	public WebElement vehicleModelDangerText;
	
	@FindBy(xpath = "//h3[contains(.,'description')]/ancestor::div[contains(@class,'collapse-item')]//child::div[contains(@class,'text-danger')]")
	public WebElement vehicleDescriptionDangerText;
	
	@FindBy(xpath = "//span[contains(.,'negotiable')]/parent::div")
	public WebElement priceNegotialbleCheckBoxinPosting;
	
	@FindBy(xpath = "//span[contains(.,'Exchange')]/parent::div")
	public WebElement exchangePossibleCheckBoxinPosting;
	
	@FindBy(xpath = "//span[contains(.,'Rent')]/parent::div")
	public WebElement rentPossibleCheckBoxinPosting;
	
	@FindBy(xpath = "//span[contains(.,'CE Marking')]/parent::div")
	public WebElement ceMarkingCheckBoxinPosting;
	
	@FindBy(xpath = "//span[contains(.,'Leasing')]/parent::div")
	public WebElement leasePossibleCheckBoxinPosting;
	
	@FindBy(xpath = "//label[contains(.,'Category')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> categoryDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Subcategory')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> subCategoryDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Make')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> makeDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Model')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> modelDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Version')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> versionDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Month')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> constructionMonthDropdownvalues;
	
	@FindBy(xpath = "//label[contains(.,'Condition')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> conditionDropdownvalues;
	
	@FindBy(xpath = "//input[@name='modelText']")
	public WebElement modelFieldOtherTextBox;
	
	@FindBy(xpath = "//label[contains(.,'Fuel Type')]/parent::div/child::div[contains(@class,'multiselect')]")
	public WebElement fuelTypeinPosting;
	
	@FindBy(xpath = "//label[contains(.,'Engine Model')]/parent::div/descendant::input")
	public WebElement engineModelinPosting;
	
	@FindBy(xpath = "//label[contains(.,'Fuel Type')]/parent::div//ul[@class='multiselect__content']//li[@class='multiselect__element']")
	public List<WebElement> fuelTypeDropdownvalues;
	
	@FindBy(xpath = "//div[@class='flex flex-col px-4']//p")
	public WebElement makeModelVersioninPreviewpage;
	
	@FindBy(xpath = "//div[@class='flex flex-col px-4']//span[contains(@class,'cursor-not-allowed')]")
	public WebElement subCategoryinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Net price')]/parent::div//span")
	public WebElement netPriceinPreviewpage;
	
	@FindBy(xpath = "(//div[@class='w-2/5' and contains(.,'Year')]/parent::div//span)[1]")
	public WebElement yearinPreviewpage;
	
	@FindBy(xpath = "(//div[@class='w-2/5' and contains(.,'km')]/parent::div//span)[1]")
	public WebElement mileageinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Net Weight')]/parent::div//span")
	public WebElement netWeightinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Gross Weight')]/parent::div//span")
	public WebElement grossWeightinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Height')]/parent::div//span")
	public WebElement heightinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Width')]/parent::div//span")
	public WebElement widthinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Length')]/parent::div//span")
	public WebElement lengthinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Fits')]/parent::div//span")
	public WebElement fitsToFollowingMachinesinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Sellers')]/parent::div//span")
	public WebElement sellersRefinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Month')]/parent::div//span")
	public WebElement constructionMonthinPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Condition')]/parent::div//span")
	public WebElement conditioninPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'Hours')]/parent::div//span")
	public WebElement hoursRuninPreviewpage;
	
	@FindBy(xpath = "//div[@class='w-2/5' and contains(.,'VIN')]/parent::div//span")
	public WebElement vininPreviewpage;
	
	@FindBy(xpath = "//span[contains(.,'Description')]/parent::div//span[contains(@class,'text-black mb-4 pr-6')]//following-sibling::div")
	public WebElement descriptioninPreviewpage;	
	
	@FindBy(xpath = "//label[contains(.,'Price type')]/parent::div/descendant::span[1]")
	public WebElement priceTypeInPosting;
	
	@FindBy(xpath = "//label[contains(.,'Price type')]/parent::div/descendant::span[1]")
	public WebElement netPriceTypeInPosting;
	
	@FindBy(xpath = "//div[text()='X']/..")
	public WebElement cancleIconinPriviewPage;

	@FindBy(xpath = "//label[contains(.,'Net price')]")
	public WebElement netPriceLabelInPostingForm;

	@FindBy(xpath = "//div[@class='con-text-noti']//p")
	public WebElement errorToastInPostingForm;

	@FindBy(xpath = "//span[contains(.,'8500')]/parent::li")
	public WebElement vehicleModelas8500;

	@FindBy(xpath = "//div[@class='overflow-hidden rounded-b']//span[text()='Post your ad ']")
	public WebElement postYourAdButtonInPreviewPage;
	
	public CreateStockTradusProPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
