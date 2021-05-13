package com.tradus.core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {
	int retryCount =0;
	int max_retryCount =3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount < max_retryCount){
			System.out.println("Retrying test "+result.getName()+" with status "+getResultStatusName(result.getStatus())+"for the "+(retryCount++)+" time");
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status){
		String statusName = null;
		if(status==1)
			statusName = "success";
		else if (status==2)
			statusName = "Failure";
		else if (status==3)
			statusName = "skipped";
		return statusName;
	}

}
