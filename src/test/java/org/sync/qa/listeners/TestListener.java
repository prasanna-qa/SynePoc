package org.sync.qa.listeners;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sync.qa.reports.ExtentLogger;
import org.sync.qa.reports.ExtentManager;
import org.sync.qa.reports.ExtentReport;
import org.sync.qa.utilities.Log;
import org.sync.qa.utilities.TakeScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	WebDriver driver;

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {

		//ExtentLogger.pass("Testcase " + result.getMethod().getMethodName() + " has passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		String path = null;
	//	ExtentLogger.fail("Testcase " + result.getMethod().getMethodName() + " has failed");
	//	ExtentManager.getExtentTest().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = result.getMethod().getMethodName();
		try {
			path = TakeScreenshot.getScreenShot(driver, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//ExtentManager.getExtentTest().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		// ExtentManager.getExtentTest().fail(fileName,
		// MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image(driver)).build());
	}

	public String getBase64Image(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		//ExtentLogger.skip("Testcase " + result.getMethod().getMethodName() + " has skipped");
		//ExtentManager.getExtentTest().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		Log.info("Test Suite Started");
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		Log.info("Test Suite Ended");
		ExtentReport.flush();
			}

}
