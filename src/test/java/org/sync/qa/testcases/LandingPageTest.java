package org.sync.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.sync.qa.actions.WebAction;
import org.sync.qa.base.TestBase;
import org.sync.qa.pages.LandingPage;
import org.sync.qa.pages.LoginPage;
import org.sync.qa.pages.RegisterPage;
import org.sync.qa.reports.ExtentLogger;
import org.sync.qa.reports.ExtentManager;
import org.sync.qa.utilities.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LandingPageTest extends TestBase {
	private LandingPage landingPage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	public WebDriver driver;
	public WebAction action;
	
	public LandingPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		Log.info("Setting up the predondition");
		driver = initialization();
		Log.info("Instantiating page classes");
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
		action=new WebAction(driver);
	}

	@Test(priority = 1, enabled = true, description="validating presence of primary links")
	public void verifyPrimaryLinksExistence() {
		ExtentManager.getExtentTest().assignAuthor("Prasanna").assignAuthor("Hemanth").assignCategory("Smoke").assignDevice(prop.getProperty("browser"));
		ExtentLogger.info("Verifying presence of Contact ID");
		Log.info("Verifying presence of Contact ID");
		Assert.assertEquals(landingPage.contactID, true);
		ExtentLogger.info("Verifying presence of Login link");
		Log.info("Verifying presence of Login link");
		Assert.assertEquals(landingPage.loginLink, true);
		Log.info("Verifying presence of LOGO");
		ExtentLogger.info("Verifying presence of LOGO");
		Assert.assertEquals(landingPage.logo, true);
		Log.info("Verifying presence of Register link");
		ExtentLogger.info("Verifying presence of Register link");
		Assert.assertEquals(landingPage.registerLink, true);
		Log.info("Validated presence of primary links");
		ExtentLogger.info("Validated presence of primary links");
	}

	@Test(priority = 0, enabled = true, description="Validating navigation of register link")
	public void verifyRegisterLink() {
		ExtentManager.getExtentTest().assignAuthor("Srinath").assignAuthor("Hemanth").assignCategory("Smoke").assignDevice("chrome");
		ExtentLogger.info("Clicking on register link");
		action.click(landingPage.registerLink);
		Assert.assertEquals(action.getText(registerPage.title), "Sign Up to Rahul Shetty Academy");
		Log.info("Validated navigation of register link");

	}

	@Test(priority = 2, enabled = true, description="Validating navigation of Login link")
	public void verifyLoginLink() {
		ExtentManager.getExtentTest().assignAuthor("Preet").assignAuthor("Prasanna").assignCategory("Smoke").assignDevice("chrome");
		ExtentLogger.info("Clicking on login link");
		action.click(landingPage.loginLink);
		Assert.assertEquals(action.getText(loginPage.title), "Log in to Rahul Shetty Academy");
		Log.info("Validated navigation of Login link");
		ExtentLogger.info("Validated navigation of Login link");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		ExtentLogger.info("Quiting the browser window");
		Log.info("Quiting the browser window after each test");
	}

}
