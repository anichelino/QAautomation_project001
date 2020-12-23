package com.testnegdemo.automation.realtimereport;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.testngdemo.automation.functional.TestSuitesBases;

public class TimeReport implements ITestListener {

	Table FailTable;
	Document document;

	public void onFinish(ITestContext arg0) {
		System.out.println("END Of Execution(TEST)->" + arg0.getName());
	}

	public void onStart(ITestContext arg0) {

		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		String pdfName = System.getProperty("user.dir") + "//Pdferror.pdf";
		PdfWriter writer;

		String file = System.getProperty("user.dir") + "//" + "Screenshoot" + (new Random().nextInt()) + ".png";
		File fileScreenshot;
		try {
			fileScreenshot = TestSuitesBases.takeSnapShot(TestSuitesBases.getDriver(), file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test Failed->" + arg0.getName());

		float[] pointColumnWidths = { 20F, 20F };
		this.FailTable = new Table(pointColumnWidths);

		try {
			ImageData data = ImageDataFactory.create(file);
			Image image = new Image(data);
			Cell cell3 = new Cell();
			cell3.add(image.setAutoScale(true));
			this.FailTable.addCell(cell3);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		try {
			writer = new PdfWriter(pdfName);
			PdfDocument pdfDoc = new PdfDocument(writer);
			Document document = new Document(pdfDoc);
			document.add(FailTable);
			document.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped->" + arg0.getName());
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started->" + arg0.getName());

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Pass->" + arg0.getName());

	}

}
