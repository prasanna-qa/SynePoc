package org.sync.qa.testcases;

import java.io.IOException;

import org.sync.qa.actions.WebAction;
import org.sync.qa.base.TestBase;
import org.sync.qa.pages.HRMSHomePage;
import org.sync.qa.pages.LandingPage;
import org.sync.qa.pages.LoginPage;
import org.sync.qa.pages.RegisterPage;
import org.sync.qa.reports.ExtentLogger;
import org.sync.qa.utilities.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRMSHomePageTest extends TestBase{
	WebAction action;
	

	public HRMSHomePageTest() throws IOException {
		super();
			}
	
	@BeforeMethod
	public void setUp() throws IOException {
		Log.info("Setting up the predondition");
		driver = initialization();
		Log.info("Instantiating page classes");
		action=new WebAction(driver);
	}
	
	
	@Test
	public void checkHomePage() {
		boolean a=action.isDisplayed(HRMSHomePage.profile);
		Assert.assertEquals(a, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Log.info("Quiting the browser window after each test");
		ExtentLogger.info("Quiting the browser window");
	}
	
	
	

}
