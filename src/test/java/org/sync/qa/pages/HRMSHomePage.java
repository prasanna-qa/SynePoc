package org.sync.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRMSHomePage {
	
	
	@FindBy(xpath="//ul[@id='ctl00_BodyplaceHolder_ulTab']/li[1]")
	public static WebElement profile;
	

}
