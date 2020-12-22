package com.testnegdemo.automation.realtimereport;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.testngdemo.automation.functional.TestSuitesBases;

public class TimeReport implements ITestListener {

	PdfPTable FailTable;
	Document document = new Document();
	final String pdfName = System.getProperty("user.dir") + "//Pdferror.pdf";
	File fileScreenshot;
	Image image;

	public void onFinish(ITestContext arg0) {
		System.out.println("END Of Execution(TEST)->" + arg0.getName());
	}

	public void onStart(ITestContext arg0) {

		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {

		String file = System.getProperty("user.dir") + "//" + "Screenshoot" + (new Random().nextInt()) + ".png";
		try {
			fileScreenshot = TestSuitesBases.takeSnapShot(TestSuitesBases.getDriver(), file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test Failed->" + arg0.getName());

		this.FailTable = new PdfPTable(new float[] { .10f, .3f, .1f, .3f });
		this.FailTable.setTotalWidth(40f);
		Paragraph p = new Paragraph("Failed Tests",
				new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)));
		p.setAlignment(Element.ALIGN_CENTER);

		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setBackgroundColor(BaseColor.RED);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		this.FailTable.addCell(cell);
		Paragraph screen = new Paragraph("Schreenshoot", new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		screen.setAlignment(Element.ALIGN_CENTER);

		PdfPCell cell2 = new PdfPCell(screen);
		cell2.setColspan(4);
		cell2.setBackgroundColor(BaseColor.YELLOW);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		this.FailTable.addCell(cell2);

		PdfPCell cell3 = new PdfPCell(image);
		this.FailTable.addCell(cell3);

		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfName));
			document.open();
			document.add(FailTable);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
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
