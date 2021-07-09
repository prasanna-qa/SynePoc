package org.sync.qa.helpers;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int count = 0;
	int retryLimit = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (count < retryLimit) {
			count++;
			return true;
		}
		return false;
	}

}
