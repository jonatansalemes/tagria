
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Column;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Row;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class PdfExporter implements Exporter {

    private PdfPCell createCell(String content, String align) {
	return createCell(content, align, null);
    }

    private PdfPCell createCell(String content, String align, Integer colspan) {
	Font font = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.BOLD);
	PdfPCell pdfPCell = new PdfPCell(new Phrase(content, font));
	pdfPCell.setHorizontalAlignment(align(align));
	if (colspan != null) {
	    pdfPCell.setColspan(colspan);
	}
	return pdfPCell;
    }

    private Integer align(String align) {
	if ("center".equals(align)) {
	    return Element.ALIGN_CENTER;
	} else if ("left".equals(align)) {
	    return Element.ALIGN_LEFT;
	} else if ("right".equals(align)) {
	    return Element.ALIGN_RIGHT;
	} else {
	    return Element.ALIGN_CENTER;
	}
    }

    @Override
    public byte[] export(Table table) {
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    Document document = new Document();
	    PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);
	    document.open();
	    document.add(pdfTable(table));
	    document.close();
	    pdfWriter.close();
	    return byteArrayOutputStream.toByteArray();
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    private PdfPTable pdfTable(Table table) {
	Integer numColumns = table.getHeaders().size();
	PdfPTable pdfPTable = new PdfPTable(numColumns);
	pdfPTable.setWidthPercentage(100);
	pdfPTable.addCell(createCell(table.getTitle(), "center", numColumns));
	for (Header header : table.getHeaders()) {
	    pdfPTable.addCell(createCell(header.getContent(), header.getAlign()));
	}
	for (Row row : table.getRows()) {
	    for (Column column : row.getColumns()) {
		pdfPTable.addCell(createCell(column.getContent(), column.getAlign()));
	    }
	}
	return pdfPTable;
    }

    @Override
    public String contentType() {
	return "application/pdf";
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "pdf".equals(mediaType);
    }

}
