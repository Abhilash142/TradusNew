package com.tradus.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionElementClass {
	static String path = System.getProperty("user.dir");
	public static Calendar c = Calendar.getInstance();
	
	public static void loadUrl(RemoteWebDriver driver, String url) throws Exception {
		driver.get(url);
	}

	public static void click(WebElement ele) throws Exception {
		ele.click();
	}

	public static void jsClick(RemoteWebDriver driver, WebElement ele) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

	public static void sendKeys(WebElement ele, String text) { 
		ele.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
		try{
		Thread.sleep(3000);
		}catch(Exception e){
			
		}
		ele.sendKeys(text);
	}

	public static String getText(WebElement ele) throws Exception {
		return ele.getText();
	}

	public static String getAttribute(WebElement ele, String val) throws Exception {
		return ele.getAttribute(val);
	}

	public static boolean verifyElementPresent(WebElement ele) {
		try {
			if (ele.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitTill(int timeInMilliSeconds) throws Exception {
		Thread.sleep(timeInMilliSeconds);
	}

	public static void waitForElement(WebElement ele) throws Exception {
		for (int i = 0; i < 10; i++) {
			try {
				if (ele.isDisplayed())
					break;
				else
					Thread.sleep(2000);
			} catch (Exception e) {
				Thread.sleep(2000);
			}
		}
	}

	public static void switchWindow(RemoteWebDriver driver, String parentWindow) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}

		}
	}

	public static void scrollToElement(RemoteWebDriver driver,WebElement ele) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	public static void explicitWaitFortheElementTobeVisible(RemoteWebDriver driver,WebElement ele) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static String getCurrentUrl(RemoteWebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public static void actionClick(RemoteWebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele).perform();
	}
	public static String getTodayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		String todayDate = sdf.format(c.getTime());
		return todayDate;
	}
	
	public static void scrollDown(RemoteWebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollUp(RemoteWebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public static int dynamicSelect(List<WebElement> dropDownValues) {
		List<WebElement> list=dropDownValues;
		Random random = new Random();
		int randomInt = random.nextInt(list.size());
		return randomInt;
	}
	
	public static void actionClick1(RemoteWebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click(ele).build().perform();
	}
	
	public static String generateRandomNumber(int low, int high)
	{
		Random r = new Random();
		int result = r.nextInt(high-low) + low;
		return(String.valueOf(result));
	}
	
	public static String getValue(RemoteWebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String text = (String) js.executeScript("return arguments[0].value", ele);
		return text;
	}
	public static void moveToElement(RemoteWebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
}

