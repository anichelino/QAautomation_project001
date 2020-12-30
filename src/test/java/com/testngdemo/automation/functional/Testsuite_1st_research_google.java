package com.testngdemo.automation.functional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.testnegdemo.automation.realtimereport.Report_table;
import com.testnegdemo.automation.realtimereport.TimeReport;
import com.testngdemo.automation.pages.pagina_demo;

@Listeners(TimeReport.class)

public class Testsuite_1st_research_google extends TestSuitesBases {
	// WebDriver driver;
	// String driverPath =
	// "C:\\Users\\F92613C\\workspace\\prova1\\drivers\\geckodriver.exe";
	pagina_demo research_page_obj;
	Document document;

	public void report_document_ini() throws FileNotFoundException {
		String pdfName = System.getProperty("user.dir") + "//Pdferror.pdf";
		PdfWriter writer = new PdfWriter(pdfName);
		PdfDocument pdfDoc = new PdfDocument(writer);
		this.document = new Document(pdfDoc);
	}

	public Document getDocument() {
		return this.document;
	}

	String file;
	File fileScreenshot;
	Report_table report_table = new Report_table();

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
		research_page_obj.sendInput("ciao mi presento");

		Assert.assertTrue(false);
	}

	@Test

	public void testPDFReporTwo() {

		driver = TestSuitesBases.getDriver();

		driver.get("http://demo.guru99.com/V4/");

		Assert.assertTrue(false);

	}

	@Test

	public void testPDFReporThree() {

		driver = TestSuitesBases.getDriver();

		driver.get("http:/www.guru99.com");

		Assert.assertTrue(false);

	}

}
