package org.sync.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sync.qa.utilities.Log;

public class LandingPage {

	@FindBy(xpath = "//div[contains(@class,'logo')]")
	public WebElement logo;

	@FindBy(xpath = "//*[@class='login-btn'][1]")
	public WebElement registerLink;

	@FindBy(xpath = "//*[@class='login-btn'][2]")
	public WebElement loginLink;

	@FindBy(xpath = "//*[@class='top-left']")
	public WebElement contactID;

	@FindBy(xpath = "//span[@class='fa fa-youtube']")
	public WebElement youtubeLink;

	@FindBy(xpath = "//span[@class='fa fa-linkedin']")
	public WebElement linkedInLink;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
