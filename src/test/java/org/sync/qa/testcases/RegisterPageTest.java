package org.sync.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sync.qa.actions.WebAction;
import org.sync.qa.base.TestBase;
import org.sync.qa.pages.DashboardPage;
import org.sync.qa.pages.ForgotPasswordPage;
import org.sync.qa.pages.LandingPage;
import org.sync.qa.pages.LoginPage;
import org.sync.qa.pages.RegisterPage;
import org.sync.qa.reports.ExtentLogger;
import org.sync.qa.reports.ExtentManager;
import org.sync.qa.utilities.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
	private DashboardPage dashboardPage;
	private LandingPage landingPage;
	private RegisterPage registerPage;
	public WebDriver driver;
	public WebAction action;

	public RegisterPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		Log.info("Setting up the predondition");
		driver = initialization();
		Log.info("Instantiating page classes");
		dashboardPage = new DashboardPage(driver);
		landingPage = new LandingPage(driver);
		registerPage = new RegisterPage(driver);
		action = new WebAction(driver);
		ExtentLogger.info("Clicking on Register link");
		action.click(landingPage.registerLink);
	}

	@Test(priority = 0, enabled = true, description = "Verifying presence of logo")
	public void verifyRegisterPageLogo() {
		ExtentManager.getExtentTest().assignAuthor("Preet").assignAuthor("Hemanth").assignCategory("Smoke").assignDevice("chrome");
		ExtentLogger.info("Checking the presence of regiter page logo");
		boolean logoVisiblity = action.isDisplayed(registerPage.logo);
		Assert.assertEquals(logoVisiblity, true);
	}

	@Test(priority = 1, enabled = true, description = "validating title")
	public void verifyTitle() {
		ExtentManager.getExtentTest().assignAuthor("Srinath").assignAuthor("Hemanth").assignCategory("Smoke").assignDevice("chrome");
		ExtentLogger.info("Getting Register Page Title");
		String title = action.getText(registerPage.title);
		Assert.assertEquals(title, "Sign Up to Rahul Shetty Academy");
		Log.info("Validated title");
	}

	@Test(dataProvider = "getData", priority = 2, enabled = true, description = "Verifying sing up function with different data")
	public void verifySignUp(String name, String email, String password, String confirmPasswrd) {
		ExtentManager.getExtentTest().assignAuthor("Prasanna").assignAuthor("Preet").assignCategory("Smoke").assignDevice("chrome");
		ExtentLogger.info("Filling the register form");
		ExtentLogger.info("Entering keys to name field");
		action.sendkeys(registerPage.fullName, name);
		ExtentLogger.info("Entering keys to email field");
		action.sendkeys(registerPage.emailAddress, email);
		ExtentLogger.info("Entering keys to password field");
		action.sendkeys(registerPage.password, password);
		ExtentLogger.info("Entering keys to confirm Passwrd field");
		action.sendkeys(registerPage.confirmPassword, confirmPasswrd);
		ExtentLogger.info("Clicking on instruction check box");
		action.click(registerPage.agreeInstruction);
		action.click(registerPage.agreeTermsCondition);
		ExtentLogger.info("Clicking on sign up button");
		action.click(registerPage.signUp);
		boolean dashboardName = action.isDisplayed(dashboardPage.currentUser);
		Assert.assertEquals(dashboardName, true);
		Log.info("Validated sign up");
		ExtentLogger.info("Validated sign up");
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		Object obj[][] = { { "prasanna", "efgh@gmail.com", "sdsdsadsds", "sdsdsadsds" },
				{ "kumar", "abcd@gmail.com", "dkjkjasd", "dkjkjasd" } };
		return obj;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		Log.info("Quiting the browser window after each test");
		ExtentLogger.info("Quiting the browser window");
	}

}