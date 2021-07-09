package org.sync.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//a[contains(@class,'header-logo')]")
	public WebElement logo;

	@FindBy(xpath = "//h1[@class='text-center']")
	public WebElement title;

	@FindBy(xpath = "//input[@id='user_email']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public WebElement invalidCredentialError;

	@FindBy(xpath = "//a[@class='link-below-button']")
	public WebElement forgotPasswordLink;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
