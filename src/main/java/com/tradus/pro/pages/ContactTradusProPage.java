package com.tradus.pro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactTradusProPage {
public RemoteWebDriver driver= null;
	
	@FindBy(xpath= "//span[@class='flex items-center w-full']//span[text()='Contact']")
	public WebElement ContactLink;
	
	@FindBy(xpath= "//div[@class='vs-sidebar--item']//span[text()='Terms of Use']")
	public WebElement TermsOfUseLinkOnSideBar;
	
	@FindBy(xpath= "//div[@class='vs-sidebar--item']//span[text()='Privacy Policy']")
	public WebElement PrivacyPolicyLinkOnSideBar;
	
	@FindBy(xpath= "//div[@class='vs-sidebar--item']//span[text()='Contact']")
	public WebElement ContactLinkOnSideBar;
	
	@FindBy(xpath= "//h1[text()= ' Terms of Use']")
	public WebElement TermsOfUseHelpPageHeading;
	
	@FindBy(xpath= "//h1[text()='How can we help you?']")
	public WebElement PrivacyPolicyHelpPageHeading;
	
	@FindBy(xpath= "//h1[text()='Help us help you faster!']")
	public WebElement contactHelpPageHeading;
	
	public ContactTradusProPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
