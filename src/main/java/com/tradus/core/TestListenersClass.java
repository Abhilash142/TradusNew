package com.tradus.core;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import static com.tradus.core.ActionElementClass.path;
import static com.tradus.core.ActionElementClass.getTodayDate;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class TestListenersClass implements ITestListener {

	static Logger log = LogManager.getLogger(TestListenersClass.class.getName());

	public void onStart(ITestContext context) {
/*		System.out.println("==================onstart============================");
		System.out.println("onStart ==== " + context);*/
		log.info("==================onstart============================");
		log.info("onStart ==== " + context);
	}

	public void onFinish(ITestContext context) {
		Iterator<ITestResult> skippedTestCases = context.getSkippedTests().getAllResults().iterator();
        while (skippedTestCases.hasNext()) {
            ITestResult skippedTestCase = skippedTestCases.next();
            ITestNGMethod method = skippedTestCase.getMethod();
            if (context.getSkippedTests().getResults(method).size() > 0) {
                System.out.println("Removing:" + skippedTestCase.getTestClass().toString());
                skippedTestCases.remove();
            }
        }
		log.info("onFinish====" + context);
		log.info("==================onFinish============================");
	}

	public void onTestStart(ITestResult result) {
		//System.out.println(result.getName() + " test case started");
		log.info(result.getName() + " TEST CASE STARTED");
		//log.info(Thread.currentThread().getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("The name of the TEST CASE PASSED is :" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		Object obj = result.getInstance();
		RemoteWebDriver driver = ((BaseClass) obj).getDriver();
		log.info("The name of the TEST CASE Failed is :" + result.getName());
		String site = System.getProperty("site");
		String failureReason = result.getThrowable().toString();
		failureReason = failureReason.replace("java.lang.AssertionError:", "")
				.replace("expected [true] but found [false]", "").trim();
		log.error(failureReason);
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File(path + "\\Reports\\" + site + "\\" + getTodayDate() + "\\" + result.getName());
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			log.info("File not found to store failed test cases....");
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		log.info(" Testcase Skipped is :" + result.getName());
		String failureReason = result.getThrowable().toString();
		log.error(failureReason);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
