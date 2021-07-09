package org.sync.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(xpath = "//span[@class='navbar-current-user']")
	public WebElement currentUser;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
 