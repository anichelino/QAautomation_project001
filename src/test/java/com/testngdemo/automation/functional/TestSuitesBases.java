package com.testngdemo.automation.functional;

import java.awt.Image;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testnegdemo.automation.singletests.TestAsSeparated;

public class TestSuitesBases {

	protected static Logger loggerTest = LogManager.getLogger(TestAsSeparated.class);

	protected String baseUrl = "https://www.google.com";

	public Image image;
	public File DestFile;

	static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {
			String driverlocator = System.getProperty("user.dir") + "\\drivers" + "\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverlocator);
			driver = new FirefoxDriver();

		}

		return driver;

	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 */

	public static File takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

		return DestFile;
	}

}
