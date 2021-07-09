package org.sync.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sync.qa.listeners.TestListener;
import org.sync.qa.utilities.Log;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	
	public TestBase() throws IOException {
		Log.info("Loading the properties File");
		FileInputStream propertiesPath = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\org\\sync\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(propertiesPath);
		Log.info("Reading the properties File");
	}
	
	

	public static WebDriver getDriver() {
		return webDriver.get();
	}



	public static void setDriver(WebDriver driverr) {
		webDriver.set(driverr);
	}
public WebDriver initialization() {
	initDriver();
	driver=getDriver();
	Log.info("Reading and hitting the base url");
	driver.get(prop.getProperty("url"));
	Log.info("Maximizing browser window");
	driver.manage().window().maximize();
	Log.info("Deleting cookies");
	driver.manage().deleteAllCookies();
	Log.info("Settting implicit wait");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}
	public void initDriver() {
		Log.info("Checking for browser option");
		switch (prop.getProperty("browser")) {
		case "chrome":
			Log.info("Launching Chrome Browser");
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			Log.error("Required Browser driver not available");
			driver = null;
		}
			setDriver(driver);
			}

}
