package org.sync.qa.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sync.qa.actions.WebAction;
import org.sync.qa.base.TestBase;
import org.sync.qa.helpers.EncodeDecode;
import org.sync.qa.helpers.RetryAnalyser;
import org.sync.qa.listeners.TestListener;
import org.sync.qa.pages.DashboardPage;
import org.sync.qa.pages.ForgotPasswordPage;
import org.sync.qa.pages.LandingPage;
import org.sync.qa.pages.LoginPage;
import org.sync.qa.reports.ExtentLogger;//
//import org.sync.qa.reports.ExtentManager;
//import org.sync.qa.reports.ExtentReport;
import org.sync.qa.utilities.CredentialJsonReader;
import org.sync.qa.utilities.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginPageTest extends TestBase {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ForgotPasswordPage forgotPasswordPage;
	private LandingPage landingPage;
	public WebDriver driver;
	public WebAction action;
	
	

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		Log.info("Setting up the predondition");
		driver = initialization();
		Log.info("Instantiating page classes");
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
		landingPage = new LandingPage(driver);
		action=new WebAction(driver);
		CredentialJsonReader.setRoot();
	}

	@Test(priority = 0, enabled = true, description = "Validating login page logo")
	public void verifyLoginPageLogo() {
		/*
		 * ExtentManager.getExtentTest().assignAuthor("Prasanna").assignAuthor("Preet").
		 * assignCategory("Smoke").assignDevice("chrome");
		 * //ExtentLogger.info("Clicking on login link");
		 */
		Log.info("Clicking on login link");
		action.click(landingPage.loginLink);
		//ExtentLogger.info("Checking presence of login logo");
		Log.info("Checking presence of login logo");
		boolean logoVisiblity = action.isDisplayed(loginPage.logo);
		Assert.assertEquals(logoVisiblity, true);
		//ExtentLogger.info("Validated login page logo");
		Log.info("Validated login page logo");

	}

	@Test(priority = 1, enabled = true, description = "Validating login with valid credentials")
	public void verifyValidLogin() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * ExtentManager.getExtentTest().assignAuthor("Srinath").assignAuthor("Hemanth")
		 * .assignCategory("Smoke").assignDevice("chrome");
		 * //ExtentLogger.info("Clicking on login link");
		 */
		Log.info("Clicking on login link");
		action.click(landingPage.loginLink);
		Log.info("Entering username and password");
		//ExtentLogger.info("Entering username and password");
		action.sendkeys(loginPage.username,CredentialJsonReader.getRoot().getCrdentials().getIt().getUsername());
		action.sendkeys(loginPage.password,EncodeDecode.decodePasswrod(CredentialJsonReader.getRoot().getCrdentials().getIt().getPassword()));
		action.click(loginPage.loginButton);
		boolean dashboardName = action.isDisplayed(dashboardPage.currentUser);
		if (!dashboardName) {
			Log.error("Login is failing");
			//ExtentLogger.info("Login is failing");
		}
		Assert.assertEquals(true, dashboardName);
		Log.info("validated login");
		//ExtentLogger.info("validated login");
	}

	@Test(priority = 2, enabled = true, description = "Validating login with invalid credentials")
	public void verifyInvalidLogin() {
		/*
		 * ExtentManager.getExtentTest().assignAuthor("Prasanna").assignCategory("Smoke"
		 * ).assignDevice("chrome"); //ExtentLogger.info("Clicking on login link");
		 */
		//ExtentLogger.info("Entering invalid username and password");
		action.click(landingPage.loginLink);
		action.sendkeys(loginPage.username,"username");
		action.sendkeys(loginPage.password,"password");
		action.click(loginPage.loginButton);
		String invalidCredsText = action.getText(loginPage.invalidCredentialError);
		Assert.assertEquals(invalidCredsText, "Your email or password is incorrect.");
		Log.info("validated invadlid credentials error message");
		
	}

	@Test(priority = 3, enabled = true, description = "Validating navigation of forgot password link")
	public void verifyForgotPasswordLink() throws InterruptedException {
		/*
		 * ExtentManager.getExtentTest().assignAuthor("Srinath").assignAuthor("Hemanth")
		 * .assignCategory("Smoke").assignDevice("chrome");
		 * Log.info("Clicking on login link");
		 */
		//ExtentLogger.info("Clicking on login link");
		action.click(landingPage.loginLink);;
		//ExtentLogger.info("Clicking on forgot password link");
		Log.info("Clicking on forgot password link");
		action.click(loginPage.forgotPasswordLink);
		String forgotpasswordPageTitle = action.getText(forgotPasswordPage.forgotPasswordPageTitle);
		Assert.assertEquals(forgotpasswordPageTitle, true);
		Log.info("validated forgot password link navigation");
		//ExtentLogger.info("validated forgot password link navigation");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		Log.info("Quiting the browser window after each test");
		//ExtentLogger.info("Quiting the browser window");
	}

}
