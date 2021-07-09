package org.sync.qa.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	private WebDriver driver;

	public static String getScreenShot(WebDriver driver, String fileName) throws IOException {
		File fileInSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileToDestination = System.getProperty("user.dir") + "\\failedScreenshots\\" + fileName + ".png";
		FileUtils.copyFile(fileInSource, new File(fileToDestination));
		return fileToDestination; 
	}

}
