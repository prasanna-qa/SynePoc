package org.sync.qa.actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sync.qa.base.TestBase;

public class WebAction extends TestBase {
	 WebDriver driver;

	public WebAction(WebDriver driver) throws IOException {
		super();
		this.driver=driver;
	}

	public void sendkeys(WebElement element, String keys) {
		try {
			element.sendKeys(keys);
		} catch (WebDriverException e) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement element) {
		try {
			element.click();
		} catch (WebDriverException e) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String getText(WebElement element) {
		String text = "";
		try {
			text = element.getText();
		} catch (WebDriverException e) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			text= wait.until(ExpectedConditions.visibilityOf(element)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		} 
       return text;
	}

	public boolean isDisplayed(WebElement element) {
		boolean elementDiplayed = false;
		try {
			element.isDisplayed();
		} catch (WebDriverException e) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementDiplayed;
	}
}
