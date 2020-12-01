package com.testngdemo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pagina_demo extends Page {

	public pagina_demo(WebDriver driver_received) {
		super(driver_received);
	}

	@FindBy(name = "uid")
	WebElement inputgoogle;

	public void sendInput(String strInput) {

		inputgoogle.sendKeys(strInput);
	}
}
