package com.tradus.core;

import static com.tradus.core.ActionElementClass.loadUrl;
import static com.tradus.core.ActionElementClass.waitTill;
import static com.tradus.core.GlobalConstants.osName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public RemoteWebDriver driver = null;

	@BeforeClass
	public void setUp() throws Exception {
		//launchChromeBrowser();
		launchRemoteWebDriver();
	}

	/*public void launchChromeBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		String site = System.getProperty("site");
		if(site==null)
			site="tpro";
		if(site.equalsIgnoreCase("tcom"))
			loadUrl(driver,"https://www.tradus.com");
		else
			loadUrl(driver,"https://pro.tradus.com");
	}
	public void launchRemoteWebDriver()throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		//URL url = new URL("http://192.168.99.100:4444/wd/hub");
		driver = new RemoteWebDriver(url, capabilities);
		driver.setFileDetector(new LocalFileDetector());
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		String site = System.getProperty("site");
		if(site==null)
			site="tpro";
		if(site.equalsIgnoreCase("tcom"))
			loadUrl(driver,"https://www.tradus.com");
		else
			loadUrl(driver, "https://pro.tradus.com");
	}
	
	@AfterClass
	public void afterMethod() throws Exception {
		driver.quit();
	}*/

public void launchRemoteWebDriver_new() throws Exception{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
	//	webDriver = new RemoteWebDriver(new URL("http://myip:5555/wd/hub"), caps);
	}
public void launchRemoteWebDriver()throws Exception {
	driver = getDesiredCapabilities();
	//DriverFactory.getInstance().setDriver(driver);
   //driver = DriverFactory.getInstance().getDriver();
	driver.setFileDetector(new LocalFileDetector());
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	String site = System.getProperty("site");
	if(site==null)
		site="tpro";
	if(site.equalsIgnoreCase("TCOM")) {
		loadUrl(driver,"https://www.tradus.com/en/");
	    waitTill(1000);
	}
	else if(site.equalsIgnoreCase("OTMPLMS")) {
	    loadUrl(driver,"https://pro.otomotoprofi.pl/signup");
	    waitTill(1000);
	    }
	else {
		loadUrl(driver, "https://pro.tradus.com");
	    waitTill(1000);
	}
}
public RemoteWebDriver getDesiredCapabilities(){
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	ChromeOptions options = new ChromeOptions();
	options.setPageLoadStrategy(PageLoadStrategy.NORMAL); 
    options.addArguments("--disable-dev-shm-usage"); 
    options.addArguments("--disable-browser-side-navigation"); 
    options.addArguments("--disable-gpu");
	options.setExperimentalOption("useAutomationExtension", false);
	options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
	String temp=null;
	if(osName.equalsIgnoreCase("Windows"))
		temp = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	else
		temp = "/usr/bin/google-chrome";
	options.setBinary(temp);
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	URL url = null;
	try {
		url = new URL("http://localhost:4444/wd/hub");
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	driver = new RemoteWebDriver(url, capabilities);
	return driver;
}
	

	@AfterClass
	public void teardown() throws Exception {
		/*if(driver!=null)
			driver.quit();*/
	//DriverFactory.getInstance().removeDriver();	
		driver.quit();
		waitTill(2000);
	//Thread.sleep(5000);
	}
	
	public RemoteWebDriver getDriver(){
		return this.driver;
	}

}
