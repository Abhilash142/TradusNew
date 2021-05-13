package com.tradus.pro.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;

public class MarketinSightsTradusProPage {
    public RemoteWebDriver driver= null;
	
	@FindBy(xpath = "//h2[contains(text(),'Most Popular Vehicles')]")
	public WebElement marketInsightHeaderText;
	
	//given xpaths like to ensure element is preset below 'Most ppular vehicle header'
	@FindBy(xpath = "//h2[contains(text(),'Popular')]/parent::header/following-sibling::div[1]//span[text()='Category']")
	public WebElement marketinSightCateorylabel;
	
	@FindBy(xpath = "//h2[contains(text(),'Popular')]/parent::header/following-sibling::div[1]//span[text()='Sub Category']")
	public WebElement marketinSightsubCateorylabel;
	
	@FindBy(xpath = "//span[text()='Category']/parent::div//select")
	public WebElement marketinSightsCategorySelectionBox;
	
	@FindBy(xpath = "//span[text()='Sub Category']/parent::div//select")
	public WebElement marketinSightssubCategorySelectionBox;
	
	@FindBy(xpath = "((//div[@class='vx-row']//section)[2]//div)[1]")
	public WebElement marketinSightSearchResultArea;
	
	@FindBy(xpath = "//div[@class='flex ml-4 py-4']")
	public WebElement marketinSightCnfNoResultsVerificationElement;
	
	@FindBy(xpath = "(//div[@class='p-3 bg-white rounded-lg mb-2'])[1]")
	public WebElement marketinSightCnfResultsVerificationElement;
	
	@FindBy(xpath = "//div[@class='p-3 bg-white rounded-lg mb-2']")
	public List<WebElement> marketinSightfilterResultscount;
	
	@FindBy(xpath = "//div[@class='vx-row']//span[contains(@class,'text-xl')]")
	public List<WebElement> marketinSightResultsMakeandModelNames;
	
	@FindBy(xpath = "//div[@class='vx-row']//div[contains(@class,'text-grey-dark')]")
	public List<WebElement> marketinSightLeadsCount;
	
	@FindBy(xpath = "//div[@class='vx-row']//span[contains(text(),'last week')]/preceding-sibling::span")
	public List<WebElement> marketinSightLeadsStatsLastWeek;
	
	@FindBy(xpath = "//div[@class='vx-row']//span[contains(text(),'last month')]/preceding-sibling::span")
	public List<WebElement> marketinSightLeadsStatsLastMonth;
	
	/*@FindBy(xpath = "//option[contains(.,'Processing Equipment')]")
	public WebElement marketinSightCategoryDropdownVerificationElement;*/
	
	@FindBy(xpath = "//option[contains(.,'Material Handling Equipment')]")
	public WebElement marketinSightCategoryDropdownVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,'Utility Service')]")
	public WebElement transportsubCategoryVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,'Agri')]")
	public WebElement farmsubCategoryVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,'Concrete Equipment')]")
	public WebElement constructionsubCategoryVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,'Other Spare Parts & Tools')]")
	public WebElement sparePatrssubCategoryVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,'Container Handler')]")
	public WebElement MHEsubCategoryVerificationElement;
	
	@FindBy(xpath = "//option[contains(.,' Waste Management')]")
	public WebElement PEMTsubCategoryVerificationElement;
	
	@FindBy(xpath = "//div[@class='flex items-center justify-center']//*[local-name() = 'svg']")
	public List<WebElement> logoinDisplayedTopLeads;
	
	@FindBy(xpath = "//h2[contains(text(),'Most Popular Vehicles')]")
	public WebElement marketInsightpageVerificationElement;
		
	public MarketinSightsTradusProPage(RemoteWebDriver driver) throws Exception
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {
			loadUrl(driver,"https://pro.tradus.com/lms/market-insights");
		} catch (Exception e) {
			e.printStackTrace();
		}
		waitTill(1000);
	}
	
	public void doLogIn(String UserName, String Password) throws Exception {
		 CommonMethod cmdObj=new  CommonMethod(driver);
		 if(!verifyElementPresent(cmdObj.LoginPageVerify)) {
			 cmdObj.logOut();
			 explicitWaitFortheElementTobeVisible(driver,cmdObj.LoginPageVerify);
		 }
		 cmdObj.login(UserName,Password);
		 explicitWaitFortheElementTobeVisible(driver,cmdObj.profileIconOnHeader);
		 loadUrl(driver,"https://pro.tradus.com/lms/market-insights");
	}

}
