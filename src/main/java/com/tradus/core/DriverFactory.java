package com.tradus.core;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
private DriverFactory(){
		
	}
	private static DriverFactory driverInstance = new DriverFactory();
	
	public static DriverFactory getInstance(){
		return driverInstance;
	}

	ThreadLocal<RemoteWebDriver> driver_local = new ThreadLocal<RemoteWebDriver>();
	
	public RemoteWebDriver getDriver(){
		return driver_local.get();
	}
	
	public void setDriver(RemoteWebDriver driver){
		driver_local.set(driver);
	}
	public void removeDriver(){
		/*if (driver_local.get() != null) {
			driver_local.get().close();
			driver_local.get().quit();
			driver_local.remove();
		}*/
		driver_local.get().quit();
		driver_local.remove();
	}
}
