package com.testngdemo.automation.functional;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testnegdemo.automation.realtimereport.TimeReport;
import com.testngdemo.automation.pages.pagina_demo;

@Listeners(TimeReport.class)

public class Testsuite_1st_research_google extends TestSuitesBases {
	// WebDriver driver;
	// String driverPath =
	// "C:\\Users\\F92613C\\workspace\\prova1\\drivers\\geckodriver.exe";
	pagina_demo research_page_obj;

	@BeforeTest

	public void setup() {

		// System.setProperty("webdriver.gecko.driver", driverPath);

		driver = TestSuitesBases.getDriver();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/V4/");
	}

	@Test
	public void Research_a_word_on_guru() {

		System.out.println("inserting the element");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		research_page_obj = new pagina_demo(driver);
		research_page_obj.sendInput("ciao sono io ora modifico da eclipse per la terza volta");
	}

	@Test

	public void testPDFReporTwo() {

		// driver = TestSuitesBases.getDriver();

		// driver.get("http:/guru99.com");

		Assert.assertTrue(false);

	}

}
