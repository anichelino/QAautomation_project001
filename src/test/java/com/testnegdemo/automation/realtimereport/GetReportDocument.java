package com.testnegdemo.automation.realtimereport;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class GetReportDocument {

	static WebDriver driver;
	static String pdfName = System.getProperty("user.dir") + "//Pdferror.pdf";
	static PdfWriter writer;

	public Document GetDocument() throws FileNotFoundException {
		writer = new PdfWriter(pdfName);
		PdfDocument pdfDoc = new PdfDocument(writer);
		Document document = new Document(pdfDoc);
		return document;
	}
}
