package com.tradus.pro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateLeads {
	
	public class ForgotPasswordPage {
		public RemoteWebDriver driver= null;
		
		@FindBy(xpath = "//input[@id='username']")
		public WebElement emailidInLoginPage;
		
		@FindBy(xpath = "//input[@id='password']")
		public WebElement passwordInLoginPage;
		
		@FindBy(xpath = "//p[contains(text(),'enter your email')]")
		public WebElement forgotPasswordInfoText;
		
		
		public ForgotPasswordPage(RemoteWebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

}
}
}