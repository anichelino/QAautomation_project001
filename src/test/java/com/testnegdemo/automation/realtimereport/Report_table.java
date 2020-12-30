package com.testnegdemo.automation.realtimereport;

import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class Report_table {

	Table FailTable;
	Document document;
	GetReportDocument document_to_take = new GetReportDocument();
	Cell cell;
	Image image;
	ImageData data;
	String file;
	float[] pointColumnWidths = { 20F, 20F };

	public void Add_Report_voice(String file) {
		try {
			FailTable = new Table(pointColumnWidths);
			data = ImageDataFactory.create(file);
			image = new Image(data);
			cell = new Cell();
			cell.add(image.scaleToFit(500F, 400F));
			FailTable.addCell(cell);
			document.add(FailTable);
			document.add(new Paragraph("\n"));
			document.close();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}
}