package smoke_test_TCOM;

import static com.tradus.core.ActionElementClass.click;
import static com.tradus.core.ActionElementClass.explicitWaitFortheElementTobeVisible;
import static com.tradus.core.ActionElementClass.getAttribute;
import static com.tradus.core.ActionElementClass.getText;
import static com.tradus.core.ActionElementClass.jsClick;
import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.scrollDown;
import static com.tradus.core.ActionElementClass.sendKeys;
import static com.tradus.core.ActionElementClass.switchWindow;
import static com.tradus.core.ActionElementClass.verifyElementPresent;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.ActionElementClass.waitForElement;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tradus.core.BaseClass;
import com.tradus.pages.AdDetailsTradusPage;

public class AdDetailsTradusTest extends BaseClass {
	
	String armyTruckNewURL="https://www.tradus.com/en/transport/trucks/army-truck/man/man-tgl-2005-7223617";
	String dionexNewURL="https://www.tradus.com/en/spare-parts/other-spare-parts-and-tools/tools/dionex/dionex-32-5837514";
	String caterpillarNewURL="https://www.tradus.com/en/spare-parts/cabins/caterpillar/caterpillar-m-7326462";
	String live_TestAd="https://www.tradus.com/en/spare-parts/buses/other-buses-spare-parts/fendt/fendt-5255-l-7508147";
	String dafSparePartsNewURL="https://www.tradus.com/en/material-handling/forklifts/linde/linde-p-30-c-1190-2015-7283906";
	String actros_Truck_URL="https://www.tradus.com/en/transport/trucks/flatbed-tarpaulin-trucks/mercedes-benz/mercedes-benz-actros-1224-2015-7520085";
	
	/*
	 * Description: Verify Selected categories along with make and title is displaying in breadcrumb
	 */
	@Test
	public void verifySelectedCatrgoriesAlongwithMakeandTitleisDisplayinginBreadcrumb() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
		loadUrl(driver,armyTruckNewURL);
		
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_MANAdDetails_xpath);
		waitTill(1000);
		int size=adDetailsObj.link_Breadcrumb_xpath.size();
		Assert.assertTrue(size==5,"All breadcrumb links are not displaying");
		String[] breadCurmbLinks= {"Home","Transport","Trucks","ArmyMilitaryTrucks","MAN"};
		for(int i=0;i<size;i++) {
			String temp=getText(adDetailsObj.link_Breadcrumb_xpath.get(i)).replaceAll("\\s","").replace("/", "").trim();
			Assert.assertTrue(temp.equals(breadCurmbLinks[i]), breadCurmbLinks[i] +"link isn't displaying in breadcrumb");
		}
	}
	
	/*
	 * Description: Verify cover image is displaying in Large and other images below it
	 */
	@Test
	public void verifyCoverImageisDisplayinginLargeAndOtherbelowToThat() throws Exception{
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		int numberOfImgs=(adDetailsObj.img_AdImageinDetaislPage_xpath).size();
		Assert.assertTrue(numberOfImgs==5, "Cover image and 4 other images aren't displaying in Ad details page");
		
		int coverImgHeight=adDetailsObj.img_AdImageinDetaislPage_xpath.get(0).getRect().height;
		int coverImgWidth=adDetailsObj.img_AdImageinDetaislPage_xpath.get(0).getRect().width;
		Assert.assertTrue(coverImgHeight==540 && coverImgWidth==720, "Large cover image isn't displaying in ADP");
		for(int i=1;i<5;i++) {
			int otherImgHeight=adDetailsObj.img_AdImageinDetaislPage_xpath.get(i).getRect().height;
			int otherImgWidth=adDetailsObj.img_AdImageinDetaislPage_xpath.get(i).getRect().width;
			Assert.assertTrue(otherImgHeight==124 && otherImgWidth==165, ""+i+" th image below cover image isn't displaying properly in ADP");
		}
	}
	/*
	 * Description: Verify the images count is displaying for the last image in below cover image if exists
	 */
	@Test
	public void verifyImagecountDisplayingontheLastImage() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.count_onLastImg_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.count_onLastImg_xpath), "Ad count isn't present on Last image in ADP");
		String count=getText(adDetailsObj.count_onLastImg_xpath).replace("\n", ",").trim();
		//System.out.println(count);
		Assert.assertTrue(count.replace(",images", "").equals("+ 3"), "Ad count isn't correct on last image of ADP");
		
	}
	/*
	 * Description: Verify default image should not zoom if particular ad is not having any ad images
	 */
	//@Test
	public void verifyDefaultImageandUnabletoZoomIn() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,dafSparePartsNewURL);
			
		
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		
		String src=getAttribute(adDetailsObj.img_defaultImageinDetaislPage_xpath,"src");
		//System.out.println(src);
		Assert.assertTrue(src.trim().contains("https://www.tradus.com/assets/tradus/offer-result/material-handling.svg"), "Default image isn't displaying in ADP");
		
		try {
			click(adDetailsObj.img_defaultImageinDetaislPage_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_defaultImageinDetaislPage_xpath);
		}
		waitTill(2000);
		//System.out.println(getAttribute(adDetailsObj.div_CoverImgSectioninDetaislPage_xpath,"class").trim());
		Assert.assertTrue(getAttribute(adDetailsObj.div_CoverImgSectioninDetaislPage_xpath,"class").trim().equals("pswp"), "Default image is zooming in ADP");
	}
	/*
	 * Description: Verify count of images, left and righ arrows, enlarge, zoom and close icons in image view 
	 */
	@Test
	public void verifyAttributesinImageExtendedView() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.img_CoverImgOfMANTGL_xpath), "Cover image might have changed for MAN TLG");
		try {
			click(adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}
		waitTill(5000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_ImageCountforImgViewPage_xpath), "Image counter isn't present in extedned image view page");
		Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals("1 / 9"), "Correct image counter isn't present in extedned image view page");
		//Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ZoomInandOutForImgViewPage_xpath), "Zoom option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_fullScreenInImgViewPage_xpath), "Full screen option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CloseButtononImgViewPage_xpath), "Cancle option isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_LeftArrowForImgViewPage_xpath), "Left arrow isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_RightArrowForImgViewPage_xpath), "Right arrow isn't present in extedned image view page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ReportBtnImgViewPage_xpath), "Report button isn't present in extedned image view page");
	}
	
	/*
	 * Descritpion: Verify the Contact seller and Show the phone numbers buttons are displaying in the last image in enlarge view and verify action without login
	 */
	@Test
	public void ContactSellerAndShowPhonenumberFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,caterpillarNewURL);
			
		if(!verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			try {
				click(adDetailsObj.div_userMenu_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.div_userMenu_xpath);
			}
			try {
				click(adDetailsObj.link_SignOut_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.link_SignOut_xpath);
			}
			waitForElement(adDetailsObj.link_loginTradus_xpath);
			loadUrl(driver,caterpillarNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfCaterpillarM322_xpath);
		try {
			click(adDetailsObj.img_CoverImgOfCaterpillarM322_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfCaterpillarM322_xpath);
		}
		
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		for(int i=0;i<1;i++) {
			int j=i+1;
			Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals(""+j+" / 2"), "Correct image counter isn't present in extedned image view page "+i+j+"");
			try {
				click(adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}
			waitTill(2000);
			if(i==0) {
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ContactSellerinImgViewPage_xpath), "Contact seller button isn't present in last image of  extedned image view page");
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CallBtninImgViewPage_xpath), "Call button isn't present in last image of  extedned image view page");
				try {
					click(adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath),"Login page isn't displaying when contact seller link is clicked before login");
			    waitTill(1000);
			    driver.navigate().back();
			    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_CallBtninImgViewPage_xpath);
			    try {
					click(adDetailsObj.btn_CallBtninImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_CallBtninImgViewPage_xpath);
				}
			    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath),"Login page isn't displaying when call link is clicked in image zoom view page before login");
			}
		}
	}
	/*
	 * Description: Verify the Contact seller and Show the phone numbers buttons are displaying in the last image in enlarge view and verify action with login
	 */
	@Test
	public void ContactSellerAndShowPhonenumberFunctionalitywithLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		if(verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
			sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
			sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
			jsClick(driver,adDetailsObj.tradusLoginButton);
			waitTill(3000);
			loadUrl(driver,armyTruckNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		try {
			click(adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.img_CoverImgOfMANTGL_xpath);
		}
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.btn_fullScreenInImgViewPage_xpath);
		for(int i=0;i<8;i++) {
			int j=i+1;
			Assert.assertTrue(getText(adDetailsObj.div_ImageCountforImgViewPage_xpath).trim().equals(""+j+" / 9"), "Correct image counter isn't present in extedned image view page "+j+"/9");
			try {
				click(adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.btn_RightArrowForImgViewPage_xpath);
			}
			waitTill(2000);
			if(i==7) {
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_ContactSellerinImgViewPage_xpath), "Contact seller button isn't present in last image of  extedned image view page");
				Assert.assertTrue(verifyElementPresent(adDetailsObj.btn_CallBtninImgViewPage_xpath), "Call button isn't present in last image of  extedned image view page");
				try {
					click(adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_ContactSellerinImgViewPage_xpath);
				}
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
				Assert.assertTrue(verifyElementPresent(adDetailsObj.div_sellerContactFormVerify_xpath),"Contact form isn't displaying when contact seller link is clicked after login");
				try {
					click(adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
				}
				/*waitTill(2000);
				try {
					click(adDetailsObj.btn_CallOptioninImgViewPage_xpath);
				}catch(Exception E) {
					jsClick(driver,adDetailsObj.btn_CallOptioninImgViewPage_xpath);
				}
				waitTill(1000);
				explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_ContactSellerforCallTextInExtendedView_xpath);
				Assert.assertTrue(getText(adDetailsObj.div_UnhidePhoneNumberInExtednedImgPage_xpath).trim().equals("+918867853090"),"Correct phonenumber isn't visible on clicking the call button");*/
			}
		}
	}
	/*
	 * Description: Verify email, call and call back buttton navigation before login
	 */
	@Test
	public void verifyEmailCallBackAndCallButtonNavigationsBeforeLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		if(!verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			try {
				click(adDetailsObj.div_userMenu_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.div_userMenu_xpath);
			}
			try {
				click(adDetailsObj.link_SignOut_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.link_SignOut_xpath);
			}
			waitForElement(adDetailsObj.link_loginTradus_xpath);
			loadUrl(driver,armyTruckNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		WebElement[] ele= {adDetailsObj.link_emailUnderContactSeller_xpath,adDetailsObj.link_callBackUnderContactSeller_xpath,adDetailsObj.link_callButtonUnderContactSeller_xpath};
	    for(int i=0;i<ele.length;i++) {
	    	try {
	    		click(ele[i]);
	    	}catch(Exception E) {
	    		jsClick(driver,ele[i]);
	    	}
	    	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
	    	Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking "+i+" th link from contact section");
	        waitTill(1000);
	        driver.navigate().back();
	        explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
	    }
	}
	
	/*
	 * Description: Verify email, call and call back buttton navigation after login
	 */
	@Test
	public void verifyEmailCallBackAndCallButtonNavigationsAfterLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		if(verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
			sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
			sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
			jsClick(driver,adDetailsObj.tradusLoginButton);
			waitTill(3000);
			loadUrl(driver,armyTruckNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		
		try {
			click(adDetailsObj.link_emailUnderContactSeller_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_emailUnderContactSeller_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_sellerContactFormVerify_xpath),"Contact form isn't displaying on clicking the link");
		try {
			click(adDetailsObj.div_sendButtonInContactForm_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_sendButtonInContactForm_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.text_leadFormSubmitSuccessinTradus_xpath);
		try {
			click(adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.btn_closeIconInContactSuccessModel_xpath);
		}
		waitTill(2000);
		
		try {
			click(adDetailsObj.link_callBackUnderContactSeller_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_callBackUnderContactSeller_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_sendButtonInCallBackForm_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callBackFormVerify_xpath),"Call back form isn't displaying on clicking the link");
		try {
			click(adDetailsObj.link_sendButtonInCallBackForm_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_sendButtonInCallBackForm_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.text_leadFormSubmitSuccessinTradus_xpath);
		try {
			click(adDetailsObj.btn_closeIconInCallBackSuccessModel_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.btn_closeIconInCallBackSuccessModel_xpath);
		}
		
		waitTill(2000);
		try {
			click(adDetailsObj.link_callOptionInContactSection_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_callOptionInContactSection_xpath);
		}
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_ContactSellerforCallText_xpath);
		Assert.assertTrue(getText(adDetailsObj.div_UnhidePhoneNumber_xpath).trim().equals("+918867853090"),"Correct phonenumber isn't visible on clicking the call button");
	}
	/*
	 * Description: Verify Ad title along with other attributes are displaying
	 */
	@Test
	public void verifyAdTitlewithOtherAttribute() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,actros_Truck_URL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		Assert.assertTrue(getText(adDetailsObj.title_AdDetails_xpath).trim().equals("Mercedes-Benz Actros 1224 - 2015"),"Ad title isn't displaying correctly in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.link_headerCategory_xpath).equals("Tractor units"),"L3 categories isn't displaying correctly in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.time_AdPostingTime_xpath),"Posting time isn't present in Ad details page");
		//System.out.println(getText(adDetailsObj.netPriceInOfferHeader_xpath));
		Assert.assertTrue(getText(adDetailsObj.netPriceInOfferHeader_xpath).equals("€56 000"),"Net price isn't correct in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.priceRatngInOfferHeader_xpath).replace("\n", ",").trim().equals("HIGH PRICE,Tradus Market Value €34 531"),"Price rating stats aren't correct in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.div_steerSideInOfferHeader_xpath).trim().equals("Left hand"),"Steering side data isn't displaying correctly in Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.div_yearOfManufacturingInOfferHeader_xpath).trim().equals("2015"),"Manufacturing year isn't displaying correctly in Ad details page");
		//Assert.assertTrue(getText(adDetailsObj.div_hoursRunInOfferHeader_xpath).trim().equals("56,000 h"),"Hours run data isn't displaying correctly in Ad details page");
		Assert.assertTrue(getText(adDetailsObj.div_mileageInOfferHeader_xpath).trim().equals("105,000 km"),"Mileage isn't displaying correctly in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_emailUnderContactSeller_xpath),"Email button under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callBackUnderContactSeller_xpath),"Call back under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_callButtonUnderContactSeller_xpath),"Call button under Contact us section isn't present in Ad details page");
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_emailforSimilarAlert_xpath),"Email for similar offer link under Contact us section isn't present in Ad details page");
		//System.out.println(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim());
		if(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim().equals("Harry,Bangalore, Netherlands,Registered on Tradus less than a year ago,View all ads (0)")) {
		Assert.assertTrue(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim().equals("Harry,Bangalore, Netherlands,Registered on Tradus less than a year ago,View all ads (0)"),"Dealer info section content might have changes in Ad details page");
		}
		else {
			Assert.assertTrue(getText(adDetailsObj.div_dealerInfo_xpath).replace("\n",",").trim().equals("Harry,Typically responds via email within 1 day.,Bangalore, Netherlands,Registered on Tradus less than a year ago,View all ads (0)"),"Dealer info section content might have changes in Ad details page");
		}
		Assert.assertTrue(verifyElementPresent(adDetailsObj.div_dealerInfo_xpath),"Map section isn't present in Ad details page");
	   
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.div_TMVsection_xpath),"TMV section isn't present in Ad details page");
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.link_aboutTMV_xpath),"About TMV info button isn't present in Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.div_TMVNetPrice_xpath).trim().equals("€56 000"),"Net price value isn't correct under TMV section of Ad details page");
	    Assert.assertTrue(getText(adDetailsObj.div_TMVPrice_xpath).trim().equals("€34 531"),"TMV value isn't correct under TMV section of in Ad details page");
	}
	/*
	 * Descritpion: Send me email alerts for similar offers with login
	 */
	@Test
	public void verifySendSimilarAlertlinkFunctionlityWithLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		if(verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			loadUrl(driver,"https://www.tradus.com/account/login#tab-login");
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tradusUidInLoginPage);
			sendKeys(adDetailsObj.tradusUidInLoginPage,"harish.boyapati+1300@olx.com");
			sendKeys(adDetailsObj.tradusPWDInLoginPage,"sunfra123");
			jsClick(driver,adDetailsObj.tradusLoginButton);
			waitTill(3000);
			loadUrl(driver,armyTruckNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		waitTill(2000);
		if(getText(adDetailsObj.link_SendAlertForSimilarOffer_xpath).trim().equals("Remove alerts for similar offers")) {
			try {
				click(adDetailsObj.link_SendAlertForSimilarOffer_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
			}
			waitTill(2000);
			loadUrl(driver,armyTruckNewURL);
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
			waitTill(1000);
		}
		try {
			click(adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}
		waitTill(2000);
		Assert.assertTrue(getText(adDetailsObj.link_SendAlertForSimilarOffer_xpath).trim().equals("Remove alerts for similar offers"), "Send alert text isn't changed after clicking the link");
		 try {
	        	click(adDetailsObj.div_userMenu_xpath);
	        }catch(Exception e) {
	        	jsClick(driver,adDetailsObj.div_userMenu_xpath);
	        }
			waitTill(2000);
			try {
	        	click(adDetailsObj.div_myAlertsLinkunderUserMenu_xpath);
	        }catch(Exception e) {
	        	jsClick(driver,adDetailsObj.div_myAlertsLinkunderUserMenu_xpath);
	        }
			explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_MyAlertsTab_xpath);
			waitTill(2000);
			SoftAssert softAssertion=new SoftAssert();
			softAssertion.assertTrue(verifyElementPresent(adDetailsObj.div_AdVerifyinAlertListing_xpath), "Respective Ad isn't present under Alert listing");
		    waitForElement(adDetailsObj.link_deleteForMANinAlertList_xpath);
		    if(verifyElementPresent(adDetailsObj.link_deleteForMANinAlertList_xpath)) {
		    	try {
		        	click(adDetailsObj.link_deleteForMANinAlertList_xpath);
		        }catch(Exception e) {
		        	jsClick(driver,adDetailsObj.link_deleteForMANinAlertList_xpath);
		        }
		    }
		    else {
		    	softAssertion.assertTrue(verifyElementPresent(adDetailsObj.link_deleteForMANinAlertList_xpath),"Delete button locater for Man | Army / Military Trucks saved alert isn't found ");
		    	try {
		        	click(adDetailsObj.link_DeleteAlerts_xpath.get(0));
		        }catch(Exception e) {
		        	jsClick(driver,adDetailsObj.link_DeleteAlerts_xpath.get(0));
		        }
		    }
			 waitTill(2000);
			 softAssertion.assertAll();
	}
	
	/*
	 * Description: Send me email alerts for similar offers without login
	 */
	@Test
	public void verifySendSimilarAlertlinkFunctionlityWithoutLogin() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		if(!verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
			try {
				click(adDetailsObj.div_userMenu_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.div_userMenu_xpath);
			}
			try {
				click(adDetailsObj.link_SignOut_xpath);
			}catch(Exception E) {
				jsClick(driver,adDetailsObj.link_SignOut_xpath);
			}
			waitForElement(adDetailsObj.link_loginTradus_xpath);
			loadUrl(driver,armyTruckNewURL);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		try {
			click(adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_SendAlertForSimilarOffer_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking receive alert link in ADP without login");
	}
	/*
	 * Descritpion: Verify the login page is displaying without login on clicking the offers button
	 */
	@Test
	public void verifyLoginPageisDisplayingwithoutLoginonClickingtheOffers() throws Exception {
	AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
	
		loadUrl(driver,dionexNewURL);
		
	if(!verifyElementPresent(adDetailsObj.link_loginTradus_xpath)) {
		try {
			click(adDetailsObj.div_userMenu_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_userMenu_xpath);
		}
		try {
			click(adDetailsObj.link_SignOut_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_SignOut_xpath);
		}
		waitForElement(adDetailsObj.link_loginTradus_xpath);
		loadUrl(driver,dionexNewURL);
	}
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
	waitTill(1000);
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_FavoriteIcon_xpath);
	try {
		click(adDetailsObj.link_FavoriteIcon_xpath);
	}catch(Exception E) {
		jsClick(driver,adDetailsObj.link_FavoriteIcon_xpath);
	}
	explicitWaitFortheElementTobeVisible(driver,adDetailsObj.tab_LoginPageVerify_xpath);
	Assert.assertTrue(verifyElementPresent(adDetailsObj.tab_LoginPageVerify_xpath), "Login page isn't displaying on clicking favorite button in ADP without login");
	}
	/*
	 * Description: Verify price rating lable and redirecting to price rating info on clicking the link
	 */
	@Test
	public void verifyPriceRatinglaleandredirectingTothatSectiononClickingtheLink() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,actros_Truck_URL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		try {
			click(adDetailsObj.link_TMVlinkInHeader_xpath);
		}catch (Exception E) {
			jsClick(driver,adDetailsObj.link_TMVlinkInHeader_xpath);
		}
		//waitTill(5000);
		//System.out.println(adDetailsObj.header_TMVvaluationHeader_xpath.getLocation().getY());
		//System.out.println(adDetailsObj.header_DescritpionvHeader_xpath.getLocation().getY());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitTill(3000);
		Long value=(Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(adDetailsObj.header_TMVvaluationHeader_xpath.getLocation().getY()-200<=value && value<=adDetailsObj.header_DescritpionvHeader_xpath.getLocation().getY()+100 , "Page is not scrolling to proper section on clicking TMV link");
	}
	/*
	 * Description: Verify sellers logo and their name is displaying
	 */
	@Test
	public void verifySellersLogoAndtheirName() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		//System.out.println(getAttribute(adDetailsObj.img_DealerLogo_xpath,"src"));
		Assert.assertTrue(getAttribute(adDetailsObj.img_DealerLogo_xpath,"src").equals("https://images.tradus.com/v1/7a1efbe4-2f24-44e4-9b1e-abb073d4a434.jpg"),"Correct dealer logo isn't displaying in ADP");
		//System.out.println(getText(adDetailsObj.img_DealerName_xpath).trim());
		Assert.assertTrue(getText(adDetailsObj.img_DealerName_xpath).trim().equals("Harry"), "Correct dealer name isn't displaying in Ad details page");
	}
	
	/*
	 * Description: Verify View all ads link is displaying and respective ads of particular user are displaying on clicking the 'View all ads' link
	 */
	@Test
	public void verifyViewAllAdslinkpresenceandFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,live_TestAd);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_ViewAllAds_xpath);
		Assert.assertTrue(verifyElementPresent(adDetailsObj.link_ViewAllAds_xpath), "View all Ads link isn't present in Delaer All Ads page");
	    try {
	    	click(adDetailsObj.link_ViewAllAds_xpath);
	    }catch(Exception E) {
	    	jsClick(driver,adDetailsObj.link_ViewAllAds_xpath);
	    }
	    explicitWaitFortheElementTobeVisible(driver,adDetailsObj.span_DealerNameinAllAdspage_xpath);
	    Assert.assertTrue(verifyElementPresent(adDetailsObj.AdCountinDealerAllAds_xpath), "Results for TRADUS B.V. isn't displaying in Dealer all Ads listing page");
	    Assert.assertTrue(Integer.parseInt((getText(adDetailsObj.AdCountinDealerAllAds_xpath).replace("results for TRADUS B.V.", "").trim()))>0, "Ad count is appered as zero/incorrect in Dealer all Ads page");
	}
	/*
	 * Description: Verify ads are displaying below Frequently viewed by other customers 
	 */
	@Test
	public void verifyAdsareDisplayingbelowFrequentlyViewedbyOtherCustomers() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.section_frequentlyViewedAds_xpath);
		int size=adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.size();
		Assert.assertTrue(size>0,"Ads aren't displaying under frequently searched section in offer details page");
	   /* try {
	    	click(adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_rightGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    if(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(5),"class").equals("offer-card glide__slide--active")) {
	    Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(5),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	    }
	    else {
	    	Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(6),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");
	    }
	    try {
	    	click(adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }catch (Exception E) {
	    	jsClick(driver,adDetailsObj.link_leftGlideArrowinFrequentlyViewedAds_xpath);
	    }
	    waitTill(1000);
	    Assert.assertTrue(getAttribute(adDetailsObj.adTilesUnderFrequentlyViewedAds_xpath.get(0),"class").equals("offer-card glide__slide--active"), "Listing under frequently viewed section isn't scrolled on clikcing right arrow head");*/
	    }
	
	/*
	 * Description: Verify Back to top link along with upward arrow is displaying
	 */
	@Test
	public void verfyBackToTopLinkanditsFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
		
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		scrollDown(driver);
		waitTill(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		waitTill(3000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_BackToTop_xpath);
		try {
			click(adDetailsObj.link_BackToTop_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_BackToTop_xpath);
		}
		waitTill(3000);
		Long value=(Long) executor.executeScript("return window.pageYOffset;");
		Assert.assertTrue(value<100, "Page isn't moving to top of the page when clicked on the Back to top link");
	}
	/*
	 * Description: Verify page is redirecting to categories page on clicking 'See all categories' link
	 */
	@Test
	public void verifySeeAllCategroyLinkandVerifyItsNavigations() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		
			loadUrl(driver,armyTruckNewURL);
			
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		try {
			click(adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_seeAllCategoriesInBottom_xpath);
		}
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.div_categoryPageVerify_xpath);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.tradus.com/en/categories"), "Page isn't naviagted to all categories page on clicking the see all category link");
	}
	/*
	 * Description: Price units are changing on changing currency type
	 */
	@Test
	public void priceUnitsAreChangeingAsPerCurrencyType() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,actros_Truck_URL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(1000);
		SoftAssert softAssertion=new SoftAssert();
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.dropdown_currency_xpath);
		String[] units= {"€","$","CHF","DKK","£","HUF","PLN","RON","RUB","SEK","TRY","UAH","ZAR"};
		Select s=new Select(adDetailsObj.dropdown_currency_xpath);
		List<WebElement> currencyOps=s.getOptions();
		for(int i=0;i<currencyOps.size();i++) {
			s.selectByIndex(i);
			waitTill(2000);
			String netPrice=getText(adDetailsObj.netPriceInOfferHeader_xpath);
			softAssertion.assertTrue(netPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for Net price in header");
			softAssertion.assertTrue((Integer.parseInt(netPrice.replaceAll("[^0-9]","").trim()))>0, "TMV net Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String tmvNetPrice=getText(adDetailsObj.div_TMVNetPrice_xpath);
			softAssertion.assertTrue(tmvNetPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for TMV net price in header");
			softAssertion.assertTrue(Integer.parseInt(tmvNetPrice.replaceAll("[^0-9]","").trim())>0, "TMV net Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String tmvPrice=getText(adDetailsObj.div_TMVPrice_xpath);
			softAssertion.assertTrue(tmvPrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value for TMV price");
			softAssertion.assertTrue(Integer.parseInt(tmvPrice.replaceAll("[^0-9]","").trim())>0, "TMV Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String priceInTMVPara=getText(adDetailsObj.span_AdPriceInTMVDescription_xpath);
			softAssertion.assertTrue(priceInTMVPara.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of price in TMV section");
			softAssertion.assertTrue(Integer.parseInt(priceInTMVPara.replaceAll("[^0-9]","").trim())>0, "Price in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String TMVPriceInDescription=getText(adDetailsObj.span_TMVPriceInTMVDescription_xpath);
			softAssertion.assertTrue(TMVPriceInDescription.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of TMV price in TMV section");
			softAssertion.assertTrue(Integer.parseInt(TMVPriceInDescription.replaceAll("[^0-9]","").trim())>0, "TMVPrice in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
			
			String estimatePrice=getText(adDetailsObj.span_TMVEsitamtedPriceDifference_xpath);
			softAssertion.assertTrue(estimatePrice.contains(units[i]), "Unit isn't correct for the "+i+"th dropdown value of esitmate price in TMV section");
			softAssertion.assertTrue(Integer.parseInt(estimatePrice.replaceAll("[^0-9]","").trim())>0, "Estamate price in TMV section Price is displaying as zero for "+i+"th dropdown value from currency type");
		}
		s.selectByValue("EUR");
		waitTill(1000);
		softAssertion.assertAll();
	}
	/*
	 * Descritpion: Verify TMV slider is displaying correctly
	 * 
	 * The x co-ordinate values are values of starting point
	 */
	@Test
	public void verifyTMVsiderisPointingCorrectly() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,actros_Truck_URL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		int netPrice=Integer.parseInt(getText(adDetailsObj.div_TMVNetPrice_xpath).replaceAll("[^0-9]", "").trim());
		int TMVPrice=Integer.parseInt(getText(adDetailsObj.div_TMVPrice_xpath).replaceAll("[^0-9]", "").trim());
		//System.out.println(netPrice);
		//System.out.println(TMVPrice);
        int location=adDetailsObj.div_TMVPricePointer_xpath.getLocation().x;
		
		int verylowPriceSection=adDetailsObj.div_VeryLowPriceSectionInTMV_xpath.getLocation().x;
		int lowPriceSection=adDetailsObj.div_LowPriceSectionInTMV_xpath.getLocation().x;
		int averagePriceSection=adDetailsObj.div_AveragePriceSectionInTMV_xpath.getLocation().x;
		int highPriceSection=adDetailsObj.div_HighPriceSectionInTMV_xpath.getLocation().x;
		int veryHighPriceSection=adDetailsObj.div_VeryHighPriceSectionInTMV_xpath.getLocation().x;
		
		//System.out.println(location);
		
		if(netPrice>TMVPrice) {
			Assert.assertTrue(location>=highPriceSection && location<=1055, "TMV slider isn't placed properly for Higher price Ads");
		}
		else if(netPrice<TMVPrice) {
			Assert.assertTrue(location<averagePriceSection && location>=verylowPriceSection, "TMV slider isn't placed properly for lower price Ads");
		}
		else {
			Assert.assertTrue(location>=averagePriceSection && location<highPriceSection, "TMV slider isn't placed properly for average price Ads");
		}
	}
	
	/*
	 * Description: Verify Print button and its functionality
	 */
	@Test
	public void verifyPrintButtonAndItsFunctionality() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.span_PrintBtn_xpath);
		String parentWindow=driver.getWindowHandle();
		try {
			click(adDetailsObj.span_PrintBtn_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.span_PrintBtn_xpath);
		}
		waitTill(2000);
		switchWindow(driver,parentWindow);
		SoftAssert softAssertion= new SoftAssert();
		
		waitForElement(adDetailsObj.span_PrintPageVerify_xpath);
		softAssertion.assertTrue(verifyElementPresent(adDetailsObj.div_AdHeaderInPrintPage_xpath),"Print page isn't displaying on clicking print button");
		driver.close();
		driver.switchTo().window(parentWindow);
		softAssertion.assertAll();
		
	}
	
	/*
	 * Descritpion: Report abuse overlay navigation
	 */
	@Test
	public void reportAbuseNavigation() throws Exception {
		AdDetailsTradusPage adDetailsObj=new AdDetailsTradusPage(driver);
		loadUrl(driver,armyTruckNewURL);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.title_AdDetailsVerify_xpath);
		waitTill(2000);
		explicitWaitFortheElementTobeVisible(driver,adDetailsObj.link_reportAbuse_xpath);
		try {
			click(adDetailsObj.link_reportAbuse_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.link_reportAbuse_xpath);
		}
		SoftAssert softAssertion= new SoftAssert();
		waitForElement(adDetailsObj.btn_reportAbuseSubmit_xpath);
		softAssertion.assertTrue(verifyElementPresent(adDetailsObj.header_reportAbuseWrapper_xpath),"Report abuse form isn't displaying on clicking report link");
		try {
			click(adDetailsObj.div_CloseIconInReportAbuseScreen_xpath);
		}catch(Exception E) {
			jsClick(driver,adDetailsObj.div_CloseIconInReportAbuseScreen_xpath);
		}
		softAssertion.assertAll();
	}
}
