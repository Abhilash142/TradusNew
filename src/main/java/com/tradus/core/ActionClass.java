package com.tradus.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class ActionClass {
	public static Calendar c = Calendar.getInstance();

	public static void loadUrl(WebDriver driver,String url) throws Exception {
		driver.get(url);
	}
	
	public static void click(WebDriver driver, By by) throws Exception {
		int count = 1;
		for (int i = 1; i <= 1; i++) {
			try {
				if (count > 3)
					throw new Exception();
				getWebElement(driver, by).click();
			} catch (StaleElementReferenceException e) {
				--i;
				count++;
			} catch (ElementNotVisibleException e) {
				--i;
				count++;
			} catch (WebDriverException e) {
				--i;
				count++;
			}
		}

	}
	
	public static void waitTill(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}
	public static void jSClick(WebDriver driver, By by) {
		WebElement ele = getWebElement(driver, by);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}
	public static void waitForElement(WebDriver driver, By by) {
		for (int i = 0; i <= 20; i++) {
			if (!verifyElementPresent(driver, by)) {
			//	System.out.println("Waiting for the Element: " + by);
				waitTill(1000);
			} else {
				break;
			}
		}
	}

	public static void scrollToElement(WebDriver driver, By by) throws Exception {
		WebElement elm = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);
		waitTill(500);
	}
	public static void waitTill() {
		waitTill(3000);
	}
	public static boolean verifyElementPresent(WebDriver driver, By by) {
		try {
			if (getWebElement(driver, by).isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	public static String getAttribute(WebDriver driver, By by, String attribute) {
		try {
			return getWebElement(driver, by).getAttribute(attribute).trim();
		} catch (Exception e) {
			return "";
		}
	}
	public static List<WebElement> getWebElements(WebDriver driver, By by) {
		List<WebElement> lis = driver.findElements(by);
		return lis;
	}
	public static WebElement getWebElement(WebDriver driver, By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	public static String getTodayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		String todayDate = sdf.format(c.getTime());
		return todayDate;
	}
	public static String getText(WebDriver driver, By by) {
		try {
			return getWebElement(driver, by).getText().trim();
		} catch (Exception e) {
			return "";
		}
	}

}
