package com.testngdemo.automation.functional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testngdemo.automation.pages.pagina_demo;

public class Testsuite_1st_research_google extends TestSuitesBases {
	WebDriver driver;
	String driverPath = "C:\\Users\\F92613C\\workspace\\prova1\\drivers\\geckodriver.exe";
	pagina_demo research_page_obj;

	@BeforeTest

	public void setup() {

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/V4/");
	}

	@Test
	public void Research_a_word_on_google() {

		System.out.println("inserting the element");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		research_page_obj = new pagina_demo(driver);
		research_page_obj.sendInput("ciao");
	}

}
