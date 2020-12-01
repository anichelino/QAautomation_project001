package com.testngdemo.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger("Page");

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("page initiated");

	}
}