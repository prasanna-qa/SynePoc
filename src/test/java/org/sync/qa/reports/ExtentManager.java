package org.sync.qa.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public  static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static void unload() {
		extentTest.remove();
	}
	

}
