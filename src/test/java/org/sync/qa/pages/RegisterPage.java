package org.sync.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sync.qa.utilities.Log;

public class RegisterPage {

	@FindBy(xpath = "//a[contains(@class,'header-logo')]")
	public WebElement logo;

	@FindBy(xpath = "//div[contains(@class,'content-box')]/h1")
	public WebElement title;

	@FindBy(xpath = "//input[@id='user_name']")
	public WebElement fullName;

	@FindBy(xpath = "//input[@id='user_email']")
	public WebElement emailAddress;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='user_password_confirmation']")
	public WebElement confirmPassword;

	@FindBy(xpath = "//input[contains(@id,'user_unsubscribe_from')]")
	public WebElement agreeInstruction;

	@FindBy(xpath = "//input[@id='user_agreed_to_terms']")
	public WebElement agreeTermsCondition;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement signUp;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}